package com.example.carloanemi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}