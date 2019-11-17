<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String basePath =   request.getScheme() + "://" + 
						request.getServerName() + ":" +
						request.getServerPort()+ 
						request.getContextPath() + "/";
%>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-首页</title>
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
</head>
<body>
	<!--顶部-->
	<div class="top">
		<div class="top_center">
		<!-- 判断customer是否为空，如果为null，证明我们没有登陆过
				显示的就是登陆信息，如果不为空，显示的就是 xxx，您好。 -->
			<ul class="top_lr">		
				<c:if test="${customer == null }">
					<li><a href="jsp/login.jsp" style="color: red;">亲,请登陆</a></li>
					<li><a href="jsp/register.jsp">免费注册</a></li>
				</c:if>
				<c:if test="${customer != null}">
					<li><a> ${customer.username }，您好！</a></li>
					<li><a style="color: green;" href="LoginOutServlet" >退出登陆</a></li>
				</c:if>
			</ul>
			<ul class="top_bars">
				<li><a href="#">我的订单<span class="jt_down"></span></a>|</li>
				<li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
				<li><a href="#">网站导航<span class="jt_down"></span></a></li>
			</ul>
		</div>
	</div>
	<!--头部-->
	<div class="header3">
		<a href="index.html"><img src="images/logo.png"></a>
		<div class="h3_center">
			<div class="search_box">
				<input type="text" /> <span>搜索</span>
			</div>
			<p>
				<c:forEach items="${categoryWithBooks }" var="category" begin="0"
					end="6">
					<a href="ListServlet?id=${category.id}">${category.name}</a>|
            	</c:forEach>
			</p>
		</div>
		<div class="h3_right">
			<div class="myyy">
				<a href="userinfo.html">个人信息</a> <span class="sj_down"></span>
			</div>
			<div class="tsc">
				<a href="emptyCar.html">去购物车结算</a> <span class="sj_right"> </span>
			</div>
		</div>
	</div>
	<!--头部导航-->
	<div class="nav_top">
		<div class="nav_top_center">
			<div>全部图书分类</div>
			<ul>
				<c:forEach items="${categoryWithBooks }" var="category" begin="0"
					end="6">
					<li><a href="ListServlet?id=${category.id}">${category.name }</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>

	<div class="container3">
		<div class="c3_b1">
			<div class="c3_b1_left">
			<!-- 
				展示指定类型，并且展示该类型下的所有书籍。 -->
				<dl>
					<c:forEach items="${categoryWithBooks }" var="category">
						<dd>
						<!-- 展示类型。 -->
						<!-- *********************************************************************** -->
							<h1>${category.name }</h1>
							<p>
								<c:forEach items="${category.books }" var="book" begin="0"
									end="2">
									<!-- 展示对应类型下的所有书籍。 -->
									<!-- 将书籍的id通过get请求的方式传到BookServlet -->
									<a href="BookServlet?id=${book.id }" style="color: blue;">${book.name }</a>
								</c:forEach>
							</p>
						</dd>
					</c:forEach>
				</dl>
			</div>
			<div class="c3_b1_center">
				<div>
					<!-- 圆梦巨人 -->
					<a href="#"><img src="images/ad1.png"></a>
				</div>
				<div class="c3_b1_c_bottom">
					<ul>
						<c:forEach items="${categoryWithBooks}" var="category" begin="2"
							end="2">
							<c:forEach items="${category.books}" var="books" begin="0"
								end="2">
								<li><a href="BookServlet?id=${books.id }"><img
										src="images/p01.png" /></a> <a href="BookServlet?id=${books.id }">${books.name }</a></li>
							</c:forEach>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="c3_b1_right">
				<h1>
					杰普快报<a href="#">更多</a>
				</h1>
				<ul>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
					<li><a href="#">〈加措〉相信这一切都是对我们最好的安排 </a></li>
				</ul>
			</div>
			<div style="clear: both"></div>
		</div>
		<div class="c3_b2">
			<ul>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>畅销书籍</h2>
						<h2>覆盖java基础及全新内容</h2>
						<p>
							<a href="#">更多精彩，点击进入</a>
						</p>
					</div>
				</li>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>畅销书籍</h2>
						<h2>覆盖java基础及全新内容</h2>
						<p>
							<a href="#">更多精彩，点击进入</a>
						</p>
					</div>
				</li>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>畅销书籍</h2>
						<h2>覆盖java基础及全新内容</h2>
						<p>
							<a href="#">更多精彩，点击进入</a>
						</p>
					</div>
				</li>
				<li class="no_mr">
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>畅销书籍</h2>
						<h2>覆盖java基础及全新内容</h2>
						<p>
							<a href="#">更多精彩，点击进入</a>
						</p>
					</div>
				</li>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>畅销书籍</h2>
						<h2>覆盖java基础及全新内容</h2>
						<p>
							<a href="#">更多精彩，点击进入</a>
						</p>
					</div>
				</li>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>畅销书籍</h2>
						<h2>覆盖java基础及全新内容</h2>
						<p>
							<a href="#">更多精彩，点击进入</a>
						</p>
					</div>
				</li>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>畅销书籍</h2>
						<h2>覆盖java基础及全新内容</h2>
						<p>
							<a href="#">更多精彩，点击进入</a>
						</p>
					</div>
				</li>
				<li class="no_mr">
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>畅销书籍</h2>
						<h2>覆盖java基础及全新内容</h2>
						<p>
							<a href="#">更多精彩，点击进入</a>
						</p>
					</div>
				</li>



			</ul>
		</div>
		<div class="c20"></div>
		<!--脚部-->
		<div class="footer3">
			<div class="f3_top">
				<div class="f3_center">
					<div class="ts1">品目繁多 愉悦购物</div>
					<div class="ts2">正品保障 天天低价</div>
					<div class="ts3">极速物流 特色定制</div>
					<div class="ts4">优质服务 以客为尊</div>
				</div>
			</div>
			<div class="f3_middle">
				<ul class="f3_center">
					<li class="f3_mi_li01">
						<h1>购物指南</h1>
						<p>常见问题</p>
						<p>找回密码</p>
						<p>会员介绍</p>
						<p>购物演示</p>
					</li>
					<li class="f3_mi_li01">
						<h1>配送方式</h1>
						<p>常见问题</p>
						<p>找回密码</p>
						<p>会员介绍</p>
						<p>购物演示</p>
					</li>
					<li class="f3_mi_li01">
						<h1>支付方式</h1>
						<p>常见问题</p>
						<p>找回密码</p>
						<p>会员介绍</p>
						<p>购物演示</p>
					</li>
					<li class="f3_mi_li01">
						<h1>售后服务</h1>
						<p>常见问题</p>
						<p>找回密码</p>
						<p>会员介绍</p>
						<p>购物演示</p>
					</li>
					<li class="f3_mi_li01">
						<h1>服务保障</h1>
						<p>常见问题</p>
						<p>找回密码</p>
						<p>会员介绍</p>
						<p>购物演示</p>
					</li>
					<li class="f3_mi_li06">
						<h1>客服中心</h1> <img src="images/qrcode_jprj.jpg" width="80px"
						height="80px">
						<p>抢红包、疑问咨询、优惠活动</p>
					</li>
				</ul>
			</div>
			<div class="f3_bottom">
				<p class="f3_links">
					<a href="#">关于我们</a>| <a href="#">联系我们</a>| <a href="#">友情链接</a>| <a
						href="#">供货商入驻</a>
				</p>
				<p>沪ICP备14033591号-8 杰普briup.com版权所有 杰普软件科技有限公司</p>
				<img src="images/police.png">
			</div>
		</div>
</body>
</html>
