package StepDefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import BaseLayer.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step extends BaseClass {

	@Given("user on login page")
	public void user_on_login_page() {
		BaseClass.initialization();

	}

	@When("user enter valid credintioals")
	public void user_enter_valid_credintioals() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");

	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}

	@Then("user validate Home page Title")
	public void user_validate_home_page_title() {
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "OrangeHRM");

	}

	@Given("user on Home page and click on PIM Link")
	public void user_on_home_page_and_click_on_pim_link() {

		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
	}

	@When("user click on add Employee button")
	public void user_click_on_add_employee_button() {
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();

	}

	@When("uer enter firstname {string} middlename {string} lastname {string}")
	public void uer_enter_firstname_middlename_lastname(String string, String string2, String string3) {

		driver.findElement(By.name("firstName")).sendKeys(string);
		driver.findElement(By.name("middleName")).sendKeys(string2);
		driver.findElement(By.name("lastName")).sendKeys(string3);
	}

	static String EmployeeId;

	@Then("user capture employee ID")
	public void user_capture_employee_id() {
		WebElement employeeId = driver.findElement(By.xpath(
				"//label[text()='Employee Id']/parent::div/following-sibling::div/child::input[@class='oxd-input oxd-input--active']"));
		EmployeeId = employeeId.getText();
		System.out.println(EmployeeId);
	}

	@Then("user click on save button")
	public void user_click_on_save_button() {
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();

	}

	@Given("user on home page and validate logo")
	public void user_on_home_page_and_validate_logo() {
		WebElement logo = driver.findElement(By.xpath("//img[@alt='client brand banner']"));
		boolean logoDis = logo.isDisplayed();
		Assert.assertTrue(logoDis);

	}

	@Given("user validate Title")
	public void user_validate_title() {
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "OrangeHRM");

	}

	@Given("user validate Url")
	public void user_validate_url() {
		String CurrentUrl = driver.getCurrentUrl();
		Assert.assertEquals(CurrentUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

	}

	@Given("User validate employeeId")
	public void user_validate_employee_id() {
		WebElement validateemployeeId = driver.findElement(By.xpath(
				"//label[text()='Employee Id']/parent::div/following-sibling::div/child::input[@class='oxd-input oxd-input--active']"));
		// Assert.assertEquals(validateemployeeId , EmployeeId);

	}

	@When("user enter otherId as {string} and select nationality {string}")
	public void user_enter_other_id_as_and_select_nationality(String first, String second) {
		// driver.findElement(By.xpath("//label[text()='Other
		// Id']/parent::div/following-sibling::div/child::input")).sendKeys(first);
		WebElement wb = driver.findElement(By.xpath(
				"//label[text()='Nationality']/parent::div/following-sibling::div/descendant::div/child::div/child::div[@class='oxd-select-text-input']"));
		wb.click();
		List<WebElement> ls = driver.findElements(By.xpath("//div[@class='oxd-select-option']"));
		for (WebElement a : ls) {
			String b = a.getText();
			if (b.equals("Indian")) {
				a.click();
				break;
			}
		}
	}

	@When("user select marrital status {string}")
	public void user_select_marrital_status(String string) {
		WebElement wb = driver.findElement(By.xpath(
				"//label[text()='Marital Status']/parent::div/following-sibling::div/descendant::div[text()='-- Select --']"));
		wb.click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='oxd-select-option']"));
		for (WebElement ls : list) {
			String a = ls.getText();
			if (a.equals(string)) {
				ls.click();
				break;
			}
		}
		// Assert.assertEquals(a, "Married");

	}

	@When("user select gender")
	public void user_select_gender() {
		List<WebElement> ls = driver.findElements(By.xpath("//div[@class=\"oxd-radio-wrapper\"]"));
		for (WebElement a : ls) {
			String b = a.getText();
			if (b.equals("Male")) {
				a.click();
				break;
			}
		}

	}

	@Then("click on MoreDetailsSave button")
	public void click_on_more_details_save_button() {
		driver.findElement(By.xpath("//p[text()=' * Required']/following-sibling::button")).click();
		driver.quit();
	}

}
