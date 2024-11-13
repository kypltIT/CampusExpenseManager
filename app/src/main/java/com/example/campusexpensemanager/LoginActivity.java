package com.example.campusexpensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameInput;  // Đây là trường nhập email
    private EditText passwordInput;
    private Button loginButton;

    private static final String DEMO_USERNAME = "admin";
    private static final String DEMO_PASSWORD = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        usernameInput = findViewById(R.id.email_input);  // Thay đổi username_input thành email_input
        passwordInput = findViewById(R.id.password_input);
        loginButton = findViewById(R.id.sign_in_button);  // Thay đổi loginButton thành sign_in_button

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (username.equals(DEMO_USERNAME) && password.equals(DEMO_PASSWORD)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("USERNAME", username);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid credentials! Use admin/123", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
