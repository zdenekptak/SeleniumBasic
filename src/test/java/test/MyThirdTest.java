package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;

public class MyThirdTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost:81/registracia.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

    }
    @Test
    public void test(){
        driver.get(BASE_URL);
        /* vytvoreni promene */
        var s = "zptakseznam.cz";
        /* do elementu input vlozime promenou {email} */
        driver.findElement(By.tagName("input")).sendKeys(s);
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/input")).sendKeys("Zdenek");
        driver.findElement(By.xpath("//input[@name='surname']")).sendKeys("Ptak");
        driver.findElement(By.xpath("/html/body/div/div/form/div[4]/input")).sendKeys("xxx1234");
        driver.findElement(By.xpath("/html/body/div/div/form/div[5]/input")).sendKeys("xxx1234");
        driver.findElement(By.xpath("//label[text()='Som robot']"));
        driver.findElement(By.xpath("//label[text()='Som robot']")).click();
    }
    @After
    public void tearDown(){
//        driver.quit();

    }
}

