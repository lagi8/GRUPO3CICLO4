package co.edu.unab.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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
        TextView ind_bajo = (TextView) findViewById(R.id.flecha1);
        TextView ind_normal = (TextView) findViewById(R.id.flecha2);
        TextView ind_sobre = (TextView) findViewById(R.id.flecha3);
        TextView ind_obeso = (TextView) findViewById(R.id.flecha4);
        TextView ind_bajo2 = (TextView) findViewById(R.id.flecha11);
        TextView ind_normal2 = (TextView) findViewById(R.id.flecha22);
        TextView ind_sobre2 = (TextView) findViewById(R.id.flecha33);
        TextView ind_obeso2 = (TextView) findViewById(R.id.flecha44);

        //Accion al hacer clic o tocar:
        imcBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Leer los datos escritos:
                String valorAltura = imcAltura.getText().toString();
                String valorPeso = imcPeso.getText().toString();
                //Convertir a float

                if(imcAltura.getText().toString().isEmpty()){
                    suResultado.setText("Usted aun no ha");
                    imcEstado.setText("indicado sus datos");
                }else{
                    suResultado.setText("Usted aun no ha");
                    imcEstado.setText("indicado sus datos");
                }
                float altura = Float.parseFloat(valorAltura);
                float peso = Float.parseFloat(valorPeso);
                //Hacer calculos
                float resultado = peso/(altura*altura)*10000;
                //Convertir a String
                String resultadoTexto = String.format("%,.1f", resultado );
                //Arroja resultado en pantalla
                suResultado.setText("Su IMC es:" + resultadoTexto);

                if (resultado >= 18.50 && resultado <= 24.99){
                    imcEstado.setText("Se encuentra Normal");
                    imcEstado.setTextColor(Color.argb(255,129,199,132));
                    suResultado.setTextColor(Color.argb(255,129,199,132));
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
                    imcEstado.setTextColor(Color.argb(255,255,183,77));
                    suResultado.setTextColor(Color.argb(255,255,183,77));
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
                    imcEstado.setTextColor(Color.argb(255,255,183,77));
                    suResultado.setTextColor(Color.argb(255,255,183,77));
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
                    imcEstado.setTextColor(Color.argb(255,244,67,54));
                    suResultado.setTextColor(Color.argb(255,244,67,54));
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