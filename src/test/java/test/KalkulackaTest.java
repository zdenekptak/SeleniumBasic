package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/* extends MainTest - znamena ze dedime vlastnosti z MainTest */
public class KalkulackaTest extends MainTest {

    @Before
    public void openBaseURL() {
        driver.get(getBASE_URL() + "kalkulacka.php");
    }
    /* vytvoreni metody pro testování výce vstupů */
    private void checkSum(String firstInput, String secondInput, String expectedSum) {
        enterInputs(firstInput, secondInput);
        driver.findElement(By.id("count")).click();
        Assert.assertEquals(expectedSum, driver.findElement(By.id("result")).getText());
    }

    /* vytvoreni metody pro testování výce vstupů */
    private void checkDeduct(String firstInput, String secondInput, String expectedDeduct) {
        enterInputs(firstInput, secondInput);
        driver.findElement(By.id("deduct")).click();
        Assert.assertEquals(expectedDeduct, driver.findElement(By.id("result")).getText());
    }

    private void enterInputs(String firstInput, String secondInput) {
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys(firstInput);
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys(secondInput);
    }

    private void isHasError(String expectedClass, String xpath) {
        Assert.assertTrue(driver.findElement(By.xpath(xpath))
                .getAttribute("class")
                .contains(expectedClass));
    }

    @Test

    public void checkSum() {
        checkSum("5", "3", "8");
        checkSum("2", "3", "5");
        checkSum("1", "1", "2");
        checkSum("5", "4", "9");
        checkSum("500", "40", "540");
        checkSum("1000", "4", "1004");
    }


    @Test
    public void testDeduct() {

        checkDeduct("5", "3", "2");
        checkDeduct("100", "25", "75");
        checkDeduct("500", "3", "497");

    }

    @Test
    public void testReset() {
        enterInputs("5", "6");
        driver.findElement(By.id("count")).click();
        driver.findElement(By.id("reset")).click();

        Assert.assertTrue(driver.findElement(By.id("firstInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("secondInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("result")).getText().isEmpty());
        Assert.assertFalse(driver.findElement(By.id("result")).isDisplayed());


    }
    @Test
    public void testInvalidInputs() {
        String expectedClass = "has-error";
        enterInputs("pes", "pes2");
        driver.findElement(By.id("count")).click();
        isHasError(expectedClass, "//div[input[@id='firstInput']]");
        isHasError(expectedClass, "//div[input[@id='secondInput']]");
    }

    @Test
    public void testInvalidFirstInputs() {
        String expectedClass = "has-error";
        enterInputs("pes", "1");
        driver.findElement(By.id("count")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='firstInput']]"))
                .getAttribute("class")
                .contains(expectedClass));
        Assert.assertFalse(driver.findElement(By.xpath("//div[input[@id='secondInput']]"))
                .getAttribute("class")
                .contains(expectedClass));
    }


}
