package app.preprocessamento.sus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import csv.PlanilhaMGCSV;
import csv.PlanilhaMGCSVHandler;

public class SepararRegistrosSusComDataTesteEIdade {
	
	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		List<PlanilhaMGCSV> registros = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/SUS-MG(ComResultadoTeste).csv");
		
		List<PlanilhaMGCSV> registrosSusComDataTesteEIdade = new ArrayList<>();
		
		for (PlanilhaMGCSV registro : registros) {
			String dataTeste = registro.getDataTeste();
			String idade = registro.getIdade();
			
			if((dataTeste != null && !dataTeste.equals(""))
			   && (idade != null && !idade.equals(""))) {
				registrosSusComDataTesteEIdade.add(registro);
			}
		}
		
		System.out.println("Total de registros SUS MG com data de teste e idade: " + registrosSusComDataTesteEIdade.size());
		
		registrosSusComDataTesteEIdade.add(0, new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", 
									                  "urs", "sexo", "idade", "internacao", 
									                  "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
									                  "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
									                  "planilha", "sintomas", "outrosSitomas", "surto", 
									                  "vacinaCov", "dataColeta", "arquivo", "identificacao", 
									                  "municipio2", "dataNascimento2", "campo1", "ar", 
									                  "arx", "am1", "am2", "bm1", 
									                  "bm2", "cm1", "cm2", "rm1", 
									                  "rm2", "qbm1", "qbm2", "qam1", "qam2"));
		
		PlanilhaMGCSVHandler.criarCSV("./arquivos/csv/SUS-MG(ComDataTesteEIdade).csv", registrosSusComDataTesteEIdade);
	}

}
