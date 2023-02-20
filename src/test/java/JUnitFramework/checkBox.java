package JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class checkBox {
    /*Create the required structure and complete the following task.
a. Go to the given web page.
https://the-internet.herokuapp.com/checkboxes
b. Locate the checkbox1 and checkbox2 elements.
c. Click the checkbox if Checkbox1 is not selected
d. Click the checkbox if Checkbox2 is not selected
e.Test Checkbox1 and Checkbox2 are selected or not
     */

  static  WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @AfterClass
    public  static void teardown(){
        driver.close();
    }
   // b. Locate the checkbox1 and checkbox2 elements.
    @Test
    public void selectedTest() throws InterruptedException {
        //a. Go to the given web page.
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
       WebElement checkBox1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
       WebElement checkBox2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
       //c. Click the checkbox if Checkbox1 is not selected
        Thread.sleep(3000);
        if(!checkBox1.isSelected()){
            checkBox1.click();
        }
        //d. Click the checkbox if Checkbox2 is not selected
        if(!checkBox2.isSelected()){
            checkBox2.isSelected();
            Thread.sleep(3000);
        }
        //e.Test Checkbox1 and Checkbox2 are selected or not
        Assert.assertTrue(checkBox1.isSelected() && checkBox2.isSelected());
       // Assert.assertTrue(checkBox1.isSelected());
       // Assert.assertTrue(checkBox2.isSelected());
    }

}
