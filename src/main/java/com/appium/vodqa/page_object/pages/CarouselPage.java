package com.appium.vodqa.page_object.pages;

import com.appium.BasePage;
import com.appium.core.app.AppGestures;
import com.appium.core.app.AppWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CarouselPage extends BasePage {

    private static final String TITLE = "Carousel - Swipe left/right";

    public CarouselPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private WebElement scrollIndex;

    @Override
    public boolean verifyOpen() {
        return driver.findElement(getTitle(TITLE)).isDisplayed();
    }

    @Override
    public void waitOpen() {
        new AppWait().waitForElementPresent(getTitle(TITLE));
    }

    public void swipeLeft() {
        AppGestures.swipeLeft(driver);
        AppGestures.swipeLeft(driver);
    }

    public String getCarouselIndex(){
        return scrollIndex.getText();
    }

}
