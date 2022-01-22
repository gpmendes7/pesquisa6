package app.pareamento;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import csv.PlanilhaMGCSV;
import csv.PlanilhaMGCSVHandler;

public class GerarCSVPareamento {
	
	private static List<PlanilhaMGCSV> registrosPareamento;
	
	public static void main(String[] args) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException, ParseException {
		registrosPareamento = new ArrayList<>();
		
		carregarDadosObito();
		carregarDadosRecuperado();
		
		registrosPareamento.add(0, new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
									                 "urs", "sexo", "idade", "internacao", 
									                 "internacaoUti", "dataInternacao", "evolucao", "intervalo", "resultadoTeste", 
									                 "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
									                 "planilha", "sintomas", "outrosSitomas", "surto", 
									                 "vacinaCov", "dataColeta", "arquivo", "identificacao", 
									                 "municipio2", "dataNascimento2", "campo1", "ar", 
									                 "arx", "am1", "am2", "bm1", 
									                 "bm2", "cm1", "cm2", "rm1", 
									                 "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome"));

       PlanilhaMGCSVHandler.criarCSV("./arquivos/csv/PareamentoTotalSivepSus MG.csv", registrosPareamento);
	}
	
	private static void carregarDadosObito() throws IOException {
		List<PlanilhaMGCSV> registrosSivepFaixa1 = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sivep/obito/SIVEP-MG(OBITO-PacientesUsadosEntre25E45Anos).csv");
		registrosSivepFaixa1.stream().forEach(r -> r.setIntervalo("25-45"));
		
		List<PlanilhaMGCSV> registrosSivepFaixa2 = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sivep/obito/SIVEP-MG(OBITO-PacientesUsadosEntre46E57Anos).csv");
		registrosSivepFaixa2.stream().forEach(r -> r.setIntervalo("46-57"));
		
		List<PlanilhaMGCSV> registrosSivepFaixa3 = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sivep/obito/SIVEP-MG(OBITO-PacientesUsadosEntre58E78Anos).csv");
		registrosSivepFaixa3.stream().forEach(r -> r.setIntervalo("58-78"));
		
		registrosPareamento.addAll(registrosSivepFaixa1);
		registrosPareamento.addAll(registrosSivepFaixa2);
		registrosPareamento.addAll(registrosSivepFaixa3);
		
		List<PlanilhaMGCSV> registrosSusFaixa1 = new ArrayList<>();
		registrosSusFaixa1.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre25E45AnosResultadoDetectado).csv"));
		registrosSusFaixa1.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre25E45AnosResultadoNaoDetectado).csv"));	
		registrosSusFaixa1.stream().forEach(r -> r.setIntervalo("25-45"));
		
		List<PlanilhaMGCSV> registrosSusFaixa2 = new ArrayList<>();
		registrosSusFaixa2.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre46E57AnosResultadoDetectado).csv"));
		registrosSusFaixa2.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre46E57AnosResultadoNaoDetectado).csv"));	
		registrosSusFaixa2.stream().forEach(r -> r.setIntervalo("46-57"));
		
		List<PlanilhaMGCSV> registrosSusFaixa3 = new ArrayList<>();
		registrosSusFaixa3.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre58E78AnosResultadoDetectado).csv"));
		registrosSusFaixa3.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre58E78AnosResultadoNaoDetectado).csv"));	
		registrosSusFaixa3.stream().forEach(r -> r.setIntervalo("58-78"));
		

		registrosPareamento.addAll(registrosSusFaixa1);
		registrosPareamento.addAll(registrosSusFaixa2);
		registrosPareamento.addAll(registrosSusFaixa3);
	}
	
	private static void carregarDadosRecuperado() throws IOException {
		List<PlanilhaMGCSV> registrosSivepFaixa1 = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sivep/recuperado/SIVEP-MG(RECUPERADO-PacientesUsadosEntre20E40Anos).csv");
		registrosSivepFaixa1.stream().forEach(r -> r.setIntervalo("20-40"));
		
		List<PlanilhaMGCSV> registrosSivepFaixa2 = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sivep/recuperado/SIVEP-MG(RECUPERADO-PacientesUsadosEntre41E51Anos).csv");
		registrosSivepFaixa2.stream().forEach(r -> r.setIntervalo("41-51"));
		
		List<PlanilhaMGCSV> registrosSivepFaixa3 = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sivep/recuperado/SIVEP-MG(RECUPERADO-PacientesUsadosEntre52E74Anos).csv");
		registrosSivepFaixa3.stream().forEach(r -> r.setIntervalo("52-74"));
		
		registrosPareamento.addAll(registrosSivepFaixa1);
		registrosPareamento.addAll(registrosSivepFaixa2);
		registrosPareamento.addAll(registrosSivepFaixa3);
		
		List<PlanilhaMGCSV> registrosSusFaixa1 = new ArrayList<>();
		registrosSusFaixa1.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre20E40AnosResultadoDetectado).csv"));
		registrosSusFaixa1.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre20E40AnosResultadoNaoDetectado).csv"));	
		registrosSusFaixa1.stream().forEach(r -> r.setIntervalo("20-40"));
		
		List<PlanilhaMGCSV> registrosSusFaixa2 = new ArrayList<>();
		registrosSusFaixa2.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre41E51AnosResultadoDetectado).csv"));
		registrosSusFaixa2.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre41E51AnosResultadoNaoDetectado).csv"));	
		registrosSusFaixa2.stream().forEach(r -> r.setIntervalo("41-51"));
		
		List<PlanilhaMGCSV> registrosSusFaixa3 = new ArrayList<>();
		registrosSusFaixa3.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre52E74AnosResultadoDetectado).csv"));
		registrosSusFaixa3.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre52E74AnosResultadoNaoDetectado).csv"));	
		registrosSusFaixa3.stream().forEach(r -> r.setIntervalo("52-74"));
		
		registrosPareamento.addAll(registrosSusFaixa1);
		registrosPareamento.addAll(registrosSusFaixa2);
		registrosPareamento.addAll(registrosSusFaixa3);
	}

}
