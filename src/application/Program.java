package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.CarRental;
import entities.Vehicle;
import services.BrazilTaxService;
import services.RentalService;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner entrada = new Scanner(System.in);
		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");

		System.out.println("Enter Rental Data");
		System.out.print("Car model: ");
		String carModel = entrada.nextLine();
		System.out.print("Pickup (dd/MM/yyyy HH:mm ");
		LocalDateTime data01 = LocalDateTime.parse(entrada.nextLine(), dataFormatada);
		System.out.print("Return (dd/MM/yyyy HH:mm ");
		LocalDateTime data02 = LocalDateTime.parse(entrada.nextLine(), dataFormatada);

		CarRental carRental = new CarRental(data01, data02, new Vehicle(carModel));

		System.out.print("Enter price per hour: ");
		Double pricePerHour = entrada.nextDouble();
		System.out.print("Enter price ér day: ");
		Double pricePerDay = entrada.nextDouble();

		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());

		rentalService.processInvoice(carRental);
		
		System.out.printf("\nINVOICE:\n");
		System.out.println("Basic payment: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
		System.out.println("Total payment: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));

		entrada.close();
	}
}
