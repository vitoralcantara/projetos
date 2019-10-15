package com.cakes;

public class ProxyDemo {

	public static void main(String[] args) {

		String arquivo = args[0];
		Proxy proxy = new Proxy();
		System.out.println(proxy.lerArquivo(arquivo));
	}
}