package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

public class FacebookPage {

    public FacebookPage(){

        PageFactory.initElements(Driver.getdriver(),this);
    }

@FindBy(xpath = "//input[@type='text']")
    public WebElement facebookGiris;
}
