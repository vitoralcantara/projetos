package game.data;

public class Requisitos {

	private final String processador;
	private final String memória;
	private final String discoRigido;
	private final String directX;
	private final String placaVideo;

	public Requisitos(String processador, //
			String memória, //
			String discoRigido, //
			String directX, //
			String placaVideo) {
		super();
		this.processador = processador;
		this.memória = memória;
		this.discoRigido = discoRigido;
		this.directX = directX;
		this.placaVideo = placaVideo;
	}

	public String getProcessador() {
		return processador;
	}

	public String getMemória() {
		return memória;
	}

	public String getDiscoRigido() {
		return discoRigido;
	}

	public String getDirectX() {
		return directX;
	}

	public String getPlacaVideo() {
		return placaVideo;
	}

}
