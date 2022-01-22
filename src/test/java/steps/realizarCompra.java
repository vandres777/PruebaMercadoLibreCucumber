package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class realizarCompra {
	WebDriver driver;

	@Given("^Abro navegador en modo incognito$")
	public void abro_navegador_en_modo_incognito() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		// System.out.println("Navegador se abre en modo incognito");

	}

	@When("^Me encuentro en la pagina de mercado libre y acepto cookies$")
	public void me_encuentro_en_la_pagina_de_mercado_libre() {
		driver.manage().window().maximize();
		driver.navigate().to("https://www.mercadolibre.com.co/");
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Mercado Libre Colombia - Envíos Gratis en el día";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		String title = driver.getTitle();
		System.out.println("El título de la página es:" + title);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//button[normalize-space()='Entendido'])[1]")).click();
	}

	@Then("^Busco el producto monitor$")
	public void busco_el_producto_monitor() {
		driver.findElement(By.name("as_word")).sendKeys("monitor pc 27 pulgadas");
		driver.findElement(By.xpath("//button/div")).click();
		driver.findElement(By.partialLinkText("Samsung Cf390 Series 27 ''monitor De Escritorio Curvado")).click();
	}

	@Then("^Una vez seleccionado el producto voy a comprarlo como cliente nuevo$")
	public void una_vez_seleccionado_el_producto_voy_a_comprarlo_como_cliente_nuevo() {
		driver.findElement(By.xpath("//span[normalize-space()='Comprar ahora']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Soy nuevo']")).click();
	}

	@And("^Lleno el formulario e ingreso (.*) (.*) (.*) (.*)$")
	public void lleno_el_formulario_e_ingreso_andres_y_leon(String firstName, String lastName, String email,
			String password) throws InterruptedException {

		// Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));

		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@Then("^Acepto terminos y condiciones$")
	public void acepto_terminos_y_condiciones() throws InterruptedException {
		driver.findElement(By.xpath("//label[contains(text(),'Acepto los')]")).click();
	}

	@And("^Valido si aparece captcha$")
	public void valido_si_aparece_captcha() {

		if (driver.findElements(By.xpath("//label[@id='recaptcha-anchor-label']")).size() != 0) {
			System.out.println("Element present");
		} else
			System.out.println("Element not present");

	}

	@Then("^Hago clic en continuar$")
	public void hago_clic_en_continuar() {
		driver.findElement(By.xpath("//span[@class='andes-button__content']")).click();

	}

}