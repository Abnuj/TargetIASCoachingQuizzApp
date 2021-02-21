package com.abnuj.targetiascoachinggovermentjobpreperationapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abnuj.targetiascoachinggovermentjobpreperationapp.Adaptors.SubjectAdaptor;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.Models.SubjectModel;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.R;

import java.util.ArrayList;
import java.util.List;

public class SubjectFragment extends Fragment {


    public SubjectFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    RecyclerView recyclerView;
    SubjectAdaptor subjectAdaptor;
    int[] imagelist;String[] subjectname;
    List<SubjectModel> subjectModelList;int index = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_subject, container, false);
        recyclerView = v.findViewById(R.id.subject_recyclerview);
        subjectModelList = new ArrayList<>();
        imagelist = new int[]{R.raw.math, R.raw.reasoning, R.raw.english, R.raw.bio, R.raw.science, R.raw.hindi};
        subjectname = getResources().getStringArray(R.array.subject_name_list);
        for (int i=0;i<imagelist.length;i++)
        {
            subjectModelList.add(new SubjectModel(imagelist[i],subjectname[i]));
        }
        subjectAdaptor = new SubjectAdaptor(subjectModelList,container.getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(container.getContext(),2));
        recyclerView.setAdapter(subjectAdaptor);
        recyclerView.setHasFixedSize(true);
        return v;
    }
}