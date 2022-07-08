package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", monochrome = true, tags = "@MyInfo")
public class MyInfoTestRunner extends AbstractTestNGCucumberTests{
    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
