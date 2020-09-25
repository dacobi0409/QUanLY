<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <title>Chi tiết sản phẩm</title>
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
                       <a href="index.htm"><img src="./resources/images/logo.png" alt=" " /></a>
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
       <!--content-->
          <div class="content">
            <div class="container">
               <div class="single">
                  <div class="col-md-9">
                     <div class="single_grid"">
                         <div style="float: left; height: 300px; width: 200px;"><img src="/products/resources/images/${p.urlAnh}" style="height: 300px; width: 200px;"></div>
                         <div class="grid images_3_of_2" style="background-color: red;">
                           <ul id="etalage">
                              <li>
                                  <a href="men.htm"><div style="width: 100%; height: 100%; background-color:#000 black;"></div>
                                      
                                 </a>
                              </li>
                           </ul>
	 <div class="clearfix"> </div>		
                         </div> 
                           <!---->
                           <div class="span1_of_1_des">
                                 <div class="desc1">
                                    <h3>${p.tenSanPham}</h3>
                                    <p>${p.moTaNgan}</p>
                                    <h5 title="Giá đã áp dụng khuyến mại <fmt:formatNumber value="${p.khuyenMai}"></fmt:formatNumber>"><fmt:formatNumber value="${p.khuyenMai}"></fmt:formatNumber>₫</h5>
                                    <sup style="text-decoration: line-through;color: red;" title="Giá gốc chưa áp dụng khuyến mại <fmt:formatNumber value="${p.giaGoc}"></fmt:formatNumber>"><fmt:formatNumber value="${p.giaGoc}"></fmt:formatNumber>₫</sup>   
                                    <div class="available">
                                          <div class="form-in"><a href="addToCar.htm?maSanPham=${p.maSanPham}">Thêm vào giỏ hàng</a></div>
                                          <div class="clearfix"></div>
                                       </div>
                                  </div>
                            </div>
                            <div class="clearfix"></div>
                      </div>
                      <!----- tabs-box --->
                      <div class="sap_tabs">	     
                               <div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
                                       <ul class="resp-tabs-list">
                                               <li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>Mô tả chi tiết</span></li>
                                               <div class="clearfix"></div>
                                       </ul>				  	 
                                       <div class="resp-tabs-container">
                                                       <div class="tab-1 resp-tab-content resp-tab-content-active" aria-labelledby="tab_item-0" style="display:block">
                                                               <div class="facts">
                                                                 <p>${p.moTaChiTiet}</p>        
                                                               </div>
                                                       </div>
                                               <h2 class="resp-accordion" role="tab" aria-controls="tab_item-1"><span class="resp-arrow"></span>Mô tả chi tiết</h2>
                                                       <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
                                                               <div class="facts"><p>${p.moTaChiTiet}</p></div>	
                                                       </div>
                                       </div>
                               </div>
                               <script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
                              <script type="text/javascript">
                                       $(document).ready(function () {
                                        $('#horizontalTab').easyResponsiveTabs({type: 'default', //Types: default, vertical, accordion           
                                       width: 'auto', //auto or any width like 600px
                                       fit: true   // 100% fit in a container
                                       });
                                      });
                                </script>	
                        </div>
                        </div>
               </div>
            </div>
          </div>
                       <!---->
    <div class="footer">
        <div class="container">
            <div class="footer-class">
                <div class="class-footer">
                <ul>
                    <li><a href="index.jsp" class="scroll">Trang chủ</a><label>|</label></li>
                    <li><a href="men.jsp" class="scroll">Sản phẩm dành cho nam</a><label>|</label></li>
                    <li><a href="women.jsp" class="scroll">Sản phẩm dành cho nữ</a><label>|</label></li>
                </ul>
                </div>	 
                <div class="footer-left">
                    <a href="index.jsp"><img src="images/logo1.png" alt=" " /></a>
                </div> 
                <div class="clearfix"></div>
            </div>
	</div>
    </div>
</body>
</html>