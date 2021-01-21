/* Test ruznych atributu jako barvy elementu, tridy elementu ...*/

package test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import java.util.List;

public class StroopTest {
    public WebDriver driver;
    private final String BASE_URL = "http://localhost:81/stroopeffect.php";

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
        List<WebElement> titles = driver.findElements(By.xpath("//div[@class='colours text-center']/h1"));

        for (WebElement title:titles) {
            /* získaní textu elementu pomoci - .getText */
            System.out.println(title.getText());
            /* získaní color elementu pomoci css - .getCssValue */
            System.out.println(title.getCssValue("color"));
            /* získaní font-size elementu pomoci css - .getCssValue */
//            System.out.println(title.getCssValue("font-family"));
            String hexColor = Color.fromString(title.getCssValue("color")).asHex();
            System.out.println(hexColor);
        }
        /* Ulozeni rgba hodnoty elementu */
        String rgba = driver.findElement(By.xpath("//div[@class='colours text-center']/h1[1]")).getCssValue("color");
        /* prevedeni rgba na hexa */
        String hexColor = Color.fromString(rgba).asHex();
        System.out.println(hexColor);
        Assert.assertEquals("#ff0e0e", hexColor);
    }

}
