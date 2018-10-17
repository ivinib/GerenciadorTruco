package com.example.vi_ni.gerenciadortruco.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vi_ni.gerenciadortruco.R;
import com.example.vi_ni.gerenciadortruco.model.Truco;
import com.example.vi_ni.gerenciadortruco.repository.TrucoRepository;

public class AtualizarTrucoActivity extends Activity {
    private TrucoRepository repository;
    private EditText edtDupla, edtPontuacao, edtPartidasGanhas;
    private TrucoRepository repository1;
    private Truco truco;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atualizar_truco_activity);

        long extra_id = getIntent().getLongExtra("ID",0);
        Toast.makeText(this, "ID:"+ extra_id, Toast.LENGTH_SHORT).show();

        edtDupla = findViewById(R.id.edtDupla);
        edtPontuacao = findViewById(R.id.edtPontuacao);
        edtPartidasGanhas = findViewById(R.id.edtPartidasGanhas);
        repository1 = new TrucoRepository(getApplicationContext());
        loadTruco(extra_id);

    }
    private void loadTruco(long extra_id){
        truco = repository1.loadTrucoByID(extra_id);
        edtDupla.setText(truco.getDupla());
        edtPartidasGanhas.setText(String.valueOf(truco.getPartidasGanhas()));
        edtPontuacao.setText(String.valueOf(truco.getPontuacao()));
    }

    private void atualizaTruco(View view){
        truco.setPontuacao(Integer.parseInt(edtPontuacao.getText().toString()));
        truco.setDupla(edtDupla.getText().toString());
        truco.setPartidasGanhas(edtPartidasGanhas.getText().toString());

        repository1.update(truco);
        callMainActivity();
    }

    private void callMainActivity(){
        Intent mainActivity = new Intent(AtualizarTrucoActivity.this, MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
