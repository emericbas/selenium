package Homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class KeyboardActionGuzelSoru extends TestBase {
    /* 1- Bir Class olusturalim KeyboardActions2
 2- https://html.com/tags/iframe/ sayfasina gidelim
             3- video’yu gorecek kadar asagi inin
 4- videoyu izlemek icin Play tusuna basin
 5- videoyu calistirdiginizi test edin

     */
    @Test
    public void test01() {
        // 1- Bir Class olusturalim KeyboardActions2
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        String firstWindowHandle = driver.getWindowHandle();

        //3- video’yu gorecek kadar asagi inin
        //4- videoyu izlemek icin Play tusuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe [@width='560']"));
        driver.switchTo().frame(iframe);
        Actions actions = new Actions(driver);
        WebElement playButton = driver.findElement(By.xpath("//button [@aria-label='Play']"));
        actions.scrollToElement(playButton).perform();
        playButton.click();
        driver.switchTo().parentFrame();

        //5- videoyu calistirdiginizi test edin
        Set<String> windowsHandles = driver.getWindowHandles();
        String secondWindowHandle = "?";
        for (String each : windowsHandles
        ) {
            if (!each.equals(firstWindowHandle)) {
                secondWindowHandle = each;
            }
        }
        driver.switchTo().window(secondWindowHandle);
        String actualTitle = driver.getTitle();
        String expectedIcerik = "volcanoes";
        Assert.assertFalse(actualTitle.contains(expectedIcerik));
    }
}