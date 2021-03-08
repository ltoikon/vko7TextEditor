package com.example.texteditor7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    Context context = null;
    String fileName;
    TextView inputFileName;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        text = (TextView) findViewById(R.id.editTextField);
        inputFileName = (TextView) findViewById(R.id.editFilename);
    }


    public void readFile(View v){
        fileName = inputFileName.getText().toString();
        try {
            InputStream ins = context.openFileInput(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(ins));

            String bufferString = " ";
            while ((bufferString=br.readLine()) != null){
                text.setText(bufferString);
            }
            ins.close();
        } catch (IOException e){
            Log.e("IOException", "io exception");
        }

    }

    public void  writeFile(View v) throws IOException {
        fileName = inputFileName.getText().toString();
        OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_PRIVATE));
        String s = text.getText().toString();
        ows.write(s);

        ows.close();

        }
    }
