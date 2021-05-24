package com.example.intro;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class BlankActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.blankactivity);

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

