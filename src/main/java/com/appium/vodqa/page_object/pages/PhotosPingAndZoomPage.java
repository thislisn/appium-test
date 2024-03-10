package com.appium.vodqa.page_object.pages;

import com.appium.BasePage;
import com.appium.core.app.AppGestures;
import com.appium.core.app.AppWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PhotosPingAndZoomPage extends BasePage {

    private static final String TITLE = "Photos - Ping & Zoom";

    public PhotosPingAndZoomPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView")
    private WebElement imageView;

    @Override
    public boolean verifyOpen() {
        return driver.findElement(getTitle(TITLE)).isDisplayed();
    }

    @Override
    public void waitOpen() {
        new AppWait().waitForElementPresent(getTitle(TITLE));
    }

    public void zoomAndPinch(){
        AppGestures.zoom(driver, imageView);
    }

}
