package mavenTests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class mavenRetest {

       /* 1- Create a class named C01_RepeatTest
        2- Go to https://www.google.com/
        3- Accept and close the cookies warning
        4- Test if the page title contains the phrase "Google"
        5- Search by typing “Nutella” in the search bar
        6- Print the number of results found
        7- test the number of results is more than 10 million
        8- Close the page

        */
 static WebDriver driver;
 @BeforeClass
    public static void setup(){
     driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     driver.get("https://www.google.com/");
 }
 @AfterClass
    public static void teardown(){
     driver.close();
 }
 @Test
    public void test01(){
     //Accept and close the cookies warning
     driver.findElement(By.xpath("//div[text()='Accept all']")).click();
 }
 @Test
    public void test02(){
     //Test if the page title contains the phrase "Google"
     String expetedTitle="Google";
     String actualTitle=driver.getTitle();
     Assert.assertTrue(actualTitle.contains(expetedTitle));
 }
 @Test
    public  void test03(){
     //Search by typing “Nutella” in the search bar
     driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella");
     driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
     // 6- Print the number of results found
     WebElement numberOfResult=driver.findElement(By.xpath("//div[@id='result-stats']"));


     //        7- test the number of results is more than 10 million
     String resultNumber= numberOfResult.getText();
     String[]resultArr=resultNumber.split(" ");
     String resultStr=resultArr[1];
    resultStr=resultStr.replaceAll("\\D","");
    int actualResultStr=Integer.parseInt(resultStr);
    Assert.assertTrue(actualResultStr>10000000);
 }
    }

