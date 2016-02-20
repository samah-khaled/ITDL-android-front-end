package com.example.intelligent_to_do;




import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.intelligentToDo.controllers.UserController;

public class SignUpActivity extends Activity {
	Button Regest;
    EditText Email ,Password,TwitterAccount,userName,DateOfBirth,City;
    RadioGroup  GenderRadioGroup;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		Email =(EditText) findViewById(R.id.editTextmail);
		Password= (EditText) findViewById(R.id.editTextpassword);
		TwitterAccount =(EditText) findViewById(R.id.editTextTwitter);
		userName=(EditText) findViewById(R.id.TextUserName);
		DateOfBirth =(EditText) findViewById(R.id.editTextBirthDate);
		City =(EditText) findViewById(R.id.editTextCity);
		GenderRadioGroup = (RadioGroup)findViewById(R.id.radioGroupGender);
		Regest = (Button)findViewById(R.id.buttonRegister);
		Regest.setOnClickListener(new View.OnClickListener(){

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
				usercontrol.signUp(name, email, pas, gender, city, date, twitter);
			
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_up, menu);
		return true;
	}

}
