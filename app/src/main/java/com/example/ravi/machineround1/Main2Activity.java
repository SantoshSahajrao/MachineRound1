package com.example.ravi.machineround1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ImageView chatImg;
    TextView memName,chattext;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        Data data = (Data) intent.getSerializableExtra("Re");

        ArrayList<Chat> chatlist = data.getChatArrayList();



        chatImg = findViewById(R.id.chatImg);
        linearLayout = findViewById(R.id.line1);

       // Picasso.with(this).load(data.getChatImg()).into(chatImg);
        for (int i=0;i<chatlist.size();i++) {

            Chat chat =chatlist.get(i);
            TextView textView = new TextView(Main2Activity.this);
            textView.setText(chat.memnane);

            TextView textView1 = new TextView(Main2Activity.this);
            textView1.setText(chat.chattext);

            linearLayout.addView(textView);
            linearLayout.addView(textView1);

        }

    }
}
