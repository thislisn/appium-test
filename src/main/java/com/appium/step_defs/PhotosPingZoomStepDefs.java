package com.appium.step_defs;

import com.appium.core.app.AndroidDriverManager;
import com.appium.vodqa.page_object.pages.DoubleTapDemoPage;
import com.appium.vodqa.page_object.pages.PhotosPingAndZoomPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class PhotosPingZoomStepDefs {

    private final PhotosPingAndZoomPage photosPingAndZoomPage = new PhotosPingAndZoomPage(AndroidDriverManager.getDriver());

    @Then("I check Photos - Ping & Zoom Page is displayed")
    public void checkPhotosPingAndZoomPageDisplayed() {
        Assert.assertTrue(photosPingAndZoomPage.verifyOpen());
    }

    @When("I zoom and pinch Image View on Photos - Ping & Zoom Page")
    public void zoomAndPinchImagViewOnPingAndZoomPageDisplay() {
        photosPingAndZoomPage.zoomAndPinch();
    }

}