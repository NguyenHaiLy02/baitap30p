package com.example.nguyenhaily_bttailop_30p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,pass;
    CheckBox luumk;
    Button login;
    SharedPreferences sharedPreferences;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
       Anhxa();
       username.setText(sharedPreferences.getString("taikhoan",""));
        pass.setText(sharedPreferences.getString("matkhau",""));
        luumk.setChecked(sharedPreferences.getBoolean("checked",false));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString().trim();
                String password = pass.getText().toString().trim();
                if(uname.equals("haily")&& password.equals("1234")){
                    Toast.makeText(MainActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    if(luumk.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan",uname);
                        editor.putString("matkhau",password);
                        editor.putBoolean("checked",true);
                        editor.commit();
                    }
                }else
                    Toast.makeText(MainActivity.this, "Lỗi đăng nhập", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void Anhxa() {
        username = (EditText) findViewById(R.id.editText_user);
        pass = (EditText) findViewById(R.id.editText_pass);
        luumk = (CheckBox) findViewById(R.id.checkbox);
        login = (Button) findViewById(R.id.buttonLogin);

    }
}