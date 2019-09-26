<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
		var blist = new Array();
		var ulist = new Array();
		var hlist = new Array();
		var commlist = new Array();
		var cilist = new Array();
		function init() {
			if (sessionStorage.getItem("commlist") != null) {
				commlist = sessionStorage.getItem("commlist");
				for (var i = 0; i < commlist.length; i++) {
					var str = commlist[i].split(",");
					$("#fyXq").append("<option value=" + str[0] + ">" + str[1] + "</option>");
				}
			}
			if (sessionStorage.getItem("blist") != null) {
				blist = sessionStorage.getItem("blist");
				for (var i = 0; i < blist.length; i++) {
					var str = blist[i].split(",");
					$("#fyDh").append("<option value=" + str[0] + ">" + str[1] + "</option>");
				}
			}
			if (sessionStorage.getItem("ulist") != null) {
				ulist = sessionStorage.getItem("ulist");
				for (var i = 0; i < ulist.length; i++) {
					var str = ulist[i].split(",");
					$("#fyDy").append("<option value=" + str[0] + ">" + str[1] + "</option>");
				}
			}
			if (sessionStorage.getItem("hlist") != null) {
				hlist = sessionStorage.getItem("hlist");
				for (var i = 0; i < hlist.length; i++) {
					var str = hlist[i].split(",");
					$("#fyFh").append("<option value=" + str[0] + ">" + str[1] + "</option>");
				}
			}
			if (sessionStorage.getItem("cilist") != null) {
				hlist = sessionStorage.getItem("cilist");
				for (var i = 0; i < cilist.length; i++) {
					var str = cilist[i].split(",");
					$("#fyFylx").append("<option value=" + str[0] + ">" + str[1] + "</option>");
				}
			}
			if (sessionStorage.getItem("commid") != null && sessionStorage.getItem("commid") != "") {
				$("#fyXq").val(sessionStorage.getItem("commid"));
			}
			if (sessionStorage.getItem("buildingid") != null && sessionStorage.getItem("buildingid") != "") {
				$("#fyDh").val(sessionStorage.getItem("buildingid"));
			}
			if (sessionStorage.getItem("unitid") != null && sessionStorage.getItem("unitid") != "") {
				$("#fyDy").val(sessionStorage.getItem("unitid"));
			}
			if (sessionStorage.getItem("houseid") != null && sessionStorage.getItem("houseid") != "") {
				$("#fyFh").val(sessionStorage.getItem("houseid"));
			}
			if (sessionStorage.getItem("costitemid") != null && sessionStorage.getItem("costitemid") != "") {
				$("#fyFylx").val(sessionStorage.getItem("costitemid"));
			}
			if (sessionStorage.getItem("firsttime") != null && sessionStorage.getItem("firsttime") != "") {
				$("#firsttime").val(sessionStorage.getItem("firsttime"));
			}
			if (sessionStorage.getItem("lasttime") != null && sessionStorage.getItem("lasttime") != "") {
				$("#lasttime").val(sessionStorage.getItem("lasttime"));
			}
			if (sessionStorage.getItem("housenumber") != null && sessionStorage.getItem("housenumber") != "") {
				$("#hn").val(sessionStorage.getItem("housenumber"));
			}
			if (sessionStorage.getItem("hostname") != null && sessionStorage.getItem("hostname") != "") {
				$("#hostname").val(sessionStorage.getItem("hostname"));
			}
		}

		function setBuilding() {
			$.ajax({
				type : "POST",
				url : "<%=basePath %>selectByCommunityId.action",
				data : {
					buildingCommunityId : $("#fyXq").val()
				},
				success : function(data) {
					$("#fyDh").empty();
					$("#fyDh").append("<option value='0'>--请选择--</option>");
					blist = data.split(";");
					for (var i = 0; i < blist.length; i++) {
						var str = blist[i].split(",");
						$("#fyDh").append("<option value=" + str[0] + ">" + str[1] + "</option>");
					}

				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(textStatus + "\t" + errorThrown);
				}
			});
		}
		function setUnit() {
			$.ajax({
				type : "POST",
				url : "<%=basePath %>selectByBuildingId.action",
				data : {
					unitBuildingId : $("#fyDh").val()
				},
				success : function(data) {
					$("#fyDy").empty();
					$("#fyDy").append("<option value='0'>--请选择--</option>");
					ulist = data.split(";");
					for (var i = 0; i < ulist.length; i++) {
						var str = ulist[i].split(",");
						$("#fyDy").append("<option value=" + str[0] + ">" + str[1] + "</option>");
					}

				}
			});
		}
		function setHouse() {
			$.ajax({
				type : "POST",
				url : "<%=basePath %>selectByUnitId.action",
				data : {
					houseUnitId : $("#fyDy").val()
				},
				success : function(data) {
					$("#fyFh").empty();
					$("#fyFh").append("<option value='0'>--请选择--</option>");
					hlist = data.split(";");
					for (var i = 0; i < hlist.length; i++) {
						var str = hlist[i].split(",");
						$("#fyFh").append("<option value=" + str[0] + ">" + str[1] + "</option>");
					}
				}
			});
		}
		function submit() {
			var commid = $("#fyXq").val();
			var buildingid = $("#fyDh").val();
			var unitid = $("#fyDy").val();
			var houseid = $("#fyFh").val();
			var costitemid = $("#fyFylx").val();
			var firsttime = $("#firsttime").val();
			var lasttime = $("#lasttime").val();
			var hn = $("#hn").val();
			var hostname = $("#hostname").val();
			var i = 0;
			$("#fyXq option").each(function() {
				if (i = 0) {
					i++;
				} else {
					commlist[i - 1] = $(this).val() + "," + $(this).text();
					i++;
				}
			});
			i = 0;
			$("#fyFylx option").each(function() {
				if (i = 0) {
					i++;
				} else {
					cilist[i - 1] = $(this).val() + "," + $(this).text();
					i++;
				}
			});

			sessionStorage.setItem("commlist", commlist);

			if (blist != "" && blist != null) {
				sessionStorage.setItem("commid", commid);
				sessionStorage.setItem("blist", blist);

				if (ulist != null && ulist != "") {
					sessionStorage.setItem("buildingid", buildingid);
					sessionStorage.setItem("ulist", ulist);

					if (hlist != null && hlist != "") {
						sessionStorage.setItem("unitid", unitid);
						sessionStorage.setItem("hlist", hlist);
						if (houseid != null) {
							sessionStorage.setItem("houseid", houseid);
						}
					}
				}
			}
			sessionStorage.setItem("cilist", cilist);
			sessionStorage.setItem("costitemid", costitemid);
			sessionStorage.setItem("firsttime", firstitem);
			sessionStorage.setItem("lasttime", lasttime);
			sessionStorage.setItem("housenumber", hn);
			sessionStorage.setItem("hostname", hostname);
			document.form1.submit();
		}
