package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_DriverManageMethodlari {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","driver/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("fullscreen size : "+driver.manage().window().getSize());//fullscreen size : (1552, 832)
        System.out.println("fullscreen position : "+driver.manage().window().getPosition());//fullscreen position : (-8, -8)
    }
}
