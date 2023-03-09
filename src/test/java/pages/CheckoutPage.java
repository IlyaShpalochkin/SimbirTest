package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.Waiting;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement zipCodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    private WebElement thankForOrderMessage;


    @Step("Ожидание появления сообщения: Thank you for your order!")
    public CheckoutPage checkThankForOrderMessageVisible() {
        Waiting.waitingElementDisplay(thankForOrderMessage, driver);
        return this;
    }

    @Step("Нажатие на кнопку Continue")
    public CheckoutPage clickContinueButton() {
        continueButton.click();
        return this;
    }

    @Step("Нажатие на кнопку Finish")
    public CheckoutPage clickFinishButton() {
        Waiting.waitingElementDisplay(finishButton, driver).click();
        return this;
    }

    @Step("Ввод данных в поле Zip/Postal Code")
    public CheckoutPage fillZipCodeInput(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
        return this;
    }

    @Step("Ввод данных в поле Last Name")
    public CheckoutPage fillLastNameInput(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    @Step("Ввод данных в поле Fist Name")
    public CheckoutPage fillFistNameInput(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }


}
