package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestBase;
import java.util.List;

public class ResultPage extends TestBase {
    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='cg-col-2 c-header-logo-wrap']")
    private static WebElement cianLogo;

    @FindAll({@FindBy(xpath = "//img[@class='image--1oiyD']")})
    private List<WebElement> listPhotos;

    public WebElement getLogo() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(cianLogo));
        return cianLogo;
    }

    public List<WebElement> getPhotos() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(listPhotos));
        return listPhotos;
    }

    public int checkPhotos() {
        int count_photos = 0;

        for (WebElement photo : listPhotos) {
            if (photo.isDisplayed()) {
                count_photos++;
            }
        }

        return count_photos;
    }
}
