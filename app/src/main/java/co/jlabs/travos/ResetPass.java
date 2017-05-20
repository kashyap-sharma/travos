package co.jlabs.travos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import co.jlabs.travos.custComp.BebasNeueButton;
import co.jlabs.travos.custComp.BebasNeueEditText;

public class ResetPass extends AppCompatActivity implements View.OnClickListener {

    private BebasNeueButton reset;
    private BebasNeueEditText username;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);
        initView();
    }

    private void initView() {
        reset = (BebasNeueButton) findViewById(R.id.reset);
        username = (BebasNeueEditText) findViewById(R.id.username);
        back = (ImageView) findViewById(R.id.back);

        reset.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reset:

                break;
            case R.id.back:

                break;
        }
    }

    private void submit() {
        // validate
        String usernameString = username.getText().toString().trim();
        if (TextUtils.isEmpty(usernameString)) {
            Toast.makeText(this, "Email Address", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
