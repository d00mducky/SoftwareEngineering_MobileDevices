package edu.perrakcwu.app2accountidentify;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class AccountIdentify extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_identify);
        AccountDatabase acctDB = new AccountDatabase(this,null,null,1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_account_identify, menu);
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


    public void createAccount(View view) {
        //instantiate output label
        TextView outputLabel = (TextView) findViewById(R.id.textView11);
        // grab user input
        EditText userName = (EditText) findViewById(R.id.editText);
        EditText userPass = (EditText) findViewById(R.id.editText2);
        // set user input as string
        String fUserName = userName.getText().toString();
        String fUserPass = userPass.getText().toString();

        if(fUserName.equals("")) {
            outputLabel.setText("Please Enter a Username");
        } else if (fUserPass.equals("")) {
            outputLabel.setText("Please Enter a Password");

        } else {
            outputLabel.setText("Congratulations!\nYour Account Has Been Created\nUsername: "
                    + fUserName + "\nPassword: " + fUserPass);
        }
    }


    public void goToNextView(View view) {

        Intent intent = new Intent(this, AccountSettings.class);

        EditText firstViewName = (EditText) findViewById(R.id.editText);
        EditText firstViewPass = (EditText) findViewById(R.id.editText2);

        String fUserName = firstViewName.getText().toString();
        String fUserPass = firstViewPass.getText().toString();

        intent.putExtra("firstViewName", fUserName);
        intent.putExtra("firstViewPass", fUserPass);

        startActivity(intent);
    }


}
