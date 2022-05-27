package tests;

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

public class DependsOnMethods {

  /*  Bir class oluşturun: DependsOnTest
● https://www.amazon.com/ adresine gidin.
            1. Test : Amazon ana sayfaya gittiginizi test edin
2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    arama yapin ve aramanizin gerceklestigini Test edin
3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
    $16.83 oldugunu test edin

   */

    WebDriver driver;
    static String title;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    /*  @AfterClass
      public void tearDown(){

          driver.quit();
      }

     */
    @Test
    public void test1() {

        driver.get("https://www.amazon.com/");

        Assert.assertTrue(driver.findElement(By.xpath("//html")).isEnabled());
    }

    @Test(dependsOnMethods = "test1")
    public void test2() {

        WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        search.sendKeys("Nutella" + Keys.ENTER);


    }

}