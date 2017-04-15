package ipn.marsoft.a6im7.synth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/* Autor: Saúl Castillo
    En esta actividad capturamos la dirección IP que aparece en la aplicación
    local para poder hacer la conexión entre el app y el ordenador
    para de ese modo poder utilizar el celular como un control de filtros de sonido
 */
public class Conectar extends Activity {

    EditText bloqueIpUno;
    EditText bloqueIpDos;
    EditText bloqueIpTres;
    EditText bloqueIpCuatro;
    private String IP="";
    private String [] bloquesIP = new String[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conectar);

        bloqueIpUno=(EditText)findViewById(R.id.primerBloque);
        bloqueIpDos=(EditText)findViewById(R.id.segundoBloque);
        bloqueIpTres=(EditText)findViewById(R.id.tercerBloque);
        bloqueIpCuatro=(EditText)findViewById(R.id.cuartoBloque);

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
            case R.id.Presets:
                opcion=new Intent(this,presetChoice.class);
                finish();
                startActivity(opcion);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setIP(String IP)
    {
        this.IP=IP;
    }

    public String getIP()
    {
        return this.IP;
    }

    //Valida la IP para iniciar la conexión con la aplicación de escritorio
    public void onClickConectar(View vw)
    {
        capturarIp();
        try{
            if(validarIP())
                iniciarConexion();
        }catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    //En este método se crea el socket y se inicia la conexión con la aplicación local
    // en la computadora con la dirección IP proporcionada
    public void iniciarConexion()throws Exception
    {
        Toast.makeText(getApplicationContext(),"Conectando a: "+getIP(),Toast.LENGTH_LONG).show();
    }

    //Se hace la captura de todos los campos numéricos y se pasan a un array String para
    // posteriormente validarlos de manera más sencilla
    public void capturarIp(){

            bloquesIP[0]=bloqueIpUno.getText().toString();
            bloquesIP[1]=bloqueIpDos.getText().toString();
            bloquesIP[2]=bloqueIpTres.getText().toString();
            bloquesIP[3]=bloqueIpCuatro.getText().toString();
    }

    //Método que hace distintas validaciones y manda una excepción
    //indicando el campo de la IP donde se encontró el error
    //si el bloque pasa la validación se concatena en una String temporal
    //para posteriormente formar la dirección IP completa
    public boolean validarIP() throws Exception
    {
        String xIP="";
        for(int i=0;i<bloquesIP.length;i++){
            if(bloquesIP[i].matches("[D]"))
                throw new Exception("Error:Sólo debe haber números en el campo: "+(i+1));
            if (! (bloquesIP[i].length()>=1 && bloquesIP[i].length()<=3) )
                throw new Exception("Debe haber entre 1 y 3 números en el campo: "+(i+1));
            xIP+=bloquesIP[i];
            if(i != bloquesIP.length-1)
                xIP+=".";
        }
        setIP(xIP);
        return true;
    }
}
