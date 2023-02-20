package basicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class xPathLocators {
    public static void main(String[] args) throws InterruptedException {
    /*    Relative X path Question
        1- Go to https://the-internet.herokuapp.com/add_remove_elements/
        2- Press the Add Element button
        3- Test that the Delete button is visible
        4- Press the delete key
        5- Test that the text “Add/Remove Elements“ is visible

     */
      //  1- Go to https://the-internet.herokuapp.com/add_remove_elements/
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
      //  2- Press the Add Element button
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
      //  3- Test that the Delete button is visible
        WebElement deleteButton=driver.findElement(By.xpath("(//button[@class='added-manually'])"));
        if(deleteButton.isDisplayed()){
            System.out.println("The test of delete button passed");
        }else{
            System.out.println("The test of delete button failed");
        }

      //  4- Press the delete key
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//button[@class='added-manually'])")).click();
      //  5- Test that the text “Add/Remove Elements“ is visible
       WebElement addRemoveButton= driver.findElement(By.xpath("//button[@onclick='addElement()']"));
       if(addRemoveButton.isDisplayed()){
           System.out.println("The test of addRemove button passed");
       }else{
           System.out.println("The test of addRemove button failed");

       }
       Thread.sleep(3000);
       driver.close();
    }
}
