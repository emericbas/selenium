package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02__DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {

         /*
            jar dosyalarini yukleyerek Selenium'u kullanilir hale getirdik
            ancak her bir class'in hangi browser ile calismasini istiyorsak
            o browser ile ilgili driver'i class'da tanimlamamiz lazim
            browser ile ilgili tercihimiz dogrultusunda
            ilgili ayarlari yapmak icin Java'daki System class'indan
            setProperty() kullanilir
            method'a 2 parametre ekleyecegiz
            1.parametre herkes icin ayni : Webdriver.chrome.driver
            2.parametre bu driver'in dosya yolu
              herkesin bilgisayarinda farkli olabilir
              windows bilgisayarlarda sonunda .exe yazilmalidir
              mac'lerde .exe olmaz
         */
    System.setProperty("Webdriver.chrome.driver","driver/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    // istenen sayfaya gitmek icin
        driver.get("https://www.wisequarter.com");
        // www olmadan da heryere gidiyor, https oladan gidemez

        Thread.sleep(4000); // 4 sn bekler
        driver.close();
    }
}
