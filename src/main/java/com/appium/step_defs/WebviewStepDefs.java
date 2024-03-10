package com.appium.step_defs;

import com.appium.core.app.AndroidDriverManager;
import com.appium.vodqa.page_object.pages.DoubleTapDemoPage;
import com.appium.vodqa.page_object.pages.WebviewPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class WebviewStepDefs {

    private final WebviewPage webviewPage = new WebviewPage(AndroidDriverManager.getDriver());

    @Then("I check Webview Page is displayed")
    public void checkWebviewPageDisplayed() {
        Assert.assertTrue(webviewPage.verifyOpen());
    }

    @When("I open link with Webview page")
    public void openWebviewLink() {
        webviewPage.openLink();
    }

    @Then("I check {string} site is opened")
    public void openWebviewLink(String siteName) {
        Assert.assertTrue(webviewPage.isSiteDisplayed(siteName));
    }

}