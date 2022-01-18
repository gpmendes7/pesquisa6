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
		
		List<PlanilhaMGCSV> registros = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/Planilha cruzada - Porto (Modificado).csv");
		
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
		
		registrosSivep.add(0, new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
				                                "urs", "sexo", "idade", "internacao", 
					                            "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
					                            "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
					                            "planilha", "sintomas", "outrosSitomas", "surto", 
					                            "vacinaCov", "dataColeta", "arquivo", "identificacao", 
					                            "municipio2", "dataNascimento2", "campo1", "ar", 
					                            "arx", "am1", "am2", "bm1", 
					                            "bm2", "cm1", "cm2", "rm1", 
					                            "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso"));
		
		registrosSus.add(0, new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
							                  "urs", "sexo", "idade", "internacao", 
							                  "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
							                  "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
							                  "planilha", "sintomas", "outrosSitomas", "surto", 
							                  "vacinaCov", "dataColeta", "arquivo", "identificacao", 
							                  "municipio2", "dataNascimento2", "campo1", "ar", 
							                  "arx", "am1", "am2", "bm1", 
							                  "bm2", "cm1", "cm2", "rm1", 
							                  "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso"));
		
		PlanilhaMGCSVHandler.criarCSV("./arquivos/csv/SIVEP-MG.csv", registrosSivep);
		PlanilhaMGCSVHandler.criarCSV("./arquivos/csv/ESUS-MG.csv", registrosSus);
	}

}
