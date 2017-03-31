package cr.ac.ucr.ecci.cql.sodauniversitaria;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Persona miPersona = new Persona();
        final Soda miSoda = new Soda();

        TextView persona = (TextView) findViewById(R.id.persona);
        Button buttonPagina = (Button) findViewById(R.id.buttonPagina);
        Button buttonLlamar = (Button) findViewById(R.id.buttonLlamar);
        Button buttonCorreo = (Button) findViewById(R.id.buttonCorreo);
        Button buttonMapa = (Button) findViewById(R.id.buttonMapa);
        Button buttonCalcularPropina = (Button) findViewById(R.id.buttonCalcularPropina);
        Button buttonListaSodas = (Button) findViewById(R.id.buttonListasSodas);

        persona.setText(miPersona.toString() + ": es un placer servirle. ");

        buttonPagina.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                irPagina(miSoda);
            }
        });

        buttonLlamar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                realizarLlamada(miSoda);
            }
        });

        buttonCorreo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enviarCorreo(miSoda);
            }
        });

        buttonMapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                irMapa(miSoda);
            }
        });

        buttonCalcularPropina.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                irCalculadoraPropina(miPersona, miSoda);
            }
        });

        buttonListaSodas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                irListaSodas(miSoda);
            }
        });
    }

    // Va a la página de la soda
    private void irPagina(Soda soda){
    // Intent para ver una página en el browser
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(soda.getWebsite()));
        startActivity(intent);
    }

    // Realiza una llamada a la soda
    private void realizarLlamada(Soda soda){
    // Intent para abrir el teclado de llamada
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + soda.getTelefono()));
        startActivity(intent);
    }

    // Envía un correo a la soda
    private void enviarCorreo(Soda soda){
    // Intent para abrir el correo
        String[] TO = {soda.getEmail()};
        Uri uri = Uri.parse("mailto:" + soda.getEmail())
                .buildUpon()
                .appendQueryParameter("subject", "Consulta Soda Universitaria")
                .appendQueryParameter("body", "Enviado desde SodaUniversitaria.")
                .build();
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        startActivity(Intent.createChooser(emailIntent, "Enviar vía correo"));
    }

    // Ir a la localización de la soda en el mapa
    private void irMapa(Soda soda) {
        // Intent para ver la localización en el mapa
        String url = "geo:" + String.valueOf(soda.getLatitud()) + "," + String.valueOf(soda.getLongitud());
        String q = "?q=" + String.valueOf(soda.getLatitud()) + "," + String.valueOf(soda.getLongitud()) + "(" + soda.getNombre() + ")";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url + q));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    // Ir a la calculadora de propinas
    private void irCalculadoraPropina(Persona persona, Soda soda){

    }
    // Ir al listado de las sodas de la universidad
    private void irListaSodas(Soda soda){

  }
}
