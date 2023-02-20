package JUnitFramework;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropdownAmazon {
    /*
      ● https://www.amazon.com/ adresine gidin.
- Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

-Test 2
1. Kategori menusunden Books secenegini secin
 2. Arama kutusuna Java yazin ve aratin
 3. Bulunan sonuc sayisini yazdirin
 4. Sonucun Java kelimesini icerdigini test edin

       */
    static WebDriver driver;
    @BeforeClass
    public  static void setUp(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }@AfterClass
    public  static  void teardown(){
        driver.close();
    }
    @Test

    public  void test01(){
         driver.get("https://www.amazon.com/");
       // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
       WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropDownMenu);
       int expectedNumber=45;
       int actualNumber=select.getOptions().size();
        Assert.assertEquals(expectedNumber,actualNumber);
    }@Test
    public void test02(){
        //-Test 2
        //1. Kategori menusunden Books secenegini secin
WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
Select select =new Select(dropDownMenu);
select.selectByVisibleText("Books");
// 2. Arama kutusuna Java yazin ve aratin
 WebElement searchBox=       driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
 searchBox.sendKeys("Java"+ Keys.ENTER);
        //  3. Bulunan sonuc sayisini yazdirin
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        System.out.println(sonucYaziElementi.getText());
       // Sonucun Java kelimesini icerdigini test edin
        String expectedIcerik="Java";
        String actualResult=sonucYaziElementi.getText();
        Assert.assertTrue(actualResult.contains(expectedIcerik));
//Assert.assertTrue();
    }




}
