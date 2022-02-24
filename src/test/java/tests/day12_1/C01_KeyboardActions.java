package tests.day12_1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeyboardActions extends TestBase {
    //Bir class olusturalim C01_KeyboardActions
    // https://www.amazon.com sayfasina gidelim
    // Arama kutusuna actions methodlarini kullanarak samsung A71 yazdirin
    // ve Enter a basarak arama yaptırın


    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions= new Actions(driver);
        /*actions.click(aramaKutusu).perform();
        actions.sendKeys("samsung").perform();
        actions.keyDown(Keys.SHIFT).perform();
        actions.sendKeys("a").perform();
        actions.keyUp(Keys.SHIFT).perform();
        actions.sendKeys("71").perform();
        actions.sendKeys(Keys.ENTER).perform();*/

        //simdiye kadar önce locate edip, o webelement uzerinden sendKeys yapiyorduk
        //aramaKutusu.sendKeys("samsung A71");

        //Yukarıdaki gibi uzun uzun yazmak yerine aşagıdaki gibi de yapabiliriz
        actions.click(aramaKutusu)
                .sendKeys("samsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();

        //Thread.sleep(5000);
        //actions.sendKeys(Keys.ENTER).perform();

        // aramanin gerçeklestigini test edin

        String arananKelime="samsung A71";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananKelime),"arama yapilamadı");



    }


}
