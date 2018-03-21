package fraccion;
/**
 * Clase que almacenas el numerado y denominador. Tambien se hara operaciones
 * como si de una fraccion se tratase.
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas Sofware.
 *         Nota:  Este diseño es un diseño por composicion. El que trata el try cach es el que te
 *         llama lanzo la execpcion.
 * @version 1.0
 * @since 2018-03-14
 */
public class Fraccion {
	long numerador;
	long denominador;
	/**
	 * Contructor que le pasaremos dos valores el numerador y denominador.
	 * @param numerador
	 * @param denominador
	 */
	Fraccion(long numerador, long denominador){
		this.numerador = numerador;
		this.denominador = denominador;
	}
	/**
	 * Método de accesos al dato numerador.
	 * @return el numerador.
	 */
	public long getNumerador() {
		return numerador;
	}
	/**
	 * Método de acceso al dato denominador.
	 * @return el denominador.
	 */
	public long getDenominador() {
		return denominador;
	}
	
}
