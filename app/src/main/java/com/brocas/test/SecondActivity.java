package com.brocas.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private ImageView mInforimg;
    private TextView mInfortxt;
    private ImageView mClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mInforimg=findViewById(R.id.Inforimg);
        mInfortxt=findViewById(R.id.Infortxt);
        mClose=findViewById(R.id.close);
        mClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Bundle bundle = this.getIntent().getExtras();

        mInforimg.setImageResource(Integer.parseInt(bundle.get(Share.IMG).toString()));
        mInfortxt.setText(bundle.get(Share.TITLE).toString());
    }
}
