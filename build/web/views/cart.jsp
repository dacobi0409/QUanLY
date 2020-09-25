<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Giỏ hàng</title>
        <link rel="icon" href="https://www.google.com.vn/url?sa=i&url=https%3A%2F%2Fwww.pinterest.co.uk%2Fpin%2F780811654117612245%2F&psig=AOvVaw0zASQ8d83-wJ6t5psVYpeG&ust=1592417146774000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLjD69D3huoCFQAAAAAdAAAAABAD">
    <link href="./resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="./resources/css/etalage.css" rel="stylesheet" type="text/css"/>
    <link href="./resources/css/owl.carousel.css" rel="stylesheet" type="text/css"/>
    <link href="./resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="./resources/js/jquery.min.js"></script>
    <meta charset="UTF-8">
    <link href='http://fonts.googleapis.com/css?family=Libre+Baskerville:400,700,400italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Oswald:400,700,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
    <style>
        .table-tdtt{
                height: auto; 
                width: 150px;
            }
            .table-th1{
                height: 50px; 
                border-bottom: solid 10px #F9F9F9;
                border-top: solid 10px #F9F9F9; 
                text-align: center;
                border-left: solid 1px #f7f7f7; 
                border-right: solid 1px #f7f7f7; 
            }
            .table-tdbd{
                border-left: solid 1px #f7f7f7; 
                border-right: solid 1px #f7f7f7;
                border-bottom: solid 10px #F9F9F9;
                border-top: solid 10px #F9F9F9;
            }
    </style>
    </head>
    <body>
        
        <!--header trang-->
    <div class="header">
        <div class="header-top">
               <div class="container">
                       <div class="header-grid">
                       <ul>
                                 <li><a href="initContact.htm" class="scroll">Liên hệ</a></li>
                                 <li><a href="privacy.htm" class="scroll">Điều khoản và riêng tư</a></li>
                                 <li><a href="adminIndex.htm" class="scroll">Trang quản lý</a></li>
                                 <li><a href="viewCart.htm" class="scroll">Giỏ hàng (${totalProductBuy})</a></li>
                                 <li style="width: 270px; color: #ffffff"> ${errors}</li>
                       </ul>
                       </div>
                   <!--  login  -->
                   <div class="header-grid-right">
                       <div style="float: left; height: 40px; width: 40px">
                           <a href="loginC.htm" class="sign-in">Đăng nhập KH</a>
                       </div>
                       <div style="float: left; height: 40px; width: 40px">
                       <a href="signupC.htm" class="sign-in">Đăng ký KH</a>
                       </div>
                       <a href="signoutC.htm" class="sign-in">Đăng xuất KH</a>
                       
                       <label>|</label>
                       <div style="float: left;  height: 50px; width: 40px">
                        <a href="login.htm" class="sign-up">Đăng nhập</a>
                       </div>
                       <a href="signout.htm" class="sign-up">Đăng xuất </a>
                       
                       </div>
                   <div class="clearfix"> </div>
               </div>
             </div>
             <div class="container">
               <div class="header-bottom">			
                   <div class="logo">
                       <a href="indexview.htm"><img src="./resources/images/logo.png" alt=" " /></a>
                       </div>
                       <div class="clearfix"> </div>
               </div>	
               <div class="header-bottom-bottom">
                       <div class="top-nav">
                       <span class="menu"> </span>
                           <ul>
                               <li><a href="index.htm">Trang chủ</a></li>
                               <li><a href="men.htm" >Sản phẩm dành cho nam</a></li>
                               <li><a href="women.htm" >Sản phẩm dành cho nữ</a></li>                            
                           </ul>		
                       <div class="clearfix"> </div>
                       <script>
                           $("span.menu").click(function(){$(".top-nav ul").slideToggle(500, function(){});});
                       </script>					
                       </div>
                       <div class="search">
                       <form action="lookUpProduct.htm">
                          <input type="text" name="keySearchProduct" required="" placeholder="Tìm kiếm!">
                           <input type="submit"  value="Tìm">
                       </form>
                       </div>
                       <div class="clearfix"> </div>
               </div>
             </div>
    </div>
    <div class="content">
        <div class="container">
            <div class="  col-m-on">
                <!---->
                <div class="in-line">
                    <div class="para-all">
                        <center>     
                    
        <h1>Thông tin giỏ hàng</h1>
        <h3 style="color: red">${error}</h3>
        
        <form action="updateCart.htm">
            <table border="1" style="text-align: center; float: left; width: 1100px; border: solid 2px #FCFCFC;">
                <tr>
                            <th class="table-th1" style="border-left: 10px solid #F9F9F9;">Ảnh</th>
                            <th class="table-th1">Mã sản phẩm</th>
                            <th class="table-th1">Tên sản phẩm</th>
                            <th class="table-th1">Giá gốc</th>
                            <th class="table-th1">Giá khuyến mại</th>
                            <th class="table-th1">Số lượng</th>
                            <th class="table-th1" >Tổng tiền</th>
                            <th class="table-th1" style="border-right: 10px solid #F9F9F9;">Xóa</th>
                            
                        </tr>            
                <c:forEach items="${list}" var="p">
                    <tr>
                        <td class="table-tdbd" style="height: auto; width: 200px; border-left: 10px solid #F9F9F9;" >
                            <img src="/products/resources/images/${p.urlAnh}" width="120px" height="150px"/>
                        </td>
                        <td class="table-tdbd">
                            ${p.maSanPham}
                            <input type="hidden" name="maSanPham" value="${p.maSanPham}"/>
                        </td>
                        <td class="table-tdbd" style="height: 120px; width: 200px;" >${p.tenSanPham}</td>
                        <td class="table-tdbd" style="height: auto; width: 100px;"><fmt:formatNumber value="${p.giaGoc}" currencySymbol=""/> VND</td>
                        <td  class="table-tdbd"><fmt:formatNumber value="${p.khuyenMai}" currencySymbol=""/> VND</td>
                        <td class="table-tdbd" style="height: auto; width: 100px;">
                            <input type="number" min="1" name="tongSanPham" value="${p.tongSanPham}"/>                            
                        </td>
                        <td class="table-tdbd"><fmt:formatNumber value="${p.tongTienTT}" currencySymbol=""/> VND</td>
                        <td class="table-tdbd" style="height: auto; width: 120px; border-right: 10px solid #F9F9F9;"><a href="removeProductCart.htm?maSanPham=${p.maSanPham}">Xóa</a></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="7" style="height: 34px; width: 100px; border: 10px solid #F9F9F9; ">
                        <input type="submit" class="btn btn-default btn-sm btn-block" value="Cập nhật" style="height: 30px; width: 180px; margin-left: 820px;"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="7" style="height: 40px; width: 100px; border: 10px solid #F9F9F9;">
                        <div class="btn btn-success btn-block" style="height: 30px; margin-left: 820px; width: 180px; text-align: center;"><a href="preOrderProduct.htm" style="height: 100%; width: 100%; color: white"><div>Mua hàng</div></a></div>
                    </td>
                </tr>
            </table>
        </form>
        
        </center>
            </div>
        </div>
        </div>
    </div>
        
</div>
        
        <div class="footer">
        <div class="container">
            <div class="footer-class">
                <div class="class-footer">
                <ul>
                    <li><a href="index.htm" class="scroll">Trang chủ</a><label>|</label></li>
                    <li><a href="men.htm" class="scroll">Sản phẩm dành cho nam</a><label>|</label></li>
                    <li><a href="women.htm" class="scroll">Sản phẩm dành cho nữ</a><label>|</label></li>
                </ul>
                <!-- <p class="footer-grid">&copy; </p> -->
                </div>	 
                <div class="footer-left">
                    <a href="index.htm"><img src="./resources/images/logo1.png" alt=" " /></a>
                </div> 
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    </body>
</html>
