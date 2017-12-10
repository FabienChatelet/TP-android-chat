package io.gresse.hugo.tp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NamePickerActivity extends AppCompatActivity implements View.OnClickListener{



    EditText mEmailEditText;
    EditText mNameEditText;
    Button mSubmitButton;


    public static final String TAG = NamePickerActivity.class.getSimpleName();
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_picker);


        //Init des vues et BdD Firebase
        mEmailEditText = findViewById(R.id.emailEditText);
        mNameEditText = findViewById(R.id.nameEditText);
        mSubmitButton = findViewById(R.id.submitButton);
        mSubmitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        final String name =  mNameEditText.getText().toString();
        final String email = mEmailEditText.getText().toString();



        //Enregistrement des champs en type primitifs (SharedPreferences)
        UserStrorage.init(this);
        UserStrorage.saveUserInfo(email, name);

        //Vérification que les champs ne soient pas vides
        if(name.isEmpty() || email.isEmpty()){
            return;
        }
        // Création d'un Pattern qui verifiera l'adresse mail parser(Matcher)
        Pattern p = Pattern.compile(".+@.+\\.[a-z0-9]+");
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            Toast.makeText(NamePickerActivity.this, "L'adresse Mail saisie n'est pas au bon format, veuillez la saisir à nouveau",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(NamePickerActivity.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
