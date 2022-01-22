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
									                 "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
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
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sivep/obito/SIVEP-MG(OBITO-PacientesUsadosEntre25E45Anos).csv"));
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sivep/obito/SIVEP-MG(OBITO-PacientesUsadosEntre46E57Anos).csv"));
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sivep/obito/SIVEP-MG(OBITO-PacientesUsadosEntre58E78Anos).csv"));
		
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre25E45AnosResultadoDetectado).csv"));
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre25E45AnosResultadoNaoDetectado).csv"));
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre46E57AnosResultadoDetectado).csv"));
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre46E57AnosResultadoNaoDetectado).csv"));
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre58E78AnosResultadoDetectado).csv"));
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre58E78AnosResultadoNaoDetectado).csv"));
	}
	
	private static void carregarDadosRecuperado() throws IOException {
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sivep/recuperado/SIVEP-MG(RECUPERADO-PacientesUsadosEntre20E40Anos).csv"));
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sivep/recuperado/SIVEP-MG(RECUPERADO-PacientesUsadosEntre41E51Anos).csv"));
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sivep/recuperado/SIVEP-MG(RECUPERADO-PacientesUsadosEntre52E74Anos).csv"));
		
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre20E40AnosResultadoDetectado).csv"));
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre20E40AnosResultadoNaoDetectado).csv"));
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre41E51AnosResultadoDetectado).csv"));
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre41E51AnosResultadoNaoDetectado).csv"));
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre52E74AnosResultadoDetectado).csv"));
		registrosPareamento.addAll(PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre52E74AnosResultadoNaoDetectado).csv"));
	}

}
