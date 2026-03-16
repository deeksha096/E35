package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo2 {

	@Test

	public void a1() {
		Reporter.log("a1 is executed");
	}

	@Test

	public void aa1() {
		Reporter.log("aa1 is executed");
	}

	@Test

	public void a2() {
		Reporter.log("a2 is executed");
	}

	@Test

	public void aa2() {
		Reporter.log("aa2 is executed");
	}
	

	@Test

	public void b1() {
		Reporter.log("b1 is executed");
	}
}
