package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_Screenshot extends TestBase {

    @Test
    public void nutellaTest() throws InterruptedException, IOException {

        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        // nutella icin arama yapalim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonuclarin nutella icerdigini test edelim
        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        String sonucYazisiStr=sonucYazisiElementi.getText();
        Assert.assertTrue(sonucYazisiStr.contains("Nutella"));
        Thread.sleep(5000);
        //testin calistiginin ispati icin tum sayfanin screenshot ini alalim

        //1. adım: TakeSreenShot objesi olusturalim
        TakesScreenshot tss= (TakesScreenshot) driver;

        // 2. adım: kaydedecegimiz dosyayi olusturalim
        File tumSayfaSS= new File("target/screenShot/tumsayfa.png");

        //3. adım: bir dosya daha oluşturup sreenshot objesi ile sreenshot i alalim
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        //4. adım: gecici resmi kaydetmek istedigimiz asil dosyaya assign edelim. yani copy yapalim.
        FileUtils.copyFile(geciciResim,tumSayfaSS);

    }
}
