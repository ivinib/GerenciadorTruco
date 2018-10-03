package com.example.vi_ni.gerenciadortruco.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.vi_ni.gerenciadortruco.DAO.TrucoDAO;
import com.example.vi_ni.gerenciadortruco.model.Truco;

@Database(entities = {Truco.class},version = 1)
public abstract class TrucoRoomDatabase extends RoomDatabase {
    private static volatile TrucoRoomDatabase INSTANCE;
    public abstract TrucoDAO trucoDAO();

    public static TrucoRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (TrucoRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),TrucoRoomDatabase.class,"truco_database").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}