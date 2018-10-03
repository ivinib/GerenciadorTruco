package com.example.vi_ni.gerenciadortruco.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.vi_ni.gerenciadortruco.R;
import com.example.vi_ni.gerenciadortruco.adapter.TrucoAdapter;
import com.example.vi_ni.gerenciadortruco.model.Truco;
import com.example.vi_ni.gerenciadortruco.repository.TrucoRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Truco> trucos;
    private EditText edtDupla, edtPontuacao, edtPartidasGanhas;
    private ListView listTruco;
    private ArrayAdapter<Truco> adapter;
    private TrucoRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtDupla = findViewById(R.id.edtDupla);
        edtPontuacao = findViewById(R.id.edtPontuacao);
        edtPartidasGanhas = findViewById(R.id.edtPartidasGanhas);
        listTruco = findViewById(R.id.listDuplas);
        repository = new TrucoRepository(getApplicationContext());
        adapter = new TrucoAdapter(this,R.layout.truco_item,repository.getAllTrucos());
        listTruco.setAdapter(adapter);
    }

    public void salvar(View view){
        String dupla = edtDupla.getText().toString();
        long pontuacao = Long.parseLong(edtPontuacao.getText().toString());
        String partida = edtPartidasGanhas.getText().toString();
        Truco truco = new Truco();

        truco.setPontuacao(pontuacao);
        truco.setDupla(dupla);
        truco.setPartidasGanhas(partida);

        repository.insert(truco);

        recreate();
    }
}
