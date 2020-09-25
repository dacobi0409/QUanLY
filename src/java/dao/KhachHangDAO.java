/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KhachHang;
import java.util.List;

/**
 *
 * @author LongLD
 */
public interface KhachHangDAO {
    
    public List<KhachHang> getAllCustomer();
    public KhachHang getCustomerById(Integer maKH);
    public boolean deleteCustomer(Integer maKH);
    public KhachHang getCustomerIsLive();
    public List<KhachHang> checkCustomerAccount(String taiKhoan,String matKhau);
    public List<KhachHang> checkCustomerAccountTK(String taiKhoan);
    public boolean setStatusCustomerTrue(String taiKhoan,String matKhau);
    public boolean setStatusCustomerFalse();
    public boolean insertCustomer(KhachHang k);
    public List<KhachHang> checkCustomerOnline();
}
