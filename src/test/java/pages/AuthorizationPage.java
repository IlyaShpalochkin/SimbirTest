package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.Waiting;

import static org.openqa.selenium.support.PageFactory.initElements;

public class AuthorizationPage {
    private WebDriver driver;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    @FindBy(css = "[placeholder='Username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@data-test='password']")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "(//button[text()='Add to cart'])[1]")
    private WebElement addToCartFirstProductButton;

    @FindBy(css = "a[class*='shopping_cart']")
    private WebElement cartButton;

    @FindBy(xpath = "//h3[contains(text(),'Epic sadface: Username and password do not match')]")
    private WebElement loginOrPasswordNotMatchError;

    @Step("Ожидание пяовлеия ошибки: Epic sadface: Username and password do not match any user in this service")
    public AuthorizationPage waitingLoginOrPasswordNotMatchErrorVisible() {
        Waiting.waitingElementDisplay(loginOrPasswordNotMatchError, driver);
        return this;
    }

    @Step("Нажатие на кнопку Login")
    public AuthorizationPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Ввод данных в инпут Username")
    public AuthorizationPage fillingUsernameInput(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    @Step("Ввод данных в инпут Password")
    public AuthorizationPage fillingPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }


}
