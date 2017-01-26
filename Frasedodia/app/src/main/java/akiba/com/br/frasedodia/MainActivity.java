package akiba.com.br.frasedodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textoNovaFrase;
    private Button botaoNovaFrase;

    private String[] frases = {
            "Feche os olhos para as pessoas que prendem e julgam você, e abra os olhos para as maravilhas do mundo e para todas as novas oportunidades no seu futuro.",
            "O caráter de um homem pode determinar a nobreza do mundo. Feliz Dia para todos os homens!",
            "Nesta manhã, a luz do sol entrou pela janela do meu quarto com a mesma velocidade que você entrou no meu pensamento. Bom dia, amor!",
            "Feliz dia do Professor, a todos que alguma vez já se pegaram falando para as paredes numa sala de aula!",
            "Tudo seria feio e escuro se não tivesse do meu lado pessoas maravilhosas como você. Agradeço por tudo!",
            "Nunca é tarde demais enquanto houver caminho pela frente. Boa semana!",
            "Quando entrelaçamos nossas mãos o medo desaparece e sinto que posso tudo. Bom dia, meu namorado!",
            "Viva um dia de cada vez, agora pense no hoje que o amanhã lá acabará chegando.",
            "Na ansiedade de nos encontrar a vida nos juntou. Bom dia, meu amor!",
            "Cada minuto longe de você parece uma eternidade.",
            "Nenhuma razão é mais válida para procurar a felicidade do que simplesmente existir.",
            "Quando amamos, acordar para um novo dia é sair de um sonho para entrar em outro melhor.",
            "Até as flores mais bonitas murcham e morrem, mas a nossa amizade permanecerá para sempre! Bom dia, amigo!",
            "Tudo em você é belo, é perfeito. Um bom dia para você, meu amor!",
            "Você deve ser sempre uma prioridade na sua vida. Boa tarde!"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNovaFrase = (TextView) findViewById(R.id.textoNovaFraseId);
        botaoNovaFrase = (Button) findViewById(R.id.botaoNovaFraseId);

        //textoNovaFrase.setText(frases[0]);

        botaoNovaFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();
                int num = random.nextInt(frases.length);
                textoNovaFrase.setText(frases[num]);
            }
        });

    }
}
