package senha.core;

/**
 * Classe inserida para fazer testes
 * @author ksdx
 *
 */
public class Main {
	public static void main(String[] args) {
		FornecedorDaSenha fs = new FornecedorDaSenha();
		fs.gerarNovaSenha();
		Senha s = fs.getSenha();
		s.printSenha();
	}
}
