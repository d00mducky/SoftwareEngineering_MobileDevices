package edu.perrakcwu.app2accountidentify;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;


/**
 * Created by kyle on 7/22/15.
 */
public class AccountDatabase extends SQLiteOpenHelper {

    private final static int DATABASE_VERSION = 1;
    private final static String DATABASE_NAME = "AccountDB.db";
    AccountStructure account = new AccountStructure();

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {

    }

    public AccountDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    public void addAccount(AccountStructure account) {

    }

    public AccountStructure findAccount(AccountStructure account)
    {

    return account;

    }





}
