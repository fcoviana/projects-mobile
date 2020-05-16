package com.example.aula15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtResult = findViewById(R.id.txt_curso);

        Bundle data = getIntent().getExtras();

        String curse = data.getString("curse");
        String name = data.getString("name");
        String semester = data.getString("semester");
        txtResult.setText("Aluno: " + name + "\n Curso: "+ curse + "\n Semestre: " + semester);
    }

    TextView txtResult;


}
