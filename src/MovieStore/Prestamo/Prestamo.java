package MovieStore.Prestamo;
import MovieStore.Cliente.Cliente;
import MovieStore.Pelicula.Pelicula;

public class Prestamo {
    // ATRIBUTOS
    private String Fecha_Retiro;
    private String Fecha_Devolucion;
    private int Cliente_Id;
    private int Pelicula_Id;
    private boolean Activo;

    // METODOS
    

    // CONSTRUCTORES
    public Prestamo(String Fecha_Retiro, String _Fecha_Devolucion, int _Pelicula_Id, int _Cliente_Id){
        setFecha_Retiro(Fecha_Retiro);
        setFecha_Devolucion(_Fecha_Devolucion);
        setCliente_Id(_Cliente_Id);
        setPelicula_Id(_Pelicula_Id);
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
    private int getCliente_Id() {
        return Cliente_Id;
    }
    private void setCliente_Id(int cliente_Id) {
        Cliente_Id = cliente_Id;
    }
    private int getPelicula_Id() {
        return Pelicula_Id;
    }
    private void setPelicula_Id(int pelicula_Id) {
        Pelicula_Id = pelicula_Id;
    }
    private boolean isActivo() {
        return Activo;
    }
    private void setActivo(boolean activo) {
        Activo = activo;
    }
}
