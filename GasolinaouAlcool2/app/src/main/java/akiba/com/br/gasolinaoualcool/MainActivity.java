package akiba.com.br.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText campoGasolina;
    private EditText campoAlcool;
    private Button botaoCalcular;
    private TextView resultadoCalculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoGasolina = (EditText) findViewById(R.id.campoGasId);
        campoAlcool = (EditText) findViewById(R.id.campoAlcId);
        botaoCalcular = (Button) findViewById(R.id.botaoCalcId);
        resultadoCalculo = (TextView) findViewById(R.id.resultadoId);

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gasolina = campoGasolina.getText().toString();
                double gasolinaNum = Double.parseDouble(gasolina);
                String alcool = campoAlcool.getText().toString();
                double alcoolNum = Double.parseDouble(alcool);

                double divisao = alcoolNum / gasolinaNum;

                if (divisao<0.7) {
                    resultadoCalculo.setText("Abasteça com álcool");
                } else {
                    resultadoCalculo.setText("Abasteça com gasolina");
                }

                Toast.makeText(getApplicationContext(),"Finalizado", Toast.LENGTH_LONG).show();

            }
        });

    }
}
