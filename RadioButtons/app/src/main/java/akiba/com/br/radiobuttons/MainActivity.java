package akiba.com.br.radiobuttons;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    private RadioButton radioButtonEscolhido;
    private Button buttonResultado;
    private TextView textViewResultado;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonResultado = (Button) findViewById(R.id.buttonId);
        textViewResultado = (TextView) findViewById(R.id.textViewResultadoId);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);

        buttonResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idRadioGroupEscolhido = radioGroup.getCheckedRadioButtonId();
                //textViewResultado.setText("id: " + R.id.radioGroupId);
                if ( idRadioGroupEscolhido > 0) {
                    radioButtonEscolhido = (RadioButton) findViewById(idRadioGroupEscolhido);
                    textViewResultado.setText(radioButtonEscolhido.getText());
                }
            }
        });
    }
}
