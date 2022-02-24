package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropdown {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


    }
    @Test
    public void dropdownTest() throws InterruptedException {
    //Dropdown da var olan seceneklerden birini secmek icin
    //1.adım:Dropdown dan webelement locate edip bir degiskene atiyoruz
    driver.get("https://www.amazon.com");
        WebElement dropdownElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
    //2.adim: Select class ından bir obje olusturalım
    // ve parametre olarak locate ettigimiz webelementi yazalim
    Select select=new Select(dropdownElementi);
    select.selectByIndex(3);
    //3.adim select objesini kullanarak, Select class inda var olan 3 secim methodundan
    //istedigimizi kullanarak dropdown da var olan option lardan birini secebilirz
    //secim yapmamiza yardım eden bu 3 method voiddir dolayisiyla bize bir sey döndürmezler
    //eger sectigimiz option degerini yaztırmak istersek
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(3000);
        select.selectByVisibleText("Deals");
        select.selectByValue("search-alias=arts-crafts-intl-ship");
        List<WebElement> optionList=select.getOptions();
        for (WebElement each:optionList){
            System.out.println(each.getText());
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
