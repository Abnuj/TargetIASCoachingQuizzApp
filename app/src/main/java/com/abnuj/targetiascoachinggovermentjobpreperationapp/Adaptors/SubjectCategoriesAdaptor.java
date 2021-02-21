package com.abnuj.targetiascoachinggovermentjobpreperationapp.Adaptors;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abnuj.targetiascoachinggovermentjobpreperationapp.Activity.QuizActivity;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.Models.SubjectModel;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.R;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.Util.Constants;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.Util.Preferences;

import java.util.ArrayList;
import java.util.List;

public class SubjectCategoriesAdaptor extends RecyclerView.Adapter<SubjectCategoriesAdaptor.CategoriesViewholder> {

    List<SubjectModel> subject_Catogories_List = new ArrayList<>();
    Context context;

    public SubjectCategoriesAdaptor(List<SubjectModel> subject_Catogories_List, Context context) {
        this.subject_Catogories_List = subject_Catogories_List;
        this.context = context;
    }

    public SubjectCategoriesAdaptor() {
    }

    @NonNull
    @Override
    public SubjectCategoriesAdaptor.CategoriesViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_categories_layout, parent, false);

        return new CategoriesViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectCategoriesAdaptor.CategoriesViewholder holder, int position) {
        SubjectModel subjectModel = subject_Catogories_List.get(position);
        holder.subject_categories_img.setImageDrawable(context.getResources().getDrawable(subjectModel.getImage()));
        holder.subject_categories_name.setText(subjectModel.getSubjectName());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, QuizActivity.class);
                intent.putExtra(Constants.SELECTEDSUBCATEGORY,holder.subject_categories_name.getText().toString().trim());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subject_Catogories_List.size();
    }

    public class CategoriesViewholder extends RecyclerView.ViewHolder {
        ImageView subject_categories_img;
        TextView subject_categories_name;
        LinearLayout linearLayout;
        public CategoriesViewholder(@NonNull View itemView) {
            super(itemView);
            subject_categories_img = itemView.findViewById(R.id.subject_categories_image);
            subject_categories_name = itemView.findViewById(R.id.subject_categories_name);
            linearLayout = itemView.findViewById(R.id.subject_categories_cardview);
        }
    }
}
