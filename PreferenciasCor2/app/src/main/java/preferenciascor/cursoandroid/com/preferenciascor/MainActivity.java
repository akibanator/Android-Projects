package preferenciascor.cursoandroid.com.preferenciascor;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    private RelativeLayout layout;
    private RadioGroup radioGroup;
    private Button botaoSalvar;
    private RadioButton radioButtonSelecionado;
    private static final String ARQUIVO_PREFERENCIA = "ArqPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (RelativeLayout) findViewById(R.id.layoutId);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);
        botaoSalvar = (Button) findViewById(R.id.botaoSalvarId);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int idRadioButtonSelecionado = radioGroup.getCheckedRadioButtonId();
                if(idRadioButtonSelecionado>0){

                    radioButtonSelecionado = (RadioButton) findViewById( idRadioButtonSelecionado );

                    String valorRadioButtonSelecionado = "";
                    valorRadioButtonSelecionado = radioButtonSelecionado.getText().toString();

                    SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("corEscolhida", valorRadioButtonSelecionado );
                    editor.commit();

                    setBackground( valorRadioButtonSelecionado );

                }


            }
        });

        //layout.setBackgroundColor(Color.parseColor("#009670"));
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if( sharedPreferences.contains("corEscolhida") ){
            String corRecuperada = sharedPreferences.getString("corEscolhida", "Azul");
            setBackground( corRecuperada );
        }

    }

    private void setBackground(String cor){

        if(cor.equals("Azul")){
            layout.setBackgroundColor(Color.parseColor("#495b7c"));
        }else if(cor.equals("Laranja")){
            layout.setBackgroundColor(Color.parseColor("#ffce26"));
        }else if(cor.equals("Verde")){
            layout.setBackgroundColor(Color.parseColor("#009670"));
        }

    }

}
