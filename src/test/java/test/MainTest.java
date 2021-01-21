package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {

    public WebDriver driver;

    private final String BASE_URL = "http://localhost:81/";

    /* vytvoreni getteru pro pristup k private promenne*/
    public String getBASE_URL() { return BASE_URL; }


    @Before
    /* pro pouziti chrome */
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /* pro pouziti firefox */
//    public void setUp() {
//        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
