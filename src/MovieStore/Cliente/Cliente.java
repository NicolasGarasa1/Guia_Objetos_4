    package MovieStore.Cliente;

    import MovieStore.Prestamo.Prestamo;

    import java.util.ArrayList;

    public class Cliente {
    // ATRIBUTOS
    private int Identificador;
    private String Nombre;
    private String Telefono;
    private String Direccion;
    private ArrayList<Prestamo> Ultimas_Peliculas_Alquiladas;
    private static int Contador_Id=0;

    // METODOS


    // CONSTRUCTORES
    public Cliente(String _Nombre, String _Telefono, String _Direccion){
        setIdentificador(getContador_Id());
        setContador_Id(getContador_Id()+1);
        setNombre(_Nombre);
        setDireccion(_Direccion);
        setTelefono(_Telefono);
        setUltimas_Peliculas_Alquiladas(new ArrayList<>(5));
    }

    // GETTERS AND SETTERS
    public int getIdentificador() {
        return Identificador;
    }
    private void setIdentificador(int identificador) {
        Identificador = identificador;
    }
    public String getNombre() {
        return Nombre;
    }
    private void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getTelefono() {
        return Telefono;
    }
    private void setTelefono(String telefono) {
        Telefono = telefono;
    }
    public String getDireccion() {
        return Direccion;
    }
    private void setDireccion(String direccion) {
        Direccion = direccion;
    }
    public ArrayList<Prestamo> getUltimas_Peliculas_Alquiladas() {
        return Ultimas_Peliculas_Alquiladas;
    }
    private void setUltimas_Peliculas_Alquiladas(ArrayList<Prestamo> ultimas_Peliculas_Alquiladas) {
        Ultimas_Peliculas_Alquiladas = ultimas_Peliculas_Alquiladas;
    }
    private static int getContador_Id() {
        return Contador_Id;
    }
    private static void setContador_Id(int contador_Id) {
        Contador_Id = contador_Id;
    }
}