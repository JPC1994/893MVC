package com.example.rasaselvan.ruebanmvc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Initialize extends AppCompatActivity {
    Button btnGenVEqu, btnGenPEqu,btnGenCross,btnGenDot;
    TextView txtViewDisplay;
    RadioButton rdn3Space,rdn2Space;
    EditText numXP1, numYP1, numZP1, numXP2, numYP2, numZP2;
    int arnP1[], arnP2[], arnDispV[], i;
    @Override
    //Android Structure: https://www.youtube.com/watch?v=rREw23TgHJ8&list=PLvnXjBkwUhDEfjK1pqT8LsGWPyFuzO5Zu
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialize);
        super.setTitle("Unit 2 Algebraic Vectors");
        btnGenVEqu = (Button) (findViewById(R.id.btnGenVEqu));
        btnGenPEqu = (Button) (findViewById(R.id.btnGenPEqu));
        btnGenCross = (Button) (findViewById(R.id.btnCross));
        btnGenDot = (Button) (findViewById(R.id.btnDot));
        numXP1=(EditText)(findViewById(R.id.editNumXP1));
        numYP1=(EditText)(findViewById(R.id.editNumYP1));
        numZP1=(EditText)(findViewById(R.id.editNumZP1));
        numXP2=(EditText)(findViewById(R.id.editNumXP2));
        numYP2=(EditText)(findViewById(R.id.editNumYP2));
        numZP2=(EditText)(findViewById(R.id.editNumZP2));
        txtViewDisplay = (TextView) (findViewById(R.id.TextViewDisplay));
        rdn3Space = (RadioButton) (findViewById(R.id.rdnBtn3Space));
        rdn2Space = (RadioButton) (findViewById(R.id.rdnBtn2Space));
        if (rdn2Space.isChecked()) {
            rdn3Space.setChecked(false);
            arnDispV = new int[2];
            arnP1 = new int[2];
            arnP2 = new int[2];
        }
        rdn3Space.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rdn2Space.setChecked(false);
                arnDispV= new int[3];
                arnP1= new int[3];
                arnP2=new int[3];
            }
        });
        rdn2Space.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rdn3Space.setChecked(false);
                arnDispV= new int[2];
                arnP1= new int[2];
                arnP2=new int[2];
            }
        });
        btnGenVEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i;
                GetCoordinates();
                if (rdn2Space.isChecked()) {
                    for(i=0;i<2;i++) {
                        arnDispV[i] = arnP2[i] - arnP1[i];
                    }
                    txtViewDisplay.setText(String.format("r=(%d,%d) + t(%d,%d)", arnP1[0], arnP1[1], arnDispV[0], arnDispV[1]));
                }
                else if(rdn3Space.isChecked()){
                    for(i=0;i<3;i++) {
                        arnDispV[i] = arnP2[i] - arnP1[i];
                    }
                    txtViewDisplay.setText(String.format("r=(%d,%d,%d) + t(%d,%d,%d)", arnP1[0], arnP1[1], arnP1[2], arnDispV[0], arnDispV[1], arnDispV[2]));
                }
            }
        });
        btnGenCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int arnCross[];
                GetCoordinates();
                if (rdn3Space.isChecked()) {
                    arnCross = new int[3];
                    arnCross[0] = (arnP1[1] * arnP2[2]) - (arnP1[2] * arnP2[1]);
                    arnCross[1] = (arnP1[2] * arnP2[0]) - (arnP1[0] * arnP2[2]);
                    arnCross[2] = (arnP1[0] * arnP2[1]) - (arnP1[1] * arnP2[0]);
                    txtViewDisplay.setText(String.format("r=(%d,%d,%d)", arnCross[0], arnCross[1], arnCross[2]));
                } else if (rdn2Space.isChecked()) {
                    //Toast Feature: https://github.com/dinnatruong/SimpleMVC/blob/master/app/src/main/java/com/example/dinna/simplemvc/Calendar.java
                    Toast.makeText(getApplicationContext(), "There is no Cross Product for lines in 2-Space",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnGenDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nDotProd=0;
                GetCoordinates();
                if(rdn3Space.isChecked()){
                    for(i=0;i<3;i++){
                        nDotProd+=(arnP1[i]*arnP2[i]);
                    }
                }
                else if(rdn2Space.isChecked()){
                    for(i=0;i<2;i++){
                        nDotProd+=(arnP1[i]*arnP2[i]);
                    }
                }
                txtViewDisplay.setText(String.format("Dot Product = %d", nDotProd));
            }
        });
    }

    public void GetCoordinates() {
        arnP1[0] = Integer.parseInt(String.valueOf(numXP1.getText()));
        arnP1[1] = Integer.parseInt(String.valueOf(numYP1.getText()));
        arnP2[0] = Integer.parseInt(String.valueOf(numXP2.getText()));
        arnP2[1] = Integer.parseInt(String.valueOf(numYP2.getText()));
        if (rdn3Space.isChecked()) {
            arnP2[2] = Integer.parseInt(String.valueOf(numZP2.getText()));
            arnP2[2] = Integer.parseInt(String.valueOf(numZP2.getText()));
        }
    }
    }


