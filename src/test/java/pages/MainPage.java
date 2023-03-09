package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    @FindBy(xpath = "(//button[text()='Add to cart'])[1]")
    private WebElement addToCartFirstProductButton;

    @FindBy(css = "a[class*='shopping_cart']")
    private WebElement cartButton;

    @Step("Нажатие на кнопку для перехода в корзину")
    public MainPage clickCartButton() {
        cartButton.click();
        return this;
    }


    @Step("Нажатие на кнопку add to cart первого продукта")
    public MainPage clickAddToCardButton() {
        addToCartFirstProductButton.click();
        return this;
    }
}
