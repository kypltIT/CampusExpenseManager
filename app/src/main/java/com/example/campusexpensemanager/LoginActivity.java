//package com.example.campusexpensemanager;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.campusexpensemanager.model.Users;
//
//public class LoginActivity extends AppCompatActivity {
//    private EditText usernameInput;
//    private EditText passwordInput;
//    private Button loginButton;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        usernameInput = findViewById(R.id.username_input);
//        passwordInput = findViewById(R.id.password_input);
//        loginButton = findViewById(R.id.loginButton);
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Users users = new Users(v.getContext());
//                SQLiteDatabase db = users.dbHelper.getReadableDatabase();
//
//                String inputUsername = usernameInput.getText().toString();
////                String inputPassword = HashUtil.hashPassword(passwordInput.getText().toString());
//                String inputPassword = passwordInput.getText().toString();
//
//                Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?",
//                        new String[]{inputUsername, HashUtil.hashPassword(inputPassword)});
//                if (cursor.moveToFirst()) {
//
//                    @SuppressLint("Range") int id  =cursor.getInt(cursor.getColumnIndex("id"));
//                    @SuppressLint("Range") String name  =
//                            cursor.getString(cursor.getColumnIndex("name"));
//                    @SuppressLint("Range") String phone  =
//                            cursor.getString(cursor.getColumnIndex("phone"));
//                    @SuppressLint("Range") String email  =
//                            cursor.getString(cursor.getColumnIndex("email"));
//                    @SuppressLint("Range") String username  =
//                            cursor.getString(cursor.getColumnIndex("username"));
//                    Auth auth = new Auth(getBaseContext());
//                    auth.saveUser(id, name, phone,email,username);
//
//
//                    Intent intent = new Intent(v.getContext(), MainActivity.class);
//                    v.getContext().startActivity(intent);
//                } else {
//                    Toast.makeText(v.getContext(), "Invalid username/password", Toast.LENGTH_LONG).show();
//                    return;
//                }
//            }
//        });
//
//        TextView registerLink = findViewById(R.id.register_link);
//        registerLink.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), RegisterActivity.class);
//                v.getContext().startActivity(intent);
//            }
//        });
//    }
//}

// LoginActivity.java

package com.example.campusexpensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameInput;
    private EditText passwordInput;
    private Button loginButton;

    private static final String DEMO_USERNAME = "admin";
    private static final String DEMO_PASSWORD = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        loginButton = findViewById(R.id.loginButton);

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
