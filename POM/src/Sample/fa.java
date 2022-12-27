package Sample;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class fa {
	public class flipama 
	{
	 	static int value;
	    static int value1;
	public static void main(String[] args) throws InterruptedException 
	{
		amazon();
		flipkart();
		
			
	}
	public static void amazon() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver","./browser files/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.amazon.in");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("iphone 14");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.xpath("(//img[@alt='Apple iPhone 14 128GB (Product) RED'])[2]"))
		.click();
		Thread.sleep(2000);
		String pid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		allid.remove(pid);
		for(String id:allid)
		{
			driver.switchTo().window(id);
			
		} 
		WebElement ele = driver.findElement(By.xpath("//span[.=' Inclusive of all taxes']/../..//div[1]//span[2]//span[2]//span[2]"));
		String text = ele.getText();
		System.out.println(text);
		String amt="75,990";
		String amt1=amt.replaceAll(",","");
	 value=Integer.parseInt(amt1);
		System.out.println(value);

	}
	public static void flipkart() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver","./browser files/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("//button[.='✕']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ipone 14");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt='APPLE iPhone 14 (Blue, 128 GB)']")).click();
		Thread.sleep(2000);
		String pid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		allid.remove(pid);
		for(String id:allid)
		{
			driver.switchTo().window(id);
			
		} 
		  WebElement ele =  driver.findElement(By.xpath("(//div[.='Available offers']/../../div[2])[1]//div[4]//div[1]//div[1]//div[1]"));
		  Thread.sleep(2000);
		  String text1 = ele.getText(); 
		  System.out.println(text1);
		  String am="77,490";
			String amt2=am.replaceAll(",","");
			 value1=Integer.parseInt(amt2);
			System.out.println(value1);

		if(value>value1)
		{
			System.out.println("amazon has discount");
		}
		else
		{
			System.out.println("flipkart has discount");
		}
	}
	}


}
