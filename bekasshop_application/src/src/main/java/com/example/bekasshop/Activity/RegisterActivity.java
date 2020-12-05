package com.example.bekasshop.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bekasshop.R;
import com.example.bekasshop.Retrofit.PreferenceHelper;
import com.example.bekasshop.Retrofit.RegisterInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    private EditText etemail, etcpassword, etusername, etpassword;
    private Button btnregister;
    private TextView tvlogin;
    private PreferenceHelper preferenceHelper;
    boolean isNameValid, isEmailValid, isPasswordValid, isCPasswordValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        preferenceHelper = new PreferenceHelper(this);

        etemail = (EditText) findViewById(R.id.etemail);
        etusername = (EditText) findViewById(R.id.etusername);
        etcpassword = (EditText) findViewById(R.id.etcpassword);
        etpassword = (EditText) findViewById(R.id.etpassword);

        btnregister = (Button) findViewById(R.id.btn);
        tvlogin = (TextView) findViewById(R.id.tvlogin);

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                RegisterActivity.this.finish();
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
            }
        });

    }

    public void SetValidation() {
        // Check for a valid email address.
        if (etemail.getText().toString().isEmpty()) {
            etemail.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(etemail.getText().toString()).matches()) {
            etemail.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
        } else  {
            isEmailValid = true;
        }

        // Check for a valid username.
        if (etusername.getText().toString().isEmpty()) {
            etusername.setError(getResources().getString(R.string.name_error));
            isNameValid = false;
        } else  {
            isNameValid = true;
        }

        // Check for a valid password.
        if (etpassword.getText().toString().isEmpty()) {
            etpassword.setError(getResources().getString(R.string.password_error));
            isPasswordValid = false;
        } else if (etpassword.getText().length() < 6) {
            etpassword.setError(getResources().getString(R.string.error_invalid_password));
            isPasswordValid = false;
        }
        else {
            isPasswordValid = true;
        }

        // Check for a valid confirm password.
        if (etcpassword.getText().toString().isEmpty()) {
            etcpassword.setError(getResources().getString(R.string.c_password_error));
            isCPasswordValid = false;
        } else if (etpassword.getText().length() < 6) {
            etcpassword.setError(getResources().getString(R.string.error_c_invalid_password));
            isCPasswordValid = false;
        }
        else if(!etcpassword.getText().toString().equals(etpassword.getText().toString())){
            etcpassword.setError(getResources().getString(R.string.error_c_not_same_password));
            isCPasswordValid = false;
        }
        else {
            isCPasswordValid = true;
        }

        if (isNameValid && isEmailValid && isPasswordValid && isCPasswordValid) {
            registerMe();
        }

    }

    private void registerMe() {

        final String email = etemail.getText().toString();
        final String username = etusername.getText().toString();
        final String password = etpassword.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RegisterInterface.REGIURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        RegisterInterface api = retrofit.create(RegisterInterface.class);

        Call<String> call = api.getUserRegi(email,username,password);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring", response.body().toString());
                //Toast.makeText()
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body().toString();
                        try {
                            parseRegData(jsonresponse);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    private void parseRegData(String response) throws JSONException {

        JSONObject jsonObject = new JSONObject(response);
        if (jsonObject.optString("status").equals("true")){

            saveInfo(response);

            Toast.makeText(RegisterActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intent);
            this.finish();
        }else {

            Toast.makeText(RegisterActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
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