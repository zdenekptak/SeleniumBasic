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

public class DragAndDropTest {
    public WebDriver driver;
    private final String BASE_URL = "http://localhost:81/moveme.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    /* napoveda ctrl+p */
    @Test
    public void test() {
        /* maximalizace okna */
        driver.manage().window().maximize();
        /* otevreme baseurl */
        driver.get(BASE_URL);

        /* vytvorime dva webelementy */
        WebElement donald = driver.findElement(By.id("donald"));
        WebElement tree = driver.findElement(By.id("tree"));

        /* vytvorime instanci actions (napr neco mysi) */
        Actions actions = new Actions(driver);
        /* spusteni akce, nejprve musime buildovat build() a potom provest perform() */
        /* .dragAndDrop chytne a pretahne element */
        actions.dragAndDrop(donald, tree).build().perform();

        /* najdeme ocekavany titulek a ulozime */
        WebElement expectedTitle = driver.findElement(By.xpath("//div[@class='success text-center']/h2"));
        String actualStr = expectedTitle.getText();
        /* je ocekavany title zobrazen */
        Assert.assertTrue(expectedTitle.isDisplayed());
        /* porovnani ocekavaneho a aktualniho titulku */
        Assert.assertEquals("HOOO HOOOOO !!!!", actualStr);
    }
}
