package pageObjectModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.MyInfo;

import java.time.Duration;

public class MyInfoPage {
    public WebDriver driver;
    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By myInfoTab = By.cssSelector("a[id='menu_pim_viewMyDetails'] b");
    private final By contactDetails = By.xpath("//a[normalize-space()='Contact Details']");
    private final By editButton = By.id("btnSave");
    private final By addressField = By.xpath("//input[@id='contact_street1']");
    private final By cityField = By.xpath("//input[@id='contact_city']");
    private final By saveButton = By.id("btnSave");
    private final By immigrationSection = By.xpath("//a[normalize-space()='Immigration']");
    private final By addButton = By.xpath("//input[@id='btnAdd']");
    private final By visaRadio = By.id("immigration_type_flag_2");
    private final By visaNumber = By.id("immigration_number");
    private final By qualifySection = By.xpath("//ul[@id='sidenav']//a[contains(text(),'Qualifications')]");
    private final By addLanguage = By.id("addLanguage");
    private final By dropdownLanguage = By.id("language_code");
    private final By selectLanguage = By.cssSelector("select[id='language_code'] option[value='3']");
    private final By dropdownFluency = By.id("language_lang_type");
    private final By selectFluency = By.xpath("//option[normalize-space()='Speaking']");
    private final By dropdownCompetency  = By.id("language_competency");
    private final By selectCompetency  = By.xpath("//option[normalize-space()='Poor']");
    private final By saveLanguageButton  = By.id("btnLanguageSave");


    public void clickMyInfoTab() {
        driver.findElement(myInfoTab).click();
    }

    public void clickDetails() {
        driver.findElement(contactDetails).click();
    }

    public void editButton() {
        driver.findElement(editButton).click();
    }

    public void addressInfo(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void cityInfo(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void enterInfoDetails(MyInfo myInfo) {
        addressInfo(myInfo.getAddress());
        cityInfo(myInfo.getCity());
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public void clickImmaSection() {
        driver.findElement(immigrationSection).click();
    }

    public void visaField(String city) {
        driver.findElement(visaNumber).sendKeys(city);
    }

    public void inputImmaDetails(MyInfo myInfo) {
        driver.findElement(addButton).click();
        driver.findElement(visaRadio).click();
        visaField(myInfo.getVisa());
    }

    public void clickQualifySection() {
        driver.findElement(qualifySection).click();
    }

    public void clickDropdownLanguage() {
        driver.findElement(addLanguage).click();
        driver.findElement(dropdownLanguage).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(selectLanguage).click();
    }

    public void clickDropdownFluency() {
        driver.findElement(dropdownFluency).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(selectFluency).click();
    }

    public void clickDropdownCompetency() {
        driver.findElement(dropdownCompetency).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(selectCompetency).click();
    }

    public void clickSaveLanguageButton() {
        driver.findElement(saveLanguageButton).click();
    }
}
