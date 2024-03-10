package com.appium.vodqa.page_object.pages;

import com.appium.BasePage;
import com.appium.core.app.AppGestures;
import com.appium.core.app.AppWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LongPressDemoPage extends BasePage {

    private static final String TITLE = "Long Press Demo";

    public LongPressDemoPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "longpress")
    private WebElement longPressButton;

    @Override
    public boolean verifyOpen() {
        return driver.findElement(getTitle(TITLE)).isDisplayed();
    }

    @Override
    public void waitOpen() {
        new AppWait().waitForElementPresent(getTitle(TITLE));
    }

    public void longTapLongPressButton(){
        AppGestures.longTap(driver, longPressButton);
    }

}
