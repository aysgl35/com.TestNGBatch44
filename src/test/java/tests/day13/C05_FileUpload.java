package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    @Test
    public void test01(){

        // https://the-internet.herokuapp.com/upload adresine gidin
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        //yuklemek istediginiz dosayayi secelim
        //1. File secme butonunu locate edelim
        WebElement filesecButonu=driver.findElement(By.id("file-upload"));
        //2 yukleyecegimiz dosyanin dinamik yolunu hazırlayalım

        String dosyaYolu=System.getProperty("user.home")+"\\Documents\\Bel1.docx";
        //sendKeys() ile dinamik path i dosya sec butonuna yollayalim
        filesecButonu.sendKeys(dosyaYolu);
        // Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //"File Uploaded" textinin görüntülendigini test edin
        WebElement sonucYazisiElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sonucYazisiElementi.isDisplayed());

    }
}
