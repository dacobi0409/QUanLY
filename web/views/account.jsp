<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<title>Website bán quần áo</title>
<link rel="icon" href="https://www.google.com.vn/url?sa=i&url=https%3A%2F%2Fwww.pinterest.co.uk%2Fpin%2F780811654117612245%2F&psig=AOvVaw0zASQ8d83-wJ6t5psVYpeG&ust=1592417146774000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLjD69D3huoCFQAAAAAdAAAAABAD">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville:400,700,400italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Oswald:400,700,300' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<!--//fonts-->
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
                    </ul>
		</div>
                <!--  login  -->
		<div class="header-grid-right">
                    <a href="login.htm" class="sign-in">Đăng nhập</a>
                    <label>|</label>
                    <a href="signup.htm" class="sign-up">Đăng ký</a>
                    <a href="cart.htm" class="cart"style="text-decoration: none;color: #CC66FF;">Giỏ hàng</a>
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
                            <li><a href="initMen.htm" >Sản phẩm dành cho nam</a></li>
                            <li><a href="initWomen.htm" >Sản phẩm dành cho nữ</a></li>
                            <li><a href="initAccount.htm">Tài khoản</a></li>
                        </ul>		
                    <div class="clearfix"> </div>
                    <script>
                        $("span.menu").click(function(){$(".top-nav ul").slideToggle(500, function(){});});
                    </script>					
		</div>
		<div class="search">
                    <form>
                        <input type="text" placeholder="Tìm kiếm!">
                        <input type="submit"  value="">
                    </form>
		</div>
		<div class="clearfix"> </div>
            </div>
	</div>
    </div>
<!--content-->
    <div class="content">
        <div class="container">
            <center style="font-family: serif;">
            <h2>Thông tin tài khoản</h2>
            <c:forEach items="${allUsers}" var="t">
                <table>
                    <tr>
                        <td>Tài khoản : </td>&emsp;&emsp;
                        <td>${t.taiKhoan}</td>
                    </tr>
                    <tr>
                        <td>Mật khẩu : </td>&emsp;&emsp;
                        <td>${t.matKhau}</td>
                    </tr>
                    <tr>
                        <td>Họ và Tên : </td>&emsp;&emsp;
                        <td>${t.hoTen}</td>
                    </tr>
                    <tr>
                        <td>Giới tính : </td>&emsp;&emsp;
                        <td>${t.gioiTinh}</td>
                    </tr>
                    <tr>
                        <td>Ngày Sinh : </td>&emsp;&emsp;
                        <td>${t.ngaySinh}</td>
                    </tr>
                    <tr>
                        <td>Email : </td>&emsp;&emsp;
                        <td>${t.email}</td>
                    </tr>
                    <tr>
                        <td>Địa chỉ : </td>&emsp;&emsp;
                        <td>${t.diaChi}</td>
                    </tr>
                    <tr>
                        <td>Số điện thoại :</td>&emsp;&emsp;
                        <td>${t.soDienThoai}</td>
                    </tr>
                </table>
            </c:forEach>
            </center>
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
                <!-- <p class="footer-grid">&copy; </p> -->
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