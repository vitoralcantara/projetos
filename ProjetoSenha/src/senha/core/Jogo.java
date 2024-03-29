package senha.core;

import java.util.List;

public class Jogo {
	
	public void iniciarJogo() {

		// List<Jogada> jogadas = new ArrayList<Jogada>();

		imprimirInformacoesJogo();
		FornecedorDaSenha fds = new FornecedorDaSenha();
		fds.gerarNovaSenha();
		Senha senha = fds.getSenha();

		Adivinho adivinho = new Adivinho();
		Tentativa tentativa = adivinho.lerTentativa();
		Jogada jogada = new Jogada();
		jogada.setSitRetorno(senha);
		jogada.setSitTentativa(tentativa);
		jogada.calcularRetorno();
		if (jogada.acertou) {
			imprimirMensagemGanhou();
		}
	}

	private void imprimirMensagemGanhou() {
		// TODO Auto-generated method stub

	}

	public void imprimirResultado(Jogada jogada) {
		List<Integer> retorno = jogada.getRetorno().getRetorno();

		imprimirMensagemDeResultado();
		for (int i = 0; i < retorno.size(); i++) {
			char x = 0;
			switch (retorno.get(i)) {
			case 0:
				x = 'P';
				break;
			case 1:
				x = 'B';
				break;
			case 2:
				x = 'E';
				break;
			default:
				try {
					throw new Exception("Identificador inv�lido");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			System.out.print("| " + x);
		}
		System.out.println();
	}

	private void imprimirMensagemDeResultado() {
		// TODO Auto-generated method stub
		System.out.println();

	}

	private void imprimirInformacoesJogo() {
		// TODO Auto-generated method stub
		System.out
				.println("Versao experimental do Jogo. Por favor, insira seu jogo:");
	}

	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		jogo.iniciarJogo();
		System.out.println("1: P | B | P | B");
		System.out.println("2: P | B | P | B");
	}
}
