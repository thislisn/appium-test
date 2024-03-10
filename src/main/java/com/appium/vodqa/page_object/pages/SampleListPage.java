package com.appium.vodqa.page_object.pages;

import com.appium.core.app.AppWait;
import com.appium.BasePage;
import com.appium.dto.SampleDto;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SampleListPage extends BasePage {

    private static final String TITLE = "Samples List";

    public SampleListPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='chainedView']")
    private WebElement nativeViewButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='slider1']")
    private WebElement sliderButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='verticalSwipe']")
    private WebElement verticalSwipingButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='dragAndDrop']")
    private WebElement dragAndDropButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='doubleTap']")
    private WebElement doubleTapButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='longPress']")
    private WebElement longPressButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='photoView']")
    private WebElement photoViewButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='webView']")
    private WebElement webViewButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='carousel']")
    private WebElement carouselButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='wheelPicker']")
    private WebElement wheelPickerButton;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"scrollView\"]/android.view.ViewGroup/android.view.ViewGroup//android.widget.TextView[1]")
    private List<WebElement> titles;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"scrollView\"]/android.view.ViewGroup/android.view.ViewGroup//android.widget.TextView[2]")
    private List<WebElement> descriptions;

    @Override
    public boolean verifyOpen() {
        return driver.findElement(getTitle(TITLE)).isDisplayed();
    }

    @Override
    public void waitOpen() {
        new AppWait().waitForElementPresent(getTitle(TITLE));
    }

    public void goNativeViewDemoPage() {
        nativeViewButton.click();
    }

    public void goSliderPage() {
        sliderButton.click();
    }

    public void goVerticalSwipingPage(){
        verticalSwipingButton.click();
    }

    public void goDragAndDropPage(){
        dragAndDropButton.click();
    }

    public void goDoubleTapDemoPage(){
        doubleTapButton.click();
    }

    public void goToLongPressDemoPage(){
        longPressButton.click();
    }

    public void goToPhotosPingAndZoomPage(){
        photoViewButton.click();
    }

    public void goToWebviewPage(){
        webViewButton.click();
    }

    public void goToCarouselPage(){
        carouselButton.click();
    }
    public void goToWheelPickerPage(){
        wheelPickerButton.click();
    }
    public List<SampleDto> getSamples(){
        List<String> titlesList  = titles.stream().map(WebElement::getText).map(String::trim).collect(Collectors.toList());
        List<String> descriptionList = descriptions.stream().map(WebElement::getText).map(String::trim).collect(Collectors.toList());
        List<SampleDto> sampleDtos = new ArrayList<>();
        for (int i = 0; i < titlesList.size(); i++) {
            sampleDtos.add(new SampleDto(titlesList.get(i), descriptionList.get(i)));
        }
        return sampleDtos;
    }
}
