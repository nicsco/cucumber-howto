package cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class Steps {

	private double cucumberCount;
	private Map<String, Double> priceChart = new HashMap<>();
	private double bill;


	@Given("^I start with (\\d+) cucumbers$")
	public void iStartWithCucumbers(int initialAmount) {
		cucumberCount = initialAmount;
	}


	@Given("^I start with an (\\d+) of cucumbers$")
	public void iStartWithAnOfCucumbers(int initialAmount) {
		cucumberCount = initialAmount;
	}

	@Given("^A \"([^\"]*)\" in the grocery store costs \\$(\\d+\\.\\d+)$")
	public void aInTheGroceryStoreCosts$(String itemName, double itemPrice) throws Throwable {
		priceChart.put(itemName, itemPrice);
	}


	@Given("^The cucumbers in the grocery store have the following prices$")
	public void theCucumbersInTheGroceryStoreHaveTheFollowingPrices(Map<String, String> priceMap) {

		for (Map.Entry<String, String> entry : priceMap.entrySet()) {
			priceChart.put(
					entry.getKey(),
					Double.parseDouble(entry.getValue().substring(1))
			);
		}
	}


	@When("^I buy (\\d+) cucumbers$")
	public void iBuyCucumbers(int arg1) {
		cucumberCount += arg1;
	}

	@When("^I eat (\\d+) cucumbers$")
	public void iEatCucumbers(int arg1) {
		cucumberCount -= arg1;
	}


	@When("^I buy (\\d+) \"([^\"]*)\"$")
	public void iBuy(int itemCount, String itemName) throws Throwable {
		if (priceChart.containsKey(itemName)) {
			bill += priceChart.get(itemName) * itemCount;
		} else {
			throw new PendingException("The item \"" + itemName + "\" has not yet been inserted in priceMap");
		}
	}


	@When("^I share the cucumber\\(s\\) with (\\d+) friends$")
	public void iShareTheCucumbersWithSome(int friends) throws Throwable {
		cucumberCount = cucumberCount / friends;
	}


	@Then("^I have (\\d+) cucumbers$")
	public void iHaveCucumbers(int arg1) {
		Assert.assertEquals((double) arg1, cucumberCount, 0);
	}


	@Then("^The final bill is \\$(\\d+\\.\\d+)$")
	public void theFinalBillIs$(double finalBill) throws Throwable {
		Assert.assertEquals(finalBill, bill, 0);
	}


	@Then("^Each of us has a (\\d+)(\\.\\d+)? of cucumber\\(s\\)$")
	public void eachOfUsHasAOfCucumbers(int finalCountInteger, Double finalCountDecimal)  {
		double finalCount = finalCountInteger;
		if (null != finalCountDecimal){
			finalCount += finalCountDecimal;
		}
		Assert.assertEquals(finalCount, cucumberCount, 0);
	}



}
