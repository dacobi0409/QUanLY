/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author LongLD
 */
public class SanPhamDH extends SanPham{
    private int tongSanPham;
    private int tongTienTT;

    public SanPhamDH() {
    }

    public SanPhamDH(int tongSanPham, int tongTienTT) {
        this.tongSanPham = tongSanPham;
        this.tongTienTT = tongTienTT;
    }

    public int getTongSanPham() {
        return tongSanPham;
    }

    public void setTongSanPham(int tongSanPham) {
        this.tongSanPham = tongSanPham;
    }

    public int getTongTienTT() {
        return tongTienTT;
    }

    public void setTongTienTT(int tongTienTT) {
        this.tongTienTT = tongTienTT;
    }
    
    
}