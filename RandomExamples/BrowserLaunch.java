package Automation.Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;

public class BrowserLaunch {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//WebDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver", "");
		//Even if the above line is not there it will launch the browser from Selenium 4 onwards there is a concept of Selenium Manager which will take care of driver.
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("The Page Title is :- "+driver.getTitle());
		System.out.println("The Page URL   is :- "+driver.getCurrentUrl());
		driver.close();

	}

}
