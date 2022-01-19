package app.pareamento;

import static app.pareamento.FiltrosPareamento.filtrarRegistrosPorFaixaEtaria;
import static app.pareamento.FiltrosPareamento.filtrarRegistrosSusNaoUsados;
import static app.pareamento.FiltrosPareamento.filtrarRegistrosSusPorAreaMunicipio;
import static app.pareamento.FiltrosPareamento.filtrarRegistrosSusPorMunicipio;
import static app.pareamento.FiltrosPareamento.filtrarRegistrosSusPorRacaCor;
import static app.pareamento.FiltrosPareamento.filtrarRegistrosSusPorResultado;
import static app.pareamento.FiltrosPareamento.filtrarRegistrosSusPorSexo;
import static app.pareamento.FiltrosPareamento.filtrarRegistrosSusPorDataTeste;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import csv.PlanilhaMGCSV;
import csv.PlanilhaMGCSVHandler;

public class Pareamento {
	
	private final static int NUMERO_POSITIVO_NEGATIVOS = 2; 

	private List<PlanilhaMGCSV> registrosSivep;
	private List<PlanilhaMGCSV> registrosSus;
	private List<PlanilhaMGCSV> registrosSusAtualizado;
	private File file;
	private FileWriter fileWriter;
	private String situacao;
	
