package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class VyberSiTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost:81/vybersi.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void test(){
        driver.get(BASE_URL);
//        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Diglett");
        Select drpPokemon = new Select(driver.findElement(By.className("form-control")));
        /* Vyber pomoci visible text */
        drpPokemon.selectByVisibleText("Pikachu");
        /* Vypiseme na obrazovku element h3 */
        System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
        /* Porovname jestli v H3 texte je slovo Pikachu */
        Assert.assertTrue("Pikachu se v texte nenachazi",driver.findElement(By.xpath("//div/h3")).getText().contains("Pikachu"));
        /* Porovname jestli v H3 texte neni slovo Karel */
        Assert.assertFalse("Karel se v texte nachazi ale nemel by",driver.findElement(By.xpath("//div/h3")).getText().contains("Karel"));
        /* Vyber pomoci indexu */
        drpPokemon.selectByIndex(5);
        /* Vyber pomoci value */
        drpPokemon.selectByValue("02");
        }


    @After
    public void tearDown(){
        driver.quit();
    }
}
