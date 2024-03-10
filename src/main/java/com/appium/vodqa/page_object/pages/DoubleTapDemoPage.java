package com.appium.vodqa.page_object.pages;

import com.appium.core.app.AppGestures;
import com.appium.core.app.AppWait;
import com.appium.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DoubleTapDemoPage extends BasePage {

    private static final String TITLE = "Double Tap Demo";

    public DoubleTapDemoPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "doubleTapMe")
    private WebElement doubleTapMeButton;

    @Override
    public boolean verifyOpen() {
        return driver.findElement(getTitle(TITLE)).isDisplayed();
    }

    @Override
    public void waitOpen() {
        new AppWait().waitForElementPresent(getTitle(TITLE));
    }

    public void doubleTapDoubleTapButton(){
        AppGestures.doubleTap(driver, doubleTapMeButton);
    }

}
