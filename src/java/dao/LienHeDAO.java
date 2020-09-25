/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KhachHang;
import entity.LienHe;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface LienHeDAO {
    public boolean insertContact(LienHe c);
    public List<LienHe> getAllContact();
    public boolean deleteContact(Integer maLienHe);
    public boolean deleteCustomerContact(Integer maKH);
    public List<KhachHang> getAllCustomer();
}
