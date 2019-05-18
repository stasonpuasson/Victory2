package com.marchenko.victory2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String name;
    EditText inp;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inp = findViewById(R.id.inputTxt);
        btn = findViewById(R.id.loginBtn);
    }

    public void login(View view) {
        name = inp.getText().toString();
        Intent intent = new Intent(this, Quest.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
