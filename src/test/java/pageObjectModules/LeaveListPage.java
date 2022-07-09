package pageObjectModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LeaveListPage {
    public WebDriver driver;
    public LeaveListPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By leaveTab = By.xpath("//b[normalize-space()='Leave']");
    private final By checkAll = By.xpath("//input[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']");
    private final By searchButton = By.id("btnSearch");
    private final By searchName = By.xpath("//a[normalize-space()='John Smith']");
    private final By leaveActionDropdown = By.xpath("//select[@class='select_action']");
    private final By resetButton = By.xpath("//input[@id='btnReset']");
    private final By saveButton = By.cssSelector("#btnSave");

    public void leaveListPage() {
        driver.findElement(leaveTab).click();
    }

    public void clickCheckboxAll() {
        driver.findElement(checkAll).click();
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void confirmNameDisplayed() {
        assert (driver.findElement(searchName).getText().equals("John Smith"));
    }

    public void clickDropdownAction() {
        WebElement staticDropdown = driver.findElement(leaveActionDropdown);
        Select selectDropdown = new Select(staticDropdown);
        selectDropdown.selectByVisibleText("Cancel");
        WebElement element = driver.findElement(leaveActionDropdown);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public void clickResetButton() {
        driver.findElement(resetButton).click();
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }
}
