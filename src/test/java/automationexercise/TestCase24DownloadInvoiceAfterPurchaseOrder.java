package automationexercise;

import automationexercise.pages.*;
import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Random;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class TestCase24DownloadInvoiceAfterPurchaseOrder extends TestBase {
    private static final Logger logger = LogManager.getLogger(TestCase1RegisterUser.class);

    @Test
    void downloadInvoiceAfterPurchaseOrder() {
        String randomEmail = "max" + new Random().nextInt() + "@bialoleka.poland";

        logger.info("Open main page of website");
        open("http://automationexercise.com");

        StartPage startPage = new StartPage();
        logger.info("Verify that home page is visible successfully");
        step("Verify that home page is visible successfully", () -> {
            startPage.sliderLoginPage.shouldBe(Condition.visible);
            startPage.buttonProducts.click();
        });
        logger.info("Add products to cart and click button Cart");
        step("Add products to cart and click button Cart", () -> {
            startPage.addItemToCartByName(TestData.PRODUCT_NAME);
            startPage.buttonViewCart.click();
        });

        CartPage cartPage = new CartPage();
        logger.info("Verify that cart page is displayed, click proceed to checkout, click 'Register / Login' button");
        step("Verify that cart page is displayed, click proceed to checkout, click 'Register / Login' button", () -> {
            cartPage.titleShoppingCart.shouldHave(Condition.text("Shopping Cart"));
            cartPage.buttonProceedToCheckout.click();
            cartPage.popupButtonRegisterOrLogin.click();
        });

        LoginPage loginPage = new LoginPage();
        logger.info("Verify 'New User Signup!' is visible");
        step("Verify 'New User Signup!' is visible", () -> {
            loginPage.titleSignup.shouldHave(Condition.text("New User Signup!"));
        });
        logger.info("Enter name and email address");
        step("Enter name and email address", () -> {
            loginPage.signupName.setValue(TestData.SIGNUP_NAME);
            loginPage.signupEmail.setValue(randomEmail);
            loginPage.buttonSignup.click();
        });

        AccountInformationPage accountInformationPage = new AccountInformationPage();
        logger.info("Fill details: Title, Name, Email, Password, Date of birth");
        step("Fill details: Title, Name, Email, Password, Date of birth", () -> {
            accountInformationPage.titleAccountInformationPage.shouldHave(Condition.text("ENTER ACCOUNT INFORMATION"));
            accountInformationPage.buttonGender.click();
            accountInformationPage.signupName.setValue(TestData.SIGNUP_NAME);
            accountInformationPage.userPassword.setValue(TestData.USER_PASSWORD);
            accountInformationPage.dayOfBirth.selectOption(TestData.DAY_OF_BIRTH);
            accountInformationPage.monthOfBirth.selectOption(TestData.MONTH_OF_BIRTH);
            accountInformationPage.yearOfBirth.selectOption(TestData.YEAR_OF_BIRTH);
        });
        logger.info("Select checkbox about newsletter and offers from partners");
        step("Select checkbox about newsletter and offers from partners", () -> {
            accountInformationPage.checkboxNewsletter.scrollTo().click();
            accountInformationPage.checkboxOffersFromPartners.click();
        });
        logger.info("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
        step("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number", () -> {
            accountInformationPage.firstName.setValue(TestData.SIGNUP_NAME);
            accountInformationPage.lastName.setValue(TestData.USER_LAST_NAME);
            accountInformationPage.company.setValue(TestData.NAME_OF_COMPANY);
            accountInformationPage.firstAddress.setValue(TestData.FIRST_ADDRESS);
            accountInformationPage.secondAddress.setValue(TestData.SECOND_ADDRESS);
            accountInformationPage.country.selectOption(TestData.COUNTRY);
            accountInformationPage.state.setValue(TestData.STATE);
            accountInformationPage.city.setValue(TestData.CITY);
            accountInformationPage.zipcode.setValue(TestData.ZIPCODE);
            accountInformationPage.mobileNumber.setValue(TestData.MOBILE_NUMBER);
            accountInformationPage.buttonCreateAccount.scrollTo().click();
        });

        logger.info("Verify that 'ACCOUNT CREATED!' is visible");
        step("Verify that 'ACCOUNT CREATED!' is visible", () -> {
            AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
            accountCreatedPage.titleAccountCreated.shouldHave(Condition.text("ACCOUNT CREATED!"));
            accountCreatedPage.buttonContinue.click();
        });

        UserMenuPage userMenuPage = new UserMenuPage();
        logger.info("Verify that 'Logged in as username' is visible and click button Cart");
        step("Verify that 'Logged in as username' is visible and click button Cart", () -> {
            userMenuPage.getElementByText("Max").shouldHave(Condition.visible);
            userMenuPage.buttonCart.click();
        });

        logger.info("Click proceed to checkout");
        step("Click proceed to checkout", () -> {
            cartPage.buttonProceedToCheckout.click();
        });

        CheckoutPage checkoutPage = new CheckoutPage();
        logger.info("Verify Address Details and Review Your Order");
        step("Verify Address Details and Review Your Order", () -> {
            checkoutPage.addressItemBox.shouldHave(Condition.text(TestData.SIGNUP_NAME),
                    Condition.text(TestData.USER_LAST_NAME),
                    Condition.text(TestData.NAME_OF_COMPANY),
                    Condition.text(TestData.FIRST_ADDRESS),
                    Condition.text(TestData.SECOND_ADDRESS),
                    Condition.text(TestData.CITY),
                    Condition.text(TestData.STATE),
                    Condition.text(TestData.ZIPCODE),
                    Condition.text(TestData.COUNTRY),
                    Condition.text(TestData.MOBILE_NUMBER));
            checkoutPage.productDetails.shouldHave(Condition.text(TestData.PRODUCT_NAME));
        });
        logger.info("Enter description in comment text area and click 'Place Order'");
        step("Enter description in comment text area and click 'Place Order'", () -> {
            checkoutPage.textAreaForComment.setValue(TestData.COMMENT_FOR_ORDER);
            checkoutPage.buttonPlaceOrder.click(ClickOptions.usingJavaScript());
        });

        PaymentPage paymentPage = new PaymentPage();
        logger.info("Enter payment details: Name on Card, Card Number, CVC, Expiration date, click 'Pay and Confirm Order' button");
        step("Enter payment details: Name on Card, Card Number, CVC, Expiration date, click 'Pay and Confirm Order' button", () -> {
            paymentPage.inputNameOnCard.setValue(TestData.NAME_ON_CARD);
            paymentPage.inputCardNumber.setValue(TestData.CARD_NUMBER);
            paymentPage.inputCVC.setValue(TestData.CVC);
            paymentPage.inputExpiryMonth.setValue(TestData.EXPIRY_MONTH);
            paymentPage.inputExpiryYear.setValue(TestData.EXPIRY_YEAR);
            paymentPage.buttonPayAndConfirmOrder.click();
        });

        OrderPlacedPage orderPlacedPage = new OrderPlacedPage();
        logger.info("Verify success message 'Congratulations! Your order has been confirmed!'");
        step("Verify success message 'Congratulations! Your order has been confirmed!'", () -> {
           orderPlacedPage.successMessage.shouldHave(Condition.text("Congratulations! Your order has been confirmed!"));
        });
        logger.info("Click 'Download Invoice' button and verify invoice is downloaded successfully");
        step("Click 'Download Invoice' button and verify invoice is downloaded successfully", () -> {
            File invoice = orderPlacedPage.buttonDownloadInvoice.download();
            Assertions.assertTrue(invoice.length() > 0);
        });
        logger.info("Click 'Continue' button");
        step("Click 'Continue' button", () -> {
            orderPlacedPage.buttonContinue.click();
        });

        logger.info("Click 'Delete Account' button");
        step("Click 'Delete Account' button", () -> {
            userMenuPage.buttonDelete.click();
        });

        logger.info("Verify that 'ACCOUNT DELETED!'and click 'Continue' button");
        step("Verify that 'ACCOUNT DELETED!'and click 'Continue' button ", () -> {
            FinishPage finishPage = new FinishPage();
            finishPage.titleAccountDeleted.shouldHave(Condition.text("ACCOUNT DELETED!"));
            finishPage.buttonContinue.click();
        });







    }
    }
