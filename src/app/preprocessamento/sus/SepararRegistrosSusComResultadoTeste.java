package app.preprocessamento.sus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import app.util.StringUtil;
import csv.PlanilhaMGCSV;
import csv.PlanilhaMGCSVHandler;

public class SepararRegistrosSusComResultadoTeste {
	
public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		
		List<PlanilhaMGCSV> registros = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/ESUS-MG.csv");
		
		List<PlanilhaMGCSV> registrosComResultadoTeste = new ArrayList<>();
		List<PlanilhaMGCSV> registrosSemResultadoTeste = new ArrayList<>();
		
		for (PlanilhaMGCSV registro : registros) {
			String resultadoTeste = StringUtil.normalizarString(registro.getResultadoTeste());
			
			if(resultadoTeste.equals("DETECTADO") || resultadoTeste.equals("NAO DETECTADO")) {
				registrosComResultadoTeste.add(registro);
			} else {
				registrosSemResultadoTeste.add(registro);
			}
		}
		
		System.out.println("Total de registros SUS MG: " + registros.size());
		System.out.println("Total de registros SUS MG com resultado teste: " + registrosComResultadoTeste.size());
		System.out.println("Total de registros SUS MG sem resultado teste: " + registrosSemResultadoTeste.size());
		
		registrosComResultadoTeste.add(0, new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
											                "urs", "sexo", "idade", "internacao", 
											                "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
											                "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
											                "planilha", "sintomas", "outrosSitomas", "surto", 
											                "vacinaCov", "dataColeta", "arquivo", "identificacao", 
											                "municipio2", "dataNascimento2", "campo1", "ar", 
											                "arx", "am1", "am2", "bm1", 
											                "bm2", "cm1", "cm2", "rm1", 
											                "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso"));

		registrosSemResultadoTeste.add(0, new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
													        "urs", "sexo", "idade", "internacao", 
													        "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
													        "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
													        "planilha", "sintomas", "outrosSitomas", "surto", 
													        "vacinaCov", "dataColeta", "arquivo", "identificacao", 
													        "municipio2", "dataNascimento2", "campo1", "ar", 
													        "arx", "am1", "am2", "bm1", 
													        "bm2", "cm1", "cm2", "rm1", 
													        "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso"));
		
		PlanilhaMGCSVHandler.criarCSV("./arquivos/csv/SUS-MG(ComResultadoTeste).csv", registrosComResultadoTeste);
		PlanilhaMGCSVHandler.criarCSV("./arquivos/csv/SUS-MG(SemResultadoTeste).csv", registrosSemResultadoTeste);
	}

}
