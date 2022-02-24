package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Allerts {
    //Bir class olusturun: Alerts
    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin


    WebDriver driver;
    WebElement sonucYazisiElementi;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @Test
    public void acceptAlertTest(){
        //Bir metod olusturun: acceptAlert
        // 1.butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        //"You successfully clicked an alert" oldugunu test edin
         sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String expectedSonucYazisi="You successfully clicked an alert";
        Assert.assertEquals(actualSonucYazisi,expectedSonucYazisi);
    }
    @Test
    public void dismissAlertTest(){
    //Bir metod olusturun: dismissAlert
    // 2.butonu tıklayın, uyarıdaki Cancel butonunua tıklayın ve
       driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
       driver.switchTo().alert().dismiss();
    //result mesajının "successfuly" icermedigini test edin.
        sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String istenmeyenKelime="successfuly";
        Assert.assertFalse(actualSonucYazisi.contains(istenmeyenKelime));

    }
    @Test
    public void sendKeysAlertTest(){
      //Bir method olusturun: sendKeysAlert
      // 3.butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
      driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
      driver.switchTo().alert().sendKeys("Ayse");
      //OK butonuna tıklayın ve result mesajında isminizin görüntülendigini doğrulayın
        driver.switchTo().alert().accept();
        sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String yazdigimizIsim="Ayse";
        Assert.assertTrue(actualSonucYazisi.contains(yazdigimizIsim));
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }

}

