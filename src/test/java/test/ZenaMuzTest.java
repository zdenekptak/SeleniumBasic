package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZenaMuzTest {
    public WebDriver driver;
    private final String BASE_URL = "http://localhost:81/zenaalebomuz.php";

    @Before
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void ukonceni() {
//        driver.quit();
    }
    @Test
    public void test() {
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//input[@value='wurst']")).click();
        driver.findElement(By.xpath("//h1[@class='description text-center']")).getText();
        /* .getText - yiskame text z elementu */
        System.out.println(driver.findElement(By.xpath("//h1[@class='description text-center']")).getText());
        /* isselected znamena zda je prvek zaskrtnuty (vybrany) */
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
        System.out.println(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value='conchita']")).isSelected());
        System.out.println(driver.findElement(By.xpath("//input[@value='conchita']")).isSelected());


    }

}
