package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.example.myfirstapplication.R.id.editText;

/*
 * This is the main activity.
 * It's the entry point for your app.
 * When you build and run your app, the system launches an instance of this Activity and loads its layout.
 */
public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button.
        /*
        * Intent constructor takes two parameters, a Context and a Class
        * Context -> parameter is used first because the Activity class is a subclass of Context
        * The Class parameter of the app component, to which the system delivers the Intent, is, in this case, the activity to start.
        */
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        /*
        * The putExtra() method adds the value of EditText to the intent. An Intent can carry data types as key-value pairs called extras.
        * Your key is a public constant EXTRA_MESSAGE because the next activity uses the key to retrieve the text value.
        *  It's a good practice to define keys for intent extras with your app's package name as a prefix.
        *  This ensures that the keys are unique, in case your app interacts with other apps.
        */
        intent.putExtra(EXTRA_MESSAGE, message);
        /*
        * The startActivity() method starts an instance of the DisplayMessageActivity that's specified by the Intent.
        */
        startActivity(intent);
    }
}