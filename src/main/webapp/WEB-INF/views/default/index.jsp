<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Akiii</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/resources/w3/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

<style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
a { text-decoration:none;}
 section#content ul li { display:inline-block; margin:10px; }
 section#content div.goodsThumb img { width:200px; height:200px; }
 section#content div.goodsName { padding:10px 0; text-align:center; }
 section#content div.goodsName a { color:#000; }
 section#content div.goodsPrice { padding:10px 0; text-align:center;}

	#container_box table {width:900px;}
	#container_box table th {font-size:20px; font-weight: bold; text-align: center; padding:10px;
								border-bottom: 2px solid #666;}
	#container_box table tr:hover {background: #eee;}
	#container_box table td {padding:10px; text-align: center;}
	#container_box table img {width:150px; height: auto;}

</style>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<body class="w3-content" style="max-width:1500px">
<%@ include file="header.jsp" %>

  <!-- Image header -->
  <div class="w3-display-container w3-container">
    <img src="/resources/shopimages/akiiikr/122177213_395151268535889_8290461004378517128_n.jpg" alt="Jeans" style="width:100%">
    <div class="w3-display-topleft w3-text-white" style="padding:24px 48px">
	      <p><a href="#jeans" class="w3-button w3-black w3-padding-large w3-large">SHOP NOW</a></p>
    </div>
  </div>
	<div class="w3-container w3-text-grey" id="jeans">
	    <p>8 items</p>
	</div>

	<section id="container">
		<div id="container_box">
			<section id="content">
				<ul>
					<c:forEach items="${list}" var="list">
						<li>
							<div class="goodsThumb">
								<img src="${list.goodsThumbImage}">
							</div>
							<div class="goodsName">
								<a href="/goods/shop?n=${list.goodsNum}"><b>${list.goodsName}</b></a>
							</div>
							<div class="goodsPrice">
								 <span><fmt:formatNumber value="${list.goodsPrice}" pattern="###,###,###"/>원</span>
							</div>
						</li>
					</c:forEach>
				</ul>
			</section>
		</div>
	</section>
  <!-- Product grid 
  <div class="w3-row w3-grayscale" style="filter:grayscale(0%)">
    <div class="w3-col l3 s6">
      <div class="w3-container">
       <div class="w3-display-container">
        <img src="/resources/shopimages/akiiikr/0140010001923.jpg" style="width:100%">
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          </div>
        </div>
        <p>어반크래커 크림<br><b>59,000원</b></p>
      </div>
      
  <div class="w3-container">
      	 <div class="w3-display-container">
        <img src="/resources/shopimages/akiiikr/0140010003063.jpg" style="width:100%">
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          	</div>
          </div>
       		 <p>청키삭스 트리플블랙<br>플라이 바운스 삭스 더티 블랙
				<br><b>49,000원</b></p>
      </div>
    </div>
     
    <div class="w3-col l3 s6">
      <div class="w3-container">
        <div class="w3-display-container">
          <img src="/resources/shopimages/akiiikr/0140010003203.jpg" style="width:100%">
          <span class="w3-tag w3-display-topleft">New</span>
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          </div>
        </div>
        <p>에너지 흡수율 31% 발피로 회복 <br>[리커버리 슈즈] 범퍼 블랙
			<br><b>69,000원</b></p>
      </div>
      
      <div class="w3-container">
      	 <div class="w3-display-container">
        <img src="/resources/shopimages/akiiikr/0140010003313.jpg" style="width:100%">
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          	</div>
          </div>
       		 <p>Fly Bounce 폼 내장 <br>플라이 바운스 삭스 더티 블랙
				<br><b>69,000원</b></p>
      </div>
    </div>
 	<div class="w3-col l3 s6">
      <div class="w3-container">
        <div class="w3-display-container">
          <img src="/resources/shopimages/akiiikr/0140010002773.jpg" style="width:100%">
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          </div>
        </div>
        <p>XF-0 블랙화이트
			<br><b>35,100원</b></p>
      </div>
   	 <div class="w3-container">
      	 <div class="w3-display-container">
        <img src="/resources/shopimages/akiiikr/0140010002593.jpg" style="width:100%">
          <span class="w3-tag w3-display-topleft">Sale</span>
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          	</div>
          </div>
       		 <p>에보 블랙
				<br><b>35,100원</b></p>
      </div>
    </div>
    
	<div class="w3-col l3 s6">
      <div class="w3-container">
        <div class="w3-display-container">
          <img src="/resources/shopimages/akiiikr/0140010001423.jpg" style="width:100%">
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          </div>
        </div>
        <p>고스트 화이트 블루 그린
			<br><b>49,000원</b></p>
      </div>
   	 <div class="w3-container">
      	 <div class="w3-display-container">
        <img src="/resources/shopimages/akiiikr/0140010001833.jpg" style="width:100%">
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          	</div>
          </div>
       		 <p>럼블 화이트 오렌지
				<br><b>69,000원</b></p>
      </div>
    </div>
 
	</div>
	-->
<hr>
 
<%@include file="../default/footer.jsp" %>
<script>


// Open and close sidebar
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}
</script>

</body>
</html>
