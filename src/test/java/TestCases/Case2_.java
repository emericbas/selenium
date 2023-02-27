package TestCases;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Case2_ extends TestBase {
/*    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Delete Account' button
10. Verify that 'ACCOUNT DELETED!' is visible

 */
    @Test
    public void test01(){
      //1. Launch browser
      //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");
      //3. Verify that home page is visible successfully
      //4. Click on 'Signup / Login' button
      //5. Verify 'Login to your account' is visible
      //6. Enter correct email address and password
      //7. Click 'login' button
      //8. Verify that 'Logged in as username' is visible
      //9. Click 'Delete Account' button
      //10. Verify that 'ACCOUNT DELETED!' is visible

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String actualTitle= driver.getTitle();
        String expecTitle="Automation";
        Assert.assertTrue(actualTitle.contains(expecTitle));
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. Verify 'Login to your account' is visible
        WebElement text= driver.findElement(By.xpath("//h2[.='Login to your account']"));
        Assert.assertTrue(text.isDisplayed());
        //6. Enter correct email address and password
        Faker faker=new Faker();
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(faker.internet().password());
        //7. Click 'login' button
        driver.findElement(By.cssSelector(".btn.btn-default")).click();
        //8. Verify that 'Logged in as username' is visible
        //9. Click 'Delete Account' button
        //10. Verify that 'ACCOUNT DELETED!' is visible


    }
}
