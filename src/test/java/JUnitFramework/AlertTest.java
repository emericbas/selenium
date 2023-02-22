package JUnitFramework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import utilities.TestBaseClass;

public class AlertTest extends TestBaseClass {

    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
// 3 test method'u olusturup her method'da bir JsAlert'e basin
// Ilgili method'lari kullanin

// 1.alert'e tiklayalim
// Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
// OK tusuna basip alert'i kapatalim

// 2.alert'e tiklayalim
// cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

// 3.alert'e tiklayalim
// Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
// Cikan sonuc yazisinin Abdullah icerdigini test edelim
@Test
public void test01(){
// https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
   // 3 test method'u olusturup her method'da bir JsAlert'e basin
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    // 1.alert'e tiklayalim
// Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
    driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
    String actualYazi=driver.switchTo().alert().getText();
    String expectedYazi="I am a JS Alert";
    Assert.assertEquals(expectedYazi,actualYazi);
    wait(3);
    // OK tusuna basip alert'i kapatalim
    driver.switchTo().alert().accept();
}
@Test
    public  void test02(){
    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
    // 3 test method'u olusturup her method'da bir JsAlert'e basin
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    // 2.alert'e tiklayalim
// cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
    driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
    wait(2);
    driver.switchTo().alert().dismiss();
String actualResult=driver.findElement(By.xpath("//p[text()='You clicked: Cancel']")).getText();
String expectedResult="You clicked: Cancel";
Assert.assertEquals(expectedResult,actualResult);
}
@Test
    public void test03(){
    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
    // 3 test method'u olusturup her method'da bir JsAlert'e basin
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    // 3.alert'e tiklayalim
// Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
// Cikan sonuc yazisinin Abdullah icerdigini test edelim

driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
driver.switchTo().alert().sendKeys("Abdullah");
wait(2);
driver.switchTo().alert().accept();
String actualText=driver.findElement(By.xpath("//p[text()='You entered: Abdullah']")).getText();
String expectedText="Abdullah";
Assert.assertEquals(expectedText,actualText);
}


}
