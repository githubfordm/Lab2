package org.androidtown.listviewmyactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.id.button2;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent passedIntent = getIntent();

        if(passedIntent!=null){

            String loginName = passedIntent.getStringExtra("name");
            String loginAge = passedIntent.getStringExtra("age");

            String text = "Student info : " + loginName + ", " + loginAge;
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();


        }

        Button button0 = (Button) findViewById(R.id.button0);

        button0.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                finish();
            }

        });



    }
}
