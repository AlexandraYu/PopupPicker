package com.example.popuppicker;

import android.os.Bundle;
import android.app.Activity;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends Activity {

    public NumberPicker numPicker;
    public TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.textView1);
       
        numPicker=(NumberPicker) findViewById(R.id.numberPicker1);
        numPicker.setMaxValue(9);  
        numPicker.setMinValue(1);    
        numPicker.setValue(1); 

        //get picked value
        numPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener (){
             public void onValueChange(NumberPicker view, int oldValue, int newValue) {
                 
                 tv.setText("pick number is " + String.valueOf(newValue));
               
             }
        });
       
    }

}