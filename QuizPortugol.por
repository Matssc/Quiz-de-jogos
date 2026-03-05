programa
{
	// Incluindo as bibliotecas
	inclua biblioteca Texto
	inclua biblioteca Util

	// --- VARIÁVEIS GLOBAIS PARA O RANKING ---
	const inteiro TAMANHO_RANKING = 10
	cadeia nomes_ranking[TAMANHO_RANKING]
	inteiro pontuacao_ranking[TAMANHO_RANKING]
	inteiro total_no_ranking = 0

	// Função para inicializar o ranking (zerar os vetores)
	funcao vazio inicializar_ranking() {
		para (inteiro i = 0; i < TAMANHO_RANKING; i++) {
			nomes_ranking[i] = ""
			pontuacao_ranking[i] = 0
		}
		total_no_ranking = 0
	}


	// --- FUNÇÕES DO QUIZ  ---

	funcao cadeia nome() {
		cadeia nome_usuario 
		logico nome_valido = falso 

		escreva("👾    Bem Vindo ao QUIZ de Jogos!!!   👾\n") 
		
		faca {
			escreva("Informe o seu nome : ")
			leia(nome_usuario)

			nome_valido = verdadeiro 
			logico contem_invalido = falso 

      // 1. Validação de nome vazio
			se (nome_usuario == "") {
				escreva("Nome inválido! Digite apenas letras.\n")
				nome_valido = falso
			} senao {
        // 2. Validação de números e símbolos e espaços em branco.
				inteiro i
				para (i = 0; i < Texto.numero_caracteres(nome_usuario); i = i + 1) {
					caracter c = Texto.obter_caracter(nome_usuario, i)
					logico e_letra = (c >= 'a' e c <= 'z') ou (c >= 'A' e c <= 'Z')
					logico e_espaco = (c == ' ')
					
					se (nao e_letra) { 
						contem_invalido = verdadeiro
						pare 
					}
				}
				se (contem_invalido) {
					escreva("Nome inválido! Digite apenas letras.\n")
					nome_valido = falso
				}
			}
			
		} enquanto (nao nome_valido) 

		escreva("Olá ", nome_usuario, ", seja bem vindo, iremos iniciar o quiz!\n")
		retorne nome_usuario
	}

	/**
	 * Este método exibe as perguntas de TERROR
	 */
	funcao inteiro terror() { 
		const inteiro NUM_PERGUNTAS = 5
		cadeia questoes[NUM_PERGUNTAS]
		cadeia opcoes[NUM_PERGUNTAS][4]
		cadeia respostas_corretas[NUM_PERGUNTAS]
		logico ja_foi_perguntada[NUM_PERGUNTAS]

		inteiro contador = 0
		cadeia resposta_usuario
		logico resposta_valida 
		
		escreva("\n--- CATEGORIA: TERROR ---\n")

		// Pergunta 0
		questoes[0] = "No jogo Resident Evil 2, qual é o nome da cidade que o jogo se passa?"
		opcoes[0][0] = "(a) Kijuju"
		opcoes[0][1] = "(b) Lanshiang"
		opcoes[0][2] = "(c) Raccoon City"
		opcoes[0][3] = "(d) Tall Oaks"
		respostas_corretas[0] = "C"

		// Pergunta 1
		questoes[1] = "Em Silent Hill 2 James vai para Silent Hill após receber uma carta de sua mulher morta chamada?"
		opcoes[1][0] = "(a) Maria"
		opcoes[1][1] = "(b) Mary"
		opcoes[1][2] = "(c) Angela"
		opcoes[1][3] = "(d) Eloisa"
		respostas_corretas[1] = "B"
		
		// Pergunta 2
		questoes[2] = "Nos jogos de Outlast qual é a principal ferramenta que o protagonista usa?"
		opcoes[2][0] = "(a) Celular"
		opcoes[2][1] = "(b) Diário"
		opcoes[2][2] = "(c) Bateria"
		opcoes[2][3] = "(d) Filmadora"
		respostas_corretas[2] = "D"

		// Pergunta 3
		questoes[3] = "Qual é o nome do primeiro manuscrito que encontramos em Alan Wake?"
		opcoes[3][0] = "(a) Partida"
		opcoes[3][1] = "(b) Retorno"
		opcoes[3][2] = "(c) Iniciação"
		opcoes[3][3] = "(d) Verdade"
		respostas_corretas[3] = "A"

		// Pergunta 4
		questoes[4] = "Em The Evil Within qual é o nome do principal vilão do jogo?"
		opcoes[4][0] = "(a) Sebastian Castellanos"
		opcoes[4][1] = "(b) Ruvik"
		opcoes[4][2] = "(c) Marcelo Jimenez"
		opcoes[4][3] = "(d) Leslie Withers"
		respostas_corretas[4] = "B"

		// Inicializa o controle
		para (inteiro i = 0; i < NUM_PERGUNTAS; i++) {
			ja_foi_perguntada[i] = falso
		}

		// --- Loop Principal da Categoria (Aleatório) ---
		para (inteiro i = 0; i < NUM_PERGUNTAS; i++) {
			inteiro indice_aleatorio
			
			faca {
				indice_aleatorio = Util.sorteia(0, NUM_PERGUNTAS - 1)
			} enquanto (ja_foi_perguntada[indice_aleatorio] == verdadeiro)

			ja_foi_perguntada[indice_aleatorio] = verdadeiro 

			escreva("\nPergunta " + (i + 1) + "/5: " + questoes[indice_aleatorio] + "\n")
			para (inteiro j = 0; j < 4; j++) {
				escreva(opcoes[indice_aleatorio][j] + "\n")
			}

			resposta_valida = falso
			faca {
				escreva("Escolha sua resposta: ")
				leia(resposta_usuario)
				resposta_usuario = Texto.caixa_alta(resposta_usuario)
				se (resposta_usuario == "A" ou resposta_usuario == "B" ou resposta_usuario == "C" ou resposta_usuario == "D") {
					resposta_valida = verdadeiro
				} senao {
					escreva("Alternativa inválida!!! Tente novamente.\n")
				}
			} enquanto (nao resposta_valida)

			se (resposta_usuario == respostas_corretas[indice_aleatorio]) {
				escreva("✅ Resposta correta!\n")
				contador = contador + 1
			} senao {
				escreva("❌ Resposta errada! O correto era: " + respostas_corretas[indice_aleatorio] + "\n")
			}
		}

		escreva("Você acertou ", contador, "/5 perguntas!!!\n") 
		retorne contador 
	}

	/**
	 * Este método exibe as perguntas de AÇÃO E AVENTURA
	 */
	funcao inteiro acao() { 
		const inteiro NUM_PERGUNTAS = 5
		cadeia questoes[NUM_PERGUNTAS]
		cadeia opcoes[NUM_PERGUNTAS][4]
		cadeia respostas_corretas[NUM_PERGUNTAS]
		logico ja_foi_perguntada[NUM_PERGUNTAS]

		inteiro contador = 0
		cadeia resposta_usuario
		logico resposta_valida 
		
		escreva("\n--- CATEGORIA: AÇÃO E AVENTURA ---\n")

		// Pergunta 0
		questoes[0] = "No jogo God of War Ragnarök, qual é o objetivo de Kratos?"
		opcoes[0][0] = "(a) Destruir o Olimpo"
		opcoes[0][1] = "(b) Encontrar Pandora"
		opcoes[0][2] = "(c) Matar Zeus"
		opcoes[0][3] = "(d) Impedir o Ragnarök"
		respostas_corretas[0] = "D"

		// Pergunta 1
		questoes[1] = "Em Tomb Raider(2013) qual é o nome da ilha que Lara Croft fica presa?"
		opcoes[1][0] = "(a) Yamatai"
		opcoes[1][1] = "(b) Xian"
		opcoes[1][2] = "(c) Kuru"
		opcoes[1][3] = "(d) Mabubu"
		respostas_corretas[1] = "A"
		
		// Pergunta 2
		questoes[2] = "Nos jogos da série Arkham do Batman qual é o vilão que aparece nos 3 jogos?"
		opcoes[2][0] = "(a) Mulher Gato"
		opcoes[2][1] = "(b) Coringa"
		opcoes[2][2] = "(c) Dr.Pyg"
		opcoes[2][3] = "(d) Pinguim"
		respostas_corretas[2] = "B"

		// Pergunta 3
		questoes[3] = "Em The Last of Us™ Part I qual é o principal personagem que a gente controla?"
		opcoes[3][0] = "(a) Ellie"
		opcoes[3][1] = "(b) Tommy"
		opcoes[3][2] = "(c) Joel"
		opcoes[3][3] = "(d) Abby"
		respostas_corretas[3] = "C"

		// Pergunta 4
		questoes[4] = "Qual doença Arthur Morgan contrai durante a história de Red Dead Redemption 2?"
		opcoes[4][0] = "(a) Tuberculose"
		opcoes[4][1] = "(b) Malária"
		opcoes[4][2] = "(c) Febre tifóide"
		opcoes[4][3] = "(d) Peste"
		respostas_corretas[4] = "A"

		// Inicializa o controle
		para (inteiro i = 0; i < NUM_PERGUNTAS; i++) {
			ja_foi_perguntada[i] = falso
		}

		// --- Loop Principal da Categoria (Aleatório) ---
		para (inteiro i = 0; i < NUM_PERGUNTAS; i++) {
			inteiro indice_aleatorio
			
			faca {
				indice_aleatorio = Util.sorteia(0, NUM_PERGUNTAS - 1)
			} enquanto (ja_foi_perguntada[indice_aleatorio] == verdadeiro)

			ja_foi_perguntada[indice_aleatorio] = verdadeiro 

			escreva("\nPergunta " + (i + 1) + "/5: " + questoes[indice_aleatorio] + "\n")
			para (inteiro j = 0; j < 4; j++) {
				escreva(opcoes[indice_aleatorio][j] + "\n")
			}

			resposta_valida = falso
			faca {
				escreva("Escolha sua resposta: ")
				leia(resposta_usuario)
				resposta_usuario = Texto.caixa_alta(resposta_usuario)
				se (resposta_usuario == "A" ou resposta_usuario == "B" ou resposta_usuario == "C" ou resposta_usuario == "D") {
					resposta_valida = verdadeiro
				} senao {
					escreva("Alternativa inválida!!! Tente novamente.\n")
				}
			} enquanto (nao resposta_valida)

			se (resposta_usuario == respostas_corretas[indice_aleatorio]) {
				escreva("✅ Resposta correta!\n")
				contador = contador + 1
			} senao {
				escreva("❌ Resposta errada! O correto era: " + respostas_corretas[indice_aleatorio] + "\n")
			}
		}

		escreva("Você acertou ", contador, "/5 perguntas!!!\n")
		retorne contador 
	}

	/**
	 * Este método exibe as perguntas de RPG
	 */
	funcao inteiro rpg() { 
		const inteiro NUM_PERGUNTAS = 5
		cadeia questoes[NUM_PERGUNTAS]
		cadeia opcoes[NUM_PERGUNTAS][4]
		cadeia respostas_corretas[NUM_PERGUNTAS]
		logico ja_foi_perguntada[NUM_PERGUNTAS]

		inteiro contador = 0
		cadeia resposta_usuario
		logico resposta_valida 
		
		escreva("\n--- CATEGORIA: RPG ---\n")

		// Pergunta 0
		questoes[0] = "Em Dark Souls, para que são usadas as “Almas” (Souls)?"
		opcoes[0][0] = "(a) Abrir portais secretos"
		opcoes[0][1] = "(b) Comprar e melhorar equipamentos e atributos"
		opcoes[0][2] = "(c) Reviver personagens mortos"
		opcoes[0][3] = "(d) Invocar outros jogadores"
		respostas_corretas[0] = "B"

		// Pergunta 1
		questoes[1] = "No universo de Clair Obscur: Expedition 33, quem ou o que é a “Artífice”?"
		opcoes[1][0] = "(a) Uma deusa misteriosa que desperta a cada ano para apagar um grupo de humanos do mundo."
		opcoes[1][1] = "(b) A líder dos exploradores que guia a Expedição 33 em busca de uma nova terra."
		opcoes[1][2] = "(c) A feiticeira que controla o clima e as estações."
		opcoes[1][3] = "(d) Uma guerreira lendária que tenta destruir o ciclo de renascimento."
		respostas_corretas[1] = "A"
		
		// Pergunta 2
		questoes[2] = "No jogo The Witcher 3: Wild Hunt, qual é o nome do protagonista?"
		opcoes[2][0] = "(a) Ezio Auditore"
		opcoes[2][1] = "(b) Arthur Morgan"
		opcoes[2][2] = "(c) Kratos"
		opcoes[2][3] = "(d) Geralt de Rívia"
		respostas_corretas[2] = "D"

		// Pergunta 3
		questoes[3] = "Em Final Fantasy VII, qual é o nome da grande corporação responsável por explorar a energia Mako?"
		opcoes[3][0] = "(a) Avalanche"
		opcoes[3][1] = "(b) Midgar Corp"
		opcoes[3][2] = "(c) Shinra"
		opcoes[3][3] = "(d) ReactorX"
		respostas_corretas[3] = "C"

		// Pergunta 4
		questoes[4] = "Em Elden Ring qual personagem ajuda o jogador a canalizar runas e subir de nível durante a jornada?"
		opcoes[4][0] = "(a) Malenia"
		opcoes[4][1] = "(b) Ranni"
		opcoes[4][2] = "(c) Renala"
		opcoes[4][3] = "(d) Melina"
		respostas_corretas[4] = "D"

		// Inicializa o controle
		para (inteiro i = 0; i < NUM_PERGUNTAS; i++) {
			ja_foi_perguntada[i] = falso
		}

		// --- Loop Principal da Categoria (Aleatório) ---
		para (inteiro i = 0; i < NUM_PERGUNTAS; i++) {
			inteiro indice_aleatorio
			
			faca {
				indice_aleatorio = Util.sorteia(0, NUM_PERGUNTAS - 1)
			} enquanto (ja_foi_perguntada[indice_aleatorio] == verdadeiro)

			ja_foi_perguntada[indice_aleatorio] = verdadeiro 

			escreva("\nPergunta " + (i + 1) + "/5: " + questoes[indice_aleatorio] + "\n")
			para (inteiro j = 0; j < 4; j++) {
				escreva(opcoes[indice_aleatorio][j] + "\n")
			}

			resposta_valida = falso
			faca {
				escreva("Escolha sua resposta: ")
				leia(resposta_usuario)
				resposta_usuario = Texto.caixa_alta(resposta_usuario)
				se (resposta_usuario == "A" ou resposta_usuario == "B" ou resposta_usuario == "C" ou resposta_usuario == "D") {
					resposta_valida = verdadeiro
				} senao {
					escreva("Alternativa inválida!!! Tente novamente.\n")
				}
			} enquanto (nao resposta_valida)

			se (resposta_usuario == respostas_corretas[indice_aleatorio]) {
				escreva("✅ Resposta correta!\n")
				contador = contador + 1
			} senao {
				escreva("❌ Resposta errada! O correto era: " + respostas_corretas[indice_aleatorio] + "\n")
			}
		}

		escreva("Você acertou ", contador, "/5 perguntas!!!\n")
		retorne contador 
	}

	/**
	 * Menu de categorias.
	 */
	funcao vazio categorias(cadeia nome_usuario) { 
		cadeia resposta
		inteiro pontuacao_da_partida = 0 

		pontuacao_da_partida = 0 

		escreva("\nDigite o número da categoria de perguntas que desejar responder:\n" + 
				"1 - Terror\n" + 
				"2 - Ação e Aventura\n" + 
				"3 - RPG\n" + 
				"4 - Voltar ao Menu Principal\n")
		escreva("Sua escolha: ")
		leia(resposta)
		
		se (resposta == "1") {
			pontuacao_da_partida = terror() 
		} senao se (resposta == "2") {
			pontuacao_da_partida = acao() 
		} senao se (resposta == "3") {
			pontuacao_da_partida = rpg() 
		} senao se (resposta == "4") {

		} senao {
			escreva("Não temos essa categoria de perguntas!\n")
		}
		
		// Se o jogador jogou (escolheu 1, 2 ou 3), adiciona os pontos ao ranking
		se (resposta == "1" ou resposta == "2" ou resposta == "3") {
			adicionar_ao_ranking(nome_usuario, pontuacao_da_partida)
		}
		

	}

	/**
	 * Adiciona a pontuação da partida ao ranking global
	 */
	funcao vazio adicionar_ao_ranking(cadeia nome_jogador, inteiro pontos_partida) {
    // Converte acertos em pontuação
		inteiro pontuacao_final_partida = pontos_partida * 100

    // Se não fez pontos, não muda o ranking
		se (pontuacao_final_partida == 0) {
			escreva("Você não fez pontos nesta rodada.\n")
			retorne
		}

		inteiro indice_jogador = -1 
    // 1. O jogador já está no ranking?
		para (inteiro i = 0; i < total_no_ranking; i++) {
			se (nomes_ranking[i] == nome_jogador) {
				indice_jogador = i
				pare
			}
		}
    		se (indice_jogador != -1) {
			// 2. Sim, já está. Apenas soma os pontos.
			pontuacao_ranking[indice_jogador] = pontuacao_ranking[indice_jogador] + pontuacao_final_partida
      escreva("💰 Você fez ", pontuacao_final_partida, " pontos nesta rodada!\n")
      escreva("Voltando ao menu principal...\n")

      // 3. Não, é um novo jogador adicionar no raking se ainda tiver espaço
    } senao se (total_no_ranking < TAMANHO_RANKING) {
			nomes_ranking[total_no_ranking] = nome_jogador
			pontuacao_ranking[total_no_ranking] = pontuacao_final_partida
			escreva("💰 Você fez ", pontuacao_final_partida, " pontos nesta rodada!\n")
      escreva("Voltando ao menu principal...\n")
			total_no_ranking = total_no_ranking + 1 
		

		} senao {
			inteiro indice_menor_pontuacao = 0
			inteiro menor_pontuacao = pontuacao_ranking[0]
			
			para(inteiro i = 1; i < TAMANHO_RANKING; i++){
				se(pontuacao_ranking[i] < menor_pontuacao){
					menor_pontuacao = pontuacao_ranking[i]
					indice_menor_pontuacao = i
				}
			}			
    }
  }

	/**
	 * Exibe o ranking ordenado
	 */
	funcao vazio exibirRanking() {
		escreva("\n🏆 === RANKING TOP 10 === 🏆\n")

		se (total_no_ranking == 0) {
			escreva("Ainda não há ninguém no ranking. Jogue para aparecer!\n")
			retorne
		}

		// --- ALGORITMO DE ORDENAÇÃO (Bubble Sort) ---
		para (inteiro i = 0; i < total_no_ranking - 1; i++) {
			para (inteiro j = 0; j < total_no_ranking - i - 1; j++) {
				
				se (pontuacao_ranking[j] < pontuacao_ranking[j+1]) {
					inteiro temp_pontos = pontuacao_ranking[j]
					pontuacao_ranking[j] = pontuacao_ranking[j+1]
					pontuacao_ranking[j+1] = temp_pontos

					cadeia temp_nome = nomes_ranking[j]
					nomes_ranking[j] = nomes_ranking[j+1]
					nomes_ranking[j+1] = temp_nome
				}
			}
		}
		// --- Fim da Ordenação ---

		para (inteiro i = 0; i < total_no_ranking; i++) {
			escreva((i+1), ". ", nomes_ranking[i], " - ", pontuacao_ranking[i], " pontos\n")
		}
	}

	funcao vazio menuCRUD() {
		escreva("\n=== MENU CRUD ===\n")
		escreva("Esta funcionalidade (Criar, Listar, Atualizar, Deletar)\n")
		escreva("requer um banco de dados e não é suportada pelo Portugol Studio.\n")
	}


	// --- PONTO DE ENTRADA PRINCIPAL ---

	funcao inicio()
	{
		inicializar_ranking()

		cadeia opcao
		logico continuar = verdadeiro
		
		faca {
			escreva("\n=== MENU PRINCIPAL ===\n")
			escreva("1 - Jogar Quiz\n")
			escreva("2 - Ver Ranking (Top 10)\n")
			escreva("3 - Gerenciar Perguntas (CRUD)\n")
			escreva("4 - Sair\n")
			escreva("Escolha uma opção: ")
			leia(opcao)

			se (opcao == "1") {
				cadeia nome_jogador = nome()
				categorias(nome_jogador) 
			}
			senao se (opcao == "2") {
				exibirRanking() 
			}
			senao se (opcao == "3") {
				menuCRUD()
			}
			senao se (opcao == "4") {
				escreva("👋 Obrigado por jogar! Até a próxima!\n")
				continuar = falso
			}
			senao {
				escreva("❌ Opção inválida!\n")
			}
			
		} enquanto(continuar)
	}
}