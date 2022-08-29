package NumerosPerdidos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        int num, cantNumLista = ingresarCantNumLista();
        numeros = ingresarNumLista(cantNumLista);
        System.out.println(numeros);
        Collections.sort(numeros);
        System.out.println(numeros);
    }

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
        ArrayList<Integer> lista = new ArrayList<Integer>();
        int numIngresar;
        System.out.println("Ingrese números enteros (No repetidos).");
        for (int i = 0; i < cant; i++) {
            System.out.printf("%d: " ,(i + 1));
            numIngresar = scanner.nextInt();
            if (!lista.contains(numIngresar)){
                lista.add(numIngresar);
            }
            else{
                System.out.println("No se permiten número repetidos.\nIngrese otro número.");
                i--;
            }
        }
        return lista;
    }
}
