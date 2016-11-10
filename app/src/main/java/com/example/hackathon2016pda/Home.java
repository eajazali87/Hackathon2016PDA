package com.example.hackathon2016pda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    ImageView PEARSON_LOGO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void navigateToAddParticipants(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, AddParticipantsInfo.class);
        startActivity(intent);
    }
}