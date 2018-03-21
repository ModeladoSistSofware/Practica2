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

}
