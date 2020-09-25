/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.DanhMucSanPham;
import entity.DonHang;
import entity.DonHangChitiet;
import entity.SanPham;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Administrator
 */
public class productDAOimpl implements productDAO{
    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<SanPham> getAllProducts() {
       Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from SanPham").list();
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
    public List<DanhMucSanPham> getAllCategories() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from DanhMucSanPham").list();
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
    public boolean insertProduct(SanPham p) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(p);
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
    public boolean updateProduct(SanPham sp) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(sp);
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
    public SanPham getProductById(Integer maSanPham) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            SanPham p = (SanPham) session.createQuery("from SanPham where maSanPham = :maSanPham")
                    .setParameter("maSanPham", maSanPham)
                    .uniqueResult();
            session.getTransaction().commit();
            session.close();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }

    @Override
    public boolean deleteProduct(Integer maSanPham) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            int i = session.createQuery("delete from SanPham where maSanPham = :maSanPham")
                    .setParameter("maSanPham", maSanPham)
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
    public List<SanPham> lookUpProductAdmin(String keySearch) {
    Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            try {
                List list = session.createQuery("from SanPham where maSanPham="+keySearch.trim()+" or TenSanPham Like '%"+keySearch.trim()+"%'").list();
                session.getTransaction().commit();
                session.close();
            return list;
            } catch (Exception e) {
                List list = session.createQuery("from SanPham where TenSanPham Like '%"+keySearch.trim()+"%'").list();
                session.getTransaction().commit();
                session.close();
            return list;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }
    @Override
   public List<SanPham> getAllSanPhamNam() {
      Session session = sessionFactory.openSession();
      try{
            session.beginTransaction();
            List nam = session.createQuery("from SanPham where MaDM = 1").list();
            session.getTransaction().commit();
            session.close();
            return nam;
      }catch(Exception e ){
         e.printStackTrace();
         session.getTransaction().rollback();
         session.close();
      }
      return null;
   }

   @Override
   public List<SanPham> getAllSanPhamNu() {
      Session session = sessionFactory.openSession();
      try{
            session.beginTransaction();
            List nu = session.createQuery("from SanPham where MaDM = 2").list();
            session.getTransaction().commit();
            session.close();
            return nu;
      }catch(Exception e ){
         e.printStackTrace();
         session.getTransaction().rollback();
         session.close();
      }
      return null;
   }

    @Override
    public boolean insertOrderProduct(DonHang dh) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(dh);
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
    public boolean insertOrderDetail(DonHangChitiet dhct) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(dhct);
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
   public List<SanPham> getAllProducts(Integer offset, Integer maxResult) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from SanPham")
                    .setFirstResult(offset==null?0:offset)
                    .setMaxResults(maxResult==null?8:maxResult)
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
   public Long getTotalProducts() {
      Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            long total = session.createQuery("from SanPham")
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
        return 0L; 
   }

    @Override
    public List<DonHang> getAllDonHang() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from DonHang").list();
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
    public boolean deleteDH(Integer maDonHang) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            int i = session.createQuery("delete from DonHang where maDonHang="+maDonHang+"")
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
    public boolean deleteDHKH(Integer maKH) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            int i = session.createQuery("delete from DonHang where maKH="+maKH+"")
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
    public Integer getMaDHFCus(Integer maKH) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query a=session.createQuery("delete from DonHang where MaKH="+maKH+"");
            a.executeUpdate();
            
            session.getTransaction().commit();
            session.close();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            return 0;
        }
        
    }

}
