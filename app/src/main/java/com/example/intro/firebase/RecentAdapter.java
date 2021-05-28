//package com.example.intro.firebase;
//
//import android.content.Intent;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.example.intro.R;
//import com.example.intro.menu.FragmentPage1;
//import com.example.intro.sqlite.MyTable;
//import com.example.intro.sqlite.MyTableList;
//
//import java.util.ArrayList;
//
//public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.CustomViewHolder> {
//
//    private ArrayList<TotalRecipe> arrayList;
//    private FragmentPage1 context;//이부분 이상함 oncreate에서 this면 context로 넘어가야하는데 context가 아닌 MainActivity반환
//
//
//
//    public RecentAdapter(ArrayList<TotalRecipe> arrayList, FragmentPage1 context) {
//        this.arrayList = arrayList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recipe,parent,false);
//        CustomViewHolder holder = new CustomViewHolder(view);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
//        Glide.with(holder.itemView)
//                .load(arrayList.get(position).getImage())
//                .override(40,40)
//                .into(holder.iv_Image);
//        holder.tv_Context.setText(arrayList.get(position).getTitle());
//        holder.tv_Ingredient.setText(arrayList.get(position).getIngredient());
//    }
//
//    @Override
//    public int getItemCount() {
//        return (arrayList!=null ? arrayList.size():0);
//    }
//
//    public class CustomViewHolder extends RecyclerView.ViewHolder {
//        ImageView iv_Image;
//        TextView tv_Context;
//        TextView tv_Ingredient;
//
//        public CustomViewHolder(@NonNull View itemView) {
//            super(itemView);
//            this.iv_Image=itemView.findViewById(R.id.iv_image);
//            this.tv_Context=itemView.findViewById(R.id.Context);
//            this.tv_Ingredient=itemView.findViewById(R.id.Ingredient);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int pos = getAdapterPosition() ;
//                    if (pos != RecyclerView.NO_POSITION) {
//                        Intent intent = new Intent(, DetailList.class);
//
//                        intent.putExtra("Title",arrayList.get(pos).getTitle());
////                        System.out.println("여기가 음식 방문시점");
//
//                        context.startActivity(intent);
//                        // TODO : use item.
//                    }
//                }
//            });
//        }
//    }
//}
