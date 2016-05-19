package edu.perrakcwu.myrssapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.view.View;


public class MainActivity extends Activity {

    private String finalUrl="http://tutorialspoint.com/android/sampleXML.xml";
    private ProcessXML obj;

    public void fetch(View view){
// create a new instance of an ProcessXML object
        obj = new ProcessXML(finalUrl);
        obj.fetchXML();
// complete parsing the XML
        while(obj.parsingComplete);
// retrieve the data in the title, link, and description tags
// from the RSS feed
        String feedTitle = obj.getTitle();
        String feedLink = obj.getLink();
        String feedDescription = obj.getDescription();
// create reference variables to components in your app
        EditText rssTitle = (EditText) findViewById(R.id.editTextTitle);
        EditText rssLink = (EditText) findViewById(R.id.editTextLink);
        EditText rssDescription = (EditText) findViewById(R.id.editTextDescription);
// set the text of those components to the data retrieved from the RSS
        rssTitle.setText(feedTitle);
        rssLink.setText(feedLink);
        rssDescription.setText(feedDescription);
    }

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
}
