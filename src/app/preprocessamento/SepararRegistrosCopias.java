package app.preprocessamento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import app.util.StringUtil;
import csv.PlanilhaMGCSV;
import csv.PlanilhaMGCSVHandler;

public class SepararRegistrosCopias {
	
	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		
		List<PlanilhaMGCSV> registros = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/Planilha MG.csv");
		
		Map<String, PlanilhaMGCSV> mapaCampo1Registro = new HashMap<>();
		int qtdCopias = 0;
		
		for (PlanilhaMGCSV registro : registros) {
			String campo1 = StringUtil.normalizarString(registro.getCampo1());
			
			PlanilhaMGCSV registroCopia = mapaCampo1Registro.get(campo1);
			
			if(registroCopia != null) {
				qtdCopias++;
				String planilha = StringUtil.normalizarString(registroCopia.getPlanilha());
				if(!planilha.equals("SIVEP")) {
					mapaCampo1Registro.put(campo1, registro);
				}
			} else {
				mapaCampo1Registro.put(campo1, registro);
			}			
		}
		
		Collection<PlanilhaMGCSV> values = mapaCampo1Registro.values();
		List<PlanilhaMGCSV> registrosSemCopias = new ArrayList<>(values);
		
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
