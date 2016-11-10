package com.example.hackathon2016pda;

import android.provider.BaseColumns;

/**
 * Created by umahaea on 11/9/16.
 */

public final class TableData {

    // To prevent someone from accidentally instantiating the TableData class,
    // make the constructor private.
    private TableData() {}

    /* Inner class that defines the table contents */
    public static class TableInfo implements BaseColumns {
        public static final String TABLE_NAME = "user_info";
        public static final String COLUMN_NAME_USERNAME = "user_name";
        public static final String COLUMN_NAME_PROJECTNAME  = "project_name";
    }
}