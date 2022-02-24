package tests.day09;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class deneme {
    @Test
    public void test(){

        int a=20;
        int b=20;
        int c=30;
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(a,b,"1.test");
        softAssert.assertTrue(a>b,"2.test");
        softAssert.assertFalse(c>b,"3.test");
        softAssert.assertAll();
    }
}
