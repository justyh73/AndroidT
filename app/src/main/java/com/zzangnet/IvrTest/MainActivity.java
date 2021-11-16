package com.zzangnet.IvrTest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import pl.polidea.apphance.Apphance;

public class MainActivity extends AppCompatActivity {

    private Button stateButton;
    private Button clearButton;
    private EditText recognizeredEditText;
    private SpectrumView spectrumView;
    private NumericKeyboard numKeyboard;

    Controller controller;

    private String recognizeredText;

    History history;

    public static final String APP_KEY = "806785c1fb7aed8a867039282bc21993eedbc4e4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Apphance.start(this, APP_KEY);

        setContentView(R.layout.activity_main);

        controller = new Controller(this);

    }
}