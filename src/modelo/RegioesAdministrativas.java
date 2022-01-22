package modelo;

import static app.util.StringUtil.normalizarString;

public class RegioesAdministrativas {
	
	
	private static final String[] NOROESTE = {"Arinos", "Bonfin�polis de Minas", "Buritis", "Cabeceira Grande",
			                                  "Dom Bosco", "Formoso", "Natal�ndia", "Una�",
			                                  "Uruana de Minas", "Brasil�ndia de Minas", "Guarda Mor", "Jo�o Pinheiro",
			                                  "Jo�o Pinheiro", "Lagoa Grande", "Paracatu", "Presidente Oleg�rio",
			                                  "S�o Gon�alo do Abaet�", "Varj�o de Minas", "Vazante"};
	
	private static final String[] NORTE = {"Bonito de Minas", "Chapada Ga�cha", "C�nego Marinho", "Icara� de Minas",
			                               "Itacarambi", "Janu�ria", "Juven�lia", "Manga",
			                               "Matias Cardoso", "Mirav�nia", "Montalv�nia", "Pedras de Maria da Cruz",
			                               "Pint�polis", "S�o Francisco", "S�o Jo�o das Miss�es", "Urucuia",
			                               "Catuti", "Espinosa", "Gameleiras", "Ja�ba",
			                               "Jana�ba", "Mamonas", "Mato Verde", "Monte Azul",
			                               "Nova Porteirinha", "Pai Pedro", "Porteirinha", "Riacho dos Machados",
			                               "Serran�polis de Minas", "�guas Vermelhas", "Berizal",
			                               "Curral de Dentro", "Divisa Alegre", "Fruta de Leite", "Indaiabira",
			                               "Montezuma", "Ninheira", "Novorizonte", "Rio Pardo de Minas",
			                               "Rubelita", "Salinas", "Santa Cruz de Salinas", "Santo Ant�nio do Retiro",
			                               "S�o Jo�o do Para�so", "Taiobeiras", "Vargem Grande do Rio Pardo", "Buritizeiro",
			                               "Ibia�", "Jequita�", "Lagoa dos Patos", "Lassance",
			                               "Pirapora", "Riachinho", "Santa F� de Minas", "S�o Rom�o",
			                               "V�rzea da Palma", "Bras�lia de Minas", "Campo Azul", "Capit�o En�ias",
			                               "Claro dos Po��es", "Cora��o de Jesus", "Francisco S�", "Glaucil�ndia",
			                               "Ibiracatu", "Japonvar", "Juramento", "Lontra",
			                               "Luisl�ndia", "Mirabela", "Montes Claros", "Patis",
			                               "Ponto Chique", "S�o Jo�o da Lagoa", "S�o Jo�o da Ponte", "S�o Jo�o do Pacu�",
			                               "Uba�", "Varzel�ndia", "Verdel�ndia", "Botumirim",
			                               "Crist�lia", "Gr�o Mogol", "Itacambira", "Josen�polis",
			                               "Padre Carvalho", "Bocai�va", "Engenheiro Navarro", "Francisco Dumont",
			                               "Guaraciama", "Olhos d'�gua"};
	

	private static final String[] JEQUITINHONHA = {"Couto de Magalh�es de Minas", "Datas", "Diamantina", "Fel�cio dos Santos",
			                                       "Gouveia", "Presidente Kubitschek", "S�o Gon�alo do Rio Preto", "Senador Modestino Gon�alves",
			                                       "Angel�ndia", "Aricanduva", "Berilo", "Capelinha",
			                                       "Carbonita", "Chapada do Norte", "Francisco Badar�", "Itamarandiba",
			                                       "Jenipapo de Minas", "Jos� Gon�alves de Minas", "Leme do Prado", "Minas Novas",
			                                       "Turmalina", "Veredinha", "Ara�ua�", "Cara�",
			                                       "Coronel Murta", "Itinga", "Novo Cruzeiro", "Padre Para�so",
			                                       "Ponto dos Volantes", "Virgem da Lapa", "Cachoeira de Paje�", "Comercinho",
			                                       "Itaobim", "Medina", "Pedra Azul", "Almenara",
			                                       "Bandeira", "Divis�polis", "Felisburgo", "Jacinto",
			                                       "Jequitinhonha", "Joa�ma", "Jord�nia", "Mata Verde",
			                                       "Monte Formoso", "Palm�polis", "Rio do Prado", "Rubim",
			                                       "Salto da Divisa", "Santa Maria do Salto", "Santo Ant�nio do Jacinto"};
	
