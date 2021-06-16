package steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

public class TesteSelleniumSteps {

	public WebDriver driver;
	WebDriverWait wait;

	String Engine = "1500";
	String Date = "10/05/2010";
	String Price = "55000";
	String Mileage = "1500";
	String Firstname = "Lafaiete";
	String Lastname = "Machado";
	String Birthdate = "06/22/1982";
	String Zipcode = "05180330";
	String Startdate = "06/16/2022";
	String Email = "lafaiete.machado@gmail.com";
	String Username = "lafaiete.machado";
	String Password = "Abcd1234";
	String Confirmpass = "Abcd1234";
	
	
	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Dado("que estou na pagina da aplicacao")
	public void que_estou_na_pagina_da_aplicacao() {
		driver.get("http://sampleapp.tricentis.com/101/app.php");
		driver.findElement(By.id("nav_automobile")).click();
		Assert.assertTrue((driver.findElement(By.id("selectedinsurance")).getText().contains("Automobile Insurance")));

	}

	@Dado("preencho a aba Vehicle Data")
	public void preencho_a_aba_vehicle_data() {
		WebElement make = driver.findElement(By.id("make"));
		Select select = new Select(make);
		select.selectByVisibleText("BMW");

		driver.findElement(By.name("[kW]")).sendKeys(Engine);

		driver.findElement(By.id("dateofmanufacture")).sendKeys(Date);

		WebElement seats = driver.findElement(By.id("numberofseats"));
		select = new Select(seats);
		select.selectByVisibleText("5");

		WebElement fuel = driver.findElement(By.id("fuel"));
		select = new Select(fuel);
		select.selectByVisibleText("Petrol");

		driver.findElement(By.id("listprice")).sendKeys(Price);

		driver.findElement(By.id("annualmileage")).sendKeys(Mileage);
		
		driver.findElement(By.id("nextenterinsurantdata")).click();
		
	}

	@Dado("preencho a aba Insurant Data")
	public void preencho_a_aba_insurant_data() {
		driver.findElement(By.id("firstname")).sendKeys(Firstname);

		driver.findElement(By.id("lastname")).sendKeys(Lastname);

		driver.findElement(By.id("birthdate")).sendKeys(Birthdate);

		WebElement country = driver.findElement(By.id("country"));
		Select select = new Select(country);
		select.selectByVisibleText("Brazil");

		driver.findElement(By.id("zipcode")).sendKeys(Zipcode);

		WebElement occupation = driver.findElement(By.id("occupation"));
		select = new Select(occupation);
		select.selectByVisibleText("Employee");

		WebElement comboboxElement = driver.findElement(By.id("other"));
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[5]")).click();
		Select combobox = new Select(comboboxElement);
		combobox.selectByVisibleText("other");
		
		driver.findElement(By.name("Next (Enter Product Data)")).click();
	}

	@Dado("preencho a aba Product Data")
	public void preencho_a_aba_product_data() {
		driver.findElement(By.id("startdate")).sendKeys(Startdate);
		
		WebElement insurancesum = driver.findElement(By.id("insurancesum"));
		Select select = new Select(insurancesum);
		select.selectByVisibleText("5000000");
		
		WebElement meritrating = driver.findElement(By.id("meritrating"));
		select = new Select(meritrating);
		select.selectByVisibleText("Bonus 1");
		
		WebElement damageinsurance = driver.findElement(By.id("damageinsurance"));
		select = new Select(damageinsurance);
		select.selectByVisibleText("Full Coverage");
		
		WebElement comboboxElement = driver.findElement(By.id("LegalDefenseInsurance"));
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[2]/span")).click();
		Select combobox = new Select(comboboxElement);
		combobox.selectByVisibleText("LegalDefenseInsurance");
		
		WebElement courtesycar = driver.findElement(By.id("courtesycar"));
		select = new Select(courtesycar);
		select.selectByVisibleText("Yes");
		
		driver.findElement(By.id("nextselectpriceoption")).click();
		
	}

	@Dado("preencho a aba Select Price Option")
	public void preencho_a_aba_select_price_option() {
		WebElement comboboxElement = driver.findElement(By.id("selectgold"));
		driver.findElement(By.xpath("//*[@id=\"selectgold\"]")).click();
		Select combobox = new Select(comboboxElement);
		combobox.selectByVisibleText("Select Option");
		
		driver.findElement(By.id("nextsendquote")).click();
	}

	@Dado("preencho a aba Send Quote e submeto o formulario")
	public void preencho_a_aba_send_quote_e_submeto_o_formulario() {
		driver.findElement(By.id("email")).sendKeys(Email);

		driver.findElement(By.id("username")).sendKeys(Username);

		driver.findElement(By.id("password")).sendKeys(Password);

		driver.findElement(By.id("confirmpassword")).sendKeys(Confirmpass);

		driver.findElement(By.id("sendemail")).click();
	}

	@Entao("devo ver a mensagem: {string}")
	public void devo_ver_a_mensagem(String string) {
		Assert.assertTrue((driver.findElement(By.tagName("h2")).getText().contains("Sending e-mail success!")));
		System.out.println(driver.findElement(By.tagName("h2")).getText());
	}
	
}