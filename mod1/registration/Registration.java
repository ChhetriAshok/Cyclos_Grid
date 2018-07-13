package com.mod1.registration;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Registration {
	WebDriver driver;    
  @Test
  public void f() {
	  
	  
		driver.findElement(By.xpath("//input[@onclick='publicRegisterUser()']")).click();  // register 
		driver.findElement(By.name("member(user).username")).sendKeys("Smitaaa");			// username	
		driver.findElement(By.name("member(name)")).sendKeys("Smita Priyadarshani");		//Full name	
		driver.findElement(By.name("member(email)")).sendKeys("smitaaa123@gmail.com");		//email
		
		//date of birth 
		driver.findElement(By.id("calendarTrigger0")).click(); 								// Click on calendar
		driver.findElement(By.name("member(customValues).value")).sendKeys("30/06/2018");	//value in date text  field
		
		
		// Radio Button Gender
		driver.findElement(By.id("_radio_2_0")).click(); 								//female
		//driver.findElement(By.id("_radio_2_1")).click();								//male		
		
		driver.findElement(By.xpath(".//*[@id='tdContents']/div/form/table[1]/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/input[3]")).sendKeys("#503 anuradhablock");				//address
		driver.findElement(By.xpath(".//*[@id='tdContents']/div/form/table[1]/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/input[3]")).sendKeys("560099");				//postal code
		driver.findElement(By.xpath(".//*[@id='tdContents']/div/form/table[1]/tbody/tr[2]/td/table/tbody/tr[8]/td[2]/input[3]")).sendKeys("Bangalore"); 			//city
		
		WebElement areavalue =  driver.findElement(By.xpath(".//*[@id='custom_field_select_6']"));
		Select areaname = new Select(areavalue);
		areaname.selectByVisibleText("Example area");
		//driver.findElement(By.xpath(".//*[@id='custom_field_select_6']")).sendKeys("chandapura");
		//area
	
		
		driver.findElement(By.xpath(".//*[@id='tdContents']/div/form/table[1]/tbody/tr[2]/td/table/tbody/tr[10]/td[2]/input[3]")).sendKeys("9871084722");				//mobile phone
		driver.findElement(By.xpath(".//*[@id='tdContents']/div/form/table[1]/tbody/tr[2]/td/table/tbody/tr[11]/td[2]/input[3]")).sendKeys("9876543215");			//phone
		driver.findElement(By.xpath(".//*[@id='tdContents']/div/form/table[1]/tbody/tr[2]/td/table/tbody/tr[12]/td[2]/input[3]")).sendKeys("+44-208-1234569");				//fax
		driver.findElement(By.xpath(".//*[@id='tdContents']/div/form/table[1]/tbody/tr[2]/td/table/tbody/tr[13]/td[2]/input[3]")).sendKeys("www.google.com");		//url
		//Password
		driver.findElement(By.name("member(user).password")).sendKeys("smita123");
		driver.findElement(By.name("confirmPassword")).sendKeys("smita123");
		
		/*//Captcha
		 String captchaValue = driver.findElement(By.xpath("//img[@id='captchaImage']")).getText();  //this will read the captcha
		 System.out.println(captchaValue);
	        driver.findElement(By.name("captcha")).sendKeys(captchaValue);
	        */
	     //new Captcha
		try {
			Thread.sleep(10000);
			driver.findElement(By.id("saveButton")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        //driver.findElement(By.linkText("New code")).click();
	        
	      //Backbutton 
	       // driver.findElement(By.id("backButton")).click();
		
		
		// submit
		
		driver.findElement(By.id("btn")).click();
  }
  
  
  @BeforeTest
 	public void beforeTest() {
 		driver=new FirefoxDriver();
 		driver.get("http://localhost:8585/do/login");
 		driver.manage().window().maximize();
 	}   

}
