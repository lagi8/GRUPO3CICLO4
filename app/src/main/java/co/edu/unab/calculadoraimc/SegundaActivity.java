package co.edu.unab.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        // Llamar a los elementos creados en activity_mail.xml
        TextView suResultado = (TextView) findViewById(R.id.suResultado);
        EditText imcAltura = (EditText) findViewById(R.id.editaAltura);
        EditText imcPeso = (EditText) findViewById(R.id.editaPeso);
        Button imcBoton = (Button) findViewById(R.id.btn_enviar);
        Button volverBoton = (Button) findViewById(R.id.btn_volver);
        TextView imcEstado = (TextView) findViewById(R.id.estado);
        TextView ind_bajo = (TextView) findViewById(R.id.flecha2);
        TextView ind_normal = (TextView) findViewById(R.id.flecha3);
        TextView ind_sobre = (TextView) findViewById(R.id.flecha4);
        TextView ind_obeso = (TextView) findViewById(R.id.flecha5);
        TextView ind_bajo2 = (TextView) findViewById(R.id.flecha22);
        TextView ind_normal2 = (TextView) findViewById(R.id.flecha33);
        TextView ind_sobre2 = (TextView) findViewById(R.id.flecha44);
        TextView ind_obeso2 = (TextView) findViewById(R.id.flecha55);

        //Accion al hacer clic o tocar:
        imcBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Leer los datos escritos:
                String valorAltura = imcAltura.getText().toString();
                String valorPeso = imcPeso.getText().toString();
                //Convertir a float
                float altura = Float.parseFloat(valorAltura);
                float peso = Float.parseFloat(valorPeso);
                //Hacer calculos
                float resultado = peso/(altura*altura)*10000 ;
                //Convertir a String
                String resultadoTexto = String.format("%,.1f", resultado );
                //Arroja resultado en pantalla
                suResultado.setText("Su ICM es:" + resultadoTexto);

                if (resultado >= 18.50 && resultado <= 24.99){
                    imcEstado.setText("Se encuentra Normal");
                    ind_normal.setText(">>>");
                    ind_bajo.setText("");
                    ind_sobre.setText("");
                    ind_obeso.setText("");
                    ind_normal2.setText("<<<");
                    ind_bajo2.setText("");
                    ind_sobre2.setText("");
                    ind_obeso2.setText("");
                }else if(resultado < 18.50){
                    imcEstado.setText("Se encuentra con Bajo peso");
                    ind_normal.setText("");
                    ind_bajo.setText(">>>");
                    ind_sobre.setText("");
                    ind_obeso.setText("");
                    ind_normal2.setText("");
                    ind_bajo2.setText("<<<");
                    ind_sobre2.setText("");
                    ind_obeso2.setText("");
                }else if(resultado > 24.99 && resultado <=29.99){
                    imcEstado.setText("Se encuentra con Sobrepeso");
                    ind_normal.setText("");
                    ind_bajo.setText("");
                    ind_sobre.setText(">>>");
                    ind_obeso.setText("");
                    ind_normal2.setText("");
                    ind_bajo2.setText("");
                    ind_sobre2.setText("<<<");
                    ind_obeso2.setText("");
                }else if(resultado> 29.99){
                    imcEstado.setText("Se encuentra Obeso");
                    ind_normal.setText("");
                    ind_bajo.setText("");
                    ind_sobre.setText("");
                    ind_obeso.setText(">>>");
                    ind_normal2.setText("");
                    ind_bajo2.setText("");
                    ind_sobre2.setText("");
                    ind_obeso2.setText("<<<");
                }
            }
        });

        volverBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}