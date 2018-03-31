package fraccion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que almacenas el numerado y denominador. Tambien se hara operaciones
 * como si de una fraccion se tratase.
 * @author Jairo Gonz�lez Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Pr�ctica Asignatura: Modelado Sistemas Sofware.
 *         Nota:  Este diseño es un diseño por composicion. El que trata el try cach es el que te
 *         llama lanzo la execpcion.
 * @version 1.0
 * @since 2018-03-14
 */
public class Fraccion implements Cloneable{
	private long numerador;
	private long denominador;
	/**
	 * M�todo para clonado del objeto.
	 */
	public Object clone(){
		   Fraccion obj = null;
	        try{
	            obj=(Fraccion)super.clone();
	        }catch(CloneNotSupportedException ex){
	            System.out.println(" no se puede duplicar");
	        }
	        
	        return obj;
	 } 
	/**
	 * Constructor por defecot crea la fracc�on 0/1;
	 */
	Fraccion(){
		numerador = 0L;
		denominador = 1L;
	}
	/**
	 * Constructor que se le pasa solo el numerador de forma entera, 
	 * el denominado va ser siempre 1
	 * @param numerador
	 */
	Fraccion(long numerador){
		this();
		this.numerador = numerador;
	}
	/**
	 * Contructor que le pasaremos dos valores el numerador y denominador.
	 * @param numerador
	 * @param denominador
	 */
	Fraccion(long numerador, long denominador) throws IllegalArgumentException{
		this(numerador);
		if(denominador == 0){
			throw new IllegalArgumentException( "Denominador igual 0 Fracción no se construlle" );
		}
		// Si numerado es 0 siempre es 0/1 que es la fracci�n por defecto ya se ha creado antes
		if(numerador != 0) {
			this.denominador = denominador;
			simplificar();
			normalizarSigno();
		}
	}
	/**
	 * M�todo que crea la fracci�n decimal irreducible equvalente al n�mero decimal pasado 
	 * como argumetno.
	 * @param num
	 */
    Fraccion(double num){
    	this( (long)(num*(long)Math.pow(10, contDecimal( "" + num))), (long)Math.pow(10, contDecimal( "" + num))); 
    }
    /**
     * Devulve la cantidad de decimales que hay en el estrin que expresa un decimal
     * ejemplo le pasamo "2.33"  devolvera dos.
     * @param dato
     * @return
     */
   private static long contDecimal(String dato) {
    	Pattern pat = Pattern.compile("[.]\\d*$");
        Matcher mat = pat.matcher(dato);
        return mat.find() ? (mat.group().length()-1) : 0;
    }
    /**
	 * M�todo que crea la fracci�n decimal irreducible equvalente al n�mero decimal pasado 
	 * como argumetno y es de tipo string se puede pasar "#" o  "#/#".
	 * @param num
	 */
    Fraccion(String num){
    	setFraction(parseFraction(num)); //hacer un clonado.??? nira si devuelve
    }
    
