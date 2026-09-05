package com.example.ea2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextView tvMensaje = findViewById(R.id.tvMensaje);
        Button btnRecibido = findViewById(R.id.btnRecibido);
        Button btnCancelado = findViewById(R.id.btnCancelado);

        String textoRecibido = getIntent().getStringExtra("TEXTO");
        tvMensaje.setText(textoRecibido);

        btnRecibido.setOnClickListener(v -> {
            setResult(RESULT_OK);
            finish();
        });

        btnCancelado.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}