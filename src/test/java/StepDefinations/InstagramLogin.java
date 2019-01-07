package StepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class InstagramLogin {
	WebDriver driver;
	String driverpath = "/home/parinder/Downloads/geckodriver-v0.22.0-linux64/geckodriver";

	@Given("^Intialize the Browser Firefox$")
	public void intialize_the_Browser_Firefox() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver", driverpath);
		driver = new FirefoxDriver();

	}

	@Given("^Vist to \"([^\"]*)\"$")
	public void vist_to(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
		Thread.sleep(3000L);

	}

	@Given("^click on login link and land on login page$")
	public void click_on_login_link_and_land_on_login_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(3000L);
	}

	@When("^Enter the invalid details \"([^\"]*)\" and \"([^\"]*)\" and log in$")
	public void enter_the_invalid_details_and_and_log_in(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@name='username']")).click();		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(arg1);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(arg2);
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		Thread.sleep(3000L);

	}

	@Then("^User is not successful logged in$")
	public void user_is_not_successful_logged_in() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String error = driver.findElement(By.xpath("//p[@id='slfErrorAlert']")).getText();
		Assert.assertTrue(
				error.contains("The username you entered doesn't belong to an account. Please check your username and try again."));
		// First Time - The username you entered doesn't belong to an account. Please check your username and try again.
		//MultipleTime - Sorry, your password was incorrect. Please double-check your password.
		driver.close();

	}

}
