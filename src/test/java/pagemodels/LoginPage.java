package pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	// 1. create constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 2. create locators
	private By email = By.id("Email");
	private By password = By.id("Password");
	private By loginButton = By.xpath("//button[contains(text(), 'Log in')]");
	
	//3. create actions
	
	public void setEmailAndPassword(String emailkey, String passwordkey) {
		WebElement em = driver.findElement(email);
		WebElement pass = driver.findElement(password);
		
		em.clear();
		em.sendKeys(emailkey);
		
		pass.clear();
		pass.sendKeys(passwordkey);
		
	}
	
	
	public void clickOnLoginButton() {
		driver.findElement(loginButton).click();;
	}


	public String getPageTitle() {
		return driver.getTitle();
	}

}
