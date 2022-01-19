package app.pareamento;

import static app.util.DataUtil.alterarDiasEmData;
import static app.util.DataUtil.dataEstaEmIntervalo;
import static app.util.StringUtil.normalizarString;
import static modelo.RegioesAdministrativas.obterNomeRegiaoMunicipio;
import static modelo.RegioesAdministrativas.obterRegiaoMunicipio;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import app.util.StringUtil;
import csv.PlanilhaMGCSV;

public class FiltrosPareamento {
	
	public static List<PlanilhaMGCSV> filtrarRegistrosPorFaixaEtaria(List<PlanilhaMGCSV> registros, int idadeMinima, int idadeMaxima) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {	
		return registros.stream()
						 .filter(r -> Integer.parseInt(r.getIdade()) >= idadeMinima && Integer.parseInt(r.getIdade()) <= idadeMaxima)
						 .collect(Collectors.toList());
	}
	
	public static List<PlanilhaMGCSV> filtrarRegistrosSusNaoUsados(List<PlanilhaMGCSV> registrosSus) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		return registrosSus.stream()
							.filter(r -> r.getObservacaoUso() == null || r.getObservacaoUso().equals(""))
							.collect(Collectors.toList());
	}
	
	public static List<PlanilhaMGCSV> filtrarRegistrosSusPorSexo(List<PlanilhaMGCSV> registrosSus, PlanilhaMGCSV registroSivepFiltrado) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		return registrosSus.stream()
						   .filter(r -> StringUtil.normalizarString(r.getSexo()).equals(StringUtil.normalizarString(registroSivepFiltrado.getSexo())))
						   .collect(Collectors.toList());		
	}
	
	
	public static List<PlanilhaMGCSV> filtrarRegistrosSusPorDataTeste(List<PlanilhaMGCSV> registrosSus, PlanilhaMGCSV registroSivepFiltrado, int numeroSemanas) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataInternacaoSivep = sdf.parse(registroSivepFiltrado.getDataInternacao());
		Date data1 = alterarDiasEmData(dataInternacaoSivep, numeroSemanas * -7);
		Date data2 = alterarDiasEmData(dataInternacaoSivep, numeroSemanas * 7);
		
		List<PlanilhaMGCSV> registrosSusFiltradosPorDataTeste = new ArrayList<PlanilhaMGCSV>();
		
		for (PlanilhaMGCSV registro : registrosSus) {
			Date dataTesteSus = sdf.parse(registro.getDataTeste());
			if(dataEstaEmIntervalo(data1, data2, dataTesteSus)) {
				registrosSusFiltradosPorDataTeste.add(registro);
			}
		}
		
		return registrosSusFiltradosPorDataTeste;
	}
	
	public static List<PlanilhaMGCSV> filtrarRegistrosSusPorMunicipio(List<PlanilhaMGCSV> registrosSus, PlanilhaMGCSV registroSivepFiltrado) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {	
		List<PlanilhaMGCSV> registrosSusFiltradosPorMunicipio = registrosSus.stream()
						   .filter(r -> StringUtil.normalizarString(r.getMunicipio()).equals(StringUtil.normalizarString(registroSivepFiltrado.getMunicipio())))
						   .collect(Collectors.toList());
		
		registrosSusFiltradosPorMunicipio.stream().forEach(r -> r.setFiltroAreaMunicipio(r.getMunicipio()));
		
		return registrosSusFiltradosPorMunicipio;
	}
	
	public static List<PlanilhaMGCSV> filtrarRegistrosSusPorAreaMunicipio(List<PlanilhaMGCSV> registrosSus, PlanilhaMGCSV registroSivepFiltrado) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {	
		List<PlanilhaMGCSV> registrosSusFiltradosPorAreaMunicipio = new ArrayList<PlanilhaMGCSV>();
		
		String[] regiao = obterRegiaoMunicipio(registroSivepFiltrado.getMunicipio());
		
		if(regiao != null) {
			for (PlanilhaMGCSV registroSus : registrosSus) {
				String municipioRegistroNormalizado = normalizarString(registroSus.getMunicipio());
				
				for (String municipioRegiao : regiao) {
					String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
							
					if(municipioRegistroNormalizado.equals(municipioRegiaoNormalizado)) {
						registrosSusFiltradosPorAreaMunicipio.add(registroSus);
					}
				}
				
			}
			
			registrosSusFiltradosPorAreaMunicipio.stream().forEach(r -> r.setFiltroAreaMunicipio(obterNomeRegiaoMunicipio(r.getMunicipio())));
		}

		return registrosSusFiltradosPorAreaMunicipio;
	}
	

	public static List<PlanilhaMGCSV> filtrarRegistrosSusPorRacaCor(List<PlanilhaMGCSV> registrosSus, PlanilhaMGCSV registroSivepFiltrado) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		return registrosSus.stream()
						   .filter(r -> StringUtil.normalizarString(r.getRaca()).equals(StringUtil.normalizarString(registroSivepFiltrado.getRaca())))
						   .collect(Collectors.toList());
	}
		
	public static List<PlanilhaMGCSV> filtrarRegistrosSusPorResultado(List<PlanilhaMGCSV> registrosSus, String resultadoTeste) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {	
		return registrosSus.stream()
					       .filter(r -> StringUtil.normalizarString(r.getResultadoTeste()).equals(StringUtil.normalizarString(resultadoTeste)))
					       .collect(Collectors.toList());
	}

}
