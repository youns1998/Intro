package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class testActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent data = getIntent();
        ArrayList<String> tagdata = data.getStringArrayListExtra("taglist");
        System.out.println(tagdata);

        Button back;
        back = (Button)findViewById(R.id.btnReturn);

        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                onBackPressed();;
                System.out.println("hi");
            }
        });

    }
}