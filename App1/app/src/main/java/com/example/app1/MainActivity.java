package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
    }

    //Button methods
    public void Next(View view){
        Intent next = new Intent(this, Main2Activity.class);
        next.putExtra("data", editText.getText().toString());
        startActivity(next);
    }


}
