package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class realizarCompra {
	WebDriver driver;

	@Given("^abro navegador en modo incognito$")
	public void abro_navegador_en_modo_incognito() {
		System.out.println("Navegador se abre");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);

	}

	@When("^me encuentro en la pagina de mercado libre$")
	public void me_encuentro_en_la_pagina_de_mercado_libre() {
		driver.manage().window().maximize();
		driver.navigate().to("https://www.mercadolibre.com.co/");
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Mercado Libre Colombia";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		System.out.println("se abre la página");
		String title = driver.getTitle();
		System.out.println("El título de la página es:" + title);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Then("^busco el producto monitor$")
	public void busco_el_producto_monitor() {
		driver.findElement(By.name("as_word")).sendKeys("monitor pc 27 pulgadas");
		driver.findElement(By.xpath("//button/div")).click();
		driver.findElement(By.partialLinkText("Monitor gamer curvo ViewSonic VX2768-PC-mhd led 27")).click();
	}

	@Then("^una vez seleccionado el producto voy a comprarlo como cliente nuevo$")
	public void una_vez_seleccionado_el_producto_voy_a_comprarlo_como_cliente_nuevo() {
		driver.findElement(By.xpath(
				"//button[@class='andes-button andes-button--loud']//span[@class='andes-button__content'][normalize-space()='Comprar ahora']"))
				.click();
		driver.findElement(By.xpath("//a[normalize-space()='Soy nuevo']")).click();
	}

	
	
	@Then("^lleno el formulario e ingreso (.*) (.*) (.*) (.*)$")
		public void lleno_el_formulario_e_ingreso_andres_y_leon(String firstName, String lastName, String email,String password) throws InterruptedException {
		
Thread.sleep(1000);
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));*/

		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
	}
	@Then("acepto terminos y condiciones")
	public void acepto_terminos_y_condiciones() {
		driver.findElement(By.xpath("//label[contains(text(),'Acepto los')]")).click();
	}
	@Then("^hago clic en continuar$")
	public void hago_clic_en_continuar() {
		driver.findElement(By.xpath("//span[@class='andes-button__content']")).click();

	}

}