package app.preprocessamento.sivep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import app.util.StringUtil;
import csv.PlanilhaMGCSV;
import csv.PlanilhaMGCSVHandler;

public class CriarCSVSivepRecuperado {
	
	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		List<PlanilhaMGCSV> registros = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/SIVEP-MG(ComDataInternacaoEIdade).csv");
			
		List<PlanilhaMGCSV> registrosSivepRecuperado = new ArrayList<>();
		
		for (PlanilhaMGCSV registro : registros) {
			String evolucao = StringUtil.normalizarString(registro.getEvolucao());
			
			if(evolucao.equals("RECUPERADO")) {
				registrosSivepRecuperado.add(registro);
			}
		}
		
		System.out.println("Total de registros SIVEP MG recuperado: " + registrosSivepRecuperado.size());
		
		registrosSivepRecuperado.add(0, new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", 
														         "urs", "sexo", "idade", "internacao", 
														         "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
														         "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
														         "planilha", "sintomas", "outrosSitomas", "surto", 
														         "vacinaCov", "dataColeta", "arquivo", "identificacao", 
														         "municipio2", "dataNascimento2", "campo1", "ar", 
														         "arx", "am1", "am2", "bm1", 
														         "bm2", "cm1", "cm2", "rm1", 
														         "rm2", "qbm1", "qbm2", "qam1", "qam2"));
		
		PlanilhaMGCSVHandler.criarCSV("./arquivos/csv/SIVEP-MG(RECUPERADO).csv", registrosSivepRecuperado);
	}


}
