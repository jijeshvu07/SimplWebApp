package com.company.product.view;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import com.company.product.domain.Department;


public class DepartmentXLSView extends AbstractExcelView {

	

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, javax.servlet.http.HttpServletRequest arg2,
			HttpServletResponse arg3) throws Exception {
		
		 HSSFSheet excelSheet = workbook.createSheet("Departments");
			setExcelHeader(excelSheet);
			
			 List<Department> departments =  (List<Department>) model.get("departments");
			setExcelRows(excelSheet,departments);
		
	}
	public void setExcelHeader(HSSFSheet excelSheet) {
		HSSFRow excelHeader = excelSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("Id");
		excelHeader.createCell(1).setCellValue("Name");
		excelHeader.createCell(2).setCellValue("Created Date");
	}
	
	public void setExcelRows(HSSFSheet excelSheet, List<Department> deps){
		int record = 1;
		for (Department department : deps) {
			HSSFRow excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(department.getId());
			excelRow.createCell(1).setCellValue(department.getName());
			excelRow.createCell(2).setCellValue(department.getCreatedDate());
			
		}
	}
}
