/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.KhachHang;
import java.util.List;
import entity.Users;

/**
 *
 * @author LongLD
 */
public interface userDAO {
    public List<Users> getAllUsers();
    public boolean insertUser(Users u);
    public boolean updateUser(Users u);
    public Users getUserById(Integer Id);
    public boolean deleteUser(Integer Id);
    public List<Users> SearchUsers(String ksUser);
    public List<Users> getAllUsersPage(Integer offset, Integer maxResults);
    public long getTotalUsers();
    
    public List<Users> checkUserAccount(String taiKhoan,String matKhau);
    public boolean setStatus(String taiKhoan,String matKhau);
    public boolean setStatusUserfalse();
    public List<Users> checkUserIsAdmin();
    public List<Users> checkUserIsEmp();
    
    
}
