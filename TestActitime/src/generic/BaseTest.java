package generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BaseTest implements IAutoContain { 
	
		static WebDriver driver;
		public void OpenBrowser() throws IOException {
			Flib flib = new Flib();
			
			String browserValue = flib.readPropertyData(prop_path, "browser");
			String url = flib.readPropertyData(prop_path, "url");
			
			
			
			if (browserValue.equalsIgnoreCase("chrome")) {
				System.setProperty(chrome_key,chrome_path);
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get(url);
			}
			else if (browserValue.equalsIgnoreCase("fireFox")) {
				System.setProperty(gecko_key,gecko_path);
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get(url);

			}
			else {
				System.out.println("Error");

			}
		}
		public void closeBrowser() {
			driver.close();
		}

		
	}	

