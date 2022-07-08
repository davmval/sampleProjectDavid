package utilities;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ContextConfiguration {
    public WebDriver driver;
    public TestBase testBase;

    public ContextConfiguration() throws IOException {
        this.testBase = new TestBase();
        this.driver = this.testBase.WebDriverManager();
    }
}
