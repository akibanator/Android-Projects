package akiba.com.br.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText editText;
    private Button button;
    private TextView textView;

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editTextCampId);
        button = (Button) findViewById(R.id.buttonId);
        textView = (TextView) findViewById(R.id.textViewRespostaId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if (editText.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Por favor, preencher o nome", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("nome", editText.getText().toString());
                    editor.commit();
                    textView.setText("Olá, " + textView.getText().toString());
                }

            }
        });

        //Recuperar os dados salvos

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if (sharedPreferences.contains("nome")){
            String nomeUsuario = sharedPreferences.getString("nome","Usuário não definido");
            textView.setText("Olá, " + nomeUsuario);
        } else {
            textView.setText("Olá, usuário não definido");
        }
    }

}
