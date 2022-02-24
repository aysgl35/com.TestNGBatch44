package tests.day14;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_Screenshot extends TestBase {

    @Test
    public void ScreenshotTest() throws IOException {
        driver.get("https://google.com");
    //TakesScreenshot interface oldugu icin obje oluşturamiyoruz
    //1. adım: ama aşagıdaki gibi casting yaparak obje oluşturabilirz
        TakesScreenshot tss= (TakesScreenshot) driver;

   /* //2. adım: tum sayfanın sreenshot ını almak icin bir File olusturalim ve
    //dosya yolunu belirtelim

     File tumSayfaSS= new File("src//tumSayfa.png");
     //3. adım: olusturdugumuz file ile takessreenshot objesini ilişkilendirelim
        tumSayfaSS=tss.getScreenshotAs(OutputType.FILE);

     //spesifik bir webelementin sreenshot ini almak istiyorsanız
        WebElement logoElementi= driver.findElement(By.xpath("(//img[@alt='Google'])[1]"));
        File logoResmi=new File("src/logo.png");
        logoResmi=logoElementi.getScreenshotAs(OutputType.FILE);*/

        //!!!DİKKAT YUKARIDAKİ ADIMLARLA OLMADI AŞAGIDAKİLERLE İSLEM BAŞARILI

        // 2. adım: kaydedecegimiz dosyayi olusturalim
        File tumSayfaSS1= new File("target/screenShot/tumsayfa1.png");

        //3. adım: bir dosya daha oluşturup sreenshot objesi ile sreenshot i alalim
        File geciciResim1=tss.getScreenshotAs(OutputType.FILE);
        //4. adım: gecici resmi kaydetmek istedigimiz asil dosyaya assign edelim. yani copy yapalim.
        FileUtils.copyFile(geciciResim1,tumSayfaSS1);
    }
}
