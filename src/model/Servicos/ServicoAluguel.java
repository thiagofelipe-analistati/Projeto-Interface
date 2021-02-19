package model.Servicos;

import model.entidades.Aluguel;
import model.entidades.Pagamento;

public class ServicoAluguel {
	private Double ValorporHora;
	private Double ValorporDia;
	
	private TaxService taxService;
	
	public ServicoAluguel() {
		
	}

	

	public ServicoAluguel(Double valorporHora, Double valorporDia, TaxService taxaBrasil) {
		ValorporHora = valorporHora;
		ValorporDia = valorporDia;
		this.taxService = taxaBrasil;
	}

	public Double getValorporHora() {
		return ValorporHora;
	}

	public void setValorporHora(Double valorporHora) {
		ValorporHora = valorporHora;
	}

	public Double getValorporDia() {
		return ValorporDia;
	}

	public void setValorporDia(Double valorporDia) {
		ValorporDia = valorporDia;
	}

	public TaxService getTaxaBrasil() {
		return taxService;
	}

	public void setTaxaBrasil(TaxaBrasil taxaBrasil) {
		this.taxService = taxaBrasil;
	}

	public void processarPagamento (Aluguel aluguel) {
		//pegar os dados 
		long t1 = aluguel.getInicio().getTime();
		long t2 = aluguel.getFim().getTime();
		double valorBasico ;
	
		double horas = (double)(t2 - t1) / 1000 / 60 / 60;
		if (horas <= 12.0) {
			valorBasico =ValorporHora * Math.ceil(horas);
			}else {
				valorBasico = ValorporDia * Math.ceil(horas /24);
			}

		double tax = taxService.tax(valorBasico);
		aluguel.setPagamento(new Pagamento(valorBasico, tax));
	}
	
	}
