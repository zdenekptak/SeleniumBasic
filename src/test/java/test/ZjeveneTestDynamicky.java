package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class ZjeveneTestDynamicky {
    public WebDriver driver;
    private final String BASE_URL = "http://localhost:81/zjavenie.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get(BASE_URL);
        driver.findElement(By.id("showHim")).click();
        /* Vložení zpoždení do kodu - tento zpusob je vložen přímo v jave ne v seleniu*/
        /* Thread.sleep(2500); */
        /* Vložení dynamického zpoždení do kodu */
        new WebDriverWait(driver, 5)   /* spoždění maximálně 5 sec */
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//img[@class='brano']"))); /* visibilityOfElementLocated kontroluje zda je element zobrazený */
//                        .presenceOfElementLocated(By.xpath("//img[@class='brano']"))); /* presenceOfElementLocated kontroluje zda je element v DOM (struktura stránky) */
        driver.findElement(By.xpath("//img[@class='brano']"));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='brano']")).isDisplayed());

    }

}
