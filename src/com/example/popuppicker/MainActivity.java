package com.example.popuppicker;

import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private NumberPicker numPicker;
    private TextView tv;
    private int DEFAULT_COPY = 1; 
    private int pickedValue; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.button); 
        View.OnClickListener myClick = new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				button.setClickable(false);
				LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
			    View popupView = layoutInflater.inflate(R.layout.popup, null);  
			    final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  
			    tv=(TextView) popupView.findViewById(R.id.textView);
			       
		        numPicker=(NumberPicker) popupView.findViewById(R.id.numberPicker);
		        numPicker.setMaxValue(9);  
		        numPicker.setMinValue(1);    
		        numPicker.setValue(1); 
		        String pickerTitle = getResources().getString(R.string.picker_title);
		   	 	String strPickerTitle = String.format(pickerTitle, String.valueOf(DEFAULT_COPY));
		        tv.setText(strPickerTitle);
		        //get picked value
		        numPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener (){
		             public void onValueChange(NumberPicker view, int oldValue, int newValue) {
		            	 Log.d("Alex", "old value is: "+oldValue); 
		            	 Log.d("Alex", "new value is: "+newValue);
		            	 String pickerTitle = getResources().getString(R.string.picker_title);
		            	 String strPickerTitle = String.format(pickerTitle, String.valueOf(newValue));
		            	 pickedValue = newValue; 
		                 tv.setText(strPickerTitle);
		               
		             }
		        });
			    Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
			    btnDismiss.setOnClickListener(new Button.OnClickListener(){
			    	@Override
			    	public void onClick(View v) {
			    		// TODO Auto-generated method stub
			    		Log.d("Alex", "dismiss onClicked!"); 
			    		popupWindow.dismiss();
			    		button.setClickable(true);
			    	}
			    });
			    Button btnOK = (Button)popupView.findViewById(R.id.ok);
			    btnOK.setOnClickListener(new Button.OnClickListener(){
			    	@Override
			    	public void onClick(View v) {
			    		// TODO Auto-generated method stub
			    		Log.d("Alex", "OK onClicked!"); 
			    		Toast.makeText(getApplicationContext(), "Will print out"+pickedValue+ " copies!", Toast.LENGTH_LONG).show(); 
			    		popupWindow.dismiss();
			    		button.setClickable(true);
			    	}
			    });           
			    popupWindow.showAsDropDown(button, 50, -30);
			}
		};


        button.setOnClickListener(myClick); 
		
    }

}