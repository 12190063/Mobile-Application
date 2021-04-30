package com.gcit.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Text view for Hello World.
    private TextView mHelloTextView;

    // array of color names, these match the color resources in color.xml
    private String[] mColorArray =
            {"red",
            "pink",
            "purple",
            "deep_purple",
            "indigo",
            "blue",
            "light_blue",
            "cyan",
            "green",
             "teal",
            "light_green",
            "lime",
            "yellow",
            "amber",
            "orange",
            "deep_orange",
            "brown",
            "grey",
            "blue_grey",
            "black" };

    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the main text view
        mHelloTextView = (TextView) findViewById(R.id.hello_textview);

        // Restore saved instance state (the text color)
        if (savedInstanceState != null) {
            mHelloTextView.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    /**
     * Handles the onClick for the change color button. Chooses a random color name from
     * the color array and gets the color value for that name from the resources. Sets
     * the Hello World textview to that color.
     *
     * @param view The view (Button) that was clicked.
     */
    public void changeColor(View view) {
        // get a random color name from the color array (20 colors)
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(20)];

        // get the color identifier that matches the color name
        int colorResourceName = getResources().getIdentifier(colorName,
                "color", getApplicationContext().getPackageName());

        // get the color ID from the resources
        // The pre API 23 way
        // int colorRes = getResources().getColor(colorResourceName);
        // The post API way
        // int colorRes = getResources().getColor(colorResourceName, this.getTheme());
        // Compatible way
        int colorRes = ContextCompat.getColor(this, colorResourceName);

        // Set the text color
        mHelloTextView.setTextColor(colorRes);
    }

    /**
     * Save the instance state if the activity is restarted (for example, on device rotation).
     * Saves the color of the hello world text.
     *
     * @param outState The state data.
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // save the current text color
        outState.putInt("color", mHelloTextView.getCurrentTextColor());
    }
}