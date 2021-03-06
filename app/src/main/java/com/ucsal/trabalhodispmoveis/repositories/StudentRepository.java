package com.ucsal.trabalhodispmoveis.repositories;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import java.util.Scanner;

import static android.content.Context.MODE_PRIVATE;

public class StudentRepository {
    private static SQLiteDatabase db;
    private static Cursor cr;
    private static int count = 1; //primary key of database


    public static void loadDatabase(Context context) {
        db = context.openOrCreateDatabase("database", MODE_PRIVATE, null);
        /*Scanner scan = new Scanner(context.getResources().openRawResource(R.raw.database));
        String query = "";
        while (scan.hasNextLine()) {
            query += scan.nextLine() + "\n";
            if (query.trim().endsWith(";")) {
                db.execSQL(query);
                query = "";
            }
        }*/
        String query = "CREATE TABLE IF NOT EXISTS students(\n" +
                "student_id INT NOT NULL PRIMARY KEY,\n" +
                "name VARCHAR(30)DEFAULT NULL,\n" +
                "mobile VARCHAR (15) DEFAULT NULL\n" +
                ");";
        db.execSQL(query);

        count = (int) DatabaseUtils.queryNumEntries(db, "students");
    }

    //read everything there is in the database
    public static Cursor readDatabase() {
        String query1 = "SELECT * FROM students";
        cr = db.rawQuery(query1, null);
        return cr;
    }

    // add a new student's record to the database
    public static void addToDatabase(String name, String mobile) {
        count++;
        String sql = "INSERT INTO students VALUES (" + count + ",'" + name + "','" + mobile + "');";
        db.execSQL(sql);
    }

    // Search a student's record by name and delete it
    public static int deleteUsingName(String name) {
        String table = "students";
        String whereClause = "name=?";
        String[] whereArgs = new String[]{name};
        int deleted = db.delete(table, whereClause, whereArgs);
        return deleted;
    }

    // Search a student's record by name and updateit
    public static void updateUsingName(String oldName, String newName, String newMobile){
        String sql = "UPDATE students SET name = '"+newName+"', mobile = '"+newMobile+"' WHERE name = '"+oldName+"';";
        db.execSQL(sql);
    }
}
