package fraccion;

import java.util.Scanner;

/**
 * Escribe un programa en Java, que pida por teclado 2 fracciones arbitrarias y calcula la
 * suma, la resta, el producto y el cociente de ambas. Muestra también cuál de las dos
 * fracciones es mayor que la otra. 
 * @author Jairo González Lemus. Email : alu0100813272@ull.edu.es Universidad:
 *         Universidad de La Laguna. Práctica Asignatura: Modelado Sistemas Sofware.
 *         Nota:  Este diseÃ±o es un diseÃ±o por composicion. El que trata el try cach es el que te
 *         llama lanzo la execpcion.
 * @version 1.0
 * @since 2018-03-14
 */
public class Programa {
	
	public static void parteUno() {
		Scanner reader = new Scanner(System.in);
		int cont = 0 , num = 0 ,den = 0 ;
		Fraccion[] aux = new Fraccion[2] ;
		
		while(cont != 2) {
			System.out.println("Introduce numerador " + (cont + 1) + ": ");
			num = reader.nextInt();
			System.out.println("Introduce denominador " + (cont + 1) + ": ") ;
			den = reader.nextInt();
			aux[cont] = new Fraccion(num,den); 
			cont++;
		}
		
		System.out.println("Suma a y b : " + aux[0].add(aux[1]) );
		System.out.println("Resta a y b : " +aux[0].minus(aux[1]));
		System.out.println("Multiplica a y b : " +aux[0].multiply(aux[1]));
		System.out.println("Divide a y b : " +aux[0].divide(aux[1]));
	}
	/**
	 * Calcula la siguiente expresión: Invierte el resultado del
	 * cuadrado de la suma de 3/5 y 4/3. imprime en pantalla los resultados. 
	 */
	public static void parteDos() {
		Fraccion auxA = new Fraccion(3,5) ;
		auxA.print();
		Fraccion auxB = new Fraccion(4,3) ;
		auxB.print();
		
		Fraccion suma = auxA.add(auxB);
		suma.print();
		
		Fraccion resultado = suma.power(2);
		resultado.print();
		
		// Lo invierto
		resultado.reciprocal().print();
	
	}
	/**
	 * Implementa una función que calcule el máximo entre dos fracciones. 
	 */
	public static void parteTres() {
		Fraccion auxA = new Fraccion(3,5) ;
		Fraccion auxB = new Fraccion(4,3) ;
		
		System.out.println("De las dos fracciones la mayor es: ");
		if (!auxA.less(auxB)) {
			auxA.print();
		}else {
			auxB.print();
		}
	}
	
	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		// parteUno();
		// parteDos();
		parteTres();
	}
	

}
