package cacerolos.joyngo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private EditText inputEmail;
    private EditText inputPassword;
    private TextView loginErrorMsg;
    Configuracion conf = new Configuracion(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (conf.getUser()==null){conf.setUser("");}

        inputEmail = (EditText) findViewById(R.id.editText);
        inputPassword = (EditText) findViewById(R.id.editText2);
        loginErrorMsg = (TextView) findViewById(R.id.textView2);
    }
    public void onClickLoging(View v) {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(inputEmail.getWindowToken(), 0);
        if (TextUtils.isEmpty(email)) {
            inputEmail.setError(getApplicationContext().getResources().getString(R.string.errorUser));
        }else{
            if (TextUtils.isEmpty(password)) {
                inputPassword.setError(getApplicationContext().getResources().getString(R.string.errorPass));
            }else{
                loginErrorMsg.setText(getApplicationContext().getResources().getString(R.string.loging));
                UsuarioValido(email, password);
                if (conf.getUser() != null) {
                    if (conf.getUser().equals("")) {
                        loginErrorMsg.setText(R.string.errorLogin);
                    }
                    if (!conf.getUser().equals("")) {
                        Intent l = new Intent(this, Principal.class);
                        startActivity(l);
                        finish();
                    }

                }

            }
        }
    }
    private void UsuarioValido(String email,String password){
        String usuariovalido;
        //CAMBIAR CODIGO POR COMPROBACION SQL
        if (email.equalsIgnoreCase("udontsi")){
            if (password.equals("2106")) {
                usuariovalido="Udontsi";
                if(conf.getUser() != null){
                    conf.setUser(usuariovalido);
                }
            }
        }
    }
    @Override
    public void onBackPressed(){
        Intent l = new Intent(this, Intro.class);
        startActivity(l);
        finish();
    }
}
