package akiba.com.br.checkbox;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {

    private CheckBox cachorro;
    private CheckBox gato;
    private CheckBox papagaio;
    private Button resultado;
    private TextView exibicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cachorro = (CheckBox) findViewById(R.id.checkBoxCachorroId);
        gato = (CheckBox) findViewById(R.id.checkBoxGatoId);
        papagaio = (CheckBox) findViewById(R.id.checkBoxPapagaioId);
        resultado = (Button) findViewById(R.id.buttonId);
        exibicao = (TextView) findViewById(R.id.textoExibicaoId);

        resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String itensSelecionados = "";

                itensSelecionados += ""+cachorro.getText() +" "+ cachorro.isChecked() + "\n";
                itensSelecionados += ""+gato.getText() +" "+ gato.isChecked() + "\n";
                itensSelecionados += ""+papagaio.getText() +" "+ papagaio.isChecked() + "\n";

                exibicao.setText(itensSelecionados);

            }
        });

    }
}
