package com.longthph30891.ph30891_mob2041_asm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.longthph30891.ph30891_mob2041_asm.Model.LoaiSach;
import com.longthph30891.ph30891_mob2041_asm.R;

import java.util.ArrayList;
import java.util.List;

public class LoaiSachSpinnerAdapter extends ArrayAdapter<LoaiSach> {
    private Context context;
    private ArrayList<LoaiSach> list;
    TextView tvMaLoai, tvTenLoai;

    public LoaiSachSpinnerAdapter(@NonNull Context context, ArrayList<LoaiSach> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.spinner, null);
        }
        final LoaiSach item = list.get(position);
        if (item == null) {
            tvMaLoai = view.findViewById(R.id.tv_ma_sp);
            tvMaLoai.setText(item.getMaTheLoai() + ". ");
            tvTenLoai = view.findViewById(R.id.tv_name_sp);
            tvTenLoai.setText(item.getTenTheLoai());
        }
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.spinner, null);
        }
        final LoaiSach item = list.get(position);
        tvMaLoai = view.findViewById(R.id.tv_ma_sp);
        tvMaLoai.setText(item.getMaTheLoai() + ". ");
        tvTenLoai = view.findViewById(R.id.tv_name_sp);
        tvTenLoai.setText(item.getTenTheLoai());
        return view;
    }
}
