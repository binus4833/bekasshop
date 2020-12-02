package com.example.bekasshop.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bekasshop.R;
import com.example.bekasshop.Retrofit.LoginInterface;
import com.example.bekasshop.Retrofit.PreferenceHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class LoginActivity extends Activity {
    private EditText etUname, etPass;
    private Button btnlogin;
    private TextView tvreg;
    private PreferenceHelper preferenceHelper;
    boolean isNameValid, isEmailValid, isPasswordValid, isCPasswordValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferenceHelper = new PreferenceHelper(this);

        etUname = (EditText) findViewById(R.id.etusername);
        etPass = (EditText) findViewById(R.id.etpassword);

        btnlogin = (Button) findViewById(R.id.btn);
        tvreg = (TextView) findViewById(R.id.tvreg);

        tvreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                LoginActivity.this.finish();
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();

            }
        });
    }

    public void SetValidation() {

        // Check for a valid username.
        if (etUname.getText().toString().isEmpty()) {
            etUname.setError(getResources().getString(R.string.name_error));
            isNameValid = false;
        } else  {
            isNameValid = true;
        }

        // Check for a valid password.
        if (etPass.getText().toString().isEmpty()) {
            etPass.setError(getResources().getString(R.string.password_error));
            isPasswordValid = false;
        } else if (etPass.getText().length() < 6) {
            etPass.setError(getResources().getString(R.string.error_invalid_password));
            isPasswordValid = false;
        }
        else {
            isPasswordValid = true;
        }

        if (isNameValid && isPasswordValid) {
            loginUser();
        }

    }

    private void loginUser() {

        final String username = etUname.getText().toString().trim();
        final String password = etPass.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LoginInterface.LOGINURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        LoginInterface api = retrofit.create(LoginInterface.class);

        Call<String> call = api.getUserLogin(username,password);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring", response.body().toString());
                //Toast.makeText()

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body().toString();
                        parseLoginData(jsonresponse);


                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error:" + t, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void parseLoginData(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString("status").equals("true")) {

                saveInfo(response);

                Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                this.finish();
            }
            else{
                Toast.makeText(LoginActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void saveInfo(String response){

        preferenceHelper.putIsLogin(true);
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString("status").equals("true")) {
                JSONArray dataArray = jsonObject.getJSONArray("data");
                for (int i = 0; i < dataArray.length(); i++) {

                    JSONObject dataobj = dataArray.getJSONObject(i);
                    preferenceHelper.putName(dataobj.getString("name"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}