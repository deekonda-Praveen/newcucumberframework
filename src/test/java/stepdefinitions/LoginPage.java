package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
         driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.opencart.com/index.php?route=common/home");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Login")).click();
        System.out.println("user is on the login page");
    }

    @Given("the user should enter valid username and password")
    public void the_user_should_enter_valid_username_and_password() {
   WebElement store=driver.findElement(By.xpath("//input[@name='email']"));
        System.out.println(store.isEnabled());
        store.sendKeys("deekondapraveen123@gmail.com");
        store.sendKeys("Pr@vn@123");
        System.out.println("user has entered valid credentials");

    }

    @When("user should click on the login button")
    public void user_should_click_on_the_login_button() {
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        System.out.println("user has clicked on login button");
    }

    @Then("verify the system should login successfully")
    public void verify_the_system_should_login_successfully() {
      boolean status=  driver.findElement(By.xpath("//div[@class='page-header']")).isDisplayed();
        System.out.println("is the page header displayed:"+status);
    }


}
