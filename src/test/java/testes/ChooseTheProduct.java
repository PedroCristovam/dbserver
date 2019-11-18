package testes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChooseTheProduct {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC-Jessica\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		boolean v = true;
		
			// entrando no site
			// driver.manage().window().maximize();
			driver.get("http://www.automationpractice.com");
			// pesquisando e selecionando item
			driver.findElement(By.id("search_query_top")).sendKeys("Faded Short Sleeve T-shirts");
			driver.findElement(By.name("submit_search")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("color_1")).click();
			// driver.findElement(By.id("color_1")).click();
			Thread.sleep(3000);
			// adicionando ao carrinho e preceguindo para o pagamento
			driver.findElement(By.name("Submit")).click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Proceed to checkout")).click();
			Thread.sleep(3000);
			String cart = driver.findElement(By.className("ajax_cart_quantity")).getText();
			String value = driver.findElement(By.id("total_price")).getText();
			
			
			
			if (cart == "0") 
			{
				v = false;
			}
			if (!value.contentEquals("$18.51")) 
			{
				v = false;				
			}
			driver.findElement(By.linkText("Proceed to checkout")).click();
			Thread.sleep(3000);

			/*
			 * --Para realização de cadastro
			 *
			 * driver.findElement(By.id("email_create")).sendKeys("atdbserver@gmail.com");
			 * driver.findElement(By.id("SubmitCreate")).click(); Thread.sleep(10000);
			 * driver.findElement(By.id("id_gender1")).click();
			 * driver.findElement(By.id("customer_firstname")).sendKeys("João");
			 * driver.findElement(By.id("customer_lastname")).sendKeys("Santos");
			 * driver.findElement(By.id("passwd")).sendKeys("Dbserver123");
			 * driver.findElement(By.id("days")).sendKeys("22");
			 * driver.findElement(By.id("months")).sendKeys("maio");
			 * driver.findElement(By.id("years")).sendKeys("1997");
			 * driver.findElement(By.id("address1")).sendKeys("Grand Centra");
			 * driver.findElement(By.id("city")).sendKeys("New York");
			 * driver.findElement(By.id("id_state")).sendKeys("New York");
			 * driver.findElement(By.id("postcode")).sendKeys("10017");
			 * driver.findElement(By.id("phone_mobile")).sendKeys("2122841800");
			 * driver.findElement(By.id("alias")).sendKeys("close");
			 * driver.findElement(By.id("submitAccount")).click(); Thread.sleep(3000);
			 * 
			 */
			// -- No caso do cadastro já criado
			driver.findElement(By.id("email")).sendKeys("atdbserver@gmail.com");
			driver.findElement(By.id("passwd")).sendKeys("Dbserver123");
			driver.findElement(By.id("SubmitLogin")).click();
			Thread.sleep(5000);
			String adress = driver.findElement(By.id("address_delivery")).getText();
			if (!adress.contains("João Santos") && !adress.contains("New York, New York 10017") && !adress.contains("United States"))
			{
			 v = false;
			}
			Thread.sleep(5000);
			driver.findElement(By.name("processAddress")).click();
		
			Thread.sleep(5000);
			driver.findElement(By.id("cgv")).click();
			Thread.sleep(3000);
			driver.findElement(By.name("processCarrier")).click();
			Thread.sleep(5000);
			driver.findElement(By.className("bankwire")).click();
			Thread.sleep(3000);
		
		
			//driver.findElement(By.linkText("I confirm my order")).click();
		
		Assert.assertEquals(true, v);
		Thread.sleep(10000);
	}

}

