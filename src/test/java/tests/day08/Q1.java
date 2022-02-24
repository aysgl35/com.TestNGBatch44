package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Q1 {
    WebDriver driver;
    WebElement sonucYazsisiElementi;
    SoftAssert softAssert;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlert(){
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        sonucYazsisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucYazsisiElementi.getText();
        String expectedSonucYazisi="You successfully clicked an alert";
        softAssert=new SoftAssert();
        softAssert.assertEquals(actualSonucYazisi,expectedSonucYazisi);
    }
    @Test
    public void dismissAlert(){
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        sonucYazsisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucYazsisiElementi.getText();
        String exceptedSonucYazisi="successfuly";
        softAssert.assertFalse(actualSonucYazisi.contains(exceptedSonucYazisi));
    }
    @Test
    public void sendKeysAlert(){
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("username");
        driver.switchTo().alert().accept();
        sonucYazsisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucYazsisiElementi.getText();
        String exceptedSonucYazisi="username";
        softAssert.assertTrue(actualSonucYazisi.contains(exceptedSonucYazisi));
    }
    @AfterClass
    public void teardown() {
        softAssert.assertAll();
        driver.close();
    }
}
