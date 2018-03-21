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
	private long numerador;
	private long denominador;
	
	Fraccion(){
		numerador = 0L;
		denominador = 1L;
	}
	
	/**
	 * Contructor que le pasaremos dos valores el numerador y denominador.
	 * @param numerador
	 * @param denominador
	 */
	Fraccion(long numerador, long denominador) throws IllegalArgumentException{
		if(denominador == 0){
			throw new IllegalArgumentException( "Denominador igual 0 Fracción no se construlle" );
		}
		
		this.numerador = numerador;
		this.denominador = denominador;
		normalizarSigno();
		simplificar();
	}
	/**
	 * Método que comprueba que el valor del denominador 
	 * sea negativo y normalizamos el signo.
	 */
	private void normalizarSigno(){
		// si es negativo el denominador normalizamos signo.
		if(denominador < 0 ){
			this.numerador *= -1;
			this.denominador *= -1;
		}
	}
	
	private void simplificar(){
		long mcd = mcd(numerador,denominador);
		numerador/=mcd;
		denominador/=mcd;
	}
	/**
	 * Método que calculo el maximo comun divisor. La versión iterativa es más eficiente 
	 * para la implementación en una computadora.
	 * @param numA
	 * @param numB
	 * @return el valor mcd calculado.
	 */
	public static long mcd(long valorA, long valorB){
		//long valorA=numA, valorB=numB, aux=0;
		long aux = 0;
		while( valorA > 0){
			aux = valorA;
			valorA = valorB % valorA;
			valorB = aux;
	    }  
		return valorB;
	}
	
	// si metemos 5.25 lo puedo tranforamr en 525/100 utilizar exprecion regurlas. -?/b3/b//b-?5/b si se introduce en extring.
	// 3/5+ esti es yb error signo + mal colocado.
	// parseFraction(). si determinao si es una fraccion o n
	// simplificar y hacer sumas y la resta par ano se me desborde los numero.
	// si tengo un enterr 3/5 + 3 = 18/5 por que se k 3 es un entero. se imprementa mas rapido.
	// fraccion mixta es 3 1/2;   3 + 1/2 y sabesmo k 172 es impropia.24/3 es 8 
	// implementa la clase
	// campo l aparate enter y otro la fraccion
	// sumas dos entermo mixto
	// calcula
	// simpre puedo pasar una 3 1/2 == 7/2== puedo pasa a fraccion y 
	// otro año se pidio amplicar la funcionalidad de la clase matriz y le digo una lista de vector de una orientacion pro fila
	// y la matriz puede tener una orientacion por fila o por columna suma multiplic ay divide y se basa en la calse matriz.
	// 10000 / 500 2?7
	// un resta es una suma pero cambiada de signo
	// divicion una multiplicacion ocn el oprenado de la derecha invertido.con dos linea sde codio una para el numero y otra
	// denominadron.
	// 0 es tanto positivo o negativo le pongo 0 y dpesu si se utliza se multiplica por 0 y dara 0 todo queda perfecto.
	// simplificar es un metodo private.
	// normaliza private de uso dinnterno y siempre se utliza.
	Fraccion(long n){}
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
	/**
	 * Método que cambiara los valor numerador que esta dentro
	 * de la clase.
	 * @param numerador
	 */
	public void setNumerador(long numerador) {
		this.numerador = numerador;
	}
	/**
	 * Método que cambiara el valor denominador que esta dentro
	 * de la clase.
	 * @param denominador
	 */
	public void setDenominador(long denominador) {
		this.denominador = denominador;
	}
	
	
}
