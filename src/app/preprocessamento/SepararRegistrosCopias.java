package app.preprocessamento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import app.util.StringUtil;
import csv.PlanilhaMGCSV;
import csv.PlanilhaMGCSVHandler;

public class SepararRegistrosCopias {
	
	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		
		List<PlanilhaMGCSV> registros = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/Planilha MG.csv");
		
		Set<String> chaves = new HashSet<>();
		List<PlanilhaMGCSV> registrosSemCopias = new ArrayList<PlanilhaMGCSV>();
		int qtdCopias = 0;
		
		for (PlanilhaMGCSV registro : registros) {
			String campo1 = StringUtil.normalizarString(registro.getCampo1());
			String planilha = StringUtil.normalizarString(registro.getPlanilha());
			String chave = campo1 + planilha;
			
			if(!chaves.contains(chave)) {
				chaves.add(chave);
				registrosSemCopias.add(registro);
			} else {
				qtdCopias++;
			}
		}
		
		System.out.println("Total de registros: " + registros.size());
		System.out.println("Total de registros únicos gerados (considerando campo1): " + registrosSemCopias.size());
		System.out.println("Total de registros cópias descartados: " + qtdCopias);
		
		registrosSemCopias.add(0, new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
					                                "urs", "sexo", "idade", "internacao", 
						                            "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
						                            "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
						                            "planilha", "sintomas", "outrosSitomas", "surto", 
						                            "vacinaCov", "dataColeta", "arquivo", "identificacao", 
						                            "municipio2", "dataNascimento2", "campo1", "ar", 
						                            "arx", "am1", "am2", "bm1", 
						                            "bm2", "cm1", "cm2", "rm1", 
						                            "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome"));
		
		PlanilhaMGCSVHandler.criarCSV("./arquivos/csv/Planilha MG(SemRepeticao).csv", registrosSemCopias);
	}

}
