package modelo;

import static app.util.StringUtil.normalizarString;

public class RegioesAdministrativas {
	
	
	private static final String[] NOROESTE = {"Arinos", "Bonfinópolis de Minas", "Buritis", "Cabeceira Grande",
			                                  "Dom Bosco", "Formoso", "Natalândia", "Unaí",
			                                  "Uruana de Minas", "Brasilândia de Minas", "Guarda Mor", "João Pinheiro",
			                                  "João Pinheiro", "Lagoa Grande", "Paracatu", "Presidente Olegário",
			                                  "São Gonçalo do Abaeté", "Varjão de Minas", "Vazante"};
	
	private static final String[] NORTE = {"Bonito de Minas", "Chapada Gaúcha", "Cônego Marinho", "Icaraí de Minas",
			                               "Itacarambi", "Januária", "Juvenília", "Manga",
			                               "Matias Cardoso", "Miravânia", "Montalvânia", "Pedras de Maria da Cruz",
			                               "Pintópolis", "São Francisco", "São João das Missões", "Urucuia",
			                               "Catuti", "Espinosa", "Gameleiras", "Jaíba",
			                               "Janaúba", "Mamonas", "Mato Verde", "Monte Azul",
			                               "Nova Porteirinha", "Pai Pedro", "Porteirinha", "Riacho dos Machados",
			                               "Serranópolis de Minas", "Águas Vermelhas", "Berizal",
			                               "Curral de Dentro", "Divisa Alegre", "Fruta de Leite", "Indaiabira",
			                               "Montezuma", "Ninheira", "Novorizonte", "Rio Pardo de Minas",
			                               "Rubelita", "Salinas", "Santa Cruz de Salinas", "Santo Antônio do Retiro",
			                               "São João do Paraíso", "Taiobeiras", "Vargem Grande do Rio Pardo", "Buritizeiro",
			                               "Ibiaí", "Jequitaí", "Lagoa dos Patos", "Lassance",
			                               "Pirapora", "Riachinho", "Santa Fé de Minas", "São Romão",
			                               "Várzea da Palma", "Brasília de Minas", "Campo Azul", "Capitão Enéias",
			                               "Claro dos Poções", "Coração de Jesus", "Francisco Sá", "Glaucilândia",
			                               "Ibiracatu", "Japonvar", "Juramento", "Lontra",
			                               "Luislândia", "Mirabela", "Montes Claros", "Patis",
			                               "Ponto Chique", "São João da Lagoa", "São João da Ponte", "São João do Pacuí",
			                               "Ubaí", "Varzelândia", "Verdelândia", "Botumirim",
			                               "Cristália", "Grão Mogol", "Itacambira", "Josenópolis",
			                               "Padre Carvalho", "Bocaiúva", "Engenheiro Navarro", "Francisco Dumont",
			                               "Guaraciama", "Olhos d'Água"};
	

	private static final String[] JEQUITINHONHA = {"Couto de Magalhães de Minas", "Datas", "Diamantina", "Felício dos Santos",
			                                       "Gouveia", "Presidente Kubitschek", "São Gonçalo do Rio Preto", "Senador Modestino Gonçalves",
			                                       "Angelândia", "Aricanduva", "Berilo", "Capelinha",
			                                       "Carbonita", "Chapada do Norte", "Francisco Badaró", "Itamarandiba",
			                                       "Jenipapo de Minas", "José Gonçalves de Minas", "Leme do Prado", "Minas Novas",
			                                       "Turmalina", "Veredinha", "Araçuaí", "Caraí",
			                                       "Coronel Murta", "Itinga", "Novo Cruzeiro", "Padre Paraíso",
			                                       "Ponto dos Volantes", "Virgem da Lapa", "Cachoeira de Pajeú", "Comercinho",
			                                       "Itaobim", "Medina", "Pedra Azul", "Almenara",
			                                       "Bandeira", "Divisópolis", "Felisburgo", "Jacinto",
			                                       "Jequitinhonha", "Joaíma", "Jordânia", "Mata Verde",
			                                       "Monte Formoso", "Palmópolis", "Rio do Prado", "Rubim",
			                                       "Salto da Divisa", "Santa Maria do Salto", "Santo Antônio do Jacinto"};
	
