import MovieStore.Local;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner Teclado = new Scanner(System.in);
        int Swtch;
        int Continuar=1;
        do {
            MovieStore.MenuPrincipal();
            Swtch = Teclado.nextInt();
            switch (Swtch){
                case 1: // CLIENTES
                    MovieStore.MenuClientes(Teclado);
                    break;
                case 2: // PELICULAS
                    MovieStore.MenuPeliculas(Teclado);
                    break;
                case 3: // ALQUILERES
                    MovieStore.MenuAlquieleres(Teclado);
                    break;
                case 0: // SALIR
                    Continuar=0;
                    break;
                default: // VOLVER
                    break;
            }
        }while(Continuar==1);
        Teclado.close();
    }
    static Local MovieStore = new Local();

}