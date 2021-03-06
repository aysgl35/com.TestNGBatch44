package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {

    @Test
    public void facebookKayitTest() throws InterruptedException {
        //https://facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //"create new account " yani yeni hesah olustur dugmesine basani
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //"firstName" giris kutusuna bir isim yazin
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String email= faker.internet().emailAddress();

        actions.click(isimKutusu)
                .sendKeys(faker.name().name())

        //"surname" giris kutusuna bir soyisim yazin
      .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
        //"email" giris kutusuna bir email yazin
      .sendKeys(Keys.TAB).sendKeys(email)
      //"email" onay kutusuna ayni mail i tekrar yazin
                .sendKeys(Keys.TAB).sendKeys(email)
      //Bir şifre girin
        .sendKeys(Keys.TAB).sendKeys(faker.internet().password())
      //Tarih icin gun secin
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("15")
       //Tarih icin ay secin
                .sendKeys(Keys.TAB)
                .sendKeys("Jan")
       //Tarih icin yil secin
                .sendKeys(Keys.TAB)
                .sendKeys("1972")
       //Cinsiyet secin
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN).perform();
        // Işaretlediginiz cinsiyetin secili diger cinsiyet kutusunun secili olmadigini test edin
        WebElement erkekSecimElementi= driver.findElement(By.xpath("//input[@value='2']"));
        WebElement kadinSecimElementi= driver.findElement(By.xpath("//input[@value='1']"));
        Assert.assertTrue(erkekSecimElementi.isSelected());
        Assert.assertFalse(kadinSecimElementi.isSelected());
        Thread.sleep(10000);

    }
}
