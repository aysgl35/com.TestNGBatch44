package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_DepenceOnMethods {

    //Bir class olusrun DepenceOnTest



    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void logoTest(){
        //https://www.amazon.com/ adresine gidin
        // 1.Test: Amazon ana sayfaya gittiginizi test edin
        driver.get("https://www.amazon.com/");
        WebElement logoElementi=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElementi.isDisplayed());

    }
    @Test(dependsOnMethods = "logoTest")
    public void aramaTesti(){
        // 2. Test:1.Test basarili ise search Box i kullanarak "Nutella" icin
        //arama yapin ve aramanızın gercekleştigini test edin
       WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        String actualTitle= driver.getTitle();
        String arananKelime="Nutella";
        Assert.assertTrue(actualTitle.contains(arananKelime));
    }
   @Test(dependsOnMethods = "aramaTesti")
    public void fiyat(){
        //3.Test "Nutella" icin arama yapıldiysa
        // ilk urunu tiklayin ve fiyatinin $16.83 oldugunu test edin
        WebElement ilkUrun= driver.findElement(By.xpath("//span[text()='Nutella Chocolate Hazelnut Spread, Perfect Topping for Pancakes, Great for Holiday Recipes, 26.5 oz']"));
        ilkUrun.click();
        WebElement fiyatElementi= driver.findElement(By.xpath("//span[@class='a-size-base a-color-price']"));
        String arananFiyat="$14.99";
        String actualFiyat=fiyatElementi.getText();
        Assert.assertTrue(actualFiyat.contains(arananFiyat));

    }

}
