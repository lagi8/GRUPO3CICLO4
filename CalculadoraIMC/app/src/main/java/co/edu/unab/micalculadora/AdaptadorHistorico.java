package co.edu.unab.micalculadora;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import co.edu.unab.micalculadora.model.RegistroIMC;

public class AdaptadorHistorico extends BaseAdapter {

    private Context contexto;
    private int layout;
    private ArrayList<RegistroIMC> registros;
    private long altura;
    private long peso;

    //Se debe crear un constructor para que traiga los datos que va a utilizar
    public AdaptadorHistorico(Context contexto, int layout, ArrayList<RegistroIMC> registros) {
        this.contexto = contexto;
        this.layout = layout;
        this.registros = registros;
    }

    //Verifica cuantas personas hay
    @Override
    public int getCount() {
        return registros.size(); //Para que cuente el total de personas que tenga
    }

    //Cual es el item seleccionado cuando pasan una posicion
    @Override
    public Object getItem(int posicion) {
        return posicion;
    }

    //Devuelve el ID del item cuando pasan la posicion
    @Override
    public long getItemId(int posicion) {
        return posicion;
    }

    //Recibe la posicion, la vista y el viewGroup para que retornemos una vista
    @Override
    public View getView(int posicion, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(contexto);

        View vistaItem = inflater.inflate(layout, null);
        RegistroIMC registro = registros.get(posicion);

        TextView textFecha = vistaItem.findViewById(R.id.TextFecha);
        textFecha.setText(registro.getFecha());

        TextView textAltura = vistaItem.findViewById(R.id.textAltura);
        altura = registro.getAltura();
        String miAltura =Long.toString(altura);
        textAltura.setText(miAltura);

        TextView textPeso = vistaItem.findViewById(R.id.textPeso);
        peso = registro.getPeso();
        String miPeso =Long.toString(peso);
        textPeso.setText(miPeso);

        TextView textIMC = vistaItem.findViewById(R.id.TextIMC);
        textIMC.setText(registro.getImc());

        return vistaItem;
    }
}