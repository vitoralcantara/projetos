package com.cakes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class Proxy {

	ConcreteServidor concreteServer;

	public Proxy() {
		System.out.println("Creating proxy at " + new Date());
	}

	public String lerArquivo(String arquivo) {
		concreteServer = new ConcreteServidor();
		try {
			concreteServer.abrirConexao(arquivo);
			StringBuilder sb = new StringBuilder();
			while (concreteServer.temDados()) {
				sb.append(concreteServer.lerLinha());
				sb.append("\n");
				return sb.toString();
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return null;
	}
}