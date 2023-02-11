package app.preprocessamento.sivep;

import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import csv.PlanilhaMGCSV;
import csv.PlanilhaMGCSVHandler;

public class CalcularPercentuaSivepSexo {
	
	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		List<PlanilhaMGCSV> registros = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sivep/SIVEP-MG.csv");
		
	    System.out.println("registros.size(): " + registros.size());
	    
	    int qtdHomens = 0;
	    int qtdMulheres = 0;
	    
	    for (PlanilhaMGCSV registro : registros) {
			if(registro.getSexo().equals("MASCULINO")) 
				qtdHomens++;
			else if(registro.getSexo().equals("FEMININO")) 
				qtdMulheres++;
		}
	    
	    float percentualHomens = ((float) qtdHomens / (float) registros.size()) * 100;
	    System.out.println("Percentual de homens: " + percentualHomens + "%");
	    
	    float percentualMulheres = ((float) qtdMulheres / (float) registros.size()) * 100;
	    System.out.println("Percentual de mulheres: " + percentualMulheres + "%");
	}

}
