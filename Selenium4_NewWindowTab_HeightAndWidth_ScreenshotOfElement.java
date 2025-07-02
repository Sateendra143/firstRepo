package Automation.Demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium4_NewWindowTab_HeightAndWidth_ScreenshotOfElement {

	public static void main(String[] args) throws IOException {

		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//Switching Window
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentWindowId = it.next();
		String childWindow =it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
		.get(1).getText();
		driver.close();
		driver.switchTo().window(parentWindowId);
		WebElement name=driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);
		//Screenshot
		File file=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\satee\\screenshot1.png"));

		//GEt Height & Width

		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setPageLoadTimeout(Duration.ofSeconds(5));
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		//if we comment out the next step there will pop up for accessing location
		driver = new ChromeDriver(options);
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://google.com");
		handles=driver.getWindowHandles();
		it=handles.iterator();
		parentWindowId = it.next();
		childWindow =it.next();
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());

	}

}
