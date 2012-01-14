package com.brett.cold;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class TempFragment extends Fragment implements OnClickListener {
	
	private View mView;
	private EditText text;
	private RadioButton mCelsiusButton;
	private RadioButton mFahrenheitButton;
	private Button mCalculate;
	
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	super.onCreateView(inflater, container, savedInstanceState);
    	mView = inflater.inflate(R.layout.main, null, false);
    	return mView;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
    	super.onActivityCreated(savedInstanceState);
    	
		text = (EditText) mView.findViewById(R.id.editText1);
		mCelsiusButton = (RadioButton) mView.findViewById(R.id.celcius);
		mFahrenheitButton = (RadioButton) mView.findViewById(R.id.fahrenheit);

		mCalculate = (Button) mView.findViewById(R.id.calculate);
		mCalculate.setOnClickListener(this);
		
    }

	@Override
	public void onClick(View view) {
    	
    	if(view == mCalculate) {
			if (text.getText().length() == 0) {
				Toast.makeText(getActivity(), "Please enter a valid number", Toast.LENGTH_LONG).show();
			}
			else {
				float inputValue = Float.parseFloat(text.getText().toString());
				if (mCelsiusButton.isChecked()) {
					text.setText(String.valueOf(convertFahrenheitToCelsius(inputValue)));
					mCelsiusButton.setChecked(false);
					mFahrenheitButton.setChecked(true);
				} else {
					text.setText(String.valueOf(convertCelsiusToFahrenheit(inputValue)));
					mFahrenheitButton.setChecked(false);
					mCelsiusButton.setChecked(true);
				}				
			}	
    	}	
	}
	
	// Converts to celsius
	private float convertFahrenheitToCelsius(float fahrenheit) {
		return ((fahrenheit - 32) * 5 / 9);
	}

	// Converts to fahrenheit
	private float convertCelsiusToFahrenheit(float celsius) {
		return ((celsius * 9) / 5) + 32;
		
	}

    
}
