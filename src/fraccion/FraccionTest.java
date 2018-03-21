package fraccion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FraccionTest {

	Fraccion frac; 
	
	@Before
	public void inciar(){
		frac = new Fraccion();
	}
	@Test
	public void test() {
		assertNotNull(frac);
	}

}