	private static final String[] VALE_MUCURI = {"Ataléia", "Catuji", "Franciscópolis", "Frei Gaspar", 
												 "Itaipé", "Ladainha", "Malacacheta", "Novo Oriente de Minas", 
												 "Ouro Verde de Minas", "Pavão", "Poté", "Setubinha", "Teófilo Otôni",
									             "Águas Formosas", "Bertópolis", "Carlos Chagas", "Crisólita",
									             "Fronteira dos Vales", "Maxacalis", "Nanuque", "Santa Helena de Minas",
									             "Serra dos Aimorés", "Umburatiba", ""};
	
	
	private static final String[] TRIANGULO_MINEIRO_ALTO_PARANAIBA = {"Cachoeira Dourada", "Capinópolis", "Gurinhatã", "Ipiaçu",
			                                                          "Ituiutaba", "Santa Vitória", "Araguari", "Araporã",
			                                                          "Canápolis", "Cascalho Rico", "Centralina", "Indianópolis",
			                                                          "Monte Alegre de Minas", "Prata", "Tupaciguara", "Uberlândia",
			                                                          "Abadia dos Dourados", "Coromandel", "Cruzeiro da Fortaleza", "Douradoquara",
			                                                          "Estrela do Sul", "Grupiara", "Iraí de Minas", "Monte Carmelo",
			                                                          "Patrocínio", "Romaria", "Serra do Salitre", "Arapuá",
			                                                          "Carmo do Paranaíba", "Guimarânia", "Lagoa Formosa", "Matutina",
			                                                          "Patos de Minas", "Rio Paranaíba", "Santa Rosa da Serra", "São Gotardo",
			                                                          "Tiros", "Campina Verde", "Carneirinho", "Comendador Gomes",
			                                                          "Fronteira", "Frutal", "Itapajipe", "Iturama",
			                                                          "Limeira do Oeste", "Limeira do Oeste", "Planura", "São Francisco de Sales",
			                                                          "União de Minas", "Água Comprida", "Campo Florido", "Conceição das Alagoas",
			                                                          "Conquista", "Delta", "Uberaba", "Veríssimo",
			                                                          "Araxá", "Campos Altos", "Ibiá", "Nova Ponte",
			                                                          "Pedrinópolis", "Perdizes", "Pratinha", "Sacramento",
			                                                          "Santa Juliana", "Tapira"};
	
	
	private static final String[] CENTRAL_MINEIRA = {"Abaeté", "Biquinhas", "Cedro do Abaeté", "Morada Nova de Minas",
			                                         "Paineiras", "Pompéu", "Três Marias", "Augusto de Lima",
			                                         "Buenópolis", "Corinto", "Curvelo", "Felixlândia",
			                                         "Inimutaba", "Joaquim Felício", "Monjolos", "Morro da Garça",
			                                         "Presidente Juscelino", "Santo Hipólito", "Araújos", "Bom Despacho",
			                                         "Dores do Indaiá" , "Estrela do Indaiá", "Japaraíba", "Lagoa da Prata",
			                                         "Leandro Ferreira", "Luz", "Martinho Campos", "Moema",
			                                         "Quartel Geral", "Serra da Saudade"};
	
	private static final String[] METROPOLITANA_BELO_HORIZONTE = {"Araçaí", "Baldim", "Cachoeira da Prata", "Caetanópolis", 
			                                                      "Capim Branco", "Cordisburgo", "Fortuna de Minas", "Funilândia",
			                                                      "Inhaúma", "Jabuticatubas", "Jequitibá", "Maravilhas",
			                                                      "Matozinhos", "Papagaios", "Paraopeba", "Pequi",
			                                                      "Prudente de Morais", "Santana de Pirapama", "Santana do Riacho", "Sete Lagoas",
			                                                      "Alvorada de Minas", "Conceição do Mato Dentro", "Congonhas do Norte", "Dom Joaquim",
			                                                      "Itambé do Mato Dentro", "Morro do Pilar", "Passabém", "Rio Vermelho",
			                                                      "Santo Antônio do Itambé", "Santo Antônio do Rio Abaixo", "São Sebastião do Rio Preto", "Serra Azul de Minas",
			                                                      "Serro", "Florestal", "Onça de Pitangui", "Pará de Minas", "Pitangui",
			                                                      "São José da Varginha", "Belo Horizonte", "Betim", "Brumadinho",
			                                                      "Caeté", "Confins", "Contagem", "Esmeraldas",
			                                                      "Ibirité", "Igarapé", "Juatuba", "Lagoa Santa",
			                                                      "Mário Campos", "Mateus Leme", "Nova Lima", "Pedro Leopoldo",
			                                                      "Raposos", "Ribeirão das Neves", "Rio Acima", "Sabará",
			                                                      "Santa Luzia", "São Joaquim de Bicas", "São José da Lapa", "Sarzedo",
			                                                      "Vespasiano", "Alvinópolis", "Barão de Cocais", "Bela Vista de Minas",
			                                                      "Bom Jesus do Amparo", "Catas Altas", "Dionísio", "Ferros",
			                                                      "Itabira", "João Monlevade", "Nova Era", "Nova União", 
			                                                      "Rio Piracicaba", "Santa Bárbara", "Santa Maria de Itabira", "São Domingos do Prata",
			                                                      "São Gonçalo do Rio Abaixo", "São José do Goiabal", "Taquaraçu de Minas", "Belo Vale",
			                                                      "Bonfim", "Crucilândia", "Itaguara", "Itatiaiuçu", "Jeceaba",
			                                                      "Moeda", "Piedade dos Gerais", "Rio Manso", "Diogo de Vasconcelos",
			                                                      "Itabirito", "Mariana", "Ouro Preto", "Casa Grande",
			                                                      "Catas Altas da Noruega", "Congonhas", "Conselheiro Lafaiete", "Cristiano Otôni",
			                                                      "Desterro de Entre Rios", "Entre Rios de Minas", "Itaverava", "Ouro Branco",
			                                                      "Queluzito", "Santana dos Montes", "São Brás do Suaçuí"};
	
