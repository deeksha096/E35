package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo3 {
	@Test

	public void A1() {
		Reporter.log("A1 is executed");
	}

	@Test

	public void A11() {
		Reporter.log("A11 is executed");
	}

	@Test

	public void a2() {
		Reporter.log("a2 is executed");
	}

	@Test

	public void b1() {
		Reporter.log("b1 is executed");
	}
	

	@Test

	public void B1() {
		Reporter.log("B1 is executed");
	}

}
