package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c05_DriverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        // yeniden amazon anasayfaya gidin
        driver.navigate().back();
        // wisequarter anasayfaya donun
        driver.navigate().forward();
        // navigate().to(),   driver.get() ile ayni islemi yapar
        driver.navigate().to("https://www.ebay.com");
        Thread.sleep(5000);
        driver.navigate().refresh();
    }
}
