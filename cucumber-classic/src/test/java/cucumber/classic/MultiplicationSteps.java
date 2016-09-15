package cucumber.classic;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;

import java.util.Map;

public class MultiplicationSteps {

	Helper helper;

	public MultiplicationSteps(Helper helper) {
		this.helper = helper;
	}


	@When("^I buy (\\d+) \"([^\"]*)\"$")
	public void iBuy(int itemCount, String itemName) throws Throwable {
		Map<String, Double> priceChart = helper.getPriceChart();
		double bill = helper.getBill();

		if (priceChart.containsKey(itemName)) {
			bill += priceChart.get(itemName) * itemCount;
		} else {
			throw new PendingException("The item \"" + itemName + "\" has not yet been inserted in priceMap");
		}
		helper.setBill(bill);
	}


}
