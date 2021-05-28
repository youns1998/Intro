package com.example.intro.sqlite;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class MyTable extends MyDBHelper {
    private SQLiteDatabase db;

    public MyTable(Context context) {
        super(context);
        // 데이터를 쓰고 읽기 위해서 db 열기
        db = getWritableDatabase();
    }

    public void insert(int column1, String column2) {
        // 데이터 쓰기
        db.execSQL("INSERT INTO mytable VALUES('" + column1 + "','" + column2 + "')");
    }


    public void delete(int column1) {
        // 조건에 일치하는 행을 삭제
        db.execSQL("DELETE FROM mytable WHERE column1=" + column1);
    }

    public void selectAll(){
        String sql = "select * from mytable";
        Cursor results = db.rawQuery(sql, null);

        results.moveToFirst();

        while(!results.isAfterLast()){
            int id = results.getInt(0);
            String voca = results.getString(1);
            System.out.println(voca);
            results.moveToNext();
        }
        results.close();
    }

    public int count() {
        int cnt = 0;
        Cursor cursor = db.rawQuery("select * from MyTable", null);
        cnt = cursor.getCount();
        return cnt;
    }

    public String titlematch(int cnt) {
        Cursor cursor = db.rawQuery("select column2 from MyTable where id=1", null);
        return cursor.toString();
    }




}



