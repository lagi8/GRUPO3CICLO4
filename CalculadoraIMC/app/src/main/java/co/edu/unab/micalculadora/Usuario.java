package co.edu.unab.micalculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import co.edu.unab.micalculadora.model.RegistroIMC;

public class Usuario extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        Button calculadora = (Button) findViewById(R.id.btn_ir_calculadora);

        calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Usuario.this, CalculadoraActivity.class);
                startActivity(intent);
            }
        });

        //Se crea una lista de registro temporales para prueba
        ArrayList<RegistroIMC> registro = new ArrayList<RegistroIMC>();

        registro.add(new RegistroIMC(180, 80, "Abril 20 - 2020", "25,3"));
        registro.add(new RegistroIMC(170, 79, "Mayo 20 - 2020", "25"));
        registro.add(new RegistroIMC(160, 78, "Junio 20 - 2020", "24,5"));
        registro.add(new RegistroIMC(150, 77, "Julio 20 - 2020", "24"));
        registro.add(new RegistroIMC(140, 76, "Agosto 20 - 2020", "23,5"));
        registro.add(new RegistroIMC(130, 75, "Septiembre 20 - 2020", "23"));

        //Se crea un adaptador para la lista nombres ya que no se puede enviar directo al ListView
        AdaptadorHistorico adaptadorHistorico = new AdaptadorHistorico(this, R.layout.layout_para_item, registro);

        //Se le pasa el adaptador al ListView
        ListView historial = (ListView) findViewById(R.id.historialUsuario);
        historial.setAdapter(adaptadorHistorico);
    }
}
