package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class registrace  extends MainTest {
    private final String validEmail = "zptak@seznam.cz";
    private final String name = "Zdenek";
    private final String surname = "Ptak";

    @Before
    public void openBaseURL() {
        driver.get(getBASE_URL() + "registracia.php");
    }

    @Test
    public void testMissingAllInputs() {
        /* Test kdy nevyplnime zadne policko */
        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement title = driver.findElement(By.xpath("//div/strong"));
        String actualTitle = title.getText();
        String expectedTitle = "Registracia neuspesna!";
        Assert.assertTrue(title.isDisplayed());
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    @Test
    public void testMissingPassword() {
        /* Test kdyz nezadame heslo */
        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.xpath("//div/input[@name='email']")).sendKeys(validEmail);
        driver.findElement(By.xpath("//div/input[@name='name']")).sendKeys(name);
        driver.findElement(By.xpath("//div/input[@name='surname']")).sendKeys(surname);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement title = driver.findElement(By.xpath("//div/strong"));
        String actualTitle = title.getText();
        String expectedTitle = "Registracia neuspesna!";
        Assert.assertTrue(title.isDisplayed());
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testMismatchedPassword() {
        /* Test nesouhlasnych hesel */
        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.xpath("//div/input[@name='email']")).sendKeys(validEmail);
        driver.findElement(By.xpath("//div/input[@name='name']")).sendKeys(name);
        driver.findElement(By.xpath("//div/input[@name='surname']")).sendKeys(surname);
        driver.findElement(By.xpath("//div/input[@name='password']")).sendKeys("Ptak");
        driver.findElement(By.xpath("//div/input[@name='password-repeat']")).sendKeys("Ptak1985");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement title = driver.findElement(By.xpath("//div/strong"));
        String actualTitle = title.getText();
        String expectedTitle = "Registracia neuspesna!";
        Assert.assertTrue(title.isDisplayed());
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testMissingCheckbox() {
        /* Test kdy neni zaskrtnuty checkbox */
        driver.findElement(By.xpath("//div/input[@name='email']")).sendKeys(validEmail);
        driver.findElement(By.xpath("//div/input[@name='name']")).sendKeys(name);
        driver.findElement(By.xpath("//div/input[@name='surname']")).sendKeys(surname);
        driver.findElement(By.xpath("//div/input[@name='password']")).sendKeys("Ptak1985");
        driver.findElement(By.xpath("//div/input[@name='password-repeat']")).sendKeys("Ptak1985");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//div/input[@name='email']")).getCssValue("border-color");
        WebElement title = driver.findElement(By.xpath("//div/strong"));
        String actualTitle = title.getText();
        String expectedTitle = "Registracia neuspesna!";
        Assert.assertTrue(title.isDisplayed());
        Assert.assertEquals(expectedTitle, actualTitle);
        String expectedColor = "rgb(169, 68, 66)";
        Assert.assertEquals(expectedColor, driver.findElement(By.xpath("//label")).getCssValue("Color"));
    }

    @Test
    public void testSuccesFullRegistration() {
        /* Test uspesne registrace */
        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.xpath("//div/input[@name='email']")).sendKeys(validEmail);
        driver.findElement(By.xpath("//div/input[@name='name']")).sendKeys(name);
        driver.findElement(By.xpath("//div/input[@name='surname']")).sendKeys(surname);
        driver.findElement(By.xpath("//div/input[@name='password']")).sendKeys("Ptak1985");
        driver.findElement(By.xpath("//div/input[@name='password-repeat']")).sendKeys("Ptak1985");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement title = driver.findElement(By.xpath("//div/strong"));
        String actualTitle = title.getText();
        String expectedTitle = "Registracia uspesna!";
        Assert.assertTrue(title.isDisplayed());
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testErrorBorderColor() {
        /* Test ktery kontroluje yda policka pri chybne zadanych hodnotach zcervenaji (to kontrolujeme pomoci ocekavane cssValue) */
        String expectedColor = "rgb(169, 68, 66)";
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        /* vytvorime seznam webelementu */
        List<WebElement> colorDivs =  driver.findElements(By.xpath("//div/input"));

        for (WebElement colorDiv : colorDivs) {
            Assert.assertEquals(expectedColor, colorDiv.getCssValue("border-color"));
        }

    }

    @Test
    public void testErrorBorderColorSecond() {
        /* Test ktery kontroluje yda policka pri chybne zadanych hodnotach zcervenaji (to kontrolujeme pomoci tridy has-error) */
        String expectedClass = "has-error";
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        List<WebElement> formDivs = driver.findElements(By.xpath("//div[input]"));

        for (WebElement formDiv : formDivs) {
            /* Test ze element obsahuje tridu has-error */
            Assert.assertTrue(formDiv.getAttribute("class").contains(expectedClass));
        }
        /* test ze checkbox obsahuje tridu has-error */
        Assert.assertTrue(driver.findElement(By.xpath("//div[label[input[@id='checkbox']]]"))
                .getAttribute("class")
                .contains(expectedClass));



    }

}
