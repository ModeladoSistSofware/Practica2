package fraccion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FraccionTest {

	Fraccion frac;

	@Before
	public void inciar() {
		frac = new Fraccion(5, 2);
	}

	@Test
	public void gcdTest() {
		assertEquals(4, Fraccion.gcd(28, 8));
		assertEquals(4, Fraccion.gcd(-8, 28));
		assertEquals(-4, Fraccion.gcd(-8, -28));
		assertEquals(-4, Fraccion.gcd(8, -28));
	}

	@Test
	public void test() {
		assertNotNull(frac);
	}

	@Test
	public void mirarElValodDatosTest() {
		assertEquals(5, frac.getNumerador());
		assertEquals(2, frac.getDenominador());
	}

	@Test
	public void metodosSetterTest() {
		frac.setNumerador(3);
		assertEquals(3, frac.getNumerador());
		frac.setDenominador(5);
		assertEquals(5, frac.getDenominador());
	}

	@Test
	public void verExceptionDenominadorCeroTest() {
		try {
			Fraccion nueva = new Fraccion(1, 0);
			fail("Se esperaba excepcion Exception");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void verQueSeGuardaValorSimplificado() {
		Fraccion fracNueva = new Fraccion(15000, 501);
		assertEquals(5000, fracNueva.getNumerador());
		assertEquals(167, fracNueva.getDenominador());
		// Si no se puede simplificar
		Fraccion fracNew = new Fraccion(5000, 167);
		assertEquals(5000, fracNew.getNumerador());
		assertEquals(167, fracNew.getDenominador());
		// Si se introuduce un valor en en numerado de 0
		Fraccion fracOtro = new Fraccion(0, 167);
		assertEquals(0, fracOtro.getNumerador());
		assertEquals(1, fracOtro.getDenominador());

	}

	@Test
	public void verSiEsUnDecimalTest() {
		assertTrue(Fraccion.isDecimal("2.545"));
		assertTrue(Fraccion.isDecimal("0.545"));
		assertTrue(Fraccion.isDecimal("-30.545"));
		assertTrue(Fraccion.isDecimal("+30.545"));
		assertTrue(Fraccion.isDecimal("+30,545"));
		assertTrue(Fraccion.isDecimal("+30 ,  545"));
		assertFalse(Fraccion.isDecimal("155"));
		assertFalse(Fraccion.isDecimal("-155"));
		// Si hay fallo al escribir
		assertTrue(Fraccion.isDecimal("2.5   45"));
		assertTrue(Fraccion.isDecimal("2.545   "));
		assertTrue(Fraccion.isDecimal("   2.545"));
		assertTrue(Fraccion.isDecimal(" +2   .545"));

	}

	@Test
	public void verSiEsEnteroTest() {
		assertFalse(Fraccion.isEntero("2.545"));
		assertFalse(Fraccion.isEntero("0.545"));
		assertFalse(Fraccion.isEntero("-30.545"));
		assertFalse(Fraccion.isEntero("+30.545"));
		assertTrue(Fraccion.isEntero("155"));
		assertTrue(Fraccion.isEntero("-155"));
		assertTrue(Fraccion.isEntero("+155"));
		// si hay espacio o trabuladcion o otra cosa.
		assertTrue(Fraccion.isEntero(" + 155 "));
	}

	@Test
	public void verSiEsFraccionTest() {
		assertFalse(Fraccion.isFraccion("23"));
		assertFalse(Fraccion.isFraccion("0.545"));
		assertFalse(Fraccion.isFraccion("-30.545"));
		assertFalse(Fraccion.isFraccion("+30,545"));
		assertFalse(Fraccion.isFraccion("+30, 545"));
		assertTrue(Fraccion.isFraccion("155/3"));
		assertTrue(Fraccion.isFraccion("-155/4"));
		assertTrue(Fraccion.isFraccion("+155/-1544"));

		// si hay espacio o trabuladcion o otra cosa.
		assertTrue(Fraccion.isFraccion("-15 5/-15  44"));
		assertTrue(Fraccion.isFraccion("-  155/-  1544"));
		assertTrue(Fraccion.isFraccion("-  155/-  1544      "));
		assertTrue(Fraccion.isFraccion("        +  155/-  1544      "));
	}

	@Test
	public void verLosConstruTest() {
		// Constructor por defecto.
		Fraccion aux0 = new Fraccion();
		assertEquals(0, aux0.getNumerador());
		assertEquals(1, aux0.getDenominador());

		// Constructro se le pasa un long.
		Fraccion aux1 = new Fraccion(-100000000);
		assertEquals(-100000000, aux1.getNumerador());
		assertEquals(1, aux1.getDenominador());

		// Construcotr se le pasa n y d.
		Fraccion aux2 = new Fraccion(-10, 2);
		assertEquals(-5, aux2.getNumerador());
		assertEquals(1, aux2.getDenominador());

		// Constructor que se le pasa un double.
		Fraccion aux3 = new Fraccion(-15.02);
		assertEquals(-751, aux3.getNumerador());
		assertEquals(50, aux3.getDenominador());
	}

	// vemos esl funcionamiento del congrucco que sele pasa un stirng.
	@Test
	public void verConstructorStringTest() {

		// Constructro se le pasa un long.
		Fraccion aux1 = new Fraccion("-100000000");
		assertEquals(-100000000, aux1.getNumerador());
		assertEquals(1, aux1.getDenominador());

		// Construcotr se le pasa n y d.
		Fraccion aux2 = new Fraccion("-10/2");
		assertEquals(-5, aux2.getNumerador());
		assertEquals(1, aux2.getDenominador());

		// Constructor que se le pasa un double.
		Fraccion aux3 = new Fraccion("-15.02");
		assertEquals(-751, aux3.getNumerador());
		assertEquals(50, aux3.getDenominador());
	}

	@Test
	public void verSignoTest() {
		Fraccion aux = new Fraccion();
		assertEquals(0, aux.sign());

		Fraccion aux1 = new Fraccion(+15, 2);
		assertEquals(1, aux1.sign());

		Fraccion aux2 = new Fraccion(-15, 2);
		assertEquals(-1, aux2.sign());
	}

	@Test
	public void verChangeSignoTest() {
		Fraccion aux1 = new Fraccion(+15, 2);
		assertEquals(1, aux1.sign());
		aux1 = aux1.changeSing();
		assertEquals(-1, aux1.sign());
	}

	@Test
	public void verStringTest() {
		Fraccion aux1 = new Fraccion(+15, 2);
		assertEquals("15/2", aux1.toString());
		aux1.setDenominador(1);
		assertEquals("15", aux1.toString());
	}

	@Test
	public void verRatioTest() {
		Fraccion aux1 = new Fraccion(15, 2);
		assertEquals(7.5, aux1.ratio(), 0.01);
	}

	@Test
	public void verCloneTest() {
		Fraccion aux1 = new Fraccion(15, 2);
		Fraccion aux2 = (Fraccion) aux1.clone();
		assertNotSame(aux1, aux2);
		assertEquals(aux1.toString(), aux2.toString());
	}

	@Test
	public void verMcMTest() {
		assertEquals(84, Fraccion.lcm(28, 12));
		assertEquals(140, Fraccion.lcm(28, 35));
	}

	@Test
	public void verOperacionesFraccionesTest() {
		Fraccion aux1 = new Fraccion(15, 2);
		Fraccion aux2 = new Fraccion(15, 2);

		Fraccion resul = aux1.add(aux2);
		assertEquals("15", resul.toString());

		resul = aux1.minus(aux2);
		assertEquals("0", resul.toString());

		resul = aux1.multiply(aux2);
		assertEquals("225/4", resul.toString());

		resul = aux1.divide(aux2);
		assertEquals("1", resul.toString());
	}

	@Test
	public void verOperacionesLongTest() {
		Fraccion aux1 = new Fraccion(15, 2);

		Fraccion resul = aux1.add(15);
		assertEquals("45/2", resul.toString());

		resul = aux1.minus(15);
		assertEquals("-15/2", resul.toString());

		resul = aux1.multiply(15);
		assertEquals("225/2", resul.toString());

		resul = aux1.divide(15);
		assertEquals("1/2", resul.toString());
	}

	@Test
	public void verFraccionInversTest() {
		try {
			Fraccion aux1 = new Fraccion();
			aux1.reciprocal();
			fail("Se esperaba excepcion Exception");
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
		Fraccion aux1 = new Fraccion(2, 15);
		Fraccion resul = aux1.reciprocal();
		assertEquals(15, resul.getNumerador());
		assertEquals(2, resul.getDenominador());
	}

	@Test
	public void verPowerTest() {
		Fraccion aux1 = new Fraccion(3, 4);
		Fraccion resul = aux1.power(-2);
		assertEquals(16, resul.getNumerador());
		assertEquals(9, resul.getDenominador());
	}

	// Testas para ver los metos de comparacion
	@Test
	public void verCompararTest() {
		Fraccion aux1 = new Fraccion(3, 4);
		Fraccion aux2 = new Fraccion(3, 4);
		Fraccion aux3 = new Fraccion(20, 1);
		assertTrue(aux1.equals(aux2));
		assertFalse(aux1.equals(aux3));

		assertTrue(aux1.less(aux3));
		assertFalse(aux3.less(aux1));

		assertTrue(aux1.lessEqual(aux2));
		assertTrue(aux1.lessEqual(aux3));

		assertFalse(aux3.lessEqual(aux1));
	}

	// Testas para ver los metos de comparacion
	@Test
	public void verPropiaTest() {
		Fraccion aux1 = new Fraccion(3, 4);
		assertTrue(aux1.isProper());
		aux1.setNumerador(500);
		assertFalse(aux1.isProper());
	}

	// Testas para ver los metos de comparacion
	@Test
	public void verGcdFraccionesTest() {
		Fraccion aux1 = new Fraccion(36, 88);
		Fraccion aux2 = new Fraccion(54, 70);
		Fraccion resultado =aux1.gcd(aux2);
		assertEquals("9/770", resultado.toString());
	}

	// Testas para ver los metos de comparacion
	@Test
	public void verlcmFraccionesTest() {
		Fraccion aux1 = new Fraccion(36, 88);
		Fraccion aux2 = new Fraccion(54, 70);
		Fraccion resultado =aux1.lcd(aux2);
		assertEquals("27", resultado.toString());
	}
}