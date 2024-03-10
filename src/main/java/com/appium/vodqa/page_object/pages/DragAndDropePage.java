package com.appium.vodqa.page_object.pages;

import com.appium.core.app.AppGestures;
import com.appium.core.app.AppWait;
import com.appium.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class DragAndDropePage extends BasePage {

    private static final String TITLE = "Drag & Drop";

    public DragAndDropePage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "dragMe")
    private WebElement dragMeButton;

    @AndroidFindBy(accessibility = "dropzone")
    private WebElement dropZoneButton;

    @AndroidFindBy(accessibility = "success")
    private WebElement successTitle;

    @Override
    public boolean verifyOpen() {
        return driver.findElement(getTitle(TITLE)).isDisplayed();
    }

    @Override
    public void waitOpen() {
        new AppWait().waitForElementPresent(getTitle(TITLE));
    }

    public void dragAndDropDragMeButton(){
        AppGestures.dragAndDrop(driver, dragMeButton, dropZoneButton);
    }

    public boolean isDragAndDropSucceed(){
        try {
            return successTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
