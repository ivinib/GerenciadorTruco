package com.example.vi_ni.gerenciadortruco.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.vi_ni.gerenciadortruco.R;
import com.example.vi_ni.gerenciadortruco.adapter.TrucoAdapter;
import com.example.vi_ni.gerenciadortruco.model.Truco;
import com.example.vi_ni.gerenciadortruco.repository.TrucoRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listTruco;
    private ArrayAdapter<Truco> adapter;
    private TrucoRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listTruco = findViewById(R.id.listDuplas);
        repository = new TrucoRepository(getApplicationContext());
        adapter = new TrucoAdapter(this,R.layout.truco_item,repository.getAllTrucos());
        listTruco.setAdapter(adapter);
    }

    public void salvar(View view){
        Intent novoTruco = new Intent(MainActivity.this,NovoTrucoActivity.class);
        startActivity(novoTruco);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Truco truco = (Truco) parent.getItemAtPosition(position);
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("O que fazer com "+ truco.getDupla()).setItems(R.array.opcoes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0){
                    callActivity(truco.getId());
                }else if (which == 1){
                    repository.delete(truco.getId());
                    atualizarTruco();
                }
            }
        }).create().show();
    }

    private void atualizarTruco(){
        List<Truco> trucos = repository.getAllTrucos();
        adapter = new TrucoAdapter(getApplicationContext(),R.layout.truco_item,trucos);
        listTruco.setAdapter(adapter);
    }

    private void callActivity(Long id) {
        Intent atualizar = new Intent(MainActivity.this,AtualizarTrucoActivity.class);
        atualizar.putExtra("ID",id);
        startActivity(atualizar);
    }


}
