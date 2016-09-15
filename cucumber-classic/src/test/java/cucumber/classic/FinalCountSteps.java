package cucumber.classic;

import cucumber.api.java.en.Then;
import org.junit.Assert;

public class FinalCountSteps {

	Helper helper;

	public FinalCountSteps(Helper helper) {
		this.helper = helper;
	}

	@Then("^I have (\\d+) cucumbers$")
	public void iHaveCucumbers(int arg1) {
		double cucumbers = helper.getCucumberCount();
		Assert.assertEquals((double) arg1, cucumbers, 0);
	}


	@Then("^The final bill is \\$(\\d+\\.\\d+)$")
	public void theFinalBillIs$(double finalBill) throws Throwable {
		double bill = helper.getBill();
		Assert.assertEquals(finalBill, bill, 0);
	}


	@Then("^Each of us has a (\\d+)(\\.\\d+)? of cucumber\\(s\\)$")
	public void eachOfUsHasAOfCucumbers(int finalCountInteger, Double finalCountDecimal)  {
		double cucumbers = helper.getCucumberCount();
		double finalCount = finalCountInteger;
		if (null != finalCountDecimal){
			finalCount += finalCountDecimal;
		}
		Assert.assertEquals(finalCount, cucumbers, 0);
	}

}
