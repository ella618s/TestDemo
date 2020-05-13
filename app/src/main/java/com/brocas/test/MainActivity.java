package com.brocas.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements InformationCallback{

    private TextView tv_content_title;
    private TextView txt_introduction;
    private RecyclerView recyclerview;
    private ImageView backtrack;
    private List<VerificationItem> verificationlist = new ArrayList<>();
    private BankAdapter bankAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backtrack = findViewById(R.id.backtrack);
        backtrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_content_title = findViewById(R.id.tv_content_title);
        txt_introduction = findViewById(R.id.txt_introduction);
        recyclerview = findViewById(R.id.recyclerview);

        AddBankListInfo();
        bankAdapter = new BankAdapter(verificationlist,this);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(bankAdapter);

    }

    private void AddBankListInfo() {
        verificationlist.clear();
        VerificationItem verificationItem = new VerificationItem();
        verificationItem.setImg(R.drawable.card809);
        verificationItem.setTitle("凱基銀行");
        verificationlist.add(verificationItem);

        VerificationItem verificationItem1 = new VerificationItem();
        verificationItem1.setImg(R.drawable.card808);
        verificationItem1.setTitle("玉山銀行");
        verificationlist.add(verificationItem1);

        VerificationItem verificationItem2 = new VerificationItem();
        verificationItem2.setImg(R.drawable.card006);
        verificationItem2.setTitle("土地銀行");
        verificationlist.add(verificationItem2);

        VerificationItem verificationItem3 = new VerificationItem();
        verificationItem3.setImg(R.drawable.card007);
        verificationItem3.setTitle("第一銀行");
        verificationlist.add(verificationItem3);

        VerificationItem verificationItem4 = new VerificationItem();
        verificationItem4.setImg(R.drawable.card008);
        verificationItem4.setTitle("華南銀行");
        verificationlist.add(verificationItem4);

        VerificationItem verificationItem5 = new VerificationItem();
        verificationItem5.setImg(R.drawable.card009);
        verificationItem5.setTitle("彰化銀行");
        verificationlist.add(verificationItem5);
    }

    @Override
    public void onInformationClicked(String title,int img) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(Share.TITLE,title);
        intent.putExtra(Share.IMG,img);
        startActivity(intent);
    }
}
