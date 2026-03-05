import java.util.Scanner;
public class Quiz4 {
    static Scanner x = new Scanner(System.in);
    public static void main(String[] args) {
        nome();
        categorias();
    }
    /**
     * Este método pede o nome do usuário,verificar se estar válido e exibir na tela
     */
    public static void nome() {
        String nome;
        System.out.printf("\uD83C\uDFAE   Bem Vindo ao QUIZ de Jogos!!!  \uD83C\uDFAE\n");
        do {
            System.out.println("Informe o seu nome : ");
            nome = x.nextLine();
            if (nome.matches("[A-Za-zÀ-ÖØ-öø-ÿ]+")) {
                break;
            } else {
                System.err.println("Nome inválido! Digite apenas letras.");
                continue;
            }
        } while (true);
        System.out.printf("Olá %s seja bem vindo,iremos iniciar o quiz!\n", nome);
    }
    /**
     * Esse método pede para o usuário escolher a categoria e mostrar a pergutas da categoria escolhida
     */
    public static void categorias() {
        String resposta;
        boolean continuar = true;
        do {
            System.out.println("Digite o número da categoria de perguntas que desejar respoder:\n" + "1 - Terror\n" + "2 - Ação e Aventura\n" + "3 - RPG\n" + "4 - Sair ");
            resposta = x.next();
            switch (resposta) {
                case "1" -> terror();
                case "2" -> acao();
                case "3" -> rpg();
                case "4" -> {
                    System.out.println("👋 Obrigado por jogar! Até a próxima!");
                    continuar = false;
                }
                default -> System.err.println("Não temos essa categoria de perguntas!");
            }
        } while (continuar);
    }

