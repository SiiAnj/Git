<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" /> 菜系列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="/wirelessplatform/cuisine.html" method="get">
			<input type="hidden" name="method" value="search">
			<input type="text" name="keyword" title="请输入菜系名称">
			<input type="submit" value="搜索">
		</form>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>菜系编号</td>
					<td>菜系名称</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<c:forEach items="${list}" var="ft">
					<tr>
						<td align="center">${ft.id}</td>
						<td align="center">${ft.typeName}</td>
						<td align="center">
							<a href="${ft.id}/toUpdateCuisine.do" class="FunctionButton">更新</a> 
							<a href="${ft.id}/deleteCuisine.do" class="FunctionButton">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="toSaveBoard.do">添加</a>
			</div>
			<table align="right">
			  <tr>
			     <!-- 1 界面中可以直接从page中取值 是因为 Page作为方法的参数 会被传过来
			          2 ?currentPage 传回到方法中的时候 可以自动的被 page接受 因为currentPage跟类中的变量名相同-->
			     <td>
			      <!-- 第一页的时候 -->
			      <c:if test="${page.currentPage==1}">
			         <a href="cuisineList.do?currentPage=1">上一页</a>
			      </c:if>
			      <c:if test="${page.currentPage!=1}">
			         <a href="cuisineList.do?currentPage=${page.currentPage-1}">上一页</a>
			      </c:if>
			      
			      <!-- 循环显示页码 -->
			      <c:forEach begin="1" end="${page.totalPage}" var="p">
			         <c:if test="${page.currentPage==p}">${p}</c:if><!-- 当前页时候不显示超链接 -->
			
			         <c:if test="${page.currentPage!=p}">
			           <a href="cuisineList.do?currentPage=${p}">${p}</a>
			         </c:if>
			      </c:forEach>
			      </td>
			      <td>
			       <c:if test="${page.currentPage==page.totalPage}">
			        <a href="cuisineList.do?currentPage=${page.totalPage}">下一页</a>
			       </c:if>
			       
			       <c:if test="${page.currentPage!=page.totalPage}">
			        <a href="cuisineList.do?currentPage=${page.currentPage+1}">下一页</a>
			       </c:if>
			       <!--********* JS里面可以用EL表达式取值 ****************-->
			     </td>
			   </tr>
		</table>
		</div>
	</div>
</body>
</html>
