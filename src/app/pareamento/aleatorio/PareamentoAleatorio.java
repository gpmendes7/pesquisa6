package app.pareamento.aleatorio;

import static app.pareamento.FiltrosPareamento.filtrarRegistrosPorFaixaEtaria;
import static app.pareamento.FiltrosPareamento.filtrarRegistrosSusNaoUsados;
import static app.pareamento.FiltrosPareamento.filtrarRegistrosSusPorResultado;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import csv.PlanilhaMGCSV;
import csv.PlanilhaMGCSVHandler;

public class PareamentoAleatorio {
	
	private final static int NUMERO_DETECTADO_E_NAO_DETECTADO = 4; 

	private List<PlanilhaMGCSV> registrosSivep;
	private List<PlanilhaMGCSV> registrosSus;
	private List<PlanilhaMGCSV> registrosSusAtualizado;
	private File file;
	private FileWriter fileWriter;
	private String situacao;
	
	public PareamentoAleatorio(String situacao) {
		this.situacao = situacao;
	}

	public void carregarArquivosCSV(String csvSivep, String csvSus) throws IOException {
		registrosSivep = PlanilhaMGCSVHandler.carregarCSV(csvSivep);
		registrosSus = PlanilhaMGCSVHandler.carregarCSV(csvSus);
		registrosSusAtualizado = new ArrayList<>(registrosSus);
	}
	
