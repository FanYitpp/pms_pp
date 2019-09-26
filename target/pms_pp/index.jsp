<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>物业管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">


	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>   
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script> 
	
	<script type="text/javascript" src="${path}/js/fusioncharts/fusioncharts.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/fusioncharts/fusioncharts.charts.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/fusioncharts/themes/fusioncharts.theme.fint.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/fusioncharts/jquery-fusioncharts.js"></script>
	
	<link href="<%=basePath %>style/authority/basic_layout.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath %>style/authority/common_style.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath %>style/authority/jquery.fancybox-1.3.4.css" rel="stylesheet" type="text/css" media="screen"></link>
	
	<style>
		.test{
			height:38px;
		}
		.loginInfo{
			border:0px solid #000;
			background-color:#E0ECFF;
			height:40px;
			line-height:40px;
		}
		.loginInfo span{
			display: inline-block;
		}
		.loginInfo .welcome{
			margin-left:10px;
			width:190px;
		}
		.loginInfo .adminLogout{
			margin-right:10px;
			float:right;
		}
	</style>
	
  </head>
  
  <body>
  <div id="layoutID" class="easyui-layout" data-options="fit:true" >
  		<div data-options="region:'north',split:false,height:98" style="background:url('images/logo.gif')0 0 no-repeat">
  			<h2 align="center">天成物业管理系统</h2>
  			<div class="loginInfo">
  				<span class="welcome">欢迎您：${sessionScope.loginAdmin.username}&nbsp;&nbsp;</span>|
  				<span class="newsInfo">如果您在试用时界面显示异常，请将浏览器切换为极速(或IE兼容)模式。&nbsp;&nbsp;</span>
  				<span class="adminLogout"><a href="javascript:void(0);" onclick="logout()">注销退出</a></span>
  			</div>
  		</div>
  		<div data-options="region:'south',split:false" style="height:50px;">
  			<div style="width:700px;margin:0px auto;">©2019 天成物业管理系统 使用系统前必读 | 系统协议 | 隐私政策 | 物业系统合作平台 | 京ICP证TIANCHENG号 <br/>
  				京公网安备TIANCHENG号
  			</div>
  		</div>
    	<div data-options="region:'west',title:'系统菜单',split:false,headerCls:'test'" style="width:200px;">
    		<div id="accordionID" class="easyui-accordion" data-options="multiple:false,selected:-1,border:0,fit:true">
		    	<div title="楼盘管理" data-options="iconCls:'icon-more'" style="overflow:auto;padding:10px;">
		    		<ul id="buildmanagement" class="easyui-tree" data-options="lines:true">  
						<li> 
							<span>小区管理</span>
							<ul>
								<li data-options="attributes:{'url':'${pageContext.request.contextPath}/initcomm.action'}">   
					       			<span>小区列表</span>   
					    		</li>
					    		<li data-options="attributes:{'url':'${pageContext.request.contextPath}/model_add.jsp'}">   
					       			<span>新增小区</span>   
					    		</li>
					    		<li data-options="attributes:{'url':'${pageContext.request.contextPath}/initstyle.action'}">   
					       			<span>户型管理</span>   
					    		</li>
							</ul>  
					         
					    </li>
					    <li> 
							<span>新增小区</span>
							<ul>
								<li>   
					       			<span>新增功能1</span>   
					    		</li>
					    		<li>   
					       			<span>新增功能2</span>   
					    		</li>
							</ul>  
					         
					    </li>
					</ul>
		    	</div>
		    	<div title="费用管理" data-options="iconCls:'icon-lock'" style="overflow:auto;padding:10px;">
		    		<ul id="expensemanagement" class="easyui-tree" data-options="lines:true">  
						<li> 
							<span>费用设置</span>
							<ul>
								<li data-options="attributes:{'url':'<%=basePath %>costitem/costitemInfo.jsp'}">   
					       			<span>费用设定</span>   
					    		</li>
					    		<li data-options="attributes:{'url':'<%=basePath %>expensemanage.action'}">
					       			<span>收费信息</span>
					    		</li>
							</ul>

					    </li>
					    <li>
							<span>费用管理</span>
							<ul>
								<li>
					       			<span>管理功能1</span>
					    		</li>
					    		<li>
					       			<span>管理功能2</span>
					    		</li>
							</ul>
					    </li>
					    <li>
							<span>缴费</span>
							<ul>
								<li>
					       			<span>缴费功能1</span>
					    		</li>
					    		<li>
					       			<span>缴费功能2</span>
					    		</li>
							</ul>
					    </li>
					</ul>
		    	</div>
		    	<div title="统计报表" data-options="iconCls:'icon-man'" style="overflow:auto;padding:10px;">
		    		<ul id="statisticalform" class="easyui-tree" data-options="lines:true">
						<li>
							<span>户主报表</span>
							<ul>
								<li data-options="attributes:{'url':'host/hostinfo.jsp'}">
					       			<span>户主信息查询</span>
					    		</li>
					    		<li>
					       			<span>户主验房对比</span>
					    		</li>
							</ul>

					    </li>
					    <li>
							<span>费用报表</span>
							<ul>
								<li data-options="attributes:{'url':'consume/consumeList.jsp'}">
					       			<span>户主费用明细列表</span>
					    		</li>
					    		<li data-options="attributes:{'url':'consume/consumeChart.jsp'}">
					       			<span>户主费用明细图</span>
					    		</li>
					    		<li>
					       			<span>欠费户主通知</span>
					    		</li>
					    		<li>
					       			<span>户主缴费监控</span>
					    		</li>
					    		<li data-options="attributes:{'url':'consume/statisticsConsume.jsp'}">
					       			<span>常规费用统计</span>
					    		</li>
							</ul>
					    </li>
					    <li>
							<span>车位报表</span>
							<ul>
								<li>
					       			<span>车位查询</span>
					    		</li>
					    		<li>
					       			<span>车位缴费统计</span>
					    		</li>
							</ul>
					    </li>
					</ul>
		    	</div>
		    	<div title="车位管理" data-options="iconCls:'icon-filter'">aaa</div>
		    	<div title="安保管理" data-options="iconCls:'icon-tip'" ></div>
		    	<div title="社区消防" data-options="iconCls:'icon-sum'" ></div>
		    	<div title="保洁绿化" data-options="iconCls:'icon-back'" ></div>
		    	<div title="服务管理" data-options="iconCls:'icon-redo'" ></div>
		    	<div title="辅助管理" data-options="iconCls:'icon-undo'" ></div>
		    	<div title="行政管理" data-options="iconCls:'icon-help'" ></div>
		    	<div title="系统管理" data-options="iconCls:'icon-search'" ></div>
		    	<div title="参数配置" data-options="iconCls:'icon-reload'" ></div>
    		</div>
    	</div>
    	<div data-options="region:'east',title:'新闻通知',split:false,headerCls:'test'" style="width:200px">
    		<ul>
    			<li><a href="javascript:void(0);">新闻1</a></li>
    			<li><a href="javascript:void(0);">新闻2</a></li>
    			<li><a href="javascript:void(0);">新闻3</a></li>
    			<li><a href="javascript:void(0);">新闻4</a></li>
    			<li><a href="javascript:void(0);">新闻5</a></li>
    			<li><a href="javascript:void(0);">新闻6</a></li>
    			<li><a href="javascript:void(0);">新闻7</a></li>
    			<li><a href="javascript:void(0);">新闻8</a></li>
    			<li><a href="javascript:void(0);">新闻9</a></li>
    		</ul>
    	</div>
    	<div data-options="region:'center',split:true" style="padding:0px;">
    		<div id="tabsID" class="easyui-tabs" data-options="pill:true,border:false,plain:false,fit:true">
	    		<div title="首页" style="padding:10px;display:none;">
			         这么巧，你也在这里。<br/>
			   	不，我在等你！
			    </div>
    		</div>
    	</div>
  </div>

  <div id="logout"><span style="padding:20px;"><b>真的要要要退出吗？确定不再多看我一眼了吗？</b></span></div>

  </body>
    <script type="text/javascript">

  		$(function(){
			$("#buildmanagement,#expensemanagement,#statisticalform").tree({
				onClick : function(node){
					var father = $(this).tree("getParent",node.target);
					if(father != null){
						var text = node.text;
						var flag = $("#tabsID").tabs("exists",text);
						if(!flag){
							var url = node.attributes.url;
				  			$("#tabsID").tabs("add",{
				  				"title"    : text,
				  				"closable" : true,
				  				"href"     : url,
				  				"iconCls"  : "icon-save"
				  			});
						}else{
							$("#tabsID").tabs("select",text);
						}
					}
				}
			});
		});

		function logout(){
			$('#logout').dialog({
			    title: '退出',
			    width: 250,
			    height: 150,
			    closed: false,
			    cache: false,
			    modal: true,
			    buttons:[{
					text:'撒手离去',
					handler:function(){
						$.ajax({
				 			url:"${pageContext.request.contextPath}/admin/logout.action",
				 			type:"post",
				 			success:function(){
				 				window.location.href="${pageContext.request.contextPath}/login.jsp";
				 			},
				 			error:function(){
				 				alert("退出失败！");
				 			}
	 					});
					}
				},{
					text:'再看一眼',
					handler:function(){
						$('#logout').dialog("close");
					}
				}]
			}); 
			
		}
  		
  </script> 
  
</html>
