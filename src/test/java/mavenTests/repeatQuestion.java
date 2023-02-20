package mavenTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class repeatQuestion {
    public static void main(String[] args) throws InterruptedException {
      /*  1- create a class
        2- Go to https://www.amazon.com/
        3- Make the browser full page
        4- Refresh the page
        5- Test if the page title contains the phrase “Spend less”
        6- Press the Gift Cards tab
        7- Press the Birthday button
        8- Click the first product from the Best Seller section
        9- Select $25 from Gift card details
        10-Test the product price is $25
        11-Close the page

       */
     //  1- create a class
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

     //  2- Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");

     //  3- Make the browser full page
        driver.manage().window().fullscreen();
        Thread.sleep(3000);

     //  4- Refresh the page
        driver.navigate().refresh();

     //  5- Test if the page title contains the phrase “Spend less”
        String expectedPageTitle="Spend less";
        String actualPageTitle=driver.getTitle();
        if(actualPageTitle.contains(expectedPageTitle)){
            System.out.println("Title test passed");
        }else {
            System.out.println("Title test failed");
        }

     //  6- Press the Gift Cards tab
        driver.findElement(By.xpath("//*[@*='a1mdro-7cycto-cja9y0-nriu9x']")).click();

     //  7- Press the Birthday button
        driver.findElement(By.xpath("//*[@id=\"contentGrid_926327\"]/div/div[2]/div[2]/div/div/a/img")).click();

     //  8- Click the first product from the Best Seller section
        driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]")).click();

     //  9- Select $25 from Gift card details
        driver.findElement(By.xpath("//button[@id='gc-mini-picker-amount-1']")).click();

     //  10-Test the product price is $25
        String expectedPriceOfGiftCard="$25.00";
        WebElement productPrice= driver.findElement(By.xpath("//span[@id='gc-live-preview-amount']"));
        if(expectedPriceOfGiftCard.equals(productPrice)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
     //  11-Close the page
        driver.close();

    }
}
