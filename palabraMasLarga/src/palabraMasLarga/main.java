package palabraMasLarga;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) {
		
		
		System.out.println("Dime el nombre de fichero que quieres abrir: ");
		
		String palabraLarga = null; //Aqui iremos guardando la palabra mas larga
		String palabraAComparar; //Aqui se iran guardando las palabras que vamos a comparar
		int caracteresPalabra = 0; //Para compararla utilizaremos los caracteres de la misma
		
		
		try(Scanner sc = new Scanner(System.in)) { //El scanner nos permite leer de teclado
			String nombreFichero = sc.nextLine(); //Guardamos en una variable lo escrito por teclado
			
			
		try(FileReader fichero = new FileReader(nombreFichero)) {//Intentara abrir el fichero con el nombre
																		//de teclado + extension
			
			BufferedReader br = new BufferedReader(fichero); 			//lee el fichero
			
			
		String s = null; //Aqui iremos guardando las lineas leidas por el buffer
		
		
		while(( s = br.readLine()) != null) { //Mientras que haya lineas para leer:
			
			StringTokenizer st = new StringTokenizer(s, "-', ");	//StringTokenizer nos separara las lineas a nuestro
																//criterio (en este caso por , o por espacio
		
			
		while(st.hasMoreTokens()) { //Mientras que haya mas tokens (medida en la que hemos dividido las lineas)
			
			palabraAComparar = st.nextToken(); //Esta sera la palabra a comparar con la larga
			
			
			int tamañoPalabraAComparar = palabraAComparar.length(); //Conseguimos el tamaño de la palabra a comparar
																	//para poder compararla con la larga
			
			if(tamañoPalabraAComparar > caracteresPalabra) { //Si la nueva es mayor que la anterior
				
				palabraLarga = palabraAComparar; //la comparada se convertira en la larga en esta vuelta
				caracteresPalabra = tamañoPalabraAComparar; //La cantidad de caracteres de la larga se actualiza
				
			} 
		}
			
		} System.out.println("La palabra mas larga es: " + palabraLarga); //Nos saca por pantalla la palabra mas larga
			
			
		} catch (FileNotFoundException e) {
			
			System.out.println("El fichero no fue encontrado o no se pudo abrir"); //En caso de no encontrar el archivo
																				   //con la ruta seleccionada o que el 
																				   //archivo no exista
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		}

	}

}
