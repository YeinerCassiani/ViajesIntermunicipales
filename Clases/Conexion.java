package Clases;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class Conexion {
    private Connection conexion;
    
    String url = "jdbc:mysql://localhost:3306/bd_empresaViajes?zeroDateTimeBehavior=convertToNull";
    String user = "root"; //Cambiar de acuerdo al pc
    String password = "yeicas16"; //Cambiar de acuerdo al pc
    public String rol = "", nombreCompleto = "";
    private String mensajeError = "";
    boolean validacion = false;
    public int id, documento;
    
    //metodo conectar
    public Connection conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            mensajeError = ex.getMessage();
        }
        finally{
            return conexion;
        }
    }
    
    //metodo cerrar conexion
    public void cerrarConexion(){
        if (conexion != null) {
            try {
                if (!conexion.isClosed()) //Si la conexión está abierta
                    conexion.close();//Cerrar la conexión
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    //Resultado
    public String resultadoConexion(){
        String mensaje = "";
        if (conexion != null) {
            try {
                if (!conexion.isClosed())
                    mensaje = "Se ha conectado exitosamente a la base de datos \nUrl: " + conexion.nativeSQL(url); //Conectado exitosamente.
            } catch (SQLException ex) {
                return null;
            }
        }else{
            mensaje = mensajeError;
        }
        return mensaje;
    }
    /*MÉTODOS PARA USUARIOS*/
    
    //Método para validar si un usuario existe y devolver su rol.
    public int validarUSuario(String usuario, String contrasena){
        Statement s;
        ResultSet rs;
        try {
            s = conexion.createStatement();
            rs = s.executeQuery ("select * from tblusuarios");
            while (rs.next()) {            
                if (rs.getString("usuario").equals(usuario) && rs.getString("contrasena").equals(contrasena)) {
                    rol = rs.getString("rol");
                    id = rs.getInt("id_usuario");
                    documento = rs.getInt("documento");
                    nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellido");
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    //Método para validar si un usuario existe y devolver su rol.
    public ArrayList consultarUsuario(String tipoUsuario){
        Statement s;
        ResultSet rs;
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            s = conexion.createStatement();
            CallableStatement cst = conexion.prepareCall("{call consultarUsuario(?)}");
            cst.setString(1,tipoUsuario);
            cst.execute(); 
            rs = cst.getResultSet();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setDocumento(rs.getString("documento"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setEmail(rs.getString("email"));
                usuarios.add(usuario);
            }
            System.out.println("Usuarios Encontrado");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
    
    public boolean verificarUsuario(String documento){
        boolean bandera = false;
        Statement s;
        ResultSet rs;
        try {
            s = conexion.createStatement();
            CallableStatement cst = conexion.prepareCall("{call VerificarUsuario(?)}");
            cst.setString(1,documento);
            cst.execute(); 
            rs = cst.getResultSet();
            while (rs.next()) {
                bandera = true;
            }
            System.out.println("Usuarios Encontrado");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bandera;
    }
    
    public String consultarNombre(int idUsuario){
        Statement s;
        ResultSet rs;
        try {
            s = conexion.createStatement();
            rs = s.executeQuery ("select * from tblusuarios");
            while (rs.next()) {            
                if (rs.getInt("id_usuario") == idUsuario) {
                    nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellido");
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombreCompleto;
    }
    
    //Método para ingresar un usuario a la base de datos usando procedimientos almacenados.
    public boolean ingresarUSuario(String documento, String nombre, String contrasena, String telefono, String email,String usuario, String rol){
        Statement s;
        try {
            s = conexion.createStatement();
            CallableStatement cst = conexion.prepareCall("{call addCliente(?,?,?,?,?,?,?)}");  //La cantidad de ? determina la cantidad de columnas en la base de datos.
            cst.setString(1,documento.trim());  //El número es de forma ordenada cada columna de la base de datos.
            cst.setString(2,nombre.trim()); //.trim elimina los espacios que puedan existir en las cadenas de texto.
            cst.setString(3,contrasena.trim());
            cst.setString(4,telefono.trim());  
            cst.setString(5,email.trim());
            cst.setString(6,usuario.trim());
            cst.setString(7,rol.trim());
            cst.execute(); //una vez lleno ejecuta el procedimiento almacenado.
            validacion = true;
        } catch (SQLException ex) {
            validacion = false;
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return validacion;
    }
    
    public boolean editarUSuario(String documento, String nombre,String apellido, String contrasena, String telefono, String email,String usuario, String rol, int idU ){
        Statement s;
        try {
            s = conexion.createStatement();
            CallableStatement cst = conexion.prepareCall("{call editarUsuario(?,?,?,?,?,?,?,?,?)}");  //La cantidad de ? determina la cantidad de columnas en la base de datos.
            cst.setInt(1,idU);  //El número es de forma ordenada cada columna de la base de datos.
            cst.setString(2,documento.trim()); //.trim elimina los espacios que puedan existir en las cadenas de texto.
            cst.setString(3,nombre.trim());
            cst.setString(4,apellido.trim());  
            cst.setString(5,usuario.trim());
            cst.setString(6,contrasena.trim());
            cst.setString(7,telefono.trim());
            cst.setString(8,email.trim());
            cst.setString(9,rol.trim());
            cst.execute(); //una vez lleno ejecuta el procedimiento almacenado.
            validacion = true;
        } catch (SQLException ex) {
            validacion = false;
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return validacion;
    }
    
    public boolean eliminarUsuario(int idU){
        Statement s;
        try {
            s = conexion.createStatement();
            CallableStatement cst = conexion.prepareCall("{call eliminarUsuario(?)}"); 
            cst.setInt(1,idU);  
            cst.execute(); 
            validacion = true;
        } catch (SQLException ex) {
            validacion = false;
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return validacion;
    }
    
    /*MÉTODOS PARA RUTAS*/
    
    public ArrayList consultarRutas(){
        Statement s;
        ResultSet rs;
        ArrayList<Rutas> rutas = new ArrayList<>();
        rutas.clear();
        try {
            s = conexion.createStatement();
            CallableStatement cst = conexion.prepareCall("{call consultarRutas()}");
            cst.execute(); 
            rs = cst.getResultSet();
            while (rs.next()) {
                Rutas ruta = new Rutas();
                ruta.setIdRutas(rs.getInt("idRuta"));
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setTiempoAproximado(rs.getTime("tiempo_Aproximado"));
                ruta.setCosto(rs.getString("costo"));
                ruta.setFechaViaje(rs.getDate("fecha_Viaje"));
                ruta.setHoraViaje(rs.getString("hora_Viaje"));
                ruta.setIdBus(rs.getInt("IDBus"));
                rutas.add(ruta);
            }
            System.out.println("Ruta Encontrada");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rutas;
    }
    
    public boolean crearRuta(String origen, String destino, Time tiempo, String costo ,Date fechaViaje ,String horaViaje ,int IDBus){
        Statement s;
        try {
            s = conexion.createStatement();
            CallableStatement cst = conexion.prepareCall("{call crearRuta(?,?,?,?,?,?,?)}"); 
            cst.setString(1,origen.trim()); 
            cst.setString(2,destino.trim());
            cst.setTime(3,tiempo);  
            cst.setString(4,costo.trim());
            cst.setDate(5,fechaViaje);
            cst.setString(6,horaViaje);
            cst.setInt(7,IDBus);
            cst.execute(); 
            validacion = true;
        } catch (SQLException ex) {
            validacion = false;
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return validacion;
    }
    
    public boolean editarRuta(int id, String origen, String destino, Time tiempo, String costo ,Date fechaViaje ,String horaViaje ,int IDBus){
        Statement s;
        try {
            s = conexion.createStatement();
            CallableStatement cst = conexion.prepareCall("{call editarRuta(?,?,?,?,?,?,?,?)}"); 
            cst.setInt(1,id);  
            cst.setString(2,origen.trim()); 
            cst.setString(3,destino.trim());
            cst.setTime(4,tiempo);  
            cst.setString(5,costo.trim());
            cst.setDate(6,fechaViaje);
            cst.setString(7,horaViaje);
            cst.setInt(8,IDBus);
            cst.execute(); 
            validacion = true;
        } catch (SQLException ex) {
            validacion = false;
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return validacion;
    }
    
    public boolean eliminarRuta(int id){
        Statement s;
        try {
            s = conexion.createStatement();
            CallableStatement cst = conexion.prepareCall("{call eliminarRuta(?)}"); 
            cst.setInt(1,id);  
            cst.execute(); 
            validacion = true;
        } catch (SQLException ex) {
            validacion = false;
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return validacion;
    }
    
    /*MÉTODOS PARA TIQUETES*/
    
    public ArrayList consultarTiquetes(int idTiquete){
        Statement s;
        ResultSet rs;
        ArrayList<Tiquete> tiquetes = new ArrayList<>();
        try {
            s = conexion.createStatement();
            CallableStatement cst = conexion.prepareCall("{call consultarTiquetes(?)}");
            cst.setInt(1,idTiquete);
            cst.execute(); 
            rs = cst.getResultSet();
            while (rs.next()) {
                Tiquete tiquete = new Tiquete();
                tiquete.setId_tiquete(rs.getInt("idTiquete"));
                tiquete.setOrigen(rs.getString("origen"));
                tiquete.setDestino(rs.getString("destino"));
                tiquete.setTiempoAproximado(rs.getTime("tiempo_Aproximado"));
                tiquete.setCosto(rs.getString("costo"));
                tiquete.setFechaCompra(rs.getDate("fecha_Compra"));
                tiquete.setFechaViaje(rs.getDate("fecha_Viaje"));
                tiquete.setHoraViaje(rs.getString("hora_Viaje"));
                tiquete.setId_bus(rs.getInt("IDBus"));
                tiquete.setId_Cliente(rs.getInt("IDCliente"));
                tiquetes.add(tiquete);
            }
            System.out.println("Tiquete Encontrado");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tiquetes;
    }
    
    public ArrayList allTiquetes(){
        Statement s;
        ResultSet rs;
        ArrayList<Tiquete> tiquetes = new ArrayList<>();
        try {
            s = conexion.createStatement();
            CallableStatement cst = conexion.prepareCall("{call allTiquetes()}");
            cst.execute(); 
            rs = cst.getResultSet();
            while (rs.next()) {
                Tiquete tiquete = new Tiquete();
                tiquete.setId_tiquete(rs.getInt("idTiquete"));
                tiquete.setOrigen(rs.getString("origen"));
                tiquete.setDestino(rs.getString("destino"));
                tiquete.setTiempoAproximado(rs.getTime("tiempo_Aproximado"));
                tiquete.setCosto(rs.getString("costo"));
                tiquete.setFechaCompra(rs.getDate("fecha_Compra"));
                tiquete.setFechaViaje(rs.getDate("fecha_Viaje"));
                tiquete.setHoraViaje(rs.getString("hora_Viaje"));
                tiquete.setId_bus(rs.getInt("IDBus"));
                tiquete.setId_Cliente(rs.getInt("IDCliente"));
                tiquetes.add(tiquete);
            }
            System.out.println("Tiquetes Encontrados");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tiquetes;
    }
    
    public boolean crearTiquete(String origen ,String destino ,String costo ,String fechaViaje ,String horaViaje ,int IDCliente){
        Statement s;
        try {
            s = conexion.createStatement();
            CallableStatement cst = conexion.prepareCall("{call crearTiquete(?,?,?,?,?,?)}"); 
            cst.setString(1,origen.trim());  
            cst.setString(2,destino.trim()); 
            cst.setString(3,costo.trim());
            cst.setString(4,fechaViaje.trim());  
            cst.setString(5,horaViaje.trim());
            cst.setInt(6,IDCliente);
            cst.execute(); 
            validacion = true;
        } catch (SQLException ex) {
            validacion = false;
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return validacion;
    }
    
    public boolean editarTiquete(String origen ,String destino ,String costo ,String fechaViaje ,String horaViaje ,int IDCliente){
        Statement s;
        try {
            s = conexion.createStatement();
            CallableStatement cst = conexion.prepareCall("{call crearTiquete(?,?,?,?,?,?)}"); 
            cst.setString(1,origen.trim());  
            cst.setString(2,destino.trim()); 
            cst.setString(3,costo.trim());
            cst.setString(4,fechaViaje.trim());  
            cst.setString(5,horaViaje.trim());
            cst.setInt(6,IDCliente);
            cst.execute(); 
            validacion = true;
        } catch (SQLException ex) {
            validacion = false;
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return validacion;
    }
}
