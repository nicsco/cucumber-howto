package cucumber.classic;

import cucumber.api.java.en.When;

public class DivisionSteps {

	Helper helper;

	public DivisionSteps(Helper helper) {
		this.helper = helper;
	}

	@When("^I share the cucumber\\(s\\) with (\\d+) friends$")
	public void iShareTheCucumbersWithSome(int friends) throws Throwable {
		double cucumbers = helper.getCucumberCount() / friends;
		helper.setCucumberCount(cucumbers);
	}


}
