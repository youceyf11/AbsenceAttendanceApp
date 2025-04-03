package com.example.profattendaceemsi;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        db= FirebaseFirestore.getInstance();

        EditText nameEditText = findViewById(R.id.editTextTextName);
        EditText phoneEditText = findViewById(R.id.editTextTextPhone);
        EditText emailEditText = findViewById(R.id.editTextTextEmailAddress);
        EditText passwordEditText = findViewById(R.id.editTextTextPassword);
        Button signUpButton = findViewById(R.id.button);
        TextView signInTextView = findViewById(R.id.sign_in_text);

        signInTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String phone = phoneEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty() || name.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(SignUpActivity.this, "Creating account...", Toast.LENGTH_SHORT).show();


                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();

                                if(user != null){
                                    saveUserToFirestore(user.getUid(), name, phone, email);
                                }
                                Toast.makeText(SignUpActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(SignUpActivity.this,"Register failed: " +
                                                (task.getException() != null ? task.getException().getMessage() : "Unknown error"),
                                        Toast.LENGTH_LONG).show();
                            }
                        });


            }
        });
    }
    private void saveUserToFirestore(String userId, String name, String phone, String email) {
        Map<String, Object> user = new HashMap<>();
        user.put("name", name);
        user.put("phone", phone);
        user.put("email", email);
        user.put("createdAt", System.currentTimeMillis());

        db.collection("users").document(userId)
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                     Toast.makeText(SignUpActivity.this,"created user",Toast.LENGTH_LONG).show();
                    }})
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(SignUpActivity.this, "Error saving user data: " + e.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}