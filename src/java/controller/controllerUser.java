/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DHCTDAO;
import dao.KhachHangDAO;
import dao.LienHeDAO;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import dao.productDAO;
import dao.userDAO;
import entity.DonHang;
import entity.KhachHang;
import entity.SanPham;
import entity.Users;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;


/**
 *
 * @author Administrator
 */
@Controller
public class controllerUser {
   private userDAO userdao;
   private KhachHangDAO khachhangdao;
   private productDAO productdao;
   private LienHeDAO lienhedao;
   private DHCTDAO dhctdao;
   @Autowired
   public void setDhctdao(DHCTDAO dhctdao) {
        this.dhctdao = dhctdao;
    }
   
   @Autowired
    public void setLienhedao(LienHeDAO lienhedao) {
        this.lienhedao = lienhedao;
    }

    
   
   @Autowired
    public void setProductdao(productDAO productdao) {
        this.productdao = productdao;
    }

    
   
   @Autowired
    public void setKhachhangdao(KhachHangDAO khachhangdao) {
        this.khachhangdao = khachhangdao;
    }
   
   
    @Autowired
    public void setUserdao(userDAO userdao) {
        this.userdao = userdao;
    }
    

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        s.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    

    @RequestMapping("/allUser")
    public String listUser(Model model, HttpServletRequest request) {
        if(checkIsEmp()==true){
            String success = request.getParameter("mes");
            model.addAttribute("success", success);
            List<Users> allUsers = userdao.getAllUsers();
            model.addAttribute("list", allUsers);
          return "allUser";
        }
        else{
            return "redirect:/index.htm";
        }
        
    }
    @RequestMapping("/allKH")
    public String allCustomer(Model model, HttpServletRequest request) {
        if(checkIsAd1()==true){
            String success = request.getParameter("mes");
            model.addAttribute("success", success);
            List<KhachHang> allCus = khachhangdao.getAllCustomer();
            model.addAttribute("list", allCus);
          return "allCustomer";
        }
        else{
            return "redirect:/index.htm";
        }
        
    }
    
    

    @RequestMapping("/initInsertUser")
    public String initFormUser(Model model) {
        if(checkIsAd1()==true){
            model.addAttribute("u", new Users());
            return "insertUser";
        }
        else{
            return "redirect:/index.htm";
        }
        
    }
    
