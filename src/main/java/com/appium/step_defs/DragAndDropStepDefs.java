package com.appium.step_defs;

import com.appium.core.app.AndroidDriverManager;
import com.appium.vodqa.page_object.pages.DragAndDropePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class DragAndDropStepDefs {

    private final DragAndDropePage dragAndDropePage = new DragAndDropePage(AndroidDriverManager.getDriver());

    @Then("I check Drag & Drop Page is displayed")
    public void checkDragAndDropPageDisplayed() {
        Assert.assertTrue(dragAndDropePage.verifyOpen());
    }

    @When("I drag and drop Drag Me button on Drag & Drop Page")
    public void dragAndDropDragMeOnDragAndDropPageButton() {
        dragAndDropePage.dragAndDropDragMeButton();
    }

    @Then("^I check Circle dropped title is \"?(displayed|not displayed)\"?$")
    public void checkCircleDropTitleIsDisplayed(String state) {
        boolean isExpectedToBeDisplayed = "displayed".equalsIgnoreCase(state);
        Assert.assertEquals(isExpectedToBeDisplayed, dragAndDropePage.isDragAndDropSucceed());
    }
}