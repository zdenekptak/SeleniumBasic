package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TitleTest {
    private WebDriver driver;
    String BASE_URL = "http://localhost:81";

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
        /* Vytvoreni seznamu webelemntu titulku stranek */
        List<WebElement> titles = driver.findElements(By.xpath("//nav//ul/li/a"));
        /* Vytvoreni seznamu stringu s odkazama */
        List<String> pagesURL = new ArrayList<>();

        for (WebElement title:titles) {
            /* pres for smycku si vypisu odkazy na vsechny stranky */
//            System.out.println(title.getAttribute("href"));
            /* pridame url do pagesURL */
            pagesURL.add(title.getAttribute("href"));
        }
            /* pomoci smycky projedeme pagesURL */
        for (String pageURL:pagesURL) {
            driver.get(pageURL);
            /* metoda substring dostane z odkaz potrebnou hodnotu, zadavame pocatecni a konecnou hodnotu */
            /* pageURL.lastIndexOf("/") - najde posledni lomitko ve vyrazu ,    pageURL.indexOf(".php") - najde .php */
            String ocekavanyTitulek = pageURL.substring(pageURL.lastIndexOf("/")+1 /* +1 odsekne lomitko */, pageURL.indexOf(".php"));
            /* pomoci tohoto prikazu udelame prvni pismeno ve stringu velke(toUpperCase)
            driver.getTitle().contains(ocekavanyTitulek.substring(0,1).toUpperCase() + ocekavanyTitulek.substring(1)) */
            Assert.assertTrue(driver.getTitle().contains(ocekavanyTitulek.substring(0,1).toUpperCase() + ocekavanyTitulek.substring(1)));
        }
    }

}
