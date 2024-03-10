package com.appium.step_defs;

import com.appium.core.app.AndroidDriverManager;
import com.appium.vodqa.page_object.pages.VerticalSwipingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class VerticalSwipingStepDefs {

    private final VerticalSwipingPage verticalSwipingPage = new VerticalSwipingPage(AndroidDriverManager.getDriver());

    @Then("I check Vertical Swiping Page is displayed")
    public void checkVerticalSwipingPageDisplayed() {
        Assert.assertTrue(verticalSwipingPage.verifyOpen());
    }

    @When("I swipe down on Vertical Swiping Page")
    public void swipeDownOnVerticalSwipingPage() {
        verticalSwipingPage.swipeUp();
    }

    @Then("^I check that text block \"?([^\"]*)\"? is \"?(displayed|not displayed)\"? on Vertical Swiping Page$")
    public void checkTextBlockVerticalSwipingPageDisplayed(String title, String state) {
        boolean isExpectedToBeDisplayed = "displayed".equalsIgnoreCase(state);
        Assert.assertEquals(isExpectedToBeDisplayed, verticalSwipingPage.isTextBlockDisplayed(title));
    }
}
