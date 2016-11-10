package com.example.hackathon2016pda;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DeleteParticipants extends AppCompatActivity {

    Button DELETE_PARTICIPANTS;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_participants);
        Toast.makeText(getBaseContext(), "Click to delete the participants data...", Toast.LENGTH_LONG).show();
        DELETE_PARTICIPANTS = (Button) findViewById(R.id.delete_participants);

        DELETE_PARTICIPANTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                DataBaseOperations dop = new DataBaseOperations(ctx);
                dop.deleteData(dop);
                Cursor CR = dop.viewData(dop);
                Toast.makeText(getBaseContext(), "Participants data deleted...", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void navigateToViewParticipants(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ViewParticipants.class);
        startActivity(intent);
    }
}