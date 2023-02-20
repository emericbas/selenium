package JUnitFramework;

import utilities.TestBaseClass;

public class DropDownMenu extends TestBaseClass {
    /* ● https://the-internet.herokuapp.com/dropdown adresine gidin.
            1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
            3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
 4.Tüm dropdown değerleri(value) yazdırın
 5. Dropdown’un boyutunun 4 oldugunu test edin

   */
   /* @Test
    public void test01(){
/Bir class oluşturun: DropDown
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement select= driver.findElement(By.id("dropdown"));
        Select select1=new Select(select);
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select1.selectByIndex(1);
        System.out.println(select1.getFirstSelectedOption().getText());
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select1.selectByValue("2");
        System.out.println(select1.getFirstSelectedOption().getText());
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select1.selectByVisibleText("Option 1");
        //4.Tüm dropdown değerleri(value) yazdırın
        //List<WebElement> options = select1.getOptions();
        for (WebElement each:select1.getOptions()
        ) {
            System.out.println(each.getText());
        }
        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
        //degilse False yazdırın.

        int expectedElement=4;
        int actualSize = select1.getOptions().size();
        Assert.assertEquals(actualSize,expectedElement);

    */


}
