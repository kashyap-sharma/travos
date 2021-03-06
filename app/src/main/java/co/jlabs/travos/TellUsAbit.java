package co.jlabs.travos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.mukesh.countrypicker.CountryPicker;
import com.mukesh.countrypicker.CountryPickerListener;

import co.jlabs.travos.custComp.BebasNeueButton;
import co.jlabs.travos.custComp.BebasNeueEditText;
import co.jlabs.travos.custComp.BebasNeueTextView;

public class TellUsAbit extends AppCompatActivity implements View.OnClickListener {

    private BebasNeueEditText age;
    private BebasNeueTextView country;
    private BebasNeueButton continu;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_tell_us_abit);
        initView();
    }

    private void initView() {
        age = (BebasNeueEditText) findViewById(R.id.age);
        country = (BebasNeueTextView) findViewById(R.id.country);
        continu = (BebasNeueButton) findViewById(R.id.continu);

        continu.setOnClickListener(this);
        country.setOnClickListener(this);
        age.setTransformationMethod(null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.continu:
                Intent intent=new Intent(context, MainPage.class);
                startActivity(intent);
                break;

            case R.id.country:
                final CountryPicker picker = CountryPicker.newInstance("Select Country");  // dialog title
                picker.setListener(new CountryPickerListener() {
                    @Override
                    public void onSelectCountry(String name, String code, String dialCode, int flagDrawableResID) {
                        country.setText(name);
                        picker.dismiss();
                    }
                });
                picker.show(getSupportFragmentManager(), "COUNTRY_PICKER");
                break;
        }
    }

    private void submit() {
        // validate
        String ageString = age.getText().toString().trim();
        if (TextUtils.isEmpty(ageString)) {
            Toast.makeText(this, "Age", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
