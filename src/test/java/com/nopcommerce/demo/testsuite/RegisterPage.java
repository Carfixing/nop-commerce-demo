package com.nopcommerce.demo.testsuite;


import com.google.common.base.Verify;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegisterPage extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    com.nopcommerce.demo.pages.RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new com.nopcommerce.demo.pages.RegisterPage();

    }
    @Test(groups = {"sanity","regression", "smoke"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        homePage.clickOnRegisterLink();
        registerPage.verifyRegisterPageText("Register");

    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        homePage.clickOnRegisterLink();
        registerPage.registerButtonClick();
        registerPage.verifyFirstNameErrorMessage("First name is required");
        registerPage.verifyLastNameErrorMessage("Last name is required");
        registerPage.verifyEmailErrorMessage("Email is required");
        registerPage.verifyPasswordErrorMessage("Password is required");
        registerPage.verifyConfirmPasswordErrorMessage("Password is required");
    }
    @Test(groups = {"regression"})
    public void verifyThatUsersShouldCreateAccountSuccessfully(){
        homePage.clickOnRegisterLink();
        registerPage.selectGender("Female");
        registerPage.firstNameClick("kajal");
        registerPage.lastNameClick("Patel");
        registerPage.selectDateOfBirth("19","june","1918");
        registerPage.enterEmailId(("Prime123@gmail.com"));
        registerPage.passwordClick("Prime321");
        registerPage.confirmPasswordClick("Prime321");
        registerPage.registerButtonClick();
        registerPage.verifyRegisterPageText(" Your registration is completed");
    }
}
