package com.example.hackathon2016pda;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddParticipantsInfo extends AppCompatActivity {

    EditText COLUMN_NAME_USERNAME, COLUMN_NAME_PROJECTNAME;
    String user_name, user_projectname;
    Button ADD_PARTICIPANT;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_participants_info);
        COLUMN_NAME_USERNAME = (EditText) findViewById(R.id.user_name_edit_text);
        COLUMN_NAME_PROJECTNAME = (EditText) findViewById(R.id.project_name_edit_text);
        ADD_PARTICIPANT = (Button) findViewById(R.id.add_participant);

        ADD_PARTICIPANT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name = COLUMN_NAME_USERNAME.getText().toString();
                user_projectname = COLUMN_NAME_PROJECTNAME.getText().toString();

                DataBaseOperations db = new DataBaseOperations(ctx);
                db.addData(db, user_name, user_projectname);
                Toast.makeText(getBaseContext(), "Participant added", Toast.LENGTH_LONG).show();
                //finish();
            }
        });
    }

    public void navigateToViewParticipants(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ViewParticipants.class);
        startActivity(intent);
    }
}