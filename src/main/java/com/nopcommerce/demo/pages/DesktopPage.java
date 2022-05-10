package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopPage extends Utility {
    //4.DesktopPage - Desktops text, Sortby, Display, selectProductList Locators and it's actions

    public DesktopPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='page-title']")
    WebElement desktopText;

    @FindBy(xpath = "//select[@id='products-orderby']")
    WebElement sortBy;

    @FindBy(xpath = "//select[@id='products-pagesize']")
    WebElement displayBy;

    @FindBy(xpath = "//div[@class='product-viewmode']")
    WebElement selectProductList;

    @FindBy (xpath = "(//button[@type='button'][normalize-space()='Add to cart'])[1]")
    WebElement buildYourOwnComputer;

    public void clickOnBuildYourOwnComputer (){
        clickOnElement(buildYourOwnComputer);
        CustomListeners.test.log(Status.PASS, "Click on build you own computer ");
    }

    public void verifyDesktopText(String text){
        verifyThatTextIsDisplayed(desktopText, text);
        CustomListeners.test.log(Status.PASS, "Desktop text " + text);
    }
    public void sortByProduct(){
        clickOnElement(sortBy);
        CustomListeners.test.log(Status.PASS, "Sortby Product");
    }
    public void displayByProduct(){
        clickOnElement(displayBy);
        CustomListeners.test.log(Status.PASS, "Display by product ");
    }
    public void selectProductFromList(){
        clickOnElement(selectProductList);
        CustomListeners.test.log(Status.PASS, "Select product from List ");
    }

}


