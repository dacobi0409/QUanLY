/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KhachHangDAO;
import dao.LienHeDAO;
import dao.productDAO;
import entity.KhachHang;
import entity.LienHe;
import entity.SanPham;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author LongLD
 */
@Controller
public class controllerContact {
    private LienHeDAO lienHeDAO;
    private KhachHangDAO khdao;
    private productDAO productdao;
    @Autowired
    public void setProductdao(productDAO productdao) {
        this.productdao = productdao;
    }
    
    @Autowired
    public void setKhdao(KhachHangDAO khdao) {
        this.khdao = khdao;
    }

    
    
    
    @Autowired
    public void setLienHeDAO(LienHeDAO lienHeDAO) {
        this.lienHeDAO = lienHeDAO;
    }

    
    
    
    @RequestMapping("/initContact")    
    public String iniContact(HttpSession session,Model model,Integer offset, Integer maxResult){
        if(checkICustomerLogin()==false){
            model.addAttribute("errors", "KH chưa đăng nhập");
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
        else{
        model.addAttribute("c", new LienHe());
        List<KhachHang> alLCustomer = lienHeDAO.getAllCustomer();
        model.addAttribute("listCustomer", alLCustomer);
        return "contact";
        }
    }
    
    @RequestMapping("/insertcontact")
    public String insertContact(@ModelAttribute("c") LienHe c, HttpServletRequest request,BindingResult result ,Model model) {
        
        try {
            //xu ly co dau
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("oooooo");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> listItems = upload.parseRequest(request);

            for (FileItem item : listItems) {
                String fieldName = item.getFieldName(); //ten phan tu cua form
                String data = item.getString();  //du lieu cua phan tu do
                
                if (item.isFormField()) {
                    //day la du lieu cua form
                    if (fieldName.equals("maLienHe.maLienHe")) {
                        LienHe l=new LienHe(Integer.parseInt(data));
                        c.setMaLienHe(Integer.parseInt(data));
                    }else if (fieldName.equals("maKH.maKH")) {
                        Integer mkh = Integer.parseInt(data);
                        KhachHang kh=new KhachHang(mkh);
                        c.setMaKH(kh);
                    }else if (fieldName.equals("noiDung")) {
                         c.setNoiDung(new String(data.getBytes("iso-8859-1"), "UTF-8"));
                    }
                }
            }
        }
        catch (Exception ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result.hasErrors()){
            model.addAttribute("c", c);
            return "contact";
        }
        else{
        boolean bl = lienHeDAO.insertContact(c);
        if (bl) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "redirect:/initContact.htm?success=Insert successfully";
        } else {
            List<LienHe> ct = lienHeDAO.getAllContact();
            model.addAttribute("c", ct);
            return "contact";
        }
        }
    }
    @RequestMapping("/deleteContact")
    public String deleteUser(@RequestParam("maLienHe")Integer maLienHe, Model model){
        
            boolean bl = lienHeDAO.deleteContact(maLienHe);
            if(bl){
                return "redirect:/allContact.htm?mes=Delete successfully!";
            }else{
                return "redirect:/allContact.htm?mes=Delete failed!";
            }   
    }
    @RequestMapping("/allContact")
    public String listContact(Model model, HttpServletRequest request) {
        String success = request.getParameter("mes");
        model.addAttribute("success", success);
        List<LienHe> c = lienHeDAO.getAllContact();
        model.addAttribute("list", c);
        return "adminContact";
    }
    
    public boolean checkICustomerLogin(){
         List<KhachHang> cusCheck= khdao.checkCustomerOnline();
        int c=cusCheck.size();
        if (c==0){
            return false;
        }
        else{
            return true;
        }
    }
}
