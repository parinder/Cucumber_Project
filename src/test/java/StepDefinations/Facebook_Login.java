package StepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class Facebook_Login {
  	WebDriver driver;
  	String driverPath = "/home/parinder/Downloads/geckodriver-v0.22.0-linux64/geckodriver";
	
    @Given("^user on facebook login page$")
    public void user_on_facebook_login_page() throws Throwable {
  
    	
    	System.setProperty("webdriver.gecko.driver", driverPath);
    	driver =new FirefoxDriver();
    	driver.get("https://www.facebook.com/");
    	
    }

    @When("^Enter the valid login details - username & Password$")
    public void enter_the_valid_login_details_username_password() throws Throwable {
    	driver.findElement(By.id("email")).sendKeys("parindersinghraina");
		driver.findElement(By.id("pass")).sendKeys("loveyoup@p@");
		driver.findElement(By.id("loginbutton")).click();
    }
    @When("^Enter the invalid login details - username & Password$")
    public void enter_the_invalid_login_details_username_Password() throws Throwable {
    	driver.findElement(By.id("email")).sendKeys("invalid");
		driver.findElement(By.id("pass")).sendKeys("invalid@p@");
		driver.findElement(By.id("loginbutton")).click();
    }

    @Then("^User should see the profile hompage with feeds$")
    public void user_should_see_the_profile_hompage_with_feeds() throws Throwable {
    String	actual=driver.getTitle();
    Assert.assertTrue(actual.contains("Facebook"));
    }
    
    @Then("^User should see the error Message$")
    public void User_should_see_the_error_Message() throws Throwable {
    	String	actualinvalid=driver.getTitle();
        Assert.assertTrue(actualinvalid.contains("Facebook - Log In or Sign Up"));
        
    }

}