</script>
	<input type="hidden" name="allIDCheck" value="" id="allIDCheck" />
	<input type="hidden" name="fangyuanEntity.fyXqName" value="" id="fyXqName" />
	<div id="container">
		<div class="ui_content">
			<div class="ui_text_indent">
				<div id="box_border">

					<div id="box_top">搜索</div>
					<form name="form1" action="<%=basePath%>search.action"
						method="post" target="rightBottom">
						<!-- target="rightBottom" -->
						<div id="box_center">
							小区 <select name="communityId" id="fyXq" class="ui_select01"
								onchange="setBuilding()">
								<option value="0">--请选择--</option>
								<c:forEach items="${requestScope.commlist}" var="comm">
									<option value="${comm.communityId }">${comm.communityName}</option>
								</c:forEach>
							</select> 栋号 <select name="buildingId" id="fyDh" class="ui_select01"
								onchange="setUnit()">
								<option value="0">--请选择--</option>
							</select> 单元 <select name="unitId" id="fyDy" class="ui_select01"
								onchange="setHouse()">
								<option value="0">--请选择--</option>

							</select> 房间号 <select name="houseId" id="fyFh" class="ui_select01">
								<option value="0">--请选择--</option>

							</select> 费用类型 <select id="fyFylx" name="costitemId" class="ui_select01">
								<option value="0">--请选择--</option>
								<c:forEach items="${requestScope.cilist}" var="ci">
									<option value="${ci.costitemId}">${ci.costitemName}</option>
								</c:forEach>
							</select>

						</div>

						<div id="box_bottom" style="position: relative;left: 0px;">
							时间范围<input style="height: 20px;" type="text" id="firsttime"
								name="firsttime" onclick="WdatePicker()" size="10"> - <input
								style="height: 20px;" type="text" id="lasttime" name="lasttime"
								size="10" onclick="WdatePicker()"> 房屋编号 <input
								style="height: 20px;" type="text" name="houseNumber" id="hn"
								size="10"> 户主姓名 <input style="height: 20px;" type="text"
								name="hostName" id=hostname> <input type="button"
								style="position:absolute; right: 0px;bottom: 0px;" value="查询"
								class="ui_input_btn01" onclick="submit()" />
							<!-- <input type="button" value="新增" class="ui_input_btn01" id="addBtn" /> 
							<input type="button" value="删除" class="ui_input_btn01" onclick="batchDel();" /> 
							<input type="button" value="导入" class="ui_input_btn01" id="importBtn" />
							<input type="button" value="导出" class="ui_input_btn01" onclick="exportExcel();" /> -->
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="iframe">
			<iframe name="rightBottom" id="rightBottom" display="none"
				scrolling="auto" width="100%" height="100%"></iframe>
			<!--frameborder="no" scrolling="auto" width="100%" height="100%" allowtransparency="true"  -->
		</div>
	</div>
	
	
<script type="text/javascript" src="scripts/datePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath %>scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="<%=basePath %>scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="<%=basePath %>scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="<%=basePath %>scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript" src="<%=basePath %>scripts/artDialog/artDialog.js?skin=default"></script>

