package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JsExecuterClick extends TestBase {

    //amazon.com anasayfaya gidip
    // sell linkine JSExecuter ile tiklayalim
    //ilgili sayfaya gittigimizi test edelim

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        //1.adım: JsExecuter objesi olusturalim ve driver i cast edelim
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        //2.adım: iligili web elementi locate edelim
        WebElement sellElementi= driver.findElement(By.xpath("//a[normalize-space()='Sell']"));
        //3. adim: ilgili script ve argument(bizim web elementimiz) ile objemiz uzerinden
        // executeScript methodunu calistiralim
        jse.executeScript("arguments[0].click();",sellElementi);
        Thread.sleep(5000);

    }
}
