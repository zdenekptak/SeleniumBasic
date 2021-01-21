package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PrejedemeMysiNadElementem {
    public WebDriver driver;
    private String BASE_URL = "http://localhost:81/semafor.php";

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
        /* otevreni baseurl */
        driver.get(BASE_URL);
        /* ulozime web element do promenne */
        WebElement trafficLight = driver.findElement(By.xpath("//div[@class='light']"));

        String expectedGreen = "rgba(10, 129, 0, 1)";
        String expectedRed = "rgba(205, 58, 63, 1)";
        String expectedOrange = "rgba(191, 111, 7, 1)";

        /* porovnani ze na zacatku je cervena */
        String actualRedLight = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedRed, actualRedLight);

        /* vytvorime instanci actions (napr neco mysi) */
        Actions actions = new Actions(driver);
        /* spusteni akce, nejprve musime buildovat build() a potom provest perform() */
        /* .moveToElement znamena najeti mysi na element */
        actions.moveToElement(trafficLight).build().perform();
        /* Ulozeni aktualni barvy do stringu actualGreenLight */
        String actualGreenLight = trafficLight.getCssValue("background-color");
        /* porovn8n9 ocekavane hodnoty a aktualni hodnoty */
        Assert.assertEquals(expectedGreen, actualGreenLight);
        System.out.println(actualGreenLight);

        /* .clickAndHold znamena najeti mysi klik a drzeni */
        actions.clickAndHold(trafficLight).build().perform();
        String actualOrangeLight = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedOrange, actualOrangeLight);
        System.out.println(actualOrangeLight);
    }

}
