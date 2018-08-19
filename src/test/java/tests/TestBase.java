package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public TestBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
