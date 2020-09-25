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
import entity.Users;
import org.hibernate.criterion.Projections;

/**
 *
 * @author LongLD
 */
public class userDAOimpl implements userDAO{
    private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<Users> getAllUsers() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from Users").list();
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
    public boolean insertUser(Users u) {
    Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(u);
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
    public boolean updateUser(Users u) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(u);
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
    public Users getUserById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Users u = (Users) session.createQuery("from Users where id = :id")
                    .setParameter("id", id)
                    .uniqueResult();
            session.getTransaction().commit();
            session.close();
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }

    @Override
    public boolean deleteUser(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            int i = session.createQuery("delete from Users where id = :id")
                    .setParameter("id", id)
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
    public List<Users> getAllUsersPage(Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from Users")
                    .setFirstResult(offset==null?0:offset)
                    .setMaxResults(maxResult==null?10:maxResult)
                    .list();
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
    public long getTotalUsers() {
    Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            long total = session.createQuery("from Users")
                    .list()
                    .size();
            session.getTransaction().commit();
            session.close();
            return total;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return 0L;  // 0L  : L ky hieu cua Long
    }

    @Override
    public List<Users> SearchUsers(String ksUser) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from Users where id="+ksUser.trim()+" or HoTen Like '%"+ksUser.trim()+"%' ").list();
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
    public List<Users> checkUserAccount(String taiKhoan,String matKhau){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from Users where taiKhoan='"+taiKhoan.trim()+"' and matKhau='"+matKhau.trim()+"' ").list();
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
    public boolean setStatus(String taiKhoan,String matKhau){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            int i = session.createQuery("update Users set TrangThaiUser=1 where taiKhoan='"+taiKhoan.trim()+"' and matKhau='"+matKhau.trim()+"'")
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
    public boolean setStatusUserfalse(){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            int i = session.createQuery("update Users set TrangThaiUser=0")
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
    
    public List<Users> checkUserIsAdmin(){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from Users where TrangThaiUser=1 and phanQuyen=0").list();
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
    public List<Users> checkUserIsEmp() {
    Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from Users where TrangThaiUser=1").list();
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
