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
<link href="${pageContext.request.contextPath}/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/css/index_1.css" />
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 菜品列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="/wirelessplatform/food.html" method="get">
			<input type="hidden" name="method" value="search">
			<input type="text" name="keyword" title="请输入菜品名称">
			<input type="submit" value="搜索">
		</form>
	</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>菜编号</td>
				<td>菜名</td>
				<td>价格</td>
                <td>会员价格</td>
                <td>订餐状态</td>
                <td>数量</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
			<c:forEach items="${list}" var="f">
				<tr class="TableDetail1">
					<td align="center">${f.id}</td>
					<td align="center">${f.foodName}</td>
					<td align="center">${f.price}</td>
	                <td align="center">${f.mprice}</td>
	                	<td align="center">
	                		<c:if test="${f.foodStatus!=0}">√</c:if>
	                		<c:if test="${f.foodStatus==0}">未点</c:if>
	                	</td>
	                	<td align="center">${f.foodCount}</td>
					<td align="center">
					
						
						<a href="${f.id}/AdditionFood.do"  class="FunctionButton">+</a>		
						<c:choose>
							<c:when test="${f.foodCount!=0}">
								<a href="${f.id}/SubtractionFood.do"  class="FunctionButton">-</a>
							</c:when>
							<c:when test="${f.foodCount==0}">
								<a href="${f.id}/SubtractionFood.do" style="pointer-events: none;cursor: default;color: red;" class="FunctionButton">-</a>
							</c:when>
						</c:choose>		
						<a href="${f.id}/cancel.do"  class="FunctionButton">取消</a>	
					</td>
				</tr>
			</c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
