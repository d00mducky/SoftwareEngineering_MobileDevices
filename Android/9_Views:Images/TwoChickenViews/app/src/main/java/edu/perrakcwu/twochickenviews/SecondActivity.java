package edu.perrakcwu.twochickenviews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        if (intent != null)
        {
            String userInput = intent.getStringExtra("userInput");

            TextView outputLabel = (TextView) findViewById(R.id.textView);

            outputLabel.setText("Hello " + userInput + "...");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);

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
        // Do something in response to the button being pressed
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void alterImage(View view) {

        ImageView image = (ImageView) findViewById(R.id.imageView);
        //image.setImageResource(R.drawable.chicks);
    }
}
