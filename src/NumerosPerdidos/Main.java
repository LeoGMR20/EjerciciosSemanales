package NumerosPerdidos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> numeros, numerosPerdidos;
        int cantNumLista = ingresarCantNumLista();
        numeros = ingresarNumLista(cantNumLista);
        System.out.println(numeros.size());
        Collections.sort(numeros);
        System.out.println(numeros);
        //numeros.add(0,55); -> Para comprobar la validación de que está ordenado xd
        if (resultadoOrdenado(numeros)){ //Si el ArrayList está ordenado
            numerosPerdidos = calcNumPer(numeros);
            if (!numerosPerdidos.isEmpty()){//Si el retorno de los números perdidos está vacío
                System.out.println("Los números perdidos del ArrayList " + numeros +
                        " son:\n" +
                        numerosPerdidos);
            }
            else {
                System.out.println("No hay números perdidos en el ArrayList "+ numeros);
            }
        }
        System.out.print("Pulse una tecla y enter para salir del programa: ");
        scanner.next();
    }

    //Funciones para ingresar un ArrayList y sus datos

    private static int ingresarCantNumLista() {
        int cantNum;
        do{
            System.out.print("Ingrese la cantidad de números que desea ingresar " +
                    "(debe ser entero positivo): ");
            cantNum = scanner.nextInt();
        }while (cantNum <= 0);
        System.out.flush();
        return cantNum;
    }

    private static ArrayList<Integer> ingresarNumLista(int cant) {
        ArrayList<Integer> lista = new ArrayList<>();
        int numIngresar;
        System.out.println("Ingrese números enteros (No repetidos).");
        for (int i = 0; i < cant; i++) {
            System.out.printf("%d: " ,(i + 1));
            numIngresar = scanner.nextInt();
            if (!lista.contains(numIngresar)){//Para no ingresar valores repetidos
                lista.add(numIngresar);
            }
            else{
                System.out.println("No se permiten número repetidos.\nIngrese otro número.");
                i--;
            }
        }
        return lista;
    }

    //Funciones para saber sí el ArrayList está ordenado o no

    private static boolean resultadoOrdenado(ArrayList<Integer> listaOrdenada) {
        //Mensajes de si el ArrayList está ordenado
        if(ordenado(listaOrdenada)){
            System.out.println("Lista correctamente ordenada");
            return true;
        }
        else {
            System.out.println("Lista no ordenada");
        }
        return false;
    }

    private static boolean ordenado(ArrayList<Integer> listaOrdenada) {
        //Verificar si el ArrayList está ordenado
        for (int i = 0; i < listaOrdenada.size() - 1; i++) {
            if (listaOrdenada.get(i) > listaOrdenada.get(i + 1)){
                return false;
            }
        }
        return true;
    }

    /*Función para calcular y retornar todos los que faltan entre
    el mayor y el menor de la lista o array de números.*/

    private static ArrayList<Integer> calcNumPer(ArrayList<Integer> listaNum){
        ArrayList<Integer> perdidos = new ArrayList<>();
        for (int i = listaNum.get(0) + 1; i < listaNum.get(listaNum.size() - 1); i++) {
            if (!listaNum.contains(i)){
                perdidos.add(i);
            }
        }
        return perdidos;
    }
}
