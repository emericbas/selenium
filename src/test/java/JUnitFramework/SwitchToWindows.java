package JUnitFramework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class SwitchToWindows extends TestBase {
    // amazon anasayfaya gidip, arama kutusunun erisilebilir oldugunu test edin

// yeni bir tab olarak wisequarter.com'a gidin
// url'in wisequarter icerdigini test edin


// amazon'un acik oldugu tab'a geri donup
// Nutella icin arama yapin
// Sonuclarin Nutella icerdigini test edin

// yeni bir window olarak youtube.com'a gidin
// Url'in youtube icerdigini test edin

// wisequarter'in acik oldugu sayfaya donun
// Title'in WiseQuarter icerdigini test edin
@Test
    public void test01(){
    driver.get("https://www.amazon.com");
    String amazonWindowHandleDegeri= driver.getWindowHandle();
    WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
    Assert.assertTrue(searchBox.isEnabled());
    // yeni bir tab olarak wisequarter.com'a gidin
// url'in wisequarter icerdigini test edin
    driver.switchTo().newWindow(WindowType.TAB);
    driver.get("");

}
}
