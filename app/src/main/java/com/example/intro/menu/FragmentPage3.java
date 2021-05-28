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


import com.example.intro.firebase.BookMarkListAdapter;
import com.example.intro.R;

import com.example.intro.firebase.RecipeList;
import com.example.intro.firebase.TotalRecipe;
import com.example.intro.firebase.BookMarkListAdapter;
import com.example.intro.firebase.TotalRecipe;
import com.example.intro.sqlite.MyTable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

// 즐겨찾기 기능
public class FragmentPage3 extends Fragment {
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

        MyTable mMyTable = new MyTable(getActivity());
        mMyTable.selectAll();
        System.out.println(mMyTable.count());
        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference("data");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot Snapshot) {
                arrayList.clear();
                for(DataSnapshot snapshot : Snapshot.getChildren())
                {
                    TotalRecipe totalRecipe=snapshot.getValue(TotalRecipe.class);

                    for(int i = 0 ; i < mMyTable.count() ; i++){
                        //DB의 개수 만큼 반복, DB의 제목으로 검색 후 레시피 목록 출력
                        if (totalRecipe.getTitle().equals(mMyTable.titlematch(i))) {           //여기가 검색 거르는곳
                            arrayList.add(totalRecipe);
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
        setHasOptionsMenu(true);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}