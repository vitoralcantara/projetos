package core;

public class Obi {
	public Boolean[] verificaPremioCurso(int numCompetidores,
			int pontuacaoMinima, int arrayNotas[][])
			throws ParametroInconsistenteException {

		if (arrayNotas == null) {
			throw new ParametroInconsistenteException(
					"Parâmetro notas de alunos inválido (está nulo)");
		}

		if (numCompetidores >= 1 && numCompetidores <= 1000
				&& pontuacaoMinima >= 1 && pontuacaoMinima <= 1000) {

			Boolean resul[] = new Boolean[numCompetidores];
			int nota;
			for (int i = 0; i < numCompetidores; i++) {
				if (arrayNotas[i][0] < 0 || arrayNotas[i][1] < 0
						|| arrayNotas[i][0] > 400 || arrayNotas[i][1] > 400) {
					throw new ParametroInconsistenteException(
							"valor fora dos limites validos");
				}

				nota = arrayNotas[i][0] + arrayNotas[i][1];
				if (nota >= pontuacaoMinima)
					resul[i] = true;
				else
					resul[i] = false;
			}
			return resul;
		} else {
			throw new ParametroInconsistenteException(
					"valor fora dos limites validos");
		}

	}

}
