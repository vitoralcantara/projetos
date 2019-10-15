package com.cakes;

import java.util.Date;

public abstract class AbstractServidor {

	public void sayHello() {
		System.out.println(this.getClass().getSimpleName() + " says howdy at "
				+ new Date());
	}

}