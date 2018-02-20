
package com.empresa.exintentimplicita;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etURL;
    private Button btnNavegador;
    private EditText etNumero;
    private Button btnDiscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etURL = findViewById(R.id.ma_et_url);
        btnNavegador = findViewById(R.id.ma_btn_navegador);
        etNumero = findViewById(R.id.ma_et_numero);
        btnDiscar = findViewById(R.id.ma_btn_discar);

        btnNavegador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etURL.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(),
                            "Digite um URL",
                            Toast.LENGTH_LONG).show();
                }else{
                    String URL = etURL.getText().toString();
                    Uri uri = Uri.parse("http://"+URL);

                    Intent it = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(it);
                }
            }
        });

        btnDiscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etNumero.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(),
                            "Digite um Numero",
                            Toast.LENGTH_LONG).show();
                }else{
                    String num = etNumero.getText().toString();
                    Uri uri = Uri.parse("tel:"+num);
                    Intent it = new Intent(Intent.ACTION_DIAL,uri);
                    startActivity(it);

                }
            }
        });

    }
}