	private static final String[] VALE_MUCURI = {"Atal�ia", "Catuji", "Francisc�polis", "Frei Gaspar", 
												 "Itaip�", "Ladainha", "Malacacheta", "Novo Oriente de Minas", 
												 "Ouro Verde de Minas", "Pav�o", "Pot�", "Setubinha", "Te�filo Ot�ni",
									             "�guas Formosas", "Bert�polis", "Carlos Chagas", "Cris�lita",
									             "Fronteira dos Vales", "Maxacalis", "Nanuque", "Santa Helena de Minas",
									             "Serra dos Aimor�s", "Umburatiba", ""};
	
	
	private static final String[] TRIANGULO_MINEIRO_ALTO_PARANAIBA = {"Cachoeira Dourada", "Capin�polis", "Gurinhat�", "Ipia�u",
			                                                          "Ituiutaba", "Santa Vit�ria", "Araguari", "Arapor�",
			                                                          "Can�polis", "Cascalho Rico", "Centralina", "Indian�polis",
			                                                          "Monte Alegre de Minas", "Prata", "Tupaciguara", "Uberl�ndia",
			                                                          "Abadia dos Dourados", "Coromandel", "Cruzeiro da Fortaleza", "Douradoquara",
			                                                          "Estrela do Sul", "Grupiara", "Ira� de Minas", "Monte Carmelo",
			                                                          "Patroc�nio", "Romaria", "Serra do Salitre", "Arapu�",
			                                                          "Carmo do Parana�ba", "Guimar�nia", "Lagoa Formosa", "Matutina",
			                                                          "Patos de Minas", "Rio Parana�ba", "Santa Rosa da Serra", "S�o Gotardo",
			                                                          "Tiros", "Campina Verde", "Carneirinho", "Comendador Gomes",
			                                                          "Fronteira", "Frutal", "Itapajipe", "Iturama",
			                                                          "Limeira do Oeste", "Limeira do Oeste", "Planura", "S�o Francisco de Sales",
			                                                          "Uni�o de Minas", "�gua Comprida", "Campo Florido", "Concei��o das Alagoas",
			                                                          "Conquista", "Delta", "Uberaba", "Ver�ssimo",
			                                                          "Arax�", "Campos Altos", "Ibi�", "Nova Ponte",
			                                                          "Pedrin�polis", "Perdizes", "Pratinha", "Sacramento",
			                                                          "Santa Juliana", "Tapira"};
	
	
	private static final String[] CENTRAL_MINEIRA = {"Abaet�", "Biquinhas", "Cedro do Abaet�", "Morada Nova de Minas",
			                                         "Paineiras", "Pomp�u", "Tr�s Marias", "Augusto de Lima",
			                                         "Buen�polis", "Corinto", "Curvelo", "Felixl�ndia",
			                                         "Inimutaba", "Joaquim Fel�cio", "Monjolos", "Morro da Gar�a",
			                                         "Presidente Juscelino", "Santo Hip�lito", "Ara�jos", "Bom Despacho",
			                                         "Dores do Indai�" , "Estrela do Indai�", "Japara�ba", "Lagoa da Prata",
			                                         "Leandro Ferreira", "Luz", "Martinho Campos", "Moema",
			                                         "Quartel Geral", "Serra da Saudade"};
	
