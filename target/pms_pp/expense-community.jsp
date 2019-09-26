<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'expense-community.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="style/authority/basic_layout.css" rel="stylesheet" type="text/css">
	<link href="style/authority/common_style.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="scripts/authority/commonAll.js"></script>
	<script type="text/javascript" src="scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
	<script type="text/javascript" src="scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
	<link rel="stylesheet" type="text/css" href="style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
	<script type="text/javascript" src="scripts/artDialog/artDialog.js?skin=default"></script>
	<script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
	<script type="text/javascript">	
		function changenum(pagesize){
			$("#pagesize").val(pagesize);
			document.form1.submit();
		}
		function init(){
		 $("select").val("${lg.pagesize}")
		}
	</script>
  </head>
  
  <body onload="init()">
  <h3>${requestScope.add}</h3>
  	<div id="box_bottom">
		<input type="button" value="导入" class="ui_input_btn01" id="importBtn" />
		<input type="button" value="导出" class="ui_input_btn01" onclick="exportExcel();" />
	</div>
   <table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
   	<tr>
		<th>房屋地址</th>
		<th>房屋名</th>
		<th>户主名</th>
		<th>费项</th>
		<th>总费用</th>
		<th>缴费时间</th>
		
	</tr>
	<%-- <tr>
	<td>${pagesize}</td>
	<td>${pagenum}</td>
	<td>${consumelist}</td>
	</tr> --%>
	
	<c:forEach items="${consumelist}" var="link">
	<tr>
		<td>${link.unit_name}</td>
		<td>${link.house_name}</td>
		<td>${link.host_name}</td>
		<td>${link.costitem_name}</td>
		<td>${link.consume_count}</td>
		<td>${link.consume_time}</td>
		
	</tr>
	</c:forEach>
	<%-- <c:forEach items="${list}" var="link">
	<tr>
	<c:forEach items="${link}" var="enpty">
	<td>${enpty.value}</td>
	</c:forEach>
	</tr>
	</c:forEach> --%>
	
	</table>
	<div id="box_bottom" align="center">
	<form action="<%=basePath %>pagechange.action" method="post" name="form1">
	<input type="hidden" name="communityId" value="${lg.communityId}">
	<input type="hidden" name="buildingId" value="${lg.buildingId}">
	<input type="hidden" name="unitId" value="${lg.unitId}">
	<input type="hidden" name="houseId" value="${lg.houseId}">
	<input type="hidden" name="costitemId" value="${lg.costitemId}">
	<input type="hidden" name="firsttime" value="${lg.firsttime}">
	<input type="hidden" name="lasttime" value="${lg.lasttime}">
	<input type="hidden" name="houseNumber" value="${lg.houseNumber}">
	<input type="hidden" name="hostName" value="${lg.hostName}">
	<input type="hidden" name="pagesize" value="${lg.pagesize}">
	<input type="hidden" name="pagenum" value="${lg.pagenum}">
	<input type="hidden" id="pagesize" name="page">
	<input type="hidden" name="num" value="${num}">
	</form>
		<input type="button" value="首页"  onclick="changenum(0)" /> 
		<input type="button" value="上一页" onclick="changenum(${lg.pagesize-1})" />
		<select id="select" name="pagenum" onchange="changenum(this.value)">
		<c:forEach begin="1" end="${num}" step="1" var="i">
		<option value="${i-1}">${i}</option>
		</c:forEach>
		</select>
		<input type="button" value="下一页"  onclick="changenum(${lg.pagesize+1})" />
		<input type="button" value="尾页"  onclick="changenum(${num-1})" /> 
	</div>
  </body>
</html>
