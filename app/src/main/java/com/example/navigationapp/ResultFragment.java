package com.example.navigationapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.navigationapp.DbHelper;
import com.example.navigationapp.R;


public class ResultFragment extends Fragment {
    DbHelper db;
    EditText name;
    TextView result;
    Button btn;
    public ResultFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.result_layout, container, false);
        db = new DbHelper(requireContext());
        name = view.findViewById(R.id.Name);
        btn = view.findViewById(R.id.button);
        result = view.findViewById(R.id.textView); // Initialize the result TextView
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int score = db.searchStudent(name.getText().toString());
                result.setText("Hello " + name.getText().toString() + " your score is " + score);
            }
        });

        return view;
    }
}
