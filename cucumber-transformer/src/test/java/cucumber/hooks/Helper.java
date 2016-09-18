package cucumber.hooks;

import bank.Money;

import java.util.HashMap;
import java.util.Map;

public class Helper {

	private double cucumberCount;
	private Map<String, Money> priceChart;
	private Money bill;


	public void setCucumberCount(double cucumberCount) {
		this.cucumberCount = cucumberCount;
	}

	public double getCucumberCount() {
		return cucumberCount;
	}

	public Map<String, Money> getPriceChart() {
		if (null == priceChart){
			priceChart = new HashMap<>();
		}
		return priceChart;
	}

	public Money getBill() {
		if(null == bill){
			bill = new Money();
		}
		return bill;
	}

	public void setBill(Money bill) {
		this.bill = bill;
	}
}
