package com.nopcommerce.demo.testsuite;


import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani
 */

public class LoginPageTest extends TestBase {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
    }

     //1.userShouldNavigateToLoginPageSuccessFully().
    //Click on login link
    //verify that "Welcome, Please Sign In!" message display
    @Test
    public void userShouldNavigateToLoginPageSuccessFully(){
        //Click on login link
        loginPage.clickonLogInLink();
        //verify that "Welcome, Please Sign In!" message display
        String expectedResult = "Welcome, Please Sign In!";
        String actualResult = loginPage.verifyWelcomePleaseSignIn();
        Assert.assertEquals(actualResult, expectedResult, "Result not found");
    }
  //2. verifyTheErrorMessageWithInValidCredentials().
    //Click on login link
    //Enter EmailId
    //Enter Password
    //Click on Login Button
    //Verify that the Error message
    @Test
    public void verifyTheErrorMessageWithInValidCredentials(){
        //Click on login link
        loginPage.clickonLogInLink();
        //Enter EmailId
        loginPage.enterYourEmailAddress("Prime123@gmial.com");
        //Enter Password
        loginPage.enterYourPassword("prime123");
        //Click on Login Button
        loginPage.clickOnLogInButton();
        //Verify that the Error message
        String expectedResult = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualResult = loginPage.verifyErrorMessage();
        Assert.assertEquals(actualResult, expectedResult, "Result not found");
    }
    //3. verifyThatUserShouldLogInSuccessFullyWithValidCredentials.
    //Click on login link
    //Enter EmailId
    //Enter Password
    //Click on Login Button
    //Verify that LogOut link is display
    @Test
    public void  verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        //Click on login link
        loginPage.clickonLogInLink();
        //Enter EmailId
        loginPage.enterYourEmailAddress("Prime123@gmial.com");
        //Enter Password
        loginPage.enterYourPassword("prime123");
        //Click on Login Button
        loginPage.clickOnLogInButton();
        //Verify that the Error message
//        String expectedResult = "";
//        String actualResult = loginPage.verifyErrorMessage();
//        Assert.assertEquals(actualResult, expectedResult, "Result not found");
    }
    //4. VerifyThatUserShouldLogOutSuccessFully()
    //Click on login link
    //Enter EmailId
    //Enter Password
    //Click on Login Button
    //Click on LogOut Link
    //Verify that LogIn Link Display
    @Test
    public void VerifyThatUserShouldLogOutSuccessFully(){
        //Click on login link
        loginPage.clickonLogInLink();
        //Enter EmailId
        loginPage.enterYourEmailAddress("Prime123@gmial.com");
        //Enter Password
        loginPage.enterYourPassword("prime123");
        //Click on Login Button
        loginPage.clickOnLogInButton();
        //Verify that LogIn Link Display
    }

}
