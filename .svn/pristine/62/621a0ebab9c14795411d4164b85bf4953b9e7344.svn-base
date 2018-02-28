package com.cxs.framework.utils.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @Description: excel导入工具
 * @ClassName: ExcelReadUtils 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年5月25日 
 *
 */
public class ExcelImportUtil {
	
	public static Workbook getWorkbook(String excelFile) throws IOException {
		return getWorkbook(new FileInputStream(excelFile));
	}
	
	public static Workbook getWorkbook(InputStream is) throws IOException {

		Workbook wb = null;

		ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
		byte[] buffer = new byte[512];
		int count = -1;
		while ((count = is.read(buffer)) != -1)
			byteOS.write(buffer, 0, count);
		byteOS.close();
		byte[] allBytes = byteOS.toByteArray();

		try {
			wb = new XSSFWorkbook(new ByteArrayInputStream(allBytes));
		} catch (Exception ex) {
			wb = new HSSFWorkbook(new ByteArrayInputStream(allBytes));
		}

		return wb;
	}
	
	public static List<List<Object>> readAllRows(String excelFile) throws IOException {
		return readAllRows(new FileInputStream(excelFile));
	}
	
	public static List<List<Object>> readAllRows(String excelFile, Integer sheetIndex, Integer rowIndex) throws IOException {
		return readAllRows(new FileInputStream(excelFile),sheetIndex,rowIndex);
	}
	
	public static List<List<Object>> readAllRows(InputStream is) throws IOException {
		return readAllRows(is, null,null);
	}

	/**
	 * 读取所有数据
	 * @param is 导入文件流
	 * @param sheetIndex 开始读取的sheet
	 * @param startRowIndex	开始读取的行
	 * @return
	 * @throws IOException
	 */
	public static List<List<Object>> readAllRows(InputStream is, Integer sheetIndex, Integer startRowIndex) throws IOException {
		return readAllRows(is,sheetIndex,sheetIndex,startRowIndex);
	}

	/**
	 * 读取所有数据
	 * @param is 导入文件流
	 * @param startSheetIndex 开始读取的sheet
	 * @param endSheetIndex 结束读取的sheet
	 * @param startRowIndex	开始读取的行
	 * @return
	 * @throws IOException
	 */
	public static List<List<Object>> readAllRows(InputStream is, Integer startSheetIndex, Integer endSheetIndex, Integer startRowIndex) throws IOException {
		if(null==startSheetIndex){
			startSheetIndex=0;
		}
		Workbook wb = getWorkbook(is);
		if(null==endSheetIndex){
			endSheetIndex= wb.getNumberOfSheets();
		}
		List<List<Object>> rowList = new ArrayList<List<Object>>();
		for (int i = startSheetIndex; i < (endSheetIndex+1); i++) {
			//获取每个Sheet表
			Sheet sheet = wb.getSheetAt(i);
			rowList.addAll(readRows(sheet, startRowIndex));
		}
		return rowList;
	}

	public static List<List<Object>> readRows(String excelFile, int startRowIndex, int rowCount) throws IOException {
		return readRows(new FileInputStream(excelFile), startRowIndex, rowCount);
	}
	
	public static List<List<Object>> readRows(String excelFile) throws IOException {
		return readRows(new FileInputStream(excelFile));
	}

	public static List<List<Object>> readRows(InputStream is,
			int startRowIndex, int rowCount) throws IOException {
		Workbook wb = getWorkbook(is);
		Sheet sheet = wb.getSheetAt(0);

		return readRows(sheet, startRowIndex, rowCount);
	}
	
	public static List<List<Object>> readRows(InputStream is) throws IOException {
		Workbook wb = getWorkbook(is);
		Sheet sheet = wb.getSheetAt(0);
		return readRows(sheet);
	}

	public static List<List<Object>> readRows(Sheet sheet,
			Integer startRowIndex, Integer rowCount) {
		if(null==startRowIndex){
			startRowIndex=0;
		}
		if(null==rowCount){
			rowCount=0;
		}
		List<List<Object>> rowList = new ArrayList<List<Object>>();
		
		for (int i = startRowIndex; i <= (startRowIndex + rowCount); i++) {
			Row row = sheet.getRow(i);
			if (row == null) {
				break;
			}
			
			List<Object> cellList = new ArrayList<Object>();
			for (Cell cell : row) {
				cellList.add(readCell(cell));
			}

			rowList.add(cellList);
		}
		
		return rowList;
	}
	
	public static List<List<Object>> readRows(Sheet sheet) {
		int rowCount = sheet.getLastRowNum();
		return readRows(sheet, 0, rowCount);
	}
	
	public static List<List<Object>> readRows(Sheet sheet, Integer startRowIndex) {
		int rowCount = sheet.getLastRowNum();
		if(null==startRowIndex){
			startRowIndex=0;
		}
		return readRows(sheet, startRowIndex, rowCount);
	}

	/**
	 * 从Excel读Cell
	 * 
	 * @param cell
	 * @return
	 */
	private static Object readCell(Cell cell) {
		if (cell == null) {
			return null;
		}

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			String str = cell.getRichStringCellValue().getString();
			return str == null ? "" : str.trim();

		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue();
			} else {
				return cell.getNumericCellValue();
			}

		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case Cell.CELL_TYPE_FORMULA:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue();
			} else {
				return cell.getCellFormula();
			}

		case Cell.CELL_TYPE_BLANK:
			return "";

		default:
			System.err.println("Data error for cell of excel: " + cell.getCellType());
			return "";
		}

	}
}
