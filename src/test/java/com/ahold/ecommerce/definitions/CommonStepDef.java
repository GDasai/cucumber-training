package com.ahold.ecommerce.definitions;

import com.ahold.ecommerce.definitions.cookienotice.CookieNoticePage;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public class CommonStepDef extends BaseStepDef {

    private BasePage basePage;

    @PostConstruct
    public void setUp() {
        basePage = PageFactory.initElements(webDriver, CookieNoticePage.class);
    }

    /* Sample for ah.nl
    @Gegeven("^gebruiker is op Appie Today omgeving \"([^\"]*)\"$")
    public void open_appie_today_website(String environment) {
        basePage.navigateToEnvironment(environment);
    }

    @Gegeven("^de gebruiker heeft de cookies geaccepteert")
    public void accepteren_cookie_melding() {
        basePage.addCookie("cookie_agreed", "true");
        basePage.refreshPage();
        basePage.isCookieNoticeVisible();
        basePage.buttonClick("accept-cookies");
    }
    */
}
