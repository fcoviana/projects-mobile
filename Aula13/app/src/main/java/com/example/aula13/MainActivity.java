package com.example.aula13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swtStatus = findViewById(R.id.swt_status);
        tggBtnStatus = findViewById(R.id.tggBtn_status);
        txtResult = findViewById(R.id.txt_result);
    }

    private Switch swtStatus;
    private ToggleButton tggBtnStatus;
    private TextView txtResult;

    public void send(View v) {
        if(swtStatus.isChecked() && tggBtnStatus.isChecked())
            txtResult.setText("Switch e ToogleButton ativados");
        else if (swtStatus.isChecked() && !tggBtnStatus.isChecked())
            txtResult.setText("Switch ativado e ToogleButton desativado");
        else if (!swtStatus.isChecked() && tggBtnStatus.isChecked())
            txtResult.setText("Switch desativado e ToogleButton ativado");
        else if(!swtStatus.isChecked() && !tggBtnStatus.isChecked())
            txtResult.setText("Switch e ToogleButton desativados");
    }
}
