package com.example.meteo;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView celcius, display1, symb, Title, statuts, Fahrenheit, Kelvin;
    ImageView cal;
    View back;
    double temp = 0;
    LinearLayout resetV;


    double sh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Title = findViewById(R.id.titles);
        symb = findViewById(R.id.symbol1);
        display1 = findViewById(R.id.degree);
        Fahrenheit = findViewById(R.id.fahr);
        Kelvin = findViewById(R.id.kelv);
        statuts = findViewById(R.id.statut);



        Fahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                celcius = findViewById(R.id.degree);
                String degrees = celcius.getText().toString();

               if(!degrees.isEmpty()){
                   double celcius = Double.parseDouble(degrees);
                   double sh = (celcius * (9.0/5.0)) + 32;
                   double temp = celcius;
                    display1.setText(String.valueOf(sh));
                    Title.setText(String.valueOf(sh) + "°F");
                    Toast.makeText(MainActivity.this, "Converted in Fahrenheit 😁", Toast.LENGTH_SHORT).show();
                    statuts.setVisibility(View.VISIBLE);
                    statuts.setText("Fahrenheit");
                    display1.setText(String.valueOf(celcius));

               }
               else {
                   Title.setText("Enter a valid number");
               }
            }
        });
        Kelvin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                celcius = findViewById(R.id.degree);
                String degrees = celcius.getText().toString();
                if (!degrees.isEmpty()){
                    double celcius = Double.parseDouble(degrees);
                    double sh = celcius + 275.13;
                    display1.setText(String.valueOf(sh));
                    Title.setText(String.valueOf(sh) + "K");
                    Toast.makeText(MainActivity.this, "Converted in Kelvin 😁", Toast.LENGTH_SHORT).show();
                    statuts.setVisibility(View.VISIBLE);
                    statuts.setText("Kelvin");
                    display1.setText(String.valueOf(celcius));
                }
                else {
                    Title.setText("Enter a valid number");
                }
            }
        });


        cal = findViewById(R.id.calc);
        back = findViewById(R.id.voir);
        final Handler handler = new Handler();
        final int[] count = {0};
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                count[0]++;
                handler.postDelayed(this, 1000);
                if (count[0] == 3){
                    cal.setVisibility(View.GONE);
                    back.setVisibility(View.GONE);
                    handler.removeCallbacks(this);
                }
            }
        };
        handler.post(runnable);

        resetV = findViewById(R.id.resets);
        resetV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display1.setText("");
                Title.setText("");
                statuts.setVisibility(View.GONE);
            }
        });

    }

}