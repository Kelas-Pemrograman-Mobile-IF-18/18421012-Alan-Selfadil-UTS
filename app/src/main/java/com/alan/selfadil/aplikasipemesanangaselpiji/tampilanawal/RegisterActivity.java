package com.alan.selfadil.aplikasipemesanangaselpiji.tampilanawal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alan.selfadil.aplikasipemesanangaselpiji.R;
import com.alan.selfadil.aplikasipemesanangaselpiji.server.BaseURL;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ornach.nobobutton.NoboButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static com.alan.selfadil.aplikasipemesanangaselpiji.server.BaseURL.register;
import static com.alan.selfadil.aplikasipemesanangaselpiji.session.PrefSetting.Username;

public class RegisterActivity extends AppCompatActivity {

    Button btnKembali;
    NoboButton btnRegister;
    EditText edtUsername, edtNamalengkap, edtPassword, edtEmail, edtAlamat, edtNotelp;

    private RequestQueue mRequestQueue;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        mRequestQueue = Volley.newRequestQueue(this);

        edtUsername     = (EditText) findViewById(R.id.edtUsername);
        edtNamalengkap  = (EditText) findViewById(R.id.edtNamalengkap);
        edtPassword     = (EditText) findViewById(R.id.edtPassword);
        edtEmail        = (EditText) findViewById(R.id.edtEmail);
        edtAlamat       = (EditText) findViewById(R.id.edtAlamat);
        edtNotelp       = (EditText) findViewById(R.id.edtNotelp);

        btnKembali = (Button) findViewById(R.id.btnKembali);
        btnRegister = (NoboButton) findViewById(R.id.btnRegister);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername      = edtUsername.getText().toString();
                String strNamalengkap   = edtNamalengkap.getText().toString();
                String strEmail         = edtEmail.getText().toString();
                String strAlamat        = edtAlamat.getText().toString();
                String strNotelp        = edtNotelp.getText().toString();
                String strPassword      = edtPassword.getText().toString();

                if(strUsername.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Username Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }else if(strNamalengkap.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Nama Lengkap Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }else if(strEmail.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Email Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }else if(strNotelp.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "No. Telepon Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }else if(strPassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Password Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }else if(strAlamat.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Alamat Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }else {
                    register(strUsername, strNamalengkap, strEmail, strNotelp, strPassword, strAlamat);
                }
            }
        });

    }
    public void register(String Username, String Namalengkap, String Email, String Notelp, String Password, String Alamat){

        // Post params to be sent to the server
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("username", Username);
        params.put("namalengkap", Namalengkap);
        params.put("email", Email);
        params.put("notelp", Notelp);
        params.put("role", "2");
        params.put("password", Password);
        params.put("alamat", Alamat);


        pDialog.setMessage("Mohon Tunggu.....");
        showDialog();

        JsonObjectRequest req = new JsonObjectRequest(BaseURL.register, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        hideDialog();
                        try {
                            String strMsg = response.getString("msg");
                            boolean status = response.getBoolean("error");
                            if(status == false){
                                Toast.makeText(getApplicationContext(), strMsg, Toast.LENGTH_LONG).show();
                                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(i);
                                finish();
                            }else {
                                Toast.makeText(getApplicationContext(), strMsg, Toast.LENGTH_LONG).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
                hideDialog();
            }
        });
        mRequestQueue.add(req);
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    private void showDialog(){
        if(!pDialog.isShowing()){
            pDialog.show();
        }
    }

    private void hideDialog(){
        if(pDialog.isShowing()){
            pDialog.dismiss();
        }
    }
}