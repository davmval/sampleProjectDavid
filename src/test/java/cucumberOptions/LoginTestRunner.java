package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", monochrome = true, tags = "@Login")
public class LoginTestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider()
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
