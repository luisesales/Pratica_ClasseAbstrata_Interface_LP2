package br.ufrn.imd.DAO;

import br.ufrn.imd.Modelo.Pessoa;
import br.ufrn.imd.controle.GeradorImpostoRenda;
import java.util.ArrayList;

public class PessoaDAO {
	GeradorImpostoRenda gerador;
	ArrayList<Pessoa> pessoas;
	public PessoaDAO() {
		pessoas = new ArrayList<Pessoa>();
		gerador = new GeradorImpostoRenda();
	}
	public void cadastraPessoa(Pessoa p) {
		pessoas.add(p);
	}
	public void removePessoa(Pessoa p) {
		pessoas.remove(p);
	}
	public void listaPessoas() {
		for(Pessoa p : pessoas) {
			System.out.println("************************************************************");
			System.out.println("Nome...: "+ p.getNome()+ " Salário.: "+String.format("%.2f",p.getSalario()));
			System.out.println("Agência: "+p.getConta().getAgencia()+" Conta.: "+ p.getConta().getNumero()+"     Saldo.: "+String.format("%.2f",p.getConta().getSaldo()));
			System.out.println("Seguro.: "+p.getSeguro().getNumero()+ "       Beneficiário.: "+p.getSeguro().getBeneficiado());
			System.out.println("Valor Seguro: "+ String.format("%.2f",p.getSeguro().getValor()));
		}
		System.out.println("************************************************************");
		System.out.println();
		
	}
	public void calcularTributosPessoas() {
		for(Pessoa p : pessoas) {
			System.out.println("************************************************************");
			System.out.println("Nome...: "+ p.getNome()+ " IRPF...: "+ String.format("%.2f",gerador.calculaValorTotalTributo(p)));
		}
		System.out.println("************************************************************");
		System.out.println();
	}
	public void imprimeImpostoTotal() {
		double temp;
		double total = 0;
		Pessoa maiorImposto = pessoas.get(0), maiorBeneficiado = pessoas.get(0);
		for(Pessoa p : pessoas) {
			temp = gerador.calculaValorTotalTributo(p);
			if(temp > gerador.calculaValorTotalTributo(maiorImposto)) maiorImposto = p;
			if(p.getSeguro().getValor() > maiorBeneficiado.getSeguro().getValor()) maiorBeneficiado = p;
			total+= temp;
		}
		System.out.println("************************************************************");
		System.out.println("Total de Impostos recilhidos: "+String.format("%.2f",total));
		System.out.println("Pessoa com maior IRPF a pagar: "+maiorImposto.getNome());
		System.out.println("Valor: "+String.format("%.2f",gerador.calculaValorTotalTributo(maiorImposto)));
		System.out.println("Maior Beneficiado(a): "+ maiorBeneficiado.getSeguro().getBeneficiado());
		System.out.println("Valor Benefício: "+String.format("%.2f",maiorBeneficiado.getSeguro().getValor()));
		System.out.println("************************************************************");
		System.out.println();
	}
	
}
