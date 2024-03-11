package com.example.homeaffairs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import  android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a vertical LinearLayout
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);

        // Create an EditText for the username
        EditText usernameEditText = new EditText(this);
        usernameEditText.setHint("Username");
        linearLayout.addView(usernameEditText);

        // Create an EditText for the password
        EditText passwordEditText = new EditText(this);
        passwordEditText.setHint("Password");
        passwordEditText.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD);
        linearLayout.addView(passwordEditText);

        //create a horizontal linearlayout for buttons
        LinearLayout buttonLayout = new LinearLayout(this);
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
        buttonLayout.setGravity(Gravity.CENTER);

        // Create a Button for submission
        Button submitButton = new Button(this);
        submitButton.setText("Submit");
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check login credentials
                //boolean isValid = checkLoginCredentials(usernameEditText.getText().toString(), passwordEditText.getText().toString());

                //Directly navigate to menu page userMenu.java
                Intent intent = new Intent(MainActivity.this,MenuHandler.class);
                startActivity(intent);
                finish();
            }
        });

        //buttonLayout.addView(submitButton);
        buttonLayout.addView(submitButton);
        linearLayout.addView(buttonLayout);

        //create a cancell button
        Button cancelButton = new Button(this);
        cancelButton.setText("Cancel");
        cancelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //clear the fields of username & password
                usernameEditText.setText("");
                passwordEditText.setText("");
            }

        });
        //buttonLayout.addView(cancelButton);
        linearLayout.addView(cancelButton);


        //create a registration link
        TextView registerTextView = new TextView(this);
        registerTextView.setText("Don't have an account? Register here");
        registerTextView.setClickable(true);
        registerTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "Register clicked", Toast.LENGTH_SHORT).show();
            }
        });
        linearLayout.addView(registerTextView);


        //Set the content view to the LinearLayout
        setContentView(linearLayout);



    }
}