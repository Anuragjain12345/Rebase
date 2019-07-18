package regJava;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Drivers {
	
	public static WebDriver driver; 
	public static String browser;
	public static Properties prop = new Properties();
	public static String osType;
	public static String url;
	
	public void Logins() throws IOException {
		
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/Reg.properties");
		
		prop.load(fiss);
		browser = prop.getProperty("browser");
		osTypes = prop.getProperty("osType");
		urls = prop.getProperty("login");

		if (browser.equalsIgnoreCase("firefox")) {
			if (osType.equalsIgnoreCase("Windows")) { // Set Path for the executable file
				System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				WebDriverWait wait = new WebDriverWait(driver, 50);
				driver.manage().window().maximize();
				driver.get(url);
				driver.findElement(By.xpath("//input[@value='Login']/ancestor::div[2]//div[5]//a[2]/h2")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Register')]")));
			} else if (osType.equalsIgnoreCase("Linux")) {
				System.setProperty("webdriver.firefox.marionette", "src/main/resources/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				WebDriverWait wait = new WebDriverWait(driver, 50);
				driver.manage().window().maximize();
				driver.get(url);
				driver.findElement(By.xpath("//input[@value='Login']/ancestor::div[2]//div[5]//a[2]/h2")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Register')]")));
			}
		}

		else if (browser.equalsIgnoreCase("chrome")) {

			if (osType.equalsIgnoreCase("Windows")) {
				System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				WebDriverWait wait = new WebDriverWait(driver, 50);
				driver.manage().window().maximize();
				driver.get(url);
				driver.findElement(By.xpath("//input[@value='Login']/ancestor::div[2]//div[5]//a[2]/h2")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Register')]")));
			} else {
				throw new IllegalArgumentException("Could not find supported browser: " + browser);
			}
		}
	}

public void close() {
driver.close();
}
}
