package com.example.intelligent_to_do;



import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.intelligentToDo.controllers.UserController;

public class ViewUserInfoActivity extends Activity {
    EditText Email ,Password,TwitterAccount,userName,DateOfBirth,City;
    RadioGroup  GenderRadioGroup;
	 RadioButton MaleRadio,FemaleRadio;
	 Button Update;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_user_info);
		Bundle extras = getIntent().getExtras();
		String username =extras.getString("username");
		String useremail =extras.getString("useremail");
		String userpassword =extras.getString("userpassword");
		String usergender =extras.getString("usergender");
		String usercity =extras.getString("usercity");
		String usertwiterAcc =extras.getString("usertwiterAcc");
		String userbirthdate =extras.getString("userbirthdate");

		Email =(EditText) findViewById(R.id.editTextmail);
		Password= (EditText) findViewById(R.id.editTextpassword);
		TwitterAccount =(EditText) findViewById(R.id.editTextTwitter);
		userName=(EditText) findViewById(R.id.TextUserName);
		DateOfBirth =(EditText) findViewById(R.id.editTextBirthDate);
		City =(EditText) findViewById(R.id.editTextCity);
		MaleRadio=(RadioButton) findViewById(R.id.radioMale);
		FemaleRadio=(RadioButton) findViewById(R.id.radioFemale);
		Update=(Button) findViewById(R.id.buttonupdate);
		GenderRadioGroup = (RadioGroup)findViewById(R.id.radioGroupGender);

		if (usergender.equals("Male")){
			MaleRadio.setChecked(true);
		}
		else {
			FemaleRadio.setChecked(true);
		}
	
		
		Email.setText(useremail);
		Password.setText(userpassword);
		userName.setText(username);
		TwitterAccount.setText(usertwiterAcc);
		City.setText(usercity);
		DateOfBirth.setText(userbirthdate);
		
		Update.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				int selectedId = GenderRadioGroup.getCheckedRadioButtonId();
				 RadioButton genderbtn = (RadioButton) findViewById(selectedId);
				final String gender =genderbtn.getText().toString();
				Log.d("Gender", gender);
				String email=Email.getText().toString();
				String pas=Password.getText().toString();
				String twitter=TwitterAccount.getText().toString();
				String name=userName.getText().toString();
				String date=DateOfBirth.getText().toString();
				String city=City.getText().toString();
				
				UserController usercontrol = UserController.getInstance();
				usercontrol.UpdateProfile(name, email, pas, gender, city, date, twitter);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_user_info, menu);
		return true;
	}

}
