package com.example.qrscanner.qira;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QrMaker extends AppCompatActivity {

    private Button generate;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_maker);

        final Context context = this;
        editText = (EditText) this.findViewById(R.id.edit_qr);
        generate = (Button) this.findViewById(R.id.btn_generate);
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textQr = editText.getText().toString();
                if(editText.getText().toString().length()==0){
                    editText.setError("You Need To Type Something");
                }else {
                    Toast.makeText(getApplicationContext(), "Ta-Da! Here You Go", Toast.LENGTH_SHORT).show();
                }
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(textQr, BarcodeFormat.QR_CODE, 200, 200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    Intent intent = new Intent(context, QrDisplay.class);
                    intent.putExtra("pic", bitmap);
                    context.startActivity(intent);
                }
                catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
