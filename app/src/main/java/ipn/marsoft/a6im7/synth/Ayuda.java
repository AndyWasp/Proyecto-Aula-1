package ipn.marsoft.a6im7.synth;

// Autor Laura Elena

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Ayuda extends Activity{
    // aquji se declaran las variables a utilizar tomadas del xml
    Spinner spinner;
    TextView informa;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        // se asigna el text view a nuestra variable global
        informa = (TextView) findViewById(R.id.informacion);
        // se asigna el spinner a nuestra variable global
        spinner = (Spinner) findViewById(R.id.opcion);
        // se le asignan los valores necesarios al spinner

        initListener();

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
            case R.id.Principal:
                opcion=new Intent(this,Main.class);
                finish();
                startActivity(opcion);
                break;
            case R.id.Presets:
                opcion=new Intent(this,presetChoice.class);
                finish();
                startActivity(opcion);
                break;
            case R.id.Conectar:
                opcion=new Intent(this,Conectar.class);
                finish();
                startActivity(opcion);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    // en este metodo se despliega la infomacion de acuerdo a la opcion requerida
    private void initListener(){
        try{
            spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                    // se crea un switch para cada posicion, asignandole informacion a cada punto
                    switch (position) {
                        case 0:
                            informa.setText("<Ninguna opción seleccionada>");
                        case 1:
                            // Informacion sobre Conectar mi telefono a Synth
                            informa.setText("Informacion1");
                            break;
                        case 2:
                            // informacion sobre guardar un preset
                            informa.setText("Informacion2");
                            break;
                        case 3:
                            // informacion sobre abrir un present
                            informa.setText("Informacion3");
                            break;
                        case 4:
                            // informacion sobre como funcionana los filtros
                            informa.setText("Informacion4");
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent){
                    // vacio

                }
            });
            // se crea el catch

        }catch(Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
}




