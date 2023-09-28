package com.longthph30891.ph30891_mob2041_asm.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.longthph30891.ph30891_mob2041_asm.Adapter.AdapterThanhVien;
import com.longthph30891.ph30891_mob2041_asm.DAO.thanhVienDAO;
import com.longthph30891.ph30891_mob2041_asm.Model.ThanhVien;
import com.longthph30891.ph30891_mob2041_asm.R;

import java.util.ArrayList;

public class frgQLyThanhVien extends Fragment {
    public frgQLyThanhVien() {
        // Required empty public constructor
    }
    private ArrayList<ThanhVien> list = new ArrayList<>();
    thanhVienDAO tvDAO;
    AdapterThanhVien adapterThanhVien;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frg_q_ly_thanh_vien, container, false);
        RecyclerView rcv = view.findViewById(R.id.rcv_Tv);
        FloatingActionButton fabAdd = view.findViewById(R.id.fabAdd_Tv);
        //
        tvDAO = new thanhVienDAO(getActivity());
        list = tvDAO.selectAll();
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        rcv.setLayoutManager(layout);
        adapterThanhVien = new AdapterThanhVien(getActivity(),list);
        rcv.setAdapter(adapterThanhVien);
        //
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpendialogAdd();
            }
        });
        return view;
    }

    private void OpendialogAdd() {

    }
}