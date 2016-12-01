<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
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
			<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 餐桌列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 过滤条件 -->
<div id="QueryArea">
	<form action="/wirelessplatform/board.html" method="get">
		<input type="hidden" name="method" value="search">
		<input type="text" name="keyword" title="请输入餐桌名称">
		<input type="submit" value="搜索">
	</form>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>编号</td>
				<td>桌名</td>
				<td>状态</td>
				<td>预定时间</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
			<c:forEach items="${list}" var="dt">
				<tr>
					<td align="center">${dt.id}</td>
					<td align="center">${dt.tableName}</td>
					<td align="center">
						<c:if test="${dt.tableStatus==1}">预定</c:if>
						<c:if test="${dt.tableStatus==0}">空闲</c:if>
					</td>
					<td align="center">${dt.orderDate}</td>
					<td align="center">
						<c:if test="${dt.tableStatus==1}"><a href="${dt.id}/unsubscribe.do" class="FunctionButton">退桌</a></c:if>				
						<c:if test="${dt.tableStatus==0}"><a href="${dt.id}/reserve.do" class="FunctionButton">预定</a></c:if>				
						<a href="${dt.id}/delete.do" onClick="return delConfirm();"class="FunctionButton">删除</a>
					</td>
				</tr>
			</c:forEach>
        </tbody>
    </table>
	
   <!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
		<div class="FunctionButton"><a href="toSaveBoard.do">添加</a></div>
		<table align="right">
			  <tr>
			     <!-- 1 界面中可以直接从page中取值 是因为 Page作为方法的参数 会被传过来
			          2 ?currentPage 传回到方法中的时候 可以自动的被 page接受 因为currentPage跟类中的变量名相同-->
			     <td>
			      <!-- 第一页的时候 -->
			      <c:if test="${page.currentPage==1}">
			         <a href="boardList.do?currentPage=1">上一页</a>
			      </c:if>
			      <c:if test="${page.currentPage!=1}">
			         <a href="boardList.do?currentPage=${page.currentPage-1}">上一页</a>
			      </c:if>
			      
			      <!-- 循环显示页码 -->
			      <c:forEach begin="1" end="${page.totalPage}" var="p">
			         <c:if test="${page.currentPage==p}">${p}</c:if><!-- 当前页时候不显示超链接 -->
			
			         <c:if test="${page.currentPage!=p}">
			           <a href="boardList.do?currentPage=${p}">${p}</a>
			         </c:if>
			      </c:forEach>
			      </td>
			      <td>
			       <c:if test="${page.currentPage==page.totalPage}">
			        <a href="boardList.do?currentPage=${page.totalPage}">下一页</a>
			       </c:if>
			       
			       <c:if test="${page.currentPage!=page.totalPage}">
			        <a href="boardList.do?currentPage=${page.currentPage+1}">下一页</a>
			       </c:if>
			       <!--********* JS里面可以用EL表达式取值 ****************-->
			     </td>
			   </tr>
		</table>
    </div> 
</div>
</body>
</html>
