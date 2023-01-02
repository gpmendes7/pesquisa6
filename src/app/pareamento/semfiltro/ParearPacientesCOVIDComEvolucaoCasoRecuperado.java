package app.pareamento.semfiltro;

public class ParearPacientesCOVIDComEvolucaoCasoRecuperado {
	
	public static void main(String[] args) throws Exception {
		PareamentoSemFiltro pareamento = new PareamentoSemFiltro("Recuperado");
		
		pareamento.carregarArquivosCSV("./arquivos/csv/sivep/recuperado/SIVEP-MG2(RECUPERADO).csv", 
				                       "./arquivos/csv/sus/SUS-MG(AposUsoObito).csv");
		
		pareamento.parearPacientesEntreSivepESus(20, 
						                         40, 
					                             "./arquivos/txt/sivep/recuperado/RegistrosUsados(PacientesRecuperadoEntre20E40Anos).txt",
					                             "./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre20E40AnosResultadoDetectado).csv", 
					                             "./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre20E40AnosResultadoNaoDetectado).csv",
					                             "./arquivos/csv/sivep/recuperado/SIVEP-MG(RECUPERADO-PacientesUsadosEntre20E40Anos).csv",
					                             "./arquivos/csv/sivep/recuperado/SIVEP-MG(RECUPERADO-PacientesNaoUsadosEntre20E40Anos).csv");
		
		pareamento.parearPacientesEntreSivepESus(41, 
								                 51, 
								                 "./arquivos/txt/sivep/recuperado/RegistrosUsados(PacientesRecuperadoEntre41E51Anos).txt",
								                 "./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre41E51AnosResultadoDetectado).csv", 
								                 "./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre41E51AnosResultadoNaoDetectado).csv",
								                 "./arquivos/csv/sivep/recuperado/SIVEP-MG(RECUPERADO-PacientesUsadosEntre41E51Anos).csv",
								                 "./arquivos/csv/sivep/recuperado/SIVEP-MG(RECUPERADO-PacientesNaoUsadosEntre41E51Anos).csv");
		
		pareamento.parearPacientesEntreSivepESus(52, 
								                 74, 
								                 "./arquivos/txt/sivep/recuperado/RegistrosUsados(PacientesRecuperadoEntre52E74Anos).txt",
								                 "./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre52E74AnosResultadoDetectado).csv", 
								                 "./arquivos/csv/sus/recuperado/SUS-MG(PacientesRecuperadoEntre52E74AnosResultadoNaoDetectado).csv",
								                 "./arquivos/csv/sivep/recuperado/SIVEP-MG(RECUPERADO-PacientesUsadosEntre52E74Anos).csv",
								                 "./arquivos/csv/sivep/recuperado/SIVEP-MG(RECUPERADO-PacientesNaoUsadosEntre52E74Anos).csv");
		
		pareamento.criarArquivosCSVSusAtualizado("./arquivos/csv/sus/SUS-MG(AposUsoRecuperado).csv");		
	}

}
