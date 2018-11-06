package fireui.icesi.dmi.firebaseui_listas;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencia es para leer o escribir
     db= FirebaseDatabase.getInstance();

     //Para escribir o para leer la rama de usuarios en el DataBase
//db.Get reference es el padre, o sea proyecto ecosistemas

        //Push autogenera usuarios
        //ingresar también a una rama de usuario
        DatabaseReference reference= db.getReference().child("usuarios").child("-LPm3o4l5M6bAP98-tlw");

        //Escribir en la base de datos

        //Usuario isa= new Usuario("jksdhak", "Isabella", "isabellajordanbe@gmail.com","isa123456");
        //reference.push().setValue(isa);

        //PARA LEER LA RAMA DE USUARIOS es como leer las carpetas comprimidas de usuario
        //addChildEventListener es para estar pendiente en las ramas en tiempo real

        //Para leer solo una vez
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            //Data snapshot es como una fotografía de los datos de la base de datos
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //Arreglo para leer todos los usuarios
                //for(DataSnapshot data: dataSnapshot.getChildren()){
                    //data es un usuario
                    //Hay que instanciarlo con la clase usuario que se creó
                    //Usuario s= data.getValue(Usuario.class);

                //PARA LEER SÓLO UN USUARIO DENTRO DE LA RAMA DEL USUARIO

                //dataSnapshot se convierte en lo que tiene Usuario.class
Usuario s= dataSnapshot.getValue(Usuario.class);

                //Con esto voy a ver la lista de usuarios
                    Log.e("NOMBRE", "Nombre: "+s.nombre);

                //}
            }

            //LEER UN USUARIO ES ESPECÍFICO

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
