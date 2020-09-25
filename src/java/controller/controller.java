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
import javax.validation.Valid;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import dao.productDAO;
import dao.userDAO;
import entity.DanhMucSanPham;
import entity.DonHang;
import entity.DonHangChitiet;
import entity.LienHe;
import entity.SanPham;
import entity.Users;
import java.util.Map;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Administrator
 */
@Controller
public class controller {
    private productDAO productdao;
    private LienHeDAO lienHeDAO;
    private userDAO userdao;
    private DHCTDAO dhctdao;
    private KhachHangDAO khachhangdao;
    
    @Autowired
    public void setKhachhangdao(KhachHangDAO khachhangdao) {
        this.khachhangdao = khachhangdao;
    }
    
    @Autowired
    public void setDhctdao(DHCTDAO dhctdao) {
        this.dhctdao = dhctdao;
    }
            
    @Autowired
    public void setUserdao(userDAO userdao) {
        this.userdao = userdao;
    }
    
    @Autowired
    public void setLienHeDAO(LienHeDAO lienHeDAO) {
        this.lienHeDAO = lienHeDAO;
    }
    @Autowired
    public void setProductdao(productDAO productdao) {
        this.productdao = productdao;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        s.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }
    @RequestMapping("/adminIndex")
    public String adminIndex(HttpSession session,Model model, HttpServletRequest request,Integer offset, Integer maxResult){
        if(checkIsEmp1()==true){
            String success = request.getParameter("mes");
            model.addAttribute("success", success);
            return "adminIndex";
        }
        else if( checkIsAd()==true){
            String success = request.getParameter("mes");
            model.addAttribute("success", success);
            return "adminIndex";
        }
        else{
            model.addAttribute("errors", "Chưa đăng nhập");
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
    }
    
    @RequestMapping("/listProduct")
    public String listProduct(Model model, HttpServletRequest request) {
        if(checkIsAd()==true){
        String success = request.getParameter("mes");
        model.addAttribute("success", success);
        List<SanPham> allProducts = productdao.getAllProducts();
        model.addAttribute("list", allProducts);
        return "listProduct";
        }
        else if( checkIsAd()==true){
        String success = request.getParameter("mes");
        model.addAttribute("success", success);
        List<SanPham> allProducts = productdao.getAllProducts();
        model.addAttribute("list", allProducts);
        return "listProduct";
        }
        else{
            return "redirect:/index.htm";
        }
    }
    
    @RequestMapping("/allProduct")
    public String allProduct(Model model, HttpServletRequest request,Integer offset, Integer maxResult) {
        String success = request.getParameter("mes");
        model.addAttribute("success", success);
        List<SanPham> allProducts = productdao.getAllProducts();
        model.addAttribute("list", allProducts);
        return "allProduct";
    }
    @RequestMapping("/signOut")
    public String signOut(Model model, HttpServletRequest request) {
        userdao.setStatusUserfalse();
        List<SanPham> allSanPhams = productdao.getAllProducts();
        model.addAttribute("list", allSanPhams);
        return "redirect:/index.htm";
    }


    @RequestMapping("/initInsertProduct")
    public String initFormProduct(Model model) {
        if(checkIsAd()==true){
            List<DanhMucSanPham> alLCategories = productdao.getAllCategories();
            model.addAttribute("listCate", alLCategories);
            model.addAttribute("p", new SanPham());
            return "insertProduct";
        }
        else{
            return "adminIndex";
        }
    }

    @RequestMapping("/insertProduct")
    public String insertProduct(@ModelAttribute("p") SanPham p, BindingResult result, HttpServletRequest request, Model model) {
        
        if(result.hasErrors()){
            List<DanhMucSanPham> alLCategories = productdao.getAllCategories();
            model.addAttribute("listCate", alLCategories);
                model.addAttribute("p",p);
                model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin");
                return "insertProduct";
        }
        else{
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
                    //day la du lieu cua form
                    if (fieldName.equals("maSanPham.maSanPham")) {
                        SanPham s=new SanPham(Integer.parseInt(data));
                        System.out.println("1111   : "+Integer.parseInt(data));
                        p.setMaSanPham(Integer.parseInt(data));
                    }else if (fieldName.equals("tenSanPham")) {
                        p.setTenSanPham(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                        System.out.println("1111   : "+data);
                    } else if (fieldName.equals("maDM.maDM")) {
                        Integer mdm = Integer.parseInt(data);
                        DanhMucSanPham dm=new DanhMucSanPham(mdm);
                        p.setMaDM(dm);
                    } else if (fieldName.equals("giaGoc")) {
                        Integer giaGoc = Integer.parseInt(data);
                        p.setGiaGoc(giaGoc);
                    }else if (fieldName.equals("khuyenMai")) {
                        Integer khuyenMai = Integer.parseInt(data);
                        p.setKhuyenMai(khuyenMai);
                    }else if (fieldName.equals("moTaNgan")) {
                        p.setMoTaNgan(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }else if (fieldName.equals("moTaChiTiet")) {
                        p.setMoTaChiTiet(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }else if (fieldName.equals("soLuong")) {
                        Integer sl = Integer.parseInt(data);
                        p.setSoLuong(sl);
                    } else if (fieldName.equals("ngayThem")) {
                        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
                        Date expire = s.parse(data);
                        p.setNgayThem(expire);
                    }
                } else {
                    //day la du lieu cua anh
                    if (item.getFieldName().equals("urlAnh")) {
                        try{
                            item.write(new File(path + "/" + item.getName()));
                            p.setUrlAnh(item.getName());
                        }
                        catch(Exception e){
                            File f=new File(path + "/" + item.getName());
                            f.delete();
                            item.write(new File(path + "/" + item.getName()));
                            p.setUrlAnh(item.getName());
                        }
                        
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean bl = productdao.insertProduct(p);
        if (bl) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "redirect:/listProduct.htm?success=Insert successfully";
        } else {
            model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin");
            List<SanPham> allProducts = productdao.getAllProducts();
            List<DanhMucSanPham> alLCategories = productdao.getAllCategories();
            model.addAttribute("listCate", alLCategories);
            model.addAttribute("listProduct", allProducts);
            model.addAttribute("p", p);
            return "insertProduct";
        }
        }
    }
    
    @RequestMapping("/preUpdateProduct")
    public String preUpdateProduct(@RequestParam("maSanPham")Integer maSanPham, Model model){
        if(checkIsAd()==true){
            List<DanhMucSanPham> alLCategories = productdao.getAllCategories();
            model.addAttribute("listCate", alLCategories);
            SanPham sp = productdao.getProductById(maSanPham);
            model.addAttribute("p", sp);
            return "updateProduct";
        }
        else{
            return "adminIndex";
        }
    }
    
    @RequestMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("p")SanPham p,HttpServletRequest request,BindingResult result, Model model){
        try {
            //xu ly co dau
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        //lay duong dan cua thu muc images
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
                    //day la du lieu cua form
                    if (fieldName.equals("maSanPham")) {
                        SanPham s=new SanPham(Integer.parseInt(data));
                        p.setMaSanPham(Integer.parseInt(data));
                    }else if (fieldName.equals("tenSanPham")) {
                        p.setTenSanPham(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    } else if (fieldName.equals("maDM.maDM")) {
                        Integer mdm = Integer.parseInt(data);
                        DanhMucSanPham dm=new DanhMucSanPham(mdm);
                        p.setMaDM(dm);
                    } else if (fieldName.equals("giaGoc")) {
                        Integer giaGoc = Integer.parseInt(data);
                        p.setGiaGoc(giaGoc);
                    }else if (fieldName.equals("khuyenMai")) {
                        Integer khuyenMai = Integer.parseInt(data);
                        p.setKhuyenMai(khuyenMai);
                    }else if (fieldName.equals("moTaNgan")) {
                        p.setMoTaNgan(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }else if (fieldName.equals("moTaChiTiet")) {
                        p.setMoTaChiTiet(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }else if (fieldName.equals("soLuong")) {
                        Integer sl = Integer.parseInt(data);
                        p.setSoLuong(sl);
                    } else if (fieldName.equals("ngayThem")) {
                        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
                        Date expire = s.parse(data);
                        p.setNgayThem(expire);
                    }
                } else {
                    if (item.getFieldName().equals("urlAnh")) {
                        try{
                            item.write(new File(path + "/" + item.getName()));
                            p.setUrlAnh(item.getName());
                        }
                        catch(Exception e){
                            File f=new File(path + "/" + item.getName());
                            f.delete();
                            item.write(new File(path + "/" + item.getName()));
                            p.setUrlAnh(item.getName());
                        }
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean bl = productdao.updateProduct(p);
        if (bl) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "redirect:/listProduct.htm?success=Update successfully";
        } else {
            model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin!");
            List<DanhMucSanPham> alLCategories = productdao.getAllCategories();
            model.addAttribute("listCate", alLCategories);
            List<SanPham> allProducts = productdao.getAllProducts();
            model.addAttribute("listProduct", allProducts);
            model.addAttribute("p", p);
            return "updateProduct";
        }  
    }
    
    @RequestMapping("/DetailProduct")
    public String detailProduct(@RequestParam("maSanPham")Integer maSanPham, Model model){
        SanPham productById = productdao.getProductById(maSanPham);
        model.addAttribute("p", productById);
        return "detailProduct";
    }
    @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("maSanPham")Integer maSanPham, Model model){
        if(checkIsAd()==true){
            boolean bl = productdao.deleteProduct(maSanPham);
            if(bl){
                return "redirect:/listProduct.htm?mes=Delete successfully!";
            }else{
                return "redirect:/listProduct.htm?mes=Delete failed!";
            }
        }
        else{
            return "adminIndex";
        }
                
    }
    @RequestMapping("/lookUp")
    public String lookUpProduct(HttpServletRequest request,Model model){
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        String keySearch=request.getParameter("keySearch");
        System.out.println("1111: "+ keySearch);
        model.addAttribute("keySearch",keySearch);
        List<SanPham> productLFA= productdao.lookUpProductAdmin(keySearch);
        model.addAttribute("list", productLFA);
        return "listProduct";
    }
    
    @RequestMapping("/index")
    public String listProduct(Model model, HttpSession session,Integer offset, Integer maxResult) {
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
    @RequestMapping("/indexview")
    public String indexview(Model model, HttpSession session,Integer offset, Integer maxResult) {
        List<SanPham> sp = productdao.getAllProducts(offset, maxResult);
        model.addAttribute("list", sp);
        Map<Integer, Integer> listProductBuy = (Map<Integer, Integer>) session.getAttribute("listProductBuy");
        session.setAttribute("totalProductBuy", listProductBuy==null?0:listProductBuy.size());
        
        List<SanPham> allSanPhams = productdao.getAllProducts(offset, maxResult);
        model.addAttribute("list", allSanPhams);
        model.addAttribute("offset", offset==null?0:offset);
        model.addAttribute("maxResult", maxResult==null?8:maxResult);
        model.addAttribute("totalRecord", productdao.getTotalProducts());
        return "indexview";
    }
    
    @RequestMapping("/privacy")
    public String privacy(Model model, HttpSession session) {
        model.addAttribute("mes");
        return "privacy";
    }
    
    @RequestMapping("/indexfirst")
    public String listProductFirst(Model model,Integer offset, Integer maxResult) {
        List<SanPham> allSanPhams = productdao.getAllProducts(offset, maxResult);
        userdao.setStatusUserfalse();
        khachhangdao.setStatusCustomerFalse();
        model.addAttribute("list", allSanPhams);
        model.addAttribute("offset", offset==null?0:offset);
        model.addAttribute("maxResult", maxResult==null?8:maxResult);
        model.addAttribute("totalRecord", productdao.getTotalProducts());
        return "index";
    }
    
    @RequestMapping("/initAccount")
    public String initAccount(Model model) {
        return "account";
    }
    @RequestMapping("/men")
    public String sanPhamnam(Model model){
       List<SanPham> nam = productdao.getAllSanPhamNam();
       model.addAttribute("nam", nam);
       return "men";
    }
    @RequestMapping("/menAdmin")
    public String sanPhamnamad(Model model){
       List<SanPham> nam = productdao.getAllSanPhamNam();
       model.addAttribute("list", nam);
       return "listProduct";
    }
    @RequestMapping("/women")
    public String sanPhamnu(Model model){
        List<SanPham> nu = productdao.getAllSanPhamNu();
        model.addAttribute("nu", nu);
        return "women";
    }
    @RequestMapping("/womenAdmin")
    public String sanPhamnuad(Model model){
        List<SanPham> nu = productdao.getAllSanPhamNu();
        model.addAttribute("list", nu);
        return "listProduct";
    }
    
    
    @RequestMapping("/single")
    public String detailProductViews(@RequestParam("maSanPham")Integer maSanPham, Model model){
        SanPham productById = productdao.getProductById(maSanPham);
        model.addAttribute("p", productById);
        return "single";
    }
    
    @RequestMapping("/lookUpProduct")
    public String lookUpProductClientClient(HttpServletRequest request,Model model){
        String keySearchProduct=request.getParameter("keySearchProduct");
        model.addAttribute("keySearchProduct",keySearchProduct);
        List<SanPham> productLFC= productdao.lookUpProductAdmin(keySearchProduct);
        model.addAttribute("list", productLFC);
        return "index";
    }
    
    @RequestMapping("/allDHCT")
    public String allDHCT(Model model, HttpServletRequest request) {
        String success = request.getParameter("mes");
        model.addAttribute("success", success);
        List<DonHangChitiet> allDHCT = dhctdao.getAllDonHangCT();
        model.addAttribute("dhct", allDHCT);
        return "allOrderDetail";
    }
    
    @RequestMapping("/allDH")
    public String allDH(Model model, HttpServletRequest request) {
        String success = request.getParameter("mes");
        model.addAttribute("success", success);
        List<DonHang> allDH = productdao.getAllDonHang();
        model.addAttribute("list", allDH);
        return "orderDT";
    }
    
    
    
    @RequestMapping("/DetailOrder")
    public String detailOrderDT(@RequestParam("maDonHang")Integer maDonHang, Model model){
        List<DonHangChitiet> dhid= dhctdao.getDonHangCTDH(maDonHang);
        model.addAttribute("dhct",dhid);
        return "allOrderDetail";
    }
    
    @RequestMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("maDonHang")Integer maDonHang, Model model){
        if(checkIsAd()==true){
            dhctdao.deleteDHCT1(maDonHang);
            boolean bl = productdao.deleteDH(maDonHang);
            if(bl){
                return "redirect:/allDH.htm?mes=Delete successfully!";
            }else{
                return "redirect:/allDH.htm?mes=Delete failed!";
            }
        }
        else{
            return "adminIndex";
        }
                
    }
    
    
    @RequestMapping("/deleteOrderDT")
    public String deleteOrderDT(@RequestParam("maDHCT")Integer maDHCT, Model model){
        if(checkIsAd()==true){
            boolean bl = dhctdao.deleteDHCT(maDHCT);
            if(bl){
                return "redirect:/allDHCT.htm?mes=Delete successfully!";
            }else{
                return "redirect:/allDHCT.htm?mes=Delete failed!";
            }
        }
        else{
            return "adminIndex";
        }
                
    }
    public boolean checkIsAd(){
         List<Users> usersCheck= userdao.checkUserIsAdmin();
        int c=usersCheck.size();
        if (c==0){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean checkIsEmp1(){
         List<Users> usersCheck= userdao.checkUserIsEmp();
        int c=usersCheck.size();
        if (c==0){
            return false;
        }
        else{
            return true;
        }
    }
}

