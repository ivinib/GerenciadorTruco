package com.example.vi_ni.gerenciadortruco.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "truco_table")
public class Truco {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private long id;
    private String dupla;
    private long pontuacao;
    private String partidasGanhas;

    public Truco() {
    }

    public Truco(long id, String dupla, long pontuacao, String partidasGanhas) {
        this.id = id;
        this.dupla = dupla;
        this.pontuacao = pontuacao;
        this.partidasGanhas = partidasGanhas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDupla() {
        return dupla;
    }

    public void setDupla(String dupla) {
        this.dupla = dupla;
    }

    public long getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(long pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getPartidasGanhas() {
        return partidasGanhas;
    }

    public void setPartidasGanhas(String partidasGanhas) {
        this.partidasGanhas = partidasGanhas;
    }

}
