package Peliculas;

public class Pelicula {
    // ATRIBUTOS
    private int Identificador;
    private String Titulo;
    private String Fecha_Lanzamiento;
    private int Duracion;
    private String Clasificacion_Audiencia;
    private String Pais_Origen;
    private String Descripcion;
    private int Stock;
    
    private static int Contador_Id = 0;
    
    // METODOS


    // CONSTRUCTORES
    public Pelicula(String _Titulo, String _Fecha_Lanzamiento, int _Duracion, String _Clasificacion_Audiencia, String _Pais_Origen, String _Descripcion, int _Stock){
        setIdentificador(getContador_Id());
        setContador_Id(getContador_Id()+1);
        setTitulo(_Titulo);
        setFecha_Lanzamiento(_Fecha_Lanzamiento);
        setDuracion(_Duracion);
        setClasificacion_Audiencia(_Clasificacion_Audiencia);
        setPais_Origen(_Pais_Origen);
        setDescripcion(_Descripcion);
        setStock(_Stock);
    }


    // GETTERS AND SETTERS
    public int getIdentificador() {
        return Identificador;
    }
    private void setIdentificador(int identificador) {
        Identificador = identificador;
    }
    public String getTitulo() {
        return Titulo;
    }
    private void setTitulo(String titulo) {
        Titulo = titulo;
    }
    public String getFecha_Lanzamiento() {
        return Fecha_Lanzamiento;
    }
    private void setFecha_Lanzamiento(String fecha_Lanzamiento) {
        Fecha_Lanzamiento = fecha_Lanzamiento;
    }
    public int getDuracion() {
        return Duracion;
    }
    private void setDuracion(int duracion) {
        Duracion = duracion;
    }
    public String getClasificacion_Audiencia() {
        return Clasificacion_Audiencia;
    }
    private void setClasificacion_Audiencia(String clasificacion_Audiencia) {
        Clasificacion_Audiencia = clasificacion_Audiencia;
    }
    public String getPais_Origen() {
        return Pais_Origen;
    }
    private void setPais_Origen(String pais_Origen) {
        Pais_Origen = pais_Origen;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    private void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
    private int getStock() {
        return Stock;
    }
    private void setStock(int stock) {
        Stock = stock;
    }
    public static int getContador_Id() {
        return Contador_Id;
    }
    private static void setContador_Id(int contador_Id) {
        Contador_Id = contador_Id;
    }
}
