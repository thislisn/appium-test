package com.appium.core.app;

import com.appium.enums.Direction;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppGestures {

    public static void flingElement(AndroidDriver driver, WebElement element, Direction direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction.toString().toLowerCase(),
                "speed", 500
        ));
    }

    public static void swipeUp(AndroidDriver driver) {
        Point center = getCenter(driver);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), center.x, center.y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), center.x, center.y - (center.y * 80 / 100)));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(new Pause(finger, Duration.ofMillis(1000)));
        driver.perform(singletonList(swipe));
    }

    public static void swipeLeft(AndroidDriver driver) {
        Point center = getCenter(driver);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(
                finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), center.x, center.y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(
                finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), center.x, center.y - (center.y * 80 / 100)));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(new Pause(finger, Duration.ofMillis(1000)));
        driver.perform(singletonList(swipe));
    }

    private static Point getCenter(AndroidDriver driver) {
        Dimension screenSize = driver.manage().window().getSize();
        return new Point(screenSize.width / 2, screenSize.height / 2);
    }

    private static Point getCenter(WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();
        return new Point(location.getX() + (size.getWidth() / 2), location.getY() + (size.getHeight() / 2));
    }

    public static void dragAndDrop(AndroidDriver driver, WebElement dragMe, WebElement dropTo) {
        Point source = getCenter(dragMe);
        Point target = getCenter(dropTo);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragAndDrop = new Sequence(finger, 1);
        dragAndDrop.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), source.x, source.y));
        dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragAndDrop.addAction(new Pause(finger, ofMillis(600)));
        dragAndDrop.addAction(finger.createPointerMove(ofMillis(600),
                PointerInput.Origin.viewport(),
                target.x, target.y));
        dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(singletonList(dragAndDrop));
    }

    public static void doubleTap(AndroidDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public static void longTap(AndroidDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public static void zoom(AndroidDriver driver, WebElement element) {
        Point center = getCenter(element);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), center))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200),
                        PointerInput.Origin.viewport(), center.getX() + 100,
                        center.getY() - 100))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        Sequence sequence2 = new Sequence(finger2, 1)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), center))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger2, Duration.ofMillis(200)))
                .addAction(finger2.createPointerMove(Duration.ofMillis(200),
                        PointerInput.Origin.viewport(), center.getX() - 100,
                        center.getY() + 100))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(sequence, sequence2));
    }

}
