package senha.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FornecedorDaSenha extends Jogador {
	private Senha senha;

	public void gerarNovaSenha() {
		List<Integer> novaSenha = new ArrayList<Integer>();
		for (int i = 0; i < 7; i++) {
			novaSenha.add(i);
		}
		Collections.shuffle(novaSenha);
		senha = new Senha();
		senha.setSenha(novaSenha.subList(0, 4));
	}

	public Senha getSenha() {
		return senha;
	}

	public void setSenha(Senha senha) {
		this.senha = senha;
	}

}
