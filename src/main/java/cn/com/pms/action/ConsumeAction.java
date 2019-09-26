package cn.com.pms.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.pms.model.Costitem;
import cn.com.pms.service.ConsumeService;
import cn.com.pms.service.CostitemService;

@Controller
@RequestMapping("/consume")
public class ConsumeAction {
	
	@Autowired
	private ConsumeService consumeService;
	
	@Autowired
	private CostitemService costitemService;
	
	//根据房间编号查询用户信息
	@RequestMapping(value="/queryConsumeInfoByHouseNumber")
	public @ResponseBody Map<String, Object> queryConsumeInfoByHouseNumber(String houseNumber,String beginTime,String endTime,Integer page,Integer rows) {
		List<Map<String , Object>> consumeInfo = consumeService.queryConsumeInfoByHouseNumber(houseNumber,beginTime,endTime,page,rows);
		Map<String , Object> map = new LinkedHashMap<String, Object>();
		map.put("total", consumeService.queryConsumeInfoByHouseNumberCount(houseNumber,beginTime,endTime));
		map.put("rows", consumeInfo);
		return map;
	}
	
	//显示统计图
	@RequestMapping(value="/displayChartByConsumeInfo")
	public @ResponseBody Map<String, Object> displayChartByConsumeInfo(String houseNumber,String beginTime,String endTime) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		List<Map<String , Object>> dateMap = new ArrayList<Map<String,Object>>();
		try {
			Date beginDate = sdf.parse(beginTime);
			Date endDate = sdf.parse(endTime);
			List<Map<String , Object>> dateList = getDatesBetweenTwoDate(beginDate, endDate);//获取一个时间段集合
			Map<String , Object> map = new LinkedHashMap<String, Object>();
			map.put("category", dateList);
			dateMap.add(map);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<Costitem> costList = costitemService.selectCostitemList();//获取所有费项集合
		List<Map<String , Object>> dataMap = new ArrayList<Map<String,Object>>();
		
		for (int i = 0; i < costList.size(); i++) {//根据费项遍历获取所有消费信息
			Map<String , Object> map = new LinkedHashMap<String, Object>();
			map.put("seriesname", costList.get(i).getCostitemName());
			List<Map<String, Object>> consumeInfo = consumeService.displayChartByConsumeInfo(houseNumber, costList.get(i).getCostitemId(), beginTime, endTime);
			map.put("data", consumeInfo);
			dataMap.add(map);
		}
		Map<String , Object> map = new LinkedHashMap<String, Object>();
		map.put("chartData", dataMap);
		map.put("dateList", dateMap);
		return map;
	}
	
	//常规费用查询
	@RequestMapping(value="/queryStatisticsConsume")
	public @ResponseBody Map<String, Object> queryStatisticsConsume(Integer commId, Integer buildId, Integer unitId,String beginTime, String endTime,Integer page,Integer rows) {
		System.out.println("commId:"+commId+" buildId:"+buildId+" unitId:"+unitId+" beginTime:"+beginTime+" endTime:"+endTime+" page:"+page+" rows:"+rows);
		List<Map<String , Object>> consumeInfo = consumeService.queryStatisticsConsume(commId,buildId,unitId,beginTime,endTime,page,rows);
		Map<String , Object> map = new LinkedHashMap<String, Object>();
		map.put("total", consumeService.queryStatisticsConsumeCount(commId,buildId,unitId,beginTime,endTime));
		map.put("rows", consumeInfo);
		return map;
	}
	
	//导出数据
	@RequestMapping(value="/exportExcelConsumeInfo")
	public void exportExcelInfo(HttpServletResponse response,int commId,int buildId,int unitId,String beginTime,String endTime) {
		System.out.println("commId:"+commId+"  buildId:"+buildId+"  unitId:"+unitId+"  beginTime:"+beginTime+" endTime:"+endTime);
		try {
			response.setContentType("application/x-excel");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String("费项统计列表.xls".getBytes(),"ISO-8859-1"));
			ServletOutputStream outputStream = response.getOutputStream();
			
			List<Map<String, Object>> consumeList = consumeService.selectAllConsumeInfo(commId,buildId,unitId,beginTime,endTime);
			consumeService.exportExcelInfo(consumeList,outputStream);
			
			if(outputStream != null) {
				outputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static List<Map<String , Object>> getDatesBetweenTwoDate(Date beginDate, Date endDate) {  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String , Object>> lDate = new ArrayList<Map<String,Object>>();	
		Map<String , Object> beginMap = new LinkedHashMap<String,Object>();
		beginMap.put("label", sdf.format(beginDate));
        lDate.add(beginMap);
        
        Calendar cal = Calendar.getInstance();  
        cal.setTime(beginDate);  
        boolean bContinue = true;  
        while (bContinue) {  
            cal.add(Calendar.MONTH, 1);    
            if (endDate.after(cal.getTime())) {  
            	Map<String , Object> dateMap = new LinkedHashMap<String,Object>();
            	dateMap.put("label", sdf.format(cal.getTime()));
                lDate.add(dateMap);  
            } else {  
                break;  
            }  
        } 
//        Map<String , Date> endMap = new LinkedHashMap<String,Date>();
//		beginMap.put("label", endDate);
//        lDate.add(endMap);// 把结束时间加入集合  
        return lDate;  
 }
}
