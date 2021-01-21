package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedAlertTest {
    public WebDriver driver;
    private final String BASE_URL = "http://localhost:81/redalert.php";

    @Before
    public void setUp() {
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
        /* Test alert1 */
        driver.findElement(By.xpath("//*[@id='alert1']")).click();
        /* Vytvorim si objekt alert a prepnu se do nej pomoci driveru*/
        Alert alert1 = driver.switchTo().alert();
        /* Akceptuji alert*/
        alert1.accept();
        /* Najdeme element podle xpath */
        driver.findElement(By.xpath("//div[@class='result']/h1")).getText();
        System.out.println(driver.findElement(By.xpath("//div[@class='result']/h1")).getText());
        /* Porovnani ocekavane hodnoty */
        Assert.assertEquals("Kirov Reporting",driver.findElement(By.xpath("//div[@class='result']/h1")).getText());

        /* Test alert2 */
        driver.findElement(By.xpath("//*[@id='alert2']")).click();
        Alert alert2 = driver.switchTo().alert();
        /* Vypsani textu z alertu */
        System.out.println(alert2.getText());
        alert2.dismiss();
        driver.findElement(By.xpath("//div[@class='result']/h1")).getText();
        System.out.println(driver.findElement(By.xpath("//div[@class='result']/h1")).getText());
        Assert.assertEquals("Negative",driver.findElement(By.xpath("//div[@class='result']/h1")).getText());

        /* Test alertu3 */
        driver.findElement(By.xpath("//*[@id='alert3']")).click();
        Alert alert3 = driver.switchTo().alert();
        /* Vepsani textu do alertu */
        alert3.sendKeys("Zdenek");
        alert3.accept();
        driver.findElement(By.xpath("//div[@class='result']/h1")).getText();
        System.out.println(driver.findElement(By.xpath("//div[@class='result']/h1")).getText());
        Assert.assertTrue("Ve zprave neni jmeno Zdenek",driver.findElement(By.xpath("//div[@class='result']/h1")).getText().contains("Zdenek"));

    }
}
