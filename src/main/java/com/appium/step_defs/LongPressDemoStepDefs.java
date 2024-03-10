package com.appium.step_defs;

import com.appium.core.app.AndroidDriverManager;
import com.appium.vodqa.page_object.pages.LongPressDemoPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LongPressDemoStepDefs {

    private final LongPressDemoPage longPressDemoPage = new LongPressDemoPage(AndroidDriverManager.getDriver());

    @Then("I check Long Press Demo Page is displayed")
    public void checkDoubleTapDemoPageDisplayed() {
        Assert.assertTrue(longPressDemoPage.verifyOpen());
    }

    @Then("I check alert with message {string} is displayed on Long Press Demo Page")
    public void checkAlertMessageOnLongPressPageDisplayed(String message) {
        Assert.assertEquals(message, longPressDemoPage.getAlertMessage());
    }

    @When("I long tap Long Press button on Long Press Demo Page")
    public void doubleTapDoubleTapMeButtonOnDoubleTapDemoPage() {
        longPressDemoPage.longTapLongPressButton();
    }

}