    /**
     * Este método exibe as perguntas na tela e pede para o usuário resposter,depois verificar a respota e exibe na tela se acertou ou não
     */
    public static void terror() {
        String escolhar1, escolhar2, escolhar3, escolhar4, escolhar5, inicio;
        int contador = 0;
        do {
            System.out.println("Primeira Pergunta: No jogo Resident Evil 2, qual é o nome da cidade que o jogo se passar?\n" + "(a) Kijuju\n" + "(b) Lanshiang\n" + "(c) Raccoon City\n" + "(d) Tall Oaks");
            System.out.println("Escolhar sua resposta: ");
            escolhar1 = x.next();
            if (!escolhar1.equalsIgnoreCase("A") &&
                    !escolhar1.equalsIgnoreCase("B") &&
                    !escolhar1.equalsIgnoreCase("C") &&
                    !escolhar1.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            } else if (escolhar1.equalsIgnoreCase("c")) {
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            } else {
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        do {
            System.out.println("Segunda Pergunta: Em Silent Hill 2 James vai para Silent Hill após receber uma carta de sua mulher morta chamada?\n" + "(a) Maria\n" + "(b) Mary\n" + "(c) Angela\n" + "(d) Eloisa");
            System.out.println("Escolhar sua resposta: ");
            escolhar2 = x.next();
            if (!escolhar2.equalsIgnoreCase("A") &&
                    !escolhar2.equalsIgnoreCase("B") &&
                    !escolhar2.equalsIgnoreCase("C") &&
                    !escolhar2.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            } else if (escolhar2.equalsIgnoreCase("b")) {
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            } else {
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        do {
            System.out.println("Terceira Pergunta: Nos jogos de Outlast qual é a principal ferramenta que o protagosnita usar?\n" + "(a) Celular\n" + "(b) Diário\n" + "(c) Bateria\n" + "(d) Filmadora");
            System.out.println("Escolhar sua resposta: ");
            escolhar3 = x.next();
            if (!escolhar3.equalsIgnoreCase("A") &&
                    !escolhar3.equalsIgnoreCase("B") &&
                    !escolhar3.equalsIgnoreCase("C") &&
                    !escolhar3.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            } else if (escolhar3.equalsIgnoreCase("d")) {
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            } else {
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        do {
            System.out.println("Quarta Pergunta: Qual é o nome do primeiro manuscrito que encotramos em Alan Wake?\n" + "(a) Partida\n" + "(b) Retorno\n" + "(c) Iniciação.\n" + "(d) Verdade");
            System.out.println("Escolhar sua resposta: ");
            escolhar4 = x.next();
            if (!escolhar4.equalsIgnoreCase("A") &&
                    !escolhar4.equalsIgnoreCase("B") &&
                    !escolhar4.equalsIgnoreCase("C") &&
                    !escolhar4.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            } else if (escolhar4.equalsIgnoreCase("a")) {
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            } else {
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        do {
            System.out.println("Quinta Pergunta: Em The Evil Within qual é o nome do principal vilão do jogo?\n" + "(a) Sebastian Castellanos\n" + "(b) Ruvik\n" + "(c) Marcelo Jimenez\n" + "(d) Leslie Withers");
            System.out.println("Escolhar sua resposta: ");
            escolhar5 = x.next();
            if (!escolhar5.equalsIgnoreCase("A") &&
                    !escolhar5.equalsIgnoreCase("B") &&
                    !escolhar5.equalsIgnoreCase("C") &&
                    !escolhar5.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            } else if (escolhar5.equalsIgnoreCase("b")) {
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            } else {
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        System.out.printf("Parabéns você acertou %d/5 perguntas!!!\n", contador);
        System.out.println("Volta para pagina inicial(sim)(não)?");
        inicio = x.next();
        if (inicio.matches("[a-zA-Z]+")) {
        } else {
            System.err.println("Opção Inválida!");
        }
        if (inicio.equalsIgnoreCase("sim")) {
            categorias();
        } else {
            System.out.println("👋 Obrigado por jogar! Até a próxima!");
            System.exit(0);
        }
    }
    /**
     * Este método exibe as perguntas na tela e pede para o usuário resposter,depois verificar a respota e exibe na tela se acertou ou não
     */
    public static void acao() {
        String escolhar1, escolhar2, escolhar3, escolhar4, escolhar5, inicio;
        int contador = 0;
        do {
            System.out.println("Primeira Pergunta: No jogo God of War Ragnarök, qual é o objetivo de Kratos?\n" + "(a) Destruir o Olimpo\n" + "(b) Encontar Pandora\n" + "(c) Matar Zeus\n" + "(d) Impedir o Ragnarök");
            System.out.println("Escolhar sua resposta: ");
            escolhar1 = x.next();
            if (!escolhar1.equalsIgnoreCase("A") &&
                    !escolhar1.equalsIgnoreCase("B") &&
                    !escolhar1.equalsIgnoreCase("C") &&
                    !escolhar1.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            } else if (escolhar1.equalsIgnoreCase("d")) {
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            } else {
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        do {
            System.out.println("Segunda Pergunta: Em Tomb Raider(2013) qual é o nome da ilha que Lara Croft ficar presa?\n" + "(a) Yamatai\n" + "(b) Xian\n" + "(c) Kuru\n" + "(d) Mabubu");
            System.out.println("Escolhar sua resposta: ");
            escolhar2 = x.next();
            if (!escolhar2.equalsIgnoreCase("A") &&
                    !escolhar2.equalsIgnoreCase("B") &&
                    !escolhar2.equalsIgnoreCase("C") &&
                    !escolhar2.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            } else if (escolhar2.equalsIgnoreCase("a")) {
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            } else {
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        do {
            System.out.println("Terceira Pergunta: Nos jogos da série Arkhan do Batman qual é o vilão que aparecem nos 3 jogos?(Multiealternativas)\n" + "(a) Mulher Gato\n" + "(b) Coringa\n" + "(c) Dr.Pyg\n" + "(d) Pinguim");
            System.out.println("Escolhar sua resposta: ");
            escolhar3 = x.next();
            if (!escolhar3.equalsIgnoreCase("A") &&
                    !escolhar3.equalsIgnoreCase("B") &&
                    !escolhar3.equalsIgnoreCase("C") &&
                    !escolhar3.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            } else if (escolhar3.equalsIgnoreCase("b")) {
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            } else {
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        do {
            System.out.println("Quarta Pergunta: Em The Last of Us™ Part I qual é o principal personagem que a gente controlar?\n" + "(a) Ellie\n" + "(b) Tommy\n" + "(c) Joel\n" + "(d) Abby");
            System.out.println("Escolhar sua resposta: ");
            escolhar4 = x.next();
            if (!escolhar4.equalsIgnoreCase("A") &&
                    !escolhar4.equalsIgnoreCase("B") &&
                    !escolhar4.equalsIgnoreCase("C") &&
                    !escolhar4.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            } else if (escolhar4.equalsIgnoreCase("c")) {
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            } else {
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        do {
            System.out.println("Quinta Pergunta: Qual doença Arthur Morgan contrai durante a história de Red Dead Redemption 2?\n" + "(a) Tuberculose\n" + "(b) Malária\n" + "(c) Febre tifóide\n" + "(d) Peste");
            System.out.println("Escolhar sua resposta: ");
            escolhar5 = x.next();
            if (!escolhar5.equalsIgnoreCase("A") &&
                    !escolhar5.equalsIgnoreCase("B") &&
                    !escolhar5.equalsIgnoreCase("C") &&
                    !escolhar5.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            } else if (escolhar5.equalsIgnoreCase("a")) {
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            } else {
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        System.out.printf("Parabéns você acertou %d/5 perguntas!!!\n", contador);
        System.out.println("Volta para pagina inicial(sim)(não)?");
        inicio = x.next();
        if (inicio.matches("[a-zA-Z]+")) {
        } else {
            System.err.println("Opção Inválida!");
        }
        if (inicio.equalsIgnoreCase("sim")) {
            categorias();
        } else {
            System.out.println("👋 Obrigado por jogar! Até a próxima!");
            System.exit(0);
        }
    }
    /**
     * Este método exibe as perguntas na tela e pede para o usuário resposter,depois verificar a respota e exibe na tela se acertou ou não
     */
    public static void rpg() {
        String escolhar1, escolhar2, escolhar3, escolhar4, escolhar5, inicio;
        int contador = 0;
        do {
            System.out.println("Primeira Pergunta: Em Dark Souls, o que são as “Almas” (Souls) usadas para?\n" + "(a) Abrir portais secretos\n" + "(b) Comprar e melhorar equipamentos e atributos\n" + "(c) Reviver personagens mortos\n" + "(d) Invocar outros jogadores");
            System.out.println("Escolhar sua resposta: ");
            escolhar1 = x.next();
            if (!escolhar1.equalsIgnoreCase("A") &&
                    !escolhar1.equalsIgnoreCase("B") &&
                    !escolhar1.equalsIgnoreCase("C") &&
                    !escolhar1.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            } else if (escolhar1.equalsIgnoreCase("b")) {
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            } else {
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        do {
            System.out.println("Segunda Pergunta: No universo de Clair Obscur: Expedition 33, quem ou o que é a “Artífice”, e qual papel ela desempenha na trama do jogo??\n" +
                    "(a) Uma deusa misteriosa que desperta a cada ano para apagar um grupo de humanos do mundo.\n"
                    + "(b) A líder dos exploradores que guia a Expedição 33 em busca de uma nova terra.\n" +
                    "(c) A líder dos exploradores que guia a Expedição 33 em busca de uma nova terra.\n" +
                    "(d) Uma guerreira lendária que tenta destruir o ciclo de renascimento.");
            System.out.println("Escolhar sua resposta: ");
            escolhar2 = x.next();
            if (!escolhar2.equalsIgnoreCase("A") &&
                    !escolhar2.equalsIgnoreCase("B") &&
                    !escolhar2.equalsIgnoreCase("C") &&
                    !escolhar2.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            } else if (escolhar2.equalsIgnoreCase("a")) {
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            } else {
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        do {
            System.out.println("Terceira Pergunta: No jogo The Witcher 3: Wild Hunt, qual é o nome do protagonista?\n" + "(a) Ezio Auditore\n" + "(b) Arthur Morgan\n" + "(c) Kratos\n" + "(d) Geralt de Rívia");
            System.out.println("Escolhar sua resposta: ");
            escolhar3 = x.next();
            if (!escolhar3.equalsIgnoreCase("A") &&
                    !escolhar3.equalsIgnoreCase("B") &&
                    !escolhar3.equalsIgnoreCase("C") &&
                    !escolhar3.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            } else if (escolhar3.equalsIgnoreCase("d")) {
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            } else {
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        do {
            System.out.println("Quarta Pergunta: Em Final Fantasy VII, qual é o nome da grande corporação responsável por explorar a energia Mako?\n" + "(a) Avalanche\n" + "(b) Midgar Corp\n" + "(c) Shinra\n" + "(d) ReactorX");
            System.out.println("Escolhar sua resposta: ");
            escolhar4 = x.next();
            if (!escolhar4.equalsIgnoreCase("A") &&
                    !escolhar4.equalsIgnoreCase("B") &&
                    !escolhar4.equalsIgnoreCase("C") &&
                    !escolhar4.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            } else if (escolhar4.equalsIgnoreCase("c")) {
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            } else {
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        do {
            System.out.println("Quinta Pergunta: Em Elden Ring qual personagem ajuda o jogador a canalizar runas e subir de nível durante a jornada?\n" + "(a) Malenia\n" + "(b) Ranni\n" + "(c) Renala\n" + "(d) Melina");
            System.out.println("Escolhar sua resposta: ");
            escolhar5 = x.next();
            if (!escolhar5.equalsIgnoreCase("A") &&
                    !escolhar5.equalsIgnoreCase("B") &&
                    !escolhar5.equalsIgnoreCase("C") &&
                    !escolhar5.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            } else if (escolhar5.equalsIgnoreCase("d")) {
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            } else {
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        System.out.printf("Parabéns você acertou %d/5 perguntas!!!\n", contador);
        System.out.println("Volta para pagina inicial(sim)(não)?");
        inicio = x.next();
        // Caso o usuário queira voltar para o inicio do Quiz ou não
        if (inicio.matches("[a-zA-Z]+")) {
        } else {
            System.err.println("Opção Inválida!");
        }
        if (inicio.equalsIgnoreCase("sim")) {
            categorias();
        } else {
            System.out.println("👋 Obrigado por jogar! Até a próxima!");
            System.exit(0);
        }
    }
}
