package tests;

import chromeDriver.GetChromeDriver;
import constants.Constants;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.MainPage;

@Epic("Тесты сайта saucedemo")
public class SuccessBuyTest {
    protected WebDriver driver;
    private AuthorizationPage authorizationPage;
    private MainPage mainPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void driver() {
        driver = GetChromeDriver.getChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.MAIN_PAGE);
        authorizationPage = new AuthorizationPage(driver);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        authorizationPage.fillingUsernameInput("standard_user")
                .fillingPasswordInput("secret_sauce")
                .clickLoginButton();
    }

    @Severity(value = SeverityLevel.NORMAL)
    @Feature("Тесты на главной странице")
    @Story("Проверка успешной покупки")
    @Test
    public void successBuyTest() {
        mainPage.clickAddToCardButton()
                .clickCartButton();
        cartPage.clickCheckoutButton();
        checkoutPage.fillFistNameInput("test")
                .fillLastNameInput("test")
                .fillZipCodeInput("test")
                .clickContinueButton()
                .clickFinishButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html","Открыта не та страница");
        checkoutPage.checkThankForOrderMessageVisible();
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
}
