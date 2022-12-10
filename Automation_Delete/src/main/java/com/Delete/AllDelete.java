package com.Delete;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllDelete {
	WebDriver driver;
	public AllDelete(WebDriver driver)
	{
		this.driver = driver;
	}
	public void navigatetoConnector()
	{
		System.out.println("inside navigate to connector");
		new WebDriverWait(driver, Duration.ofSeconds(120))
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sidebar-options']/div[@data-header='Connectors']")));
		driver.findElement(By.xpath("//div[@class='sidebar-options']/div[@data-header='Connectors']")).click();
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("add-text"))));
		
	}
	public void deleteConnector(String conn_name)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Boolean isPresent = driver.findElements(By.xpath("//*[text()='"+conn_name+"']")).size() > 0;
		if(isPresent)
		{
		new WebDriverWait(driver, Duration.ofSeconds(30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+conn_name+"']/ancestor-or-self::div[@class='table-row']/div/div[5]")));
		driver.findElement(By.xpath("//*[text()='"+conn_name+"']/ancestor-or-self::div[@class='table-row']/div/div[5]")).click();
		driver.findElement(By.xpath("//*[text()='"+conn_name+"']/ancestor-or-self::div[@class='table-row']/div/div[5]/div/div[4]")).click();
		driversleep();
		driver.findElement(By.xpath("//div[@class='event-button-click yes']")).click();
		System.out.println( conn_name+" deleted");
		}
		else
		{
			System.out.println(conn_name+" not found");
		}
	}
	public void deleteMongo()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		Boolean isPresent = driver.findElements(By.xpath("//*[text()='AutoTestMongo']")).size() > 0;
		if(isPresent)
		{
		new WebDriverWait(driver, 30)
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='AutoTestMongo']/ancestor-or-self::div[@class='table-row']/div/div[5]")));
		driver.findElement(By.xpath("//*[text()='AutoTestMongo']/ancestor-or-self::div[@class='table-row']/div/div[5]")).click();
		driver.findElement(By.xpath("//*[text()='AutoTestMongo']/ancestor-or-self::div[@class='table-row']/div/div[5]/div/div[4]")).click();
		driversleep();
		driver.findElement(By.xpath("//div[@class='event-button-click yes']")).click();
		System.out.println("MongoDB deleted");
		}
		else
		{
			System.out.println("AutoTestMongo not found");
		}
	}
	public void deletePostgre()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		new WebDriverWait(driver, 30)
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='AutoTestPostgre']/ancestor-or-self::div[@class='table-row']/div/div[5]")));
		driver.findElement(By.xpath("//*[text()='AutoTestPostgre']/ancestor-or-self::div[@class='table-row']/div/div[5]")).click();
		driver.findElement(By.xpath("//*[text()='AutoTestPostgre']/ancestor-or-self::div[@class='table-row']/div/div[5]/div/div[4]")).click();
		driversleep();
		driver.findElement(By.xpath("//div[@class='event-button-click yes']")).click();
		System.out.println("Postgre deleted");
		ThreadSleep();
	}
	public void deleteRestApi()
	{
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", 	
				driver.findElement(By.xpath("//*[text()='AutoApi']")));
		new WebDriverWait(driver, 30)
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='AutoApi']/ancestor-or-self::div[@class='table-row']/div/div[5]")));
		driver.findElement(By.xpath("//*[text()='AutoApi']")).click();
		driver.findElement(By.xpath("//*[text()='AutoApi']/ancestor-or-self::div[@class='table-row']/div/div[5]")).click();
		driver.findElement(By.xpath("//*[text()='AutoApi']/ancestor-or-self::div[@class='table-row']/div/div[5]/div/div[4]")).click();
		driversleep();
		driver.findElement(By.xpath("//div[@class='event-button-click yes']")).click();
		System.out.println("AutoApi deleted");
		ThreadSleep();
	}
	
	public void deleteGraphQL()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		new WebDriverWait(driver, 30)
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='AutoGraphQL']/ancestor-or-self::div[@class='table-row']/div/div[5]")));
		driver.findElement(By.xpath("//*[text()='AutoGraphQL']")).click();
		driver.findElement(By.xpath("//*[text()='AutoGraphQL']/ancestor-or-self::div[@class='table-row']/div/div[5]")).click();
		driver.findElement(By.xpath("//*[text()='AutoGraphQL']/ancestor-or-self::div[@class='table-row']/div/div[5]/div/div[4]")).click();
		driversleep();
		driver.findElement(By.xpath("//div[@class='event-button-click yes']")).click();
		System.out.println("GraphQL deleted");
		ThreadSleep();
	}
	public void deleteGoogleSheet()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@class='add-new-btn add-category-button']")).click();
		driver.findElement(By.xpath("//*[@class='hq-close-btn d-flex align-center ml-2 pointer close-sidebar']")).click();
		driver.findElement(By.xpath("//*[@class='add-new-btn add-category-button']")).click();
		driver.findElement(By.xpath("//*[@title='Google Sheets']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@data-account-name='AutoSheet']")).click();
		driver.findElement(By.xpath("//div[@data-account-name='AutoSheet']/div[2]/div[1]")).click();
		driver.findElement(By.xpath("//*[@class='event-button']/div[2]")).click();
		driversleep();
		new WebDriverWait(driver, 30)
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='hq-close-btn d-flex align-center ml-2 pointer account-sidebar-close']")));
		driver.findElement(By.xpath("//a[@class='hq-close-btn d-flex align-center ml-2 pointer account-sidebar-close']")).click();//cross button
		System.out.println("Google sheet deleted");
		ThreadSleep();
	}
	public void deleteApp()
	{
		driversleep();
		driver.findElement(By.xpath("//div[@class='ui deleteApp mini modal transition visible active']/div[2]/div[1]")).click();
		//driver.findElement(By.xpath("//div[@class='ui deleteApp mini modal transition visible active']/div[2]/div[1]")).click();
	}
	public void deleteAutoApp()
	{
		
		driver.findElement(By.xpath("//div[@class='sidebar-options']/div[@data-header='Apps']")).click();//go to App
		driversleep();
		WebElement element =driver.findElement(By.xpath("//*[@data-appname='AutoApp']/div/div[2]/div[2]/div/img"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		driver.findElement(By.xpath("//*[@data-appname='AutoApp']/div/div[2]/div[2]/div/img")).click();
		driver.findElement(By.xpath("//*[@data-appname='AutoApp']/div/div[2]/div[2]/div/div/div[5]")).click();
		deleteApp();
	}
	public void deleteExportApp()
	{
		driversleep();
		driver.findElement(By.xpath("//div[@class='sidebar-options']/div[@data-header='Apps']")).click();//go to App
		driversleep();
		driversleep();
		WebElement element =driver.findElement(By.xpath("//*[@data-appname='ExportAuto']/div/div[2]/div[2]/div/img"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		driver.findElement(By.xpath("//*[@data-appname='ExportAuto']/div/div[2]/div[2]/div/img")).click();
		driver.findElement(By.xpath("//*[@data-appname='ExportAuto']/div/div[2]/div[2]/div/div/div[5]")).click();
		deleteApp();
	}
	public void ThreadSleep()
	{
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void driversleep()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
}
