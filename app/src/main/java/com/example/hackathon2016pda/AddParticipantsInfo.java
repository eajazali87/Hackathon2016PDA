package com.example.hackathon2016pda;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.hackathon2016pda.R.layout.activity_add_participants_info;

public class AddParticipantsInfo extends AppCompatActivity {

    EditText COLUMN_NAME_USERNAME, COLUMN_NAME_PROJECTNAME;
    String user_name, user_projectname;
    Button ADD_PARTICIPANT;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_add_participants_info);
        COLUMN_NAME_USERNAME = (EditText) findViewById(R.id.user_name_edit_text);
        COLUMN_NAME_PROJECTNAME = (EditText) findViewById(R.id.project_name_edit_text);
        ADD_PARTICIPANT = (Button) findViewById(R.id.add_participant);
        final Handler handler = new Handler();

        ADD_PARTICIPANT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name = COLUMN_NAME_USERNAME.getText().toString();
                user_projectname = COLUMN_NAME_PROJECTNAME.getText().toString();

                LinearLayout layout = new LinearLayout(getBaseContext());
                TextView tv = new TextView(getBaseContext());
                layout.addView(tv);
                tv.setTextColor(Color.RED);

                if (user_name.isEmpty() || user_projectname.isEmpty()) {
                    final Toast toast = Toast.makeText(getBaseContext(), "Participant or Project Name is empty", Toast.LENGTH_LONG);
                    View view = toast.getView();
                    view.setBackgroundColor(Color.RED);
                    toast.setView(view);
                    toast.show();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);

                } else {
                    DataBaseOperations db = new DataBaseOperations(ctx);
                    db.addData(db, user_name, user_projectname);
                    final Toast toast = Toast.makeText(getBaseContext(), "Participant added", Toast.LENGTH_LONG);
                    toast.show();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
                    COLUMN_NAME_USERNAME.setText("");
                    COLUMN_NAME_PROJECTNAME.setText("");
                }
                //finish();
            }
        });
    }

    public void navigateToViewParticipants(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ViewParticipants.class);
        startActivity(intent);
    }

    public void navigateToHome(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}