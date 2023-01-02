package app.pareamento;

public class ParearPacientesCOVIDComEvolucaoCasoObito {
	
	public static void main(String[] args) throws Exception {
		Pareamento pareamento = new Pareamento("Obito");
		
		pareamento.carregarArquivosCSV("./arquivos/csv/sivep/obito/SIVEP-MG2(OBITO).csv", 
				                       "./arquivos/csv/sus/SUS-MG2(ComDataTesteEIdade).csv");
		
		pareamento.parearPacientesEntreSivepESus(25, 
						                         45, 
					                             "./arquivos/txt/sivep/obito/RegistrosUsados(PacientesObitoEntre25E45Anos).txt",
					                             "./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre25E45AnosResultadoDetectado).csv", 
					                             "./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre25E45AnosResultadoNaoDetectado).csv",
					                             "./arquivos/csv/sivep/obito/SIVEP-MG(OBITO-PacientesUsadosEntre25E45Anos).csv",
					                             "./arquivos/csv/sivep/obito/SIVEP-MG(OBITO-PacientesNaoUsadosEntre25E45Anos).csv");
		
		pareamento.parearPacientesEntreSivepESus(46, 
					                             57, 
					                             "./arquivos/txt/sivep/obito/RegistrosUsados(PacientesObitoEntre46E57Anos).txt",
					                             "./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre46E57AnosResultadoDetectado).csv", 
					                             "./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre46E57AnosResultadoNaoDetectado).csv",
					                             "./arquivos/csv/sivep/obito/SIVEP-MG(OBITO-PacientesUsadosEntre46E57Anos).csv",
					                             "./arquivos/csv/sivep/obito/SIVEP-MG(OBITO-PacientesNaoUsadosEntre46E57Anos).csv");
		
		pareamento.parearPacientesEntreSivepESus(58, 
								                 78, 
								                 "./arquivos/txt/sivep/obito/RegistrosUsados(PacientesObitoEntre58E78Anos).txt",
								                 "./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre58E78AnosResultadoDetectado).csv", 
								                 "./arquivos/csv/sus/obito/SUS-MG(PacientesObitoEntre58E78AnosResultadoNaoDetectado).csv",
								                 "./arquivos/csv/sivep/obito/SIVEP-MG(OBITO-PacientesUsadosEntre58E78Anos).csv",
								                 "./arquivos/csv/sivep/obito/SIVEP-MG(OBITO-PacientesNaoUsadosEntre58E78Anos).csv");
		
		pareamento.criarArquivosCSVSusAtualizado("./arquivos/csv/sus/SUS-MG(AposUsoObito).csv");		
	}

}
