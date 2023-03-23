package app.preprocessamento;

import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import app.util.StringUtil;
import csv.PlanilhaMGCSV;
import csv.PlanilhaMGCSVHandler;

public class ContagemSivepESus {

	public static void main(String[] args)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		List<PlanilhaMGCSV> registros = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/Planilha MG.csv");

		System.out.println("registros.size(): " + registros.size());

		int qtdSivep = 0;
		int qtdEsus = 0;

		for (PlanilhaMGCSV registro : registros) {
			String planilha = StringUtil.normalizarString(registro.getPlanilha());
			if (planilha.equals("SIVEP")) {
				qtdSivep++;
			} else {
				qtdEsus++;
			}
		}
		
		System.out.println("qtdSivep: " + qtdSivep);
		System.out.println("qtdEsus: " + qtdEsus);
	}

}
