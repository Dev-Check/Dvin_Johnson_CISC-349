package com.dvincisc349.login2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText userInputEditText;
    private EditText passwordInputEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure this matches your layout file name

        // Initialize your views with the correct IDs
        userInputEditText = findViewById(R.id.user_input); // Matches the ID in the layout
        passwordInputEditText = findViewById(R.id.password_input); // Matches the ID in the layout
        loginButton = findViewById(R.id.login_button); // Matches the ID in the layout

        // Add a click listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userInputEditText.getText().toString().trim();
                String password = passwordInputEditText.getText().toString().trim();

                // Here you can call your server API for authentication (using Volley, Retrofit, etc.)
                // For now, we are simulating the check
                if (username.equals("admin") && password.equals("password")) {
                    // Successful login, show success message or change UI on the same activity
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

                    // Optionally, you can update UI elements or perform other actions on successful login
                } else {
                    // Show error message
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        }
        );
    }
}