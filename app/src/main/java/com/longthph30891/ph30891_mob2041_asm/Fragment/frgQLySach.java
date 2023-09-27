package com.longthph30891.ph30891_mob2041_asm.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.longthph30891.ph30891_mob2041_asm.Adapter.AdapterLoaiSach;
import com.longthph30891.ph30891_mob2041_asm.Adapter.AdapterSach;
import com.longthph30891.ph30891_mob2041_asm.DAO.loaiSachDAO;
import com.longthph30891.ph30891_mob2041_asm.DAO.sachDAO;
import com.longthph30891.ph30891_mob2041_asm.Model.Sach;
import com.longthph30891.ph30891_mob2041_asm.R;

import java.util.ArrayList;

public class frgQLySach extends Fragment {
    public frgQLySach() {
    }
    private ArrayList<Sach> list;
    sachDAO sDAO;
    AdapterSach adapterSach;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frg_q_ly_sach, container, false);
        RecyclerView rcvS = view.findViewById(R.id.rcv_S);
        FloatingActionButton fabAdd = view.findViewById(R.id.fabAdd_S);
        //
        sDAO = new sachDAO(getActivity());
        list = sDAO.selectAll();
        LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        rcvS.setLayoutManager(layout);
        adapterSach = new AdapterSach(getActivity(),list);
        rcvS.setAdapter(adapterSach);
        // btnAdd
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