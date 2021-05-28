package com.example.intro.firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.example.intro.R;
import com.example.intro.firebase.DetailAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class DetailList extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    protected ArrayList<Context> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaillist);
        database = FirebaseDatabase.getInstance();//파이어베이스 데이터베이스 연동
        recyclerView = findViewById(R.id.DetailContext);
        recyclerView.setHasFixedSize(true);//성능강화

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        final String[] key = new String[1];
        Button back,CancleBookMark,BookMark;
        CancleBookMark=(Button)findViewById(R.id.btnCancleMark);
        BookMark=(Button)findViewById(R.id.btnBookMark);
        back = (Button)findViewById(R.id.btnReturn);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                onBackPressed();
            }
        });

        Intent DetailIntent = getIntent();
        database = FirebaseDatabase.getInstance();
        /*databaseReference=database.getReference("data").child("recipe001").child("Context");*/
        databaseReference = database.getReference("data");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot Snapshot) {
                arrayList.clear();
                for (DataSnapshot snapshot : Snapshot.getChildren()) {
                    if(snapshot.child("title").getValue().equals(DetailIntent.getStringExtra("Title")))
                    {
                        key[0] =snapshot.getKey();
                        for(DataSnapshot k : snapshot.child("Context").getChildren())
                        {
                            Context context=k.getValue(Context.class);
                            arrayList.add(context);
                        }
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("MainActivity", String.valueOf(error.toException()));
            }
        });
        adapter = new DetailAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);
        CancleBookMark.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        databaseReference=database.getReference("data/"+key[0]);
                        databaseReference.child("isMarked").setValue("0");
                    }
                }
        );
        BookMark.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        databaseReference=database.getReference("data/"+key[0]);
                        databaseReference.child("isMarked").setValue("1");
                    }
                }
        );
    }
}
