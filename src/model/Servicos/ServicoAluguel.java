package model.Servicos;

import model.entidades.Aluguel;
import model.entidades.Pagamento;

public class ServicoAluguel {
	private Double ValorporHora;
	private Double ValorporDia;
	
	private TaxaBrasil taxaBrasil;

	public ServicoAluguel() {
		
	}

	

	public ServicoAluguel(Double valorporHora, Double valorporDia, TaxaBrasil taxaBrasil) {
		ValorporHora = valorporHora;
		ValorporDia = valorporDia;
		this.taxaBrasil = taxaBrasil;
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

	public TaxaBrasil getTaxaBrasil() {
		return taxaBrasil;
	}

	public void setTaxaBrasil(TaxaBrasil taxaBrasil) {
		this.taxaBrasil = taxaBrasil;
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

		double tax = taxaBrasil.Taxa(valorBasico);
		aluguel.setPagamento(new Pagamento(valorBasico, tax));
	}
	
	}
