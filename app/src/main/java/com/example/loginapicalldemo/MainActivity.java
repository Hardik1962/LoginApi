package com.example.loginapicalldemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.loginapicalldemo.activity.EmployeeListActivity;
import com.example.loginapicalldemo.model.RequestDataClass;
import com.example.loginapicalldemo.model.ResponseDataClass;
import com.example.loginapicalldemo.retrofit.ApiService;
import com.example.loginapicalldemo.retrofit.RetrofitRestClient;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etemail)
    AppCompatEditText etemail;
    @BindView(R.id.etpwd)
    AppCompatEditText etpwd;
    @BindView(R.id.btnlogin)
    AppCompatButton btnlogin;
        ApiService  apiService;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        progressDialog = new ProgressDialog(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if (validationLogin())
              {
                  loginApi();
              }
            }
        });
    }

    public boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean validationLogin()
    {
        if (etemail.getText().toString().trim().isEmpty())
        {
            Toast.makeText(MainActivity.this,"Enter Email",Toast.LENGTH_LONG).show();
            return false;
        }
        else if(!emailValidator(etemail.getText().toString()))
        {
            Toast.makeText(MainActivity.this,"Enter valid Email",Toast.LENGTH_LONG).show();
            return false;
        }
        else if (etpwd.getText().toString().trim().isEmpty())
        {
            Toast.makeText(MainActivity.this,"Enter Password",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void loginApi()
    {
        progressDialog.setMessage("Wait");
        progressDialog.show();

        apiService = RetrofitRestClient.getRetrofitInstance().create(ApiService.class);
        final RequestDataClass requestDataClass= new RequestDataClass("dpatel@ciright.com", "Dpatel$2020", 0);
        Call<List<ResponseDataClass>> listCall=apiService.Login(requestDataClass);
        listCall.enqueue(new Callback<List<ResponseDataClass>>() {
            @Override
            public void onResponse(Call<List<ResponseDataClass>> call, final Response<List<ResponseDataClass>> response) {

                progressDialog.dismiss();
                if (response.isSuccessful()) {

                    Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_LONG).show();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                Intent ii = new Intent(MainActivity.this,EmployeeListActivity.class);
                                List res = response.body();


                                for(int i=0;i<res.size();i++)
                                {
                                    global.arry.add((ResponseDataClass) res.get(i));
                                }

                                startActivity(ii);
                            }catch (Exception e)
                            {
                                e.printStackTrace();
                            }

                        }
                    });
                }
                else {
                    Toast.makeText(MainActivity.this, "Response fail", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<List<ResponseDataClass>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_LONG).show();

            }
        });

    }
}