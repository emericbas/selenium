package JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class radioButtons {
    /*Create the required structure and complete the following task.
a. Go to the given web page.
https://facebook.com
b. Accept cookies
c. Press the Create an account button
D. Locate the radio button elements and choose the one that suits you
e.sectiginiz radio butonun secili ,digerlerinin ise secili olmadigini test edin   */
   WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public  void teardown(){
        driver.close();
    }

    //a. Go to the given web page.
    //https://facebook.com
    @Test
    public void radioButtonTest(){

  driver.get("https://www.facebook.com");
  //b. Accept cookies
       driver.findElement(By.xpath("//button[text()='Allow essential and optional cookies']")).click();
       //c. Press the Create an account button
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        //D. Locate the radio button elements and choose the one that suits you
        WebElement femaleElementi= driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement maleElementi= driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement customElementi= driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
        femaleElementi.click();
        //e.sectiginiz radio butonun secili ,digerlerinin ise secili olmadigini test edin
        Assert.assertTrue(femaleElementi.isSelected());
        Assert.assertFalse(maleElementi.isSelected());
        Assert.assertFalse(customElementi.isSelected());
    }
}
