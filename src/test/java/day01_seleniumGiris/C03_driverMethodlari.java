package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_driverMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // gittiginiz sayfadaki title ve url'i yazdirin
        System.out.println("URL : "+driver.getCurrentUrl()); // URL : https://www.amazon.com/
       System.out.println("Baslik : "+driver.getTitle());
        // amazon anasayfaya gittiginizi test edin
        // Test expected result ile actual result'in karsilastirilmasidir
        // ornegin url amazon iceriyorsa diyebiliriz
        String expectedIcerik = "amazon";
      String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedIcerik)){ // amazon anasayfaya gittiysek
            System.out.println("Test PASSED");
       }else {//gidemediysek
           System.out.println("Test FAILED");
        }
    }
}
