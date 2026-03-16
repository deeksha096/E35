package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class helperattribute_priority {

	@Test(priority = -1)

	public void createAccount() {
		Reporter.log("createaccount", true);
	}

	@Test(priority = 0)

	public void updateAccount() {
		Reporter.log("updateaccount", true);
	}

	@Test(priority = 1)

	public void deleteAccount() {
		Reporter.log("deleteaccount", true);
	}

}
