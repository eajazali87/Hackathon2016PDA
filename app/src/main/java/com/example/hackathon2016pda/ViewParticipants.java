package com.example.hackathon2016pda;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewParticipants extends AppCompatActivity {

    Button VIEW_PARTICIPANTS;
    ListView LIST_PARTICIPANTS_NAME;
    ListView LIST_PROJECT_NAME;
    TextView PARTICIPANTS_NAME;
    TextView PROJECT_NAME;
    Context ctx = this;
    List<String> participantNameList = new ArrayList<String>();
    List<String> projectNameList = new ArrayList<String>();
    Map<String, String> map = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_participants);
        Toast.makeText(getBaseContext(), "Click to view the participants data...", Toast.LENGTH_LONG).show();
        VIEW_PARTICIPANTS = (Button) findViewById(R.id.view_participants);
        LIST_PARTICIPANTS_NAME = (ListView) findViewById(R.id.display_participants_name_list);
        LIST_PROJECT_NAME = (ListView) findViewById(R.id.display_project_name_list);
        final TextView textView = new TextView(this);

        VIEW_PARTICIPANTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, project = " ";
                Intent intent = getIntent();
                DataBaseOperations dop = new DataBaseOperations(ctx);
                Cursor CR = dop.viewData(dop);
                PARTICIPANTS_NAME = (TextView) findViewById(R.id.view_user_name);
                PARTICIPANTS_NAME.setText("User");
                PROJECT_NAME = (TextView) findViewById(R.id.view_project_name);
                PROJECT_NAME.setText("Project");
                while (CR.moveToNext()) {
                    name = CR.getString(CR.getColumnIndex(TableData.TableInfo.COLUMN_NAME_USERNAME));
                    project = CR.getString(CR.getColumnIndex(TableData.TableInfo.COLUMN_NAME_PROJECTNAME));
                    participantNameList.add(name);
                    ArrayAdapter participantNameListAdapter = new ArrayAdapter<>(ViewParticipants.this, android.R.layout.simple_list_item_1, participantNameList);
                    LIST_PARTICIPANTS_NAME.setAdapter(participantNameListAdapter);
                    projectNameList.add(project);
                    ArrayAdapter projectNameListAdapter = new ArrayAdapter<>(ViewParticipants.this, android.R.layout.simple_list_item_1, projectNameList);
                    LIST_PROJECT_NAME.setAdapter(projectNameListAdapter);
                }
            }
        });
    }

    public void navigateToDeleteParticipants(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DeleteParticipants.class);
        startActivity(intent);
    }
}