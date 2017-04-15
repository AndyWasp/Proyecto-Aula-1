package ipn.marsoft.a6im7.synth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Andrea on 13/04/2017.
 */
public class presetChoice extends Activity{

    private TextView nPreset;
    private Button aPreset;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preset_choice);

        //Esto es únicamente para el presetX
        nPreset = (TextView) findViewById(R.id.textView);
        aPreset = (Button)findViewById(R.id.button);
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
            case R.id.Ayuda:
                opcion=new Intent(this,Ayuda.class);
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


    //Método que abre el preset seleccionado según el botón
    public void abrirPreset(View v){
        try{
            Toast.makeText(this, "Abriendo preset...", Toast.LENGTH_LONG).show();
        }catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}

