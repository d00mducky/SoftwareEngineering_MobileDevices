package edu.perrakcwu.myjokes; /**
 * Created by kyle on 7/16/15.
 */
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.content.*;
import java.util.*;
import android.database.Cursor;

public class JokeOperations {
    // class/instance variables
    private DataBaseWrapper dbHelper;
    private String[] JOKE_TABLE_COLUMNS = { DataBaseWrapper.JOKE_ID,
            DataBaseWrapper.JOKE };
    private SQLiteDatabase database;
    // constructor
    public JokeOperations(Context context) {
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
    public Joke addJoke(String joke) {
        Joke newJoke = null;
        if (joke.equals("")){
            return newJoke;
        }else{
            ContentValues values = new ContentValues();
            values.put(DataBaseWrapper.JOKE, joke);
            long jokeID = database.insert(DataBaseWrapper.JOKES, null,
                    values);
        // now that the joke is created return it ...
            Cursor cursor = database.query(DataBaseWrapper.JOKES,
            JOKE_TABLE_COLUMNS, DataBaseWrapper.JOKE_ID + " = "
                    + jokeID, null, null, null, null);
            cursor.moveToFirst();
            newJoke = parseJoke(cursor);
            cursor.close();
            return newJoke;
        }
    }
    // delete a joke
    public void deleteJoke(Joke joke) {
        long id = joke.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(DataBaseWrapper.JOKES, DataBaseWrapper.JOKE_ID
                + " = " + id, null);
    }
    // retrieve all of the jokes as entries in a ListArray
    public List getAllJokes() {
        List jokes = new ArrayList();
        Cursor cursor = database.query(DataBaseWrapper.JOKES, JOKE_TABLE_COLUMNS, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Joke joke = parseJoke(cursor);
            jokes.add(joke);
            cursor.moveToNext();
        }
        cursor.close();
        return jokes;
    }
    // Parse/create a new Joke object
    private Joke parseJoke(Cursor cursor) {
        Joke joke = new Joke();
        joke.setId((cursor.getInt(0)));
        joke.setJoke(cursor.getString(1));
        return joke;
    }
}