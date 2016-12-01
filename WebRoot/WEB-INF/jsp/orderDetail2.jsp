<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<img border="0" width="13" height="13"
					src="style/css/images/title_arrow.gif" /> 订单菜品列表
				
			</div>
		</div>
		<div id="TitleArea_End"></div>
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
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
			<c:forEach items="${list}" var="od">
				<tr class="TableDetail1">
					<td align="center">${od.food_id}</td>
					<td align="center">${od.foodName}</td>
					<td align="center">${od.price}</td>
	                <td align="center">${od.mprice}</td>
	                	<td align="center">
	                		<c:if test="${od.foodStatus!=0}">√</c:if>
	                		<c:if test="${od.foodStatus==0}">未点</c:if>
	                	</td>
	                	<td align="center">${od.foodCount}</td>
				</tr>
			</c:forEach>
        </tbody>
    </table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
		</div>
		
	</div>
</body>
</html>
