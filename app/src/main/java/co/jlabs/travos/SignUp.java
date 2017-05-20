package co.jlabs.travos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import co.jlabs.travos.custComp.BebasNeueButton;
import co.jlabs.travos.custComp.BebasNeueEditText;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private BebasNeueButton signin;
    private BebasNeueButton signup;
    private RadioGroup radiogrp;
    private BebasNeueEditText password;
    private BebasNeueEditText username;
    private BebasNeueEditText name;
    private BebasNeueButton skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();
    }

    private void initView() {
        signin = (BebasNeueButton) findViewById(R.id.signin);
        signup = (BebasNeueButton) findViewById(R.id.signup);
        radiogrp = (RadioGroup) findViewById(R.id.radiogrp);
        password = (BebasNeueEditText) findViewById(R.id.password);
        username = (BebasNeueEditText) findViewById(R.id.username);
        name = (BebasNeueEditText) findViewById(R.id.name);
        skip = (BebasNeueButton) findViewById(R.id.skip);

        signin.setOnClickListener(this);
        signup.setOnClickListener(this);
        skip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signin:

                break;
            case R.id.signup:

                break;
            case R.id.skip:

                break;
        }
    }

    private void submit() {
        // validate
        String passwordString = password.getText().toString().trim();
        if (TextUtils.isEmpty(passwordString)) {
            Toast.makeText(this, "Password", Toast.LENGTH_SHORT).show();
            return;
        }

        String usernameString = username.getText().toString().trim();
        if (TextUtils.isEmpty(usernameString)) {
            Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show();
            return;
        }

        String nameString = name.getText().toString().trim();
        if (TextUtils.isEmpty(nameString)) {
            Toast.makeText(this, "Name", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
