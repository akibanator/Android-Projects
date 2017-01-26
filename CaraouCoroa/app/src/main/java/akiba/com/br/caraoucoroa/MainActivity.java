package akiba.com.br.caraoucoroa;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView buttonJogar;
    private String[] opcao = {"cara", "coroa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonJogar = (ImageView) findViewById(R.id.imageViewJogarId);

        buttonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Gerar número aleatório
                Random random = new Random();
                int numAleatorio = random.nextInt(2);

                //0 - cara, 1 - coroa
                //opcao[numAleatorio]
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("opcao", opcao[numAleatorio]);

                startActivity(intent);

            }
        });
    }
}