	private static final String[] VALE_RIO_DOCE = {"Braúnas", "Carmésia", "Coluna", "Divinolândia de Minas",
			                                       "Dores de Guanhães", "Gonzaga", "Guanhães", "Materlândia",
			                                       "Paulistas", "Sabinópolis", "Santa Efigênia de Minas", "São João Evangelista", 
			                                       "Sardoá", "Senhora do Porto", "Virginópolis", "Água Boa",
			                                       "Cantagalo", "Frei Lagonegro", "José Raydan", "Peçanha",
			                                       "Santa Maria do Suaçuí", "São José do Jacuri", "São Pedro do Suaçuí", "São Sebastião do Maranhão",
			                                       "Alpercata", "Campanário", "Capitão Andrade", "Coroaci",
			                                       "Divino das Laranjeiras", "Engenheiro Caldas", "Fernandes Tourinho", "Frei Inocêncio",
			                                       "Galiléia", "Governador Valadares", "Itambacuri", "Itanhomi",
			                                       "Jampruca", "Marilac", "Matias Lobato", "Nacip Raydan",
			                                       "Nova Módica", "Pescador", "São Geraldo da Piedade", "São Geraldo do Baixio", 
			                                       "São José da Safira", "São José do Divino", "Sobrália", "Tumiritinga",
			                                       "Virgolândia", "Central de Minas", "Itabirinha de Mantena", "Mantena",
			                                       "Mendes Pimentel", "Nova Belém", "São Félix de Minas", "São João do Manteninha",
			                                       "Açucena", "Antônio Dias", "Belo Oriente", "Coronel Fabriciano",
			                                       "Ipatinga", "Jaguaraçu", "Joanésia", "Marliéria",
			                                       "Mesquita", "Naque", "Periquito", "Santana do Paraíso",
			                                       "Timóteo", "Bom Jesus do Galho", "Bugre", "Caratinga",
			                                       "Córrego Novo", "Dom Cavati", "Entre Folhas", "Iapu",
			                                       "Imbé de Minas", "Inhapim", "Ipaba", "Piedade de Caratinga",
			                                       "Pingo d'Água", "Santa Rita de Minas", "São Domingos das Dores", "São João do Oriente",
			                                       "São Sebastião do Anta", "Tarumirim", "Ubaporanga", "Vargem Alegre",
			                                       "Aimorés", "Alvarenga", "Conceição de Ipanema", "Conselheiro Pena",
			                                       "Cuparaque", "Goiabeira", "Ipanema", "Itueta",
			                                       "Mutum", "Pocrane", "Resplendor", "Santa Rita do Itueto", "Taparuba"};
	
	private static final String[] OESTE = {"Bambuí", "Córrego Danta", "Doresópolis", "Iguatama",
			                               "Medeiros", "Pium-í", "São Roque de Minas", "Tapiraí",
			                               "Vargem Bonita", "Carmo do Cajuru", "Cláudio", "Conceição do Pará",
			                               "Divinópolis", "Igaratinga", "Itaúna", "Nova Serrana",
			                               "Perdigão", "Santo Antônio do Monte", "São Gonçalo do Pará", "São Sebastião do Oeste",
			                               "Arcos", "Camacho", "Córrego Fundo", "Formiga",
			                               "Itapecerica", "Pains", "Pedra do Indaiá", "Pimenta",
			                               "Aguanil", "Campo Belo", "Cana Verde", "Candeias",
			                               "Cristais", "Perdões", "Santana do Jacaré", "Bom Sucesso",
			                               "Carmo da Mata", "Carmópolis de Minas", "Ibituruna", "Oliveira",
			                               "Passa Tempo", "Piracema", "Santo Antônio do Amparo", "São Francisco de Paula"};
	
