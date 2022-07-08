package pageObjectModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.AssignLeave;

import static utilities.ErrorMsgs.NO_RECORDS_FOUND;

public class LeaveListPage {
    public WebDriver driver;
    public LeaveListPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By leaveTab = By.xpath("//b[normalize-space()='Leave']");
    private final By checkAll = By.xpath("//input[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']");
    private final By searchButton = By.id("btnSearch");
    private final By searchName = By.xpath("//a[normalize-space()='John Smith']");
    private final By searchTable = By.id("resultTable");
    private final By leaveActionDropdown = By.id("select_leave_action_68");
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
    public void confirmNameDisplayed(AssignLeave assignLeave) {
        assert (driver.findElement(searchName).getText().equals(assignLeave.getCompleteName()));
    }
    public void nameNotFound() {
        assert (driver.findElement(searchTable).getText().equals(NO_RECORDS_FOUND.getText()));
    }
    public void clickDropdownAction() {
        WebElement staticDropdown = driver.findElement(leaveActionDropdown);
        Select selectDropdown = new Select(staticDropdown);
        selectDropdown.selectByVisibleText("Cancel");
        WebElement element = driver.findElement(leaveActionDropdown);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }
}