	public Pareamento(String situacao) {
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
										                "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
										                "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
										                "planilha", "sintomas", "outrosSitomas", "surto", 
										                "vacinaCov", "dataColeta", "arquivo", "identificacao", 
										                "municipio2", "dataNascimento2", "campo1", "ar", 
										                "arx", "am1", "am2", "bm1", 
										                "bm2", "cm1", "cm2", "rm1", 
										                "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso"));

		PlanilhaMGCSVHandler.criarCSV(csvSusAtualizado, registrosSusAtualizado); 
	}

	public void parearPacientesEntreSivepESus(int idadeMinima, int idadeMaxima, String arquivoTxt,
			String csvResultadoPositivo, String csvResultadoNegativo, String csvSivepUsados, String csvSivepNaoUsados)
			throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException, ParseException {
		List<PlanilhaMGCSV> registrosSivepFiltrados = filtrarRegistrosPorFaixaEtaria(registrosSivep, idadeMinima, idadeMaxima);
		
		List<PlanilhaMGCSV> registrosSusTotaisFiltradosComResultadoPositivo = new ArrayList<>();
		List<PlanilhaMGCSV> registrosSusTotaisFiltradosComResultadoNegativo = new ArrayList<>();

		file = new File(arquivoTxt);
		fileWriter = new FileWriter(file);

		fileWriter.write("***************************\n");
		fileWriter.write("Número de registros do sivep com evolução caso " + situacao + " na faixa etaria de " + idadeMinima
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
			int numeroSemanas = 1;
			List<PlanilhaMGCSV> registrosSusFiltradosRegistroSivepComResultadoPositivo = new ArrayList<>();
			List<PlanilhaMGCSV> registrosSusFiltradosRegistroSivepComResultadoNegativo = new ArrayList<>();

			while (filtragem < 10 && (registrosSusFiltradosRegistroSivepComResultadoPositivo.size() < NUMERO_POSITIVO_NEGATIVOS
					              || registrosSusFiltradosRegistroSivepComResultadoNegativo.size() < NUMERO_POSITIVO_NEGATIVOS)) {
				fileWriter.write("---------------------------\n");
				fileWriter.write("Filtragem " + filtragem + "\n");

				List<PlanilhaMGCSV> registrosSusFiltradosRegistroSivep = filtrarRegistrosSusNaoUsados(registrosSusAtualizado);

				if (filtragem < 10) {
					registrosSusFiltradosRegistroSivep = filtrarRegistrosPorFaixaEtaria(registrosSusFiltradosRegistroSivep, 
							                                                            idadeMinima, idadeMaxima);
					fileWriter.write("Filtrou " + registrosSusFiltradosRegistroSivep.size() + " registros do sus por faixa etária\n");
				} else {
					fileWriter.write("Não filtrou registros do sus por faixa etária\n");
				}
				
				if (filtragem < 9) {
					registrosSusFiltradosRegistroSivep = filtrarRegistrosSusPorRacaCor(
							registrosSusFiltradosRegistroSivep, registroSivepFiltrado);
					fileWriter.write("Filtrou " + registrosSusFiltradosRegistroSivep.size() + " registros do sus por raça cor\n");
				} else {
					fileWriter.write("Não filtrou registros do sus por raça cor\n");
				}

				if (filtragem < 8) {
					registrosSusFiltradosRegistroSivep = filtrarRegistrosSusPorDataTeste(
							registrosSusFiltradosRegistroSivep, registroSivepFiltrado, numeroSemanas);
					fileWriter.write("Filtrou " + registrosSusFiltradosRegistroSivep.size() + " registros do sus com "
							+ numeroSemanas + " semana(s) para trás e para frente por data de notificação\n");
				} else {
					fileWriter.write("Não filtrou registros do sus por data de notificação\n");
				}

				if (filtragem < 4) {
					registrosSusFiltradosRegistroSivep = filtrarRegistrosSusPorMunicipio(
							registrosSusFiltradosRegistroSivep, registroSivepFiltrado);
					fileWriter.write("Filtrou " + registrosSusFiltradosRegistroSivep.size() + " registros do sus por município\n");
				} else {
					fileWriter.write("Não filtrou registros do sus por município\n");
				}

				if (filtragem == 4) {
					registrosSusFiltradosRegistroSivep = filtrarRegistrosSusPorAreaMunicipio(
							registrosSusFiltradosRegistroSivep, registroSivepFiltrado);
					fileWriter.write("Filtrou " + registrosSusFiltradosRegistroSivep.size() + " registros do sus por área\n");
				} else {
					fileWriter.write("Não filtrou registros do sus por área\n");
				}
				
				if (filtragem < 3) {
					registrosSusFiltradosRegistroSivep = filtrarRegistrosSusPorSexo(registrosSusFiltradosRegistroSivep,
							registroSivepFiltrado);
					fileWriter.write(
							"Filtrou " + registrosSusFiltradosRegistroSivep.size() + " registros do sus por sexo\n");
				} else {
					fileWriter.write("Não filtrou registros do sus por sexo\n");
				}

				int qtdRegistros;

				if (registrosSusFiltradosRegistroSivepComResultadoPositivo.size() < NUMERO_POSITIVO_NEGATIVOS) {
					qtdRegistros = NUMERO_POSITIVO_NEGATIVOS - registrosSusFiltradosRegistroSivepComResultadoPositivo.size();
					registrosSusFiltradosRegistroSivepComResultadoPositivo.addAll(
							obterRegistrosUsadosComResultadoPositivo(registrosSusFiltradosRegistroSivep, qtdRegistros));
				}

				if (registrosSusFiltradosRegistroSivepComResultadoNegativo.size() < NUMERO_POSITIVO_NEGATIVOS) {
					qtdRegistros = NUMERO_POSITIVO_NEGATIVOS - registrosSusFiltradosRegistroSivepComResultadoNegativo.size();
					registrosSusFiltradosRegistroSivepComResultadoNegativo.addAll(
							obterRegistrosUsadosComResultadoNegativo(registrosSusFiltradosRegistroSivep, qtdRegistros));
				}

				fileWriter.write("Número atual de registros do sus usados com resultado Positivo após filtragem "
						+ filtragem + " : " + registrosSusFiltradosRegistroSivepComResultadoPositivo.size() + "\n");
				fileWriter.write("Número atual de registros do sus usados com resultado Negativo após filtragem "
						+ filtragem + " : " + registrosSusFiltradosRegistroSivepComResultadoNegativo.size() + "\n");

				filtragem++;

				if (filtragem > 4 && filtragem < 8) {
					numeroSemanas++;
				}
				
				if(registrosSusFiltradosRegistroSivepComResultadoPositivo.size() == NUMERO_POSITIVO_NEGATIVOS &&
				   registrosSusFiltradosRegistroSivepComResultadoNegativo.size() == NUMERO_POSITIVO_NEGATIVOS) {
					break;
				}
			}

			fileWriter.write("---------------------------\n");
			fileWriter.write("Resultados finais após filtragem " + (filtragem - 1) + "\n");

			if (registrosSusFiltradosRegistroSivepComResultadoPositivo.size() < NUMERO_POSITIVO_NEGATIVOS
					|| registrosSusFiltradosRegistroSivepComResultadoNegativo.size() < NUMERO_POSITIVO_NEGATIVOS) {
				fileWriter.write("Número de registros do sus com resultado Positivo e Negativo insuficientes! Registro "
						+ registro + " não será usado!\n");
				fileWriter.write(
						"Registros do sus filtrados usados vão ser desmarcados para uso posterior para filtro de outro registro sivep!\n");

				registrosSusAtualizado.removeAll(registrosSusFiltradosRegistroSivepComResultadoPositivo);
				registrosSusFiltradosRegistroSivepComResultadoPositivo.stream().forEach(r -> r.setObservacaoUso(""));
				registrosSusFiltradosRegistroSivepComResultadoPositivo.stream()
						.forEach(r -> r.setFiltroAreaMunicipio(""));
				registrosSusAtualizado.addAll(registrosSusFiltradosRegistroSivepComResultadoPositivo);

				registrosSusAtualizado.removeAll(registrosSusFiltradosRegistroSivepComResultadoNegativo);
				registrosSusFiltradosRegistroSivepComResultadoNegativo.stream().forEach(r -> r.setObservacaoUso(""));
				registrosSusFiltradosRegistroSivepComResultadoNegativo.stream()
						.forEach(r -> r.setFiltroAreaMunicipio(""));
				registrosSusAtualizado.addAll(registrosSusFiltradosRegistroSivepComResultadoNegativo);

				registrosSivepNaoUsados.add(registroSivepFiltrado);
			} else {
				fileWriter.write("Número final de registros do sus usados com resultado Positivo: "
						+ registrosSusFiltradosRegistroSivepComResultadoPositivo.size() + "\n");
				fileWriter.write("Número final de registros do sus usados com resultado Negativo: "
						+ registrosSusFiltradosRegistroSivepComResultadoNegativo.size() + "\n");

				registrosSusTotaisFiltradosComResultadoPositivo
						.addAll(registrosSusFiltradosRegistroSivepComResultadoPositivo);
				registrosSusTotaisFiltradosComResultadoNegativo
						.addAll(registrosSusFiltradosRegistroSivepComResultadoNegativo);
			}

			fileWriter.write("***************************\n");
		}

		fileWriter.flush();
		fileWriter.close();

		registrosSusTotaisFiltradosComResultadoPositivo.add(0,
				new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
				                  "urs", "sexo", "idade", "internacao", 
				                  "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
				                  "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
				                  "planilha", "sintomas", "outrosSitomas", "surto", 
				                  "vacinaCov", "dataColeta", "arquivo", "identificacao", 
				                  "municipio2", "dataNascimento2", "campo1", "ar", 
				                  "arx", "am1", "am2", "bm1", 
				                  "bm2", "cm1", "cm2", "rm1", 
				                  "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso"));
		
		PlanilhaMGCSVHandler.criarCSV(csvResultadoPositivo, registrosSusTotaisFiltradosComResultadoPositivo);

		registrosSusTotaisFiltradosComResultadoNegativo.add(0,
				new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
					              "urs", "sexo", "idade", "internacao", 
					              "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
					              "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
					              "planilha", "sintomas", "outrosSitomas", "surto", 
					              "vacinaCov", "dataColeta", "arquivo", "identificacao", 
					              "municipio2", "dataNascimento2", "campo1", "ar", 
					              "arx", "am1", "am2", "bm1", 
					              "bm2", "cm1", "cm2", "rm1", 
					              "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso"));
		
		PlanilhaMGCSVHandler.criarCSV(csvResultadoNegativo, registrosSusTotaisFiltradosComResultadoNegativo);

		registrosSivepFiltrados.removeAll(registrosSivepNaoUsados);

		registrosSivepFiltrados.add(0,
				new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
					              "urs", "sexo", "idade", "internacao", 
					              "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
					              "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
					              "planilha", "sintomas", "outrosSitomas", "surto", 
					              "vacinaCov", "dataColeta", "arquivo", "identificacao", 
					              "municipio2", "dataNascimento2", "campo1", "ar", 
					              "arx", "am1", "am2", "bm1", 
					              "bm2", "cm1", "cm2", "rm1", 
					              "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso"));

		PlanilhaMGCSVHandler.criarCSV(csvSivepUsados, registrosSivepFiltrados);

		registrosSivepNaoUsados.add(0,
				new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
			                      "urs", "sexo", "idade", "internacao", 
			                      "internacaoUti", "dataInternacao", "evolucao", "resultadoTeste", 
			                      "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
			                      "planilha", "sintomas", "outrosSitomas", "surto", 
			                      "vacinaCov", "dataColeta", "arquivo", "identificacao", 
			                      "municipio2", "dataNascimento2", "campo1", "ar", 
			                      "arx", "am1", "am2", "bm1", 
			                      "bm2", "cm1", "cm2", "rm1", 
			                      "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso"));

		PlanilhaMGCSVHandler.criarCSV(csvSivepNaoUsados, registrosSivepNaoUsados);
	}

	private List<PlanilhaMGCSV> obterRegistrosUsadosComResultadoNegativo(List<PlanilhaMGCSV> registrosSusFiltradosRegistroSivep, int qtd)
			throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		List<PlanilhaMGCSV> registrosSusFiltradosComResultadoNegativo = filtrarRegistrosSusPorResultado(
				registrosSusFiltradosRegistroSivep, "Nao Detectado");
		fileWriter.write("Filtrou " + registrosSusFiltradosComResultadoNegativo.size()
				+ " registros do sus com resultado Não Detectado\n");

		registrosSusAtualizado.removeAll(registrosSusFiltradosComResultadoNegativo);

		registrosSusFiltradosComResultadoNegativo.stream().limit(qtd)
				.forEach(r -> r.setObservacaoUso("Registro usado por " + situacao));

		registrosSusAtualizado.addAll(registrosSusFiltradosComResultadoNegativo);

		List<PlanilhaMGCSV> registrosSusFiltradosComResultadoNegativoUsados = registrosSusFiltradosComResultadoNegativo
				.stream().filter(r -> r.getObservacaoUso() != null && !r.getObservacaoUso().equals(""))
				.collect(Collectors.toList());
		if (registrosSusFiltradosComResultadoNegativoUsados.size() > 0) {
			fileWriter.write("Foram usados " + registrosSusFiltradosComResultadoNegativoUsados.size()
					+ " registros do sus com resultado Não Detectado\n");
		}

		return registrosSusFiltradosComResultadoNegativoUsados;
	}

	private List<PlanilhaMGCSV> obterRegistrosUsadosComResultadoPositivo(List<PlanilhaMGCSV> registrosSusFiltradosRegistroSivep, int qtd) 
			throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		List<PlanilhaMGCSV> registrosSusFiltradosComResultadoPositivo = filtrarRegistrosSusPorResultado(
				registrosSusFiltradosRegistroSivep, "Detectado");
		fileWriter.write("Filtrou " + registrosSusFiltradosComResultadoPositivo.size()
				+ " registros do sus com resultado Detectado\n");

		registrosSusAtualizado.removeAll(registrosSusFiltradosComResultadoPositivo);

		registrosSusFiltradosComResultadoPositivo.stream().limit(qtd)
				.forEach(r -> r.setObservacaoUso("Registro usado por " + situacao));

		registrosSusAtualizado.addAll(registrosSusFiltradosComResultadoPositivo);

		List<PlanilhaMGCSV> registrosSusFiltradosComResultadoPositivoUsados = registrosSusFiltradosComResultadoPositivo
				.stream().filter(r -> r.getObservacaoUso() != null && !r.getObservacaoUso().equals(""))
				.collect(Collectors.toList());

		if (registrosSusFiltradosComResultadoPositivoUsados.size() > 0) {
			fileWriter.write("Foram usados " + registrosSusFiltradosComResultadoPositivoUsados.size()
					+ " registros do sus com resultado Detectado\n");
		}

		return registrosSusFiltradosComResultadoPositivoUsados;
	}

}
