package edu.perrakcwu.app3accountidentify;

/**
 * Created by kyle on 7/30/15.
 */
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.content.*;
import java.util.*;
import android.database.Cursor;

public class AccountOperations {
    // class/instance variables
    private DataBaseWrapper dbHelper;
    private String[] JOKE_TABLE_COLUMNS = { DataBaseWrapper.ACCOUNT_ID,
            DataBaseWrapper.ACCOUNT };
    private SQLiteDatabase database;
    // constructor
    public AccountOperations(Context context) {
        dbHelper = new DataBaseWrapper(context);
    }
    // open method that creates reference variable to DB object
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }
    // Add a joke to the table
    public Account addAccount(String account) {
        Account newAccount = null;
        if (account.equals("")){
            return newAccount;
        }else{
            ContentValues values = new ContentValues();
            values.put(DataBaseWrapper.ACCOUNT, account);
            long jokeID = database.insert(DataBaseWrapper.ACCOUNTS, null,
                    values);
            // now that the joke is created return it ...
            Cursor cursor = database.query(DataBaseWrapper.ACCOUNTS,
                    JOKE_TABLE_COLUMNS, DataBaseWrapper.ACCOUNT_ID + " = "
                            + jokeID, null, null, null, null);
            cursor.moveToFirst();
            newAccount = parseAccount(cursor);
            cursor.close();
            return newAccount;
        }
    }
    // delete a joke
    public void deleteAccount(Account account) {
        long id = account.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(DataBaseWrapper.ACCOUNTS, DataBaseWrapper.ACCOUNT_ID
                + " = " + id, null);
    }
    // retrieve all of the jokes as entries in a ListArray
    public List getAllAccounts() {
        List accounts = new ArrayList();
        Cursor cursor = database.query(DataBaseWrapper.ACCOUNTS, JOKE_TABLE_COLUMNS, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Account account = parseAccount(cursor);
            accounts.add(account);
            cursor.moveToNext();
        }
        cursor.close();
        return accounts;
    }
    // Parse/create a new Joke object
    private Account parseAccount(Cursor cursor) {
        Account account = new Account();
        account.setId((cursor.getInt(0)));
        account.setAccount(cursor.getString(1));
        return account;
    }
}
