package services;

public class BrazilTaxService implements TaxService {

	@Override
	public Double tax(double amount) {
		if (amount <= 100.00) {
			return amount * 0.2;
		}
		return amount * 0.15;
	}
}
