package fireui.icesi.dmi.firebaseui_listas;

public class Usuario {

    public  String uid;
    public  String nombre;
    public  String correo;
    public  String contrasena;

    public Usuario(){

    }

    //Es requisito de firebase dejar el constructor vacío
    public Usuario(String uid, String nombre, String correo, String contrasena){
        this.uid=uid;
        this.nombre=nombre;
        this.correo=correo;
        this.contrasena=contrasena;
    }

}
