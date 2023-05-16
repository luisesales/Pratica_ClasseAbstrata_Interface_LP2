package br.ufrn.imd.controle;

import br.ufrn.imd.Modelo.Pessoa;

public class GeradorImpostoRenda {
	private double totalTributo;
	public double calculaValorTotalTributo(Pessoa p) {
		totalTributo = p.getConta().calcularTributos()+p.getSeguro().calcularTributos() +p.calcularTributos();
		return totalTributo;
	}
}
