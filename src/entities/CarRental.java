package entities;

import java.time.LocalDateTime;

public class CarRental {
	
	private LocalDateTime dateStart;
	private LocalDateTime dateFinish;
    private Vehicle vehicle;
    private Invoice invoice;
	
	
	public CarRental(LocalDateTime dateStart, LocalDateTime dateFinish, Vehicle vehicle) {

		this.dateStart = dateStart;
		this.dateFinish = dateFinish;
		this.vehicle = vehicle;
	}

	public LocalDateTime getDateStart() {
		return dateStart;
	}

	public void setDateStart(LocalDateTime dateStart) {
		this.dateStart = dateStart;
	}

	public LocalDateTime getDateFinish() {
		return dateFinish;
	}

	public void setDateFinish(LocalDateTime dateFinish) {
		this.dateFinish = dateFinish;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
    
}
