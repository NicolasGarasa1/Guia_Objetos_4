package MovieStore;
import MovieStore.Cliente.Cliente;
import MovieStore.Pelicula.Pelicula;
import MovieStore.Prestamo.Prestamo;
import java.io.*;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Local {
    // ATRIBUTO
    private ArrayList<Pelicula> Peliculas;
    private ArrayList<Cliente> Clientes;
    private int Saldo;
    // METODOS -- PRINCIPALES
    public void MenuPrincipal(){
        System.out.print("\n Bienvenido.");
        System.out.print("\n Su saldo es de: "+getSaldo()+".");
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
        int Swtch;
        int Continuar=1;
        do {
            System.out.print("\n Bienvenido.");
            System.out.print("\n Elija una de las siguientes opciones.");
            System.out.print("\n");
            System.out.print("\n 01 - Ver todos los clientes.");
            System.out.print("\n 02 - Aniadir un nuevo cliente.");
            System.out.print("\n 03 - Exportar todos los clientes.");
            System.out.print("\n 04 - Ver ultimas 5 peliculas alquiladas de un cliente.");
            System.out.print("\n");
            System.out.print("\n 00 - Volver.");
            System.out.print("\n");
            System.out.print("\n Opcion elegida: ");
            Swtch = Teclado.nextInt();
            switch (Swtch) {
                case 1 -> // VER TODOS LOS CLIENTES
                        Mostrar_Todos_Clientes(Teclado);
                case 2 -> // AniADIR UN NUEVO CLIENTE
                        Aniadir_Cliente(Teclado);
                case 3 -> // EXPORTAR TODOS LOS CLIENTES
                        Exportar_Clientes();
                case 4 -> // VER ULTIMAS 5 PELICULAS DE UN CLIENTE
                        Mostrar_Ultimas_Peliculas_Alquiladas(Teclado);
                case 0 -> Continuar = 0;
                default -> {
                }
            }
        }while(Continuar==1);
    }
    public void MenuPeliculas(Scanner Teclado){
        int Swtch;
        int Continuar=1;
        do {
            System.out.print("\n Bienvenido.");
            System.out.print("\n Elija una de las siguientes opciones.");
            System.out.print("\n 01 - Ver todas las peliculas.");
            System.out.print("\n 02 - Buscar una pelicula por titulo.");
            System.out.print("\n 03 - Aniadir una nueva pelicula.");
            System.out.print("\n 04 - Exportar todas las peliculas.");
            System.out.print("\n");
            System.out.print("\n 00 - Volver.");
            System.out.print("\n");
            System.out.print("\n Opcion elegida: ");
            Swtch = Teclado.nextInt();
            switch (Swtch) {
                case 1 -> // VER TODAS LAS PELICULAS
                        Mostrar_Todas_Peliculas(Teclado);
                case 2 -> // BUSCAR PELICULA POR ID
                        Buscar_Nombre(Teclado);
                case 3 -> // AniADIR UNA NUEVA PELICULA
                        Aniadir_Pelicula(Teclado);
                case 4 -> // EXPORTAR TODAS LAS PELICULAS
                        Exportar_Peliculas();
                case 0 -> Continuar = 0;
                default -> {
                }
            }
        }while(Continuar==1);
    }
    public void MenuAlquieleres(Scanner Teclado){
        int Swtch;
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
            System.out.print("\n 07 - Devolucion de una pelicula.");
            System.out.print("\n");
            System.out.print("\n 00 - Volver.");
            System.out.print("\n");
            System.out.print("\n Opcion elegida: ");
            Swtch = Teclado.nextInt();
            switch (Swtch){
                case 1: // VER TODOS LOS ALQUILERES
                    Mostrar_Todos_Prestamos(Teclado);
                    break;
                case 2: // VER ALQUILERES VIGENTES
                    Ver_AlquilesVigentes(Teclado);
                    break;
                case 3: // VER ALQUILERES QUE TERMINAN HOY
                    Ver_Alquiles_Hoy(Teclado);
                    break;
                case 4: // VER ALQUILERES DE UN CLIENTE
                    Mostrar_Ultimas_Peliculas_Alquiladas(Teclado);
                    break;
                case 5: // GENERAR UN NUEVO ALQUILER
                    Generar_Prestamo(Teclado);
                    break;
                case 6: // EXPORTAR TODOS LOS ALQUILERES
                    Exportar_Alquileres();
                    break;
                case 7: // DEVOLVER UN ALQUILER
                    Devolucion_Pelicula(Teclado);
                case 0:
                    Continuar=0;
                    break;
                default:
                    break;
            }
        }while(Continuar==1);
    }

    // METODOS -- PRESTAMOS
    private void Ver_Alquiles_Hoy(Scanner Teclado){
        Cliente Aux;
        Prestamo Aux_2;
        System.out.print("\n [Cliente Id]---[Pelicula Id]---[-----Titulo-----]---[--Activo--]---[Fecha de Retiro]---[Fecha de Devolucion]");
        for(int i=0 ; i<getClientes().size() ; i++){
            Aux = getClientes().get(i);
            for(int j=0 ; j<Aux.getUltimas_Peliculas_Alquiladas().size() ; j++){
                Aux_2 = Aux.getUltimas_Peliculas_Alquiladas().get(j);
                if(Aux_2.isActivo()){
                    if (LocalDate.now().isEqual(Aux_2.getFecha_Devolucion())){
                        Mostrar_Un_Prestamo(Aux_2);
                    }
                }
            }
        }
        Teclado.nextLine();
        System.out.print("\n\n Aprete enter para continuar.");
        Teclado.nextLine();
    }
    private void Devolucion_Pelicula(Scanner Teclado){
        int Cliente_Id;
        int Pelicula_Id;

        System.out.print("\n Ingrese el Id del cliente.");
        System.out.print("\n Id: ");
        Cliente_Id = Teclado.nextInt();

        Cliente_Id = Existe_Cliente(Cliente_Id);
        if (Cliente_Id==-1){
            Teclado.nextLine();
            System.out.print("\n No se ha encontrado el cliente con el Id ingresado.");
        }
        else{
            System.out.print("\n Ingrese el Id de las siguientes peliculas que fueron prestadas al Cliente.");
            for(int i=0 ; i<getClientes().get(Cliente_Id).getUltimas_Peliculas_Alquiladas().size() ; i++){
                if(getClientes().get(Cliente_Id).getUltimas_Peliculas_Alquiladas().get(i).isActivo()){
                    Mostrar_Una_Pelicula(Peliculas.get(getClientes().get(Cliente_Id).getUltimas_Peliculas_Alquiladas().get(i).getPelicula_Id()));
                }
            }
            System.out.print("\n Pelicula Id: ");
            Pelicula_Id = Teclado.nextInt();

            Pelicula_Id = Existe_Prestamo(Pelicula_Id, Cliente_Id);
            if(Pelicula_Id==-1){
                Teclado.nextLine();
                System.out.print("\n No se ha encontrado la pelicula con el Id ingresado.");
            }
            else{
                getClientes().get(Cliente_Id).getUltimas_Peliculas_Alquiladas().get(Pelicula_Id).Finalizar_Devolucion();
                getPeliculas().get(Existe_Pelicula(getClientes().get(Cliente_Id).getUltimas_Peliculas_Alquiladas().get(Pelicula_Id).getPelicula_Id())).Aumentar_Stock();
                System.out.print("\n La pelicula ha sido devuelta de forma exitosa!");
            }
        }
        System.out.print("\n Aprete enter para volver al menu.");
        Teclado.nextLine();

    }
    private void Exportar_Alquileres(){
        String Ruta = "C:\\Users\\Nicolas\\IdeaProjects\\Guia_Objetos_4\\src\\Archivos\\Alquileres.txt";
        Prestamo Prestamo_Aux;
        Cliente Cliente_Aux;
        for(int i=0 ; i<getClientes().size() ; i++){
            Cliente_Aux = getClientes().get(i);
            for (int j=0 ; j<Cliente_Aux.getUltimas_Peliculas_Alquiladas().size() ; j++){
                Prestamo_Aux = Cliente_Aux.getUltimas_Peliculas_Alquiladas().get(j);
                Escribir_Archivo(Ruta, "" +
                        "Alquiler[" +
                        "Cliente Id:"+Prestamo_Aux.getCliente_Id()+". " +
                        "Pelicula Id:"+Prestamo_Aux.getPelicula_Id()+". " +
                        "Titulo:\""+getPeliculas().get(Existe_Pelicula(Prestamo_Aux.getPelicula_Id())).getTitulo()+"\". " +
                        "Fecha retiro:"+Prestamo_Aux.getFecha_Retiro().toString()+". " +
                        "Fecha devolucion:"+Prestamo_Aux.getFecha_Devolucion().toString()+"" +
                        "]");
            }
        }
    }
    private void Mostrar_Todos_Prestamos(Scanner Teclado){
        Cliente Aux;
        System.out.print("\n Prestamos:");
        System.out.print("\n [Cliente Id]---[Pelicula Id]---[-----Titulo-----]---[--Activo--]---[Fecha de Retiro]---[Fecha de Devolucion]");
        for(int i=0 ; i<getClientes().size() ; i++){
            Aux = getClientes().get(i);
            for(int j=0 ; j<Aux.getUltimas_Peliculas_Alquiladas().size() ; j++){
                Mostrar_Un_Prestamo(Aux.getUltimas_Peliculas_Alquiladas().get(j));
            }
        }
        Teclado.nextLine();
        System.out.print("\n Aprete enter para continuar.");
        Teclado.nextLine();
    }
    private void Mostrar_Un_Prestamo(Prestamo Mostrar){
        System.out.printf("\n [%10d]---", Mostrar.getCliente_Id());
        System.out.printf("[%11s]---", Mostrar.getPelicula_Id());
        //System.out.printf("[%16s]---", Retornar_Titulo(Mostrar.getPelicula_Id()));
        System.out.printf("[%16s]---", getPeliculas().get(Existe_Pelicula(Mostrar.getPelicula_Id())).getTitulo());
        if (Mostrar.isActivo()){
            System.out.print("[ Alquilado]---");
        }
        else{
            System.out.print("[  Devuelto]---");
        }
        System.out.printf("[%15s]---", Mostrar.getFecha_Retiro().toString());
        System.out.printf("[%19s]", Mostrar.getFecha_Devolucion().toString());
    }
    private void Generar_Prestamo(Scanner Teclado){
        int Cliente_Id;
        int Pelicula_Id;
        
        System.out.print("\n Ingrese el Id del cliente buscado.");
        System.out.print("\n Id: ");
        Cliente_Id = Teclado.nextInt();
        
        Cliente_Id = Existe_Cliente(Cliente_Id);
        if (Cliente_Id == -1){ // IF NO EXISTE RETURN
            Teclado.nextLine();
            System.out.print("\n No se ha encontrado ningun cliente con el Id ingresado.");
            System.out.print("\n Aprete enter para volver al menu.");
            Teclado.nextLine();
            return;
        }
        else{ // ELSE MOSTRAR INFORMACION
            System.out.print("\n Cliente encontrado! La informacion del cliente es la siguiente:");
            System.out.print("\n [---Id---]---[-----Nombre-----]---[-----Telefono-----]---[-----Direccion-----]");
            Mostrar_Un_Cliente(getClientes().get(Cliente_Id));
        }
        
        System.out.print("\n Ingrese el Id de la pelicula a alquilar.");
        System.out.print("\n Id: ");
        Pelicula_Id = Teclado.nextInt();

        Pelicula_Id = Existe_Pelicula(Pelicula_Id);
        if (Pelicula_Id==-1) {// IF NO EXISTE RETURN
            Teclado.nextLine();
            System.out.print("\n No se ha encontrado la pelicula con el Id ingresado.");
            System.out.print("\n Aprete enter para volver al menu.");
            Teclado.nextLine();
            return;
        }
        else {// ELSE MOSTRAR INFORMACION
            System.out.print("\n Pelicula encontrado! La informacion de la pelicula es la siguiente:");
            System.out.print("\n [-Id-]---[-----Titulo-----]---[Duracion]---[Fecha de Lanzamiento]---[-----Pais de Origen-----]---[Stock]---[Clasificacion de Audiciencia]");
            Mostrar_Una_Pelicula(getPeliculas().get(Pelicula_Id));
        }
        if (getPeliculas().get(Pelicula_Id).getStock()==0){
            Teclado.nextLine();
            System.out.print("\n Lamentablemente no nos queda stock de la pelicula buscada.");
            System.out.print("\n Aprete enter para volver al menu.");
            Teclado.nextLine();
        }
        else{
            Prestamo NuevoPrestamo = new Prestamo(LocalDate.now(), LocalDate.now().plusWeeks(1), Pelicula_Id, Cliente_Id);

            System.out.print("\n La informacion del nuevo prestamo es la siguiente:");
            System.out.print("\n [Cliente Id]---[Pelicula Id]---[-----Titulo-----]---[--Activo--]---[Fecha de Retiro]---[Fecha de Devolucion]");
            Mostrar_Un_Prestamo(NuevoPrestamo);

            Pelicula_Id=1;
            int Swtch;
            do {
                System.out.print("\n Elija una de las siguientes opciones.");
                System.out.print("\n");
                System.out.print("\n 01 - Guardar prestamo.");
                System.out.print("\n 02 - Cancelar prestamo.");
                System.out.print("\n");
                System.out.print("\n Opcion elegida: ");
                Swtch = Teclado.nextInt();
                switch (Swtch) {
                    case 1 -> { // GUARDAR
                        Pelicula_Id = 0;
                        getClientes().get(Cliente_Id).getUltimas_Peliculas_Alquiladas().add(NuevoPrestamo);
                        getPeliculas().get(Existe_Pelicula(NuevoPrestamo.getPelicula_Id())).Descontar_Stock();
                        setSaldo(getSaldo()+150);
                        Teclado.nextLine();
                        System.out.print("\n Prestamo generado de forma exitosa!\n Aprete enter para volver al menu.");
                        Teclado.nextLine();
                    }
                    case 2 -> // CANCELAR
                            Pelicula_Id = 0;
                    default -> {
                    }
                }
            }while(Pelicula_Id==1);
        }
    }
    private int Existe_Prestamo(int Pelicula_Id, int Cliente_Id){
        for(int i=0 ; i<getClientes().get(Cliente_Id).getUltimas_Peliculas_Alquiladas().size() ; i++){
            if(getClientes().get(Cliente_Id).getUltimas_Peliculas_Alquiladas().get(i).isActivo() && getClientes().get(Cliente_Id).getUltimas_Peliculas_Alquiladas().get(i).getPelicula_Id()==Pelicula_Id){
                return i;
            }
        }
        return -1;
    }
    private void Ver_AlquilesVigentes(Scanner Teclado){
        Cliente Aux;
        Prestamo Aux_2;
        System.out.print("\n [Cliente Id]---[Pelicula Id]---[-----Titulo-----]---[--Activo--]---[Fecha de Retiro]---[Fecha de Devolucion]");
        for(int i=0 ; i<getClientes().size() ; i++){
            Aux = getClientes().get(i);
            for(int j=0 ; j<Aux.getUltimas_Peliculas_Alquiladas().size() ; j++){
                Aux_2 = Aux.getUltimas_Peliculas_Alquiladas().get(j);
                if(Aux_2.isActivo()){
                    Mostrar_Un_Prestamo(Aux_2);
                }
            }
        }
        Teclado.nextLine();
        System.out.print("\n\n Aprete enter para continuar.");
        Teclado.nextLine();
    }
    
    // METODOS -- CLIENTES
    private void Aniadir_Cliente(Scanner Teclado){
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
    private void Mostrar_Todos_Clientes(Scanner Teclado){
        System.out.print("\n Clientes:");
        System.out.print("\n [---Id---]---[-----Nombre-----]---[-----Telefono-----]---[-----Direccion-----]");
        for(int i=0 ; i<getClientes().size() ; i++){
            Mostrar_Un_Cliente(getClientes().get(i));
        }
        Teclado.nextLine();
        System.out.print("\n\n Aprete enter para continuar.");
        Teclado.nextLine();
    }
    private void Mostrar_Un_Cliente(Cliente Mostrar){
        System.out.printf("\n [%8d]---[%16s]---[%18s]---[%19s]", Mostrar.getIdentificador(), Mostrar.getNombre(), Mostrar.getTelefono(), Mostrar.getDireccion());
    }
    private void Mostrar_Ultimas_Peliculas_Alquiladas(Scanner Teclado){
        int Cliente_Id;

        Teclado.nextLine();
        System.out.print("\n Ingrese el Id del Cliente.\n Id: ");
        Cliente_Id = Teclado.nextInt();

        Cliente_Id = Existe_Cliente(Cliente_Id);
        if (Cliente_Id==-1) {
            Teclado.nextLine();
            System.out.print("\n El Id ingresado no existe dentro de los clientes registrados.");
        }
        else{
            System.out.print("\n [Cliente Id]---[Pelicula Id]---[--Activo--]---[Fecha de Retiro]---[Fecha de Devolucion]");
            for(int i=0 ; i<getClientes().get(Cliente_Id).getUltimas_Peliculas_Alquiladas().size() ; i++){
                Mostrar_Un_Prestamo(getClientes().get(Cliente_Id).getUltimas_Peliculas_Alquiladas().get(i));
            }
            Teclado.nextLine();
        }
        System.out.print("\n Aprete enter para volver al menu.");
        Teclado.nextLine();


    }
    private void Exportar_Clientes(){
        String Ruta = "C:\\Users\\Nicolas\\IdeaProjects\\Guia_Objetos_4\\src\\Archivos\\Clientes.txt";
        Cliente Aux;
        for(int i=0 ; i<getClientes().size() ; i++){
            Aux = getClientes().get(i);
            Escribir_Archivo(Ruta, "" +
                    "Cliente[" +
                    "Id:"+Aux.getIdentificador()+". " +
                    "Nombre:\""+Aux.getNombre()+"\". " +
                    "Telefono:\""+Aux.getTelefono()+"\". " +
                    "Direccion:\""+Aux.getNombre()+"\"" +
                    "]");
        }
    }
    private int Existe_Cliente(int Id_Buscado){
        for (int i=0 ; i<getClientes().size() ; i++){
            if (getClientes().get(i).getIdentificador() == Id_Buscado){
                return i;
            }
        }
        return -1;
    }

    // METODOS -- PELICULAS
    private void Aniadir_Pelicula(Scanner Teclado){
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
        System.out.print("\n Pelicula aniadida de forma exitosa!\n Aprete enter para volver al menu.");
        Teclado.nextLine();

    }
    private void Mostrar_Todas_Peliculas(Scanner Teclado){
        System.out.print("\n Peliculas:");
        System.out.print("\n [-Id-]---[-----Titulo-----]---[Duracion]---[Fecha de Lanzamiento]---[-----Pais de Origen-----]---[Stock]---[Clasificacion de Audiciencia]");
        for(int i=0 ; i<getPeliculas().size() ; i++){
            Mostrar_Una_Pelicula(getPeliculas().get(i));
        }
        Teclado.nextLine();
        System.out.print("\n Aprete enter para continuar.");
        Teclado.nextLine();
    }
    private void Mostrar_Una_Pelicula(Pelicula Mostrar){
        System.out.printf("\n [%4d]---", Mostrar.getIdentificador());
        System.out.printf("[%16s]---", Mostrar.getTitulo());
        System.out.printf("[%8d]---", Mostrar.getDuracion());
        System.out.printf("[%20s]---", Mostrar.getFecha_Lanzamiento());
        System.out.printf("[%24s]---", Mostrar.getPais_Origen());
        System.out.printf("[%5d]---", Mostrar.getStock());
        System.out.printf("[%28s]", Mostrar.getClasificacion_Audiencia());
    }
    private void Buscar_Nombre(Scanner Teclado){
        String Nombre;
        Teclado.nextLine();
        System.out.print("\n Ingrese el nombre de la pelicula buscada.");
        System.out.print("\n Nombre: ");
        Nombre = Teclado.nextLine();

        boolean Encontrada = false;
        int Pelicula_Index=0;

        for(int i=0 ; i<getPeliculas().size() && !Encontrada ; i++){
            if (getPeliculas().get(i).getTitulo().equals(Nombre)){
                Encontrada = true;
                Pelicula_Index=i;
            }
        }

        if (!Encontrada) {
            System.out.print("\n No se han encontrado peliculas con el nombre exactamente igual al buscado.");
            System.out.print("\n A continuacion se mostraran, si existen, titulos cuyo substring sea el titulo ingresado.");
            System.out.print("\n [-Id-]---[-----Titulo-----]---[Duracion]---[Fecha de Lanzamiento]---[-----Pais de Origen-----]---[Stock]---[Clasificacion de Audiciencia]");
            for (int i = 0; i < getPeliculas().size() ; i++) {
                if (getPeliculas().get(i).getTitulo().contains(Nombre)) {
                    Mostrar_Una_Pelicula(getPeliculas().get(i));
                }
            }
        }
        else{
            System.out.print("\n Informacion de la pelicula:");
            System.out.print("\n [-Id-]---[-----Titulo-----]---[Duracion]---[Fecha de Lanzamiento]---[-----Pais de Origen-----]---[Stock]---[Clasificacion de Audiciencia]");
            Mostrar_Una_Pelicula(getPeliculas().get(Pelicula_Index));
        }
        Teclado.nextLine();
        System.out.print("\n Aprete enter para volver al menu.");
        Teclado.nextLine();

    }
    private void Exportar_Peliculas(){
        String Ruta = "C:\\Users\\Nicolas\\IdeaProjects\\Guia_Objetos_4\\src\\Archivos\\Peliculas.txt";
        Pelicula Aux;
        for(int i=0 ; i<getClientes().size() ; i++){
            Aux = getPeliculas().get(i);
            Escribir_Archivo(Ruta, "" +
                    "Pelicula[" +
                    "Id:"+Aux.getIdentificador()+". " +
                    "Titulo:\""+Aux.getTitulo()+"\". " +
                    "Fecha de lanzamiento:\""+Aux.getFecha_Lanzamiento()+"\". " +
                    "Duracion:\""+Aux.getDuracion()+"\". " +
                    "Clasificacion Audiencia:\""+Aux.getClasificacion_Audiencia()+"\". " +
                    "Pais de origen:\""+Aux.getPais_Origen()+"\". " +
                    "Descripcion:\""+Aux.getDescripcion()+"\". " +
                    "Stock hasta la fecha:\""+Aux.getStock()+"\"" +
                    "]");
        }
    }
    private int Existe_Pelicula(int Id_Buscado){
        for (int i=0 ; i<getClientes().size() ; i++){
            if (getPeliculas().get(i).getIdentificador() == Id_Buscado){
                return i;
            }
        }
        return -1;
    }

    // EXPORTAR
    private void Escribir_Archivo(String Ruta, String Mensaje){
        FileWriter Archivo;
        PrintWriter Escritor;
        try {
            Archivo = new FileWriter(Ruta, true);
            Escritor = new PrintWriter(Archivo);
            Escritor.print(Mensaje);
            for (int i=Mensaje.length() ; i<200 ; i++){
                Escritor.print(" ");
            }
            Escritor.print("\r\n");
            Archivo.close();
        }
        catch (Exception _Exception){
            System.out.println(_Exception.getMessage());
        }
    }

    // CONSTRUCTOR
    public Local(){
        setClientes(new ArrayList<>());
        setPeliculas(new ArrayList<>());
        setSaldo(0);
    }

    // GETTERS
    private ArrayList<Pelicula> getPeliculas() {
        return Peliculas;
    }
    private ArrayList<Cliente> getClientes() {
        return Clientes;
    }
    private int getSaldo() {
        return Saldo;
    }

    // SETTERS
    private void setPeliculas(ArrayList<Pelicula> peliculas) {
        Peliculas = peliculas;
    }
    private void setClientes(ArrayList<Cliente> clientes) {
        Clientes = clientes;
    }
    private void setSaldo(int saldo) {
        Saldo = saldo;
    }
}
