package com.longthph30891.ph30891_mob2041_asm.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.longthph30891.ph30891_mob2041_asm.Database.DbHelper;
import com.longthph30891.ph30891_mob2041_asm.Model.Sach;
import com.longthph30891.ph30891_mob2041_asm.Model.Top;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class thongKeDAO {
    private final DbHelper dbHelper;
    public thongKeDAO(Context context) {
        dbHelper = new DbHelper(context);
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    // thong ke top 10
    public  ArrayList<Top> getTop10(){
        ArrayList<Top> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = "SELECT SACH.TenSach ,COUNT(PHIEUMUON.MaSach)  FROM SACH LEFT JOIN PHIEUMUON ON SACH.MaSach = PHIEUMUON. MaSach GROUP BY SACH.TenSach ORDER BY soLuot DESC LIMIT 10";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.moveToNext()) {
                Top top = new Top();
                top.tenSach = cursor.getString(0);
                top.soLuong = cursor.getInt(1);
                list.add(top);
                cursor.moveToNext();
            }
        }
        return list;
    }
    // thong ke doanh thu
    public int getDoanhThu(String dayStart, String dayEnd){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = "SELECT SUM(TienThue)  FROM PHIEUMUON WHERE NgayMuon BETWEEN ? AND ?";
        ArrayList<Integer> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(query,new String[]{dayStart,dayEnd});
        while (cursor.moveToNext()){
            try {
                int doanhThu = cursor.getInt(0);
                list.add(doanhThu);
            }catch (Exception e){
                list.add(0);
            }
        }
        return list.get(0);
    }
}
