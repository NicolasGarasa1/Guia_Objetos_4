package MovieStore;

import MovieStore.Cliente.Cliente;
import MovieStore.Pelicula.Pelicula;
import MovieStore.Prestamo.Prestamo;

import java.util.ArrayList;

public class Local {
    // ATRIBUTO
    private ArrayList<Pelicula> Peliculas;
    private ArrayList<Cliente> Clientes;
    private ArrayList<Prestamo> Prestamos;
    private int Saldo;
    // METODOS

    // CONSTRUCTOR
    public Local(){
        setPrestamos(new ArrayList<>());
        setClientes(new ArrayList<>());
        setPeliculas(new ArrayList<>());
        setSaldo(0);
    }

    // GETTERS AND SETTERS

    private ArrayList<Pelicula> getPeliculas() {
        return Peliculas;
    }
    private void setPeliculas(ArrayList<Pelicula> peliculas) {
        Peliculas = peliculas;
    }
    private ArrayList<Cliente> getClientes() {
        return Clientes;
    }
    private void setClientes(ArrayList<Cliente> clientes) {
        Clientes = clientes;
    }
    private ArrayList<Prestamo> getPrestamos() {
        return Prestamos;
    }
    private void setPrestamos(ArrayList<Prestamo> prestamos) {
        Prestamos = prestamos;
    }
    private int getSaldo() {
        return Saldo;
    }
    private void setSaldo(int saldo) {
        Saldo = saldo;
    }
}
