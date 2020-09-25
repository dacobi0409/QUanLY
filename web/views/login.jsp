<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    
<head>
        <title>Đăng Nhập</title><meta charset="UTF-8" />
        <link rel="icon" href="https://www.google.com.vn/url?sa=i&url=https%3A%2F%2Fwww.pinterest.co.uk%2Fpin%2F780811654117612245%2F&psig=AOvVaw0zASQ8d83-wJ6t5psVYpeG&ust=1592417146774000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLjD69D3huoCFQAAAAAdAAAAABAD">
    <link href="./resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="./resources/css/etalage.css" rel="stylesheet" type="text/css"/>
    <link href="./resources/css/owl.carousel.css" rel="stylesheet" type="text/css"/>
    <link href="./resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="./resources/js/jquery.min.js"></script>
    <link rel="stylesheet" href="admin/css/matrix-style.css" />
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
                       <div class="clearfix"> </div>
               </div>
             </div>
    </div>
    <div class="content">			         
        <div class="container"> 			         
            <div class="register">
        <form action="btnDangNhap.htm" style="margin-left: 220px; margin-right: 220px; background-color: #f2f2f2;">
                
            <div class="  register-top-grid">
                              <div class="  register-top-grid">
                        
                    <table style="width: 1000px; margin-left: 80px;">
                        <tr>
                            <td style="width: 20%;"></td>
                            <td><h2 style="color: red;">&nbsp;&nbsp;&nbsp; Đăng nhập</h2><br> <p style="color: red;">&nbsp;&nbsp; ${tb}</p></td>
                            <td></td>
                        </tr><br>
                        <tr style="height: 10px;"></tr>
                        <tr>
                            <td>Tên tài khoản:</td>
                            <td>
                                <input type="text" placeholder="Ten tai khoan" style="float: left; width: 300px;" name="taiKhoan" required="Chưa nhập Tên tài khoản"/><br>
                            </td>
                        </tr>
                        <tr>
                            <td>Mật khẩu:</td>
                            <td>
                                <input type="password" placeholder="Mat khau" name="matKhau" required="Chưa nhập mật khẩu!" style="float: left; width: 300px;" /><br><br><br><br>
                            </td>
                        </tr>
                        <tr  style="height: 10px"></tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" value="Đăng nhập" class="btn btn-primary btn-md"/> &nbsp; <br>
                                <a href="signup.htm"><div class="btn btn-default btn-sm btn-block" style="height: 30px; width: 95px;">Đăng ký</div></a>
                             </td>
                        </tr>
                    
                    </table>
                              </div>
                        <div class="clearfix"></div>
                </div>
        </form>
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
    <script src="./resources/js/jquery.min.js"></script>  
        <script src="./resources/js/matrix.login.js"></script> 
</html>
