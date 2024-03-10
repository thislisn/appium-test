package com.appium.step_defs;

import com.appium.core.app.AndroidDriverManager;
import com.appium.vodqa.page_object.pages.DoubleTapDemoPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class DoubleTapDemoStepDefs {

    private final DoubleTapDemoPage doubleTapDemoPage = new DoubleTapDemoPage(AndroidDriverManager.getDriver());

    @Then("I check Double Tap Demo Page is displayed")
    public void checkDoubleTapDemoPageDisplayed() {
        Assert.assertTrue(doubleTapDemoPage.verifyOpen());
    }

    @When("I double tap Double Tap Me button on Double Tap Demo Page")
    public void doubleTapDoubleTapMeButtonOnDoubleTapDemoPage() {
        doubleTapDemoPage.doubleTapDoubleTapButton();
    }

    @Then("I check alert with message {string} is displayed on Double Tap Demo Page")
    public void checkAlertMessageOnDoubleTapDemoPageDisplayed(String message) {
        Assert.assertEquals(message, doubleTapDemoPage.getAlertMessage());
    }
}