import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class locators {
    public static void main(String[] args) throws InterruptedException {
      /*  1- Go to https://www.amazon.com/
        2- Search by typing "city bike" in the search
                box
        3- Print the number of displayed results
        4- Click on the picture of the first product
        from the list

       */
     //  1- Go to https://www.amazon.com/
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");

     //  2- Search by typing "city bike" in the search box
      WebElement searchBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
      searchBox.sendKeys("city bike"+ Keys.ENTER);

     //  3- Print the number of displayed results
        System.out.println(driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]")).getText());
        //1-16 of 119 results for

        //  4- Click on the picture of the first product  from the list
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        Thread.sleep(3000);
        driver.close();
    }
}