package JUnitFramework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Cookies extends TestBase {
    /*1- Amazon anasayfaya gidin
2- tum cookie’leri listeleyin
3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
olusturun ve sayfaya ekleyin
6- eklediginiz cookie’nin sayfaya eklendigini test edin
7- ismi skin olan cookie’yi silin ve silindigini test edin
8- tum cookie’leri silin ve silindigini test edin

     */
    @Test
    public void test01() {
// 1- Amazon anasayfaya gidin
driver.get("https://www.amazon.com");
//2- tum cookie’leri listeleyin
   Set<Cookie> cookieList= driver.manage().getCookies();
 int  siraNo=1;
        for (Cookie each:cookieList
             ) {
            System.out.println(siraNo+"--"+each);
siraNo++;
        }
//3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookieList.size()>5);

//4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedValue="USD";
        String  actualValue=driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(expectedValue,actualValue);

//5- ismi “"en sevdigim cookie"” ve degeri “cikolatali” olan bir cookie
//    olusturun ve sayfaya ekleyin
        Cookie benimCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(benimCookie);
        System.out.println("=====Son Durum=========");

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
    cookieList=driver.manage().getCookies();
    siraNo=1;
        for (Cookie each:cookieList
             ) {
            System.out.println(siraNo+"--"+each);
            siraNo++;
        }
        Assert.assertTrue(cookieList.contains(benimCookie));

//7- ismi skin olan cookie’yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookieList.contains("skin"));

//8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieList=driver.manage().getCookies();
        Assert.assertTrue(cookieList.size()==0);
    }
}