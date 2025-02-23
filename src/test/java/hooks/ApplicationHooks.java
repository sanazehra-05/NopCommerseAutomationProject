package hooks;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.ConfigReader;

public class ApplicationHooks {
	
	private ConfigReader configReader;
	private WebDriver diver;
	private Properties prop;
	
	
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.initProperties();
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		diver = DriverFactory.initializeDriver(browserName);
	}
	
	@After(order = 0)
	public void quitBrowser() {
		diver.manage().timeouts().implicitlyWait(Duration.ofMinutes(350));
		diver.quit();
	}

	//@After(order = 1)
	public void tearDown(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {

			String screenShotName = scenario.getName().replaceAll(" ", "_");
			File screenshotFile = ((TakesScreenshot) diver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(".\\screenshots\\error.png"));
			
			byte[] bytes = ((TakesScreenshot) diver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(bytes, screenShotName, screenShotName);

		}
	}
	
	@AfterStep(order = 1)
	public void addScreenshot(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {

			String screenShotName = scenario.getName().replaceAll(" ", "_");
			byte[] bytes = ((TakesScreenshot) diver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(bytes, "image/png", screenShotName);

		}
	}
	
	

}
