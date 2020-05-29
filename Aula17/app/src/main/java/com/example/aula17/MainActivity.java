package com.example.aula17;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase fistDatabase = openOrCreateDatabase("project", MODE_PRIVATE, null);
            fistDatabase.execSQL("CREATE TABLE IF NOT EXISTS " +
                    "people(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age INT(3))");
//            fistDatabase.execSQL("CREATE TABLE IF NOT EXISTS people(name VARCHAR, age INT(3))");
//            fistDatabase.execSQL("INSERT INTO people(name, age) VALUES ('Chicao', 20)");
//            fistDatabase.execSQL("INSERT INTO people(name, age) VALUES ('Pedrao', 31)");
            fistDatabase.execSQL("UPDATE people SET name = 'Ze Pedro', age = 43 WHERE name = 'Pedrao'");


            String sql = "SELECT name, age FROM people";

            Cursor cursor = fistDatabase.rawQuery(sql, null);

            cursor.moveToFirst();
            while(cursor != null) {

                int indexName = cursor.getColumnIndex("name");
                int indexAge = cursor.getColumnIndex("age");
                int indexId = cursor.getColumnIndex("id");

                String name = cursor.getString(indexName);
                String age = cursor.getString(indexAge);
                String id = cursor.getString(indexId);

                Log.i("Retorno - ID: ",  id + ". NOME: " + name + ". Idade: " + age);

                cursor.moveToNext();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
