package hr.ekonerg.ekonerginterview.service;

import java.io.IOException;

import hr.ekonerg.ekonerginterview.excel.ExcelData;

public interface IExcelDataService {

	ExcelData getExcelDataAsList() throws IOException;

	void saveExcelData(ExcelData excelData);

}
