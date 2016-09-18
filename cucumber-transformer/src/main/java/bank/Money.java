package bank;

import lombok.Data;

@Data
public class Money {

	private int dollars;
	private int cents;

	public Money(int dollars, int cents) {
		this.dollars = dollars;
		this.cents = cents;
	}

	public Money() {
		this(0, 0);
	}

	public Money addMoney(Money amount) {
		int currentCents = dollars * 100 + cents;
		int subtractCents = amount.getDollars() * 100 + amount.getCents();
		currentCents += subtractCents;
		dollars = currentCents / 100;
		cents = currentCents % 100;
		return this;
	}

	public Money subtractMoney(Money amount) {
		int currentCents = dollars * 100 + cents;
		int subtractCents = amount.getDollars() * 100 + amount.getCents();
		currentCents -= subtractCents;
		dollars = currentCents / 100;
		cents = currentCents % 100;
		return this;
	}

	public Money multiplyBy(int multiplier) {
		int currentCents = dollars * 100 + cents;
		currentCents *= multiplier;
		dollars = currentCents / 100;
		cents = currentCents % 100;
		return this;
	}


}
