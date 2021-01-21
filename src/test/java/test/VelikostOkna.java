package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VelikostOkna {
    public WebDriver driver;
    private final String BASE_URL = "http://localhost:81/clickmebaby.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
//        driver.quit();
    }

    @Test
    public void test() {
        /* nastaveni velikosti prehlizece na jiny rozmer */
        driver.manage().window().setSize(new Dimension(150, 2500));
        driver.get(BASE_URL);
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("1", driver.findElement(By.id("clicks")).getText());
        Assert.assertEquals("klik", driver.findElement(By.className("description")).getText());

    }

}
