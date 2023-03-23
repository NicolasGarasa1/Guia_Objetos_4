package MovieStore.Prestamo;
import MovieStore.Cliente.Cliente;
import MovieStore.Pelicula.Pelicula;

public class Prestamo {
    // ATRIBUTOS
    private String Fecha_Retiro;
    private String Fecha_Devolucion;
    private Pelicula Pelicula_Alquilada;
    private Cliente Cliente_Alquilador;
    private boolean Activo;

    // METODOS

    // CONSTRUCTORES
    public Prestamo(String Fecha_Retiro, String _Fecha_Devolucion, Pelicula _Pelicula_Alquilada, Cliente _Cliente_Alquilador){
        setFecha_Retiro(Fecha_Retiro);
        setFecha_Devolucion(_Fecha_Devolucion);
        setPelicula_Alquilada(_Pelicula_Alquilada);
        setCliente_Alquilador(_Cliente_Alquilador);
        setActivo(true);
    }

    // GETTERS AND SETTERS
    private String getFecha_Retiro() {
        return Fecha_Retiro;
    }
    private void setFecha_Retiro(String fecha_Retiro) {
        Fecha_Retiro = fecha_Retiro;
    }
    private String getFecha_Devolucion() {
        return Fecha_Devolucion;
    }
    private void setFecha_Devolucion(String fecha_Devolucion) {
        Fecha_Devolucion = fecha_Devolucion;
    }
    private Pelicula getPelicula_Alquilada() {
        return Pelicula_Alquilada;
    }
    private void setPelicula_Alquilada(Pelicula pelicula_Alquilada) {
        Pelicula_Alquilada = pelicula_Alquilada;
    }
    private Cliente getCliente_Alquilador() {
        return Cliente_Alquilador;
    }
    private void setCliente_Alquilador(Cliente cliente_Alquilador) {
        Cliente_Alquilador = cliente_Alquilador;
    }
    private boolean isActivo() {
        return Activo;
    }
    private void setActivo(boolean activo) {
        Activo = activo;
    }
}
