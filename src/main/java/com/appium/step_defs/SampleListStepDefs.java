package com.appium.step_defs;

import com.appium.core.app.AndroidDriverManager;
import com.appium.dto.SampleDto;
import com.appium.vodqa.page_object.pages.CarouselPage;
import com.appium.vodqa.page_object.pages.DoubleTapDemoPage;
import com.appium.vodqa.page_object.pages.DragAndDropePage;
import com.appium.vodqa.page_object.pages.LongPressDemoPage;
import com.appium.vodqa.page_object.pages.NativeViewDemoPage;
import com.appium.vodqa.page_object.pages.PhotosPingAndZoomPage;
import com.appium.vodqa.page_object.pages.SampleListPage;
import com.appium.vodqa.page_object.pages.SliderPage;
import com.appium.vodqa.page_object.pages.VerticalSwipingPage;
import com.appium.vodqa.page_object.pages.WebviewPage;
import com.appium.vodqa.page_object.pages.WheelPickerDemoPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class SampleListStepDefs {

    private final AndroidDriver driver = AndroidDriverManager.getDriver();
    private final SampleListPage sampleListPage = new SampleListPage(driver);
    private final NativeViewDemoPage nativeViewDemoPage = new NativeViewDemoPage(driver);
    private final SliderPage sliderPage = new SliderPage(driver);
    private final VerticalSwipingPage verticalSwipingPage = new VerticalSwipingPage(driver);
    private final DragAndDropePage dragAndDropePage = new DragAndDropePage(driver);
    private final DoubleTapDemoPage doubleTapDemoPage = new DoubleTapDemoPage(driver);
    private final LongPressDemoPage longPressDemoPage = new LongPressDemoPage(driver);
    private final PhotosPingAndZoomPage photosPingAndZoomPage = new PhotosPingAndZoomPage(driver);
    private final WebviewPage webviewPage = new WebviewPage(driver);
    private final CarouselPage carouselPage = new CarouselPage(driver);
    private final WheelPickerDemoPage wheelPickerDemoPage = new WheelPickerDemoPage(driver);

    @Given("I go to Native View Demo Page")
    public void goToNativeViewDemoPage() {
        sampleListPage.goNativeViewDemoPage();
        nativeViewDemoPage.waitOpen();
    }

    @Given("I go to Slider Page")
    public void goToSliderPage() {
        sampleListPage.goSliderPage();
        sliderPage.waitOpen();
    }

    @Given("I go to Vertical Swiping Page")
    public void goToVerticalSwipingPage() {
        sampleListPage.goVerticalSwipingPage();
        verticalSwipingPage.waitOpen();
    }

    @Given("I go to Drag & Drop Page")
    public void goToDragAndDropPage() {
        sampleListPage.goDragAndDropPage();
        dragAndDropePage.waitOpen();
    }

    @Given("I go to Double Tap Demo Page")
    public void goToDoubleTapDemoPage() {
        sampleListPage.goDoubleTapDemoPage();
        doubleTapDemoPage.waitOpen();
    }

    @Given("I go to LongPress Demo Page")
    public void goToLongPressDemoPage() {
        sampleListPage.goToLongPressDemoPage();
        longPressDemoPage.waitOpen();
    }

    @Given("I go to Photos - Ping & Zoom Page")
    public void goToPhotosPingAndZoomPage() {
        sampleListPage.goToPhotosPingAndZoomPage();
        photosPingAndZoomPage.waitOpen();
    }

    @Given("I go to Webview Page")
    public void goToWebviewPage() {
        sampleListPage.goToWebviewPage();
        webviewPage.waitOpen();
    }

    @Given("I go to Carousel Page")
    public void goToCarouselPage() {
        sampleListPage.goToCarouselPage();
        carouselPage.waitOpen();
    }

    @Given("I go to Wheel Picker Demo Page")
    public void goToWheelPickerPage() {
        sampleListPage.goToWheelPickerPage();
        wheelPickerDemoPage.waitOpen();
    }

    @Then("I check Sample List Page is displayed")
    public void checkSampleListPageDisplayed() {
        Assert.assertTrue(sampleListPage.verifyOpen());
    }

    @When("I swipe up on Sample List Page")
    public void swipeUpOnSampleListPage() {
        sampleListPage.swipeUp();
    }

    @Then("I check content on Sample List Page as in saved json")
    public void checkContentOnSampleListPage() throws IOException {
        List<SampleDto> actualDtos = sampleListPage.getSamples();
        ObjectMapper mapper = new ObjectMapper();
        List<SampleDto> expectedDtos = mapper.readValue(new File("src/test/resources/samples.json"),
                TypeFactory.defaultInstance().constructCollectionType(List.class, SampleDto.class));
        for (SampleDto actualDto : actualDtos) {
            Assert.assertTrue(expectedDtos.contains(actualDto));
        }
    }
}
