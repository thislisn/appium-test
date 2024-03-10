package com.appium.step_defs;

import com.appium.core.app.AndroidDriverManager;
import com.appium.vodqa.page_object.pages.SliderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@Slf4j
public class SliderStepDefs {

    private SliderPage sliderPage = new SliderPage(AndroidDriverManager.getDriver());

    @Then("I check Slider Page is displayed")
    public void checkSliderPageDisplayed() {
        Assert.assertTrue(sliderPage.verifyOpen());
    }

    @When("I fling Slider bar on Slider Page")
    public void flingSlideBarOnSliderPage() {
        sliderPage.flingSliderBar();
    }

    @Then("I check slide bar position is equal {double} on Slider Page")
    public void checkSliderBarPositionEqualOnSliderPage(Double position) {
        Assert.assertEquals(position, new Double(sliderPage.getSlideBarPosition()));
    }

    @Then("I check slide bar position is greater than {double} on Slider Page")
    public void checkSliderBarPositionGreaterOnSliderPage(Double position) {
        assertThat(new Double(sliderPage.getSlideBarPosition()), greaterThan(position));
    }
}
