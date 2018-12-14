package com.example.rahul.googlemapdragdrop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("lat", "2.12345");
        editor.putString("lon", "1.54321");

        editor.commit();

        btn_submit = findViewById(R.id.address);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);

            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        btn_submit.setText(sharedpreferences.getString("lon", "")+ "," + sharedpreferences.getString("lat", ""));

    }
}
