package JUnitFramework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class MoveToElement extends TestBase {
    /* 1- https://www.amazon.com/ adresine gidin
    2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
    3- “Create a list” butonuna basin
    4- Acilan sayfada “Your Lists” yazisi oldugunu test edin

    */
    @Test

    public void test01(){

  // 1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
  //  2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
      WebElement accountListsElement= driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
      Actions actions=new Actions(driver);
      actions.moveToElement(accountListsElement).perform();
  //  3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
  //  4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String actualResult=driver.findElement(By.xpath("//div[@role='heading']")).getText();
        String expectedResult="Your Lists";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
}
