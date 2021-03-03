package com.example.city_bus.SideNavigation.ui.login;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.city_bus.R;
import com.example.city_bus.SideNavigation.SideNavigationActivity;
import com.example.city_bus.SideNavigation.ui.home.HomeFragment;
import com.example.city_bus.admin.AdminSideNavigation.AdminSideNavigationActivity;
import com.example.city_bus.admin.AdminSideNavigation.ui.home.AdminHomeFragment;
import com.example.city_bus.login.SignupActivity;
import com.example.city_bus.startup.Splash_Screen;
import com.example.city_bus.startup.ViewPagerScreen;
import com.example.city_bus.user.UserSideNavigation.UserSideNavigationActivity;
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
    EditText email;
    EditText password;
    Button btn_login;
    CircularImageView lg_google;
    CheckBox rememberMe;
    Button signup;
    RelativeLayout progressbar;

    FirebaseAuth auth;
    DatabaseReference myref= FirebaseDatabase.getInstance().getReference();

    private GoogleSignInClient mGoogleSignInClient;

//    @Override
//    public void onStart() {
//        super.onStart();
//        FirebaseUser currentUser = auth.getCurrentUser();
//        if (currentUser != null) {
//            Intent intent = new Intent(getActivity(), HomeFragment.class);
//            startActivity(intent);
//        }
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_login, container, false);


        email = view.findViewById(R.id.lg_email);
        password = view.findViewById(R.id.lg_password);
        btn_login = (Button)view.findViewById(R.id.btn_login);
        lg_google = (CircularImageView)view.findViewById(R.id.lg_google);
        rememberMe = (CheckBox)view.findViewById(R.id.rememberMe);
      //  progressbar = view.findViewById(R.id.progressbar);
        auth = FirebaseAuth.getInstance();

        signup = (Button)view.findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SignupActivity.class));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!isConnected(getActivity())) {
                    showCustomDialog();
                }
                if(!validateFields()){
                    return;
                }


              //  progressbar.setVisibility(View.VISIBLE);

                auth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Map<String,String> map=new HashMap<>();
                                map.put("email",email.getText().toString());
                                myref.child(authResult.getUser().getUid()).setValue(map);
                                if(email.getText().toString().equals("admin@gmail.com")) {
                                    startActivity(new Intent(getActivity(), AdminSideNavigationActivity.class));
                                    getActivity().finish();

                                }
                                else {
                                    startActivity(new Intent(getActivity(), SideNavigationActivity.class));
                                    //progressbar.setVisibility(View.GONE);
                                }

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                       // progressbar.setVisibility(View.GONE);
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


//        rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//
//                SharedPreferences sharedPref = getActivity().getSharedPreferences("remember", MODE_PRIVATE);
//                String email = sharedPref.getString("email", "");
//                String password = sharedPref.getString("password","");
//
//                if(buttonView.isChecked()){
//                    SharedPreferences.Editor editor = sharedPref.edit();
//                    editor.putString("email",email.getEditText().getText().toString());
//                    editor.putString("password",password.getEditText().getText().toString());
//                    editor.putString("rememberMe","true");
//                    editor.apply();
//                }
//                else{
//
//                }
//
//            }
//        });
    }


    private boolean isConnected(FragmentActivity loginFragment) {

        ConnectivityManager connectivityManager = (ConnectivityManager) loginFragment.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wificon = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobcon = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if((wificon != null && wificon.isConnected()) || (mobcon != null && mobcon.isConnected())){
            return true;
        }
        else {
            return false;
        }

    }


    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Please connect to the internet to proceed further")
        .setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getActivity(), UserSideNavigationActivity.class));

                    }
                });
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


    private boolean validateFields(){
        String eml = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if(eml.isEmpty()){
            email.setError("Email can not be empty");
            email.requestFocus();
            return  false;
        }
        else if(pass.isEmpty()){
            password.setError("Password can not be empty");
            password.requestFocus();
            return  false;
        }
        else{
            password.setError(null);
            //password.setErrorEnabled(false);
            return true;
        }
    }

}