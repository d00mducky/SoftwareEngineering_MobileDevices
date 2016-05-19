package edu.perrakcwu.app3accountidentify;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by kyle on 7/30/15.
 */

public class DataBaseWrapper extends android.database.sqlite.SQLiteOpenHelper {

    // instance/class fields
    public static final String ACCOUNTS = "Accounts";
    public static final String ACCOUNT_ID = "_id";
    public static final String ACCOUNT = "_account";
    private static final String DATABASE_NAME = "Accounts.db";
    private static final int DATABASE_VERSION = 1;
    // creation SQLite statement
    private static final String DATABASE_CREATE = "create table " + ACCOUNTS
            + "(" + ACCOUNT_ID + " integer primary key autoincrement, "
            + ACCOUNT + " text not null);";
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
        db.execSQL("DROP TABLE IF EXISTS " + ACCOUNTS);
        onCreate(db);
    }
}