package senha.core;

import java.util.List;

public class Senha {

	private List<Integer> senha;

	public List<Integer> getSenha() {
		return senha;
	}

	public void setSenha(List<Integer> senha) {
		this.senha = senha;
	}
	
	public void printSenha() {
		for(int s : senha) {
			System.out.print(s + " ");
		}
	}

}
