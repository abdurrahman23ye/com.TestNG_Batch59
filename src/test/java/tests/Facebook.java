package tests;

import org.testng.annotations.Test;
import pages.FacebookPage;
import utulities.Driver;

public class Facebook {

    @Test
    public static void facebookTest(){

        Driver.getdriver().get("https://www.facebook.com");

        FacebookPage facebookObje=new FacebookPage();

        facebookObje.facebookGiris.sendKeys("dadsa");
    }
}