	private static final String[] SUL_SUDOESTE = {"Alpinópolis", "Bom Jesus da Penha", "Capetinga", "Capitólio",
			                                      "Cássia", "Claraval", "Delfinópolis", "Fortaleza de Minas",
			                                      "Ibiraci", "Itaú de Minas", "Passos", "Pratápolis",
			                                      "São João Batista do Glória", "São José da Barra", "Arceburgo", "Cabo Verde",
			                                      "Guaranésia", "Guaxupé", "Itamoji", "Jacuí",
			                                      "Juruaia", "Monte Belo", "Monte Santo de Minas", "Muzambinho",
			                                      "Nova Resende", "São Pedro da União", "São Sebastião do Paraíso", "São Tomás de Aquino",
			                                      "Alfenas", "Alterosa", "Areado", "Carmo do Rio Claro",
			                                      "Carvalhópolis", "Conceição da Aparecida", "Divisa Nova", "Fama",
			                                      "Machado", "Paraguaçu", "Poço Fundo", "Serrania",
			                                      "Boa Esperança", "Campanha", "Campo do Meio", "Campos Gerais",
			                                      "Carmo da Cachoeira", "Coqueiral", "Elói Mendes", "Guapé",
			                                      "Ilicínea", "Monsenhor Paulo", "Santana da Vargem", "São Bento Abade",
			                                      "São Tomé das Letras", "Três Corações", "Três Pontas", "Varginha",
			                                      "Albertina", "Andradas", "Bandeira do Sul", "Botelhos",
			                                      "Caldas", "Campestre", "Ibitiúra de Minas", "Inconfidentes",
			                                      "Jacutinga", "Monte Sião", "Ouro Fino", "Poços de Caldas",
			                                      "Santa Rita de Caldas", "Bom Repouso", "Borda da Mata", "Bueno Brandão",
			                                      "Camanducaia", "Cambuí", "Congonhal", "Córrego do Bom Jesus",
			                                      "Espírito Santo do Dourado", "Estiva", "Extrema", "Gonçalves", 
			                                      "Ipuiúna", "Itapeva", "Munhoz", "Pouso Alegre", 
			                                      "Sapucaí Mirim", "Senador Amaral", "Senador José Bento", "Tocos do Moji",
			                                      "Toledo", "Cachoeira de Minas", "Careaçu", "Conceição das Pedras", 
			                                      "Conceição dos Ouros", "Cordislândia", "Heliodora", "Natércia", 
			                                      "Pedralva", "Santa Rita do Sapucaí", "São Gonçalo do Sapucaí", "São João da Mata",
			                                      "São José do Alegre", "São Sebastião da Bela Vista", "Silvianópolis", "Turvolândia",
			                                      "Alagoa", "Baependi", "Cambuquira", "Carmo de Minas",
			                                      "Caxambu", "Conceição do Rio Verde", "Itamonte",
			                                      "Itanhandu", "Jesuânia", "Lambari", "Olímpio Noronha",
			                                      "Passa Quatro", "Pouso Alto", "São Lourenço", "São Sebastião do Rio Verde",
			                                      "Soledade de Minas", "Aiuruoca", "Andrelândia", "Arantina",
			                                      "Bocaina de Minas", "Bom Jardim de Minas", "Carvalhos", "Cruzília",
			                                      "Liberdade", "Minduri", "Passa Vinte", "São Vicente de Minas", "Seritinga",
			                                      "Serranos", "Brasópolis", "Consolação", "Cristina",
			                                      "Delfim Moreira", "Dom Viçoso", "Itajubá", "Maria da Fé", "Marmelópolis",
			                                      "Paraisópolis", "Piranguçu", "Piranguinho", "Venceslau Brás",
			                                      "Virgínia"};
	

