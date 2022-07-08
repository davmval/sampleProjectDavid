package pageObjectModules;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import utilities.AssignLeave;

import java.time.Duration;

public class MyInfoPage {
    public WebDriver driver;
    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    //******Scenario: admin adds a new employee leave******
    private final By leave = By.xpath("//b[normalize-space()='Leave']");
    private final By assignLeave = By.xpath("//a[@id='menu_leave_assignLeave']");
    private final By employeeName = By.xpath("//input[@name='assignleave[txtEmployee][empName]']");
    private final By dropdownNameSelect = By.cssSelector(".ac_even.ac_over");
    private final By leaveType = By.id("assignleave_txtLeaveType");
    private final By leaveTypeDropdown = By.id("assignleave_txtLeaveType");
    private final By txtFromDate = By.xpath("//input[@id='assignleave_txtFromDate']");
    private final By fromDate = By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active");
    private final By assignButton = By.id("assignBtn");
    private final By confirmationButton = By.id("confirmOkButton");

    public void accessLeavePage() {
        driver.findElement(leave).click();
        driver.findElement(assignLeave).click();
    }
    public void inputEmployeeName(String firstName) {
        driver.findElement(employeeName).sendKeys(firstName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement element = driver.findElement(dropdownNameSelect);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    public void inputLeaveType() {
        driver.findElement(leaveType).click();
    }
    public void leaveDropdownMenu() {
        WebElement staticDropdown = driver.findElement(leaveTypeDropdown);
        Select selectDropdown = new Select(staticDropdown);
        selectDropdown.selectByValue("1");
        WebElement element = driver.findElement(leaveTypeDropdown);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    public void calendarSelect() {
        driver.findElement(txtFromDate).click();
        driver.findElement(fromDate).click();
    }
    public void enterInfo(AssignLeave assignLeave) {
        inputEmployeeName(assignLeave.getCompleteName());
        inputLeaveType();
        leaveDropdownMenu();
        calendarSelect();
    }
    public void clickAssignButton() throws InterruptedException {
        WebElement element = driver.findElement(assignButton);
        Actions action = new Actions(driver);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        action.moveToElement(element).perform();Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(assignButton)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void confirmLeave() {
        driver.findElement(confirmationButton).click();
    }
}
