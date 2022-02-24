package tests.day12_1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_KeyboardActions extends TestBase {

   @Test
   public void test(){
       //1.Bir class oluşturduk
      //2. https://html.com/tags/iframe/ sayfasina gidelim
      driver.get("https://html.com/tags/iframe/");

      //3.video yu gorecek kadar aşagı inin
      Actions actions=new Actions(driver);
      actions.sendKeys(Keys.PAGE_DOWN).perform();
      //4.video yu izlemek icin play tuşuna basin
      WebElement iFrame= driver.findElement(By.className("lazy-loaded"));
      driver.switchTo().frame(iFrame);
     // driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
      WebElement playTusu=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
     actions.click(playTusu).perform();

      //5. videoyu calistirdiginizi test edin
      Assert.assertFalse(playTusu.isDisplayed());
   }
}
