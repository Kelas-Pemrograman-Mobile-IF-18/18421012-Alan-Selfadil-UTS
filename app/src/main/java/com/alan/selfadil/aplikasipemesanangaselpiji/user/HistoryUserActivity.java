package com.alan.selfadil.aplikasipemesanangaselpiji.user;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.alan.selfadil.aplikasipemesanangaselpiji.R;
import com.alan.selfadil.aplikasipemesanangaselpiji.adapter.AdapterGas;
import com.alan.selfadil.aplikasipemesanangaselpiji.model.ModelGas;
import com.alan.selfadil.aplikasipemesanangaselpiji.server.BaseURL;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HistoryUserActivity extends AppCompatActivity {

    ProgressDialog pDialog;

    AdapterGas adapter;
    ListView list;

    ArrayList<ModelGas> newsList = new ArrayList<ModelGas>();
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_user);
        getSupportActionBar().setTitle("Data Gas");

        mRequestQueue = Volley.newRequestQueue(this);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        list = (ListView) findViewById(R.id.array_list);
        newsList.clear();
        adapter = new AdapterGas(HistoryUserActivity.this, newsList);
        list.setAdapter(adapter);
        getAllgas();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(HistoryUserActivity.this, UserActivity.class);
        startActivity(i);
        finish();
    }

    private void getAllgas() {
        // Pass second argument as "null" for GET requests
        pDialog.setMessage("Loading");
        showDialog();
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, BaseURL.datagas, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        hideDialog();
                        try {
                            boolean status = response.getBoolean("error");
                            if (status == false) {
                                Log.d("data buku = ", response.toString());
                                String data = response.getString("data");
                                JSONArray jsonArray = new JSONArray(data);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    final ModelGas gas = new ModelGas();
                                    final String _id = jsonObject.getString("_id");
                                    final String kodepesanan = jsonObject.getString("kodepesanan");
                                    final String jenisgas = jsonObject.getString("jenisgas");
                                    final String jumlahgas = jsonObject.getString("jumlahpesanan");
                                    final String alamat = jsonObject.getString("alamatpenerima");
                                    final String atasnama = jsonObject.getString("atasnama");
                                    gas.setKodeGas(kodepesanan);
                                    gas.setJenisGas(jenisgas);
                                    gas.setJumlahPesanan(jumlahgas);
                                    gas.setAlamatpenerima(alamat);
                                    gas.setAtasnama(atasnama);
                                    gas.set_id(_id);

                                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                            // TODO Auto-generated method stub
                                            Intent a = new Intent(HistoryUserActivity.this, EditdanHapusDataGasActivity.class);
                                            a.putExtra("kodepesanan", newsList.get(position).getKodeGas());
                                            a.putExtra("_id", newsList.get(position).get_id());
                                            a.putExtra("jenisgas", newsList.get(position).getJenisGas());
                                            a.putExtra("jumlahpesanan", newsList.get(position).getJumlahPesanan());
                                            a.putExtra("alamatpenerima", newsList.get(position).getAlamatpenerima());
                                            a.putExtra("atasnama", newsList.get(position).getAtasnama());
                                            startActivity(a);
                                        }
                                    });
                                    newsList.add(gas);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
                hideDialog();
            }
        });

        /* Add your Requests to the RequestQueue to execute */
        mRequestQueue.add(req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();

    }
}