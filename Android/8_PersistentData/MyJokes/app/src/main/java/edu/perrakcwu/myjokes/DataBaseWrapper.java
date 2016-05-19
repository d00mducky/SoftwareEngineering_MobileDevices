package edu.perrakcwu.myjokes;

/**
 * Created by kyle on 7/16/15.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseWrapper extends android.database.sqlite.SQLiteOpenHelper {



    // instance/class fields
    public static final String JOKES = "Jokes";
    public static final String JOKE_ID = "_id";
    public static final String JOKE = "_joke";
    private static final String DATABASE_NAME = "Jokes.db";
    private static final int DATABASE_VERSION = 1;
    // creation SQLite statement
    private static final String DATABASE_CREATE = "create table " + JOKES
            + "(" + JOKE_ID + " integer primary key autoincrement, "
            + JOKE + " text not null);";
        // constructor, that explicitly invokes the superclass's constructor
        public DataBaseWrapper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        // necessary overriding of superclass's abstract method onCreate
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + JOKES);
            onCreate(db);
        }
}

