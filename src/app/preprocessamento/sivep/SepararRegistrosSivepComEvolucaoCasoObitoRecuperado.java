package app.preprocessamento.sivep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import app.util.StringUtil;
import csv.PlanilhaMGCSV;
import csv.PlanilhaMGCSVHandler;

public class SepararRegistrosSivepComEvolucaoCasoObitoRecuperado {
	
	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		
		List<PlanilhaMGCSV> registros = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sivep/SIVEP-MG.csv");
		
		List<PlanilhaMGCSV> registrosComEvolucaoCasoObitoRecuperado = new ArrayList<>();
		List<PlanilhaMGCSV> registrosSemEvolucaoCasoObitoRecuperado = new ArrayList<>();
		
		for (PlanilhaMGCSV registro : registros) {
			String evolucao = StringUtil.normalizarString(registro.getEvolucao());
			
			if(evolucao.equals("OBITO") || evolucao.equals("RECUPERADO")) {
				registrosComEvolucaoCasoObitoRecuperado.add(registro);
			} else {
				registrosSemEvolucaoCasoObitoRecuperado.add(registro);
			}
		}
		
		System.out.println("Total de registros SIVEP MG: " + registros.size());
		System.out.println("Total de registros SIVEP MG com evolu��o caso Obito ou Recuperado: " + registrosComEvolucaoCasoObitoRecuperado.size());
		System.out.println("Total de registros SIVEP MG sem evolu��o caso Obito ou Recuperado: " + registrosSemEvolucaoCasoObitoRecuperado.size());
		
		registrosComEvolucaoCasoObitoRecuperado.add(0, new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
														                 "urs", "sexo", "idade", "internacao", 
														                 "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
														                 "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
														                 "planilha", "sintomas", "outrosSitomas", "surto", 
														                 "vacinaCov", "dataColeta", "arquivo", "identificacao", 
														                 "municipio2", "dataNascimento2", "campo1", "ar", 
														                 "arx", "am1", "am2", "bm1", 
														                 "bm2", "cm1", "cm2", "rm1", 
														                 "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome"));

		registrosSemEvolucaoCasoObitoRecuperado.add(0, new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
																	      "urs", "sexo", "idade", "internacao", 
																	      "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
																	      "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
																	      "planilha", "sintomas", "outrosSitomas", "surto", 
																	      "vacinaCov", "dataColeta", "arquivo", "identificacao", 
																	      "municipio2", "dataNascimento2", "campo1", "ar", 
																	      "arx", "am1", "am2", "bm1", 
																	      "bm2", "cm1", "cm2", "rm1", 
																	      "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome"));
		
		PlanilhaMGCSVHandler.criarCSV("./arquivos/csv/sivep/SIVEP-MG(ComEvolucaoCasoObitoRecuperado).csv", registrosComEvolucaoCasoObitoRecuperado);
		PlanilhaMGCSVHandler.criarCSV("./arquivos/csv/sivep/SIVEP-MG(SemEvolucaoCasoObitoRecuperado).csv", registrosSemEvolucaoCasoObitoRecuperado);
	}

}