	private static final String[] CAMPO_VERTENTES = {"Carrancas", "Ijaci", "Ingaí", "Itumirim",
			                                         "Itutinga", "Lavras", "Luminárias", "Nepomuceno",
			                                         "Ribeirão Vermelho", "Conceição da Barra de Minas", "Coronel Xavier Chaves", "Dores de Campos",
			                                         "Lagoa Dourada", "Madre de Deus de Minas", "Nazareno", "Piedade do Rio Grande",
			                                         "Prados", "Resende Costa", "Ritápolis", "Santa Cruz de Minas",
			                                         "Santana do Garambéu", "São João del Rei", "São Tiago", "Tiradentes",
			                                         "Alfredo Vasconcelos", "Antônio Carlos", "Barbacena", "Barroso",
			                                         "Capela Nova", "Caranaíba", "Carandaí", "Desterro do Melo",
			                                         "Ibertioga", "Ressaquinha", "Santa Bárbara do Tugúrio", "Senhora dos Remédios"};
	
	
	private static final String[] ZONA_MATA = {"Acaiaca", "Barra Longa", "Dom Silvério", "Guaraciaba",
			                                   "Jequeri", "Oratórios", "Piedade de Ponte Nova", "Ponte Nova",
			                                   "Raul Soares", "Rio Casca", "Rio Doce", "Santa Cruz do Escalvado",
			                                   "Santo Antônio do Grama", "São Pedro dos Ferros", "Sem Peixe", "Sericita",
			                                   "Urucânia", "Vermelho Novo", "Abre Campo", "Alto Caparaó",
			                                   "Alto Jequitibá", "Caparaó", "Caputira", "Chalé",
			                                   "Durandé", "Lajinha", "Luisburgo", "Manhuaçu",
			                                   "Manhumirim", "Martins Soares", "Matipó", "Pedra Bonita",
			                                   "Reduto", "Santa Bárbara do Leste", "Santa Margarida", "Santana do Manhuaçu",
			                                   "São João do Manhuaçu", "São José do Mantimento", "Simonésia", "Alto Rio Doce",
			                                   "Amparo da Serra", "Araponga", "Brás Pires", "Cajuri",
			                                   "Canaã", "Cipotânea", "Coimbra", "Ervália",
			                                   "Lamim", "Paula Cândido", "Pedra do Anta", "Piranga",
			                                   "Porto Firme", "Presidente Bernardes", "Rio Espera", "São Miguel do Anta",
			                                   "Senhora de Oliveira", "Teixeiras", "Viçosa", "Antônio Prado de Minas",
			                                   "Barão do Monte Alto", "Caiana", "Carangola", "Divino",
			                                   "Espera Feliz", "Eugenópolis", "Faria Lemos", "Fervedouro",
			                                   "Miradouro", "Miraí", "Muriaé", "Orizânia",
			                                   "Patrocínio do Muriaé", "Pedra Dourada", "Rosário da Limeira", "São Francisco do Glória",
			                                   "São Sebastião da Vargem Alegre", "Tombos", "Vieiras", "Astolfo Dutra",
			                                   "Divinésia", "Dores do Turvo", "Guarani", "Guidoval",
			                                   "Guiricema", "Mercês", "Piraúba", "Rio Pomba",
			                                   "Rodeiro", "São Geraldo", "Senador Firmino", "Silveirânia",
			                                   "Tabuleiro", "Tocantins", "Ubá", "Visconde do Rio Branco",
			                                   "Aracitaba", "Belmiro Braga", "Bias Fortes", "Bicas",
			                                   "Chácara", "Chiador", "Coronel Pacheco", "Descoberto",
			                                   "Ewbank da Câmara", "Goianá", "Guarará", "Juiz de Fora", 
			                                   "Lima Duarte", "Mar de Espanha", "Maripá de Minas", "Matias Barbosa",
			                                   "Olaria", "Oliveira Fortes", "Paiva", "Pedro Teixeira",
			                                   "Pequeri", "Piau", "Rio Novo", "Rio Preto",
			                                   "Rochedo de Minas", "Santa Bárbara do Monte Verde", "Santa Rita do Ibitipoca", "Santa Rita do Jacutinga",
			                                   "Santana do Deserto", "Santos Dumont", "São João Nepomuceno", "Senador Cortes",
			                                   "Simão Pereira", "Além Paraíba", "Argirita", "Cataguases",
			                                   "Dona Eusébia", "Estrela d'Alva", "Itamarati de Minas", "Laranjal",
			                                   "Leopoldina", "Palma", "Pirapetinga", "Recreio",
			                                   "Santana de Cataguases", "Santo Antônio do Aventureiro", "Volta Grande"};
	
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
	            return "Triângulo Mineiro / Alto Paranaíba";
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
