<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>用户费用明细</title>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">   
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script> 

	
</head>
<body>
	<div style="border:0px solid #000;width:100%;padding:10px;">
		
		起始日期：<input id="chartBeginTime" type="text" class="easyui-datebox " editable="false" >&nbsp;&nbsp;
		结束日期：<input id="chartEndtime" type="text"  class="easyui-datebox" editable="false" >&nbsp;&nbsp;
		
		<input id="chartHouseNuber" class="easyui-textbox" data-options="
					label: '房间编号:',
					labelPosition: 'left',
					buttonText: '显示',
					onClickButton:function(){
						var house_number = $('#chartHouseNuber').textbox('getValue');
						if(house_number.trim() == ''){
							alert('请输入房间编号！！！');
						}else{
							displayChartConsumeInfo(house_number);
						}
					}" style="width:260px"/> &nbsp;&nbsp;
		
	</div>
	
	<div id="chart-container"></div>
	
    <script type="text/javascript">
    	
    	function displayChartConsumeInfo(houseNumber){
    	
    	var beginTime = $('#chartBeginTime').textbox('getValue');
    	var endTime = $('#chartEndtime').textbox('getValue');
    	
    		//根据年份统计
	 		$.ajax({
	 			url:"${pageContext.request.contextPath}/consume/displayChartByConsumeInfo.action",
	 			data:{
	 				'houseNumber':houseNumber,
	 				'beginTime':beginTime,
	 				'endTime':endTime
	 			},
	 			type:"post",
	 			dataType:"json",
	 			success:function(data){
	 				console.log("data:"+data.chartData);
	 				if(data != null && data != "" && data != undefined){
	 					
				 		$("#chart-container").insertFusionCharts({
						  type: "msline",
						  width: "100%",
						  height: "700",
						  dataFormat: "json",
						  dataSource: {
						    chart: {
						      caption: beginTime+"~"+endTime+"各费项消费统计",
						      yaxisname: "消费金额",
						      subcaption: "",
						      showhovereffect: "1",
						      numbersuffix: "",
						      drawcrossline: "1",
						      plottooltext: "<b>$dataValue</b> of youth were on $seriesName",
						      theme: "fusion"
						    },
						    categories: data.dateList,
						    dataset: data.chartData
						  }
						});
				 		
				 		
	 				}else{
	 					alert("统计投书信息失败！！！");
	 				}
	 			},
	 			error:function(){
	 				alert("统计投书信息失败！！！");
	 			}
	 		});
	    	
    	}
   
    </script>
</body>
</html>