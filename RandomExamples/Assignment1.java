package Automation.Demo;

import org.openqa.selenium.*;
import java.util.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;

import com.sun.tools.javac.util.List;

public class Assignment1 {

	@SuppressWarnings("restriction")
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		java.util.List<WebElement> checkboxlist = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("The number of checkboxes available in the page are :- "+checkboxlist.size());
		
		WebElement firstCheckbox = driver.findElement(By.xpath(" //input[@id='checkBoxOption1']"));
		//	Assert.assertFalse(firstCheckbox.isSelected(),"Verify the checkbox is unselected");
		//System.out.println("Verify the checkbox is unselected: "+firstCheckbox.isSelected());
		firstCheckbox.click();
		Assert.assertTrue(firstCheckbox.isSelected(),"Verify the checkbox is Selected");
		System.out.println("Verify the checkbox is Selected :- "+firstCheckbox.isSelected()); 
		firstCheckbox.click();
		Assert.assertFalse(firstCheckbox.isSelected(),"Verify the checkbox is unselected");
		System.out.println("Verify the checkbox is unselected:- "+firstCheckbox.isSelected());
		driver.close();
	}

}
