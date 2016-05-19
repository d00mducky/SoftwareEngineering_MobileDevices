package edu.perrakcwu.twochickenviews;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void goToNextView(View view) {
    // Do something in response to the button being pressed
        Intent intent = new Intent(this, SecondActivity.class);

        EditText text1 = (EditText) findViewById(R.id.editText1);
        String sText = text1.getText().toString();

        intent.putExtra("userInput", sText);

        startActivity(intent);
    }

    public void alterImage(View view) {

        ImageView image = (ImageView) findViewById(R.id.imageView);
        //image.setImageResource(R.drawable.chicks);
    }
}
