package br.ufrn.imd.Modelo;

public class SeguroVida implements ITributavel {
	private String beneficiado;
	private int numero;
	private double valor,taxa;
	public String getBeneficiado() {
		return beneficiado;
	}
	public void setBeneficiado(String beneficado) {
		this.beneficiado = beneficado;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getTaxa() {
		return taxa;
	}
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	public double calcularTributos() {
		return 31.5;
		
	}
}
