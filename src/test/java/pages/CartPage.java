package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    @FindBy(id = "checkout")
    private WebElement checkoutButton;


    @Step("Нажатие на кнопку checkout")
    public CartPage clickCheckoutButton() {
        checkoutButton.click();
        return this;
    }


}
