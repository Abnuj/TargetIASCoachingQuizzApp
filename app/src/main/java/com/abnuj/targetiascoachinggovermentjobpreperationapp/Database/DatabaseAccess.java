package com.abnuj.targetiascoachinggovermentjobpreperationapp.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.abnuj.targetiascoachinggovermentjobpreperationapp.Models.DatabaseQuizesmodel;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.Util.Constants;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //    ***** Open the database connection
    public void open() {
        this.database = openHelper.getReadableDatabase();
    }

    //*** Close the database Connection *******
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    //    *** Read data from database ********
    public List<DatabaseQuizesmodel> getCompleteData(String SELECTEDSUBCATEGORY) {
        List<DatabaseQuizesmodel> quizesmodels = new ArrayList<>();
        DatabaseQuizesmodel quizesmodel = new DatabaseQuizesmodel();
//       "SELECT * FROM AllQuizesDataTargetIAS WHERE SubjectSubCategory = "+Constants.SELECTEDSUBCATEGORY,null
//        Cursor cursor = database.query(Constants.TABLENAME, new String[]
//                        {Constants.SubjectSubCategory,Constants.Question, Constants.Option1, Constants.Option2, Constants.Option3, Constants.Option4, Constants.CorrectAnswer}
//                , Constants.SubjectSubCategory + "=?", new String[]{Constants.SELECTEDSUBCATEGORY}
//                , null, null, Constants.ID, null);

        Cursor cursor = database.rawQuery("SELECT * FROM " + Constants.TABLENAME + " WHERE " +
                Constants.SubjectSubCategory + " ='Numbers' AND "+Constants.ID + " BETWEEN 1 AND 5", null);

        if (cursor != null)
            cursor.moveToFirst();

        do {
//            quizesmodel.setId(cursor.getInt(cursor.getColumnIndex(Constants.ID)));
//         quizesmodel.setSubjectcategory(cursor.getString(cursor.getColumnIndex(Constants.SubjectSubCategory)));

            quizesmodel.setQuestion(cursor.getString(cursor.getColumnIndex(Constants.Question)));
            quizesmodel.setOption1(cursor.getString(cursor.getColumnIndex(Constants.Option1)));
            quizesmodel.setOption2(cursor.getString(cursor.getColumnIndex(Constants.Option2)));
            quizesmodel.setOption3(cursor.getString(cursor.getColumnIndex(Constants.Option3)));
            quizesmodel.setOption4(cursor.getString(cursor.getColumnIndex(Constants.Option4)));
            quizesmodel.setCorrectAnswer(cursor.getString(cursor.getColumnIndex(Constants.CorrectAnswer)));
            quizesmodels.add(quizesmodel);
        } while (cursor.moveToNext());


        return quizesmodels;
    }

public DatabaseQuizesmodel getsinglequestiondata(int Index)
{

    DatabaseQuizesmodel quizesmodel = new DatabaseQuizesmodel();
//       "SELECT * FROM AllQuizesDataTargetIAS WHERE SubjectSubCategory = "+Constants.SELECTEDSUBCATEGORY,null
        Cursor cursor = database.query(Constants.TABLENAME, new String[]
                        {Constants.SubjectSubCategory,Constants.Question, Constants.Option1, Constants.Option2, Constants.Option3, Constants.Option4, Constants.CorrectAnswer}
                , Constants.SubjectSubCategory + "=? AND "+Constants.ID +" = '1'", new String[]{Constants.SELECTEDSUBCATEGORY}
                , null, null, Constants.ID, null);

//    Cursor cursor = database.rawQuery("SELECT * FROM " + Constants.TABLENAME + " WHERE " +
//            Constants.SubjectSubCategory + " ='Numbers' AND "+Constants.ID + " BETWEEN 1 AND 5", null);

    if (cursor != null)
        cursor.moveToFirst();

//            quizesmodel.setId(cursor.getInt(cursor.getColumnIndex(Constants.ID)));
//         quizesmodel.setSubjectcategory(cursor.getString(cursor.getColumnIndex(Constants.SubjectSubCategory)));

        quizesmodel.setQuestion(cursor.getString(cursor.getColumnIndex(Constants.Question)));
        quizesmodel.setOption1(cursor.getString(cursor.getColumnIndex(Constants.Option1)));
        quizesmodel.setOption2(cursor.getString(cursor.getColumnIndex(Constants.Option2)));
        quizesmodel.setOption3(cursor.getString(cursor.getColumnIndex(Constants.Option3)));
        quizesmodel.setOption4(cursor.getString(cursor.getColumnIndex(Constants.Option4)));
        quizesmodel.setCorrectAnswer(cursor.getString(cursor.getColumnIndex(Constants.CorrectAnswer)));

        return quizesmodel;
}
}
