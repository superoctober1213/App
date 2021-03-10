package com.example.myapplication;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class IdentityCard extends AppCompatActivity {

    EditText editIDName;
    EditText editIDGender;
    EditText editIDBirth;
    EditText editIDNumber;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identitycard);
    }
}
