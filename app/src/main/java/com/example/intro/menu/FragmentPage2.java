package com.example.intro.menu;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.intro.BookMarkListAdapter;
import com.example.intro.R;

import com.example.intro.TotalRecipe;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

// 즐겨찾기 기능
public class FragmentPage2 extends Fragment {
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<TotalRecipe> arrayList=new ArrayList<>();
    Context ct;
    public interface Callback{
        void success(TotalRecipe data);
        void fail(String errorMessage);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        database= FirebaseDatabase.getInstance();//파이어베이스 데이터베이스 연동
        ViewGroup v = (ViewGroup)inflater.inflate(R.layout.activity_bookmark,container,false);
        ct=container.getContext();
        recyclerView=(RecyclerView)v.findViewById(R.id.RecipeListView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference("data");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot Snapshot) {
                arrayList.clear();
                for(DataSnapshot snapshot : Snapshot.getChildren())
                {
                        if(snapshot.child("isMarked").getValue()!=null && snapshot.child("isMarked").getValue().equals("1")) {
                            TotalRecipe totalRecipe=snapshot.getValue(TotalRecipe.class);
                            arrayList.add(totalRecipe);
                        }
                }
                adapter = new BookMarkListAdapter(arrayList,getActivity());
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("MainActivity", String.valueOf(error.toException()));
            }
        });
        setHasOptionsMenu(true);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}