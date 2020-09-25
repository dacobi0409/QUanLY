<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<title>Trang quản lý admin</title>
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
    <h2 style="text-shadow: 2px 2px 6px #996699;color: #CC33FF;font-family: myFirstFont;">Shop quần áo</h2>
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


<!--main-container-part-->
<div id="content-adminindex">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="adminIndex.htm" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
  </div>
<!--End-breadcrumbs-->

<!--Action boxes-->
  <div class="container-fluid">
    <div class="quick-actions_homepage">
      <ul class="quick-actions">
        <li class="bg_lb"> <a href="listProduct.htm"> <i class="icon-dashboard"></i> Quản lý</a>  </li>
        <li class="bg_lo"> <a href="allProduct.htm"> <i class="icon-th"></i>Tất cả sản phẩm</a> </li>
        <li class="bg_lb"> <a href="initInsertProduct.htm"> <i class="icon-pencil"></i>Thêm sản phẩm mới</a> </li>
        <li class="bg_lr"> <a href="allUser.htm"> <i class="icon-info-sign"></i>Tất cả người dùng</a> </li>
        <li class="bg_lb"> <a href="initInsertUser.htm"> <i class="icon-pencil"></i>Thêm người dùng mới</a> </li>
        <li class="bg_lr"> <a href="allContact.htm"> <i class="icon-info-sign"></i>Tất cả Liên hệ</a> </li>
      </ul>
    </div>
      </div>
</div>
<!--End-Action boxes-->

<!--Footer-part-->

<div class="row-fluid">
    <div id="footer" class="span12"> 2020 &copy; <a href="index.htm">Shop quần áo</a>.</div>
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

<script type="text/javascript">
  // This function is called from the pop-up menus to transfer to
  // a different page. Ignore if the value returned is a null string:
  function goPage (newURL) {

      // if url is empty, skip the menu dividers and reset the menu selection to default
      if (newURL != "") {
      
          // if url is "-", it is this page -- reset the menu:
          if (newURL == "-" ) {
              resetMenu();            
          } 
          // else, send page to designated URL            
          else {  
            document.location.href = newURL;
          }
      }
  }

// resets the menu selection upon entry to this page:
function resetMenu() {
   document.gomenu.selector.selectedIndex = 2;
}
</script>
</body>
</html>