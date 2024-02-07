package automationexercise.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class UserMenuPage {
    public SelenideElement getElementByText(String text){
        return $(byText(text));
    }
    public SelenideElement buttonDelete = $("[href='/delete_account']");
    public SelenideElement buttonLogout = $("[href='/logout']");
    public SelenideElement buttonCart = $("[href='/view_cart']");
}
