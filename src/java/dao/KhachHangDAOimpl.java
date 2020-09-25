/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KhachHang;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LongLD
 */
public class KhachHangDAOimpl implements KhachHangDAO{
    
    private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<KhachHang> checkCustomerAccount(String taiKhoan, String matKhau) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from KhachHang where TaiKhoanKH='"+taiKhoan.trim()+"' and MatKhauKH='"+matKhau.trim()+"'").list();
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
    public boolean setStatusCustomerTrue(String taiKhoan, String matKhau) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            int i = session.createQuery("update KhachHang set TrangThaiKH=1 where TaiKhoanKH='"+taiKhoan.trim()+"' and MatKhauKH='"+matKhau.trim()+"'")
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
    public boolean setStatusCustomerFalse() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            int i = session.createQuery("update KhachHang set TrangThaiKH=0")
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
    public KhachHang getCustomerIsLive() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            KhachHang kh = (KhachHang) session.createQuery("from KhachHang where TrangThaiKH=1")
                    .uniqueResult();
            session.getTransaction().commit();
            session.close();
            return kh;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }
    @Override
    public boolean insertCustomer(KhachHang k) {
    Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(k);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return false;
    }

    @Override
    public List<KhachHang> checkCustomerOnline() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from KhachHang where TrangThaiKH=1").list();
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
    public List<KhachHang> checkCustomerAccountTK(String taiKhoan) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from KhachHang where TaiKhoanKH='"+taiKhoan.trim()+"'").list();
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
    public List<KhachHang> getAllCustomer() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from KhachHang").list();
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
    public KhachHang getCustomerById(Integer maKH) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCustomer(Integer maKH) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            int i = session.createQuery("delete from KhachHang where MaKH = :maKH")
                    .setParameter("maKH", maKH)
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
    
}
