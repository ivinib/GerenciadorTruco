package com.example.vi_ni.gerenciadortruco.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.vi_ni.gerenciadortruco.model.Truco;

import java.util.List;
@Dao
public interface TrucoDAO {

    @Insert
    void insert(Truco truco);

    @Query("DELETE FROM truco_table WHERE truco_table.ID == :id")
    void delete(long id);

    @Query("SELECT * FROM truco_table ORDER BY partidasGanhas DESC")
    List<Truco> loadTruco();
}
