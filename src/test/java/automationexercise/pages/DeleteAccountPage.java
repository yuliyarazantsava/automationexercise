package automationexercise.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DeleteAccountPage {
    public SelenideElement getElementByText(String text){
        return $(byText(text));
    }
    public SelenideElement buttonDelete = $("[href='/delete_account']");
}
