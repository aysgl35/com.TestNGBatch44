package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
//Iki tane metod olusturun: implicitWait(), explicitWait()
    @Test
    public void implicitlyWaitTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      //https://the-internet.herokuapp.com/dynamic_controls adresine gidin
      driver.get("https://the-internet.herokuapp.com/dynamic_controls"); ;
      //Remove butonuna basin
       driver.findElement(By.xpath("//button[.='Remove']")).click();
       //"It's gone!" mesajinin goruntulendigini dogrulayin
        WebElement itsGoneElementi= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());
      //Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
       //7. It's back mesajinin gorunduğunu test edin
        WebElement itsBackElementi= driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackElementi.isDisplayed());

    }
    @Test
    public void explicitlyWaitTest() throws InterruptedException {
    //explicitly Wait nadiren kullanilir
     //https://the-internet.herokuapp.com/dynamic_controls adresine gidin
          driver.get("https://the-internet.herokuapp.com/dynamic_controls");
     //explicitly wait kullanabilmek icin önce wait objesi olusturmaliyiz
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        //      //Remove butonuna basin
        driver.findElement(By.xpath("//button[.='Remove']")).click();
      //"It's gone!" mesajinin görüntülendigini dogrulayin

       // WebElement itsGoneElementi= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        //wait.until(ExpectedConditions.visibilityOf(itsGoneElementi));
        /* ***** her ne kadar üstteki gibi kodun anlaşılır olması icin önce locate edelim sonra bekleyelim yaklaşimi
        güzel görünse de web element zaten görünür olmadıgından locate etmemiz de mumkun olmayacaktir
        bu durumda locate ve bekleme işlemini beraber yapmak gerekir.******
         */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        WebElement itsGoneElementi= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());
        Thread.sleep(3000);
        // Add butonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        // It's back mesajinin gorunduğunu test edin
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
               WebElement itsBackElementi= driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
                Assert.assertTrue(itsBackElementi.isDisplayed());
    }

}
