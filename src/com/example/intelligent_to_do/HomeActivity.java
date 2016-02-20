package com.example.intelligent_to_do;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.intelligentToDo.controllers.UserController;

public class HomeActivity extends Activity {
	TextView ShowTextView;
	 Button UpdateProfile,SignOut;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Bundle extras = getIntent().getExtras();
		
		String status = extras.getString("status");
		String serviceType =extras.getString("serviceType");
		
		String name = "",welcome="Hello",text="";
		
		if(serviceType.equals("LoginService")){
			name = extras.getString("name");
		
			welcome = "Welcome " + name;
			String id=extras.getString("userId");
			 text = status + " ... " + welcome+"  , your id is "+	id;
		}
		else if(serviceType.equals("RegistrationService")){
			String id=extras.getString("userId");
			 text = status + " ... " + welcome+"  , your id is "+	id;
		}
		else if (serviceType.equals("UpdateProfileService")){
			 text = status;
		}
		ShowTextView = (TextView) findViewById(R.id.ShowText);
		
		ShowTextView.setText(text);
		UpdateProfile = (Button) findViewById(R.id.UpdateProfile);
		SignOut = (Button) findViewById(R.id.SignOut);
		
		UpdateProfile.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				UserController usercontrol = UserController.getInstance();
				usercontrol.GetUserInformation();
			
			}
		});
		
		SignOut.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				UserController usercontrol = UserController.getInstance();
				usercontrol.SignOut();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
