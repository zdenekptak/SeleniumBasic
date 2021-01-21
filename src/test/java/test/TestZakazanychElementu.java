package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestZakazanychElementu {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost:81/nemenne.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @After
    public void ukonceni() {
        driver.quit();
    }

    @Test
    public void test() {
        driver.get(BASE_URL);
        driver.findElement(By.id("inputEmail3")).isEnabled();
        System.out.println(driver.findElement(By.id("inputEmail3")).isEnabled());
        /* overime ze element neni povolen */
        Assert.assertFalse(driver.findElement(By.id("inputEmail3")).isEnabled());
        System.out.println(driver.findElement(By.id("sel1")).getText());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='sel2']/option[1]")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='sel2']/option[2]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='sel2']/option[3]")).isEnabled());
        System.out.println(driver.findElement(By.className("btn-danger")).isEnabled());

        Assert.assertFalse(driver.findElement(By.xpath("//button[contains(@class,'btn-danger')]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(@class,'btn-succes')]")).isEnabled());
    }

}
