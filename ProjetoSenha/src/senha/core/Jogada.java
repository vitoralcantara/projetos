package senha.core;

import java.util.ArrayList;
import java.util.List;

public class Jogada {

	private Tentativa sitTentativa;
	private Senha sitRetorno;
	private Retorno retorno;
	boolean acertou;

	public boolean acertou() {
		return acertou;
	}

	public Retorno getRetorno() {
		return retorno;
	}

	/**
	 * C�digo: 0 - Acertou cor e posi��o 1 - Acertou cor, mas posi��o n�o 2 - N�o
	 * tem a cor na lista
	 * 
	 * @param tentativa
	 * @param senha
	 * @return
	 */
	public void calcularRetorno() {
		List<Integer> lad = sitTentativa.getTentativa();
		List<Integer> s = sitRetorno.getSenha();
		List<Integer> r = new ArrayList<Integer>();
		int qtAcertos = 0;

		for (int i = 0; i < r.size(); i++) {
			if (lad.get(i) == s.get(i)) {
				r.add(0);
				qtAcertos++;
			} else if (s.contains(lad.get(i))) {
				r.add(1);
			} else {
				r.add(2);
			}
		}
		if (qtAcertos == 4) {
			acertou = true;
		}
		Retorno retorno = new Retorno();
		retorno.setRetorno(r);
		this.retorno = retorno;
	}

	public Tentativa getSitTentativa() {
		return sitTentativa;
	}

	public void setSitTentativa(Tentativa sitTentativa) {
		this.sitTentativa = sitTentativa;
	}

	public Senha getSitRetorno() {
		return sitRetorno;
	}

	public void setSitRetorno(Senha sitRetorno) {
		this.sitRetorno = sitRetorno;
	}

}
