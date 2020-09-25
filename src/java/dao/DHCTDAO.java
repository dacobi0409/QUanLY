/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.DonHangChitiet;
import java.util.List;

/**
 *
 * @author LongLD
 */
public interface DHCTDAO {
    public List<DonHangChitiet> getAllDonHangCT();
    public List<DonHangChitiet> getDonHangCTDH(Integer maDHCT);
    public boolean deleteDHCT(Integer maDonHang);
    public boolean deleteDHCT1(Integer maDonHang);
}
