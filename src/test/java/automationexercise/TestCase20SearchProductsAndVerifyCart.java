package automationexercise;

import automationexercise.pages.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestCase20SearchProductsAndVerifyCart extends TestBase {
    private static final Logger logger = LogManager.getLogger(TestCase1RegisterUser.class);

    @Test
    void searchProductsAndVerifyCart() {

        logger.info("Open main page of website");
        open("http://automationexercise.com");

        StartPage startPage = new StartPage();
        logger.info("Verify that home page is visible successfully");
        step("Verify that home page is visible successfully", () -> {
            startPage.sliderLoginPage.shouldBe(Condition.visible);
            startPage.buttonProducts.click();
        });

        ProductsPage productsPage = new ProductsPage();
        logger.info("Verify user is navigated to ALL PRODUCTS page successfully");
        step("Verify user is navigated to ALL PRODUCTS page successfully", () -> {
            productsPage.titleAllProducts.shouldHave(Condition.text("ALL PRODUCTS"));
        });
        logger.info("Enter product name in search input and click search button");
        step("Enter product name in search input and click search button", () -> {
            productsPage.searchInput.setValue(TestData.PRODUCT_NAME);
            productsPage.buttonSearch.click();
        });

        SearchResultPage searchResultPage = new SearchResultPage();
        logger.info("Verify 'SEARCHED PRODUCTS' is visible");
        step("Verify 'SEARCHED PRODUCTS' is visible", () -> {
            searchResultPage.titleSearchedProducts.shouldHave(Condition.text("SEARCHED PRODUCTS"));
        });
        logger.info("Verify all the products related to search are visible");
        step("Verify all the products related to search are visible", () -> {
            searchResultPage.searchedProductName.shouldHave(Condition.text(TestData.PRODUCT_NAME));
            searchResultPage.buttonAddToCart.click();
        });
        logger.info("Verify all the products related to search are visible, add and go to cart");
        step("Verify all the products related to search are visible, add and go to cart", () -> {
            searchResultPage.searchedProductName.scrollTo().shouldHave(Condition.text(TestData.PRODUCT_NAME));
            searchResultPage.buttonAddToCart.click();
            searchResultPage.buttonViewCart.click();
        });

        CartPage cartPage = new CartPage();
        logger.info("Verify that products are visible in cart and click 'Signup / Login' button");
        step("Verify that products are visible in cart", () -> {
            cartPage.productsDescriptionInCart.shouldHave(Condition.text(TestData.PRODUCT_NAME));
            cartPage.buttonSignupOrLogin.click();
        });

        LoginPage loginPage = new LoginPage();
        logger.info("Submit login details");
        step("Submit login detail", () -> {
            loginPage.loginEmail.setValue(TestData.LOGIN_EMAIL);
            loginPage.loginPassword.setValue(TestData.USER_PASSWORD);
            loginPage.buttonLogin.click();
        });

        logger.info("Go to Cart page");
        step("Go to Cart page", () -> {
            startPage.buttonCart.click();
        });

        logger.info("Verify that those products are visible in cart after login as well");
        step("Verify that those products are visible in cart after login as well", () -> {
            cartPage.productsDescriptionInCart.shouldHave(Condition.text(TestData.PRODUCT_NAME));
        });
    }
}
