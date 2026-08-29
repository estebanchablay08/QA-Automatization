package com.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SauceDemoPages {
    public static final Target USERNAME_FIELD = Target.the("campo de usuario").located(By.id("user-name"));
    public static final Target PASSWORD_FIELD = Target.the("campo de contraseña").located(By.id("password"));
    public static final Target LOGIN_BUTTON = Target.the("botón de login").located(By.id("login-button"));

    // Productos
    public static final Target ADD_TO_CART_BACKPACK = Target.the("añadir mochila").located(By.id("add-to-cart-sauce-labs-backpack"));
    public static final Target ADD_TO_CART_BIKE_LIGHT = Target.the("añadir luz de bicicleta").located(By.id("add-to-cart-sauce-labs-bike-light"));

    public static final Target CART_ICON = Target.the("icono del carrito").located(By.className("shopping_cart_link"));
    public static final Target CHECKOUT_BUTTON = Target.the("botón checkout").located(By.id("checkout"));

    // Formulario de compra
    public static final Target FIRST_NAME = Target.the("nombre").located(By.id("first-name"));
    public static final Target LAST_NAME = Target.the("apellido").located(By.id("last-name"));
    public static final Target POSTAL_CODE = Target.the("código postal").located(By.id("postal-code"));
    public static final Target CONTINUE_BUTTON = Target.the("botón continuar").located(By.id("continue"));

    // Finalizar
    public static final Target FINISH_BUTTON = Target.the("botón finalizar").located(By.id("finish"));
    public static final Target SUCCESS_MESSAGE = Target.the("mensaje de confirmación").located(By.className("complete-header"));
}