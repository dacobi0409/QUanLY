<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<title>Shop quần áo</title>
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
                       <form action="lookUp.htm">
                          <input type="text" name="keySearch" required="" placeholder="Tìm kiếm!">
                           <input type="submit"  value="Tìm">
                       </form>
                       </div>
                       <div class="clearfix"> </div>
               </div>
             </div>
    </div>
    <!---->
    <div class="content">
        <div class="container"> 			         
            <div class="register">
                <form:form action="insertUserRegister.htm" modelAttribute="u" enctype="multipart/form-data">
            
                    <div class="  register-top-grid">
                        
                    <table style="width: 1000px;">
               
                <tr>
                    <td>Tên tài khoản:</td>
                    <td>
                        <form:input type="text" placeholder="Nhập tên tài khoản"  path="taiKhoan"/>
                    </td>
                </tr>
                
                <tr>
                    <td>Mật khẩu :</td>
                    <td>
                        <form:password  placeholder="Nhập mật khẩu"  path="matKhau"/>
                    </td>
                </tr>
                <tr>
                    <td>Họ tên :</td>
                    <td>
                        <form:input type="text" placeholder="Nhập Họ tên"  path="hoTen"/>
                    </td>
                </tr>
                <tr style="height: 50px;">
                    <td>Giới tính :</td>
                    <td>
                        <form:radiobutton  path="gioiTinh" value="1" /> Nam &nbsp;&nbsp;&nbsp;
                        <form:radiobutton  path="gioiTinh" value="0" /> Nữ &nbsp;&nbsp;&nbsp;
                        
                    </td>
                </tr>
                <tr>
                    <td>Ngày sinh</td>
                    <td><form:input type="date" path="ngaySinh"/></td>
                </tr>
                <tr>
                    <td>Email :</td>
                    <td>
                        <form:input type="text" placeholder="Email"  path="email"/>
                    </td>
                </tr>
                <tr>
                    <td>Số điện thoại:</td>
                    <td>
                        <form:input type="number" placeholder="Số điện thoại"  path="soDienThoai"/>
                    </td>
                </tr>
                <tr>
                    <td>Địa chỉ :</td>
                    <td>
                        <br>
                        <form:textarea rows="8" placeholder="Nhập địa chỉ" path="diaChi"/>
                    </td>
                </tr>
                
                
                <tr>
                  <td>Quyền :</td>
                  <td>
                      <form:radiobutton  path="phanQuyen" value="1"/> Nhân viên &nbsp;&nbsp;&nbsp;
                  </td>
                </tr>
                <tr>
                    <td>Ảnh</td>
                    <td>
                        <form:input type="file" path="urlAnhUser" />                   
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Đăng ký"/>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                        <input type="reset" value="Xóa"/>
                    </td>
                </tr>
            </table>
                    </div>
        </form:form>
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