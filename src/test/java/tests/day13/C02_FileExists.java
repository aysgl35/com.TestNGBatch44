package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {
    @Test
    public void test01(){
        System.out.println(System.getProperty("user.home"));
        //masaustundeki Proje klasorunun Path ini istesem
        //C:\Users\Ayşe\Desktop\projeler

        //Yani dinamik olarak masaustundeki Proje klasorunun path ini yazmak istersem
        String path=System.getProperty("user.home")+"Desktop\\projeler";
        System.out.println(path);
        System.out.println(System.getProperty("user.dir"));//C:\javademos\com.TestNGBatch44
            //user.dir benim projemin yolunu veriyor
     //Masaustunde projeler klasörü icerisnde test isminde dosya oldugunu test edin
        //***********masaustunde projeler klasoru ve icinde test olmazsa çalısmaz***********************
        //1. önce bu dosyaya ulasmak icin gerekli dinamik path olusturalim
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\projeler\\test";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//true
        //projemizde pom.xml oldugunu test edin
        //C:\javademos\com.TestNGBatch44\pom.xml
        String pomPath=System.getProperty("user.dir")+"\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(pomPath)));//Test Passed

    }
}
