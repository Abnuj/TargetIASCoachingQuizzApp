package com.abnuj.targetiascoachinggovermentjobpreperationapp.Util;

import android.content.Context;
import android.content.SharedPreferences;

import com.abnuj.targetiascoachinggovermentjobpreperationapp.Models.SubjectModel;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.R;

public class Preferences {

    SharedPreferences sharedPreferences;
    Context context;

    public Preferences(Context context) {
        this.context = context;
        getSharedPreference();
    }

    private void getSharedPreference() {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.Userdata), Context.MODE_PRIVATE);
    }

    public void writeSharedPreference(String SUBJECTNAME, int Imagedata) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.SUBJECTNAME), SUBJECTNAME);
        editor.putInt(context.getString(R.string.SUBJECTIMAGE), Imagedata);
        editor.apply();
    }
    public void writeSharedPreference(String subjectSubCategories)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getResources().getString(R.string.SUBJECT_SUB_CATEGORIES),subjectSubCategories);
        editor.apply();
    }

//    public boolean checkPreference() {
//        boolean status = false;
//        if (sharedPreferences.getString(context.getString(R.string.USERNAMEKEY), "null").equals("null")) {
//            status = false;
//        } else {
//            status = true;
//        }
//        return status;
//    }

    public void clearPreference() {
        sharedPreferences.edit().clear().apply();
    }

    public SubjectModel getSubjectData() {
        String SelectedSubjectName = sharedPreferences.getString(context.getString(R.string.SUBJECTNAME), "");
        int selectedSubjectImage = sharedPreferences.getInt(context.getString(R.string.SUBJECTIMAGE), 0);
        return new SubjectModel(selectedSubjectImage, SelectedSubjectName);
    }
}
