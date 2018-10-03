package com.example.vi_ni.gerenciadortruco.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.vi_ni.gerenciadortruco.R;
import com.example.vi_ni.gerenciadortruco.model.Truco;

import java.util.List;

public class TrucoAdapter  extends ArrayAdapter<Truco>{
    private int rId;

    public TrucoAdapter(@NonNull Context context, int resource, @NonNull List<Truco> objects){
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View currertView, ViewGroup parent){
        View mView = currertView;

        if (mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId,null);
        }
        Truco truco = getItem(position);

        TextView txtDupla = mView.findViewById(R.id.txtDupla);
        TextView txtPontuacao = mView.findViewById(R.id.txtPontuacao);
        TextView txtPartida = mView.findViewById(R.id.txtPartidas);

        txtDupla.setText("Nome da dupla: " + truco.getDupla());
        txtPontuacao.setText(String.valueOf("Partidas ganhas: " + truco.getPontuacao()));
        txtPartida.setText("Placar da partida: " + truco.getPartidasGanhas());


        return mView;
    }
}
