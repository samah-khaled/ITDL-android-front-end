package com.example.intelligent_to_do;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.intelligentToDo.controllers.UserController;

public class MainActivity extends Activity {
	Button LogInButton,SignUpButton;
    EditText Email ,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        LogInButton=(Button) findViewById(R.id.buttonLogIn);
        SignUpButton=(Button) findViewById(R.id.buttonSignUp);
		Email= (EditText)findViewById(R.id.editTextEmail);
		Password=(EditText)findViewById(R.id.editTextPassword);
		
        LogInButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String email = Email.getText().toString();
				String pas = Password.getText().toString();
				UserController usercontrol = UserController.getInstance();
				usercontrol.Login(email, pas);

			}
		});
        
        SignUpButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent i = new Intent(getApplicationContext(),SignUpActivity.class);
				    startActivity(i);
				  // setContentView(R.layout.activity_sign_up);
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
