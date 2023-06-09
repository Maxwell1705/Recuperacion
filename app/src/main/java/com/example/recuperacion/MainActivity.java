package com.example.recuperacion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombreCliente;
    private Button btnEntrar;
    private Button btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrar();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir();
            }
        });
    }

    private void iniciarComponentes(){
        txtNombreCliente = findViewById(R.id.txtNombreCliente);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnSalir = findViewById(R.id.btnSalir);
    }

    private void entrar(){
        String textoNombre =txtNombreCliente.getText().toString().trim();

        if (textoNombre.isEmpty()) {
            Toast.makeText(this, "Ingrese el nombre del cliente", Toast.LENGTH_SHORT).show();
        }else {
            Bundle bundle = new Bundle();
            bundle.putString("nombreCliente", txtNombreCliente.getText().toString());

            Intent intent = new Intent(MainActivity.this, CotizacionActivity.class);
            intent.putExtras(bundle);

            startActivity(intent);
        }
    }

    private void salir(){
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);
        confirmar.setTitle("Cotización");
        confirmar.setMessage("¿Desea Salir de la Aplicaciòn?");
        confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        confirmar.show();
    }
}
