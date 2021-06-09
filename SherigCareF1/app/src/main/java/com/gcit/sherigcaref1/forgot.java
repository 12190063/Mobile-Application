package com.gcit.sherigcaref1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText edit;
        Button forgot;
        FirebaseAuth firebaseAuth;
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_forgot);

            getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name) + "</font>"));
            edit=findViewById(R.id.fmailID);
            forgot=findViewById(R.id.forgotp);
            firebaseAuth=FirebaseAuth.getInstance();
            forgot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    firebaseAuth.sendPasswordResetEmail(edit.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(forgot.this, "password is sent to your email",Toast.LENGTH_LONG).show();
                                Intent intent= new Intent(forgot.this,LoginActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(forgot.this, task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            });
        }

    }