package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KontrolaRadkuVTabulce {
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
        driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText();
        /* predelani stringu na integer */
        int rows = Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText());
        for (int i = 1; i < rows+1; i++) {
            /* projdeme vsechny radky a ziskame jejich hodnoty */
            String radek = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]")).getText();
            /* tisk radku do terminalu */
            System.out.println(radek);
            /* Vybereme prijmeni z kaydeho radku */
            String prijmeni = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[3]")).getText();
            System.out.println(prijmeni);
            /* Kontrola jestli prijmeni neni przdne */
            Assert.assertFalse(prijmeni.isEmpty());

        }

    }

}
