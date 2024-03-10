package com.appium.vodqa.page_object.pages;

import com.appium.core.app.AppGestures;
import com.appium.core.app.AppWait;
import com.appium.enums.Direction;
import com.appium.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SliderPage extends BasePage {

    private static final String TITLE = "Slider";

    public SliderPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "slider")
    private WebElement sliderBar;

    @Override
    public boolean verifyOpen() {
        return driver.findElement(getTitle(TITLE)).isDisplayed();
    }

    @Override
    public void waitOpen() {
        new AppWait().waitForElementPresent(getTitle(TITLE));
    }

    public void flingSliderBar() {
        AppGestures.flingElement(driver, sliderBar, Direction.RIGHT);
    }

    public String getSlideBarPosition() {
        return sliderBar.getText();
    }

}
