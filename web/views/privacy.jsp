<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<title>Website privacy</title>
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
    <!---->
    <div class="content">
        <div class="container"> 			         
            <div class="privacy-top">
                <h3>Điều khoản và riêng tư</h3>
                <div class="privacy-bottom">
                    <h5><a>1. Mục đích và phạm vi thu thập thông tin</a></h5>
                    <p>- Chúng tôi thu thập thông tin từ bạn khi bạn đặt hàng trên trang web hoặc liên hệ email, điện thoại với chúng tôi. Bất kỳ thông tin chúng tôi thu thập từ bạn có thể được sử dụng một trong những cách sau đây:</p>
                    <p>     + Để cải thiện trang web của chúng tôi (Chúng tôi liên tục cố gắng để cải thiện các dịch vụ trang web của chúng tôi dựa trên các thông tin và phản hồi chúng tôi nhận được từ bạn)</p>
                    <p>     + Để cải thiện dịch vụ khách hàng (Thông tin của bạn sẽ giúp chúng tôi đáp ứng hiệu quả hơn yêu cầu dịch vụ khách hàng và nhu cầu hỗ trợ của bạn)</p>
                    <p>     + Để xử lý các giao dịch</p>
                    <p>     + Địa chỉ email mà bạn cung cấp khi xử lý đơn hàng, có thể được sử dụng để gửi cho bạn thông tin và cập nhật liên quan đến đặt hàng của bạn, ngoài việc tiếp nhận tin tức thường xuyên, cập nhật, sản phẩm hoặc dịch vụ liên quan đến thông tin</p>
                </div>
                <div class="privacy-bottom">
                    <h5><a>2. Phạm vi sử dụng thông tin</a></h5>
                    <p>Shop quần áo sử dụng thông tin khách hàng trong trường hợp thông báo đơn hàng đến với khách hàng. Không sử dụng thông tin khách hàng cho các mục đích khác mà chưa được sự đồng ý của khách hàng</p>
                </div>
                <div class="privacy-bottom">
                    <h5><a>3. Thời gian lưu trữ thông tin</a></h5>
                    <p>Shop quần áo lưu trữ thông tin khách hàng, đơn hàng nhằm để đối chiếu khi có phát sinh vấn đề xảy ra, không lưu trữ thông tin khác, nhạy cảm của khách hàng như số điện thoại, thông tin địa chỉ..v.v..</p>
                </div>
                <div class="privacy-bottom">
                    <h5><a>4. Địa chỉ của đơn vị thu thập và quản lý thông tin cá nhân</a></h5>
                    <p>Shop quần áo lưu trữ thông tin khách hàng thông qua việc khách hàng email đặt hàng, không yêu cầu khách hàng phải để lại thông tin nếu chưa được sự đồng ý.</p>
                </div>
                <div class="privacy-bottom">
                    <h5><a>5. Phương tiện và công cụ để người dùng tiếp cận và điều chỉnh</a></h5>
                    <p>Khách hàng hoàn toàn có thể yêu cầu 4menshop.com cung cấp hoặc xóa bỏ thông tin của chính mình nếu có nhu cầu, 4MEN hoàn toàn không sử dụng hoặc chỉnh sửa thông tin khách hàng.</p>
                </div>
                <div class="privacy-bottom">
                    <h5><a>6. Cam kết bảo mật thông tin cá nhân khách hàng</a></h5>
                    <p>- Thông tin của bạn, dù công hay tư, sẽ <strong> không</strong> được bán, trao đổi, chuyển nhượng, hoặc để lộ cho bất kỳ công ty khác cho bất kỳ lý do nào, mà không có sự đồng ý của bạn</p>
                    <p>- Tất cả các thông tin nhạy cảm chỉ có thể truy cập bởi những người được ủy quyền có quyền truy cập và được yêu cầu để giữ cho các thông tin bí mật.</p>
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