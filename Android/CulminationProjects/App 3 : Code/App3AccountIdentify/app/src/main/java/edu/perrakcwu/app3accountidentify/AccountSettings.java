package edu.perrakcwu.app3accountidentify;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;


public class AccountSettings extends Activity {

    public static String passedName;
    public static String passedPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        Intent intent = getIntent();

        if (intent != null) {

            passedName = intent.getStringExtra("firstViewName");
            passedPass = intent.getStringExtra("firstViewPass");

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_account_settings, menu);
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

    public void goToNextView2(View view) {

        Intent intent = new Intent(this, AccountIdentify.class);

        startActivity(intent);
    }

    public void changeUserName(View view) {

        TextView text = (TextView) findViewById(R.id.textView);
        EditText userName = (EditText) findViewById(R.id.editText4);
        EditText userPass = (EditText) findViewById(R.id.editText5);
        EditText nameChange = (EditText) findViewById(R.id.editText6);
        String sUserName = userName.getText().toString();
        String sUserPass = userPass.getText().toString();
        String sNameChange = nameChange.getText().toString();

        if (sUserName.equals("")) // if current userName textfield is empty
        {
            text.setText("Please Enter Your Current Username");
        } else if (sUserPass.equals("")) // if current password textfield is empty
        {
            text.setText("Please Enter Your Current Password");
        } else if (sNameChange.equals("")) // if updating textfield is empty
        {
            text.setText("Please Enter an Updated Value");
        } else // if all textfields have been filled in
        {

            if(sUserName.equals(passedName)) // if userName is equal to first view userName
            {
                if(sUserPass.equals(passedPass)) // if userPass is equal to first view userPass
                {
                    setUserName(view, sNameChange, sUserName);
                } else // wrong password input
                {
                    text.setText("Non-Matching Password Input");
                }
            } else // wrong username input
            {
                text.setText("Non-Matching Username Input");
            }
        }
    }

    public void changeUserPass(View view) {

        TextView text = (TextView) findViewById(R.id.textView);
        EditText userName = (EditText) findViewById(R.id.editText4);
        EditText userPass = (EditText) findViewById(R.id.editText5);
        EditText passChange = (EditText) findViewById(R.id.editText6);
        String sUserName = userName.getText().toString();
        String sUserPass = userPass.getText().toString();
        String sPassChange = passChange.getText().toString();

        if (sUserName.equals("")) // if current userName textfield is empty
        {
            text.setText("Please Enter Your Current Username");
        } else if (sUserPass.equals("")) // if current password textfield is empty
        {
            text.setText("Please Enter Your Current Password");
        } else if (sPassChange.equals("")) // if updating textfield is empty
        {
            text.setText("Please Enter an Updated Value");
        } else // if all textfields have been filled in
        {

            if (sUserName.equals(passedName)) // if userName is equal to first view userName
            {
                if (sUserPass.equals(passedPass)) // if userPass is equal to first view userPass
                {
                    setUserPass(view,sPassChange,sUserPass);
                } else // wrong password input
                {
                    text.setText("Non-Matching Password Input");
                }
            } else // wrong username input
            {
                text.setText("Non-Matching Username Input");
            }

        }
    }

    public void setUserName(View view, String newUsername, String oldUsername) {

        TextView text = (TextView) findViewById(R.id.textView);
        text.setText("Your Account Information Was Successfully Changed\nNew Username: " + newUsername
                + "\nOld Username: " + oldUsername);
    }

    public void setUserPass(View view, String newPassword, String oldPassword) {

        TextView text = (TextView) findViewById(R.id.textView);
        text.setText("Your Account Information Was Successfully Changed\nNew Password: " + newPassword
                + "\nOld Password: " + oldPassword);
    }
}
