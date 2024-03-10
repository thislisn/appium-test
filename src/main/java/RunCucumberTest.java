import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/html_report/cucumber-report/cucumber-report.html", "json:target/cucumber-report/cucumber-report.json"},
        features = {"src/test/resources/features"},
        glue = {"com.appium.step_defs"}
)
public class RunCucumberTest {

}
