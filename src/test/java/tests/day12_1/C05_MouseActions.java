package tests.day12_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_MouseActions extends TestBase {

    @Test
    public void test(){
     // https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");
     //sag ust bolumde bulunan "Account & Lists" menusunun acilmasi icin mouse u bu menunun üstüne getirelim
        WebElement liste= driver.findElement(By.xpath("//span[.='Hello, Sign in']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(liste).perform();
     //"Create a list" butonuna basalim
        driver.findElement(By.xpath("//span[.='Create a List']")).click();
     // Acilan sayfada "Your Lists" yazisi oldugunu test edelim
        WebElement yourListYazisi= driver.findElement(By.xpath("//li[@class='a-tab-heading a-active a-size-large']"));
        Assert.assertTrue(yourListYazisi.isEnabled());



        //Aşagıdaki gibi de yapılabilir hatta daha kolay bir yol
        /*String actualtitle= driver.getTitle();
        String arananMetin="Your List";
        Assert.assertTrue(actualtitle.contains(arananMetin));*/

    }

}
