package com.example.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnBmi;
    EditText TextCm, TextKg, TextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnclick();
        calculate();

    }

    public void btnclick(){
       TextCm=findViewById(R.id.TextCm);
       TextKg=findViewById(R.id.TextKg);
       btnBmi=findViewById(R.id.btnBmi);
       TextResult=findViewById(R.id.TextResult);


    }

    public void calculate(){

  btnBmi.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        float x=Float.parseFloat(TextCm.getText().toString())/100;
        float y=Float.parseFloat(TextKg.getText().toString());
        ActivityModel am=new ActivityModel(x, y);
        float z=am.getWeight()/(am.getHeight()*am.getHeight());
        TextResult.setText(""+z);


        if(z<18.5) {
            Toast.makeText(MainActivity.this, "Under Weight", Toast.LENGTH_LONG).show();

        }

        else if(z>=18.5 && z<=24.9) {
            Toast.makeText(MainActivity.this, "Normal Weight",Toast.LENGTH_LONG).show();

        }

        else if(z>=25 && z<=29.9) {
            Toast.makeText(MainActivity.this, "Over Weight",Toast.LENGTH_LONG).show();
        }

        else {
            Toast.makeText(MainActivity.this, "Obesity",Toast.LENGTH_LONG).show();
        }

    }
});
    }
}