	private static final String[] METROPOLITANA_BELO_HORIZONTE = {"Ara�a�", "Baldim", "Cachoeira da Prata", "Caetan�polis", 
			                                                      "Capim Branco", "Cordisburgo", "Fortuna de Minas", "Funil�ndia",
			                                                      "Inha�ma", "Jabuticatubas", "Jequitib�", "Maravilhas",
			                                                      "Matozinhos", "Papagaios", "Paraopeba", "Pequi",
			                                                      "Prudente de Morais", "Santana de Pirapama", "Santana do Riacho", "Sete Lagoas",
			                                                      "Alvorada de Minas", "Concei��o do Mato Dentro", "Congonhas do Norte", "Dom Joaquim",
			                                                      "Itamb� do Mato Dentro", "Morro do Pilar", "Passab�m", "Rio Vermelho",
			                                                      "Santo Ant�nio do Itamb�", "Santo Ant�nio do Rio Abaixo", "S�o Sebasti�o do Rio Preto", "Serra Azul de Minas",
			                                                      "Serro", "Florestal", "On�a de Pitangui", "Par� de Minas", "Pitangui",
			                                                      "S�o Jos� da Varginha", "Belo Horizonte", "Betim", "Brumadinho",
			                                                      "Caet�", "Confins", "Contagem", "Esmeraldas",
			                                                      "Ibirit�", "Igarap�", "Juatuba", "Lagoa Santa",
			                                                      "M�rio Campos", "Mateus Leme", "Nova Lima", "Pedro Leopoldo",
			                                                      "Raposos", "Ribeir�o das Neves", "Rio Acima", "Sabar�",
			                                                      "Santa Luzia", "S�o Joaquim de Bicas", "S�o Jos� da Lapa", "Sarzedo",
			                                                      "Vespasiano", "Alvin�polis", "Bar�o de Cocais", "Bela Vista de Minas",
			                                                      "Bom Jesus do Amparo", "Catas Altas", "Dion�sio", "Ferros",
			                                                      "Itabira", "Jo�o Monlevade", "Nova Era", "Nova Uni�o", 
			                                                      "Rio Piracicaba", "Santa B�rbara", "Santa Maria de Itabira", "S�o Domingos do Prata",
			                                                      "S�o Gon�alo do Rio Abaixo", "S�o Jos� do Goiabal", "Taquara�u de Minas", "Belo Vale",
			                                                      "Bonfim", "Crucil�ndia", "Itaguara", "Itatiaiu�u", "Jeceaba",
			                                                      "Moeda", "Piedade dos Gerais", "Rio Manso", "Diogo de Vasconcelos",
			                                                      "Itabirito", "Mariana", "Ouro Preto", "Casa Grande",
			                                                      "Catas Altas da Noruega", "Congonhas", "Conselheiro Lafaiete", "Cristiano Ot�ni",
			                                                      "Desterro de Entre Rios", "Entre Rios de Minas", "Itaverava", "Ouro Branco",
			                                                      "Queluzito", "Santana dos Montes", "S�o Br�s do Sua�u�"};
	
