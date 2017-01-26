package akiba.com.br.dadosactivityv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText editTextNome;
    private EditText editTextSenha;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = (EditText) findViewById(R.id.editTextNomeId);
        editTextSenha = (EditText) findViewById(R.id.editTextSenhaId);
        buttonLogin = (Button) findViewById(R.id.buttonId);

        String textNome = editTextNome.getText().toString();
        String textSenha = editTextSenha.getText().toString();

        final Intent intentNome = new Intent();
        intentNome.putExtra("nome", (Parcelable) editTextNome);

        Intent intentSenha = new Intent();
        intentSenha.putExtra("senha", (Parcelable) editTextSenha);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intentNome);

            }
        });
    }
}
