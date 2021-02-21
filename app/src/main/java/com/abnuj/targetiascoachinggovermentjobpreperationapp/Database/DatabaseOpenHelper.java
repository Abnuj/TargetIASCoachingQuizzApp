package com.abnuj.targetiascoachinggovermentjobpreperationapp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public  class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "TargetIASOfflineQuizeData.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseOpenHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

}
