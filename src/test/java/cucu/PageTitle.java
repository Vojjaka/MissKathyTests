package cucu;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vlad on 16.08.2015.
 */
public class PageTitle {
    protected WebDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
    }

    @Given("^I open website misskathy.ru$")
    public void I_open_google() {
        //Set implicit wait of 30 seconds and launch website
        driver.get("http://misskathy.ru/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("^getting page title$")
    public void Getting_title_and_print_it() {
        //print out page title
        System.out.println(driver.getTitle());
    }

    @Then("^asserting page title \"([^\"]*)\"$")
    public void I_should_get_correct_page_title(String expectedResult) {

        //Asserting page title
        assertEquals(driver.getTitle(), expectedResult);

        driver.close();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
