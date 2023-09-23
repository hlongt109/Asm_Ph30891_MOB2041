package com.longthph30891.ph30891_mob2041_asm.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.longthph30891.ph30891_mob2041_asm.Database.DbHelper;
import com.longthph30891.ph30891_mob2041_asm.Model.PhieuMuon;

import java.util.ArrayList;

public class phieuMuonDAO {
    private final DbHelper dbHelper;
    public phieuMuonDAO(Context context) {
        dbHelper = new DbHelper(context);
    }
    // selectAll
    public ArrayList<PhieuMuon> selectAll(){
        ArrayList<PhieuMuon> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery("SELECT * FROM PHIEUMUON",null);
            if(cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    PhieuMuon pm = new PhieuMuon();
                    pm.setMaPhieu(cursor.getInt(0));
                    pm.setMaSach(cursor.getInt(1));
                    pm.setMaTT(cursor.getString(2));
                    pm.setMaTV(cursor.getInt(3));
                    pm.setTienThue(cursor.getInt(4));
                    pm.setNgayMuon(cursor.getString(5));
                    pm.setTrangThai(cursor.getInt(6));
                    list.add(pm);
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    // add new
    public boolean insert(PhieuMuon pm){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaPhieu",pm.getMaPhieu());
        values.put("MaSach",pm.getMaSach());
        values.put("MaTT",pm.getMaTT());
        values.put("MaTV",pm.getMaTV());
        values.put("TienThue",pm.getTienThue());
        values.put("NgayMuon",pm.getNgayMuon());
        values.put("TrangThai",pm.getTrangThai());
        long row = db.insert("PHIEUMUON",null,values);
        return (row > 0);
    }
    public boolean update (PhieuMuon pm){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaPhieu",pm.getMaPhieu());
        values.put("MaSach",pm.getMaSach());
        values.put("MaTT",pm.getMaTT());
        values.put("MaTV",pm.getMaTV());
        values.put("TienThue",pm.getTienThue());
        values.put("NgayMuon",pm.getNgayMuon());
        values.put("TrangThai",pm.getTrangThai());
        long row = db.update("PHIEMUON",values,"MaPhieu=?",new String[]{String.valueOf(pm.getMaPhieu())});
        return (row > 0);
    }
    // delete
    public boolean delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long row = db.delete("PHIEUMUON","MaPhieu=?",new String[]{String.valueOf(id)});
        return (row > 0);
    }
}
