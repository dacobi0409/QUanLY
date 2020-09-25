<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head><style>
            .error{
                color: red;
            }
        </style>
<title>Thêm sản phẩm mới</title>
<meta charset="UTF-8" />
<link rel="icon" href="./resources/images/icon.jpg">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="./resources/cssAdmin/bootstrap.min.css" />
<link rel="stylesheet" href="./resources/cssAdmin/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="./resources/cssAdmin/fullcalendar.css" />
<link rel="stylesheet" href="./resources/cssAdmin/matrix-style.css" />
<link rel="stylesheet" href="./resources/cssAdmin/matrix-media.css" />
<link href="./resources/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="./resources/cssAdmin/jquery.gritter.css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
        
<body>
<!--Header-part-->
<a href="index.htm">
  <div id="header">
    <h2 style="text-shadow: 2px 2px 6px #996699;color: #CC33FF;font-family: myFirstFont;">Shop Quần Áo</h2>
  </div>
</a>
<!--close-Header-part--> 


<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">Chào admin</span><b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a href="profile.jsp"><i class="icon-user"></i>Thông tin cá nhân</a></li>
        <li class="divider"></li>
        <li><a href="signOut.htm"><i class="icon-key"></i>Đăng xuất</a></li>
      </ul>
    </li>
  </ul>
</div>
<!--close-top-Header-menu-->

<!--sidebar-menu-->
<div id="sidebar"><a href="adminIndex.htm" class="visible-phone"><i class="icon icon-home" ></i>Menu</a>
  <ul>
    <li class="active"><a href="listProduct.htm"><i class="icon icon-home"></i> <span>Quản lý</span></a> </li>  
    <li class="submenu"> <a href="allProduct.htm"><i class="icon icon-th-list"></i> <span>Sản phẩm</span></a>
      <ul>
        <li><a href="allProduct.htm">Tất cả sản phẩm</a></li>
        <li><a href="initInsertProduct.htm">Thêm sản phẩm mới</a></li>
      </ul>
    </li>
    <li class="submenu"> <a href="detailUser.htm"><i class="icon icon-info-sign"></i> <span>Người dùng</span></a>
      <ul>
        <li><a href="allUser.htm">Tất cả người dùng</a></li>
        <li><a href="initInsertUser.htm">Thêm người dùng mới</a></li>
      </ul>
    </li>
    <li ><a href="allContact.htm"><i class="icon icon-info-sign"></i> <span>Liên hệ</span></a>
    <li ><a href="allDHCT.htm"><i class="icon icon-info-sign"></i> <span>Đơn hàng chi tiết</span></a>
    <li ><a href="allDH.htm"><i class="icon icon-info-sign"></i> <span>Đơn hàng</span></a>
        <li ><a href="allKH.htm"><i class="icon icon-info-sign"></i> <span>Khách Hàng</span></a>
  </ul>
</div>


<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="adminIndex.htm" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
  </div>
<!--End-breadcrumbs-->



<!--Action boxes-->
  <div class="container-fluid">
    <div class="quick-actions_homepage">
      <center>
        <h1>Thêm thành viên</h1><br><br><br>
        <h3 style="color: red">${error}</h3>
        
        <form:form action="insertUser.htm" modelAttribute="u" enctype="multipart/form-data">
            <table style="width: 1000px;">
               
                <tr>
                    <td>Tên tài khoản:</td>
                    <td>
                        <form:input type="text" placeholder="Nhập tên tài khoản"  path="taiKhoan"/>
                        <form:errors cssClass="error" path="taiKhoan"/>
                    </td>
                </tr>
                
                <tr>
                    <td>Mật khẩu :</td>
                    <td>
                        <form:password  placeholder="Nhập mật khẩu"  path="matKhau"/>
                        <form:errors cssClass="error" path="matKhau"/>
                    </td>
                </tr>
                <tr>
                    <td>Họ tên :</td>
                    <td>
                        <form:input type="text" placeholder="Nhập Họ tên"  path="hoTen"/>
                        <form:errors cssClass="error" path="hoTen"/>
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
                    <form:errors cssClass="error" path="ngaySinh"/>
                </tr>
                <tr>
                    <td>Email :</td>
                    <td>
                        <form:input type="text" placeholder="Email"  path="email"/>
                        <form:errors cssClass="error" path="email"/>
                    </td>
                </tr>
                <tr>
                    <td>Số điện thoại:</td>
                    <td>
                        <form:input type="number" placeholder="Số điện thoại"  path="soDienThoai"/>
                        <form:errors cssClass="error" path="soDienThoai"/>
                    </td>
                </tr>
                <tr>
                    <td>Địa chỉ :</td>
                    <td>
                        <form:textarea rows="10" placeholder="Địa chỉ" path="diaChi"/>
                        <form:errors cssClass="error" path="diaChi"/>
                    </td>
                </tr>
                
                
                <tr>
                  <td>Loại User :</td>
                  <td>
                      <form:radiobutton  path="phanQuyen" value="1"/> Nhân viên &nbsp;&nbsp;&nbsp;
                      <form:radiobutton  path="phanQuyen" value="0"/> Quản lý &nbsp;&nbsp;&nbsp;
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
                        <input type="submit" value="Thêm"/>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                        <input type="reset" value="Xóa"/>
                    </td>
                </tr>
            </table>
        </form:form>
      </center>
    </div>
  </div>
<!--End-Action boxes-->



<!--Footer-part-->
<div class="row-fluid">
    <div id="footer" class="span12"> 2020 &copy; <a href="../index.jsp">Shop bán quần áo</a>.</div>
</div>

<!--end-Footer-part-->
<script src="admin/js/excanvas.min.js"></script> 
<script src="admin/js/jquery.min.js"></script> 
<script src="admin/js/jquery.ui.custom.js"></script> 
<script src="admin/js/bootstrap.min.js"></script> 
<script src="admin/js/jquery.flot.min.js"></script> 
<script src="admin/js/jquery.flot.resize.min.js"></script> 
<script src="admin/js/jquery.peity.min.js"></script> 
<script src="admin/js/fullcalendar.min.js"></script> 
<script src="admin/js/matrix.js"></script> 
<script src="admin/js/matrix.dashboard.js"></script> 
<script src="admin/js/jquery.gritter.min.js"></script> 
<script src="admin/js/matrix.interface.js"></script> 
<script src="admin/js/matrix.chat.js"></script> 
<script src="admin/js/jquery.validate.js"></script> 
<script src="admin/js/matrix.form_validation.js"></script> 
<script src="admin/js/jquery.wizard.js"></script> 
<script src="admin/js/jquery.uniform.js"></script> 
<script src="admin/js/select2.min.js"></script> 
<script src="admin/js/matrix.popover.js"></script> 
<script src="admin/js/jquery.dataTables.min.js"></script> 
<script src="admin/js/matrix.tables.js"></script> 
</body>
</html>
