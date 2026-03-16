package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class HelperAttribute_dependson {
	@Test

	public void createAccount() {
		Reporter.log("Createaccount", true);
	}

	@Test(dependsOnMethods = "createAccount")

	public void updateAccount() {
		Reporter.log("updateAccount", true);
	}

	@Test(dependsOnMethods = {"createAccount","updateAccount"})

	public void deleteAccount() {
		Reporter.log("deleteAccount", true);
	}

}
