package com.example.hackathon2016pda;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by umahaea on 11/9/16.
 */

public class DataBaseOperations extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TableData.TableInfo.TABLE_NAME + " (" +
                    TableData.TableInfo._ID + " INTEGER PRIMARY KEY," +
                    TableData.TableInfo.COLUMN_NAME_USERNAME + TEXT_TYPE + COMMA_SEP +
                    TableData.TableInfo.COLUMN_NAME_PROJECTNAME + TEXT_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TableData.TableInfo.TABLE_NAME;

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "user_db.db";

    public DataBaseOperations(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database operations", "Database created");
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        Log.d("Database operations", "Table created");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void addData(DataBaseOperations dop, String userName, String projectName) {
        SQLiteDatabase sq = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.COLUMN_NAME_USERNAME, userName);
        cv.put(TableData.TableInfo.COLUMN_NAME_PROJECTNAME, projectName);
        long val = sq.insert(TableData.TableInfo.TABLE_NAME, null, cv);
        Log.d("Database Operations", "One row inserted");
    }

    public Cursor viewData(DataBaseOperations dop) {
        SQLiteDatabase sq = dop.getReadableDatabase();
        String[] columns = {TableData.TableInfo.COLUMN_NAME_USERNAME, TableData.TableInfo.COLUMN_NAME_PROJECTNAME};
        Cursor CR = sq.query(TableData.TableInfo.TABLE_NAME, columns, null, null, null, null, null);
        return CR;
    }

    public void deleteData(DataBaseOperations dop) {
        SQLiteDatabase sq = dop.getReadableDatabase();
        String[] selection = {TableData.TableInfo.COLUMN_NAME_USERNAME, TableData.TableInfo.COLUMN_NAME_PROJECTNAME};
        sq.delete(TableData.TableInfo.TABLE_NAME, null, null);
    }
}