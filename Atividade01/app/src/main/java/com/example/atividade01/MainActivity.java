package com.example.atividade01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edt_name);
        edtCell = findViewById(R.id.edt_cell);
        ckbName = findViewById(R.id.ckb_name);
        ckbCell = findViewById(R.id.ckb_cell);
        ckbSms = findViewById(R.id.ckb_sms);
        txtResult = findViewById(R.id.txt_result);
        rdgMale = findViewById(R.id.rdg_male);
        rdgFemale = findViewById(R.id.rdg_female);

    }

    private EditText edtName;
    private EditText edtCell;
    private CheckBox ckbName;
    private CheckBox ckbCell;
    private CheckBox ckbSms;
    private TextView txtResult;
    private RadioButton rdgMale;
    private RadioButton rdgFemale;

    public void sendMesage(View v) {

        String name = edtName.getText().toString();
        String cell = edtCell.getText().toString();

        String mesage = "Nome: " + name + "\nTelefone: " + cell + "\nCheck: ";

        if(ckbSms.isChecked())
            mesage += ckbSms.getText().toString() + "\n";
        if(ckbCell.isChecked())
            mesage += ckbCell.getText().toString() + "\n";
        if(ckbName.isChecked())
            mesage += ckbName.getText().toString() + "\n";

        if(rdgMale.isChecked())
            mesage += "Sexo: " + rdgMale.getText().toString() + "\n";
        else if(rdgFemale.isChecked())
            mesage += "Sexo: " + rdgFemale.getText().toString() + "\n";

        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setMessage(mesage);
        alert.setNeutralButton("OK", null);
        alert.show();

        txtResult.setText("Resultado: " + mesage);
    }

    public void cleanInput(View v) {
        edtName.setText("");
        edtCell.setText("");
        ckbName.setChecked(false);
        ckbCell.setChecked(false);
        ckbSms.setChecked(false);
        rdgMale.setChecked(false);
        rdgFemale.setChecked(false);
        txtResult.setText("Resultado");
    }
}
