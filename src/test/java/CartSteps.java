import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CartSteps {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void closeBrowser() {
        driver.quit();

    }
    @Given("User is loged in")
    public void user_is_loged_in() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    }
    @When("User adds item to cart")
    public void user_adds_item_to_cart() {
        driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }
    @And("go to cart")
    public void user_goes_to_cart (){
        driver.findElement(By.linkText("1")).click();
    }
    @Then("He should see item in cart")
    public void user_sees_item_in_cart() {
        assertEquals(driver.findElement(By.cssSelector(".inventory_item_name")).getText(), ("Sauce Labs Backpack"));
    }

    @Given("User has item in cart")
    public void user_has_item_in_cart() {
        user_is_loged_in();
        user_adds_item_to_cart();
        user_goes_to_cart ();
        user_sees_item_in_cart();
    }
    @When("User remove item from cart")
    public void user_remove_item_from_cart() {
        driver.findElement(By.cssSelector("*[data-test=\"remove-sauce-labs-backpack\"]")).click();
    }
    @Then("He cart should be empty")
    public void he_cart_should_be_empty() {
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".cart_footer"));
            assert(elements.size() > 0);
        }
    }
}