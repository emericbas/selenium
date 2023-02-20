package mavenTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class mavenClassWork{
    public static void main(String[] args) throws InterruptedException {
     /*   ClassWork Amazon Search Test
        1- Go to https://www.amazon.com/
        2- let's locate the search box
        3- Let's search with "Samsung headphones"
        4- Let's print the number of results found
        5- Let's click the first product
        6- Let's print all the titles on the page

      */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // 1- Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");

       // 2- let's locate the search box
      WebElement searchBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

       // 3- Let's search with "Samsung headphones"
        searchBox.sendKeys("Samsung headphones"+ Keys.ENTER);

       // 4- Let's print the number of results found
        System.out.println(driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]")).getText());

        // 5- Let's click the first product
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();


       // 6- Let's print all the titles on the page
        driver.navigate().back();
        List<WebElement>namesOfTitle=driver.findElements(By.xpath("//span[@class='a-size-base a-color-base puis-bold-weight-text']"));
    int productNumber=1;
    for (WebElement each:namesOfTitle
         ) {
        System.out.println(productNumber+"-----"+each.getText());
        productNumber++;
    }
       Thread.sleep(3000);
       driver.close();

    }
}
