<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 /*
 section#content ul li { display:inline-block; margin:10px; }
 section#content div.goodsThumb img { width:200px; height:200px; }
 section#content div.goodsName { padding:10px 0; text-align:center; }
 section#content div.goodsName a { color:#000; }
 */
 section#content ul li { margin:10px 0; }
 section#content ul li img { width:250px; height:250px; }
 section#content ul li::after { content:""; display:block; clear:both; }
 section#content div.thumb { float:left; width:250px; }
 section#content div.goodsInfo { float:right; width:calc(100% - 270px); }
 section#content div.goodsInfo { font-size:20px; line-height:2; }
 section#content div.goodsInfo span { display:inline-block; width:100px; font-weight:bold; margin-right:10px; }
 section#content div.goodsInfo .delete {float:right;}
 section#content div.goodsInfo .delete button { font-size:22px;
            padding:5px 10px; border:1px solid #eee; background:#eee;}
.allCheck { float:left; width:200px; }
.allCheck input { width:16px; height:16px; }
.allCheck label { margin-left:10px; }
.delBtn { float:right; width:300px; text-align:right; }
.delBtn button { font-size:18px; padding:5px 10px; border:1px solid #eee; background:#eee;}

.checkBox { float:left; width:30px; }
.checkBox input { width:16px; height:16px; }
.listResult { padding:20px; background:#eee; }
.listResult .sum { float:left; width:45%; font-size:22px; }

.listResult .orderOpne { float:right; width:45%; text-align:right; }
.listResult .orderOpne button { font-size:18px; padding:5px 10px; border:1px solid #999; background:#fff;}
.listResult::after { content:""; display:block; clear:both; }
</style>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../default/header.jsp" %>
<section id="container">
		<div id="container_box">
			<section id="content">
			<form action="/member/order" method="post">
				<ul>
					<li>
						<div class="allCheck">
						
							<input type="checkbox" name="allCheck" id="allCheck" /><label
								for="allCheck">모두 선택</label>
							<script>
								$("#allCheck").click(function() {
									var chk = $("#allCheck").prop("checked");
									if (chk) {
										$(".chBox").prop("checked", true);
									} else {
										$(".chBox").prop("checked", false);
									}
								});
							</script>
						</div>

						<div class="delBtn">
							<button type="button" class="selectDelete_btn">선택 삭제</button>
							<script>
							 $(".selectDelete_btn").click(function(){
							  var confirm_val = confirm("정말 삭제하시겠습니까?");
							  
							  if(confirm_val) {
							   var checkArr = new Array();
							   
							   $("input[class='chBox']:checked").each(function(){
							    checkArr.push($(this).attr("data-cartNum"));
							   });
							    
							   $.ajax({
								   url : "/member/deleteCart",
								   type : "post",
								   data : { chbox : checkArr },
								   success : function(result){
								    if(result == 1) {          
								     location.href = "/member/cartList";
								    } else {
								     alert("삭제 실패");
								    }
								   }
								  });
							  }
							 });
							</script>
						</div>
					</li>
					
					<c:set var="sum" value="0" />
					
					<c:forEach items="${cartList}" var="cartList">
						<li>
							<div class="checkBox">
								<input type="checkbox" name="chBox" class="chBox"
									data-cartNum="${cartList.cartNum}" />
								<script>
									$(".chBox").click(function() {
										$("#allCheck").prop("checked", false);
									});
								</script>
							</div>

							<div class="thumb">
								<img src="${cartList.goodsThumbImage}" />
							</div>
							<div class="goodsInfo">
								<p>
									<span>상품명</span>${cartList.goodsName}<br> 
									<span>사이즈</span>${cartList.goodsSize}mm<br>
									<span>개당 가격</span>
									<fmt:formatNumber pattern="###,###,###"
										value="${cartList.goodsPrice}" />
									원<br /> <span>구입 수량</span>${cartList.cartStock} 개<br /> <span>최종
										가격</span>
									<fmt:formatNumber pattern="###,###,###"
										value="${cartList.goodsPrice * cartList.cartStock}" />
									원
								</p>

								<div class="delete">
									<button type="button" class="delete_${cartList.cartNum}_btn"
										data-cartNum="${cartList.cartNum}">삭제</button>

									<script>
									  $(".delete_${cartList.cartNum}_btn").click(function(){
									   var confirm_val = confirm("정말 삭제하시겠습니까?");
									   
									   if(confirm_val) {
									    var checkArr = new Array();
									    
									    checkArr.push($(this).attr("data-cartNum"));
									               
									    $.ajax({
									     url : "/member/deleteCart",
									     type : "post",
									     data : { chbox : checkArr },
									     success : function(result){
									      if(result == 1) {     
									       location.href = "/member/cartList";
									      } else {
									       alert("삭제 실패");
									      }
									     }
									    });
									   } 
									  });
									 </script>
								</div>
							</div>
						</li>
						
					<c:set var="sum" value="${sum + (cartList.goodsPrice * cartList.cartStock)}" />
					
					</c:forEach>
				</ul>

				<div class="listResult">
					<div class="sum">
						총 합계 :
						<fmt:formatNumber pattern="###,###,###" value="${sum}" />
						원
					</div>
					<div class="orderOpne">
						<input type="submit" class="orderOpne_bnt" value="전체 상품 주문하기">
					</div>
				</div>
				</form>
			</section>
		</div>
	</section>
	
<%@ include file="../default/footer.jsp" %>
</body>
</html>