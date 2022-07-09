package pageObjectModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static utilities.ErrorMsgs.USERNAME_EMPTY;
import static utilities.ErrorMsgs.INVALID_CREDENTIALS;


public class LoginPage {
    public static WebDriver driver;
    public LoginPage(WebDriver driver) {
        LoginPage.driver = driver;
    }

    private final By loginUsername = By.xpath("//input[@id='txtUsername']");
    private final By loginPassWord = By.xpath("//input[@id='txtPassword']");
    private final By loginButton = By.id("btnLogin");
    private final By dashboard = By.xpath("//a[@href='http://www.orangehrm.com/']");
    private final By validationMessage = By.xpath("//span[@id='spanMessage']");

    public void loggingIn(String user, String password) {
        driver.findElement(loginUsername).sendKeys(user);
        driver.findElement(loginPassWord).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String pageTitle() {
        return driver.getTitle();
    }

    public void correctLogin() {
        assert (driver.findElement(dashboard).isDisplayed());
    }

    public void assertingNotEmpty() {
        assert (driver.findElement(validationMessage).getText().equals(USERNAME_EMPTY.getText()));
    }

    public void assertingCredentials() {
        assert (driver.findElement(validationMessage).getText().equals(INVALID_CREDENTIALS.getText()));
    }

}
