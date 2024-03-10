package com.appium.step_defs;

import com.appium.core.app.AndroidDriverManager;
import com.appium.vodqa.page_object.pages.CarouselPage;
import com.appium.vodqa.page_object.pages.WheelPickerDemoPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class WheelPickerDemoStepDefs {

    private final WheelPickerDemoPage wheelPickerDemoPage = new WheelPickerDemoPage(AndroidDriverManager.getDriver());

    @Then("I check Wheel Picker Demo Page is displayed")
    public void checkWheelPickerDemoPageDisplayed() {
        Assert.assertTrue(wheelPickerDemoPage.verifyOpen());
    }

    @When("I pick Colour {string} on Wheel Picker Demo Page")
    public void pickColourOnWheelPickerDemoPage(String colour) {
        wheelPickerDemoPage.pickOptionColour(colour);
    }

    @Then("I check current status is {string} on Wheel Picker Demo Page")
    public void checkCurrentColourStatusOnWheelPickerDemoPage(String expectedStatus) {
        Assert.assertEquals(expectedStatus, wheelPickerDemoPage.getCurrentColour());
    }
}