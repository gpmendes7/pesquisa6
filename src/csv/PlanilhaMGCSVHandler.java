package csv;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class PlanilhaMGCSVHandler {
	
private static ColumnPositionMappingStrategy<PlanilhaMGCSV> strategy;
	
	static {
		strategy = new ColumnPositionMappingStrategy<PlanilhaMGCSV>();
		strategy.setType(PlanilhaMGCSV.class);

		String[] colunas = { "laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio",
				             "urs", "sexo", "idade", "internacao", "internacaoUti",
				             "dataInternacao", "evolucao", "intervalo", "resultadoTeste", "dataTeste",
				             "comorbidade", "comorbidadeDetalhe", "raca", "planilha",
				             "sintomas", "outrosSitomas", "surto", "vacinaCov",
				             "dataColeta", "arquivo", "identificacao", "municipio2",
				             "dataNascimento2", "campo1", "ar", "arx", "am1",
				             "am2", "bm1", "bm2", "cm1",
				             "cm2", "rm1", "rm2", "qbm1",
				             "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome", "semanaNotificacao"};
 
		strategy.setColumnMapping(colunas);
	}
	
	public static List<PlanilhaMGCSV> carregarCSV(String nomeArquivo) throws IOException {
		try (Reader reader = Files.newBufferedReader(Paths.get(nomeArquivo));) {
			CsvToBean<PlanilhaMGCSV> csvToBean = new CsvToBeanBuilder<PlanilhaMGCSV>(reader).withMappingStrategy(strategy)
					.withType(PlanilhaMGCSV.class).withSeparator(',').withSkipLines(1).build();
			List<PlanilhaMGCSV> registros = csvToBean.parse();
			return registros;
		}
	}
	
	public static void criarCSV(String nomeArquivo, List<PlanilhaMGCSV> registros) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		try (Writer writer = Files.newBufferedWriter(Paths.get(nomeArquivo));) {
			StatefulBeanToCsv<PlanilhaMGCSV> beanToCsv = new StatefulBeanToCsvBuilder<PlanilhaMGCSV>(writer)
														.withMappingStrategy(strategy)
														.withSeparator(',')
														.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
														.build();
			beanToCsv.write(registros);
		}
	}

}
