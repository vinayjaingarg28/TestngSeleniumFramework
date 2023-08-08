package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	
	@BeforeTest
	public static void setUp() {
		System.out.println("setup run");
		
		if(driver== null) {
			try {
				FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/config.properties");
				Properties prop = new Properties();
				prop.load(fr);
				String browser = prop.getProperty("browser");
				if(browser.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		System.out.println("setup finish");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
