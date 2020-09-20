package com.example.fitnesstracker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInPageActivity extends AppCompatActivity {

    private EditText signin_mail;
    private EditText signin_pass;
    private Button login;
    private Button sign_up_button;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);
        this.setTitle("LogInPage");

        signin_mail= (EditText) findViewById(R.id.SignIn_EmailId);
        signin_pass= (EditText) findViewById(R.id.SignIn_Password);
        login=(Button)findViewById(R.id.Loginbutton);
        sign_up_button=(Button)findViewById(R.id.SignInpage_SignUpbutton);
        progressBar=(ProgressBar)findViewById(R.id.progressbarId);
        mAuth = FirebaseAuth.getInstance();

    }

    public void ShownewActivity(View view) {
        userLogin();
    }


    private void userLogin() {

        String email=signin_mail.getText().toString().trim();
        String password=signin_pass.getText().toString().trim();

        ///..............checking email validity...............////
        if(email.isEmpty())
        {
            signin_mail.setError("Enter an email address");
            signin_mail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signin_mail.setError("Enter a valid email address");
            signin_mail.requestFocus();
            return;
        }

        ///..............checking password validity...............////
        if(password.isEmpty())
        {
            signin_pass.setError("Enter a password");
            signin_pass.requestFocus();
            return;
        }
        if(password.length()<8)
        {
            signin_pass.setError("Minimum length of password is 8");
            signin_pass.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressBar.setVisibility(View.GONE);
                 if(task.isSuccessful())
                 {
                     Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                     startActivity(i);
                 }
                 else
                 {
                     Toast.makeText(getApplicationContext(), "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                 }
            }
        });

    }

    public void showSignUpPage(View view) {
        Intent i=new Intent(getApplicationContext(),SignUpActivityPage.class);
        startActivity(i);
    }

}
