package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeyboardActions extends TestBase {

    @Test
    public void test(){
        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //video yu görecek kadar aşagı inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //video yu izlemek icin Play tusuna basin
       WebElement iframeElementi= driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
       driver.switchTo().frame(iframeElementi);
        //video yu calistirdiginizi test edin
        WebElement playTusu=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        actions.click(playTusu).perform();
        WebElement pouseTusu=driver.findElement(By.xpath("//button[@title='Duraklat (k)']"));
        Assert.assertTrue(pouseTusu.isEnabled());
       // Assert.assertFalse(playTusu.isDisplayed());
        //button[@class='ytp-play-button ytp-button']
    }
}
