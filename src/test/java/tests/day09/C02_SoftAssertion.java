package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C02_SoftAssertion {
    //Yeni bir Class Olusturun : C03_SoftAssert
    //1. “http://zero.webappsecurity.com/” Adresine gidin
    //2. Sign in butonuna basin
    //3. Login kutusuna “username” yazin
    //4. Password kutusuna “password” yazin
    //5. Sign in tusuna basin
    //6. Pay Bills sayfasina gidin
    //7. “Purchase Foreign Currency” tusuna basin
    //8. “Currency” drop down menusunden Eurozone’u secin
    //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
    //"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China
    //(yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong
    //(dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand
    //(dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
    //Test NG
    //Soft Assert Class Work
    //Yeni bir Class Olusturun : D11_SoftAssert1
    //1. “https://www.hepsiburada.com/” Adresine gidin
    //2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayi


    WebDriver driver;
    WebElement dropdownElementi;
    Select select;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void test01(){
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //3. Login kutusuna “username” yazin
        WebElement loginElementi= driver.findElement(By.xpath("//input[@id='user_login']"));
        loginElementi.sendKeys("username");
        //4. Password kutusuna “password” yazin
        WebElement passwordElementi= driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordElementi.sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.navigate().back();
        //6. Online Banking menusu icinde Pay Bills sayfasina gidin
                driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
                driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
       dropdownElementi=driver.findElement(By.xpath("//select[@id='pc_currency']"));
         select= new Select(dropdownElementi);
        select.selectByValue("EUR");

        //9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert= new SoftAssert();
        String actualSecim= select.getFirstSelectedOption().getText();
        String expectedSecim="Eurozone (euro)";
        softAssert.assertEquals(actualSecim,expectedSecim,"Dropdown dogru secilemedi");

        //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        //"Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China
        //(yuan)", "Denmark (krone)","Eurozone (euro)", "Great Britain (pound)", "Hong Kong
        //(dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)", "New Zealand
        //(dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"
        List<WebElement> aptionList= select.getOptions();
        String actualOptionListesiStringOlarak="";
        for(WebElement each: aptionList){
            actualOptionListesiStringOlarak+="\"" + each.getText() + "\",";
        }
        actualOptionListesiStringOlarak=actualOptionListesiStringOlarak.substring(0,actualOptionListesiStringOlarak.length()-2);
        String expectedListeStringOlarak="\"Select One\",\"Australia (dollar)\",\"Canada (dollar)\",\"Switzerland (franc)\",\"China (yuan)\",\"Denmark (krone)\",\"Eurozone (euro)\",\"Great Britain (pound)\",\"Hong Kong (dollar)\",\"Japan (yen)\",\"Mexico (peso)\",\"Norway (krone)\",\"New Zealand (dollar)\",\"Sweden (krona)\",\"Singapore (dollar)\",\"Thailand (baht)";
        softAssert.assertEquals(actualOptionListesiStringOlarak,expectedListeStringOlarak);
        softAssert.assertAll();

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
