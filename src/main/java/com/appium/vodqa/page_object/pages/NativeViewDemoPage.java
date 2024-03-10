package com.appium.vodqa.page_object.pages;

import com.appium.core.app.AppWait;
import com.appium.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class NativeViewDemoPage extends BasePage {

    private static final String TITLE = "Native View Demo";

    public NativeViewDemoPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='chainedView']")
    private WebElement nativeViewButton;

    @Override
    public boolean verifyOpen() {
        return driver.findElement(getTitle(TITLE)).isDisplayed();
    }

    @Override
    public void waitOpen() {
        new AppWait().waitForElementPresent(getTitle(TITLE));
    }

    public boolean isTextBlockDisplayed(String title){
        return driver.findElement(AppiumBy.xpath(String.format("//android.widget.TextView[@content-desc=\"textView\" and @text=\"%s \"]", title))).isDisplayed();
    }
}
