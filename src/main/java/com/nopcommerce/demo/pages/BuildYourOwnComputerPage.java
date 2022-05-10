package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.smartcardio.Card;

public class BuildYourOwnComputerPage extends Utility {

    //5.BuildYourOwnComputerPage - Build your own computer Text, Processor Drop Down, Ram
    //drop down,
    //HDD radios, os radio, software check boxes, Add To Card button, "The product has been
    //added to your shopping cart"
    //message locators and it's actions

    public BuildYourOwnComputerPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[contains(text(),'Build your own computer')]")
    WebElement buildYourOwnComputerText;

    @FindBy(xpath = "//select[@id='product_attribute_1']")
    WebElement processorDropDown;

    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement ramDropDown;

    @FindBy (xpath = "(//ul[@class='option-list'])[1]")
    WebElement hddRadios400;

    @FindBy (xpath = "(//ul[@class='option-list'])[2]")
    WebElement osRadio;

    @FindBy (xpath = "(//ul[@class='option-list'])[3]")
    WebElement software;

    @FindBy (xpath = "//button[@id='add-to-cart-button-1']")
    WebElement addToCartButton;

    @FindBy (xpath = "//p[@class='content']")
    WebElement verifyProductHasBeenAddedMessage;

    public void verifyBuildYourOwnComputerText() {
        verifyThatTextIsDisplayed(buildYourOwnComputerText, "Build your own computer");
        CustomListeners.test.log(Status.PASS, "Build your own computer text displayed ");
    }

    public void selectProcessorFromDropDown(String text) {
        selectByVisibleTextFromDropDown(processorDropDown, text);
        CustomListeners.test.log(Status.PASS, "Select a Processor " + text);
    }

    public void selectRAMFromDropDown(String text) {
        selectByVisibleTextFromDropDown(ramDropDown, text);
        CustomListeners.test.log(Status.PASS, "Select RAM " + text);
    }

    public void selectHDDRadioButton(String text) {
        clickOnElement(hddRadios400);
        CustomListeners.test.log(Status.PASS, "Select HDD " + text);
    }

    public void selectOSRadioButton(String text) {
        clickOnElement(osRadio);
        CustomListeners.test.log(Status.PASS, "Select Operating system " + text);
    }

    public void selectSoftwareCheckBox(String text) {
        clickOnElement(software);
        CustomListeners.test.log(Status.PASS, "Select a Software " + text);
    }

    public void clickAddToCart() {
        clickOnElement(addToCartButton);
        CustomListeners.test.log(Status.PASS, "Add to cart ");
    }

    public void verifyAddToCartText() {
        verifyThatTextIsDisplayed(verifyProductHasBeenAddedMessage, "The product has been added to your shopping cart");
        CustomListeners.test.log(Status.PASS, "Verify Add to cart ");
    }

    //    public void selectParts(String processor, String ram, String hdd, String os, String software) {
//        selectProcessorFromDropDown(processor);
//        selectRAMFromDropDown(ram);
//        selectHDDRadioButton(hdd);
//        selectOSRadioButton(os);
//        selectSoftwareCheckBox(software);
//    }
    public void buildConfigurationFromList(String processor, String ram, String hdd, String os, String software1){
        selectByVisibleTextFromDropDown(processorDropDown, processor);
        selectByVisibleTextFromDropDown(ramDropDown, ram);
        clickOnElement(hddRadios400);
        clickOnElement(osRadio);
        clickOnElement(software);
        CustomListeners.test.log(Status.PASS, "Selecting processor "+processor +"<br>");
        CustomListeners.test.log(Status.PASS, "Selecting RAM "+ram+"<br>");
        CustomListeners.test.log(Status.PASS, "Clicking HDD RadioButton "+hdd+"<br>");
        CustomListeners.test.log(Status.PASS, "Clicking Operating System RadioButton "+os+"<br>");
        CustomListeners.test.log(Status.PASS, "Checking software checkboxes "+software+"<br>");


    }
}
