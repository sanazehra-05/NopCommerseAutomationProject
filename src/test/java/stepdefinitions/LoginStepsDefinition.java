package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pagemodels.LoginPage;

public class LoginStepsDefinition {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static final Logger logger = LogManager.getLogger(LoginStepsDefinition.class);

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://admin-demo.nopcommerce.com/login");
	}

	@When("user enter email {string} and password {string}")
	public void user_enter_email_and_password(String email, String password) {
		loginPage.setEmailAndPassword(email, password);
		logger.info("----------- entered email and password ----------");
	}

	@And("user click on login button")
	public void user_click_on_login_button() {
		loginPage.clickOnLoginButton();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
		logger.info("----------- verify page title ------------");
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(title, actualTitle);
	}

}
