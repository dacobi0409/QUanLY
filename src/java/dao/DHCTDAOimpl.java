/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.DonHangChitiet;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LongLD
 */
public class DHCTDAOimpl implements DHCTDAO{
    
    private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<DonHangChitiet> getAllDonHangCT() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from DonHangChitiet").list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }
    @Override
    public boolean deleteDHCT(Integer maDonHang) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            int i = session.createQuery("delete from DonHangChitiet where maDHCT="+maDonHang+"")
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return false;
    }
    
    @Override
    public boolean deleteDHCT1(Integer maDonHang) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            int i = session.createQuery("delete from DonHangChitiet where maDonHang="+maDonHang+"")
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
            if(i>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return false;
    }

    @Override
    public List<DonHangChitiet> getDonHangCTDH(Integer maDHCT) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from DonHangChitiet  where MaDonHang="+maDHCT+"").list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }
}
