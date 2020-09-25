/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.DanhMucSanPham;
import entity.DonHang;
import entity.DonHangChitiet;
import java.util.List;
import entity.SanPham;

/**
 *
 * @author Administrator
 */
public interface productDAO {
    public List<SanPham> getAllProducts();
    public List<DanhMucSanPham> getAllCategories();
    public boolean insertProduct(SanPham p);
    public boolean updateProduct(SanPham p);
    public SanPham getProductById(Integer maSanPham);
    public List<SanPham> lookUpProductAdmin(String keySearch);
    public boolean deleteProduct(Integer maSanPham);
    public List<SanPham> getAllSanPhamNam();
    public List<SanPham> getAllSanPhamNu();
    public List<SanPham> getAllProducts(Integer offset, Integer maxResult);
    public Long getTotalProducts();
    
    public boolean insertOrderProduct(DonHang dh);
    
    public boolean insertOrderDetail(DonHangChitiet dhct);
    public List<DonHang> getAllDonHang();
    
    
    public boolean deleteDH(Integer maDonHang);
    public boolean deleteDHKH(Integer maKH);
    public Integer getMaDHFCus(Integer maKH);
    
}
