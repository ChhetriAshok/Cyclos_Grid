package com.mod1.login;

import static org.testng.Assert.assertEquals;

import java.net.URL;

import org.openqa.jetty.html.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {
	public WebDriver driver;
	
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browser) throws Exception {
		
		/* if(browser.equalsIgnoreCase("chrome"))
		{
			String avi_pc="http://192.168.43.84:4567/wd/hub";
			DesiredCapabilities dc=DesiredCapabilities.chrome();
			dc.setBrowserName("chrome");
			dc.setPlatform(Platform.WIN10);
			driver=new RemoteWebDriver(new URL(avi_pc),dc);
		}
		*/ if(browser.equalsIgnoreCase("firefox"))
			{
				String arun_pc="http://192.168.43.105:8888/wd/hub";
				DesiredCapabilities dc=DesiredCapabilities.firefox();
				//dc.setBrowserName("firefox");
				dc.setPlatform(Platform.WIN10);
				driver=new RemoteWebDriver(new URL(arun_pc),dc);
			}	
	
		/* if(browser.equalsIgnoreCase("ie"))
		{
			String avinash_pc=" http://172.24.74.63:5556/wd/hub";
			DesiredCapabilities dc=DesiredCapabilities.internetExplorer();
			dc.setBrowserName("ie");
			dc.setPlatform(Platform.WIN10);
			driver=new RemoteWebDriver(new URL(avinash_pc),dc);
			
		}*/
			
		
	//driver = new FirefoxDriver();
		
	}
	@Test(priority = 1)
	public void login() throws InterruptedException {
		//driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8585/do/login");
	
		// login userName
		String username = "admin";
		driver.findElement(By.id("cyclosUsername")).sendKeys(username);

		// assert for login username
		boolean validUsername = username.matches("[a-zA-Z0-9]+");
		assertEquals(validUsername, true, " no special character");

		// length must between 4 to 10
		int lengthUsername = username.length();
		if (lengthUsername < 4)
			assertEquals(lengthUsername, 4, "it must be more than 4 character");
		if (lengthUsername > 10)
			assertEquals(lengthUsername, 10, "it must be less than 10 character");

		// not only numeric assert
		boolean validusername = username.matches("[0-9]+");
		assertEquals(validusername, false, " atleast one alphabet");

		// login passWord

		/*
		 * String password ="1234";
		 * driver.findElement(By.id("cyclosPassword")).sendKeys(password); int
		 * lengthpass = password.length(); if(lengthpass<4 || lengthpass>20)
		 * assertEquals(lengthpass,4,"it must be more than 4 to 20 character");
		 */

		// In keyboard it is not fetching the data

		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();
		// Thread.sleep(10000);

		/*
		 * WebElement virtualpass= driver.findElement(By.id("cyclosPassword"));
		 * //String virtualpass=
		 * driver.findElement(By.xpath(".//*[@id='cyclosPassword']")).getText();
		 * System.out.println(virtualpass);
		 * 
		 * int lengthpass = virtualpass.length(); if(lengthpass<=4 ||
		 * lengthpass>20)
		 * assertEquals(lengthpass,4,"it must be more than 4 to 20 character");
		 */

		// Submit

		driver.findElement(By.xpath("//input[@value='Submit']")).click();

		// logout
		// driver.findElement(By.linkText("Logout")).click();
		// Checking for redirecting to home page

		/*
		 * String Expectedurl = "Cyclos"; String actualurl = driver.getTitle();
		 * Assert.assertEquals(Expectedurl, actualurl);
		 * System.out.println(actualurl);
		 * System.out.println("Login Done with Click");
		 */

		// driver.findElement(By.xpath("//input[@onclick='publicRegisterUser()']")).click();

	}
	/*
	 * @Test
	 * 
	 * public void registrationCheck() { //Registration
	 * 
	 * driver.findElement(By.xpath("//input[@onclick='publicRegisterUser()']")).
	 * click(); }
	 */

}
