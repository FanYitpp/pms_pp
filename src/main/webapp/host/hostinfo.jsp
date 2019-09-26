<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>业主信息查询</title>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">   
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>   
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script> 

</head>
<body>
	<div style="border:0px solid #000;width:100%;padding:10px;">
		小区：<input id="comm" class="easyui-combobox" data-options="    
			        valueField: 'communityId',    
			        textField: 'communityName',
			        limitToList: true, 
			        panelHeight: 130,   
			        url: '${pageContext.request.contextPath}/community/selectCommList.action',    
			        onSelect: function(rec){    
			            var url = '${pageContext.request.contextPath}/building/selectBuildByComm.action?commId='+rec.communityId;      
			            $('#build').combobox('clear',true);
			            $('#unit').combobox('clear',true);
			            $('#build').combobox('reload', url);
			            $('#unit').combobox('disable',true);
			        }" /> &nbsp;&nbsp;  
		楼宇：<input id="build" class="easyui-combobox" data-options="    
			        valueField: 'buildingId',
			        textField: 'buildingName',
			        limitToList: true,
			        panelHeight: 130,
			        onSelect: function(rec){    
			            var url = '${pageContext.request.contextPath}/unit/selectUnitByBuild.action?buildId='+rec.buildingId;    
			           	$('#unit').combobox('clear',true);
			           	$('#unit').combobox('enable',true);
			            $('#unit').combobox('reload', url);    
			        }" />  &nbsp;&nbsp;  
		单元：<input id="unit" class="easyui-combobox" data-options="valueField:'unitId',limitToList: true,textField:'unitName',panelHeight: 130" /> &nbsp;&nbsp;
		业主名称：<input id="hostName" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:100px"> &nbsp;&nbsp;
		<a id="query" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> &nbsp;&nbsp;
		<a id="clearInfo"  class="easyui-linkbutton" data-options="iconCls:'icon-clear'">清空数据</a> &nbsp;&nbsp;
		<a id="printInfo"  class="easyui-linkbutton" data-options="iconCls:'icon-print'">导出数据</a> &nbsp;&nbsp;
		
		<input id="houseNumber" class="easyui-textbox" data-options="
					label: '房间编号:',
					labelPosition: 'left',
					buttonText: 'Search',
					onClickButton:function(){
						var houseNumber = $('#houseNumber').textbox('getValue');
						if(houseNumber == ''){
							alert('请输入房间编号！！！');
						}else{
							var url = '${pageContext.request.contextPath}/host/selectHostByHouseNumber.action?houseNumber='+houseNumber; 
							$('#dg').datagrid('reload',url);
						}
					}" style="width:260px"/> &nbsp;&nbsp;
		
		
		<script type="text/javascript">
			$(function(){   
			 
			    $('#query').bind('click', function(){  
			    	getDateGrid();
			    });
			    
			    $("#printInfo").click(function(){
				    var commId = $("#comm").val();
		    		if(commId == ""){
		    			commId = "0"
		    		}
		    		var buildId = $("#build").val();
		    		if(buildId == ""){
		    			buildId = "0"
		    		}
		    		var unitId = $("#unit").val();
		    		if(unitId == ""){
		    			unitId = "0"
		    		}
		    		var hostName = $("#hostName").val();
		    		window.open("${pageContext.request.contextPath}/host/exportExcelInfo.action?commId="+commId+"&buildId="+buildId+"&unitId="+unitId+"&hostName="+hostName+"");

			    }); 
			    
			    $("#clearInfo").click(function(){
			    	$('#comm').combobox('clear',true);
			    	$('#build').combobox('clear',true);
			    	$('#unit').combobox('clear',true);
			    	$('#hostName').textbox('clear',true);
			    });
			});  
		</script>
	</div>
	
	<table id="dg" ></table>
	
    <script type="text/javascript">
    
    	$(function(){
    		getDateGrid();
    	});
    
    
    	function getDateGrid(){
    		
    		var commId = $("#comm").val();
    		if(commId == ""){
    			commId = "0"
    		}
    		var buildId = $("#build").val();
    		if(buildId == ""){
    			buildId = "0"
    		}
    		var unitId = $("#unit").val();
    		if(unitId == ""){
    			unitId = "0"
    		}
    		var hostName = $("#hostName").val();
    	
    		$("#dg").datagrid({
    			broder:20,
	    		toolbar: '#tb',
	    		striped: true,
	    		fit: false,
	    		border:false,
	    		queryParams: {
		        	commId: commId,
		        	buildId: buildId,
		        	unitId: unitId,
		        	hostName:hostName
		        },
	    		url : '${pageContext.request.contextPath}/host/hostByCond.action?time='+new Date().getTime(),
	    		columns : [[
	    				{field:'hnum',title:'房间编号',width:'10%',halign:'center',align:'center',rowspan:2,
	    					styler: function(value,row,index){
									return 'background-color:#ffffff;color:#000000;';
							}
	    				},
	    				{field:'uname',title:'所属单元',width:'20%',halign:'center',align:'center',rowspan:2},
	    				{field:'hname',title:'房间号',width:'10%',halign:'center',align:'center',rowspan:2},
	    				{field:'host_name',title:'业主',width:'10%',halign:'center',align:'center',rowspan:2},
	    				{field:'host_gender',title:'性别',width:'10%',halign:'center',align:'center',rowspan:2},
	    				{field:'host_link',title:'联系电话1',width:'10%',halign:'center',align:'center',rowspan:2},
	    				{field:'host_link2',title:'联系电话2',width:'10%',halign:'center',align:'center',rowspan:2},
	    				{field:'host_card',title:'证件号码',width:'10%',halign:'center',align:'center',rowspan:2},
	    				{field:'htime',title:'入住时间',width:'10%',halign:'center',align:'center',rowspan:2,
	    					formatter : function(date){
	    						var hdate = new Date(date);
	    						return hdate.getFullYear()+"年" +(hdate.getMonth()+1)+"月"+hdate.getDate()+"日";
	    					}
	    				}   				
	    		],[]],
	    		fitColums : true,
	    		singleSelect : true,
	    		pagination : true,
	    		pageNumber   : 1,
	    		pageSize : 15,
	    		pageList : [10,15,20]
	    	});
    	} 
    	
    </script>
</body>
</html>