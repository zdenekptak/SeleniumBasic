package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class KontrolaVsechRadku {
    public WebDriver driver;
    private final String BASE_URL = "http://localhost:81/tabulka.php";

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
        /* Vytvorime list webelementu */
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        /* z kazdeho elementu si nechame vypsat text */
        for (WebElement row : rows) {
            System.out.println(row.getText());
            /* ziskame pouze prijmeni */
            row.findElement(By.xpath("./td[3]")).getText();
            System.out.println(row.findElement(By.xpath("./td[3]")).getText());
            /* overeni ze prijmeni neni prazdne */
            Assert.assertFalse(row.findElement(By.xpath("./td[3]")).getText().isEmpty());
        }

    }
}
