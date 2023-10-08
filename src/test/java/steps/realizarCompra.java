package steps;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.Assert;
import io.cucumber.java.en.*;

import java.util.concurrent.TimeUnit;

public class realizarCompra {
    WebDriver driver;

    @Before
    @Given("^Abro navegador en modo incognito$")
    public void Abro_navegador_en_modo_incognito() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Navegador se abre en modo incógnito");

    }

    @When("^Me encuentro en la página de Mercado Libre y acepto cookies$")
    public void me_encuentro_en_la_pagina_de_mercado_libre_y_acepto_cookies() {
        driver.navigate().to("https://www.mercadolibre.com.co/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Mercado Libre Colombia - Envíos Gratis en el día";
        Assert.assertEquals(expectedTitle, actualTitle);
        System.out.println("El título de la página es: " + actualTitle);
        WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[normalize-space()='Aceptar cookies']"));
        acceptCookiesButton.click();
    }

    @Then("^Busco el producto monitor$")
    public void busco_el_producto_monitor() {
        driver.findElement(By.name("as_word")).sendKeys("monitor pc 27 pulgadas");
        WebElement searchButton = driver.findElement(By.xpath("//button/div"));
        searchButton.click();
        WebElement laterButton = driver.findElement(By.xpath("//span[normalize-space()='Más tarde']"));
        laterButton.click();
WebElement monitorLink = driver.findElement(By.xpath("(//h2[@class='ui-search-item__title'][contains(text(),'27')])[1]"));
        monitorLink.click();
    }

    @Then("^Una vez seleccionado el producto voy a comprarlo como cliente nuevo$")
    public void una_vez_seleccionado_el_producto_voy_a_comprarlo_como_cliente_nuevo() {
        WebElement buyNowButton = driver.findElement(By.xpath("//span[normalize-space()='Comprar ahora']"));
        buyNowButton.click();
        driver.navigate().refresh();
        WebElement createAccountButton = driver.findElement(By.xpath("//span[normalize-space()='Crear cuenta']"));
        createAccountButton.click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().refresh();
        WebElement createPersonalAccountButton = driver.findElement(By.xpath("//span[normalize-space()='Crear cuenta personal']"));
        createPersonalAccountButton.click();
    }

    @And("^Diligencio el formulario de registro con (.*) (.*) (.*) (.*)$")
    public void diligencio_el_formulario_de_registro_con(String firstName, String lastName, String email, String password) {
        driver.navigate().refresh();
        WebElement agregarButton = driver.findElement(By.xpath("//span[@class=\"andes-button__text\"]"));
        agregarButton.click();
        driver.navigate().refresh();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(email);
        WebElement policiesCheckbox = driver.findElement(By.xpath("//input[@id='policies']"));
        policiesCheckbox.click();
        WebElement continueButton = driver.findElement(By.xpath("//span[@class='andes-button__content']"));
        continueButton.click();

    }

    @Then("se cierra el navegador automaticamente")
    public void se_cierra_el_navegador_automaticamente() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.close();
        /*if (driver != null) {
            driver.quit();
        }*/
    }
}
