package app.preprocessamento.sus;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import app.util.DataUtil;
import csv.PlanilhaMGCSV;
import csv.PlanilhaMGCSVHandler;

public class PreencherSemanaNotificacaoSus {
	
	public static void main(String[] args) throws IOException, ParseException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        List<PlanilhaMGCSV> registros = PlanilhaMGCSVHandler.carregarCSV("./arquivos/csv/sus/SUS-MG(ComDataTesteEIdade).csv");
		
		Date dataInicioPandemia = new GregorianCalendar(2020, Calendar.FEBRUARY, 26).getTime();
		
		for (PlanilhaMGCSV registro : registros) {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd"); 
			Date dataTeste = sdf1.parse(registro.getDataTeste()); 
			long semanaNotificacao = DataUtil.obterDiferencaDias(dataTeste, dataInicioPandemia)/7;
			registro.setSemanaNotificacao(semanaNotificacao + "");
		}
		
		registros.add(0, new PlanilhaMGCSV("laboratoriox", "codigo", "dataNascimento", "municipio", "filtroAreaMunicipio", 
							               "urs", "sexo", "idade", "internacao", 
							               "internacaoUti", "dataInternacao", "evolucao", "intervalo", "resultadoTeste", 
							               "dataTeste", "comorbidade", "comorbidadeDetalhe", "raca", 
							               "planilha", "sintomas", "outrosSitomas", "surto", 
							               "vacinaCov", "dataColeta", "arquivo", "identificacao", 
							               "municipio2", "dataNascimento2", "campo1", "ar", 
							               "arx", "am1", "am2", "bm1", 
							               "bm2", "cm1", "cm2", "rm1", 
							               "rm2", "qbm1", "qbm2", "qam1", "qam2", "observacaoUso", "etniaRedome", "semanaNotificacao"));
		
		PlanilhaMGCSVHandler.criarCSV("./arquivos/csv/sus/SUS-MG2(ComDataTesteEIdade).csv", registros);
	}

}
