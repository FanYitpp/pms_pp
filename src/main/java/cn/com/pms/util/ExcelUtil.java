package cn.com.pms.util;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExcelUtil {

	public static void exportHostExcel(List<Map<String, Object>> hostList, ServletOutputStream outputStream) {
		
		try {
			//1.创建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			//1.1创建合并单元格对象
			CellRangeAddress cra = 	new CellRangeAddress(0,0,0,7);
			//1.2头标题样式
			HSSFCellStyle titleStyle = createCellStyle(workbook,(short)16);
			
			//1.3列标题样式
			HSSFCellStyle rowStyle = createCellStyle(workbook, (short)14);
				
			//2.创建工作表
			HSSFSheet sheet = workbook.createSheet("业主房产信息列表");
			//2.1加载合并单元格对象
			sheet.addMergedRegion(cra);
			//2.2设置默认列宽
			sheet.setDefaultColumnWidth(20);
			
			//3.创建行
			//3.1创建头标题行；并设置头标题
			HSSFRow titleRow = sheet.createRow(0);
			HSSFCell titleCell = titleRow.createCell(0);
			//3.2给头标题行加载单元格样式
			titleCell.setCellStyle(titleStyle);
			titleCell.setCellValue("业主房产信息列表");
			//3.3创建列标题行，并设置列标题
			HSSFRow hrow = sheet.createRow(1);
			String [] cellNames = {"房间编号","所属单元","房间号","业主","性别","联系电话1","联系电话2","证件号码"};
			for (int i = 0; i < cellNames.length; i++) {
				HSSFCell cell = hrow.createCell(i);
				//3.4加载单元个样式
				cell.setCellStyle(rowStyle);
				cell.setCellValue(cellNames[i]);
			}
			//4.操作单元格，将用户列表写入excel
			if(hostList != null) {
				for (int i = 0; i < hostList.size(); i++) {
					HSSFRow userRow = sheet.createRow(i+2);
					userRow.createCell(0).setCellValue(hostList.get(i).get("hnum").toString());
					userRow.createCell(1).setCellValue(hostList.get(i).get("uname").toString());
					userRow.createCell(2).setCellValue(hostList.get(i).get("hname").toString());
					userRow.createCell(3).setCellValue(hostList.get(i).get("host_name").toString());
					userRow.createCell(4).setCellValue(hostList.get(i).get("host_gender").toString());
					userRow.createCell(5).setCellValue(hostList.get(i).get("host_link").toString());
					userRow.createCell(6).setCellValue(hostList.get(i).get("host_link2").toString());
					userRow.createCell(7).setCellValue(hostList.get(i).get("host_card").toString());
				}
			}
				
			//5.输出
			workbook.write(outputStream);
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
public static void exportConsumeExcel(List<Map<String, Object>> consumeList, ServletOutputStream outputStream) {
		
		try {
			//1.创建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			//1.1创建合并单元格对象
			CellRangeAddress cra = 	new CellRangeAddress(0,0,0,20);
			//1.2头标题样式
			HSSFCellStyle titleStyle = createCellStyle(workbook,(short)16);
			
			//1.3列标题样式
			HSSFCellStyle rowStyle = createCellStyle(workbook, (short)14);
				
			//2.创建工作表
			HSSFSheet sheet = workbook.createSheet("费用查询列表");
			//2.1加载合并单元格对象
			sheet.addMergedRegion(cra);
			//2.2设置默认列宽
			sheet.setDefaultColumnWidth(20);
			
			//3.创建行
			//3.1创建头标题行；并设置头标题
			HSSFRow titleRow = sheet.createRow(0);
			HSSFCell titleCell = titleRow.createCell(0);
			//3.2给头标题行加载单元格样式
			titleCell.setCellStyle(titleStyle);
			titleCell.setCellValue("费用查询列表");
			//3.3创建列标题行，并设置列标题
			HSSFRow hrow = sheet.createRow(1);
			String [] cellNames = {"房间编号","户主","联系方式","物业费1","物业费2","物业费3","卫生费1","卫生费2","卫生费3","取暖费1","取暖费2","取暖费3","水费1","水费2","水费3","电费1","点费2","点费3","污水处理费1","污水处理2","污水处理3"};
			for (int i = 0; i < cellNames.length; i++) {
				HSSFCell cell = hrow.createCell(i);
				//3.4加载单元个样式
				cell.setCellStyle(rowStyle);
				cell.setCellValue(cellNames[i]);
			}
			//4.操作单元格，将用户列表写入excel
			if(consumeList != null) {
				for (int i = 0; i < consumeList.size(); i++) {
					HSSFRow userRow = sheet.createRow(i+2);
					userRow.createCell(0).setCellValue(consumeList.get(i).get("hnum")+"");
					userRow.createCell(1).setCellValue(consumeList.get(i).get("host_name")+"");
					userRow.createCell(2).setCellValue(consumeList.get(i).get("host_link")+"");
					userRow.createCell(3).setCellValue(consumeList.get(i).get("peopertyAll")+"");
					userRow.createCell(4).setCellValue(consumeList.get(i).get("peopertyYes")+"");
					userRow.createCell(5).setCellValue(consumeList.get(i).get("peopertyNo")+"");
					userRow.createCell(6).setCellValue(consumeList.get(i).get("sanitationAll")+"");
					userRow.createCell(7).setCellValue(consumeList.get(i).get("sanitationYes")+"");
					userRow.createCell(8).setCellValue(consumeList.get(i).get("sanitationNo")+"");
					userRow.createCell(9).setCellValue(consumeList.get(i).get("heatingAll")+"");
					userRow.createCell(10).setCellValue(consumeList.get(i).get("heatingYes")+"");
					userRow.createCell(11).setCellValue(consumeList.get(i).get("heatingNo")+"");
					userRow.createCell(12).setCellValue(consumeList.get(i).get("waterAll")+"");
					userRow.createCell(13).setCellValue(consumeList.get(i).get("waterYes")+"");
					userRow.createCell(14).setCellValue(consumeList.get(i).get("waterNo")+"");
					userRow.createCell(15).setCellValue(consumeList.get(i).get("electricAll")+"");
					userRow.createCell(16).setCellValue(consumeList.get(i).get("electricYes")+"");
					userRow.createCell(17).setCellValue(consumeList.get(i).get("electricNo")+"");
					userRow.createCell(18).setCellValue(consumeList.get(i).get("sewageAll")+"");
					userRow.createCell(19).setCellValue(consumeList.get(i).get("sewageYes")+"");
					userRow.createCell(20).setCellValue(consumeList.get(i).get("sewageNo")+"");
				}
			}
				
			//5.输出
			workbook.write(outputStream);
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//设置单元格样式
	private static HSSFCellStyle createCellStyle(HSSFWorkbook workbook, short fontSize) {
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); //水平居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); //垂直居中
		//1.2.1创建字体
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //加粗字体
		font.setFontHeightInPoints(fontSize);
		//加载字体
		style.setFont(font);
		return style;
	}
	
}
