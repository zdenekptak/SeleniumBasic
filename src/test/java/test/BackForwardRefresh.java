package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BackForwardRefresh {
    public WebDriver driver;
    private final String BASE_URL = "http://localhost:81/registracia.php";

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
    public void test() {
        driver.get(BASE_URL);
        /* vytvoreni promenne email  */
        String email = "zptak@seznam.cz";
        /* do elementu se jmenem email vlozime promenou email */
        driver.findElement(By.name("email")).sendKeys(email);
        /* kliknem na stranku zenaanebomuz */
        driver.findElement((By.xpath("//a[@href='zenaalebomuz.php']"))).click();
        /* dame na strance zpet */
        driver.navigate().back();
        /* cekani na element */
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
        /* kontrolujeme zda zustala vyplnena hodnota emailu - input ziskavame pomoci getAttribute() */
//        System.out.println(driver.findElement(By.name("email")).getAttribute("value"));
        String kontrolaEmailu = driver.findElement(By.name("email")).getAttribute("value");
        System.out.println(kontrolaEmailu);
        /* porovnani zda jsou dve hodnoty stejne */
        Assert.assertEquals(email, kontrolaEmailu);
        /* dame dopredu */
        driver.navigate().forward();
        /* cekani na element */
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='img/conchita.jpg']")));
        /* kontrola zda se element zobrazil   - .isDisplayed()*/
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='img/conchita.jpg']")).isDisplayed());


    }

}
