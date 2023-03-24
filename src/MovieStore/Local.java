package MovieStore;

import MovieStore.Cliente.Cliente;
import MovieStore.Pelicula.Pelicula;
import MovieStore.Prestamo.Prestamo;

import javax.management.loading.PrivateClassLoader;
import java.util.ArrayList;
import java.util.Scanner;

public class Local {
    // ATRIBUTO
    private ArrayList<Pelicula> Peliculas;
    private ArrayList<Cliente> Clientes;
    private ArrayList<Prestamo> Prestamos;
    private int Saldo;
    // METODOS -- PRINCIPALES
    public void MenuPrincipal(){
        System.out.print("\n Bienvenido.");
        System.out.print("\n Su saldo es de: 0.");
        System.out.print("\n Elija una de las siguientes opciones.");
        System.out.print("\n");
        System.out.print("\n 01 - Clientes");
        System.out.print("\n 02 - Peliculas");
        System.out.print("\n 03 - Alquileres");
        System.out.print("\n");
        System.out.print("\n 00 - Salir.");
        System.out.print("\n");
        System.out.print("\n Opcion elegida: ");
    }
    public void MenuClientes(Scanner Teclado){
        int Swtch=0;
        int Continuar=1;
        do {
            System.out.print("\n Bienvenido.");
            System.out.print("\n Elija una de las siguientes opciones.");
            System.out.print("\n");
            System.out.print("\n 01 - Ver todos los clientes.");
            System.out.print("\n 02 - Añadir un nuevo cliente.");
            System.out.print("\n 03 - Exportar todos los clientes.");
            System.out.print("\n 04 - Ver ultimas 5 peliculas alquiladas de un cliente.");
            System.out.print("\n");
            System.out.print("\n 00 - Volver.");
            System.out.print("\n");
            System.out.print("\n Opcion elegida: ");
            Swtch = Teclado.nextInt();
            switch (Swtch){
                case 1: // VER TODOS LOS CLIENTES
                    Mostrar_Todos_Clientes(Teclado);
                    break;
                case 2: // AÑADIR UN NUEVO CLIENTE
                    Añadir_Cliente(Teclado);
                    break;
                case 3: // EXPORTAR TODOS LOS CLIENTES
                    break;
                case 4: // VER ULTIMAS 5 PELICULAS DE UN CLIENTE
                    break;
                case 0:
                    Continuar=0;
                    break;
                default:
                    break;
            }
        }while(Continuar==1);
    }
    public void MenuPeliculas(Scanner Teclado){
        int Swtch=0;
        int Continuar=1;
        do {
            System.out.print("\n Bienvenido.");
            System.out.print("\n Elija una de las siguientes opciones.");
            System.out.print("\n 01 - Ver todas las peliculas.");
            System.out.print("\n 02 - Buscar una pelicula por Id.");
            System.out.print("\n 03 - Añadir una nueva pelicula.");
            System.out.print("\n 04 - Exportar todas las peliculas.");
            System.out.print("\n");
            System.out.print("\n Opcion elegida: ");
            Swtch = Teclado.nextInt();
            switch (Swtch){
                case 1: // VER TODAS LAS PELICULAS
                    Mostrar_Todas_Peliculas(Teclado);
                    break;
                case 2: // BUSCAR PELICULA POR ID
                    break;
                case 3: // AÑADIR UNA NUEVA PELICULA
                    Añadir_Pelicula(Teclado);
                    break;
                case 4: // EXPORTAR TODAS LAS PELICULAS
                    break;
                case 0:
                    Continuar=0;
                    break;
                default:
                    break;
            }
        }while(Continuar==1);
    }
    public void MenuAlquieleres(Scanner Teclado){
        int Swtch=0;
        int Continuar=1;
        do {
            System.out.print("\n Bienvenido.");
            System.out.print("\n Elija una de las siguientes opciones.");
            System.out.print("\n 01 - Ver todos los alquileres.");
            System.out.print("\n 02 - Ver alquileres vigentes.");
            System.out.print("\n 03 - Ver alquileres que terminan hoy.");
            System.out.print("\n 04 - Ver alquileres de cliente.");
            System.out.print("\n 05 - Generar un nuevo alquiler.");
            System.out.print("\n 06 - Exportar todos los alquileres.");
            System.out.print("\n");
            System.out.print("\n 00 - Volver.");
            System.out.print("\n");
            System.out.print("\n Opcion elegida: ");
            Swtch = Teclado.nextInt();
            switch (Swtch){
                case 1: // VER TODOS LOS ALQUILERES
                    break;
                case 2: // VER ALQUILERES VIGENTES
                    break;
                case 3: // VER ALQUILERES QUE TERMINAN HOY
                    break;
                case 4: // VER ALQUILERES DE UN CLIENTE
                    break;
                case 5: // GENERAR UN NUEVO ALQUILER
                    break;
                case 6: // EXPORTAR TODOS LOS ALQUILERES
                    break;
                case 0:
                    Continuar=0;
                    break;
                default:
                    break;
            }
        }while(Continuar==1);
    }

