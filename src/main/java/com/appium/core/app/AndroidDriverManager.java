package com.appium.core.app;

import com.appium.core.exceptions.DriverException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AndroidDriverManager {

    private static final ThreadLocal<AndroidDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    private static final PropertyManager propertyManager = new PropertyManager();

    public static AndroidDriver getDriver(){
        if (null == DRIVER_THREAD_LOCAL.get()) {
            setDriver();
        }
        return DRIVER_THREAD_LOCAL.get();
    }

    public static void init(){
        if (Objects.isNull(DRIVER_THREAD_LOCAL.get()) || DRIVER_THREAD_LOCAL.get().getSessionId() == null) {
            setDriver();
        }
        log.info("init driver");
    }

    public static void quit(){
        if (null != DRIVER_THREAD_LOCAL.get()) {
            DRIVER_THREAD_LOCAL.get().quit();
        }
        DRIVER_THREAD_LOCAL.remove();
        log.info("close driver");
    }

    private static void setDriver() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 3a API 28");
        options.setApp(System.getProperty("user.dir") + "\\src\\main\\resources\\appiumChallenge.apk");
        AndroidDriver driver;
        try {
            driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new DriverException("Set driver exception",e);
        }
        DRIVER_THREAD_LOCAL.set(driver);
    }
}
