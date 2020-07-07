package com.example.qrscanner.qira;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class QrDisplay extends AppCompatActivity {

    private ImageView imageView;
    Button backmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_gen_display);

        backmenu=(Button)findViewById(R.id.bmenu);

        imageView = (ImageView) findViewById(R.id.qrimage_view);
        Bitmap bitmap = getIntent().getParcelableExtra("pic");
        imageView.setImageBitmap(bitmap);

        backmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QrDisplay.this, MainActivity.class);
                startActivity(i);
            }
        });



    }
}