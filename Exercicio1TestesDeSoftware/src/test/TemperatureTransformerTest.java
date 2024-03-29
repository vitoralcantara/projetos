package test;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import core.CelsiusTemperature;
import core.FahrenheitTemperature;
import core.Temperature;
import core.TemperatureTransformer;

/**
 * Por favor, ler comentário da classe {@link TemperatureTransformer}
 * 
 * @author MeineENildo
 * 
 */
public class TemperatureTransformerTest {

	public Double convert(Temperature t) {
		TemperatureTransformer x = new TemperatureTransformer();
		try {
			return x.convert(t).getValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Double convertCtoF(Double num) {
		CelsiusTemperature c = new CelsiusTemperature();
		try {
			c.setValue(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convert(c);
	}

	public Double convertFtoC(Double num) {
		FahrenheitTemperature f = new FahrenheitTemperature();
		try {
			f.setValue(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convert(f);
	}

	@Test
	public void testFreezeCelsius() {
		assertEquals(32.0, convertCtoF(0.0));
	}

	@Test
	public void testBoilCelsius() {
		assertEquals(212.0, convertCtoF(100.0));
	}

	// Este teste nao esta funcionando quando deveria estar.
	@Test
	public void testZeroCelsius() {
		assertEquals(-459, 4, convertCtoF(-273.0));
	}

	@Test
	public void testQualquerTemperaturaCelsius() {
		assertEquals(10, 13, convertCtoF(-12.15));
	}

	@Test
	public void testQualquerTemperaturaFahrenheit() {
		assertEquals(-24.555555555555557, convertFtoC(-12.20));
	}

	@Test
	public void testBoilFahrenheit() {
		assertEquals(100.0, convertFtoC(212.0));
	}

	@Test
	public void testZeroFahrenheit() {
		assertEquals(-273.0, convertFtoC(-459.4));
	}

}
