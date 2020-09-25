/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KhachHang;
import entity.LienHe;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Administrator
 */
public class LienHeDAOImpl implements LienHeDAO{
    private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public boolean insertContact(LienHe c) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(c);
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
    public List<LienHe> getAllContact() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from LienHe").list();
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
    public boolean deleteContact(Integer maLienHe) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            int i = session.createQuery("delete from LienHe where maLienHe = :maLienHe")
                    .setParameter("maLienHe", maLienHe)
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
    public List<KhachHang> getAllCustomer() {
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
    public boolean deleteCustomerContact(Integer maKH) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            int i = session.createQuery("delete from LienHe where maKH ="+maKH+"")
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
