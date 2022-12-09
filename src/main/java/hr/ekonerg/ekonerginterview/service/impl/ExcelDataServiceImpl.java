package hr.ekonerg.ekonerginterview.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import hr.ekonerg.ekonerginterview.entity.Naselje;
import hr.ekonerg.ekonerginterview.entity.Zupanija;
import hr.ekonerg.ekonerginterview.excel.ExcelData;
import hr.ekonerg.ekonerginterview.repository.NaseljeRepository;
import hr.ekonerg.ekonerginterview.repository.ZupanijaRepository;
import hr.ekonerg.ekonerginterview.service.IExcelDataService;

@Service
public class ExcelDataServiceImpl implements IExcelDataService {

	@Autowired
	ZupanijaRepository zupanijaRepository;

	@Autowired
	NaseljeRepository naseljeRepository;

	Workbook workbook;

	public ExcelData getExcelDataAsList() throws IOException {

		workbook = WorkbookFactory.create(new ClassPathResource("podaci.xlsx").getInputStream());

		Sheet sheetZupanije = workbook.getSheetAt(0);
		Sheet sheetNaselja = workbook.getSheetAt(1);

		// Extract data from each sheet
		List<Zupanija> zupanijaList = new ArrayList<>();
		for (int i = 1; i <= sheetZupanije.getLastRowNum(); i++) {
			zupanijaList.add(new Zupanija((long) i, sheetZupanije.getRow(i).getCell(0).toString(), null, null));
		}

		List<Naselje> naseljeList = new ArrayList<>();
		for (int i = 1; i <= sheetNaselja.getLastRowNum(); i++) {
			Row row = sheetNaselja.getRow(i);
			naseljeList.add(new Naselje((long) i, sheetNaselja.getRow(i).getCell(1).toString(),
					(int) sheetNaselja.getRow(i).getCell(2).getNumericCellValue(), null, zupanijaList.stream()
							.filter(z -> z.getNaziv().equals(row.getCell(0).toString())).findAny().orElse(null)));
		}

		workbook.close();

		return new ExcelData(naseljeList, zupanijaList);
	}

	@Override
	public void saveExcelData(ExcelData excelData) {
		zupanijaRepository.saveAll(excelData.getZupanijaList());
		naseljeRepository.saveAll(excelData.getNaseljeList());
	}

}