    // METODOS -- CLIENTES
    public void Añadir_Cliente(Scanner Teclado){
        String Nombre, Telefono, Direccion;

        Teclado.nextLine();
        System.out.print("\n Nombre: ");
        Nombre = Teclado.nextLine();

        Teclado.nextLine();
        System.out.print("\n Telefono: ");
        Telefono = Teclado.nextLine();

        Teclado.nextLine();
        System.out.print("\n Direccion: ");
        Direccion = Teclado.nextLine();

        Cliente Nuevo = new Cliente(Nombre, Telefono, Direccion);
        getClientes().add(Nuevo);

        Teclado.nextLine();
        System.out.print("\n Cliente registrado de forma exitosa!\n Aprete enter para volver al menu.");
        Teclado.nextLine();

    }
    public void Mostrar_Todos_Clientes(Scanner Teclado){
        System.out.print("\n Clientes:");
        System.out.print("\n [---Id---]---[-----Nombre-----]---[-----Telefono-----]---[-----Direccion-----]");
        for(int i=0 ; i<getClientes().size() ; i++){
            System.out.printf("\n [%8d]---[%16s]---[%18s]---[%19s]", getClientes().get(i).getIdentificador(), getClientes().get(i).getNombre(), getClientes().get(i).getTelefono(), getClientes().get(i).getDireccion());
        }
        Teclado.nextLine();
        System.out.print("\n Aprete enter para continuar.");
        Teclado.nextLine();
    }
    public void Mostrar_Ultimas_Peliculas_Alquiladas(Scanner Teclado){
        int Cliente_Id;
        int Cliente_Index=0;
        boolean Encontrado=false;

        Teclado.nextLine();
        System.out.print("\n Ingrese el Id del Cliente.\n Id: ");
        Cliente_Id = Teclado.nextInt();

        for (int i=0 ; i<getClientes().size() && Encontrado==false ; i++){
            if (getClientes().get(i).getIdentificador() == Cliente_Id){
                Encontrado = true;
                Cliente_Index=i;
            }
        }

        if (!Encontrado) {
            Teclado.nextLine();
            System.out.print("\n El Id ingresado no existe dentro de los clientes registrados.");
            System.out.print("\n Aprete enter para volver al menu.");
            Teclado.nextLine();
            return;
        }


    }
    // METODOS -- PRESTAMOS
    public void Mostrar_Todos_Prestamos(Scanner Teclado){
        System.out.print("\n Prestamos:");
        System.out.print("\n [Cliente Id]---[Pelicula Id]---[--Activo--]---[Fecha de Retiro]---[Fecha de Devolucion]");
        for(int i=0 ; i<getPrestamos().size() ; i++){
            Mostrar_Un_Prestamo(getPrestamos().get(i));
        }
        Teclado.nextLine();
        System.out.print("\n Aprete enter para continuar.");
        Teclado.nextLine();
    }
    public void Mostrar_Un_Prestamo(Prestamo Mostrar){
        System.out.printf("\n [%10d]---", Mostrar.getCliente_Id());
        System.out.printf("[%11s]---", Mostrar.getPelicula_Id());
        if (Mostrar.isActivo()){
            System.out.printf("[ Alquilado]---");
        }
        else{
            System.out.printf("[  Devuelto]---");
        }
        System.out.printf("[%15s]---", Mostrar.getFecha_Retiro());
        System.out.printf("[%19s]", Mostrar.getFecha_Devolucion());
    }

    // METODOS -- PELICULAS
    public void Añadir_Pelicula(Scanner Teclado){
        String Titulo, Fecha_Lanzamiento, Clasificacion_Audiencia, Pais_Origen, Descripcion;
        int Duracion, StockInicial;

        Teclado.nextLine();
        System.out.print("\n Titulo: ");
        Titulo = Teclado.nextLine();

        Teclado.nextLine();
        System.out.print("\n Fecha de lanzamiento, (formato AAAA/MM/DD): ");
        Fecha_Lanzamiento = Teclado.nextLine();

        Teclado.nextLine();
        System.out.print("\n Clasificacion de Audiencia, (G, PG, PG-13, R, NC-17, UNRATED): ");
        Clasificacion_Audiencia = Teclado.nextLine();

        Teclado.nextLine();
        System.out.print("\n Pais de Origen: ");
        Pais_Origen = Teclado.nextLine();

        Teclado.nextLine();
        System.out.print("\n Descripcion: ");
        Descripcion = Teclado.nextLine();

        Teclado.nextLine();
        System.out.print("\n Duracion: ");
        Duracion = Teclado.nextInt();

        Teclado.nextLine();
        System.out.print("\n Stock Inicial: ");
        StockInicial = Teclado.nextInt();

        Pelicula Nueva = new Pelicula(Titulo,Fecha_Lanzamiento, Duracion, Clasificacion_Audiencia, Pais_Origen, Descripcion, StockInicial);
        getPeliculas().add(Nueva);

        Teclado.nextLine();
        System.out.print("\n Pelicula añadida de forma exitosa!\n Aprete enter para volver al menu.");
        Teclado.nextLine();

    }
    public void Mostrar_Todas_Peliculas(Scanner Teclado){
        System.out.print("\n Peliculas:");
        System.out.print("\n [-Id-]---[-----Titulo-----]---[Duracion]---[Fecha de Lanzamiento]---[-----Pais de Origen-----]---[Stock]---[Clasificacion de Audiciencia]");
        for(int i=0 ; i<getPeliculas().size() ; i++){
            Mostrar_Una_Pelicula(getPeliculas().get(i));
        }
        Teclado.nextLine();
        System.out.print("\n Aprete enter para continuar.");
        Teclado.nextLine();
    }
    public void Mostrar_Una_Pelicula(Pelicula Mostrar){
        System.out.printf("\n [%4d]---", Mostrar.getIdentificador());
        System.out.printf("[%16s]---", Mostrar.getTitulo());
        System.out.printf("[%8d]---", Mostrar.getDuracion());
        System.out.printf("[%20s]---", Mostrar.getFecha_Lanzamiento());
        System.out.printf("[%24s]---", Mostrar.getPais_Origen());
        System.out.printf("[%5d]---", Mostrar.getStock());
        System.out.printf("[%28s]", Mostrar.getClasificacion_Audiencia());
    }
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
