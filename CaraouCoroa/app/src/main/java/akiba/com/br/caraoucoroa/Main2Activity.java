package akiba.com.br.caraoucoroa;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    private ImageView imageViewMoeda;
    private ImageView imageViewVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageViewMoeda = (ImageView) findViewById(R.id.imageViewMoedaId);
        imageViewVoltar = (ImageView) findViewById(R.id.imageViewVoltarId);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String opcaoEscolhida = bundle.getString("opcao");
            if (opcaoEscolhida.equals("cara")) {
                //imagem cara
                imageViewMoeda.setImageDrawable(ContextCompat.getDrawable(Main2Activity.this, R.drawable.moeda_cara));
            } else {
                //imagem coroa
                imageViewMoeda.setImageDrawable(ContextCompat.getDrawable(Main2Activity.this, R.drawable.moeda_coroa));
            }
        }

        imageViewVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
