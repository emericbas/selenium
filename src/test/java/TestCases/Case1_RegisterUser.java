package TestCases;

import com.github.javafaker.Faker;
import org.bouncycastle.crypto.modes.KCCMBlockCipher;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
import utilities.TestBaseClass;

public class Case1_RegisterUser extends TestBase {
  /*  1. Launch browser
2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
            11. Select checkbox 'Receive special offers from our partners!'
            12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
            14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

   */
    @Test
    public void test01() throws InterruptedException {
//    1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//3. Verify that home page is visible successfully
        String actualtitle = driver.getTitle();
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(expectedTitle, actualtitle);
//4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
//5. Verify 'New User Signup!' is visible
        WebElement text = driver.findElement(By.xpath("//h2[.='New User Signup!']"));
        Assert.assertTrue(text.isDisplayed());
//6. Enter name and email address
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys(faker.name().fullName());
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys(faker.internet().emailAddress());
//7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        text = driver.findElement(By.xpath("//b[.='Enter Account Information']"));
        Assert.assertTrue(text.isDisplayed());
//9. Fill details: Title, Name, Email, Password, Date of birth
        Actions actions = new Actions(driver);
        driver.findElement(By.id("id_gender2")).click();
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys("25")
                .sendKeys(Keys.TAB)
                .sendKeys("may")
                .sendKeys(Keys.TAB)
                .sendKeys("1980").perform();
//10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//label[@for='newsletter']")).click();
//11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();
//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.country().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().state())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .perform();
//13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
//14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement element = driver.findElement(By.xpath("//h2[.='Account Created!']"));
        Assert.assertTrue(element.isDisplayed());
//15. Click 'Continue' button
        Thread.sleep(10000);
        driver.findElement(By.xpath("//p[.='Congratulations! Your new account has been successfully created!']")).click();
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
//16. Verify that 'Logged in as username' is visible
        WebElement element1 = driver.findElement(By.xpath("//i[@class='fa fa-home']"));
        Assert.assertTrue(element1.isDisplayed());
//17. Click 'Delete Account' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();
//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//b[.='Account Deleted!']")).isDisplayed());
    }


    }