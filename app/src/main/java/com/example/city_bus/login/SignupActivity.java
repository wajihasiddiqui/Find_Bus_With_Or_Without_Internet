package com.example.city_bus.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.city_bus.R;
import com.example.city_bus.SideNavigation.ui.login.LoginFragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    EditText name, email, password;
    Button btn_signup, signin;

    FirebaseAuth auth;
    DatabaseReference myref= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        auth = FirebaseAuth.getInstance();
        name = findViewById(R.id.sg_name);
        email = findViewById(R.id.sg_email);
        password = findViewById(R.id.sg_passsword);

        btn_signup = findViewById(R.id.btn_signup);
        signin = findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginFragment.class));
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(!validatename() | !validateemail() | !validatepassword()){
                    return;
                }

                auth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Map<String,String> map=new HashMap<>();
                                map.put("email",email.getText().toString());
                                myref.child(authResult.getUser().getUid()).setValue(map);

                                startActivity(new Intent(SignupActivity.this, LoginFragment.class));

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignupActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }


    private boolean validatename(){

        String val = name.getText().toString().trim();
        String checkspaces = "\\A\\w{1,20}\\z";

        if(val.isEmpty()){
            name.setError("Field Can not be empty");
            return  false;
        }
        else if(val.length() > 20 ){
            name.setError("Password Is Too Large!");

            return  false;
        }
        else if(!val.matches(checkspaces)){
            name.setError("No White Space Are Allowed!");

            return  false;
        }
        else{
            name.setError(null);
           // name.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateemail(){

        String val = email.getText().toString().trim();
        String checkemail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty()){
            email.setError("Field Can not be empty");
            return  false;
        }
        else if(!val.matches(checkemail)){
            email.setError("Invalid Email!");
            return  false;
        }
        else{
            email.setError(null);
            return true;
        }
    }

    private boolean validatepassword(){

        String val = password.getText().toString().trim();


        if(val.isEmpty()){
            password.setError("Field Can not be empty");
            return  false;
        }
        else{
            password.setError(null);
            return true;
        }
    }


}