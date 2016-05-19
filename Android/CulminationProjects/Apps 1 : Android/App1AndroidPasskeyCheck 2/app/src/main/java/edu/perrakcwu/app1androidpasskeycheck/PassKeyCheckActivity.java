package edu.perrakcwu.app1androidpasskeycheck;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import java.util.Random;

public class PassKeyCheckActivity extends Activity {

    public static String randomPasskey = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_key_check);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pass_key_check, menu);
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

    public void generate(View view) {

        Random rand = new Random();

        int firstOperand = rand.nextInt(9);
        int secondOperand = rand.nextInt(9);
        int thirdOperand = rand.nextInt(9);
        int fourthOperand = rand.nextInt(9);

        String firstOp = String.valueOf(firstOperand);
        String secondOp = String.valueOf(secondOperand);
        String thirdOp = String.valueOf(thirdOperand);
        String fourthOp = String.valueOf(fourthOperand);
        randomPasskey = firstOp + secondOp + thirdOp + fourthOp;


        TextView tEdit = (TextView) findViewById(R.id.textView3);

        tEdit.setText("Your passkey: " + randomPasskey);

    }

    public void validate(View view) {

        TextView tEdit2 = (TextView) findViewById(R.id.textView4);

        EditText edit = (EditText) findViewById(R.id.editText2);

        String userInput = edit.getText().toString();

        if (userInput.equals(randomPasskey)) {

            tEdit2.setText("Passkey is: Validated");

        } else {

            tEdit2.setText("Passkey is: Invalid");
        }
    }
}
