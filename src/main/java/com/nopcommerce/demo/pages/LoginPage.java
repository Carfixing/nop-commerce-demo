package com.nopcommerce.demo.pages;


import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Jay Vaghani
 */
public class LoginPage extends Utility {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    //1.LoginPage - Email, password, Login Button and "Welcome, Please Sign In!" text Locators
    //and create appropriate methods for it.
    @FindBy(xpath ="//a[normalize-space()='Log in']")
    WebElement clickloginlink;
    @FindBy(xpath= "//h1[normalize-space()='Welcome, Please Sign In!']")
    WebElement verifywelcome;
    @FindBy(xpath="//input[@id='Email']")
    WebElement enterEmail;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement enterPassword;
    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement clickLOgInBtn;
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement verifyErrormsg;

    //***********************************************************

    public void clickonLogInLink(){
        clickOnElement(clickloginlink);
    }
    public String verifyWelcomePleaseSignIn(){
        return getTextFromElement(verifywelcome);
    }
    public void enterYourEmailAddress(String email){
        sendTextToElement(enterEmail ,email);
    }
    public void enterYourPassword(String password){ sendTextToElement(enterPassword,password);}
    public void clickOnLogInButton(){
        clickOnElement(clickLOgInBtn);
    }
    public String verifyErrorMessage(){
        return getTextFromElement(verifyErrormsg);
    }
}
