package com.panharithcoding.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {
    TextView textView2, luckyNumberTxt;
    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);
        textView2 = findViewById(R.id.textView2);
        luckyNumberTxt = findViewById(R.id.luckyNumberTxt);
        btnShare = findViewById(R.id.btnShare);

        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        int random_num = generateRandomNumber();
        luckyNumberTxt.setText("" + random_num);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName, random_num);
            }
        });
    }

    public int generateRandomNumber(){
        Random random = new Random();
        int upper_limit = 1000;
        int randomNumberGenerated = random.nextInt(upper_limit);
        return randomNumberGenerated;
    }
    public void shareData(String username ,int randomNum){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String number = String.valueOf(randomNum);
        i.putExtra(Intent.EXTRA_SUBJECT, username);
        i.putExtra(Intent.EXTRA_TEXT, randomNum);

        startActivity(Intent.createChooser(i, "choose a platform"));
    }
}