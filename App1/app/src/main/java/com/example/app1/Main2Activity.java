package com.example.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView2 = (TextView)findViewById(R.id.textView2);

        String data = getIntent().getStringExtra("data");
        textView2.setText("You wrote: " + data);
    }

    public void Previous(View view){
        Intent previous = new Intent(this, MainActivity.class);
        startActivity(previous);
    }
}
