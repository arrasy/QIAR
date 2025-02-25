package com.example.qrscanner.qira;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    private TextView textView;
    Button insertButton,discardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        myDb = new DatabaseHelper(this);

        textView=(TextView)findViewById(R.id.result_txt);
        insertButton=(Button)findViewById(R.id.add_btn);
        discardButton=(Button)findViewById(R.id.ignore_btn);

        Intent intent =getIntent();
        String qrData=intent.getExtras().getString("key");
        AddData(qrData);
       textView.setText(qrData);

       discardButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(SecondActivity.this, MainActivity.class);
               startActivity(i);
           }
       });

    }

    public void AddData(final String qrData) {
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = myDb.insertData(qrData);
                if(isInserted == true)
                    Toast.makeText(SecondActivity.this,"Saved",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(SecondActivity.this,"Can't Saved",Toast.LENGTH_LONG).show();
            }
        });
    }


}
