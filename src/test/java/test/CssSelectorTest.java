package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost:81/clickmebaby.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        driver.findElement(By.cssSelector("div.row button")).click();


    }
    @After
    public void tearDown(){
//        driver.quit();

    }
}
