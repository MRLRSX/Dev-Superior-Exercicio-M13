package services;

import java.time.Duration;
import java.time.LocalDateTime;

import entities.CarRental;
import entities.Invoice;

public class RentalService {

	private Double pricePerDay;
	private Double pricePerHour;
	private TaxService taxService;

	public RentalService() {}
	public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {

		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	
	public TaxService getTaxService() {
		return taxService;
	}
	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		double duracao = dateRent(carRental.getDateStart(), carRental.getDateFinish());
        double basicPayment = duracao > 12 ?  Math.ceil(duracao / 24) * this.pricePerDay : Math.ceil(duracao) * this.pricePerHour;
        carRental.setInvoice(new Invoice(basicPayment, taxService.tax(basicPayment)));
	}
	
	private double dateRent(LocalDateTime start, LocalDateTime finish){
		return (double) Duration.between(start, finish).toHours();
	}
    
}
