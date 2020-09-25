<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <title>Search</title>
    <link rel="icon" href="https://www.google.com.vn/url?sa=i&url=https%3A%2F%2Fwww.pinterest.co.uk%2Fpin%2F780811654117612245%2F&psig=AOvVaw0zASQ8d83-wJ6t5psVYpeG&ust=1592417146774000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLjD69D3huoCFQAAAAAdAAAAABAD">
    <link href="./resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="./css/etalage.css" rel="stylesheet" type="text/css"/>
    <link href="./css/owl.carousel.css" rel="stylesheet" type="text/css"/>
    <link href="./css/style.css" rel="stylesheet" type="text/css"/>
    <script src="./js/jquery.min.js"></script>
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
            <div class="women-in">
                <div class="col-md-9 col-d">
                    <div class="banner">
                        <div class="banner-matter">
                            <label>Bộ sưu tập</label>
                            <h2>Mùa hè</h2>
                            <p>Làm cho bạn quyến rũ©</p>
                        </div>
                        <div class="you">
                            <span>40<label>%</label></span>
                            <small>off</small>
                        </div>			
                        <p  class="para-in">Sản phẩm trưng bày.</p>
                    </div>
                        <table style="border: 1px bold black;">
                            <div class="in-line">
                                <div class="para-an">
                                    <h3>Sản phẩm tìm thấy</h3>
                                </div>
                                    <div class="lady-in">
                                        <c:forEach items="${list}" var="t">
                                            <div class="col-md-4 you-para">
                                                <a href="single.html"><img class="img-responsive pic-in" src="images/pi.jpg" alt=" " ></a>
                                                <p>${t.tenSanPham}</p>
                                                <span style="font-weight: 30px;"><fmt:formatNumber value="${t.khuyenMai}"></fmt:formatNumber>₫
                                                    <sup style="text-decoration: line-through;color: red;"><fmt:formatNumber value="${t.giaGoc}"></fmt:formatNumber>₫</sup>  | 
                                                    <label class="cat-in"> </label> 
                                                    <a href="#">Thêm vào giỏ hàng</a>
                                                </span>
                                            </div>
                                        </c:forEach>
                                        <div class="clearfix"> </div>
                                    </div>
                            </div>
                        </table>
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
                    <li><a href="index.htm" class="scroll">Trang chủ</a><label>|</label></li>
                    <li><a href="men.htm" class="scroll">Sản phẩm dành cho nam</a><label>|</label></li>
                    <li><a href="women.htm" class="scroll">Sản phẩm dành cho nữ</a><label>|</label></li>
                </ul>
                <!-- <p class="footer-grid">&copy; </p> -->
                </div>	 
                <div class="footer-left">
                    <a href="index.htm"><img src="./images/logo1.png" alt=" " /></a>
                </div> 
                <div class="clearfix"></div>
            </div>
	</div>
    </div>
</body>
</html>