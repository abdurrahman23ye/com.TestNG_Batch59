package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Priority191 {

 /* 1) Bir class oluşturun: YoutubeAssertions
2) https://www.youtube.com adresine gidin
            3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
            ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

  */
    WebDriver driver;
   static String title;


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }



    @Test(priority=1)
    public void test1(){
        driver.get("https://www.youtube.com");
         title=driver.getTitle();

        Assert.assertTrue(title.equals("YouTube"));}

    @Test(priority=2)
    public void test2(){

        Assert.assertTrue(driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]")).isDisplayed());}


    @Test(priority=3)
    public void test3(){

        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='search']")).isEnabled());}

    @Test(priority=4)
    public void test4(){

        Assert.assertFalse(title.equals("youTube"));}



}

