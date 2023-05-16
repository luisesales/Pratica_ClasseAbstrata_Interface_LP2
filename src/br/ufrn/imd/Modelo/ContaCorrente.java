package br.ufrn.imd.Modelo;

public class ContaCorrente implements ITributavel {

	private String agencia,numero;
	private double saldo;
	
	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public void sacar(double valor) {
		if(saldo >= valor) {
			saldo-=valor;
			System.out.println("Saque de "+valor+" em ["+this.getNumero() +"] efetuado com sucesso!");
			System.out.println();
		}
		else {
			System.out.println("Saldo insuficiente pro saque ou valor menor que 0!");
			System.out.println();
		}
	}
	public void depositar(double valor) {
		saldo+=valor;
		System.out.println("Depósito de "+valor+" para ["+this.getNumero()+"] efetuado com sucesso!");
		System.out.println();
	}
	public boolean transferir(double valor, ContaCorrente cc) {
		if(saldo >= valor) {
			saldo-=valor;
			cc.setSaldo(cc.getSaldo()+valor);
			System.out.println("Transferência de "+valor+" para ["+cc.getNumero() +"] efetuada com sucesso!");
			System.out.println();
			return true;
		}
		else {
			System.out.println("Saldo insuficiente pra transferência ou valor menor que 0!");
			System.out.println();
			return false;
		}
	}
	public double calcularTributos() {
		return saldo*0.0038;		
	}
}
