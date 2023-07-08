package com.example.navigationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    DbHelper db;
    EditText name;
    TextView result;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        db = new DbHelper(this);
name=findViewById(R.id.Name);
btn=findViewById(R.id.button);

btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        int score=db.searchStudent(name.getText().toString());
        result.setText("Hello "+name.getText().toString()+" your score is "+score);

    }
});

    }
}