    /**
     * M�todo que analiza el string que se la pasa y devuelve una fraccion.
     * @param s
     * @return
     */
    public static Fraccion parseFraction(String num) {
    		Fraccion result = null;
    	    if(isDecimal(num)) {
    	    	result = new Fraccion(Double.parseDouble(num));
    		}
    	    if(isEntero(num)) {
    	    	result = new Fraccion(Long.parseLong(num));
    	    }
    	    if(isFraccion(num)) {
    	    	String[] aux = num.split("/");
    	    	result = new Fraccion( Long.parseLong(aux[0]), Long.parseLong(aux[1]));
    	    }
    	    
			return result;
    }
    /**
     * M�todo que detecta si es un decimal de tipo 7.8 o +7.8 o -7.9...
     * tembien se puede separar con ,.
     * */
    public static Boolean isDecimal(String num)
    {
    	 return Pattern.matches( "^[-+]?\\d*(\\.|\\,)\\d*$", num.replaceAll("\\s*",""));
    }
    /**
     * M�todo que detecta si es un valor entero positivo o negativo 3 o -3 o +4.
     * */
    public static Boolean isEntero(String num)
    {
    	 return Pattern.matches( "^[-+]?\\d*$", num.replaceAll("\\s*",""));
    }
    /**
     * M�todo que detecta si es un valor en fracion como pro ejemplo 2/2 o +2/-1.
     * */
    public static Boolean isFraccion(String num)
    {
    	 return Pattern.matches( "^[-+]?\\d*[/][-+]?\\d*$", num.replaceAll("\\s*",""));
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
	/**
	 * M�todo para cambiar el signo de la fraccion.
	 */
	public Fraccion changeSing(){
			return new Fraccion( numerador *-1, denominador);
	}
	/**
	 * M�todo que simplifica la fracci�n
	 */
	private void simplificar(){
		long mcd = gcd(numerador,denominador);
		numerador/=mcd;
		denominador/=mcd;
	}
	/**
	 * M�todo que calculo el maximo comun divisor. La versión iterativa es más eficiente 
	 * para la implementación en una computadora.
	 * @param numA
	 * @param numB
	 * @return el valor mcd calculado.
	 */
	public static long gcd(long valorA, long valorB){
		long a,b,resto = 1;
		//Verifica que numerado es mayor.
		a = numeroMayor(valorA,valorB);
		b = numeroMenor(valorA,valorB);	
		resto = a % b;
	    while(resto != 0) { 
            a = b;
			b = resto;
			resto = a % b;
	    }
			
		return b;
	}
	/**
	 * M�todo que calculo el minimo comun multiplo. 
	 * @param numA
	 * @param numB
	 * @return el valor mcm calculado.
	 */
	public static long lcm(long valorA, long valorB){
        long mcm = 0;
        // seleccionamos el mayor
        long a = Math.max(valorA, valorB);
        long b = Math.min(valorA, valorB);
        mcm =  (a*b)/gcd(a,b);    
        return mcm;
    }
	/**
	 * M�todo que calcula el maximo comun diviso entre dos fracciones.
	 * Estas siempre van a ser ireducible no hay que comprobar nada.
	 * @param nueva
	 * @return
	 */
	public Fraccion gcd(Fraccion nueva) {	
		return new Fraccion(gcd(numerador,nueva.getNumerador()), 
				            lcm(denominador,nueva.getDenominador()));
	}
	/**
	 * M�todo que calcula el m�nimo comun multiplo entre dos fracciones.
	 * Estas siempre van a ser ireducible no hay que comprobar nada.
	 * @param nueva
	 * @return
	 */
	public Fraccion lcd(Fraccion nueva) {	
		return new Fraccion(lcm(numerador,nueva.getNumerador()), 
				            gcd(denominador,nueva.getDenominador()));
	}
	/**
	 * Devuleve el valor mayor de dos numero de tipo long
	 * @param valorA
	 * @param valorB
	 * @return
	 */
	private static long numeroMayor(long valorA, long valorB){
		return (valorA > valorB) ? valorA : valorB;
	}
	/**
	 * Devuleve el valor menor de dos numero de tipo long
	 * @param valorA
	 * @param valorB
	 * @return
	 */
	private static long numeroMenor(long valorA, long valorB){
		return (valorA > valorB) ? valorB : valorA;
	}
	/**
	 * Método que calculo el maximo comun divisor. La versi�n recusiva.
	 * @param numA
	 * @param numB
	 * @return el valor mcd calculado.
	 */
	public static long gcdR(long valorA, long valorB){
		if(valorB == 0) {
			return valorA;
		}else {
			return gcd(valorB,valorA%valorB);
		}
	}
	/**
	 * M�todo para obetenr el signo de la fracci�n.
	 * @return 1 si fracci�n es positiva , -1 negativa y 0 en otro caso.
	 */
	public int sign() {
		return (numerador == 0)? 0 : ( (numerador > 0)? 1 : -1 );
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
	/**
	 * M�todo que modifica la fracion  con los valores de la fraccion
	 * que se le pasa.
	 * @param nueva
	 */
	public void setFraction(Fraccion nuevaF) {
		numerador = nuevaF.getNumerador();
    	denominador = nuevaF.getDenominador();
	}
	/**
	 * C�lculo del valor en decima al hacer la fracci�n.
	 * @return
	 */
	public double ratio() {
		return (double)numerador / (double)denominador;
	}
	
	/** (sin Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (denominador != 1) ? numerador + "/" + denominador : numerador + "";
	}
	/**
	 * M�todo para imprimir una fraccion.
	 */
	 public void print() {
		 System.out.println(this);
	 }
	/**
	 * M�todo que realiza la operaci�n de suma con otra fracci�n.
	 * @param nueva
	 * @return
	 */
	 public Fraccion add( Fraccion nueva) {
		 return new Fraccion(numerador*nueva.getDenominador() + nueva.getNumerador()*denominador,denominador*nueva.getDenominador());
	 }
	 /**
	  * M�todo que realiza la operaci�n de resta con otra fracci�n.
	  * @param nueva
	  * @return
	  */
	 public Fraccion minus( Fraccion nueva) {
		 return add(nueva.changeSing());
		// return new Fraccion(numerador*nueva.getDenominador() - nueva.getNumerador()*denominador,denominador*nueva.getDenominador());
	 }
	 /**
	  * M�todo que realiza la operaci�n de multiplica con otra fracci�n.
	  * @param nueva
	  * @return
	  */
	 public Fraccion multiply( Fraccion nueva) {
		 return new Fraccion(numerador*nueva.getNumerador(), denominador*nueva.getDenominador());
	 }
	 /**
	  * M�todo que realiza la operaci�n de dividir con otra fracci�n.
	  * @param nueva
	  * @return
	  */
	 public Fraccion divide( Fraccion nueva) {
		 return multiply(nueva.reciprocal()); 
	 }
	 /**
	  * M�todo que realiza la operaci�n de suma con un entero grande
	  * @param nueva
	  * @return
	  */
	 public Fraccion add( long nueva) {
		 return new Fraccion(numerador + nueva*denominador, denominador);
	 }
	 /**
	  * M�todo que realiza la operaci�n de resta con un entero grande
	  * @param nueva
	  * @return
	  */
	 public Fraccion minus( long nueva) {
		 return add(nueva*-1);
		 //return new Fraccion(numerador - nueva*denominador, denominador);
	 }
	 /**
	  * M�todo que realiza la operaci�n de multiplicar con un entero grande
	  * @param nueva
	  * @return
	  */
	 public Fraccion multiply( long nueva) {
		 return new Fraccion(numerador*nueva, denominador);
	 }
	 /**
	  * M�todo que realiza la operaci�n de divide con un entero grande
	  * @param nueva
	  * @return
	  */
	 public Fraccion divide( long nueva) {
		 return new Fraccion(numerador, denominador*nueva); 
	 }
	 /**
	  * M�todo que invierte la fraccion si al invertir es 1/0 entonces
	  * se lanza una excepci�n.
	  * @throws ArithmeticException
	  */
	 public Fraccion reciprocal() throws ArithmeticException{
			if(numerador == 0){
				throw new  ArithmeticException( "Numerador igual 0 no se puede invertir" );
			}
		 return new Fraccion(denominador,numerador);
	 }
	 /**
	  * M�todo para calcular la potencia n-sima de uan fraccion.
	  * @param n_sima
	  */
	 public Fraccion power(int n_sima) {
		 if(n_sima < 0) {
			 return new Fraccion((long)Math.pow(denominador, Math.abs(n_sima)),
					              (long)Math.pow(numerador, Math.abs(n_sima)));
		 }else {
			 return new Fraccion((long)Math.pow(numerador, Math.abs(n_sima)), 
					             (long)Math.pow(denominador, Math.abs(n_sima)));
		 }
	 }
	/* (sin Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if( obj instanceof Fraccion) {
			if((this.numerador ==((Fraccion) obj).getNumerador())&&
					(this.denominador ==((Fraccion) obj).getDenominador())){
				return true;
			}
		}
		return false;
	}
	/**
	 * M�todo booleano que sice si la fraccion es menor que la que le pasamos.
	 * @param obj
	 * @return
	 */
	public boolean less(Object obj) {
		if( obj instanceof Fraccion) {
			if(this.ratio() < ((Fraccion) obj).ratio()) {
				return true;
			}
		}
		return false;
	}
	/**
	 * M�todo booleano que sice si la fraccion es menor que la que le pasamos.
	 * @param obj
	 * @return
	 */
	public boolean lessEqual(Object obj) {
		if( obj instanceof Fraccion) {
			if(equals(obj)||(less(obj))) {
				return true;
			}
		}
		return false;
	}
	/**
	 * M�todo booleano para saber si la fraci�n es propia. Es propia si el 
	 * valor absoluto de la fracci�n es menor a 1.
	 * @param obj
	 * @return
	 */
	public boolean isProper() {
		return (Math.abs( this.ratio()) < 1 ) ? true : false;
	}
	
}
