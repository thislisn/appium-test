package com.appium.vodqa.page_object.pages;

import com.appium.core.app.AppWait;
import com.appium.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;

public class VerticalSwipingPage extends BasePage {

    private static final String TITLE = "Vertical swiping";

    public VerticalSwipingPage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public boolean verifyOpen() {
        return driver.findElement(getTitle(TITLE)).isDisplayed();
    }

    @Override
    public void waitOpen() {
        new AppWait().waitForElementPresent(getTitle(TITLE));
    }

    public boolean isTextBlockDisplayed(String title) {
        try {
            return driver.findElement(AppiumBy.xpath(String.format("//android.widget.TextView[@text=\" %s\"]", title))).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
