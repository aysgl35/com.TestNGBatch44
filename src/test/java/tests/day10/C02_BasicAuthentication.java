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

public class C02_BasicAuthentication {
    // Bir class olusturun : BasicAuthentication

   WebDriver driver;
   @BeforeClass
    public void setUp(){
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }
   @Test
    public void authenticationTesti(){
       // https://the-internet.herokuapp.com/basic_auth sayfasına gidin
       //driver.get("https://the-internet.herokuapp.com/basic_auth");
       //aşağıdaki yöntem ve test datalarını kullanarak aunhentication i yapin
       //Html komutu: https://username:password@URl
       // Username: admin
       // password : admin
       //basic authentication isteyen web servisleri bize nasil ve hangi bilgilerle authentication
       //yapabilecegimiz bilgisini de vermek zorundadır
       //biz de bize tarif edilen yöntem ve bize verilen bilgileri birebir uygulayarak
       //istedigimiz webservise giris saglayabiliriz.


       driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
       //Başarili şekilde sayfaya girildigini dogrulayın
       WebElement congratMesajElementi= driver.findElement(By.tagName("p"));
       Assert.assertTrue(congratMesajElementi.isDisplayed());

   }
   @AfterClass
    public void tearDown(){
       driver.close();
   }


}

