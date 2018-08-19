package tests;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ResultPage;
import pages.SearchPage;

public class BeforeAfter {

    public static SearchPage searchPage;
    public static ResultPage resultPage;
    public static WebDriver driver;


    @Before
    public void InitializeTest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        searchPage = new SearchPage(driver);
        resultPage = new ResultPage(driver);
    }

    @After
    public void TearDownTest(){
       driver.quit();
    }
}
