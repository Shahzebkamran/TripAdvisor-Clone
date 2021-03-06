package com.example.tripadvisor;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import android.widget.Toast;

public class DbHelper extends SQLiteOpenHelper{
    private Context context;
    private static final String DATABASE_NAME = "TripAdvisor.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_users";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "_name";
    private static final String COLUMN_EMAIL = "_email";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, " + COLUMN_EMAIL + " TEXT);";
        DB.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    void addUsers(String Name,String Email){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME,Name);
        cv.put(COLUMN_EMAIL,Email);
        long result = db.insert(TABLE_NAME,null,cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db!= null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
}
