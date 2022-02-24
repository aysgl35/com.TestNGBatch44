package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_JsExecuterScrooIntolView extends TestBase {
    // hotelmycamp anasayfasina gidin
    // 2 farkli test methodu olusturarak actions clasi ve Js Executor kullanarak aşagidaki oda
    // turlerinden ust sira
    // istediginiz oda inceleme sayfasi acildigini test edin
    @Test
    public void scroolAction() throws InterruptedException {
        driver.get("https://www.hotelmycamp.com");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        driver.findElement(By.xpath("(//a[@class='btn-custom'])[1]")).click();
        Thread.sleep(5000);
    }
    @Test
    public void scroolJsExecutor() throws InterruptedException {
        driver.get("https://www.hotelmycamp.com");
        //1.adim JsExecutor objesi olustur ve driver i cast et
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        //2.adim calisacigimiz webelementi locate edelim
        WebElement odaInceleLinki=driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));
        //3.adım ilgili script ve argument ile jse.executeScript() calistir
        jse.executeScript("arguments[0].scrollIntoView(true);",odaInceleLinki);
        Thread.sleep(5000);
        jse.executeScript("arguments[0].click();",odaInceleLinki);
        Thread.sleep(5000);



    }
}