    @RequestMapping("/insertUser")
    public String insertUser( @ModelAttribute("u") Users u,HttpServletRequest request,BindingResult result, Model model) {
        
            
        try {
            //xu ly co dau
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        //duong dan cua thu muc img 
        String path = request.getRealPath("resources/images");
        path = path.substring(0, path.indexOf("build"));
        path = path + "web\\resources\\images";
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> listItems = upload.parseRequest(request);

            for (FileItem item : listItems) {
                String fieldName = item.getFieldName(); //ten phan tu cua form
                String data = item.getString();  //du lieu cua phan tu do

                if (item.isFormField()) {
                    if (fieldName.equals("id")) {
                        Users us=new Users(Integer.parseInt(data));
                        u.setId(Integer.parseInt(data));
                    }
                    else if (fieldName.equals("taiKhoan")) {
                        u.setTaiKhoan(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("matKhau")) {
                        u.setMatKhau(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("hoTen")) {
                        u.setHoTen(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("gioiTinh")) {
                        Integer gt=Integer.parseInt(data);
                        u.setGioiTinh(gt);
                    }else if (fieldName.equals("ngaySinh")) {
                        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
                        Date ns = s.parse(data);
                        u.setNgaySinh(ns);
                    }
                    else if (fieldName.equals("email")) {
                        u.setEmail(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("diaChi")) {
                        u.setDiaChi(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("soDienThoai")) {
                        u.setSoDienThoai(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("phanQuyen")) {
                        Integer pq=Integer.parseInt(data);
                        u.setPhanQuyen(pq);
                        
                    }
                } 
                else {
                    if (item.getFieldName().equals("urlAnhUser")) {
                        try{
                            item.write(new File(path + "/" + item.getName()));
                            u.setUrlAnhUser(item.getName());
                        }
                        catch (Exception e){
                            File f=new File(path + "/" + item.getName());
                            f.delete();
                            item.write(new File(path + "/" + item.getName()));
                            u.setUrlAnhUser(item.getName());
                        }
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result.hasErrors()){
            model.addAttribute("u",u);
            return "insertUser";
        }
        else{
        boolean bl = userdao.insertUser(u);
        if (bl) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "redirect:/allUser.htm?success=Insert successfully";
        } else {
            model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin!");
            List<Users> allUsers = userdao.getAllUsers();
            model.addAttribute("allUser", allUsers);
            model.addAttribute("u", u);
            return "insertUser";
        }       
    }
}
    
    
    
    @RequestMapping("/insertUserRegister")
    public String insertUserRegister(@ModelAttribute("u") Users u,HttpServletRequest request, Model model) {
        try {
            //xu ly co dau
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        //duong dan cua thu muc img 
        String path = request.getRealPath("resources/images");
        path = path.substring(0, path.indexOf("build"));
        path = path + "web\\resources\\images";
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> listItems = upload.parseRequest(request);

            for (FileItem item : listItems) {
                String fieldName = item.getFieldName(); //ten phan tu cua form
                String data = item.getString();  //du lieu cua phan tu do

                if (item.isFormField()) {
                    if (fieldName.equals("id")) {
                        Users us=new Users(Integer.parseInt(data));
                        u.setId(Integer.parseInt(data));
                    }
                    else if (fieldName.equals("taiKhoan")) {
                        u.setTaiKhoan(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("matKhau")) {
                        u.setMatKhau(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("hoTen")) {
                        u.setHoTen(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("gioiTinh")) {
                        Integer gt=Integer.parseInt(data);
                        u.setGioiTinh(gt);
                    }else if (fieldName.equals("ngaySinh")) {
                        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
                        Date ns = s.parse(data);
                        u.setNgaySinh(ns);
                    }
                    else if (fieldName.equals("email")) {
                        u.setEmail(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("diaChi")) {
                        u.setDiaChi(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("soDienThoai")) {
                        u.setSoDienThoai(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("phanQuyen")) {
                        Integer pq=Integer.parseInt(data);
                        u.setPhanQuyen(pq);
                        
                    }
                } 
                else {
                    if (item.getFieldName().equals("urlAnhUser")) {
                        try{
                            item.write(new File(path + "/" + item.getName()));
                            u.setUrlAnhUser(item.getName());
                        }
                        catch (Exception e){
                            File f=new File(path + "/" + item.getName());
                            f.delete();
                            item.write(new File(path + "/" + item.getName()));
                            u.setUrlAnhUser(item.getName());
                        }
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean bl = userdao.insertUser(u);
        userdao.setStatusUserfalse();
        if (bl) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "redirect:/indexview.htm?success=Insert successfully";
        } else {
            model.addAttribute("error", "Insert failed!");
            List<Users> allUsers = userdao.getAllUsers();
            model.addAttribute("allUser", allUsers);
            model.addAttribute("u", u);
            return "signup";
        }       
    }
    
    @RequestMapping("/preUpdateUser")
    public String preUpdateUser(@RequestParam("id")Integer id, Model model){
        if(checkIsAd1()==true){
            Users us = userdao.getUserById(id);
            model.addAttribute("u", us);
            return "updateUser";
        }
        else{
            return "redirect:/index.htm";
        }
        
    }
    
    @RequestMapping("/updateUser")
    public String updateProduct(@ModelAttribute("u") Users u,HttpServletRequest request,BindingResult result, Model model){
        
        try {
            //xu ly co dau
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        //duong dan cua thu muc img 
        String path = request.getRealPath("resources/images");
        path = path.substring(0, path.indexOf("build"));
        path = path + "web\\resources\\images";
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> listItems = upload.parseRequest(request);

            for (FileItem item : listItems) {
                String fieldName = item.getFieldName(); //ten phan tu cua form
                String data = item.getString();  //du lieu cua phan tu do

                if (item.isFormField()) {
                    if (fieldName.equals("id")) {
                        Users us=new Users(Integer.parseInt(data));
                        u.setId(Integer.parseInt(data));
                    }
                    else if (fieldName.equals("taiKhoan")) {
                        u.setTaiKhoan(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("matKhau")) {
                        u.setMatKhau(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("hoTen")) {
                        u.setHoTen(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("gioiTinh")) {
                        Integer gt=Integer.parseInt(data);
                        u.setGioiTinh(gt);
                    }else if (fieldName.equals("ngaySinh")) {
                        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
                        System.out.println("sssssssssss :123123  "+data);
                        Date ns = s.parse(data);
                        u.setNgaySinh(ns);
                        System.out.println("datetetetet   " +ns);
                    }
                    else if (fieldName.equals("email")) {
                        u.setEmail(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("diaChi")) {
                        u.setDiaChi(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("soDienThoai")) {
                        u.setSoDienThoai(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("phanQuyen")) {
                        Integer pq=Integer.parseInt(data);
                        u.setPhanQuyen(pq);
                        
                    }
                } 
                else {
                    if (item.getFieldName().equals("urlAnhUser")) {
                        try{
                            item.write(new File(path + "/" + item.getName()));
                            u.setUrlAnhUser(item.getName());
                        }
                        catch (Exception e){
                            File f=new File(path + "/" + item.getName());
                            f.delete();
                            item.write(new File(path + "/" + item.getName()));
                            u.setUrlAnhUser(item.getName());
                        }
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(result.hasErrors()){
            model.addAttribute("u",u);
            return "updateUser";
        }
        else{
        boolean bl = userdao.updateUser(u);
        if (bl) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "redirect:/allUser.htm?success= successfully";
        } else {
            model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin!");
            List<Users> allUsers = userdao.getAllUsers();
            model.addAttribute("allUser", allUsers);
            model.addAttribute("u", u);
            return "updateUser";
        }  
    }
   }
    
    @RequestMapping("/insertCustomerRegister")
    public String insertCustomerRegister(@Valid @ModelAttribute("k") KhachHang k,BindingResult result,HttpServletRequest request, Model model) {
        if(result.hasErrors()){
                
                model.addAttribute("tb", "Vui lòng nhập đầy đủ thông tin");
                return "signupc";
        }
        else{
        try {
            //xu ly co dau
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> listItems = upload.parseRequest(request);

            for (FileItem item : listItems) {
                String fieldName = item.getFieldName(); //ten phan tu cua form
                String data = item.getString();  //du lieu cua phan tu do

                if (item.isFormField()) {
                    if (fieldName.equals("maKH")) {
                        KhachHang kh=new KhachHang(Integer.parseInt(data));
                        k.setMaKH(Integer.parseInt(data));
                    }
                    else if (fieldName.equals("taiKhoanKH")) {
                        k.setTaiKhoanKH(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("matKhauKH")) {
                        k.setMatKhauKH(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                        k.setSoTienMua(0);
                    }
                    else if (fieldName.equals("hoTenKH")) {
                        k.setHoTenKH(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("diaChiKH")) {
                        k.setDiaChiKH(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                    else if (fieldName.equals("soDienThoaiKH")) {
                        k.setSoDienThoaiKH(Integer.parseInt(data));
                    }
                } 
            }
        } catch (Exception ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("11111123123"+k.getHoTenKH()+"   "+k.getMatKhauKH());
        if(checkCustomerAcc(k.getTaiKhoanKH())){
            model.addAttribute("tb", "Tên tài khoản  đã tồn tại!");
            model.addAttribute("k", k);
            return "signupc";
        }
        else{
            
        
        boolean bl = khachhangdao.insertCustomer(k);
        if (bl) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            }   
            model.addAttribute("tb", "Đăng ký thành công!");
            return "signupc";
        } else {
            model.addAttribute("error", "Register failed!");
            model.addAttribute("k", k);
            return "signupc";
        }        
        }

        }
    }
    
    @RequestMapping("/detailUser")
    public String profileUser(@RequestParam("id")Integer id, Model model){
        Users userById = userdao.getUserById(id);
        model.addAttribute("u", userById);
        return "profile";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id")Integer id, Model model){
        if(checkIsAd1()==true){
            boolean bl = userdao.deleteUser(id);
            if(bl){
                return "redirect:/allUser.htm?mes=Delete successfully!";
            }else{
                return "redirect:/allUser.htm?mes=Delete failed!";
            }   
        }
        else{
            return "redirect:/index.htm";
        }     
    }
    @RequestMapping("/deleteCustomerAD")
    public String deleteCustomer(@RequestParam("maKH")Integer maKH, Model model){
        if(checkIsAd1()==true){
            try {
                
            
            //xoa lien he
            lienhedao.deleteCustomerContact(maKH);
            
            //xoa dhct
            Integer madonhang=productdao.getMaDHFCus(maKH);
                System.out.println("mmmmmam    "+madonhang);
            dhctdao.deleteDHCT(madonhang);
            productdao.deleteDHKH(maKH);
            //xoa Customer
            boolean bl = khachhangdao.deleteCustomer(maKH);
            if(bl){
                return "redirect:/allKH.htm?mes=Delete successfully!";
            }else{
                return "redirect:/allKH.htm?mes=Delete failed!";
            }
            } catch (Exception e) { 
                return "redirect:/allKH.htm";
            }   
        }
        else{
            return "redirect:/index.htm";
        }     
    }
    
    @RequestMapping("/account")
    public String listUsers(Model model) {
        if(checkIsAd1()==true){
            List<Users> allUsers = userdao.getAllUsers();
            model.addAttribute("allUsers", allUsers);
            return "account";
        }
        else{
            return "redirect:/index.htm";
        }
        
    }
    
    //Phan trang
    
    @RequestMapping("/loadUsers")
    public String listStudent(Model model, Integer offset, Integer maxResult){      
        List<Users> allStudents = userdao.getAllUsersPage(offset, maxResult);
        model.addAttribute("list", allStudents);
        model.addAttribute("offset", offset==null?0:offset);
        model.addAttribute("maxResult", maxResult==null?10:maxResult);
        model.addAttribute("totalRecord", userdao.getTotalUsers());
        return "allUsers";
    }
    
    @RequestMapping("/signup")
    public String dangKy(Model model){
        model.addAttribute("u", new Users());
        return "signup";
    }
    
    @RequestMapping("/login")
    public String dangNhap(Model model){
        return "login";
    }
    
    @RequestMapping("/signupC")
    public String dangKyC(Model model){
        
        model.addAttribute("k", new KhachHang());
        return "signupc";
    }
    
    @RequestMapping("/loginC")
    public String dangNhapC(Model model){
        return "loginc";
    }
    
    @RequestMapping("/signoutC")
    public String dangXuatC(Model model, HttpSession session,Integer offset, Integer maxResult){
        khachhangdao.setStatusCustomerFalse();
        List<SanPham> sp = productdao.getAllProducts(offset, maxResult);
        model.addAttribute("list", sp);
        Map<Integer, Integer> listProductBuy = (Map<Integer, Integer>) session.getAttribute("listProductBuy");
        session.setAttribute("totalProductBuy", listProductBuy==null?0:listProductBuy.size());
        List<SanPham> allSanPhams = productdao.getAllProducts(offset, maxResult);
        model.addAttribute("list", allSanPhams);
        model.addAttribute("offset", offset==null?0:offset);
        model.addAttribute("maxResult", maxResult==null?8:maxResult);
        model.addAttribute("totalRecord", productdao.getTotalProducts());
        return "index";
    }
    @RequestMapping("/signout")
    public String signout(Model model, HttpSession session,Integer offset, Integer maxResult){
        userdao.setStatusUserfalse();
        List<SanPham> sp = productdao.getAllProducts(offset, maxResult);
        model.addAttribute("list", sp);
        Map<Integer, Integer> listProductBuy = (Map<Integer, Integer>) session.getAttribute("listProductBuy");
        session.setAttribute("totalProductBuy", listProductBuy==null?0:listProductBuy.size());
        List<SanPham> allSanPhams = productdao.getAllProducts(offset, maxResult);
        model.addAttribute("list", allSanPhams);
        model.addAttribute("offset", offset==null?0:offset);
        model.addAttribute("maxResult", maxResult==null?8:maxResult);
        model.addAttribute("totalRecord", productdao.getTotalProducts());
        return "index";
    }
    @RequestMapping("/lookupUser")
    public String lookUpUser(HttpServletRequest request,Model model){
        String ksUser=request.getParameter("ksUser");
        model.addAttribute("ksUser",ksUser);
        List<Users> userss= userdao.SearchUsers(ksUser);
        model.addAttribute("list", userss);
        return "allUser";
    }
    
    @RequestMapping("/btnDangNhap")
    public String btnDangNhap(HttpServletRequest request,Model model){
        String taiKhoan=request.getParameter("taiKhoan");
        model.addAttribute("taiKhoan",taiKhoan.trim());
        String matKhau=request.getParameter("matKhau");
        model.addAttribute("matKhau",matKhau.trim());
            System.out.println("Đã getTHong tin");
        
        List<Users> usersChecked= userdao.checkUserAccount(taiKhoan, matKhau);
        int c=usersChecked.size();
        if (c==0){
            return "login";
        }
        else{
            userdao.setStatusUserfalse();
            khachhangdao.setStatusCustomerFalse();
            userdao.setStatus(taiKhoan, matKhau);
            return "redirect:/index.htm";
        }
    }
    
    @RequestMapping("/btnDangNhapKH")
    public String btnDangNhapKH(HttpServletRequest request,Model model){
        String taiKhoanKH=request.getParameter("taiKhoanKH");
        model.addAttribute("taiKhoanKH",taiKhoanKH  .trim());
        String matKhauKH=request.getParameter("matKhauKH");
        model.addAttribute("matKhauKH",matKhauKH.trim());
        
        List<KhachHang> khChecked= khachhangdao.checkCustomerAccount(taiKhoanKH, matKhauKH);
        System.out.println("111111" +taiKhoanKH+"  "+matKhauKH);
        int k=khChecked.size();
        if (k==0){
            model.addAttribute("tb","Đăng nhập không thành công");
            return "loginc";
        }
        else{
            userdao.setStatusUserfalse();
            khachhangdao.setStatusCustomerFalse();
            khachhangdao.setStatusCustomerTrue(taiKhoanKH, matKhauKH);
            model.addAttribute("errors","Đăng nhập thành công");
            return "redirect:/index.htm?errors=Đăng nhập thanh cong";
        }
    }
    public boolean checkIsAd1(){
         List<Users> usersCheck= userdao.checkUserIsAdmin();
        int c=usersCheck.size();
        if (c==0){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean checkIsEmp(){
         List<Users> usersCheck= userdao.checkUserIsEmp();
        int c=usersCheck.size();
        if (c==0){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean checkCustomerAcc(String taiKhoan){
         List<KhachHang> cusCheck= khachhangdao.checkCustomerAccountTK(taiKhoan);
        int c=cusCheck.size();
        if (c==0){
            return false;
        }
        else{
            return true;
        }
    }
}
