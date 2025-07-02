package Automation.Demo;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.Files;

public class BrokenLinks_BrowserOptions_Screenshot {

	public static void main(String[] args) throws MalformedURLException, IOException {

		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setPageLoadTimeout(Duration.ofSeconds(5));
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        
		System.out.println(options.getBrowserName());
		System.out.println(options.getBrowserVersion());
		System.out.println(options.getCapabilityNames());
        
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Users\\satee\\screenshot.png"));
        
        List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a =new SoftAssert();
        for(WebElement link : links)
	      {
          String url= link.getAttribute("href");
          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
          conn.setRequestMethod("HEAD");
          conn.connect();
          int respCode = conn.getResponseCode();
          System.out.println("The link with Text "+link.getText()+" is giving a response code :-"+respCode);
          a.assertTrue(respCode<400, "The link with Text "+link.getText()+" is broken with code" +respCode);
	      }
	     System.out.println(driver.manage().getCookies());
	     driver.close();
	     a.assertAll();
	     }
}
