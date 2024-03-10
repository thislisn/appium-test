package com.appium.step_defs;

import com.appium.core.app.AndroidDriverManager;
import com.appium.vodqa.page_object.pages.CarouselPage;
import com.appium.vodqa.page_object.pages.DoubleTapDemoPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class CarouselStepDefs {

    private final CarouselPage carouselPage = new CarouselPage(AndroidDriverManager.getDriver());

    @Then("I check Carousel Page is displayed")
    public void checkCarouselPageDisplayed() {
        Assert.assertTrue(carouselPage.verifyOpen());
    }

    @When("I swipe left on Carousel Page")
    public void swipeLeftOnCarouselPage() {
        carouselPage.swipeLeft();
    }

    @Then("I check Carousel index is {string}")
    public void checkCarouselIndex(String index) {
        Assert.assertEquals(index, carouselPage.getCarouselIndex());
    }
}