package cz.bernhard.playground.cv;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class Money {

	private final Amount amount;
	private final Currency currency;
			
	public Money(Amount amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;		
	}

	public static Money czk(BigDecimal amount) {
		return new Money(Amount.of(amount), Currency.getInstance("CZK"));
	}	

	public static Money czk(int amount) {
		return czk(new BigDecimal(amount));
	}

	@Override
	public String toString() {
		return amount.getAmount() + " " + currency.getCurrencyCode(); 
	}
	
	public static class Amount {
		
		private final BigDecimal amount;

		private Amount(BigDecimal amount) {
			this.amount = amount;			
		}
		
		public static Amount of(BigDecimal amount) {
			return new Amount(amount);
		}
		
		
		public BigDecimal getAmount() {
			return amount;
		}
		
	}
	
	

	
	
}
