import MovieStore.Local;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner Teclado = new Scanner(System.in);
        int Swtch;
        int Continuar=1;
        do {
            MovieStore.MenuPrincipal();
            Swtch = Teclado.nextInt();
            switch (Swtch) {
                case 1 -> // CLIENTES
                        MovieStore.MenuClientes(Teclado);
                case 2 -> // PELICULAS
                        MovieStore.MenuPeliculas(Teclado);
                case 3 -> // ALQUILERES
                        MovieStore.MenuAlquieleres(Teclado);
                case 0 -> // SALIR
                        Continuar = 0;
                default -> {
                } // VOLVER
            }
        }while(Continuar==1);
        Teclado.close();

    }
    static Local MovieStore = new Local();

}