package com.example.recuperacion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CotizacionActivity extends AppCompatActivity {
    private TextView lblNombreCliente;
    private TextView lblNumFolio;
    private EditText txtDescripcion;
    private EditText txtValorAuto;
    private EditText txtPorPagoInicial;
    private RadioButton rb12meses;
    private RadioButton rb18meses;
    private RadioButton rb24meses;
    private RadioButton rb36meses;
    private Button btnCalcular;
    private Button btnLimpiar;
    private Button btnRegresar;
    private EditText txtPagoMensual;
    private EditText txtEnganche;

    private String nombreCliente;

    // Declarar objeto
    Cotizacion cotizacion = new Cotizacion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizacion);
        iniciarComponentes();

        Bundle datos = getIntent().getExtras();
        if (datos != null) {
            nombreCliente = datos.getString("nombreCliente");
            if (nombreCliente != null) {
                lblNombreCliente.setText(nombreCliente);

            }
        }

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresar();
            }
        });
    }

    public void iniciarComponentes(){
        lblNombreCliente = findViewById(R.id.lblNombreCliente);
        lblNumFolio = findViewById(R.id.lblNumFolio);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtValorAuto = findViewById(R.id.txtValorAuto);
        txtPorPagoInicial = findViewById(R.id.txtPorPagoInicial);
        rb12meses = findViewById(R.id.rb12meses);
        rb18meses = findViewById(R.id.rb18meses);
        rb24meses = findViewById(R.id.rb24meses);
        rb36meses = findViewById(R.id.rb36meses);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);
        txtPagoMensual = findViewById(R.id.txtPagoMensual);
        txtEnganche = findViewById(R.id.txtEnganche);

        cotizacion = new Cotizacion();
        lblNumFolio.setText(""+cotizacion.generarFolio());
        rb12meses.setChecked(true);
    }

    public void calcular(){
        int porcentaje = 0;

        if(rb12meses.isChecked()){
            porcentaje = 12;
        }else if(rb18meses.isChecked()){
            porcentaje = 18;
        }else if(rb24meses.isChecked()){
            porcentaje = 24;
        }else if(rb36meses.isChecked()){
            porcentaje = 36;
        }

        if(txtDescripcion.getText().toString().isEmpty() || txtValorAuto.getText().toString().isEmpty()
                || txtPorPagoInicial.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese los datos faltantes", Toast.LENGTH_SHORT).show();
        }else{
            float valorAuto = Float.parseFloat(txtValorAuto.getText().toString());
            float porEnganche = Float.parseFloat(txtPorPagoInicial.getText().toString());
            float enganche = cotizacion.calcularEnganche(valorAuto, porEnganche);
            txtEnganche.setText("" + enganche);

            float pagoMensual = cotizacion.calcularPagoMensual(valorAuto, enganche, porcentaje);
            txtPagoMensual.setText("" + pagoMensual);
        }
    }

    public void limpiar(){

        txtDescripcion.setText("");
        txtValorAuto.setText("");
        txtPorPagoInicial.setText("");
        rb12meses.setChecked(true);
        txtPagoMensual.setText("");
        txtEnganche.setText("");
    }

    public void regresar(){
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);
        confirmar.setTitle("Cotización App");
        confirmar.setMessage("¿Desea regresar al inicio?");
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
