package test;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class OdstraneniElementuMimoObraz {
    public WebDriver driver;
    private final String BASE_URL = "http://localhost:81/moveme.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
//        driver.quit();
    }
    @Test
    public void test()  throws InterruptedException, IOException {
        /* maximalizace okna */
        driver.manage().window().maximize();
        /* otevreme baseurl */
        driver.get(BASE_URL);
        WebElement donald = driver.findElement(By.id("donald"));
        Actions actions = new Actions(driver);
        /* posunutí elementu po pixelech */
        actions.clickAndHold(donald).moveByOffset(5000, 0).release().build().perform();
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        /* nasledne chceme file ulozit pomoci fileUtils */
        FileUtils.copyFile(screenShot, new File("C://Users//zdenek//Repository//Selenium//Pictures//scr.png"));
    }
}
