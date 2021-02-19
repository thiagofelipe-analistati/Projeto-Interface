package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.Servicos.ServicoAluguel;
import model.Servicos.TaxaBrasil;
import model.entidades.Aluguel;
import model.entidades.Veiculo;

public class Programa {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Dados do Aluguel: ");
		System.out.print("Modelo do Carro: ");
		String modelo = sc.nextLine();
		System.out.print("Data e hora da Retirada do ve�culo: ");
		Date inicio = sdf.parse(sc.nextLine());
		System.out.print("Data e hora da entrega do ve�culo: ");
		Date fim = sdf.parse(sc.nextLine());
		
		Aluguel aluguel = new Aluguel(inicio, fim, new Veiculo(modelo));
		
		System.out.print("digite o pre�o por Horas: ");
		double precoPorHora = sc.nextDouble();
		System.out.print("digite o pre�o por Dia: ");
		double precoPorDia = sc.nextDouble();
		
		ServicoAluguel sa = new ServicoAluguel(precoPorHora, precoPorDia, new TaxaBrasil());
		
		sa.processarPagamento(aluguel);
		System.out.println("Pagamento: ");
		
		System.out.println("Pagamento B�sico : " + String.format("%.2f", aluguel.getPagamento().getValorBasico()));
		System.out.println("Pagamento da taxa : " + String.format("%.2f", aluguel.getPagamento().getTaxImposto()));
		System.out.println("Pagamento total : " + String.format("%.2f", aluguel.getPagamento().getValorTotal()));
		sc.close();

	}

}
