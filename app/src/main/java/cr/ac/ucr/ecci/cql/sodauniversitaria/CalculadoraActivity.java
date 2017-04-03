package cr.ac.ucr.ecci.cql.sodauniversitaria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle; import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity {

    private Persona miPersona;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        // recibimos el Intent y los parámetros
        /Bundle b = getIntent().getExtras();
        if (b != null)
        {
            // obtenemos el objeto persona
            miPersona = b.getParcelable(MainActivity.EXTRA_MESSAGE);
        }

        // mensaje de bienvenida para persona
        TextView persona = (TextView) findViewById(R.id.persona);
        persona.setText(miPersona.toString() + ": es un placer servirle.");
        Button buttonEnviar = (Button) findViewById(R.id.buttonEnviarPropina);
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Valor de prueba
                String montoStr = "100.00";
                editText.getText().toString();

            // Devolvemos el monto y cerramos la actividad
                Intent intent = new Intent();
                intent.putExtra("montoStr", montoStr);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
