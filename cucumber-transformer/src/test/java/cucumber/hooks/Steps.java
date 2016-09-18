package cucumber.hooks;

import bank.Money;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import cucumber.transformers.MoneyConverter;

import java.util.Map;

public class Steps {
	Helper helper;

	public Steps(Helper helper) {
		this.helper = helper;
	}


	@Given("^A \"([^\"]*)\" in the grocery store costs (\\$\\d+\\.\\d+)$")
	public void aInTheGroceryStoreCosts$(String itemName, @Transform(MoneyConverter.class) Money itemPrice) throws Throwable {
		Map<String, Money> priceChart = helper.getPriceChart();
		priceChart.put(itemName, itemPrice);
	}


	@When("^I buy (\\d+) \"([^\"]*)\"$")
	public void iBuy(int itemCount, String itemName) throws Throwable {
		Map<String, Money> priceChart = helper.getPriceChart();
		Money bill = helper.getBill();
		if (priceChart.containsKey(itemName)) {
			bill.addMoney(priceChart.get(itemName).multiplyBy(itemCount));
		} else {
			throw new PendingException("The item \"" + itemName + "\" has not yet been inserted in priceMap");
		}
		helper.setBill(bill);
	}


	@Then("^The final bill is (\\$\\d+\\.\\d+)$")
	public void theFinalBillIs$(@Transform(MoneyConverter.class) Money expected) throws Throwable {
		Money bill = helper.getBill();
		Assert.assertEquals("Incorrect bill calculation - ", expected, bill);
	}



}
