package JUnitFramework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class WindowHandle2 extends TestBase {
    //● Yeni bir class olusturun: WindowHandle
    //● Amazon anasayfa adresine gidin.

    //● Sayfa’nin window handle degerini String bir degiskene atayin

    //● Sayfa title’nin “Amazon” icerdigini test edin
    //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
    //● Sayfa title’nin “Bootcamp” icerdigini test edin
    //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    //● Sayfa title’nin “Walmart” icerdigini test edin
    //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
    // Ikinci acilan sayfaya gidin

   @Test
    public void test01() {
        //● Yeni bir class olusturun: WindowHandle
        //● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String ilkWHD = driver.getWindowHandle();
        //● Sayfa title’nin “Amazon” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");
        //● Sayfa title’nin “wisequarter” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Bootcamp"));
        //driver.switchTo().newWindow(WindowType.TAB).get("https://www.facebook.com");
        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        //  driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");
        //● Sayfa title’nin “Walmart” icerdigini test edin
        //  Assert.assertTrue(driver.getTitle().contains("Walmart"));
        wait(1);
        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(ilkWHD);
        wait(1);
        String actualUrl = driver.getCurrentUrl();
        String expectUrl = "https://www.amazon.com/";
        wait(1);
        String ikiWindow = "";
        Assert.assertEquals("yoooookkk", expectUrl, actualUrl);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles
        ) {
            if (!each.equals(ilkWHD)) {
                ikiWindow = each;
            }
        }
        driver.switchTo().window(ikiWindow);
    }


}