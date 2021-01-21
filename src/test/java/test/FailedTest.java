package test;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;


public class FailedTest {
    public WebDriver driver;
    private final String BASE_URL = "http://localhost:81/vybersi.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown() throws IOException {
        /* vytvoreni screenshot chyby,  TakesScreenshot - ziskame screenshot ktery udela nas driver */
        /* screenshot chceme ziskat jako OutputType "FILE"  -   getScreenshotAs(OutputType.FILE)  */
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        /* nasledne chceme file ulozit pomoci fileUtils */
        FileUtils.copyFile(screenShot, new File("C://Users//zdenek//Repository//Selenium//Pictures//scr.png"));
        /* vypsani zdrojoveho kodu stranky */
        System.out.println(driver.getPageSource());


    }
    @Test
    public void test() {
        driver.get(BASE_URL);
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Charmander");
        String actualTitle = driver.findElement(By.xpath("//div[contains(@class, 'pokemon')]/h3")).getText();
        Assert.assertTrue(actualTitle.contains("Pikachu"));
    }

}


