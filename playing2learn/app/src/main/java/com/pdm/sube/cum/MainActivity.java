package com.pdm.sube.cum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pdm.sube.cum.seccion.MenuActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    EditText edt_usuario, edt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        this.edt_usuario = findViewById(R.id.edt_usuario);
        this.edt_password = findViewById(R.id.edt_password);

        this.btnLogin = findViewById(R.id.login_btn_login);
        this.btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn_login:
                Toast.makeText(this,"Click a login", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MenuActivity.class));
                break;
        }
    }
}
