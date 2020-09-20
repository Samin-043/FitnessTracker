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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivityPage extends AppCompatActivity {

   // private EditText signup_name;
    private EditText signup_mail;
    private EditText signup_pass;
    private Button signup;
    private Button signIn;
    private FirebaseAuth mAuth;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        this.setTitle("SignUp");

        mAuth = FirebaseAuth.getInstance();

       // signup_name=(EditText) findViewById(R.id.SignUp_Name);
        signup_mail=(EditText) findViewById(R.id.SignUp_EmailId);
        signup_pass=(EditText) findViewById(R.id.SignUp_NewPassword);
        signup=(Button)findViewById(R.id.SignUp_Button);
        signIn=(Button)findViewById(R.id.SignUppage_SignInbutton);
        progressbar=(ProgressBar) findViewById(R.id.progressId);

    }

    public void show_Main2_Activity(View view) {



       if(view.getId()==R.id.SignUp_Button)
       {
           userRegister();
       }

        //Intent i=new Intent(getApplicationContext(),LogInPageActivity.class);
        //startActivity(i);

    }

    ////.........................User Register Method.....................//////
    private void userRegister() {
        String email=signup_mail.getText().toString().trim();
        String password=signup_pass.getText().toString().trim();

        ///..............checking email validity...............////
        if(email.isEmpty())
        {
            signup_mail.setError("Enter an email address");
            signup_mail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signup_mail.setError("Enter a valid email address");
            signup_mail.requestFocus();
            return;
        }

        ///..............checking password validity...............////
        if(password.isEmpty())
        {
            signup_pass.setError("Enter a password");
            signup_pass.requestFocus();
            return;
        }
        if(password.length()<8)
        {
            signup_pass.setError("Minimum length of password is 8");
            signup_pass.requestFocus();
            return;
        }

        progressbar.setVisibility(View.VISIBLE);


        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressbar.setVisibility(View.GONE);

                if (task.isSuccessful())
                {
                    //finish();
                    Toast.makeText(getApplicationContext(), "Register is Succesfully", Toast.LENGTH_SHORT).show();
                    //Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                    //startActivity(i);
                }
                else
                {
                    if(task.getException()instanceof FirebaseAuthUserCollisionException)
                    {
                        Toast.makeText(getApplicationContext(), "User is already registered", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void showSignInPage(View view) {
        Intent i=new Intent(getApplicationContext(),LogInPageActivity.class);
        startActivity(i);
    }

}
