package tests.day12_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_MouseActions extends TestBase {
    @Test
    public void test(){
        //Yeni bir class olusturalim:C04_MouseActions
        //1- https://demoga.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- "Drag me" butonunu tutup "Drop here" kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement dragElementi= driver.findElement(By.id("draggable"));
        WebElement dropAlani= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragElementi,dropAlani).perform();


        //3- "Drop here" yazisi yerine "Dropped!" oldugunu test edin
        WebElement droppedYazisi= driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String actualDropped=droppedYazisi.getText();
        String expectedDropped="Dropped!";
        Assert.assertEquals(actualDropped,expectedDropped);

        //Aşagıdaki yöntem daha kısa
         /*String actualDroppedYazisi=dropAlani.getText();
         String expectedDroppedYazisi="Dropped!";
        Assert.assertEquals(actualDroppedYazisi,expectedDroppedYazisi);*/

    }

}
