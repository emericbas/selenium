package Homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class WebTables extends TestBase {
    /*Bir Class olusturun D19_WebtablesHomework
1. “https://demoqa.com/webtables” sayfasina gidin
2. Headers da bulunan basliklari yazdirin
3. 3.sutunun basligini yazdirin
4. Tablodaki tum datalari yazdirin
5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
6. Tablodaki satir sayisini yazdirin
7. Tablodaki sutun sayisini yazdirin
8. Tablodaki 3.kolonu yazdirin
9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
sayisini girdigimde bana datayi yazdirsin

     */
    @Test
    public void test01(){

//    1. “https://demoqa.com/webtables” sayfasina gidin
driver.get("https://demoqa.com/webtables");

//     2. Headers da bulunan basliklari yazdirin
List<WebElement> titles=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
int sayi=1;
        for (WebElement each:titles
             ) {
            System.out.println(sayi+"--"+each.getText());
            sayi++;

        }

//3. 3.sutunun basligini yazdirin
        System.out.println(driver.findElement(By.xpath("//div[@class='rt-resizer']")).getText());

//4. Tablodaki tum datalari yazdirin
        System.out.println(driver.findElement(By.xpath("//div[@class='ReactTable -striped -highlight']")).getText());

//5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
       List<WebElement>allCell=driver.findElements(By.xpath("//div[@class='rt-td']"));
       int count=0;
        for (WebElement each:allCell
             ) {
            if(!each.getText().isEmpty()){
                count++;
            }

        }
        System.out.println("bos olmayan hucre sayisi: "+count);
//6. Tablodaki satir sayisini yazdirin
        List<WebElement> rows=driver.findElements(By.xpath("rt-tr-group"));
        System.out.println(rows.size());

//7. Tablodaki sutun sayisini yazdirin
        List<WebElement>sutunSayisi=driver.findElements(By.xpath("//div[@class=\"rt-th rt-resizable-header -cursor-pointer\"]"));
        System.out.println(sutunSayisi.size());

//8. Tablodaki 3.kolonu yazdirin

//9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println(driver.findElement(By.xpath("//div[@class='rt-tr-group'][3]/div/div[5]")).getText());

//            10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
//    sayisini girdigimde bana datayi yazdirsin
        System.out.println(getData(1,4));
    }
    public  String getData(int satirNo,int sutunNo){
        String dataXpath="//div[@class='rt-tbody']/div["+satirNo+"]/div/div["+sutunNo+"]";
        String istenenData = driver.findElement(By.xpath(dataXpath)).getText();
        return istenenData;
    }
}