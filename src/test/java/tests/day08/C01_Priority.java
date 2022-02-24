package tests.day08;

import org.testng.annotations.Test;

public class C01_Priority {


    @Test(priority = -9)
    public void youtubeTest(){
        System.out.println("Youtube testi calisti");
    }
    @Test(priority = 8)
    public void amazonTest(){
        System.out.println("Amazon testi calisti");
    }
    @Test //priority yoksa default 0 dir.
    public void bestBuyTest(){
        System.out.println("Bestbuy testi çalisti");
    }
}
