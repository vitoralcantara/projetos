package com.cakes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ConcreteServidor extends AbstractServidor {
	BufferedReader br;

	public ConcreteServidor() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String lerLinha() throws IOException {
		return br.readLine();
	}

	public boolean temDados() throws IOException {
		return br.ready();
	}

	public void abrirConexao(String arquivo) throws FileNotFoundException {
		Reader r = new FileReader(arquivo);
		br = new BufferedReader(r);
	}
}