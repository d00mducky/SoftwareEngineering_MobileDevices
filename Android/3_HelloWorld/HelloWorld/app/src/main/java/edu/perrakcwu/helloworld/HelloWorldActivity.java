package edu.perrakcwu.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


public class HelloWorldActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hello_world, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void postMessage(View view) {

        //retrieve the pointer to the text (EditText) object where user input name
        //follow pointer and retrieve text input by user in text field
        //retrieve the pointer to the output text (TextView)
        //follow the pointer to output text and set value as "Hello" + user input

        EditText edit = (EditText) findViewById(R.id.editText);
        String usersInput = edit.getText().toString();

        TextView tEdit = (TextView) findViewById(R.id.textView3);

        tEdit.setText("Hello " + usersInput);

    }
}
