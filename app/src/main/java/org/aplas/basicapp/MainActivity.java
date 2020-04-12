package org.aplas.basicapp;

//import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.Image;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Distance dist = new Distance();
    private Weight weight = new Weight();
    private Temperature temp = new Temperature();
    private Button convertBtn;
    private EditText inputTxt;
    private EditText outputTxt;
    private Spinner unitOri;
    private Spinner unitConv;
    private RadioGroup unitType;
    private CheckBox roundBox;
    private CheckBox formBox;
    private ImageView imgView;
    private AlertDialog startDialog;
    private ImageView imgFormula;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertBtn = (Button)findViewById(R.id.convertButton);
        inputTxt = (EditText) findViewById(R.id.inputText);
        outputTxt = (EditText) findViewById(R.id.outputText);
        unitOri = (Spinner) findViewById(R.id.oriList);
        unitConv = (Spinner) findViewById(R.id.convList);
        unitType = (RadioGroup) findViewById(R.id.radioGroup);
        roundBox = (CheckBox) findViewById(R.id.chkRounded);
        formBox = (CheckBox) findViewById(R.id.chkFormula);
        imgView = (ImageView) findViewById(R.id.img);
        imgFormula = (ImageView) findViewById(R.id.imgFormula);

        unitType.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton rbTemp = findViewById(R.id.rbTemp);
                        RadioButton rbDist = findViewById(R.id.rbDist);
                        RadioButton rbWeight = findViewById(R.id.rbWeight);

                        ArrayAdapter<CharSequence> adapter;

                        if (rbTemp.isChecked()) {
                            adapter = ArrayAdapter.createFromResource(unitType.getContext(),
                                    R.array.tempList, android.R.layout.simple_spinner_item);
                            imgView.setImageResource(R.drawable.temperature);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            unitOri.setAdapter(adapter);
                            unitConv.setAdapter(adapter);
                        } else if (rbDist.isChecked()) {
                            adapter = ArrayAdapter.createFromResource(unitType.getContext(),
                                    R.array.distList, android.R.layout.simple_spinner_item);
                            imgView.setImageResource(R.drawable.distance);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            unitOri.setAdapter(adapter);
                            unitConv.setAdapter(adapter);
                        } else if (rbWeight.isChecked()) {
                            adapter = ArrayAdapter.createFromResource(unitType.getContext(),
                                    R.array.weightList, android.R.layout.simple_spinner_item);
                            imgView.setImageResource(R.drawable.weight);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            unitOri.setAdapter(adapter);
                            unitConv.setAdapter(adapter);
                        }
                        inputTxt.setText("0");
                        outputTxt.setText("0");
                    }
                }
        );
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doConvert();
            }
        });
        unitOri.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                doConvert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        unitConv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                doConvert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        roundBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                doConvert();
            }
        });
        formBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (formBox.isChecked())
                    imgFormula.setVisibility(View.VISIBLE);
                else
                    imgFormula.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        startDialog = new AlertDialog.Builder(this).create();
        startDialog.setTitle("Application started");
        startDialog.setMessage("This app can use to convert any units");
        startDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        startDialog.show();
    }

    protected double convertUnit(String type, String oriUnit, String convUnit, double value){
        switch (type){
            case "Temperature":
                switch (oriUnit){
                    case "°C":
                        switch (convUnit){
                            case "°F":
                                value = temp.getFahrenheit();
                                break;
                            case "K":
                                value = temp.getKelvins();
                                break;
                            case "°C":
                                value = temp.getCelcius();
                                break;
                        }
                        break;
                    case "°F":
                        switch (convUnit){
                            case "°F":
                                value = temp.getFahrenheit();
                                break;
                            case "K":
                                value = temp.getKelvins();
                                break;
                            case "°C":
                                value = temp.getCelcius();
                                break;
                        }
                        break;
                    case "K":
                        switch (convUnit){
                            case "°F":
                                value = temp.getFahrenheit();
                                break;
                            case "K":
                                value = temp.getKelvins();
                                break;
                            case "°C":
                                value = temp.getCelcius();
                                break;
                        }
                        break;
                }
                break;
            case "Distance":
                switch (oriUnit){
                    case "Mtr":
                        switch (convUnit){
                            case "Inc":
                                value = dist.getInch();
                                break;
                            case "Mil":
                                value = dist.getMile();
                                break;
                            case "Ft":
                                value = dist.getFoot();
                                break;
                            case "Mtr":
                                value = dist.getMeter();
                                break;
                        }
                        break;
                    case "Inc":
                        switch (convUnit){
                            case "Inc":
                                value = dist.getInch();
                                break;
                            case "Mil":
                                value = dist.getMile();
                                break;
                            case "Ft":
                                value = dist.getFoot();
                                break;
                            case "Mtr":
                                value = dist.getMeter();
                                break;
                        }
                    case "Ft":
                        switch (convUnit){
                            case "Inc":
                                value = dist.getInch();
                                break;
                            case "Mil":
                                value = dist.getMile();
                                break;
                            case "Ft":
                                value = dist.getFoot();
                                break;
                            case "Mtr":
                                value = dist.getMeter();
                                break;
                        }
                        break;
                    case "Mil":
                        switch (convUnit){
                            case "Inc":
                                value = dist.getInch();
                                break;
                            case "Mil":
                                value = dist.getMile();
                                break;
                            case "Ft":
                                value = dist.getFoot();
                                break;
                            case "Mtr":
                                value = dist.getMeter();
                                break;
                        }
                        break;
                }
                break;
            case "Weight":
                switch (oriUnit){
                    case "Grm":
                        switch (convUnit){
                            case "Grm":
                                value = weight.getGram();
                                break;
                            case "Onc":
                                value = weight.getOunce();
                                break;
                            case "Pnd":
                                value = weight.getPound();
                                break;
                        }
                        break;
                    case "Pnd":
                        switch (convUnit){
                            case "Grm":
                                value = weight.getGram();
                                break;
                            case "Onc":
                                value = weight.getOunce();
                                break;
                            case "Pnd":
                                value = weight.getPound();
                                break;
                        }
                        break;
                    case "Onc":
                        switch (convUnit){
                            case "Grm":
                                value = weight.getGram();
                                break;
                            case "Onc":
                                value = weight.getOunce();
                                break;
                            case "Pnd":
                                value = weight.getPound();
                                break;
                        }
                        break;
                }
                break;
        }

        return value;
    }

    protected String strResult(double val, boolean rounded){
        DecimalFormat f = new DecimalFormat("#.##");
        DecimalFormat f2 = new DecimalFormat("#.#####");
        String result ="" ;
        if (rounded){
            result = f.format(val);
        }else if (!rounded){
            result = f2.format(val);
        }

        return result;
    }

    void doConvert(){
        RadioButton rbTemp = findViewById(R.id.rbTemp);
        RadioButton rbDist = findViewById(R.id.rbDist);
        RadioButton rbWeight = findViewById(R.id.rbWeight);

        Double inputDouble = Double.parseDouble(inputTxt.getText().toString());

        String ori = unitOri.getSelectedItem().toString();
        String conv = unitConv.getSelectedItem().toString();

        if (rbTemp.isChecked()) {
            inputDouble = convertUnit("Temperature", ori, conv, inputDouble);
        } else if (rbDist.isChecked()) {
            inputDouble = convertUnit("Distance", ori, conv, inputDouble);
        } else if (rbWeight.isChecked()) {
            inputDouble = convertUnit("Weight", ori, conv, inputDouble);
        }

        if (roundBox.isChecked()) {
            String output = strResult(inputDouble, true);
            outputTxt.setText(output);
        } else {
            String output = strResult(inputDouble, false);
            outputTxt.setText(output);
        }
    }
}
