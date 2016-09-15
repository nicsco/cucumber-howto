package cucumber.classic;

import java.util.HashMap;
import java.util.Map;

public class Helper {

	private double cucumberCount;
	private Map<String, Double> priceChart;
	private double bill;


	public void setCucumberCount(double cucumberCount) {
		this.cucumberCount = cucumberCount;
	}

	public double getCucumberCount() {
		return cucumberCount;
	}

	public Map<String, Double> getPriceChart() {
		if (null == priceChart){
			priceChart = new HashMap<>();
		}
		return priceChart;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}
}