	private static final String[] VALE_RIO_DOCE = {"Bra�nas", "Carm�sia", "Coluna", "Divinol�ndia de Minas",
			                                       "Dores de Guanh�es", "Gonzaga", "Guanh�es", "Materl�ndia",
			                                       "Paulistas", "Sabin�polis", "Santa Efig�nia de Minas", "S�o Jo�o Evangelista", 
			                                       "Sardo�", "Senhora do Porto", "Virgin�polis", "�gua Boa",
			                                       "Cantagalo", "Frei Lagonegro", "Jos� Raydan", "Pe�anha",
			                                       "Santa Maria do Sua�u�", "S�o Jos� do Jacuri", "S�o Pedro do Sua�u�", "S�o Sebasti�o do Maranh�o",
			                                       "Alpercata", "Campan�rio", "Capit�o Andrade", "Coroaci",
			                                       "Divino das Laranjeiras", "Engenheiro Caldas", "Fernandes Tourinho", "Frei Inoc�ncio",
			                                       "Galil�ia", "Governador Valadares", "Itambacuri", "Itanhomi",
			                                       "Jampruca", "Marilac", "Matias Lobato", "Nacip Raydan",
			                                       "Nova M�dica", "Pescador", "S�o Geraldo da Piedade", "S�o Geraldo do Baixio", 
			                                       "S�o Jos� da Safira", "S�o Jos� do Divino", "Sobr�lia", "Tumiritinga",
			                                       "Virgol�ndia", "Central de Minas", "Itabirinha de Mantena", "Mantena",
			                                       "Mendes Pimentel", "Nova Bel�m", "S�o F�lix de Minas", "S�o Jo�o do Manteninha",
			                                       "A�ucena", "Ant�nio Dias", "Belo Oriente", "Coronel Fabriciano",
			                                       "Ipatinga", "Jaguara�u", "Joan�sia", "Marli�ria",
			                                       "Mesquita", "Naque", "Periquito", "Santana do Para�so",
			                                       "Tim�teo", "Bom Jesus do Galho", "Bugre", "Caratinga",
			                                       "C�rrego Novo", "Dom Cavati", "Entre Folhas", "Iapu",
			                                       "Imb� de Minas", "Inhapim", "Ipaba", "Piedade de Caratinga",
			                                       "Pingo d'�gua", "Santa Rita de Minas", "S�o Domingos das Dores", "S�o Jo�o do Oriente",
			                                       "S�o Sebasti�o do Anta", "Tarumirim", "Ubaporanga", "Vargem Alegre",
			                                       "Aimor�s", "Alvarenga", "Concei��o de Ipanema", "Conselheiro Pena",
			                                       "Cuparaque", "Goiabeira", "Ipanema", "Itueta",
			                                       "Mutum", "Pocrane", "Resplendor", "Santa Rita do Itueto", "Taparuba"};
	
	private static final String[] OESTE = {"Bambu�", "C�rrego Danta", "Dores�polis", "Iguatama",
			                               "Medeiros", "Pium-�", "S�o Roque de Minas", "Tapira�",
			                               "Vargem Bonita", "Carmo do Cajuru", "Cl�udio", "Concei��o do Par�",
			                               "Divin�polis", "Igaratinga", "Ita�na", "Nova Serrana",
			                               "Perdig�o", "Santo Ant�nio do Monte", "S�o Gon�alo do Par�", "S�o Sebasti�o do Oeste",
			                               "Arcos", "Camacho", "C�rrego Fundo", "Formiga",
			                               "Itapecerica", "Pains", "Pedra do Indai�", "Pimenta",
			                               "Aguanil", "Campo Belo", "Cana Verde", "Candeias",
			                               "Cristais", "Perd�es", "Santana do Jacar�", "Bom Sucesso",
			                               "Carmo da Mata", "Carm�polis de Minas", "Ibituruna", "Oliveira",
			                               "Passa Tempo", "Piracema", "Santo Ant�nio do Amparo", "S�o Francisco de Paula"};
	
