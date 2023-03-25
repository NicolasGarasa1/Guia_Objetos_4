package MovieStore.Prestamo;
import MovieStore.Cliente.Cliente;
import MovieStore.Local;
import MovieStore.Pelicula.Pelicula;

import java.time.LocalDate;

public class Prestamo {
    // ATRIBUTOS
    private LocalDate Fecha_Retiro;
    private LocalDate Fecha_Devolucion;
    private int Cliente_Id;
    private int Pelicula_Id;
    private boolean Activo;

    // METODOS
    public void Finalizar_Devolucion(){
        setActivo(false);
    }

    // CONSTRUCTORES
    public Prestamo(LocalDate _Fecha_Retiro, LocalDate _Fecha_Devolucion, int _Pelicula_Id, int _Cliente_Id){
        setFecha_Retiro(_Fecha_Retiro);
        setFecha_Devolucion(_Fecha_Devolucion);
        setCliente_Id(_Cliente_Id);
        setPelicula_Id(_Pelicula_Id);
        setActivo(true);
    }
    public Prestamo(LocalDate _Fecha_Retiro, LocalDate _Fecha_Devolucion, int _Pelicula_Id, int _Cliente_Id, boolean _Activo){
        setFecha_Retiro(_Fecha_Retiro);
        setFecha_Devolucion(_Fecha_Devolucion);
        setCliente_Id(_Cliente_Id);
        setPelicula_Id(_Pelicula_Id);
        setActivo(_Activo);
    }

    // GETTERS
    public int getCliente_Id() {
        return Cliente_Id;
    }
    public int getPelicula_Id() {
        return Pelicula_Id;
    }
    public boolean isActivo() {
        return Activo;
    }
    public LocalDate getFecha_Retiro() {
        return Fecha_Retiro;
    }
    public LocalDate getFecha_Devolucion() {
        return Fecha_Devolucion;
    }

    // SETTERS
    private void setCliente_Id(int cliente_Id) {
        Cliente_Id = cliente_Id;
    }
    private void setPelicula_Id(int pelicula_Id) {
        Pelicula_Id = pelicula_Id;
    }
    private void setActivo(boolean activo) {
        Activo = activo;
    }
    private void setFecha_Retiro(LocalDate fecha_Retiro) {
        Fecha_Retiro = fecha_Retiro;
    }
    private void setFecha_Devolucion(LocalDate fecha_Devolucion) {
        Fecha_Devolucion = fecha_Devolucion;
    }
}
