package com.example.aula13;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
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

    public void showToast(View v) {
        Toast.makeText(
          getApplicationContext(), "Mensagem teste",
          Toast.LENGTH_SHORT).show();
    }

    public void showAlet(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setIcon(android.R.drawable.ic_delete);
        alert.setTitle("Titulo do alerta");
        alert.setMessage("Aqui você pode colocar a mensagem do alerta...");
        alert.setCancelable(false);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(
                        getApplicationContext(), "Ciclou OK",
                        Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(
                        getApplicationContext(), "Ciclou Cancelar",
                        Toast.LENGTH_SHORT).show();
            }
        });

        alert.create();
        alert.show();
    }
}
