package com.example.ea2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tvEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etEntrada = findViewById(R.id.etEntrada);
        Button btnEnviar = findViewById(R.id.btnEnviar);
        tvEstado = findViewById(R.id.tvEstado);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        tvEstado.setText("Estado: RECIBIDO");
                    } else if (result.getResultCode() == RESULT_CANCELED) {
                        tvEstado.setText("Estado: CANCELADO");
                    }
                }
        );

        btnEnviar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            intent.putExtra("TEXTO", etEntrada.getText().toString());
            launcher.launch(intent);
        });
    }
}