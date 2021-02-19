package model.entidades;

public class Pagamento {
	private Double ValorBasico;
	private Double taxImposto;
	
	public Pagamento() {
	}
	
	public Pagamento(Double valorBasico, Double taxImposto) {
		ValorBasico = valorBasico;
		this.taxImposto = taxImposto;
	}

	public Double getValorBasico() {
		return ValorBasico;
	}

	public void setValorBasico(Double valorBasico) {
		ValorBasico = valorBasico;
	}

	public Double getTaxImposto() {
		return taxImposto;
	}

	public void setTaxImposto(Double taxImposto) {
		this.taxImposto = taxImposto;
	}
	public Double getValorTotal() {
		return getTaxImposto()+ getValorBasico();
	}
}
