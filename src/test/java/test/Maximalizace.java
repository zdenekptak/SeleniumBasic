package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Maximalizace {
    public WebDriver driver;
    private final String BASE_URL = "http://localhost:81/moveme.php";

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
        /* nastaveni velikosti prehlizece na maximalizaci */
        driver.manage().window().maximize();
        /* nahrazeni metody maximize metodou setPosition muzeme zadat uvodni pozici okna (pokud zadame hodnoty -2500 a -2500 dostane se test mimo obraz a muzu pokracovat v praci)*/
//        driver.manage().window().setPosition(new Point(500,500));
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//img[@id='donald']")).isDisplayed();
        Assert.assertTrue(driver.findElement(By.xpath("//img[@id='donald']")).isDisplayed());


    }

}

