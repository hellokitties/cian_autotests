package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestBase;


public class SearchPage extends TestBase {

    public SearchPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@placeholder='до']")
    private static WebElement inputMaxPrice;

    @FindBy(xpath = "//input[@placeholder='от']")
    private static WebElement inputMinPrice;

    @FindBy(xpath = "//button[.='Найти']")
    private static WebElement searchButton;

    @FindBy(xpath = "//input[@id='c_filters-suggest_input']")
    private static WebElement inputTown;

    public WebElement getSearchButton() {
        return searchButton;
    }


    @FindBy(xpath = "//button[@data-reactid='15']")
    private static WebElement buttonChooseAction;

    @FindBy(xpath = "//button[@data-reactid='18']")
    private static WebElement chooseObject;

    public void inputPrice(String minprice, String maxprice) {
        inputMaxPrice.clear();
        inputMinPrice.clear();
        inputMinPrice.sendKeys(minprice);
        inputMaxPrice.sendKeys(maxprice);
    }

    public void inputTown(String town) {
        inputTown.clear();
        inputTown.sendKeys(town);
        wait = new WebDriverWait(driver, 15);
        WebElement town_item = (wait)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='c_filters-suggest_popup-content___1Y1Wa']/div/*[1]")));

        town_item.click();
    }

    public void chooseAction(String action) {
        buttonChooseAction.click();
        String s = String.format("//div[@class='c-filters-form___2RBwa']//div[contains(text(),'%s')]", action);
        WebElement userName = driver.findElement(By.xpath(s));
        userName.click();
    }

    public void chooseObject(String ob) {
        chooseObject.click();
        String s = String.format("//li[@class='c-filters-property-list-item___QhkVe']//span[.='%s']", ob);
        WebElement typeObject = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(s)));
        typeObject.click();
    }

}
