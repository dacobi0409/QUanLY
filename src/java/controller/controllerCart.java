/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KhachHangDAO;
import dao.LienHeDAO;
import dao.productDAO;
import dao.userDAO;
import entity.DonHang;
import entity.DonHangChitiet;
import entity.KhachHang;
//import entity.KhachHangDH;
import entity.SanPham;
import entity.SanPhamDH;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author LongLD
 */
@Controller
public class controllerCart {
    private productDAO productdao;
    private userDAO userdao;
    private KhachHangDAO khachhangdao;
    
    @Autowired
    public void setKhachhangdao(KhachHangDAO khachhangdao) {
        this.khachhangdao = khachhangdao;
    }
    
    @Autowired
    public void setProductdao(productDAO productdao) {
        this.productdao = productdao;
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

    @RequestMapping("/addToCar")
    public String addToCart(@RequestParam("maSanPham") Integer maSanPham, HttpSession session) {
        Map<Integer, Integer> listProductBuy = (Map<Integer, Integer>) session.getAttribute("listProductBuy");

        if (listProductBuy == null) {
            listProductBuy = new HashMap<>();
            listProductBuy.put(maSanPham, 1);
        } else {
            boolean isBought = false;
            for (Map.Entry<Integer, Integer> sp : listProductBuy.entrySet()) {
                Integer key = sp.getKey();
                Integer value = sp.getValue();
                if (key == maSanPham) {
                    listProductBuy.remove(key);
                    isBought = true;
                    listProductBuy.put(key, value + 1);
                    break;
                }
            }
            if (!isBought) {
                listProductBuy.put(maSanPham, 1);
            }
        }

        session.setAttribute("listProductBuy", listProductBuy);
        return "redirect:/index.htm";
    }
    
    @RequestMapping("/removeProductCart")
    public String removeCart(@RequestParam("maSanPham") Integer maSanPham, HttpSession session) {
        Map<Integer, Integer> listProductBuy = (Map<Integer, Integer>) session.getAttribute("listProductBuy");

        
            boolean isBought = false;
            for (Map.Entry<Integer, Integer> sp : listProductBuy.entrySet()) {
                Integer key = sp.getKey();
                Integer value = sp.getValue();
                if (key == maSanPham) {
                    listProductBuy.remove(key);
                    isBought = true;
                    break;
                }
            }
        
        session.setAttribute("totalProductBuy", listProductBuy==null?0:listProductBuy.size());
        session.setAttribute("listProductBuy", listProductBuy);
        return "redirect:/viewCart.htm";
    }
    
    @RequestMapping("/viewCart")
    public String viewCart(HttpSession session, Model model, HttpServletRequest request,Integer offset, Integer maxResult) {
        try {
        Map<Integer, Integer> listProductBuy = (Map<Integer, Integer>) session.getAttribute("listProductBuy");
        
        List<SanPhamDH> listBuy = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pro : listProductBuy.entrySet()) {
            Integer key = pro.getKey();
            Integer value = pro.getValue();

            SanPham p = productdao.getProductById(key);
            SanPhamDH spdh = new SanPhamDH();
            spdh.setMaSanPham(p.getMaSanPham());
            spdh.setNgayThem(p.getNgayThem());
            spdh.setUrlAnh(p.getUrlAnh());
            spdh.setGiaGoc(p.getGiaGoc());
            spdh.setKhuyenMai(p.getKhuyenMai());
            spdh.setTenSanPham(p.getTenSanPham());
            spdh.setMaDM(p.getMaDM());
            spdh.setMoTaNgan(p.getMoTaNgan());
            spdh.setMoTaChiTiet(p.getMoTaChiTiet());
            spdh.setSoLuong(p.getSoLuong());
            spdh.setTongSanPham(value);
            spdh.setTongTienTT(spdh.getKhuyenMai() * spdh.getTongSanPham());
            listBuy.add(spdh);
        }
        model.addAttribute("list", listBuy);
        
        //xu ly message
        String error = request.getParameter("errors");
        if (error != null) {
            model.addAttribute("errors", "Chưa có sản phẩm trong giỏ hàng!");
        }
        return "cart";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errors", "Chưa có sản phẩm trong giỏ hàng!");
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

    @RequestMapping("/updateCart")
    public String updateCart(HttpServletRequest request) {
        try {
            
        HttpSession session = request.getSession(true);

        Map<Integer, Integer> listProductBuy = new HashMap<>();

        String[] listmaSP = request.getParameterValues("maSanPham");
        String[] listTotal = request.getParameterValues("tongSanPham");

        for (int i = 0; i < listmaSP.length; i++) {
            listProductBuy.put(Integer.parseInt(listmaSP[i]), Integer.parseInt(listTotal[i]));
        }

        session.setAttribute("listProductBuy", listProductBuy);
        return "redirect:/viewCart.htm";
        
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/viewCart.htm";
        }
    }

    @RequestMapping("/preOrderProduct")
    public String orderProduct(Model model, HttpSession session) {
        if(checkICustomerLoginCart()==true){
        KhachHang kh= khachhangdao.getCustomerIsLive();
        model.addAttribute("userod",kh);   
        Map<Integer, Integer> listProductBuy = (Map<Integer, Integer>) session.getAttribute("listProductBuy");

        List<SanPhamDH> listBuy = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pro : listProductBuy.entrySet()) {
            Integer key = pro.getKey();
            Integer value = pro.getValue();

            SanPham p = productdao.getProductById(key);
            SanPhamDH spdh = new SanPhamDH();
            spdh.setMaSanPham(p.getMaSanPham());
            spdh.setNgayThem(p.getNgayThem());
            spdh.setUrlAnh(p.getUrlAnh());
            spdh.setGiaGoc(p.getGiaGoc());
            spdh.setKhuyenMai(p.getKhuyenMai());
            spdh.setTenSanPham(p.getTenSanPham());
            spdh.setMaDM(p.getMaDM());
            spdh.setMoTaNgan(p.getMoTaNgan());
            spdh.setMoTaChiTiet(p.getMoTaChiTiet());
            spdh.setSoLuong(p.getSoLuong());
            spdh.setTongSanPham(value);
            spdh.setTongTienTT(spdh.getKhuyenMai() * spdh.getTongSanPham());
            listBuy.add(spdh);
        }
        model.addAttribute("list", listBuy);

        return "orderProduct";
        }
        else{
            
            model.addAttribute("errors", "KH chưa đăng nhập");
            return "loginc";
        }
     }

    @RequestMapping("/orderProduct")
    public String orderProduct(@ModelAttribute("userod") KhachHang kh, HttpSession session) throws ParseException {
        Map<Integer, Integer> listProductBuy = (Map<Integer, Integer>) session.getAttribute("listProductBuy");
        
        
        
        
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
        Date now = new Date();
        String strDate = s.format(now);
        Date d= s.parse(strDate);
        
        
        DonHang dh = new DonHang();
        dh.setNgayDatHang(new Date());
        dh.setMaKH(kh);
        boolean bl = productdao.insertOrderProduct(dh);
        boolean bld = false;
        System.out.println("1111111111111");
       
        if (bl) {
            
            for (Map.Entry<Integer, Integer> obj : listProductBuy.entrySet()) {
                Integer maSP = obj.getKey();
                Integer quantity = obj.getValue();

                SanPham p = productdao.getProductById(maSP);
                
                DonHangChitiet dhct = new DonHangChitiet();
                dhct.setMaDonHang(new DonHang(dh.getMaDonHang()));
                dhct.setMaSanPham(new SanPham(maSP));
                dhct.setSoluong(quantity);
                dhct.setKhuyenMai(p.getKhuyenMai());
                System.out.println("22");
                
                bld = productdao.insertOrderDetail(dhct);
            }

            
        }
        if (bl && bld) {
            session.removeAttribute("listProductBuy");
            return "redirect:/index.htm?success=Dat hang thanh cong";            
        }else{
            return "redirect:viewCart.htm?error=Co loi khong dat hang duoc";
        }  
    }
    public boolean checkICustomerLoginCart(){
         List<KhachHang> cusCheck= khachhangdao.checkCustomerOnline();
        int c=cusCheck.size();
        if (c==0){
            return false;
        }
        else{
            return true;
        }
    }
}
