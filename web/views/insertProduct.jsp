<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
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
<style>
    .errors{
        color: red;
    }
</style>
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
        <li><a href="../login.jsp"><i class="icon-key"></i>Đăng xuất</a></li>
      </ul>
    </li>
  </ul>
</div>
<!--close-top-Header-menu-->

<!--sidebar-menu-->
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
        <h1>Thêm sản phẩm mới</h1><br><br><br>
        <h3 style="color: red">${error}</h3>
        
        <form:form action="insertProduct.htm" modelAttribute="p" enctype="multipart/form-data">
            <table style="width: 1000px;">
               
                <tr>
                    <td style="width: 400px;"><span id="td-insert">Tên sản phẩm mới :</span></td>
                    <td>
                        <form:input placeholder="Nhập tên sản phẩm mới"  path="tenSanPham"/>
                        <form:errors path="tenSanPham" cssClass="errors"/>
                    </td>
                </tr>
                <tr style="height: 50px;">
                    <td><span id="td-insert">Danh mục :</span></td>
                    <td>
                        <form:select path="maDM.maDM">
                            <form:options items="${listCate}" itemLabel="tenDM" itemValue="maDM"/>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td><span id="td-insert">Giá gốc :</span></td>
                    <td>
                        <form:input type="number" placeholder="Nhập giá cho sản phẩm"  path="giaGoc"/>
                        <form:errors path="giaGoc" cssClass="errors"/>
                    </td>
                </tr>
                <tr>
                    <td><span id="td-insert">Giá khuyến mại :</span></td>
                    <td>
                        <form:input type="number" placeholder="Nhập giá khuyến mại cho sản phẩm"  path="khuyenMai"/>
                        <form:errors path="khuyenMai" cssClass="errors"/>
                    </td>
                </tr>
                <tr>
                    <td><span id="td-insert">Mô tả ngắn :</span></td>
                    <td>
                        <form:textarea rows="6" placeholder="Nhập mô tả ngắn cho sản phẩm" path="moTaNgan"/>
                        <form:errors path="moTaNgan" cssClass="errors"/>
                    </td>
                </tr>
                <tr>
                    <td><span id="td-insert">Mô tả chi tiết :</span></td>
                    <td>
                        <form:textarea rows="10" placeholder="Nhập mô tả chi tiết cho sản phẩm" path="moTaChiTiet"/>
                    </td>
                </tr>
                <tr>
                    <td><span id="td-insert">Ngày lập:</span></td>
                    <td><form:input type="date" path="ngayThem"/>
                        <form:errors path="ngayThem" cssClass="errors"/>
                    </td>
                    
                </tr>
                <tr>
                    <td><span id="td-insert">Số lượng :</span></td>
                  <td>
                      <form:input type="number" placeholder="Nhập số lượng sản phẩm"  path="soLuong"/>
                      <form:errors path="soLuong" cssClass="errors"/>
                  </td>
                </tr>
                <tr>
                    <td><span id="td-insert">Ảnh</span></td>
                    <td>
                        <form:input type="file" path="urlAnh" />     
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
</div>
<!--End-Action boxes-->



<!--Footer-part-->
<div class="row-fluid">
    <div id="footer" class="span12"> 2020 &copy; <a href="../index.jsp">Shop bán quần áo</a>.</div>
</div>

<!--end-Footer-part-->

<script src="./resources/jsAdmin/excanvas.min.js"></script> 
<script src="./resources/jsAdmin/jquery.min.js"></script> 
<script src="./resources/jsAdmin/jquery.ui.custom.js"></script> 
<script src="./resources/jsAdmin/bootstrap.min.js"></script> 
<script src="./resources/jsAdmin/jquery.flot.min.js"></script> 
<script src="./resources/jsAdmin/jquery.flot.resize.min.js"></script> 
<script src="./resources/jsAdmin/jquery.peity.min.js"></script> 
<script src="./resources/jsAdmin/fullcalendar.min.js"></script> 
<script src="./resources/jsAdmin/matrix.js"></script> 
<script src="./resources/jsAdmin/matrix.dashboard.js"></script> 
<script src="./resources/jsAdmin/jquery.gritter.min.js"></script> 
<script src="./resources/jsAdmin/matrix.interface.js"></script> 
<script src="./resources/jsAdmin/matrix.chat.js"></script> 
<script src="./resources/jsAdmin/jquery.validate.js"></script> 
<script src="./resources/jsAdmin/matrix.form_validation.js"></script> 
<script src="./resources/jsAdmin/jquery.wizard.js"></script> 
<script src="./resources/jsAdmin/jquery.uniform.js"></script> 
<script src="./resources/jsAdmin/select2.min.js"></script> 
<script src="./resources/jsAdmin/matrix.popover.js"></script> 
<script src="./resources/jsAdmin/jquery.dataTables.min.js"></script> 
<script src="./resources/jsAdmin/matrix.tables.js"></script>
</body>
</html>
