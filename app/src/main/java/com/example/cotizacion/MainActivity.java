package com.example.cotizacion;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtNoCotizacion;
    private EditText txtDescripcion;
    private EditText txtPrecio;
    private EditText txtPagoInicial;
    private EditText txtPlazo;
    private TextView lblDatos;
    private Button btnRealizarCalculo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNoCotizacion = (EditText) findViewById(R.id.txtNumeroDeCotizacion);
        txtPlazo = (EditText) findViewById(R.id.txtPlazo);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        btnRealizarCalculo = (Button) findViewById(R.id.btnMostrarDatos);
        txtPrecio = (EditText) findViewById(R.id.txtPrecio);
        txtPagoInicial = (EditText) findViewById(R.id.txtPorcentajePagoInicial);
        lblDatos = (TextView) findViewById(R.id.lblDatos);

        cotizacion cotizacion = new cotizacion();

        btnRealizarCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numeroDeCotizacion = txtNoCotizacion.getText().toString();
                cotizacion.setNumeroCotizacion(Integer.parseInt(numeroDeCotizacion));

                cotizacion.setDescripcionAutomovil(txtDescripcion.getText().toString());

                String precio = txtPrecio.getText().toString();
                cotizacion.setPrecio(Double.parseDouble(precio));

                String porcentajePagoInicial = txtPagoInicial.getText().toString();
                cotizacion.setPorcentajePagoInicial(Double.parseDouble(porcentajePagoInicial));

                String plazo = txtPlazo.getText().toString();
                cotizacion.setPlazo(Integer.parseInt(plazo));

                Double pagoInicial = cotizacion.calcularPagoInicial();
                Double pagoFinal = cotizacion.calcularTotalFinal();
                Double pagoMensual = cotizacion.calcularPagoMensual();

                lblDatos.setText("\n*******COTIZACIONES*******"
                        +"\n\nNúmero de cotización: " +cotizacion.getNumeroCotizacion()
                        +"\n\nDescripción: " +cotizacion.getDescripcionAutomovil()
                        +"\n\nPrecio: " +cotizacion.getPrecio()
                        +"\n\nPorcentaje de pago inicial (%): " +cotizacion.getPorcentajePagoInicial()
                        +"\n\nPlazo (en meses): " +cotizacion.getPlazo()
                        +"\n\n*****************************************"
                        +"\n\nPago inicial: " + pagoInicial
                        +"\n\nTotal a fin: " +pagoFinal
                        +"\n\nPago mensual: " +pagoMensual);
            }
        });

    }
}