package cucumber.classic;

import cucumber.api.java.en.Given;

import java.util.Map;

public class InitialConditionsSteps {

	Helper helper;

	public InitialConditionsSteps(Helper helper) {
		this.helper = helper;
	}


	@Given("^I start with (\\d+) cucumbers$")
	public void iStartWithCucumbers(int initialAmount) {
		helper.setCucumberCount(initialAmount);
	}


	@Given("^I start with an (\\d+) of cucumbers$")
	public void iStartWithAnOfCucumbers(int initialAmount) {
		helper.setCucumberCount(initialAmount);
	}


	@Given("^A \"([^\"]*)\" in the grocery store costs \\$(\\d+\\.\\d+)$")
	public void aInTheGroceryStoreCosts$(String itemName, double itemPrice) throws Throwable {
		Map<String, Double> priceChart = helper.getPriceChart();
		priceChart.put(itemName, itemPrice);
	}

	@Given("^The cucumbers in the grocery store have the following prices$")
	public void theCucumbersInTheGroceryStoreHaveTheFollowingPrices(Map<String, String> priceMap) {

		Map<String, Double> priceChart = helper.getPriceChart();

		for (Map.Entry<String, String> entry : priceMap.entrySet()) {
			priceChart.put(
					entry.getKey(),
					Double.parseDouble(entry.getValue().substring(1))
			);
		}
	}

}
