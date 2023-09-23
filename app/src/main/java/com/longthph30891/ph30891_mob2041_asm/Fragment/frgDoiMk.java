package com.longthph30891.ph30891_mob2041_asm.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.longthph30891.ph30891_mob2041_asm.DAO.AdminDAO;
import com.longthph30891.ph30891_mob2041_asm.DAO.thuThuDAO;
import com.longthph30891.ph30891_mob2041_asm.Database.DbHelper;
import com.longthph30891.ph30891_mob2041_asm.Model.ThuThu;
import com.longthph30891.ph30891_mob2041_asm.R;

import java.util.ArrayList;

public class frgDoiMk extends Fragment {
    public frgDoiMk() {
        // Required empty public constructor
    }
    TextInputLayout ilOldPass, ilNewPass, ilConf;
    TextInputEditText edOldPass, edNewPass, edConf;
    Button btnSave, btnCancel;
    ArrayList<ThuThu>list;
    thuThuDAO ttDAO;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frg_doi_mk, container, false);
        ilOldPass = view.findViewById(R.id.ilPassOld);
        ilNewPass = view.findViewById(R.id.ilPassChange);
        ilConf = view.findViewById(R.id.ilRePassChange);
        edOldPass = view.findViewById(R.id.edPassOld);
        edNewPass = view.findViewById(R.id.edPassChange);
        edConf = view.findViewById(R.id.edRePassChange);
        btnSave = view.findViewById(R.id.btnSaveUserChange);
        btnCancel = view.findViewById(R.id.btnCancelUserChange);
        //
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edOldPass.setText("");
                edNewPass.setText("");
                edConf.setText("");
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPass = edOldPass.getText().toString();
                String newPass = edNewPass.getText().toString();
                String confPass = edConf.getText().toString();
                ttDAO = new thuThuDAO(getActivity());
                if (ttDAO.checkOldPassword(oldPass) && newPass.equals(confPass)){
                    ThuThu tt = new ThuThu();
                    tt.setMatKhau(newPass);
                    if (ttDAO.update(tt)){
                        Toast.makeText(getActivity(), "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                        //
                    }else {
                        Toast.makeText(getActivity(), "Lỗi đổi mật khẩu!", Toast.LENGTH_SHORT).show();
                    }
                } else if (!newPass.equals(confPass)) {
                    ilNewPass.setError("Mật khẩu không khớp");
                    ilConf.setError("Mật khẩu không khớp");
                }else {
                    if(oldPass.isEmpty()||newPass.isEmpty() || confPass.isEmpty()){
                        if (oldPass.equals("")){
                            ilOldPass.setError("Không để trống");
                        }else{
                            ilOldPass.setError(null);
                        }
                        if(newPass.equals("")){
                            ilNewPass.setError("Không để trống");
                        }else{
                            ilNewPass.setError(null);
                        }
                        if(confPass.equals("")){
                            ilConf.setError("Không để trống");
                        }else{
                            ilConf.setError(null);
                        }
                    }else {
                        ilOldPass.setError("Mật khẩu cũ không đúng");
                    }
                }
            }
        });
        return view;
    }
}