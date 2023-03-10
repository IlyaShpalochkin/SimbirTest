package tests;

import chromeDriver.GetChromeDriver;
import constants.Constants;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthorizationPage;

@Epic("Тесты сайта saucedemo")

public class IncorrectLoginTest {

    protected WebDriver driver;

    private AuthorizationPage authorizationPage;


    @BeforeMethod
    public void driver() {
        driver = GetChromeDriver.getChromeDriver();
        driver.manage().window().maximize();
        authorizationPage = new AuthorizationPage(driver);
        driver.get(Constants.MAIN_PAGE);
    }

    @Severity(value = SeverityLevel.NORMAL)
    @Feature("Тесты авторизации")
    @Story("Неверная авторизация")
    @Test
    public void incorrectLoginTest() {
        authorizationPage.fillingUsernameInput("test")
                .fillingPasswordInput("test")
                .clickLoginButton()
                .waitingLoginOrPasswordNotMatchErrorVisible();
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

}
