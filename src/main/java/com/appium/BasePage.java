package com.appium;

import com.appium.core.app.AppGestures;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected AndroidDriver driver;

    @AndroidFindBy(id = "android:id/message")
    private WebElement alertMessage;

    public abstract boolean verifyOpen();

    public abstract void waitOpen();

    protected By getTitle(String title) {
        return AppiumBy.xpath(String.format("//android.widget.TextView[@text='%s']", title));
    }

    public String getAlertMessage() {
        return alertMessage.getText();
    }

    public void swipeUp() {
        AppGestures.swipeUp(driver);
    }
}
