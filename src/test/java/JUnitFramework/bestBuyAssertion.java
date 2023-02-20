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

public class bestBuyAssertion {
    /*1) Create a class: BestBuy Assertions
2) https://www.bestbuy.com/ Go to address A and make the following tests by
creating different test methods
○ Test that the page URL is equal to https://www.bestbuy.com/
○ titleTest => Test if the page title does not contain "Rest"
○ logoTest => Test if BestBuy logo displayed
○ Francais LinkTest => Test if French link is displayed
    */
    static WebDriver driver;
    @BeforeClass
    public  static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public  static  void teardown(){
        driver.close();
    }
    @Test
    public void test01(){
        //○ Test that the page URL is equal to"" https://www.bestbuy.com/""
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    @Test
    public void test02(){
      // ○ titleTest => Test if the page title does not contain "Rest"
        String expectedTitle="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test03(){
        //○ logoTest => Test if BestBuy logo displayed
        WebElement displayElement=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(displayElement.isDisplayed());
    }
    @Test
    public  void test04(){
        //○ Francais LinkTest => Test if French link is displayed
        WebElement franciesLink=driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(franciesLink.isDisplayed());
    }


}
