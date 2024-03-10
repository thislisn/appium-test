package com.appium.vodqa.page_object.pages;

import com.appium.core.app.AppWait;
import com.appium.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private static final String TITLE = "Login";

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "login")
    private WebElement logInButton;

    @Override
    public boolean verifyOpen() {
        return driver.findElement(getTitle(TITLE)).isDisplayed();
    }

    @Override
    public void waitOpen() {
        new AppWait().waitForElementPresent(getTitle(TITLE));
    }

    public void goToSamplePage() {
        logInButton.click();
    }
}
