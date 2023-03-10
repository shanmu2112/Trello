package PageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.WebUtil;

public class LoginPage {
	
	    public WebDriver driver;
	    
	    WebUtil webutil;
	    
	    public Properties prop;
	    
		By btn_loginHome = By.xpath("//a[contains(@href,'login')]");
		
		By input_user= By.xpath("//input[@name='user']");
		
		By continueLogin = By.xpath("//input[@id='login']");
		
		By input_password = By.xpath("//input[@id='password']");
		
		By btn_login = By.xpath("//button[contains(@id,'login')]");
		
		By icon_account = By.xpath("//button[@aria-label='Open member menu']");
		
		By btn_logout = By.xpath("//button[contains(@data-testid,'logout')]");
		
	    By btn_finalLogout = By.xpath("//span[text()='Log out']/parent::span/parent::button");
		
		public LoginPage(WebDriver driver) throws IOException
	{
		
		this.driver = driver;
		
		webutil = new WebUtil(driver);
		
        String currentDirectory = System.getProperty("user.dir"); 
		
    	String propertiesPath = currentDirectory + "\\src\\main\\java\\resources\\data.properties";
    	
    	FileInputStream fis = new FileInputStream(propertiesPath);
    	
    	prop = new Properties();
    	
		prop.load(fis);
	}
	
		public WebElement getBtn_loginHome() {
			
			return driver.findElement(btn_loginHome);
		}
		public WebElement getInput_user() {
			
			return driver.findElement(input_user);
		}
		public WebElement getContinueLogin() {
			
			return driver.findElement(continueLogin);
		}
		public WebElement getInput_password() {
			
			return driver.findElement(input_password);
		}
		public WebElement getBtn_login() {
			
			return driver.findElement(btn_login);
		}
		
		public By getIcon_account() {
			
			return icon_account;
		}
		
		public By getBtn_logout() {
			
			return btn_logout;
		}
		
		public By getBtn_finalLogout() {
			
			return btn_finalLogout;
		}
		
		public void loginToTrello() throws InterruptedException {
			
			webutil.waitForPageload();
			
			webutil.click(getBtn_loginHome());
			
			webutil.waitForPageload();
			
			webutil.clickClearAndInput(getInput_user(),prop.getProperty("userID"));
			
			webutil.click(getContinueLogin());
			
			webutil.waitForPageload();
			
			webutil.clickClearAndInput(getInput_password(), prop.getProperty("password"));
			
			webutil.click(getBtn_login());
			
			webutil.waitForPageload();

		     
		}
		
		public void logout() {
			
			webutil.click(getIcon_account());
			
			webutil.click(getBtn_logout());
			
			webutil.waitForPageload();
			
			webutil.click(getBtn_finalLogout());
			
			webutil.waitForPageload();
		
		}

}
