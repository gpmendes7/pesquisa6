package app.preprocessamento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import app.util.StringUtil;
import csv.PlanilhaMGCSV;
import csv.PlanilhaMGCSVHandler;

public class GerarArquivosSivepSusMG {
	
	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		
		List<PlanilhaMGCSV> registros = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/Planilha MG(SemRepeticao).csv");
		
		List<PlanilhaMGCSV> registrosSivep = new ArrayList<PlanilhaMGCSV>();
		List<PlanilhaMGCSV> registrosSus = new ArrayList<PlanilhaMGCSV>();
		
		for (PlanilhaMGCSV registro : registros) {
			String planilha = StringUtil.normalizarString(registro.getPlanilha());
			
			if(planilha.equals("SIVEP")) {
				registrosSivep.add(registro);
			} else {
				registrosSus.add(registro);
			}
		}
		
		System.out.println("Total de registros SIVEP MG: " + registrosSivep.size());
		System.out.println("Total de registros ESUS MG: " + registrosSus.size());
		
		registrosSivep.add(0, new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
				                                "urs", "sexo", "idade", "internacao", 
					                            "internacaoUti", "dataInternacao", "evolucao", "intervalo", "resultadoTeste", 
					                            "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
					                            "planilha", "sintomas", "outrosSitomas", "surto", 
					                            "vacinaCov", "dataColeta", "arquivo", "identificacao", 
					                            "municipio2", "dataNascimento2", "campo1", "ar", 
					                            "arx", "am1", "am2", "bm1", 
					                            "bm2", "cm1", "cm2", "rm1", 
					                            "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome"));
		
		registrosSus.add(0, new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
							                  "urs", "sexo", "idade", "internacao", 
							                  "internacaoUti", "dataInternacao", "evolucao", "intervalo", "resultadoTeste", 
							                  "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
							                  "planilha", "sintomas", "outrosSitomas", "surto", 
							                  "vacinaCov", "dataColeta", "arquivo", "identificacao", 
							                  "municipio2", "dataNascimento2", "campo1", "ar", 
							                  "arx", "am1", "am2", "bm1", 
							                  "bm2", "cm1", "cm2", "rm1", 
							                  "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome"));
		
		PlanilhaMGCSVHandler.criarCSV("./arquivos/csv/sivep/SIVEP-MG.csv", registrosSivep);
		PlanilhaMGCSVHandler.criarCSV("./arquivos/csv/sus/ESUS-MG.csv", registrosSus);
	}

}
