package com.appium.vodqa.page_object.pages;

import com.appium.BasePage;
import com.appium.core.app.AppGestures;
import com.appium.core.app.AppWait;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebviewPage extends BasePage {

    private static final String TITLE = "Webview";

    public WebviewPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Windows 1.0 site – everything there is to know about the first Windows version (krnl386.com)\"]")
    private WebElement doubleTapMeButton;

    @AndroidFindBy(xpath = "//android.widget.GridView/android.view.View[1]")
    private WebElement firstLink;

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

    private By getLink(String text){
        return AppiumBy.xpath(String.format("//android.view.View[@text=\"%s\"]", text));
    }

    public void openLink(){
        firstLink.click();
    }

    public boolean isSiteDisplayed(String siteName){
        return driver.findElement(getLink(siteName)).isDisplayed();
    }

}
