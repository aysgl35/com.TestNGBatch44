package tests.day12_1;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions extends TestBase {

    @Test
    public void test(){
   //1. Yeni bir class olusturalim: C03_MouseActions
   //2. https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3. cizili alan üzerine sag click yapalim
        Actions actions=new Actions(driver);
        WebElement ciziliAlan= driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlan).perform();
    //4. Alert te cikan yazinin "You selected a context menu" oldugunu test edelim

    String expectedAlertYazisi="You selected a context menu";
    String actualAlertYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi,"alert yazisi beklenenden farkli");
    //5. Tamam diyerek alert i kapatalim
        driver.switchTo().alert().accept();
    //6. Elemental Selenium linkine tiklayin
        String ilkSayfaHandle= driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
    //7. Acilan sayfada h1 taginda"Elemental Selenium" yazdigini test edelim
    Set<String> handles=driver.getWindowHandles();
    String ikinciSayfaHandle="";
    for(String each:handles){
        if (!each.equals(ilkSayfaHandle)){
            ikinciSayfaHandle=each;
        }
    }
    driver.switchTo().window(ikinciSayfaHandle);
    String expectedIkinciSayfaYazisi="Elemental Selenium";
    String actualIkinciSayfaYazisi=driver.findElement(By.tagName("h1")).getText();
    Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi,"ikinci sayfa istenenden farkli");
    }
}
