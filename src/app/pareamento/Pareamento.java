package app.pareamento;

import static app.pareamento.FiltrosPareamento.filtrarRegistrosPorFaixaEtaria;
import static app.pareamento.FiltrosPareamento.filtrarRegistrosSusNaoUsados;
import static app.pareamento.FiltrosPareamento.filtrarRegistrosSusPorAreaMunicipio;
import static app.pareamento.FiltrosPareamento.filtrarRegistrosSusPorDataTeste;
import static app.pareamento.FiltrosPareamento.filtrarRegistrosSusPorMunicipio;
import static app.pareamento.FiltrosPareamento.filtrarRegistrosSusPorResultado;
import static app.pareamento.FiltrosPareamento.filtrarRegistrosSusPorSexo;
import static app.pareamento.FiltrosPareamento.filtrarRegistrosSusPorEtniaRedome;

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
										                "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome"));

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
			int numeroSemanas = 1;
			List<PlanilhaMGCSV> registrosSusFiltradosRegistroSivepComResultadoPositivo = new ArrayList<>();
			List<PlanilhaMGCSV> registrosSusFiltradosRegistroSivepComResultadoNegativo = new ArrayList<>();

			while (filtragem < 9 && (registrosSusFiltradosRegistroSivepComResultadoPositivo.size() < NUMERO_POSITIVO_NEGATIVOS
					             || registrosSusFiltradosRegistroSivepComResultadoNegativo.size() < NUMERO_POSITIVO_NEGATIVOS)) {
				fileWriter.write("---------------------------\n");
				fileWriter.write("Filtragem " + filtragem + "\n");

				List<PlanilhaMGCSV> registrosSusFiltradosRegistroSivep = filtrarRegistrosSusNaoUsados(registrosSusAtualizado);

				if (filtragem < 9) {
					registrosSusFiltradosRegistroSivep = filtrarRegistrosPorFaixaEtaria(registrosSusFiltradosRegistroSivep, 
							                                                            idadeMinima, idadeMaxima);
					fileWriter.write("Filtrou " + registrosSusFiltradosRegistroSivep.size() + " registros do sus por faixa et�ria\n");
				} else {
					fileWriter.write("N�o filtrou registros do sus por faixa et�ria\n");
				}
				
		
				if (filtragem < 8) {
					registrosSusFiltradosRegistroSivep = filtrarRegistrosSusPorEtniaRedome(
							registrosSusFiltradosRegistroSivep, registroSivepFiltrado);
					fileWriter.write("Filtrou " + registrosSusFiltradosRegistroSivep.size() + " registros do sus por ra�a cor\n");
				} else {
					fileWriter.write("N�o filtrou registros do sus por ra�a cor\n");
				}

				if (filtragem < 7) {
					registrosSusFiltradosRegistroSivep = filtrarRegistrosSusPorDataTeste(
							registrosSusFiltradosRegistroSivep, registroSivepFiltrado, numeroSemanas);
					fileWriter.write("Filtrou " + registrosSusFiltradosRegistroSivep.size() + " registros do sus com "
							+ numeroSemanas + " semana(s) para tr�s e para frente por data de teste\n");
				} else {
					fileWriter.write("N�o filtrou registros do sus por data de teste\n");
				}

				if (filtragem < 3) {
					registrosSusFiltradosRegistroSivep = filtrarRegistrosSusPorMunicipio(
							registrosSusFiltradosRegistroSivep, registroSivepFiltrado);
					fileWriter.write("Filtrou " + registrosSusFiltradosRegistroSivep.size() + " registros do sus por munic�pio\n");
				} else {
					fileWriter.write("N�o filtrou registros do sus por munic�pio\n");
				}

				if (filtragem == 3) {
					registrosSusFiltradosRegistroSivep = filtrarRegistrosSusPorAreaMunicipio(
							registrosSusFiltradosRegistroSivep, registroSivepFiltrado);
					fileWriter.write("Filtrou " + registrosSusFiltradosRegistroSivep.size() + " registros do sus por �rea\n");
				} else {
					fileWriter.write("N�o filtrou registros do sus por �rea\n");
				}
				
				if (filtragem < 2) {
					registrosSusFiltradosRegistroSivep = filtrarRegistrosSusPorSexo(registrosSusFiltradosRegistroSivep,
							registroSivepFiltrado);
					fileWriter.write(
							"Filtrou " + registrosSusFiltradosRegistroSivep.size() + " registros do sus por sexo\n");
				} else {
					fileWriter.write("N�o filtrou registros do sus por sexo\n");
				}

				int qtdRegistros;

				if (registrosSusFiltradosRegistroSivepComResultadoPositivo.size() < NUMERO_POSITIVO_NEGATIVOS) {
					qtdRegistros = NUMERO_POSITIVO_NEGATIVOS - registrosSusFiltradosRegistroSivepComResultadoPositivo.size();
					registrosSusFiltradosRegistroSivepComResultadoPositivo.addAll(
							obterRegistrosUsadosComResultadoDetectado(registrosSusFiltradosRegistroSivep, qtdRegistros));
				}

				if (registrosSusFiltradosRegistroSivepComResultadoNegativo.size() < NUMERO_POSITIVO_NEGATIVOS) {
					qtdRegistros = NUMERO_POSITIVO_NEGATIVOS - registrosSusFiltradosRegistroSivepComResultadoNegativo.size();
					registrosSusFiltradosRegistroSivepComResultadoNegativo.addAll(
							obterRegistrosUsadosComResultadoNaoDetectado(registrosSusFiltradosRegistroSivep, qtdRegistros));
				}

				fileWriter.write("N�mero atual de registros do sus usados com resultado Detectado ap�s filtragem "
						+ filtragem + " : " + registrosSusFiltradosRegistroSivepComResultadoPositivo.size() + "\n");
				fileWriter.write("N�mero atual de registros do sus usados com resultado N�o Detectado ap�s filtragem "
						+ filtragem + " : " + registrosSusFiltradosRegistroSivepComResultadoNegativo.size() + "\n");

				filtragem++;

				if (filtragem > 3 && filtragem < 7) {
					numeroSemanas++;
				}
				
				if(registrosSusFiltradosRegistroSivepComResultadoPositivo.size() == NUMERO_POSITIVO_NEGATIVOS &&
				   registrosSusFiltradosRegistroSivepComResultadoNegativo.size() == NUMERO_POSITIVO_NEGATIVOS) {
					break;
				}
			}

			fileWriter.write("---------------------------\n");
			fileWriter.write("Resultados finais ap�s filtragem " + (filtragem - 1) + "\n");

			if (registrosSusFiltradosRegistroSivepComResultadoPositivo.size() < NUMERO_POSITIVO_NEGATIVOS
					|| registrosSusFiltradosRegistroSivepComResultadoNegativo.size() < NUMERO_POSITIVO_NEGATIVOS) {
				fileWriter.write("N�mero de registros do sus com resultado Detectado e N�o Detectado insuficientes! Registro "
						+ registro + " n�o ser� usado!\n");
				fileWriter.write(
						"Registros do sus filtrados usados v�o ser desmarcados para uso posterior para filtro de outro registro sivep!\n");

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
				fileWriter.write("N�mero final de registros do sus usados com resultado Positivo: "
						+ registrosSusFiltradosRegistroSivepComResultadoPositivo.size() + "\n");
				fileWriter.write("N�mero final de registros do sus usados com resultado Negativo: "
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
				                  "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome"));
		
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
					              "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome"));
		
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
					              "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome"));

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
			                      "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome"));

		PlanilhaMGCSVHandler.criarCSV(csvSivepNaoUsados, registrosSivepNaoUsados);
	}

	private List<PlanilhaMGCSV> obterRegistrosUsadosComResultadoNaoDetectado(List<PlanilhaMGCSV> registrosSusFiltradosRegistroSivep, int qtd)
			throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		List<PlanilhaMGCSV> registrosSusFiltradosComResultadoNaoDetectado = filtrarRegistrosSusPorResultado(
				registrosSusFiltradosRegistroSivep, "Nao Detectado");
		fileWriter.write("Filtrou " + registrosSusFiltradosComResultadoNaoDetectado.size()
				+ " registros do sus com resultado N�o Detectado\n");
		

		registrosSusAtualizado.removeAll(registrosSusFiltradosComResultadoNaoDetectado);
		

		registrosSusFiltradosComResultadoNaoDetectado.stream().limit(qtd)
				.forEach(r -> r.setObservacaoUso("Registro usado por " + situacao));
		
		registrosSusAtualizado.addAll(registrosSusFiltradosComResultadoNaoDetectado);

		List<PlanilhaMGCSV> registrosSusFiltradosComResultadoNaoDetectadoUsados = registrosSusFiltradosComResultadoNaoDetectado
				.stream().filter(r -> r.getObservacaoUso() != null && !r.getObservacaoUso().equals(""))
				.collect(Collectors.toList());

		if (registrosSusFiltradosComResultadoNaoDetectadoUsados.size() > 0) {
			fileWriter.write("Foram usados " + registrosSusFiltradosComResultadoNaoDetectadoUsados.size()
					+ " registros do sus com resultado N�o Detectado\n");
		}

		return registrosSusFiltradosComResultadoNaoDetectadoUsados;
	}

	private List<PlanilhaMGCSV> obterRegistrosUsadosComResultadoDetectado(List<PlanilhaMGCSV> registrosSusFiltradosRegistroSivep, int qtd) 
			throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
		List<PlanilhaMGCSV> registrosSusFiltradosComResultadoDetectado = filtrarRegistrosSusPorResultado(
				registrosSusFiltradosRegistroSivep, "Detectado");
		fileWriter.write("Filtrou " + registrosSusFiltradosComResultadoDetectado.size()
				+ " registros do sus com resultado Detectado\n");
		
		registrosSusAtualizado.removeAll(registrosSusFiltradosComResultadoDetectado);

		registrosSusFiltradosComResultadoDetectado.stream().limit(qtd)
				.forEach(r -> r.setObservacaoUso("Registro usado por " + situacao));

		registrosSusAtualizado.addAll(registrosSusFiltradosComResultadoDetectado);

		List<PlanilhaMGCSV> registrosSusFiltradosComResultadoDetectadoUsados = registrosSusFiltradosComResultadoDetectado
				.stream().filter(r -> r.getObservacaoUso() != null && !r.getObservacaoUso().equals(""))
				.collect(Collectors.toList());

		if (registrosSusFiltradosComResultadoDetectadoUsados.size() > 0) {
			fileWriter.write("Foram usados " + registrosSusFiltradosComResultadoDetectadoUsados.size()
					+ " registros do sus com resultado Detectado\n");
		}

		return registrosSusFiltradosComResultadoDetectadoUsados;
	}

}
