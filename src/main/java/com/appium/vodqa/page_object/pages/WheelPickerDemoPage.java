package com.appium.vodqa.page_object.pages;

import com.appium.BasePage;
import com.appium.core.app.AppWait;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WheelPickerDemoPage extends BasePage {

    private static final String TITLE = "Wheel Picker Demo";

    public WheelPickerDemoPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.Spinner")
    private WebElement pickColourButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Current Color:')]")
    private WebElement currentColour;

    @Override
    public boolean verifyOpen() {
        return driver.findElement(getTitle(TITLE)).isDisplayed();
    }

    @Override
    public void waitOpen() {
        new AppWait().waitForElementPresent(getTitle(TITLE));
    }

    private By getOptionColour(String colour){
        return AppiumBy.xpath(String.format("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"%s\"]", colour));
    }

    public void pickOptionColour(String colour){
        pickColourButton.click();
        By dropdown = AppiumBy.xpath("//android.widget.ListView");
        new AppWait().waitForElementPresent(dropdown);
        driver.findElement(getOptionColour(colour)).click();
        new AppWait().waitForElementIsNotPresent(dropdown);
    }

    public String getCurrentColour(){
        return currentColour.getText().trim();
    }

}
