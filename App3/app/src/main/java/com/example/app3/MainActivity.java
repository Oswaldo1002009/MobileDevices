package com.example.app3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;
//import android.content.DialogInterface;
//import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        Toast MyToast = new Toast(context);
        MyToast.makeText(context, "My first Toast Message", Toast.LENGTH_LONG).show();

        AlertDialog.Builder DialogConf = new AlertDialog.Builder (this);
        DialogConf.setTitle("Conf Dialog");
        DialogConf.setMessage("Text of the dialog");
        DialogConf.setIcon(R.mipmap.ic_launcher);

        DialogConf.setNeutralButton("Close",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int d){
                        Toast.makeText(context, "You closed the dialog", Toast.LENGTH_LONG).show();
                    }
                });

        AlertDialog MyDialog = DialogConf.create();
        MyDialog.show();

        AlertDialog.Builder DialogConf2 = new AlertDialog.Builder (this);
        DialogConf2.setTitle("Conf Dialog");
        DialogConf2.setMessage("Text of the dialog");
        DialogConf2.setIcon(R.mipmap.ic_launcher);

        DialogConf2.setPositiveButton("Yes",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Toast.makeText(context, "Answer yes", Toast.LENGTH_LONG).show();
                    }
                });

        DialogConf2.setNegativeButton("No",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Toast.makeText(context, "Answer no", Toast.LENGTH_LONG).show();
                    }
                });

        DialogConf2.setNeutralButton("Close",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Toast.makeText(context, "Closed dialog", Toast.LENGTH_LONG).show();
                    }
                });

        AlertDialog MySecondDialog = DialogConf2.create();
        MySecondDialog.show();

        //Next step
        AlertDialog.Builder DialogConf3 = new AlertDialog.Builder (this);
        DialogConf3.setTitle("Conf Dialog");
        DialogConf3.setMessage("Text of the dialog");
        DialogConf3.setIcon(R.mipmap.ic_launcher);

        final EditText TextInput = new EditText(context);
        TextInput.setTextColor(Color.RED);
        DialogConf3.setView(TextInput);

        DialogConf3.setNeutralButton("Cancel",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        String str = TextInput.getEditableText().toString();
                        Toast.makeText(context, "You wrote " + str, Toast.LENGTH_LONG).show();
                    }
                });

        AlertDialog MyThirdDialog = DialogConf3.create();
        MyThirdDialog.show();
    }


}
