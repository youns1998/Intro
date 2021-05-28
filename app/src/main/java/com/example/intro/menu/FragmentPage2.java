package com.example.intro.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.intro.R;
// 최근기록 기능
public class FragmentPage2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_page_2, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}


//package com.example.intro.menu;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.KeyEvent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.AutoCompleteTextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.intro.R;
//import com.example.intro.firebase.RecentAdapter;
//import com.example.intro.firebase.RecentRecipe;
//import com.example.intro.firebase.RecipeList;
//import com.example.intro.firebase.TotalRecipe;
//import com.example.intro.sqlite.MyTable;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//
//// 즐겨찾기 기능
//public class FragmentPage2 extends Fragment {
//
//    private FirebaseDatabase database;
//    private DatabaseReference databaseReference;
//    private RecyclerView recyclerView;
//    private RecyclerView.Adapter adapter;
//    private RecyclerView.LayoutManager layoutManager;
//    private ArrayList<TotalRecipe> arrayList;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
////        View v = inflater.inflate(R.layout.activity_recipelist, container, false);
////
////
////        database= FirebaseDatabase.getInstance();//파이어베이스 데이터베이스 연동
////        recyclerView=v.findViewById(R.id.RecipeListView);
////
////        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
////        recyclerView.setLayoutManager(layoutManager);
////        arrayList = new ArrayList<>();
////
////        database= FirebaseDatabase.getInstance();
////        databaseReference=database.getReference("data");
////        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
////            @Override
////            public void onDataChange(@NonNull DataSnapshot Snapshot) {
////                arrayList.clear();
////                for(DataSnapshot snapshot : Snapshot.getChildren())
////                {
////                    TotalRecipe totalRecipe=snapshot.getValue(TotalRecipe.class);
////
////                    if (totalRecipe.getTitle().contains("당근")) {           //여기가 검색 거르는곳
////                        arrayList.add(totalRecipe);
////                    }
////                }
////                adapter.notifyDataSetChanged();
////            }
////
////            @Override
////            public void onCancelled(@NonNull DatabaseError error) {
////                Log.e("MainActivity", String.valueOf(error.toException()));
////
////            }
////        });
////        adapter = new RecentAdapter(arrayList,getActivity());
////        recyclerView.setAdapter(adapter);
////
////        return v;   //반드시 v를 리턴
////    }
////    @Override
////    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
////        super.onViewCreated(view, savedInstanceState);
////
////
//    }
//
//}