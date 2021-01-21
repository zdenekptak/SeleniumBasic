package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RefreshStranky {
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
        /* ulozeni uvodni hodnoty do promenny uvodniHodnota*/
        String uvodniHodnota = driver.findElement(By.xpath("//h1[@id='clicks']")).getText();
        System.out.println(uvodniHodnota);
        /* cyklus pro 5 kliknuti */
        for (int i = 0; i<5; i++) {
            driver.findElement(By.id("clickMe")).click();
        }
        /* porovnani poctu kliku - 5 */
        Assert.assertEquals("5", driver.findElement(By.xpath("//h1[@id='clicks']")).getText());
        /* refresh stranky */
        driver.navigate().refresh();
        Assert.assertEquals(uvodniHodnota, driver.findElement(By.xpath("//h1[@id='clicks']")).getText());
    }
    @After
    public void tearDown() {
        driver.quit();

    }
}
