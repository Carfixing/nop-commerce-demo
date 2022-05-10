package com.nopcommerce.demo.pages;


import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Jay Vaghani
 */
public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Log in']")
    WebElement loginLink;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement registerLink;

    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    WebElement nopCommerceLogo;

    @FindBy(xpath = "//a[normalize-space()='My account']")
    WebElement myAccountMenuLink;

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logoutLink;

    @FindBy(xpath = "//div[@class='header-menu']//li")
    public WebElement allMenuList;

    @FindBy (xpath = "(//a[normalize-space()='Computers'])[1]")
    WebElement computers;

    public void clickOnComputers(){
        clickOnElement(computers);
        CustomListeners.test.log(Status.PASS,"Click on Computers Tab");
    }
    public void selectMenu(String menu){

        List<WebElement> topMenuNames = driver.findElements(By.xpath("//div[@class='header-menu']//li"));
        for (WebElement names : topMenuNames){
            if (names.getText().equalsIgnoreCase(menu)){
                names.click();
                break;
            }
        }
    }

    public void clickOnLoginLink(){
        clickOnElement(loginLink);
    }
    public  void loginLinkDisplay(){
        verifyThatElementIsDisplayed(loginLink);
        CustomListeners.test.log(Status.PASS,"Verifying Login link is displayed");
    }
    public void clickOnRegisterLink(){
        clickOnElement(registerLink);
        CustomListeners.test.log(Status.PASS,"Clicking on Register Link");
    }
    public void clickMyAccountLink(){
        clickOnElement(myAccountMenuLink);
        CustomListeners.test.log(Status.PASS,"Clicking on Logout Link");
    }
    public void logoutLinkDisplayed(){
        verifyThatElementIsDisplayed(logoutLink);
        CustomListeners.test.log(Status.PASS,"Verifying logout link is displayed");
    }
    public void verifyNopCommerceLogo() {
        verifyThatElementIsDisplayed(nopCommerceLogo);
        CustomListeners.test.log(Status.PASS, "Verify Logo");
    }
//2.HomePage - All Menu (Seven menu), LoginLink, registerLink, nopcommerce logo, My
//account link and LogOut link locatores

}
