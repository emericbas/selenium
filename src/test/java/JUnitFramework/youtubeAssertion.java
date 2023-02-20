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

public class youtubeAssertion {
    /*1) Create a class: Youtube Assertions
2) Go to https://www.youtube.com
3) Create 3 test methods using the following names and run the necessary tests
○ titleTest => Test that the page title is "YouTube"
○ imageTest => Test that YouTube image is displayed (isDisplayed())
○ Test that Search Box is accessible (isEnabled())
○ wrongTitleTest => Verify that the page title is not “youtube”

     */
   static WebDriver driver;
    @BeforeClass
    public  static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2) Go to https://www.youtube.com.

        driver.get("https://www.youtube.com");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    //3) Create 3 test methods using the following names and run the necessary tests
    //        ○ titleTest => Test that the page title is "YouTube"
    @Test
    public void titleTest() {
//click Accept all button
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response-inverse'])[2]")).click();
       String expectedTitle="YouTube";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    //  ○ imageTest => Test that "YouTube" image is displayed (isDisplayed())
    @Test
    public  void imageTest(){
     WebElement imageElement= driver.findElement(By.xpath("(//div[@class='style-scope ytd-topbar-logo-renderer'])[1]"));

Assert.assertTrue(imageElement.isDisplayed());
    }

  //        ○ Test that Search Box is accessible (isEnabled())
    @Test
    public void searchBoxTest(){
      WebElement searchBox=  driver.findElement(By.xpath("//input[@id='search']"));
      Assert.assertTrue(searchBox.isEnabled());
    }

  //        ○ wrongTitleTest => Verify that the page title is not “youtube”
    @Test
    public void wrongTitleTest(){
        String actualTitle=driver.getTitle();
        String expectedTitle="youtube";
        Assert.assertNotEquals(expectedTitle,actualTitle);
    }
}
