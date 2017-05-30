package co.jlabs.travos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import co.jlabs.travos.custComp.BebasNeueButton;
import co.jlabs.travos.custComp.BebasNeueEditText;

public class SignIn extends AppCompatActivity implements View.OnClickListener {

    private BebasNeueButton signup;
    private TextView bar;
    private BebasNeueButton forgot;
    private BebasNeueButton login;
    private BebasNeueEditText password;
    private TextInputLayout inputPassword;
    private BebasNeueEditText username;
    private TextInputLayout inputUsername;
    private BebasNeueButton skip;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_sign_in);
        initView();
    }

    private void initView() {
        signup = (BebasNeueButton) findViewById(R.id.signup);
        bar = (TextView) findViewById(R.id.bar);
        forgot = (BebasNeueButton) findViewById(R.id.forgot);
        login = (BebasNeueButton) findViewById(R.id.login);
        password = (BebasNeueEditText) findViewById(R.id.password);
        inputPassword = (TextInputLayout) findViewById(R.id.input_password);
        username = (BebasNeueEditText) findViewById(R.id.username);
        inputUsername = (TextInputLayout) findViewById(R.id.input_username);
        skip = (BebasNeueButton) findViewById(R.id.skip);

        signup.setOnClickListener(this);
        forgot.setOnClickListener(this);
        login.setOnClickListener(this);
        skip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signup:
                Intent inten=new Intent(context, SignUp.class);
                startActivity(inten);
                break;
            case R.id.forgot:
                Intent intent=new Intent(context, ResetPass.class);
                startActivity(intent);
                break;
            case R.id.login:
                Intent inte=new Intent(context, MainPage.class);
                startActivity(inte);
                break;
            case R.id.skip:
                Intent intent2=new Intent(context,TellUsAbit.class);
                startActivity(intent2);
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

        // TODO validate success, do something


    }
}