	private static final String[] SUL_SUDOESTE = {"Alpin�polis", "Bom Jesus da Penha", "Capetinga", "Capit�lio",
			                                      "C�ssia", "Claraval", "Delfin�polis", "Fortaleza de Minas",
			                                      "Ibiraci", "Ita� de Minas", "Passos", "Prat�polis",
			                                      "S�o Jo�o Batista do Gl�ria", "S�o Jos� da Barra", "Arceburgo", "Cabo Verde",
			                                      "Guaran�sia", "Guaxup�", "Itamoji", "Jacu�",
			                                      "Juruaia", "Monte Belo", "Monte Santo de Minas", "Muzambinho",
			                                      "Nova Resende", "S�o Pedro da Uni�o", "S�o Sebasti�o do Para�so", "S�o Tom�s de Aquino",
			                                      "Alfenas", "Alterosa", "Areado", "Carmo do Rio Claro",
			                                      "Carvalh�polis", "Concei��o da Aparecida", "Divisa Nova", "Fama",
			                                      "Machado", "Paragua�u", "Po�o Fundo", "Serrania",
			                                      "Boa Esperan�a", "Campanha", "Campo do Meio", "Campos Gerais",
			                                      "Carmo da Cachoeira", "Coqueiral", "El�i Mendes", "Guap�",
			                                      "Ilic�nea", "Monsenhor Paulo", "Santana da Vargem", "S�o Bento Abade",
			                                      "S�o Tom� das Letras", "Tr�s Cora��es", "Tr�s Pontas", "Varginha",
			                                      "Albertina", "Andradas", "Bandeira do Sul", "Botelhos",
			                                      "Caldas", "Campestre", "Ibiti�ra de Minas", "Inconfidentes",
			                                      "Jacutinga", "Monte Si�o", "Ouro Fino", "Po�os de Caldas",
			                                      "Santa Rita de Caldas", "Bom Repouso", "Borda da Mata", "Bueno Brand�o",
			                                      "Camanducaia", "Cambu�", "Congonhal", "C�rrego do Bom Jesus",
			                                      "Esp�rito Santo do Dourado", "Estiva", "Extrema", "Gon�alves", 
			                                      "Ipui�na", "Itapeva", "Munhoz", "Pouso Alegre", 
			                                      "Sapuca� Mirim", "Senador Amaral", "Senador Jos� Bento", "Tocos do Moji",
			                                      "Toledo", "Cachoeira de Minas", "Carea�u", "Concei��o das Pedras", 
			                                      "Concei��o dos Ouros", "Cordisl�ndia", "Heliodora", "Nat�rcia", 
			                                      "Pedralva", "Santa Rita do Sapuca�", "S�o Gon�alo do Sapuca�", "S�o Jo�o da Mata",
			                                      "S�o Jos� do Alegre", "S�o Sebasti�o da Bela Vista", "Silvian�polis", "Turvol�ndia",
			                                      "Alagoa", "Baependi", "Cambuquira", "Carmo de Minas",
			                                      "Caxambu", "Concei��o do Rio Verde", "Itamonte",
			                                      "Itanhandu", "Jesu�nia", "Lambari", "Ol�mpio Noronha",
			                                      "Passa Quatro", "Pouso Alto", "S�o Louren�o", "S�o Sebasti�o do Rio Verde",
			                                      "Soledade de Minas", "Aiuruoca", "Andrel�ndia", "Arantina",
			                                      "Bocaina de Minas", "Bom Jardim de Minas", "Carvalhos", "Cruz�lia",
			                                      "Liberdade", "Minduri", "Passa Vinte", "S�o Vicente de Minas", "Seritinga",
			                                      "Serranos", "Bras�polis", "Consola��o", "Cristina",
			                                      "Delfim Moreira", "Dom Vi�oso", "Itajub�", "Maria da F�", "Marmel�polis",
			                                      "Parais�polis", "Pirangu�u", "Piranguinho", "Venceslau Br�s",
			                                      "Virg�nia"};
	

