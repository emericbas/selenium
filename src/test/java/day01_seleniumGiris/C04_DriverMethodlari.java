package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverMethodlari {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wisequarter.com");

        System.out.println(driver.getWindowHandle());  //CDwindow-C48CA901FFC89CE4DDD82CE8E2056EA1
        //2. kez calistirinca farkli geldi===> CDwindow-197A249BAC258EC0AFBF440491D7DB38
        // getWindowHandle selenium tarafindan her driver sayfasi icin uretilen
        // unique handle degerini döndürür
        // getWindowHandles() ise test sirasinda birden fazla sayfa acilmissa
        // bir set olarak, tum sayfalarin window handle degerlerini döndürür

        System.out.println(driver.getPageSource());// upuzun yazilar, sayfa kodlari geliyor javascript,html vb

        //Sayfa kodlari "2 hours weekly meeting with the team" iceriyor mu test edin
        String expectedIcerik="2 hours weekly meeting with the team" ;
        String actualSayfaKodlari=driver.getPageSource();
        if(actualSayfaKodlari.contains(expectedIcerik)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }

        driver.quit();
        // close() ve quit() ikisi de sayfa kapatmak icin kullanilir
        // close() sadece bir sayfa kapatirken
        // quit() test sirasinda acilan tum sayfalari kapatir
    }
}
