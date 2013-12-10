package com.example.finalexam;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private RadioButton favoriteQuoteRadioButton;
	private Button favoritePetButton;
	private Button alertButton;
	private Spinner chooseMeSpinner;
	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		
		favoriteQuoteRadioButton = (RadioButton) findViewById(R.id.favQuoteRadioButton);
		favoritePetButton = (Button) findViewById(R.id.favPetButton);
		alertButton = (Button) findViewById(R.id.alertButton);
		chooseMeSpinner = (Spinner) findViewById(R.id.chooseMeSpinner);
		
		favoriteQuoteRadioButton.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Toast.makeText(context, "Two men looked out from prison bars,\n" +
						"One saw the mud, the other saw stars.\n" +
						"- Dale Carnegie", Toast.LENGTH_LONG).show();
			}
		});
		
		favoritePetButton.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Intent intent = new Intent(getApplicationContext(),FavoritePetActivity.class);
				startActivity(intent);
			}
		});
		
		/**
		 * Used the following code from the site listed below and modified it to show only what I want:
		 * http://www.mkyong.com/android/android-alert-dialog-example/
		 */
		alertButton.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
				
				// set title
				alertDialogBuilder.setTitle("User beware!");
				
				// set dialog message
				alertDialogBuilder .setMessage("This app is useless!").setCancelable(false).setPositiveButton("Ok",new DialogInterface.OnClickListener() 
				{
					public void onClick(DialogInterface dialog,int id) 
					{
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}
				});
				
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
				
				// show it
				alertDialog.show();
			}
		});
		
		chooseMeSpinner.setOnItemSelectedListener(new OnItemSelectedListener() 
		{
			
			public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) 
			{
				Toast.makeText(parent.getContext(), "Wise Choice.", Toast.LENGTH_LONG).show();
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> arg0){}});
	}
	
	
	
}
