package tests.day12;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.day10.C01_Allerts;
import utilities.TestBase;

public class C01_TestBaseKullanim {

    @Test
    public void test01(){
        //projeniz icerisindeki herhangi bir classtan obje oluşturabilir
        //ve obje sayesinde ait oldugu classdaki tum variable ve methodlara
        //(access modefier izin verdigi surece) ulaşabilirsiniz
        //eger proje kapsaminda bir clall dan obje oluşturulmasini engellemk isterseniz
        //1- o classin constructor ini private yapabiliriz
        //2- classin kendisini abstract yapabiliriz
        //1.method çok tercih edilmez cunku OOP consept e uymaz (çok sınırlı sayıda kullanımı vardır)
        //2. methodu kullanabiliriz böylece  o classdaki abstract olmayan (concrete)
        //methodlari override etmek mecburiyeti olmadan kullanabiliriz
        //ama obje oluşturamayiz

        // ornegin biz testBase class ini abstract yaptigimizdan obje oluşturamayiz
        //ama child classlardan TestBase deki setUp ve tearDown methodlarini kullanabilirz
        C01_Allerts obj= new C01_Allerts();
       // TestBase obj1= new TestBase();

    }
}
