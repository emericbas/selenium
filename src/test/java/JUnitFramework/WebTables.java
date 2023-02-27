package JUnitFramework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class WebTables extends TestBase {
    /*1."https://www.amazon.com" adresine gidin
2.Sayfanin en altina inin
3.Web table tum body’sini yazdirin
4.Web table’daki satir sayisinin 9 oldugunu test edin
5.Tum satirlari yazdirin
6. Web table’daki sutun sayisinin 13 olduğunu test edin
7. 5.sutunu yazdirin
8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi
döndüren bir method olusturun
9. 7.satirinin, 9.datasinin "Shoes" icerdigini test edin
     */
    @Test
    public void test01() throws InterruptedException {

// 1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");

//2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();

//3.Web table tum body’sini yazdirin
      //  WebElement tumBody=driver.findElement(By.xpath("//tbody"));
       WebElement tumBody=driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[4]/table"));
        System.out.println(tumBody.toString());

//4.Web table’daki satir sayisinin 10 oldugunu test edin
        List<WebElement> satirlarLIstesi=driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(10,satirlarLIstesi.size());

//5.Tum satirlari yazdirin
        int satirSayisi=1;
        for (WebElement each:satirlarLIstesi
             ) {
            System.out.println(satirSayisi+"--"+each.getText());
            satirSayisi++;
        }

//6. Web table’daki sutun sayisinin 13 olduğunu test edin
      List<WebElement>ucuncuSatirDatalarList=driver.findElements(By.xpath("//tbody/tr[3]/td"));
        Assert.assertEquals(13,ucuncuSatirDatalarList.size());

//7. 5.sutunu yazdirin
        System.out.println("=====5.Sutun====");
        int basliksayisi=1;
       List<WebElement>besinciSutunListesi=driver.findElements(By.xpath("tbody/tr/td[5]"));
        for (WebElement eachdata:besinciSutunListesi
             ) {
            System.out.println(basliksayisi+"--"+eachdata.getText());
            basliksayisi++;
        }

       //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi
//döndüren bir method olusturun
        System.out.println("istenen data :\n"+getData(3, 5));

     //   9. 7.satirinin, 9.datasinin "Shoes" icerdigini test edin
       String  actualData= getData(7,9);
       String expectedData="Shoes";
       Assert.assertTrue(actualData.contains(expectedData));
    }
    public  String getData(int satirNo,int sutunNo){
        //3.satir, 5. sutun'daki bilgiyi getirin
        //    //tbody/tr[3]/td[5]

String dataXpath="//tbody/tr["+ satirNo + "]/td["+sutunNo +"]";
    String istenenData=driver.findElement(By.xpath(dataXpath)).getText();
    return istenenData;
    }
}
