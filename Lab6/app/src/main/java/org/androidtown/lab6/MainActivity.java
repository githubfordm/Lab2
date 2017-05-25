package org.androidtown.lab6;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    File sdCard = Environment.getExternalStorageDirectory();
    File directory = new File(sdCard.getAbsolutePath() + "/Myfiles");
    File file;

    EditText txtData;
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    String name = "mysdfile.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        directory.mkdir();

        file = new File(directory, name);

        txtData = (EditText) findViewById(R.id.txtData);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String getData = txtData.getText().toString();

                writeFiles(getData);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                txtData.setText("");

            }
        });


        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                readFiles();

            }
        });


        button4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                finish();
            }
        });

    }

    public void writeFiles(String data){

        try {
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            osw.write(data);
            osw.close();
            Toast.makeText(getApplicationContext(), "Done writing SD " + name, Toast.LENGTH_LONG).show();
        }catch(Throwable t){
            Toast.makeText(getApplicationContext(), "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }


    }

    public void readFiles() {

        String bringData = "";

        try {
            FileInputStream fIn = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fIn);
            BufferedReader reader = new BufferedReader(isr);

            while ((bringData = reader.readLine()) != null) {
                txtData.append(bringData + "\n");
            }
            isr.close();
            reader.close();
            Toast.makeText(getApplicationContext(), "Done Reading SD 'mysdfile.txt'", Toast.LENGTH_LONG).show();
        } catch (Throwable t) {
            Toast.makeText(getApplicationContext(), "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }

    }


}