	public void criarArquivosCSVSusAtualizado(String csvSusAtualizado) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		registrosSusAtualizado.add(0, new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
										                "urs", "sexo", "idade", "internacao", 
										                "internacaoUti", "dataInternacao", "evolucao", "intervalo", "resultadoTeste", 
										                "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
										                "planilha", "sintomas", "outrosSitomas", "surto", 
										                "vacinaCov", "dataColeta", "arquivo", "identificacao", 
										                "municipio2", "dataNascimento2", "campo1", "ar", 
										                "arx", "am1", "am2", "bm1", 
										                "bm2", "cm1", "cm2", "rm1", 
										                "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome", "semanaNotificacao"));

		PlanilhaMGCSVHandler.criarCSV(csvSusAtualizado, registrosSusAtualizado); 
	}

	public void parearPacientesEntreSivepESus(int idadeMinima, int idadeMaxima, String arquivoTxt,
			String csvResultadoDetectado, String csvResultadoNaoDetectado, String csvSivepUsados, String csvSivepNaoUsados)
			throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException, ParseException {
		List<PlanilhaMGCSV> registrosSivepFiltrados = filtrarRegistrosPorFaixaEtaria(registrosSivep, idadeMinima, idadeMaxima);
		
		List<PlanilhaMGCSV> registrosSusTotaisFiltradosComResultadoDetectado = new ArrayList<>();
		List<PlanilhaMGCSV> registrosSusTotaisFiltradosComResultadoNaoDetectado = new ArrayList<>();

		file = new File(arquivoTxt);
		fileWriter = new FileWriter(file);

		fileWriter.write("***************************\n");
		fileWriter.write("N�mero de registros do sivep com evolu��o caso " + situacao + " na faixa etaria de " + idadeMinima
				+ " a " + idadeMaxima + " anos usados para filtrar registros no sus: " + registrosSivepFiltrados.size()
				+ "\n");
		fileWriter.write("***************************\n");

		List<PlanilhaMGCSV> registrosSivepNaoUsados = new ArrayList<>();

		for (PlanilhaMGCSV registroSivepFiltrado : registrosSivepFiltrados) {
			fileWriter.write("***************************\n");
			int registro = (registrosSivepFiltrados.indexOf(registroSivepFiltrado) + 1);
			fileWriter.write("registro " + registro + "\n");

			fileWriter.write("registro do sivep com identificacao " + registroSivepFiltrado.getIdentificacao() + "\n");
			fileWriter.write("registro do sivep com codigo " + registroSivepFiltrado.getCodigo() + "\n");
			fileWriter.write("registro do sivep com campo1 " + registroSivepFiltrado.getCampo1() + "\n");
			fileWriter.write("registro do sivep com dataNascimento " + registroSivepFiltrado.getDataNascimento() + "\n");

			int filtragem = 1;
			
			List<PlanilhaMGCSV> registrosSusFiltradosRegistroSivepComResultadoDetectado = new ArrayList<>();
			List<PlanilhaMGCSV> registrosSusFiltradosRegistroSivepComResultadoNaoDetectado = new ArrayList<>();
            
			List<PlanilhaMGCSV> registrosSusFiltradosRegistroSivep = filtrarRegistrosSusNaoUsados(registrosSusAtualizado);
			
			registrosSusFiltradosRegistroSivepComResultadoDetectado.addAll(
					obterRegistrosSusUsadosComResultadoDetectado(registrosSusFiltradosRegistroSivep, NUMERO_DETECTADO_E_NAO_DETECTADO));
			
			registrosSusFiltradosRegistroSivepComResultadoNaoDetectado.addAll(
					obterRegistrosSusUsadosComResultadoNaoDetectado(registrosSusFiltradosRegistroSivep, NUMERO_DETECTADO_E_NAO_DETECTADO));

			fileWriter.write("---------------------------\n");
			fileWriter.write("Resultados finais ap�s filtragem " + (filtragem - 1) + "\n");

			if (registrosSusFiltradosRegistroSivepComResultadoDetectado.size() < NUMERO_DETECTADO_E_NAO_DETECTADO
					|| registrosSusFiltradosRegistroSivepComResultadoNaoDetectado.size() < NUMERO_DETECTADO_E_NAO_DETECTADO) {
				fileWriter.write("N�mero de registros do sus com resultado Detectado e N�o Detectado insuficientes! Registro "
						+ registro + " n�o ser� usado!\n");
				fileWriter.write(
						"Registros do sus filtrados usados v�o ser desmarcados para uso posterior para filtro de outro registro sivep!\n");

				registrosSusFiltradosRegistroSivepComResultadoDetectado.stream().forEach(r -> r.setObservacaoUso(""));
				registrosSusFiltradosRegistroSivepComResultadoDetectado.stream()
						.forEach(r -> r.setFiltroAreaMunicipio(""));

				registrosSusFiltradosRegistroSivepComResultadoNaoDetectado.stream().forEach(r -> r.setObservacaoUso(""));
				registrosSusFiltradosRegistroSivepComResultadoNaoDetectado.stream()
						.forEach(r -> r.setFiltroAreaMunicipio(""));

				registrosSivepNaoUsados.add(registroSivepFiltrado);
			} else {
				fileWriter.write("N�mero final de registros do sus usados com resultado Detectado: "
						+ registrosSusFiltradosRegistroSivepComResultadoDetectado.size() + "\n");
				fileWriter.write("N�mero final de registros do sus usados com resultado N�o Detectado: "
						+ registrosSusFiltradosRegistroSivepComResultadoNaoDetectado.size() + "\n");

				registrosSusTotaisFiltradosComResultadoDetectado
						.addAll(registrosSusFiltradosRegistroSivepComResultadoDetectado);
				registrosSusTotaisFiltradosComResultadoNaoDetectado
						.addAll(registrosSusFiltradosRegistroSivepComResultadoNaoDetectado);
			}

			fileWriter.write("***************************\n");
		}

		fileWriter.flush();
		fileWriter.close();

		registrosSusTotaisFiltradosComResultadoDetectado.add(0,
				new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
				                  "urs", "sexo", "idade", "internacao", 
				                  "internacaoUti", "dataInternacao", "evolucao", "intervalo", "resultadoTeste", 
				                  "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
				                  "planilha", "sintomas", "outrosSitomas", "surto", 
				                  "vacinaCov", "dataColeta", "arquivo", "identificacao", 
				                  "municipio2", "dataNascimento2", "campo1", "ar", 
				                  "arx", "am1", "am2", "bm1", 
				                  "bm2", "cm1", "cm2", "rm1", 
				                  "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome", "semanaNotificacao"));
		
		PlanilhaMGCSVHandler.criarCSV(csvResultadoDetectado, registrosSusTotaisFiltradosComResultadoDetectado);

		registrosSusTotaisFiltradosComResultadoNaoDetectado.add(0,
				new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
					              "urs", "sexo", "idade", "internacao", 
					              "internacaoUti", "dataInternacao", "evolucao", "intervalo", "resultadoTeste", 
					              "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
					              "planilha", "sintomas", "outrosSitomas", "surto", 
					              "vacinaCov", "dataColeta", "arquivo", "identificacao", 
					              "municipio2", "dataNascimento2", "campo1", "ar", 
					              "arx", "am1", "am2", "bm1", 
					              "bm2", "cm1", "cm2", "rm1", 
					              "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome", "semanaNotificacao"));
		
		PlanilhaMGCSVHandler.criarCSV(csvResultadoNaoDetectado, registrosSusTotaisFiltradosComResultadoNaoDetectado);

		registrosSivepFiltrados.removeAll(registrosSivepNaoUsados);

		registrosSivepFiltrados.add(0,
				new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
					              "urs", "sexo", "idade", "internacao", 
					              "internacaoUti", "dataInternacao", "evolucao", "intervalo", "resultadoTeste", 
					              "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
					              "planilha", "sintomas", "outrosSitomas", "surto", 
					              "vacinaCov", "dataColeta", "arquivo", "identificacao", 
					              "municipio2", "dataNascimento2", "campo1", "ar", 
					              "arx", "am1", "am2", "bm1", 
					              "bm2", "cm1", "cm2", "rm1", 
					              "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome", "semanaNotificacao"));

		PlanilhaMGCSVHandler.criarCSV(csvSivepUsados, registrosSivepFiltrados);

		registrosSivepNaoUsados.add(0,
				new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
			                      "urs", "sexo", "idade", "internacao", 
			                      "internacaoUti", "dataInternacao", "evolucao", "intervalo", "resultadoTeste", 
			                      "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
			                      "planilha", "sintomas", "outrosSitomas", "surto", 
			                      "vacinaCov", "dataColeta", "arquivo", "identificacao", 
			                      "municipio2", "dataNascimento2", "campo1", "ar", 
			                      "arx", "am1", "am2", "bm1", 
			                      "bm2", "cm1", "cm2", "rm1", 
			                      "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome", "semanaNotificacao"));

		PlanilhaMGCSVHandler.criarCSV(csvSivepNaoUsados, registrosSivepNaoUsados);
	}

	private List<PlanilhaMGCSV> obterRegistrosSusUsadosComResultadoNaoDetectado(List<PlanilhaMGCSV> registrosSusFiltradosRegistroSivep, int qtd)
			throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		List<PlanilhaMGCSV> registrosSusFiltradosComResultadoNaoDetectado = filtrarRegistrosSusPorResultado(
				registrosSusFiltradosRegistroSivep, "Nao Detectado");
		fileWriter.write("Filtrou " + registrosSusFiltradosComResultadoNaoDetectado.size()
				+ " registros do sus com resultado N�o Detectado\n");
		
		selecionarRegistrosSusAleatoriamente(registrosSusFiltradosComResultadoNaoDetectado, qtd);
		
		List<PlanilhaMGCSV> registrosSusFiltradosComResultadoNaoDetectadoUsados = registrosSusFiltradosComResultadoNaoDetectado
				.stream().filter(r -> r.getObservacaoUso() != null && !r.getObservacaoUso().equals(""))
				.collect(Collectors.toList());

		if (registrosSusFiltradosComResultadoNaoDetectadoUsados.size() > 0) {
			fileWriter.write("Foram usados " + registrosSusFiltradosComResultadoNaoDetectadoUsados.size()
					+ " registros do sus com resultado N�o Detectado\n");
		}

		return registrosSusFiltradosComResultadoNaoDetectadoUsados;
	}

	private List<PlanilhaMGCSV> obterRegistrosSusUsadosComResultadoDetectado(List<PlanilhaMGCSV> registrosSusFiltradosRegistroSivep, int qtd) 
			throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		List<PlanilhaMGCSV> registrosSusFiltradosComResultadoDetectado = filtrarRegistrosSusPorResultado(
				registrosSusFiltradosRegistroSivep, "Detectado");
		fileWriter.write("Filtrou " + registrosSusFiltradosComResultadoDetectado.size()
				+ " registros do sus com resultado Detectado\n");
		
		selecionarRegistrosSusAleatoriamente(registrosSusFiltradosComResultadoDetectado, qtd);

		List<PlanilhaMGCSV> registrosSusFiltradosComResultadoDetectadoUsados = registrosSusFiltradosComResultadoDetectado
				.stream().filter(r -> r.getObservacaoUso() != null && !r.getObservacaoUso().equals(""))
				.collect(Collectors.toList());

		if (registrosSusFiltradosComResultadoDetectadoUsados.size() > 0) {
			fileWriter.write("Foram usados " + registrosSusFiltradosComResultadoDetectadoUsados.size()
					+ " registros do sus com resultado Detectado\n");
		}

		return registrosSusFiltradosComResultadoDetectadoUsados;
	}
	
	private List<PlanilhaMGCSV> selecionarRegistrosSusAleatoriamente(List<PlanilhaMGCSV> registrosSus, int qtd) {
		List<PlanilhaMGCSV> registrosSusSorteados = new ArrayList<PlanilhaMGCSV>();
		Random rand = new Random();
			
		for (int i = 0; i < qtd; i++) {
			int indiceAleatorio = rand.nextInt(registrosSus.size());
			PlanilhaMGCSV registroSusSorteado = registrosSus.get(indiceAleatorio);
			registroSusSorteado.setObservacaoUso("Registro usado por " + situacao);
			registrosSusSorteados.add(registroSusSorteado);
			registrosSus.remove(indiceAleatorio);
		}
		
		registrosSus.addAll(registrosSusSorteados);
		
		return registrosSusSorteados;
    }

}
