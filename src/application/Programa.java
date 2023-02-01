package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Contrato;
import entities.Parcela;
import services.ContratoService;
import services.Paypal;

public class Programa {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Digite os dados do contrato:");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.print("Data de vencimento: ( DD/MM/AAAA ): ");
		LocalDate dataFmt = LocalDate.parse(sc.next(),fmt);

		System.out.print("Valor do contrato: ");
		Double valorContrato = sc.nextDouble();

		List<Parcela> parcelas = new ArrayList<>();
		Contrato contrato = new Contrato(numero, dataFmt, valorContrato, parcelas);

		System.out.print("Numero de parcelas: ");
		int numParcelas = sc.nextInt();

		ContratoService service = new ContratoService(new Paypal());
		service.processaContrato(contrato, numParcelas);
		
		System.out.println("Parcelas:");
		for(Parcela p : parcelas) {
			System.out.println(p);
		}
		sc.close();
	}
}
