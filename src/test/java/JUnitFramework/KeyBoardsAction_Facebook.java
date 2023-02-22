package JUnitFramework;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.K;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class KeyBoardsAction_Facebook extends TestBase {
    /* 1- https://www.facebook.com adresine gidelim
     2-Cookies'i kabul edip
    Yeni hesap olustur butonuna basalim
      3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
      4- Kaydol tusuna basalim

     */
    @Test
    public  void test01(){

       //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
       //2-Cookies'i kabul edip
        driver.findElement(By.xpath("//button[@title=\"Allow essential and optional cookies\"]")).click();
       //Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@data-testid=\"open-registration-form-button\"]")).click();
       //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions=new Actions(driver);
        Faker faker=new Faker();

        actions.sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("23").
                sendKeys(Keys.TAB).sendKeys("FEB").
                sendKeys(Keys.TAB).sendKeys("2345").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
       //4- Kaydol tusuna basalim


    }
}
