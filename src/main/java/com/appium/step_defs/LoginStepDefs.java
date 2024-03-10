package com.appium.step_defs;

import com.appium.core.app.AndroidDriverManager;
import com.appium.vodqa.page_object.pages.LoginPage;
import com.appium.vodqa.page_object.pages.SampleListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class LoginStepDefs {

    private final LoginPage loginPage = new LoginPage(AndroidDriverManager.getDriver());
    private final SampleListPage sampleListPage = new SampleListPage(AndroidDriverManager.getDriver());

    @Given("I open Samples List Page")
    public void login() {
        loginPage.goToSamplePage();
        sampleListPage.waitOpen();
    }

    @Then("I check Log in page is displayed")
    public void checkLogInPageDisplayed() {
        Assert.assertTrue(loginPage.verifyOpen());
    }
}
