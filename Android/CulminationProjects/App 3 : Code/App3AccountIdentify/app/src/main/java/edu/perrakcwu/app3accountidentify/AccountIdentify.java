package edu.perrakcwu.app3accountidentify;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
import android.widget.ArrayAdapter;

public class AccountIdentify extends Activity {

    private AccountOperations accountOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_identify);
        //
        accountOperations = new AccountOperations(this);
        accountOperations.open();
        List values = accountOperations.getAllAccounts();
        // Use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_expandable_list_item_1, values);
        //setListAdapter(adapter);


        /***************************Could Not Get Any Adapter Methods Working***************************************/
    }

    public void addAccount(View view) {
        //ArrayAdapter adapter = (ArrayAdapter) getListAdapter();
        EditText text = (EditText) findViewById(R.id.editText);
        Account account = accountOperations.addAccount(text.getText().toString());
        //adapter.add(account);
    }
    public void deleteFirstAccount(View view) {
        //ArrayAdapter adapter = (ArrayAdapter) getListAdapter();
        Account account = null;
        //if (getListAdapter().getCount() > 0) {
            //account = (Account) getListAdapter().getItem(0);
            accountOperations.deleteAccount(account);
            //adapter.remove(account);
        }

    @Override
    protected void onResume() {
        accountOperations.open();
        super.onResume();
    }
    @Override
    protected void onPause() {
        accountOperations.close();
        super.onPause();
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
