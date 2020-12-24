package com.example.city_bus.SideNavigation.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.city_bus.R;
import com.example.city_bus.SideNavigation.ui.home.HomeFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;


public class LoginFragment extends Fragment {


    private static final int RC_SIGN_IN = 123;
    TextInputLayout lg_email, lg_password;
    FloatingActionButton btn_login;
    CircularImageView lg_google;
    CheckBox rememberMe;

    FirebaseAuth auth;
    DatabaseReference myref= FirebaseDatabase.getInstance().getReference();

    private GoogleSignInClient mGoogleSignInClient;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(getActivity(), HomeFragment.class);
            startActivity(intent);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_login, container, false);


        lg_email = (TextInputLayout)view.findViewById(R.id.lg_email);
        lg_password = (TextInputLayout)view.findViewById(R.id.lg_password);
        btn_login = (FloatingActionButton)view.findViewById(R.id.btn_login);
        lg_google = (CircularImageView)view.findViewById(R.id.lg_google);
        rememberMe = (CheckBox)view.findViewById(R.id.rememberMe);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                auth.signInWithEmailAndPassword(lg_email.getEditText().getText().toString(),lg_password.getEditText().getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Map<String,String> map=new HashMap<>();
                                map.put("email",lg_email.getEditText().getText().toString());
                                myref.child(authResult.getUser().getUid()).setValue(map);
                                startActivity(new Intent(getActivity(), HomeFragment.class));

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });



        lg_google.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                signIn();
            }
        });


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);

        return view;

//        SharedPreferences sharedPref = getActivity().getSharedPreferences("remember", MODE_PRIVATE);
//        String email = sharedPref.getString("email", "");//"No name defined" is the default value.
//        String password = sharedPref.getString("password",""); //0 is the default value.
//
//
//        rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                if(buttonView.isChecked()){
//                    SharedPreferences sharedPref = getActivity().getSharedPreferences("remember", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPref.edit();
//                    editor.putString("email",lg_email.getEditText().getText().toString());
//                    editor.putString("password",lg_password.getEditText().getText().toString());
//                    editor.putString("rememberMe","true");
//                    editor.apply();
//                    Toast.makeText(getActivity(), "checked", Toast.LENGTH_SHORT).show();
//
//
//                }
//                else if(!buttonView.isChecked()){
//                    SharedPreferences sharedPref = getActivity().getSharedPreferences("remember", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPref.edit();
//                    editor.putString("email",lg_email.getEditText().getText().toString());
//                    editor.putString("password",lg_password.getEditText().getText().toString());
//                    editor.putString("rememberMe","false");
//                    editor.apply();
//                    Toast.makeText(getActivity(), "unchecked", Toast.LENGTH_SHORT).show();
//
//
//                }
//
//            }
//        });
    }



    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == 123) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {

                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            Intent intent = new Intent(getActivity(), HomeFragment.class);
                            startActivity(intent);
                        } else {

                            Toast.makeText(getActivity(), "Sorry Auth Fail", Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });


    }


}