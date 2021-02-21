package com.abnuj.targetiascoachinggovermentjobpreperationapp.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abnuj.targetiascoachinggovermentjobpreperationapp.Adaptors.SubjectCategoriesAdaptor;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.Models.SubjectModel;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.R;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.Util.Preferences;

import java.util.ArrayList;
import java.util.List;

public class SubjectCategoriesFragment extends Fragment {

    public SubjectCategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    String selectedSubjectname;
    String[] CategoriesName;
    Preferences preferences;
    RecyclerView subject_categories_recyclerview;
    List<SubjectModel> modelList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_subject_categories, container, false);
        Bundle bundle = new Bundle();
        CategoriesName = new String[]{};
        modelList = new ArrayList<>();
        preferences = new Preferences(container.getContext());
        subject_categories_recyclerview = v.findViewById(R.id.subject_categories_recyclerview);
        SubjectModel subjectModel = preferences.getSubjectData();
        int image = subjectModel.getImage();
        selectedSubjectname = subjectModel.getSubjectName();
        Log.d("TAG", "selected subject name : " + selectedSubjectname);
        Log.d("TAG", "Image : " + image);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(selectedSubjectname);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        subjectCategoriesAttach(selectedSubjectname);

        for (String s : CategoriesName) {
            modelList.add(new SubjectModel(image, s));
            Log.d("TAG", "value of s : " + s);
        }
        if (modelList != null) {

            subject_categories_recyclerview.setLayoutManager(new LinearLayoutManager(container.getContext()));
            subject_categories_recyclerview.setHasFixedSize(true);
            subject_categories_recyclerview.setAdapter(new SubjectCategoriesAdaptor(modelList, v.getContext()));

        } else {
            subjectCategoriesAttach(selectedSubjectname);
        }
        return v;
    }

    private void subjectCategoriesAttach(String selectedSubjectname) {
//         <item>Math</item>
//        <item>Reasoning</item>
//        <item>English</item>
//        <item>Bio</item>
//        <item>Science</item>
//        <item>हिंदी</item>
        switch (selectedSubjectname) {
            case "Math":
                CategoriesName = getResources().getStringArray(R.array.MathCategories);
                break;
            case "Reasoning":
                CategoriesName = getResources().getStringArray(R.array.ReasoningCategories);
                break;
            case "English":
                CategoriesName = getResources().getStringArray(R.array.EnglishCategories);
                break;
            case "Bio":
                CategoriesName = getResources().getStringArray(R.array.BioCategories);
                break;
            case "Science":
                CategoriesName = getResources().getStringArray(R.array.ScienceCategories);
                break;
            case "हिंदी":
                CategoriesName = getResources().getStringArray(R.array.HindiCategories);
                break;
        }
    }
}