	private static final String[] CAMPO_VERTENTES = {"Carrancas", "Ijaci", "Inga�", "Itumirim",
			                                         "Itutinga", "Lavras", "Lumin�rias", "Nepomuceno",
			                                         "Ribeir�o Vermelho", "Concei��o da Barra de Minas", "Coronel Xavier Chaves", "Dores de Campos",
			                                         "Lagoa Dourada", "Madre de Deus de Minas", "Nazareno", "Piedade do Rio Grande",
			                                         "Prados", "Resende Costa", "Rit�polis", "Santa Cruz de Minas",
			                                         "Santana do Garamb�u", "S�o Jo�o del Rei", "S�o Tiago", "Tiradentes",
			                                         "Alfredo Vasconcelos", "Ant�nio Carlos", "Barbacena", "Barroso",
			                                         "Capela Nova", "Carana�ba", "Caranda�", "Desterro do Melo",
			                                         "Ibertioga", "Ressaquinha", "Santa B�rbara do Tug�rio", "Senhora dos Rem�dios"};
	
	
	private static final String[] ZONA_MATA = {"Acaiaca", "Barra Longa", "Dom Silv�rio", "Guaraciaba",
			                                   "Jequeri", "Orat�rios", "Piedade de Ponte Nova", "Ponte Nova",
			                                   "Raul Soares", "Rio Casca", "Rio Doce", "Santa Cruz do Escalvado",
			                                   "Santo Ant�nio do Grama", "S�o Pedro dos Ferros", "Sem Peixe", "Sericita",
			                                   "Uruc�nia", "Vermelho Novo", "Abre Campo", "Alto Capara�",
			                                   "Alto Jequitib�", "Capara�", "Caputira", "Chal�",
			                                   "Durand�", "Lajinha", "Luisburgo", "Manhua�u",
			                                   "Manhumirim", "Martins Soares", "Matip�", "Pedra Bonita",
			                                   "Reduto", "Santa B�rbara do Leste", "Santa Margarida", "Santana do Manhua�u",
			                                   "S�o Jo�o do Manhua�u", "S�o Jos� do Mantimento", "Simon�sia", "Alto Rio Doce",
			                                   "Amparo da Serra", "Araponga", "Br�s Pires", "Cajuri",
			                                   "Cana�", "Cipot�nea", "Coimbra", "Erv�lia",
			                                   "Lamim", "Paula C�ndido", "Pedra do Anta", "Piranga",
			                                   "Porto Firme", "Presidente Bernardes", "Rio Espera", "S�o Miguel do Anta",
			                                   "Senhora de Oliveira", "Teixeiras", "Vi�osa", "Ant�nio Prado de Minas",
			                                   "Bar�o do Monte Alto", "Caiana", "Carangola", "Divino",
			                                   "Espera Feliz", "Eugen�polis", "Faria Lemos", "Fervedouro",
			                                   "Miradouro", "Mira�", "Muria�", "Oriz�nia",
			                                   "Patroc�nio do Muria�", "Pedra Dourada", "Ros�rio da Limeira", "S�o Francisco do Gl�ria",
			                                   "S�o Sebasti�o da Vargem Alegre", "Tombos", "Vieiras", "Astolfo Dutra",
			                                   "Divin�sia", "Dores do Turvo", "Guarani", "Guidoval",
			                                   "Guiricema", "Merc�s", "Pira�ba", "Rio Pomba",
			                                   "Rodeiro", "S�o Geraldo", "Senador Firmino", "Silveir�nia",
			                                   "Tabuleiro", "Tocantins", "Ub�", "Visconde do Rio Branco",
			                                   "Aracitaba", "Belmiro Braga", "Bias Fortes", "Bicas",
			                                   "Ch�cara", "Chiador", "Coronel Pacheco", "Descoberto",
			                                   "Ewbank da C�mara", "Goian�", "Guarar�", "Juiz de Fora", 
			                                   "Lima Duarte", "Mar de Espanha", "Marip� de Minas", "Matias Barbosa",
			                                   "Olaria", "Oliveira Fortes", "Paiva", "Pedro Teixeira",
			                                   "Pequeri", "Piau", "Rio Novo", "Rio Preto",
			                                   "Rochedo de Minas", "Santa B�rbara do Monte Verde", "Santa Rita do Ibitipoca", "Santa Rita do Jacutinga",
			                                   "Santana do Deserto", "Santos Dumont", "S�o Jo�o Nepomuceno", "Senador Cortes",
			                                   "Sim�o Pereira", "Al�m Para�ba", "Argirita", "Cataguases",
			                                   "Dona Eus�bia", "Estrela d'Alva", "Itamarati de Minas", "Laranjal",
			                                   "Leopoldina", "Palma", "Pirapetinga", "Recreio",
			                                   "Santana de Cataguases", "Santo Ant�nio do Aventureiro", "Volta Grande"};
	
