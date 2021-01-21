package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class NavigaceTest {
    public WebDriver driver;
    private final String BASE_URL = "http://localhost:81/";

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
        String expectedClass = "active";
        /* Vytvoreni seznamu(list) s jednotlivymi strankami */
        List<String> pages = new ArrayList<>();
        /* Vlozeni nasich stranek */
        pages.add("vybersi.php");
        pages.add("tabulka.php");
        pages.add("zjavenie.php");
        pages.add("clickmebaby.php");
        pages.add("kalkulacka.php");
        pages.add("moveme.php");
        pages.add("nemenne.php");
        pages.add("redalert.php");
        pages.add("registracia.php");
        pages.add("stroopeffect.php");
        pages.add("semafor.php");
        pages.add("xpathtrainingcenter.php");
        pages.add("zenaalebomuz.php");

        /* For cyklus pres nas vytvoreny seznam */
        for (String page : pages) {
            /* otevreni konkretni stranky */
            driver.get(BASE_URL + page);
            /* Chceme overit že element má class = active pomoci funkce getAttribute,  contains znamena ze obsahuje "active"*/
            Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='" + page + "']"))
                    .getAttribute("class").contains(expectedClass));
        }
    }
}
