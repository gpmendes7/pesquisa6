package app.preprocessamento.sus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import csv.PlanilhaMGCSV;
import csv.PlanilhaMGCSVHandler;

public class ContarRegistrosSusSemDataInternacao {
	
	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		List<PlanilhaMGCSV> registros = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/SUS-MG(ComResultadoTeste).csv");
		
		List<PlanilhaMGCSV> registrosSusSemDataInternacao = new ArrayList<>();
		
		for (PlanilhaMGCSV registro : registros) {
			String dataInternacao = registro.getDataInternacao();
			
			if(dataInternacao == null || dataInternacao.equals("")) {
				registrosSusSemDataInternacao.add(registro);
			}
		}
		
		System.out.println("Total de registros SUS MG sem data internação: " + registrosSusSemDataInternacao.size());
		
		registrosSusSemDataInternacao.add(0, new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
											                   "urs", "sexo", "idade", "internacao", 
											                   "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
											                   "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
											                   "planilha", "sintomas", "outrosSitomas", "surto", 
											                   "vacinaCov", "dataColeta", "arquivo", "identificacao", 
											                   "municipio2", "dataNascimento2", "campo1", "ar", 
											                   "arx", "am1", "am2", "bm1", 
											                   "bm2", "cm1", "cm2", "rm1", 
											                   "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome"));
		
		PlanilhaMGCSVHandler.criarCSV("./arquivos/csv/sus/SUS-MG(SemDataInternacao).csv", registrosSusSemDataInternacao);
	}

}