	public static String obterNomeRegiaoMunicipio(String municipio) {
		String municipioNormalizado = normalizarString(municipio);
				
	    for (String municipioRegiao : NOROESTE) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return "Noroeste de Minas";
	        }
	    }
	    
	    for (String municipioRegiao : NORTE) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return "Norte de Minas";
	        }
	    }
	    
	    for (String municipioRegiao : JEQUITINHONHA) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return "Jequitinhonha";
	        }
	    }
	    
	    for (String municipioRegiao : VALE_MUCURI) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return "Vale do Mucuri";
	        }
	    }
	    
	    for (String municipioRegiao : TRIANGULO_MINEIRO_ALTO_PARANAIBA) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return "Tri�ngulo Mineiro / Alto Parana�ba";
	        }
	    }
	    
	    for (String municipioRegiao : CENTRAL_MINEIRA) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return "Central Mineira";
	        }
	    }
	    
	    for (String municipioRegiao : METROPOLITANA_BELO_HORIZONTE) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return "Metropolitana de Belo Horizonte";
	        }
	    }
	    
	    for (String municipioRegiao : VALE_RIO_DOCE) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return "Vale do Rio Doce";
	        }
	    }
	    
	    for (String municipioRegiao : OESTE) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return "Oeste de Minas";
	        }
	    }
	    
	    for (String municipioRegiao : SUL_SUDOESTE) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return "Sul / Sudoeste de Minas";
	        }
	    }
	    
	    for (String municipioRegiao : CAMPO_VERTENTES) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return "Campo das Vertentes";
	        }
	    }
	    
	    for (String municipioRegiao : ZONA_MATA) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return "Zona da Mata";
	        }
	    }
	    
	    
	    return null;
	}
	
	public static String[] obterRegiaoMunicipio(String municipio) {
		String municipioNormalizado = normalizarString(municipio);
		
	    for (String municipioRegiao : NOROESTE) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return NOROESTE;
	        }
	    }
	    
	    for (String municipioRegiao : NORTE) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return NORTE;
	        }
	    }
	    
	    for (String municipioRegiao : JEQUITINHONHA) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return JEQUITINHONHA;
	        }
	    }
	    
	    for (String municipioRegiao : VALE_MUCURI) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return VALE_MUCURI;
	        }
	    }
	    
	    for (String municipioRegiao : TRIANGULO_MINEIRO_ALTO_PARANAIBA) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return TRIANGULO_MINEIRO_ALTO_PARANAIBA;
	        }
	    }
	    
	    for (String municipioRegiao : CENTRAL_MINEIRA) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return CENTRAL_MINEIRA;
	        }
	    }
	    
	    for (String municipioRegiao : METROPOLITANA_BELO_HORIZONTE) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return METROPOLITANA_BELO_HORIZONTE;
	        }
	    }
	    
	    for (String municipioRegiao : VALE_RIO_DOCE) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return VALE_RIO_DOCE;
	        }
	    }
	    
	    for (String municipioRegiao : OESTE) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return OESTE;
	        }
	    }
	    
	    for (String municipioRegiao : SUL_SUDOESTE) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return SUL_SUDOESTE;
	        }
	    }
	    
	    for (String municipioRegiao : CAMPO_VERTENTES) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return CAMPO_VERTENTES;
	        }
	    }
	    
	    for (String municipioRegiao : ZONA_MATA) {
	    	String municipioRegiaoNormalizado = normalizarString(municipioRegiao);
	        
	    	if (municipioNormalizado.equals(municipioRegiaoNormalizado)) {
	            return ZONA_MATA;
	        }
	    }
	    
	    return null;
	}

}
