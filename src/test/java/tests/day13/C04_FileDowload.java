package tests.day13;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDowload extends TestBase {
    //Iki tane metod olusturun:isExist() ve downloadTest()
    // downloadTest() methodu icinde aşagıdaki testi yapalim
    // https://the-internet.herokuapp.com/dowload adresine gidelim
    // code.txt dosyasını indirelim
    // ardından isExist() methodunda dosyanın başarıyla indirilip indirilmedigini test edelim

    //class ı çalistirdigimizda alfabetik siraya göre çaliştigi için önce downloadTest()
    //methodu çalişir sonra isExistTest() methodu çalisir
    @Test
    public void isExistTest() {
        String dosyaYolu=System.getProperty("user.home")+"\\Downloads\\download.jpg";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[text()='download.jpg']")).click();
        Thread.sleep(5000);
    }
}
