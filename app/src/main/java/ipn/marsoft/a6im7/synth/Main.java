package ipn.marsoft.a6im7.synth;


/*
AUTOR: Fernando Daniel Castillo Barrón (C) Abril 2017
VERSIÓN: 1.0

DESCRIPCIÓN: Actividad que maneja dos SeekBar para modificar los valores del Filtro y el Volumen
             de Synth mediante el uso de Web Services


COMPILACIÓN: se compila en tiempo de ejecucion.
EJECUCIÓN: se ejecuta desde el IDE de Android Studio con las teclas shift + F10.  (En Windows) - ./programa (En Linux)
*/

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpRequest;

public class Main extends Activity {

    private SeekBar skFiltro;
    private SeekBar skVolumen;
    private TextView filtroValor;
    private TextView volumenValor;

    //Url del web service REST
    //Para que funcione : cambiar HOST por direccion ipv4 del residente del web service
    private final String HOST = "0.0.0.1";
    private final String URL = "http://" + HOST + ":8080/Synth BLOG/webresources/RESTWebService/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skFiltro = (SeekBar)findViewById(R.id.skFiltro);
        skFiltro.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String nuevoValor = new Double(progress + 100).toString();
                filtroValor.setText(nuevoValor);
                //Aqui va el codigo para pasar el nuevo valor
                //a Synth a travez del web service
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        skVolumen = (SeekBar)findViewById(R.id.skVolumen);
        skVolumen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String nuevoValor = new Double(progress).toString();
                volumenValor.setText(nuevoValor);
                String valorAmandar = new Double(new Double(nuevoValor) / 100).toString();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        filtroValor = (TextView)findViewById(R.id.filtroValor);
        volumenValor = (TextView)findViewById(R.id.volumenValor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent opcion;
        int action=item.getItemId();
        switch(action)
        {
            case R.id.Conectar:
                opcion=new Intent(this,Conectar.class);
                finish();
                startActivity(opcion);
                break;
            case R.id.Presets:
                opcion=new Intent(this,presetChoice.class);
                finish();
                startActivity(opcion);
                break;
            case R.id.Ayuda:
                opcion=new Intent(this,Ayuda.class);
                finish();
                startActivity(opcion);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void guardarPreset(View o){
        Toast.makeText(this, "Guardando...",Toast.LENGTH_LONG).show();
        //Aqui va el codigo para guardar el preset
    }

    // Clase que consume un web service REST
    // Y mete el resultado en un TextView
    // previamente asignado en el constructor
    public class ConsumirREST extends AsyncTask<String,Void,String> {

        //metodo sobreescrito que consume el web service
        //para ello se usa la librería legacy de apache
        //ver dependencia en build.gradle
        @Override
        protected String doInBackground(String... params) {
            return null;
        }
        @Override
        protected void onPostExecute(String resultado){
            //Este web service no recibe respuesta alguna
        }
    }
}