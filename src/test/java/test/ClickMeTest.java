package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ClickMeTest extends MainTest {
    /* vytvoreni promenne typu webdriver */
//    private WebDriver driver;

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "clickmebaby.php");

    }
    @Test
    /* void znamena ze navraci hodnotu */
    public void test(){
        /* otevreni nasi stranky */
//        driver.get(BASE_URL);
        /* overyme puvodni pocet kliku a slovo klik */
        Assert.assertEquals("Uvodni pocet kliku", "0", driver.findElement(By.id("clicks")).getText());
        Assert.assertEquals("Uvodni sklonovani klikov", "klikov", driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText());
        /* for cykl */
        for (int i = 1; i < 11; i = i+1) {
            /* 10x klikneme na button s id clickMe */
            driver.findElement(By.id("clickMe")).click();
            /* porovani hodnoty  pomoci for cyklu */
            Assert.assertEquals(String.valueOf(i), driver.findElement(By.id("clicks")).getText());
            if (i == 1) {
                /* print na obrazovku (terminal) */
                System.out.println("Overujeme slovo klik");
                /* vypsani cisla do terminalu */
                System.out.println(driver.findElement(By.id("clicks")).getText());
                /* vypsani kliku do terminalu */
                System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText());
                /* porovani sklonovani u klik */
                Assert.assertEquals("klik", driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText());
            }
            if (1<i && i<5) {
                System.out.println("Overujeme slovo kliky");
                System.out.println(driver.findElement(By.id("clicks")).getText());
                System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText());
                Assert.assertEquals("kliky", driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText());
            }
            if (i>4) {
                System.out.println("Overujeme slovo klikov");
                System.out.println(driver.findElement(By.id("clicks")).getText());
                System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText());
                Assert.assertEquals("klikov", driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText());
            }
        }


    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
