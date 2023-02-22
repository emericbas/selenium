package JUnitFramework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseClass;

public class BasicAuthentication extends TestBaseClass {
      /*
 1- Bir class olusturun : BasicAuthentication
 2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
 3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    Html komutu : https://username:password@URL
    Username    : admin
    password     : admin
4- Basarili sekilde sayfaya girildigini dogrulayin

    */
    @Test
    public  void test01(){
      //  2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/basic_auth");
      //  3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
      //  Html komutu : https://username:password@URL
      //  Username    : admin
      //  password     : admin
      //  4- Basarili sekilde sayfaya girildigini dogrulayin
String actualResult=driver.findElement(By.tagName("p")).getText();
String expectedResult="Congratulations!";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
