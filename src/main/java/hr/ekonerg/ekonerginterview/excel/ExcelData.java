package hr.ekonerg.ekonerginterview.excel;

import java.util.List;

import hr.ekonerg.ekonerginterview.entity.Naselje;
import hr.ekonerg.ekonerginterview.entity.Zupanija;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelData {

	private List<Naselje> naseljeList;

	private List<Zupanija> zupanijaList;

}
