package JUnitFramework;

import org.junit.Test;
import utilities.TestBase;

public class incorrectEmailTest extends TestBase {
    /*1. Let's create a Class IncorrectEmailTest
2. Let's go to http://automationpractice.com/index.php
3. Let's hit the sign in button
4. Let's test that when we write an e-mail without the @ sign in the e-mail box
and press enter, the "Invalid email address" warning appears

     */
    @Test
    public void test(){
        driver.get("http://automationpractice.com");
    }
  //  driver
}
