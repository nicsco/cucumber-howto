package cucumber.classic;

import cucumber.api.java.en.When;

public class AdditionSteps {

	Helper helper;

	public AdditionSteps(Helper helper) {
		this.helper = helper;
	}

	@When("^I buy (\\d+) cucumbers$")
	public void iBuyCucumbers(int arg1) {
		double cucumbers = helper.getCucumberCount() + arg1;
		helper.setCucumberCount(cucumbers);
	}

	@When("^I eat (\\d+) cucumbers$")
	public void iEatCucumbers(int arg1) {
		double cucumbers = helper.getCucumberCount() - arg1;
		helper.setCucumberCount(cucumbers);
	}


}
