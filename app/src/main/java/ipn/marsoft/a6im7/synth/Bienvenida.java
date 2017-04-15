package ipn.marsoft.a6im7.synth;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.IdRes;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.ImageView;

public class Bienvenida extends Activity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = (ImageView) findViewById(R.id.logo);

    }

    public void onClick(View v) {
        Animation ampliar;
        ampliar = AnimationUtils.loadAnimation(this, R.anim.ampliar);
        ampliar.reset();
        logo.startAnimation(ampliar);

        ultimo();
    }

    public void ultimo (){
        Animation trans;
        trans = AnimationUtils.loadAnimation(this, R.anim.transparentar);
        trans.reset();
        logo.startAnimation(trans);
        Handler retraso=new Handler();
        retraso.postDelayed(new Runnable() {
            @Override
            public void run() {
               iniciarApp();
            }
        },3000);

    }
    public void iniciarApp()
    {
        Intent iniciar=new Intent(this,Main.class);
        finish();
        startActivity(iniciar);
    }
}

