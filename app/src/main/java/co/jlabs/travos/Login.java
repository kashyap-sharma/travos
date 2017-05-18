package co.jlabs.travos;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.facebook.CallbackManager;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import co.jlabs.travos.custComp.BebasNeueButton;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private BebasNeueButton sign_up;
    private BebasNeueButton sign_in;
    private BebasNeueButton fblogin;
    private BebasNeueButton skip;
    private LoginButton loginbutton;
    private CallbackManager callbackManager;
    private PendingAction pendingAction = PendingAction.NONE;
    private enum PendingAction {
        NONE,
        POST_PHOTO,
        POST_STATUS_UPDATE
    }
    String string_emails="";
    String string_last_name="";
    String string_first_name="";
    String string_fb_id="";
    String string_pic_url="";
    String string_bday="";
    String string_gender="";
    String string_location="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.activity_login);
        initView();

    }

    public void printHashKey() {
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "co.jlabs.travos",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }

        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }


    private void initView() {
        sign_up = (BebasNeueButton) findViewById(R.id.sign_up);
        sign_in = (BebasNeueButton) findViewById(R.id.sign_in);
        fblogin = (BebasNeueButton) findViewById(R.id.fblogin);
        skip = (BebasNeueButton) findViewById(R.id.skip);
        callbackManager = CallbackManager.Factory.create();
        sign_up.setOnClickListener(this);
        sign_in.setOnClickListener(this);
        fblogin.setOnClickListener(this);
        skip.setOnClickListener(this);
        loginbutton = (LoginButton) findViewById(R.id.loginbutton);
        loginbutton.setReadPermissions(Arrays.asList("public_profile, email", "user_birthday", "user_friends", "user_location"));
        loginbutton.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        
                        GraphRequest request = GraphRequest.newMeRequest(
                                loginResult.getAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject object, GraphResponse response) {
                                        string_emails = object.optString("email");
                                        string_last_name = object.optString("last_name");
                                        string_first_name = object.optString("first_name");
                                        string_fb_id = object.optString("id");
                                        try {
                                            string_bday=object.getString("birthday");
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                        string_gender=object.optString("gender");
                                        JSONObject location=object.optJSONObject("location");
                                        JSONObject picture = object.optJSONObject("picture");
                                        JSONObject data=picture.optJSONObject("data");

                                        try {
                                            string_pic_url=data.optString("url");
                                        } catch (Exception e) {
                                            string_pic_url="http://jlabs.co/no_image.png";
                                            e.printStackTrace();
                                        }
                                        Log.e("object",""+string_emails+string_gender+string_bday+string_location);
                                        SendFbData();

                                    }
                                });

                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "id,last_name,first_name,picture.type(large),email,birthday,gender,location");
                        request.setParameters(parameters);
                        request.executeAsync();


                    }


                    @Override
                    public void onCancel() {
                        Log.d("user2", "hello2");

                    }

                    @Override
                    public void onError(FacebookException exception) {

                        if (pendingAction != PendingAction.NONE
                                && exception instanceof FacebookAuthorizationException) {
                            showAlert();
                            pendingAction = PendingAction.NONE;
                        }

                    }

                    private void showAlert() {
                        new AlertDialog.Builder(Login.this)
                                .setTitle(R.string.cancelled)
                                .setMessage(R.string.permission_not_granted)
                                .setPositiveButton(R.string.ok, null)
                                .show();
                    }
                });
    }

    private void SendFbData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_up:

                break;
            case R.id.sign_in:

                break;
            case R.id.fblogin:
                loginbutton.performClick();
                break;
            case R.id.skip:

                break;

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
