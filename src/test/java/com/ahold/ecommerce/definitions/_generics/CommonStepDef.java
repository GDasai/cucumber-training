package com.ahold.ecommerce.definitions._generics;

import com.ahold.ecommerce.definitions.ah.checkout.CheckoutPage;
import com.ahold.ecommerce.definitions.ah.login.LoginPage;
import com.ahold.ecommerce.definitions.ah.ordering.OrderPage;
import com.ahold.ecommerce.driver.CukeConfigurator;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public class CommonStepDef extends BaseStepDef {

    private LoginPage loginPage;
    private OrderPage orderPage;
    private CheckoutPage checkoutPage;
    CukeConfigurator cukeconfig = new CukeConfigurator();

    @PostConstruct
    public void setUpLogin() {
        loginPage = PageFactory.initElements(webDriver, LoginPage.class);
    }

    @PostConstruct
    public void setUpOrder() {
        orderPage = PageFactory.initElements(webDriver, OrderPage.class);
    }

    @PostConstruct
    public void setUpCheckout() {
        checkoutPage = PageFactory.initElements(webDriver, CheckoutPage.class);
    }

    // navigate and login AH test environment
    @Gegeven("^dat gebruiker is ingelogd op een AH test omgeving")
    public void login_ah_testomgeving() {
        loginPage.navigateToEnvironment(cukeconfig.targetHostName);
        loginPage.loginAhEnvironment();
    }

    @En("^de gebruiker producten besteld")
    public void select_products() {
        orderPage.productSelection();
    }

    @Dan("rond de gebruiker af met een pup order")
    public void pup_checkout() {
        checkoutPage.orderProduct();
    }
}
