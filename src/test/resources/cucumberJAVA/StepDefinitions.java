package cucumberJAVA
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;

public class Stepdefs {
    private String username_s ;
    private String password_s ;
    private String actualAnswer;

    @Given("I am at saucedemo.com page")
    public void i_am_at_saucedemo_com_page() {
        driver.get("https://www.saucedemo.com/");
    }