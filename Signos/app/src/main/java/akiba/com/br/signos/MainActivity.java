package akiba.com.br.signos;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listViewSignos;
    private String[] signos = {
            "Áries",
            "Touro",
            "Gêmeos",
            "Câncer",
            "Leão",
            "Virgem",
            "Libra",
            "Escorpião",
            "Sagitário",
            "Capricórnio",
            "Aquário",
            "Peixes"};
    private String[] perfis = {
            "Não sei bem o que quero, só sei que quero JÁ!",
            "Amor numa cabana? Só se for 5 ESTRELAS",
            "Odeio fofocas… Mas… já te contei a última?",
            "Lar… Meu doce LAR!",
            "Antigamente EU era vaidoso, mas agora me curei e estou PERFEITO!",
            "Já te disse que sou SUPER DEMOCRATA… mas porque você ainda não fez o que eu MANDEI?",
            "A justiça tarda mas não falha, pois está sempre COMIGO",
            "Sou super LIBERAL… mas onde você foi, MESMO?",
            "Já te disse 1.000.000 de vezes que NUNCA EXAGERO!",
            "HOJE assumi o cargo de vice-diretor de uma empresa que ORGANIZAREI, e será sucesso daqui a 10 ANOS",
            "‘Já estou guardando grana, para construir a NOSSA bela casa lá na LUA",
            "Ontem tinha DÚVIDAS, hoje… NÃO SEI!"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewSignos = (ListView) findViewById(R.id.listViewId);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, signos);

        listViewSignos.setAdapter(adapter);

        listViewSignos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int codigoPosicao = i;

                Toast.makeText(getApplicationContext(), perfis[codigoPosicao], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
