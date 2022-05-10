package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ComputerPage extends Utility {
    //3.ComputerPage - Comuters text, DesktopsLink, NotebooksLink, SoftwareLink Locators
    //and create appropriate methods for it.
    public ComputerPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h2[@class='title']/a[@href='/desktops']")
    WebElement desktopLink;
    @FindBy(xpath = "//h1[contains(text(),'Desktop')]")
    WebElement deskTopText;
    @FindBy(xpath = "//h1[contains(text(),'Computers')]")
    WebElement computerText;
    @FindBy(xpath = "//h2[@class='title']/a[@href='/notebooks']")
    WebElement notebooksLink;
    @FindBy(xpath = "//h2[@class='title']/a[@href='/software']")
    WebElement softwareLink;

    public String verifyComputerText() {
        CustomListeners.test.log(Status.PASS, "Navigate to computer page and verify navigated page welcome text " + computerText);
        return computerText.getText();

    }

    public String getDesktopNavigationText() {
        CustomListeners.test.log(Status.PASS, "Navigate to Desktop page and verify navigated page welcome text " + deskTopText);
        return deskTopText.getText();
    }

    public void clickOnDesktop() {
        CustomListeners.test.log(Status.PASS, "Click on desktop option " + desktopLink);
        mouseHoverToElementAndClick(desktopLink);
    }

    public void clickOnNotebooks() {
        CustomListeners.test.log(Status.PASS, "Click on desktop option " + notebooksLink);
        mouseHoverToElementAndClick(notebooksLink);
    }

    public void clickOnSoftware() {
        CustomListeners.test.log(Status.PASS, "Click on desktop option " + softwareLink);
        mouseHoverToElementAndClick(softwareLink);
    }

}