package com.nopcommerce.demo.testsuite;


import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.DesktopPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

/**
 * Created by Jay Vaghani
 */

public class ComputerPage extends TestBase {

    HomePage homePage;
    com.nopcommerce.demo.pages.ComputerPage computerPage;
    DesktopPage desktopPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        computerPage=new com.nopcommerce.demo.pages.ComputerPage();
        desktopPage=new DesktopPage();
        buildYourOwnComputerPage=new BuildYourOwnComputerPage();
    }
    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully(){
        homePage.clickOnComputers();
        String expectedText="Computers";
        String actualText=computerPage.verifyComputerText();
        Assert.assertEquals(actualText,expectedText,"Computers text not displayed");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        homePage.clickOnComputers();
        computerPage.clickOnDesktop();
        String expectedText="Desktops";
        String actualText=computerPage.getDesktopNavigationText();
        Assert.assertEquals(actualText,expectedText,"Desktops text not displayed");
    }
    @Test(groups = {"regression"}, dataProvider = "AddToCart",dataProviderClass = TestData.class)
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) throws InterruptedException {
        homePage.clickOnComputers();
        computerPage.clickOnDesktop();
        desktopPage.clickOnBuildYourOwnComputer();
        buildYourOwnComputerPage.buildConfigurationFromList(processor, ram, hdd, os, software);
        buildYourOwnComputerPage.clickAddToCart();
        Thread.sleep(2000);
        buildYourOwnComputerPage.verifyBuildYourOwnComputerText();
    }

}
