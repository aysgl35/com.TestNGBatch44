package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_Iframe {
    //Bir class olusturun: IframeTest

     WebDriver driver;
     @BeforeClass
    public void setUp(){
         WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

     }
     @Test
    public void iFrameTest(){
         // https://the-internet.herokuapp.com/iframe adresine gidin
         driver.get("https://the-internet.herokuapp.com/iframe");
         // Bir method oluşturun:iframeTest
         // "An IFrame containing... ." tesxtinin erişilebilir oldugunu test edin ve konsola yazdırın.
         WebElement istenenYaziElementi=driver.findElement(By.tagName("h3"));
         SoftAssert softAssert= new SoftAssert();
         softAssert.assertTrue(istenenYaziElementi.isEnabled(),"Iframe yazisi gorunmuyor");
         System.out.println(istenenYaziElementi.getText());
         // TextBox a "Merhaba Dunya!" yazin.
         // yazı yazmak istedigimiz text kutusu iframe in icinde oldugundan direkt ulaşamiyoruz
         // önce iframe i locate edip, onun icine switch yapmaliyiz
         WebElement iFrame=driver.findElement(By.tagName("iframe"));
         driver.switchTo().frame(iFrame);
         WebElement textBox=driver.findElement(By.tagName("p"));
         textBox.clear();
         textBox.sendKeys("Merhaba Dunya");
         // TextBox in altinda bulunan "Elemental Selenium" linkini

         //yukarida iframe icine switch yaptigimizdan yeniden disari cıkmak istedigimizde
         //ana sayfaya dönmeliyiz
         driver.switchTo().defaultContent();
         driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
         // yeni sayfada "Sponsored by Sauce Labs" textinin gorunur oldugunu dogrulayin ve konsola yazdırın.

         //sponsored yazisi yeni sayfada oldugundan ve driver eski sayfada kaldigindan yaziyi locate edemedik



         WebElement sponsoredYazisiElementi= driver.findElement(By.xpath("//p[text()='Sponsored by'] "));
         softAssert.assertTrue(sponsoredYazisiElementi.isDisplayed(),"Sponsored yazisi görünmüyor");
         softAssert.assertAll();
     }
     @AfterClass
    public void tearDown(){
         driver.quit(); // iki sayfa oldugu icin
     }

}
