package com.longthph30891.ph30891_mob2041_asm.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.longthph30891.ph30891_mob2041_asm.Adapter.AdapterPhieuMuon;
import com.longthph30891.ph30891_mob2041_asm.DAO.phieuMuonDAO;
import com.longthph30891.ph30891_mob2041_asm.Model.PhieuMuon;
import com.longthph30891.ph30891_mob2041_asm.R;

import java.util.ArrayList;


public class frgQLyPhieuMuon extends Fragment {
    public frgQLyPhieuMuon() {
        // Required empty public constructor
    }
    private ArrayList<PhieuMuon> list = new ArrayList<>();
    phieuMuonDAO pmDAO;
    AdapterPhieuMuon adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frg_q_ly_phieu_muon, container, false);
        RecyclerView rcv = view.findViewById(R.id.rcv_pm);
        FloatingActionButton fabAdd = view.findViewById(R.id.fabAdd_pm);
        //
        pmDAO = new phieuMuonDAO(getActivity());
        list = pmDAO.selectAll();
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        rcv.setLayoutManager(layout);
        adapter = new AdapterPhieuMuon(getActivity(),list);
        rcv.setAdapter(adapter);
        //
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
}