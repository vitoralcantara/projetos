package server;

import static game.data.Constante.ANO;
import static game.data.Constante.DIA;
import static game.data.Constante.DIRECTX;
import static game.data.Constante.DISCO;
import static game.data.Constante.ESTILOS;
import static game.data.Constante.FOTOS;
import static game.data.Constante.ICONE;
import static game.data.Constante.MEMORIA;
import static game.data.Constante.MES;
import static game.data.Constante.NOME;
import static game.data.Constante.PLACA_VIDEO;
import static game.data.Constante.PLATAFORMA;
import static game.data.Constante.PROCESSADOR;
import static game.data.Constante.PRODUTORA;
import static game.data.Constante.RESUMO;
import static game.data.Constante.VIDEOS;
import game.data.JogoData;
import game.data.Jogos;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.ContentType;

/**
 * Servlet implementation class ForumGameServer
 */
@WebServlet("/ForumGameServer")
public class ForumGameServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String JOGOS = "jogos";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForumGameServer() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String responseText = "";
		HashMap<String, JogoData> listaJogos = (new Jogos()).getJogos();

		Map<String, String[]> parameters = request.getParameterMap();

		if (parameters.containsKey(JOGOS)) {
			Set<String> jogoIndexes = listaJogos.keySet();

			for (String s : jogoIndexes) {
				JogoData jogo = listaJogos.get(s);
				responseText += s + "|" + jogo.getNomeDoJogo() + "|"
						+ jogo.getDiaLancamento() + "|"
						+ jogo.getMesLancamento() + "|"
						+ jogo.getAnoLancamento() + "#";
			}
		} else {
			Iterator<String> iterator = parameters.keySet().iterator();
			while (iterator.hasNext()) {
				String constante = iterator.next();
				String jogoIndex = parameters.get(constante)[0];
				if (constante.equals(NOME)) {
					responseText = listaJogos.get(jogoIndex).getNomeDoJogo();
					break;
				}
				if (PRODUTORA.toString().equals(constante)) {
					responseText = listaJogos.get(jogoIndex).getProdutora();
					break;
				}
				if (constante.equals(PROCESSADOR)) {
					responseText = listaJogos.get(jogoIndex).getRequisitos()
							.getProcessador();
					break;
				}
				if (constante.equals(VIDEOS)) {
					String[] videos = listaJogos.get(jogoIndex).getVideoURLs();
					if (videos.length > 0) {
						responseText += videos[0];
					}
					for (int i = 1; i < videos.length; i++) {
						responseText += "|" + videos[i];
					}
					break;
				}

				if (constante.equals(FOTOS)) {
					String[] fotos = listaJogos.get(jogoIndex).getImagemURLs();
					if (fotos.length > 0) {
						responseText += fotos[0];
					}
					for (int i = 1; i < fotos.length; i++) {
						responseText += "|" + fotos[i];
					}
					break;
				}

				if (constante.equals(ESTILOS)) {
					responseText = listaJogos.get(jogoIndex).getEstilo();
					break;
				}

				if (constante.equals(DIA)) {
					responseText = listaJogos.get(jogoIndex).getDiaLancamento()
							.toString();
					break;
				}

				if (constante.equals(MES)) {
					responseText = listaJogos.get(jogoIndex).getMesLancamento()
							.toString();
					break;
				}

				if (constante.equals(ANO)) {
					responseText = listaJogos.get(jogoIndex).getAnoLancamento()
							.toString();
					break;
				}
				if (constante.equals(PLATAFORMA)) {
					responseText = listaJogos.get(jogoIndex)
							.getPlataformasToString();
					break;
				}

				if (constante.equals(RESUMO)) {
					responseText = listaJogos.get(jogoIndex).getResumo();
					break;
				}

				if (constante.equals(ICONE)) {
					responseText = listaJogos.get(jogoIndex).getIconeURL();
					break;
				}

				if (constante.equals(MEMORIA)) {
					responseText = listaJogos.get(jogoIndex).getRequisitos()
							.getMemória();
					break;
				}

				if (constante.equals(DISCO)) {
					responseText = listaJogos.get(jogoIndex).getRequisitos()
							.getDiscoRigido();
					break;
				}
				if (constante.equals(DIRECTX)) {
					responseText = listaJogos.get(jogoIndex).getRequisitos()
							.getDirectX();
					break;
				}

				if (constante.equals(PLACA_VIDEO)) {
					responseText = listaJogos.get(jogoIndex).getRequisitos()
							.getPlacaVideo();
					break;
				}
			}
		}
		out.println(responseText);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
