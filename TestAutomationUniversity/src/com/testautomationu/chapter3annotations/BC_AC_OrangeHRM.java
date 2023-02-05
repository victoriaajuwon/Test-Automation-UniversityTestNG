package com.testautomationu.chapter3annotations;

import javax.swing.text.Highlighter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BC_AC_OrangeHRM 
{
WebDriver driver;
	
	@BeforeClass
	public void setUp ()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rex Allen Jones II\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println("1. Open Chrome & Application");
	}
	
	@Test
	public void signIn ()
	{		
		WebElement textUsername = driver.findElement(By.id("txtUsername"));
		Highlighter.highlightElement(driver, textUsername);
		textUsername.sendKeys("Admin");
		
		WebElement textPassword = driver.findElement(By.id("txtPassword"));
		Highlighter.highlightElement(driver, textPassword);
		textPassword.sendKeys("admin123");
		
		WebElement buttonLogin = driver.findElement(By.id("btnLogin"));
		Highlighter.highlightElement(driver, buttonLogin);
		buttonLogin.click();
		
		System.out.println("2. Sign In");
	}
	
	@Test
	public void userSearch ()
	{		
		WebElement menuAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
		Highlighter.highlightElement(driver, menuAdmin);
		menuAdmin.click();
		
		WebElement textUserName = driver.findElement(By.id("searchSystemUser_userName"));
		Highlighter.highlightElement(driver, textUserName);
		textUserName.sendKeys("Admin");
		
		WebElement buttonSearch = driver.findElement(By.id("searchBtn"));
		Highlighter.highlightElement(driver, buttonSearch);
		buttonSearch.click();		
		
		System.out.println("3. Search For User");
	}
	
	@Test
	public void userSignOut () 
	{
		WebElement linkWelcome = driver.findElement(By.id("welcome"));
		Highlighter.highlightElement(driver, linkWelcome);
		linkWelcome.click();
			
		WebElement linkLogout = driver.findElement(By.xpath("//div[@id='welcome-menu']/descendant::a[contains(@href,'logout')]"));
		Highlighter.highlightElement(driver, linkLogout);
		linkLogout.click();

		System.out.println("4. Sign Out");
	}
	
	@AfterClass
	public void tearDown ()
	{
		System.out.println("5. Close Chrome & Application");
		driver.quit();		
	}

}
