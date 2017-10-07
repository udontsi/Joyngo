package cacerolos.joyngo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Intro extends AppCompatActivity {
    Configuracion conf = new Configuracion(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        if(conf.getUser()!= null){
            if(!conf.getUser().equals("")) {
                Intent i = new Intent(this, Principal.class);
                startActivity(i);
                finish();

            }
        }
    }
    public void loginClick(View l){
        Intent i = new Intent(this,Login.class);
        startActivity(i);
        finish();
    }
    public void signUpClick(View s){
        Intent i = new Intent(this,SignUp.class);
        startActivity(i);
        finish();
    }
}
