package com.example.convertisseur_devise;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    double mnt;
    TextView result;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Adding items to list "from"
        Spinner spinnerfr = findViewById(R.id.from);
        ArrayList<String> from = new ArrayList<>();
        from.add("TND");
        from.add("EURO");
        from.add("USD");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, from);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerfr.setAdapter(arrayAdapter);

        //Adding items to list "to"
        Spinner spinnerto = findViewById(R.id.to);
        ArrayList<String> to = new ArrayList<>();
        to.add("EURO");
        to.add("TND");
        to.add("USD");
        ArrayAdapter<String> arrayAdapterto = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, to);
        arrayAdapterto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerto.setAdapter(arrayAdapterto);
        final EditText vl = findViewById(R.id.value);
        final Button btnConvert = findViewById(R.id.button);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinnerfr = findViewById(R.id.from);
                Spinner spinnerto = findViewById(R.id.to);
                result = findViewById(R.id.result);
                //get value of editText "montant"


                String to = spinnerto.getSelectedItem().toString();
                String from = spinnerfr.getSelectedItem().toString();
                if(!vl.getText().toString().isEmpty()) {
                   String vl1 =vl.getText().toString();
                    mnt = Double.parseDouble(vl1);
                    switch (from) {
                        case "TND":
                            switch (to) {
                                case "TND": {
                                    double sum = mnt;
                                    String r = "votre montant TND est : " + sum;
                                    result.setText(r);
                                    break;
                                }
                                case "EURO": {
                                    double sum = mnt / 3.2;
                                    String r = "votre montant TND en Euro  est : " + sum;
                                    result.setText(r);
                                    break;
                                }
                                case "USD": {
                                    double sum = mnt / 3;
                                    String r = "votre montant TND en USD est : " + sum;
                                    result.setText(r);

                                    break;
                                }
                            }

                            break;
                        case "EURO":
                            switch (to) {
                                case "TND": {
                                    double sum = mnt * 3;
                                    String r = "votre montant EURO en TND est : " + sum;
                                    result.setText(r);
                                    break;
                                }
                                case "EURO": {
                                    double sum = mnt;
                                    String r = "votre montant de TND en Euro  est : " + sum;
                                    result.setText(r);
                                    break;
                                }
                                case "USD": {
                                    double sum = mnt * 1;
                                    String r = "votre montant de TND en USD est : " + sum;
                                    result.setText(r);

                                    break;
                                }
                            }

                            break;
                        case "USD":
                            switch (to) {
                                case "TND": {
                                    double sum = mnt * 3.2;
                                    String r = "votre montant USD en dinars est : " + sum;
                                    result.setText(r);
                                    break;
                                }
                                case "EURO": {
                                    double sum = mnt * 1;
                                    String r = "votre montant USD en Euro  est : " + sum;
                                    result.setText(r);
                                    break;
                                }
                                case "USD": {
                                    double sum = mnt;
                                    String r = "votre montant en USD est : " + sum;
                                    result.setText(r);
                                    break;
                                }
                            }
                            break;
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Please Enter a Value to Convert..", Toast.LENGTH_SHORT).show();

                }
            }
        });
        }

    }