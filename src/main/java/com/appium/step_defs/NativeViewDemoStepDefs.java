package com.appium.step_defs;

import com.appium.core.app.AndroidDriverManager;
import com.appium.vodqa.page_object.pages.NativeViewDemoPage;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class NativeViewDemoStepDefs {

    private final NativeViewDemoPage nativeViewDemoPage = new NativeViewDemoPage(AndroidDriverManager.getDriver());

    @Then("I check Native View Demo Page is displayed")
    public void checkSampleListPageDisplayed() {
        Assert.assertTrue(nativeViewDemoPage.verifyOpen());
    }

    @Then("I check text block {string} on Native View Demo Page is displayed")
    public void checkTextBlockPageOnNativeViewDemoPageDisplayed(String title) {
        Assert.assertTrue(nativeViewDemoPage.isTextBlockDisplayed(title));
    }
}
