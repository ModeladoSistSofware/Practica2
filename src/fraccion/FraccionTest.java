package fraccion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FraccionTest {

	Fraccion frac; 
	
	@Before
	public void inciar(){
		frac = new Fraccion(5,2);
	}
	@Test
	public void gcdTest() {
		assertEquals(4,Fraccion.gcd(28,8));
		assertEquals(4,Fraccion.gcd(-8,28));
		assertEquals(-4,Fraccion.gcd(-8,-28));
		assertEquals(-4,Fraccion.gcd(8,-28));
	}
	
	@Test
	public void test() {
		assertNotNull(frac);
	}
	@Test
	public void mirarElValodDatosTest() {
		assertEquals(5,frac.getNumerador());
		assertEquals(2,frac.getDenominador());
	}
	@Test
	public void metodosSetterTest(){
		frac.setNumerador(3);
		assertEquals(3,frac.getNumerador());
		frac.setDenominador(5);
		assertEquals(5,frac.getDenominador());
	}
	@Test
	public void verExceptionDenominadorCeroTest(){
		  try {
			   Fraccion nueva = new Fraccion(1,0); 
			   fail("Se esperaba excepcion Exception");
		  } catch(IllegalArgumentException e) {
			  
		  }	
	}
	@Test
	public void verQueSeGuardaValorSimplificado(){
		   Fraccion fracNueva = new Fraccion(15000, 501); 
		   assertEquals(5000,fracNueva.getNumerador());
		   assertEquals(167,fracNueva.getDenominador());
		   // Si no se puede simplificar
		   Fraccion fracNew = new Fraccion(5000, 167); 
		   assertEquals(5000,fracNew.getNumerador());
		   assertEquals(167,fracNew.getDenominador());
		   // Si se introuduce un valor en en numerado de 0
		   Fraccion fracOtro = new Fraccion(0, 167); 
		   assertEquals(0,fracOtro.getNumerador());
		   assertEquals(1,fracOtro.getDenominador());
		   
	}
	@Test
	public void verSiEsUnDecimalTest(){
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
	public void verSiEsEnteroTest(){
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
	public void verSiEsFraccionTest(){
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
	public void verLosConstruTest(){
		// Constructor por defecto.
		Fraccion aux0 = new Fraccion();
		assertEquals(0, aux0.getNumerador());
		assertEquals(1, aux0.getDenominador());
		
		// Constructro se le pasa un long.
		Fraccion aux1 = new Fraccion(-100000000);
		assertEquals(-100000000, aux1.getNumerador());
		assertEquals(1, aux1.getDenominador());
		
		// Construcotr se le pasa n y d.
		Fraccion aux2= new Fraccion(-10,2);
		assertEquals(-5, aux2.getNumerador());
		assertEquals(1, aux2.getDenominador());
		
		// Constructor que se le pasa un double.
		Fraccion aux3 = new Fraccion(-15.02);
		assertEquals(-751, aux3.getNumerador());
		assertEquals(50, aux3.getDenominador());
	}
	// vemos esl funcionamiento del congrucco que sele pasa un stirng.
	@Test
	public void verConstructorStringTest(){
			
		// Constructro se le pasa un long.
		Fraccion aux1 = new Fraccion("-100000000");
		assertEquals(-100000000, aux1.getNumerador());
		assertEquals(1, aux1.getDenominador());
		
		// Construcotr se le pasa n y d.
		Fraccion aux2= new Fraccion("-10/2");
		assertEquals(-5, aux2.getNumerador());
		assertEquals(1, aux2.getDenominador());
		
		// Constructor que se le pasa un double.
		Fraccion aux3 = new Fraccion("-15.02");
		assertEquals(-751, aux3.getNumerador());
		assertEquals(50, aux3.getDenominador());
	}
	@Test
	public void verSignoTest(){
		Fraccion aux = new Fraccion();
		assertEquals(0, aux.sign());
		
		Fraccion aux1 = new Fraccion(+15,2);
		assertEquals(1, aux1.sign());
		
		Fraccion aux2 = new Fraccion(-15,2);
		assertEquals(-1, aux2.sign());
	}
	
	@Test
	public void verChangeSignoTest(){
		Fraccion aux1 = new Fraccion(+15,2);
		assertEquals(1, aux1.sign());
	    aux1.changeSing();
		assertEquals(-1, aux1.sign());
	}
	@Test
	public void verStringTest(){
		Fraccion aux1 = new Fraccion(+15,2);
		assertEquals("15/2", aux1.toString());
		aux1.setDenominador(1);
		assertEquals("15", aux1.toString());
	}
	@Test
	public void verRatioTest(){
		Fraccion aux1 = new Fraccion(15,2);
		assertEquals(7.5, aux1.ratio(),0.01);
	}
	@Test
	public void verCloneTest(){
		Fraccion aux1 = new Fraccion(15,2);
		Fraccion aux2 = (Fraccion) aux1.clone();
		assertNotSame(aux1, aux2);
		assertEquals(aux1.toString(), aux2.toString());
	}
	@Test
	public void verMcMTest(){
		
		assertEquals(84, Fraccion.lcm(28,12));
		assertEquals(140, Fraccion.lcm(28,35));
	}
}