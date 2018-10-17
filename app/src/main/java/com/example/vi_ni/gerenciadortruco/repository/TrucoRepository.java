package com.example.vi_ni.gerenciadortruco.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.vi_ni.gerenciadortruco.DAO.TrucoDAO;
import com.example.vi_ni.gerenciadortruco.database.TrucoRoomDatabase;
import com.example.vi_ni.gerenciadortruco.model.Truco;

import java.util.List;

public class TrucoRepository {

    private TrucoDAO mTrucoDAO;
    private List<Truco> mTrucos;

    public TrucoRepository(Context context){
        TrucoRoomDatabase db = TrucoRoomDatabase.getDatabase(context);
        mTrucoDAO = db.trucoDAO();
        mTrucos = mTrucoDAO.loadTruco();
    }

    public List<Truco> getAllTrucos(){
        mTrucos = mTrucoDAO.loadTruco();
        return mTrucos;
    }

    public Truco loadTrucoByID(long ID){
        return mTrucoDAO.loadTrucoByID(ID);
    }

    public void insert(Truco truco){
        new insertAsyncTask(mTrucoDAO).execute(truco);
    }

    public void delete(long id){
        mTrucoDAO.delete(id);
    }
    public void update(Truco truco){
        mTrucoDAO.update(truco);
    }

    private static class insertAsyncTask extends AsyncTask<Truco,Void,Void>{
        private  TrucoDAO mAsyncTaskDAO;
        insertAsyncTask(TrucoDAO dao){ mAsyncTaskDAO = dao;}

        @Override
        protected Void doInBackground(final Truco... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
