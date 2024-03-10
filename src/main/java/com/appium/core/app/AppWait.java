package com.appium.core.app;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static com.appium.core.app.AndroidDriverManager.getDriver;

@Slf4j
public class AppWait {

    private long pollingInterval = TimeOutConstants.DEFAULT_POLLING_TIMEOUT_500_MS;

    public void waitForElementPresent(final By element, final long... msToWait) {
        final long msToWaitLoc = msToWait.length > 0 ? msToWait[0] : TimeOutConstants.DEFAULT_TIMEOUT_20_000_MS;
        try {
            Waiter waiter = () ->
                    waitUntilExpected(webDriver -> {
                        try {
                            webDriver.findElement(element);
                            return true;
                        } catch (NoSuchElementException e) {
                            log.debug(String.format("The element '%s' isn't present on the page. Waiting...", element.toString()));
                            return false;
                        } catch (TimeoutException e) {
                            log.info(String.format("Timed out after '%d' millisec(s) waiting for: '%s'.", msToWaitLoc, element.toString()));
                            return false;
                        }
                    }, msToWaitLoc);
            changeTimeOutsAndWait(waiter, TimeOutConstants.DEFAULT_IMPLICIT_WAIT_50_MS, TimeOutConstants.DEFAULT_POLLING_TIMEOUT_10_MS);
        } catch (TimeoutException e) {
            throw new TimeoutException(String.format("The Element '%s' is not present after timeout '%d' millisec(s).", element, msToWaitLoc));
        }
    }

    public void waitForElementIsNotPresent(final By element, final long... msToWait) {
        long msToWaitLoc = msToWait.length > 0 ? msToWait[0] : TimeOutConstants.DEFAULT_TIMEOUT_20_000_MS;
        try {
            Waiter waiter = () ->
                    waitUntilExpected(webDriver -> {
                        try {
                            webDriver.findElement(element);
                            log.debug(String.format("The element '%s' is still present on the page. Waiting...", element.toString()));
                            return false;
                        } catch (NoSuchElementException e) {
                            log.info(String.format("The element '%s' has been disappeared from DOM as expected.", element.toString()));
                            return true;
                        }
                    }, msToWaitLoc);
            changeTimeOutsAndWait(waiter, TimeOutConstants.DEFAULT_IMPLICIT_WAIT_50_MS, TimeOutConstants.DEFAULT_POLLING_TIMEOUT_10_MS);
        } catch (TimeoutException e) {
            throw new TimeoutException(String.format("The Element '%s' is still present after timeout '%d' millisec(s).", element, msToWaitLoc));
        }
    }

    public <T> T waitUntilExpected(Function<WebDriver, T> function, final long... msToWait) {
        long msToWaitLoc = msToWait.length > 0 ? msToWait[0] : TimeOutConstants.DEFAULT_TIMEOUT_20_000_MS;
        WebDriverWait wait = new WebDriverWait(getDriver(),  Duration.ofSeconds(msToWaitLoc / 1000));
        wait.pollingEvery(Duration.of(pollingInterval, ChronoUnit.MILLIS));
        return wait.until(function);
    }

    public void changeTimeOutsAndWait(Waiter waiter, long implicitlyWait, long pollingInterval) {
        setImplicitlyWait(implicitlyWait);
        setPollingInterval(pollingInterval);
        waiter.applyWait();
        setImplicitlyWait();
        setPollingInterval();
    }

    public void setPollingInterval(final long... interval) {
        pollingInterval = interval.length > 0 ? interval[0] : TimeOutConstants.DEFAULT_POLLING_TIMEOUT_500_MS;
    }

    public void setImplicitlyWait(final long... msToWait) {
        final long msToWaitLoc = msToWait.length > 0 ? msToWait[0] : TimeOutConstants.DEFAULT_IMPLICIT_WAIT_3_000_MS;
        getDriver().manage().timeouts().implicitlyWait(msToWaitLoc, TimeUnit.MILLISECONDS);
    }

    private static final class TimeOutConstants {
        public static final int DEFAULT_IMPLICIT_WAIT_3_000_MS = 3_000;
        public static final int DEFAULT_IMPLICIT_WAIT_50_MS = 50;
        public static final long DEFAULT_POLLING_TIMEOUT_10_MS = 10;
        public static final long DEFAULT_POLLING_TIMEOUT_500_MS = 500;
        public static final int DEFAULT_TIMEOUT_20_000_MS = 20_000;
    }
}
