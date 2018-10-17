package com.example.vi_ni.gerenciadortruco.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.vi_ni.gerenciadortruco.R;
import com.example.vi_ni.gerenciadortruco.adapter.TrucoAdapter;
import com.example.vi_ni.gerenciadortruco.model.Truco;
import com.example.vi_ni.gerenciadortruco.repository.TrucoRepository;

public class NovoTrucoActivity extends Activity {

    private TrucoRepository repository;
    private EditText edtDupla, edtPontuacao, edtPartidasGanhas;
    private TrucoRepository repository1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_truco);

        edtDupla = findViewById(R.id.edtDupla);
        edtPontuacao = findViewById(R.id.edtPontuacao);
        edtPartidasGanhas = findViewById(R.id.edtPartidasGanhas);
        repository1 = new TrucoRepository(getApplicationContext());

    }

    public void salvarTruco(View view){
        Truco truco = new Truco();

        truco.setPontuacao(Integer.parseInt(edtPontuacao.getText().toString()));
        truco.setDupla(edtDupla.getText().toString());
        truco.setPartidasGanhas(edtPartidasGanhas.getText().toString());

        repository1.insert(truco);
        callMainActivity();

    }

    private void callMainActivity(){
        Intent mainActivity = new Intent(NovoTrucoActivity.this, MainActivity.class);
        startActivity(mainActivity);
        finish();
    }

    }
