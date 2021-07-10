package com.alan.selfadil.aplikasipemesanangaselpiji.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alan.selfadil.aplikasipemesanangaselpiji.R;
import com.alan.selfadil.aplikasipemesanangaselpiji.model.ModelGas;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterGas extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<ModelGas> item;

    public AdapterGas(Activity activity, List<ModelGas> item) {
        this.activity = activity;
        this.item = item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.content_gas, null);

        TextView kodepesanan        = (TextView) convertView.findViewById(R.id.txtKodegas);
        TextView jenisgas          = (TextView) convertView.findViewById(R.id.txtJenisgas);
        TextView jumlahgas      = (TextView) convertView.findViewById(R.id.txtJumlahgas);
        TextView alamatpesanan       = (TextView) convertView.findViewById(R.id.txtAlamat);
        TextView atasnama          = (TextView) convertView.findViewById(R.id.txtAtasnama);

        jenisgas.setText(item.get(position).getJenisGas());
        jumlahgas.setText(item.get(position).getJumlahPesanan());
        alamatpesanan.setText(item.get(position).getAlamatpenerima());
        atasnama.setText(item.get(position).getAtasnama());
        return convertView;
    }
}
