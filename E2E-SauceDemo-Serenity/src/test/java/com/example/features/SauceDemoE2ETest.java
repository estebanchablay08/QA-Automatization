package com.example.features;

import com.example.ui.SauceDemoPages;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@ExtendWith(SerenityJUnit5Extension.class)
public class SauceDemoE2ETest {

    private final Actor esteban = Actor.named("Esteban");
    private WebDriver herBrowser;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-autofill-keyboard-access-accessory");
        options.addArguments("--remote-allow-origins=*");

        options.addArguments("--user-data-dir=C:\\temp\\chrome-profile-" + System.currentTimeMillis());

        java.util.Map<String, Object> prefs = new java.util.HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);

        herBrowser = new ChromeDriver(options);
        esteban.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void flujoDeCompraCompletoEnSauceDemo() {
        esteban.attemptsTo(
                Open.url("https://www.saucedemo.com/"),
                Enter.theValue("standard_user").into(SauceDemoPages.USERNAME_FIELD),
                Enter.theValue("secret_sauce").into(SauceDemoPages.PASSWORD_FIELD),
                Click.on(SauceDemoPages.LOGIN_BUTTON),

                Click.on(SauceDemoPages.ADD_TO_CART_BACKPACK),
                Click.on(SauceDemoPages.ADD_TO_CART_BIKE_LIGHT),

                Click.on(SauceDemoPages.CART_ICON),
                Click.on(SauceDemoPages.CHECKOUT_BUTTON),

                Enter.theValue("Esteban").into(SauceDemoPages.FIRST_NAME),
                Enter.theValue("TestE2E").into(SauceDemoPages.LAST_NAME),
                Enter.theValue("123456").into(SauceDemoPages.POSTAL_CODE),
                Click.on(SauceDemoPages.CONTINUE_BUTTON),

                Click.on(SauceDemoPages.FINISH_BUTTON)
        );

        esteban.attemptsTo(
                Ensure.that(SauceDemoPages.SUCCESS_MESSAGE).text().isEqualToIgnoringCase("Thank you for your order!")
        );
    }
}