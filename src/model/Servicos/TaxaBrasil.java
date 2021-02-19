package model.Servicos;

public class TaxaBrasil {

	public double Taxa (double valor) {
		if(valor >= 100.0) {
			return valor * 0.15;
		} else {
			return valor * 0.2;
		}
	}

}
