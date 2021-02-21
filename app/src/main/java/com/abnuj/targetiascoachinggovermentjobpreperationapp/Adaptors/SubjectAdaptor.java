package com.abnuj.targetiascoachinggovermentjobpreperationapp.Adaptors;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.abnuj.targetiascoachinggovermentjobpreperationapp.Fragments.SubjectCategoriesFragment;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.Models.SubjectModel;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.R;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.Util.Constants;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.Util.Preferences;

import java.util.ArrayList;
import java.util.List;

public class SubjectAdaptor extends RecyclerView.Adapter<SubjectAdaptor.SubjectViewholder> {
    List<SubjectModel> subjectModels = new ArrayList<>();
    Context context;
    AppCompatActivity appCompatActivity;
Preferences preferences;
    public SubjectAdaptor() {
    }

    public SubjectAdaptor(List<SubjectModel> subjectModels, Context context) {
        this.subjectModels = subjectModels;
        this.context = context;
    }

    @NonNull
    @Override
    public SubjectViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_recycler_item, parent, false);
        return new SubjectViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewholder holder, int position) {
        SubjectModel s = subjectModels.get(position);
        Log.d("TAG", "Image name : "+s.getImage());
        holder.subjectimg.setImageDrawable(context.getResources().getDrawable(s.getImage()));
        holder.subjectname.setText(s.getSubjectName());
        Bundle bundle = new Bundle();
        holder.subject_recycler_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appCompatActivity = (AppCompatActivity) v.getContext();
                preferences = new Preferences(v.getContext());
                appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_fragment_container, new SubjectCategoriesFragment()).commit();
                bundle.putString(Constants.SUBJECT_NAME,holder.subjectname.getText().toString().trim());
                preferences.writeSharedPreference(holder.subjectname.getText().toString().trim(),s.getImage());
//                bundle.putInt(Constants.SUBJECT_IMAGE,s.getImage());
//                Log.d("TAG", "Subject name : "+bundle.getInt(Constants.SUBJECT_IMAGE));
            }
        });
    }

    @Override
    public int getItemCount() {
        return subjectModels.size();
    }

    public class SubjectViewholder extends RecyclerView.ViewHolder {
        ImageView subjectimg;
        TextView subjectname;
        CardView subject_recycler_cardview;

        public SubjectViewholder(@NonNull View itemView) {
            super(itemView);
            subjectimg = itemView.findViewById(R.id.subject_image);
            subjectname = itemView.findViewById(R.id.subjectname);
            subject_recycler_cardview = itemView.findViewById(R.id.subject_recycler_cardview);
        }
    }
}
