package co.edu.unab.micalculadora;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import co.edu.unab.micalculadora.model.Personas;
import co.edu.unab.micalculadora.repository.PersonaRepositoryimpl;
import co.edu.unab.micalculadora.repository.UsuariosRepository;

public class AgregarPersonas extends AppCompatActivity {
    private final static String TAG = "Logs Consulta FireBase";

    UsuariosRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        // Llamar a los elementos creados en activity_crear_personas.xml

        EditText identificacion = (EditText) findViewById(R.id.editIdentificacion);
        EditText nombre = (EditText) findViewById(R.id.editNombres);
        EditText apellido = (EditText) findViewById(R.id.editApellidos);
        EditText telefono = (EditText) findViewById(R.id.editTelefono);
        Button cancelar = (Button) findViewById(R.id.bto_cancelar_agregar);
        Button guardar = (Button) findViewById(R.id.bto_agregar_persona);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = identificacion.getText().toString();
                String name = nombre.getText().toString();
                String lastname = apellido.getText().toString();
                String phone = telefono.getText().toString();

                try {
                    long phoneNumber = Long.parseLong(phone); //Como se llamó el phone como String, hay que castear a long ya q esta creado como long
                    Personas personas = new Personas(id, name, lastname, phoneNumber);

                    repository = new PersonaRepositoryimpl(); //
                    repository.create(personas, new Callback() {
                        @Override
                        public void onSuccess(Object object) {
                            Log.d("MSJ", "Persona Creada");
                            Intent intent = new Intent(AgregarPersonas.this, CalculadoraActivity.class);
                            startActivity(intent);
                        }
                        @Override
                        public void onFailure(Object object) {
                            Log.d("MSJ", "Persona no Creada");
                        }
                    });

                } catch (Exception e){
                }
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgregarPersonas.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
