package com.expance.manager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity implements View.OnClickListener {

    ImageView loginButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acount_create_name);

        // Cài đặt màu sắc thanh trạng thái (status bar)
        SystemConfiguration.setStatusBarColor(this, R.color.white, SystemConfiguration.IconColor.ICON_DARK);

        // Thiết lập layout
        setUpLayout();
    }

    private void setUpLayout() {
        // Khởi tạo các thành phần giao diện
        loginButton1 = findViewById(R.id.loginButton1);

        // Đặt sự kiện click cho nút login
        loginButton1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Khi người dùng nhấn vào loginButton1, chuyển hướng sang trang GetStart
        Intent intent = new Intent(this, AccountCreateName.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.scale_in, R.anim.right_to_left);
    }
}
