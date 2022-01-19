package app.preprocessamento.sivep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import csv.PlanilhaMGCSV;
import csv.PlanilhaMGCSVHandler;

public class ContarRegistrosSivepSemIdade {
	
	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        List<PlanilhaMGCSV> registros = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sivep/SIVEP-MG(ComEvolucaoCasoObitoRecuperado).csv");
		
		List<PlanilhaMGCSV> registrosRegistrosSivepSemIdade = new ArrayList<>();
		
		for (PlanilhaMGCSV registro : registros) {
			String idade = registro.getIdade();
			
			if(idade == null || idade.equals("")) {
				registrosRegistrosSivepSemIdade.add(registro);
			}
		}
		
		System.out.println("Total de registros SIVEP MG sem idade: " + registrosRegistrosSivepSemIdade.size());
		
		registrosRegistrosSivepSemIdade.add(0, new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
														         "urs", "sexo", "idade", "internacao", 
														         "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
														         "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
														         "planilha", "sintomas", "outrosSitomas", "surto", 
														         "vacinaCov", "dataColeta", "arquivo", "identificacao", 
														         "municipio2", "dataNascimento2", "campo1", "ar", 
														         "arx", "am1", "am2", "bm1", 
														         "bm2", "cm1", "cm2", "rm1", 
														         "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso"));
		
		PlanilhaMGCSVHandler.criarCSV("./arquivos/csv/sivep/SIVEP-MG(SemIdade).csv", registrosRegistrosSivepSemIdade);
	}

}
