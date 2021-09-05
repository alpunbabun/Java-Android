package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textView2;
    private TextView textView1; //variables
    private EditText Email; //variables
    private EditText Password; //variables
    private Button Login;      //variables
    float v = 0;

    private FirebaseAuth auth; //variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.pb_loading);
        textView2 = (TextView) findViewById(R.id.tv_welcome);
        textView1 = (TextView) findViewById(R.id.tv_helloAgain);
        Email = (EditText) findViewById(R.id.et_email);
        Password = (EditText) findViewById(R.id.et_password);
        Login = (Button) findViewById(R.id.btn_login);

        textView1.setTranslationX(800);
        textView2.setTranslationX(800);
        Email.setTranslationX(800);
        Password.setTranslationX(800);
        Login.setTranslationX(800);

        textView2.setAlpha(v);
        textView1.setAlpha(v);
        Email.setAlpha(v);
        Password.setAlpha(v);
        Login.setAlpha(v);

        textView1.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(50).start();
        textView2.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(75).start();
        Email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(100).start();
        Password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(125).start();
        Login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(150).start();

        auth = FirebaseAuth.getInstance();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              progressBar.setVisibility(View.VISIBLE);
                String txt_Email = Email.getText().toString().trim();
                String txt_Password = Password.getText().toString().trim();

                if (txt_Email.isEmpty()) {
                    Email.setError("Email is Required!");
                    Email.requestFocus();
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                if (txt_Password.isEmpty()) {
                    Password.setError("Password is Required!");
                    Password.requestFocus();
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                if (txt_Password.length()<6) {
                    Password.setError("Incorrect Password");
                    Password.requestFocus();
                    progressBar.setVisibility(View.GONE);
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(txt_Email).matches()) {
                    Email.setError("Please provide valid email!");
                    Email.requestFocus();
                    progressBar.setVisibility(View.GONE);
                    return;
                }


                auth.signInWithEmailAndPassword(txt_Email, txt_Password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        progressBar.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
                        finish();
                    }
                });
            }
        });
    }
}