package com.zzangnet.IvrTest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

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

        stateButton = (Button)this.findViewById(R.id.stateButton);
        stateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.changeState();
            }
        });

        clearButton = (Button)this.findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                controller.clear();
            }
        });

        spectrumView = new SpectrumView();
        spectrumView.setImageView((ImageView) this.findViewById(R.id.spectrum));

        recognizeredEditText = (EditText)this.findViewById(R.id.recognizeredText);
        recognizeredEditText.setFocusable(false);

        numKeyboard = new NumericKeyboard();
        numKeyboard.add('0', (Button)findViewById(R.id.button0));
        numKeyboard.add('1', (Button)findViewById(R.id.button1));
        numKeyboard.add('2', (Button)findViewById(R.id.button2));
        numKeyboard.add('3', (Button)findViewById(R.id.button3));
        numKeyboard.add('4', (Button)findViewById(R.id.button4));
        numKeyboard.add('5', (Button)findViewById(R.id.button5));
        numKeyboard.add('6', (Button)findViewById(R.id.button6));
        numKeyboard.add('7', (Button)findViewById(R.id.button7));
        numKeyboard.add('8', (Button)findViewById(R.id.button8));
        numKeyboard.add('9', (Button)findViewById(R.id.button9));
        numKeyboard.add('0', (Button)findViewById(R.id.button0));
        numKeyboard.add('#', (Button)findViewById(R.id.buttonHash));
        numKeyboard.add('*', (Button)findViewById(R.id.buttonAsterisk));

        setEnabled(false);

        recognizeredText = "";

        history = new History(this);
        history.load();

    }

    public void start()
    {
        stateButton.setText(R.string.stop);
        setEnabled(true);
    }

    public void stop()
    {
        history.add(recognizeredText);

        stateButton.setText(R.string.start);
        setEnabled(false);
    }





}