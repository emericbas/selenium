package JUnitFramework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Iframe extends TestBase {
    // https://the-internet.herokuapp.com/iframe  adresine gidin
    // "Your content goes here." yazisinin gorunur oldugunu test edin
    // Elemental Selenium linkine click yapin
    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/iframe  adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        // "Your content goes here." yazisinin gorunur oldugunu test edin
        WebElement frameElementi= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);
    WebElement actualYazi= driver.findElement(By.tagName("p"));

        Assert.assertTrue(actualYazi.isDisplayed());
        // Elemental Selenium linkine click yapin
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
    }

}
