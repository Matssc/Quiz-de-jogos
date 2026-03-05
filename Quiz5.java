import java.util.Scanner;
import java.util.Random;
public class Quiz5 {
    static Scanner x = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        nome();
        categorias();
    }

    /**
     * Pede o nome do usuário, valida e exibe uma saudação.
     */
    public static void nome() {
        String nome;
        System.out.println("🎮 Bem-vindo ao QUIZ de Jogos!!! 🎮");
        do {
            System.out.print("Informe o seu nome: ");
            nome = x.nextLine();
            if (nome.matches("[A-Za-zÀ-ÖØ-öø-ÿ]+"))
                break;
            System.err.println("Nome inválido! Digite apenas letras.");
        } while (true);
        System.out.printf("Olá %s, seja bem-vindo! Iremos iniciar o quiz!\n\n", nome);
    }

    /**
     * Mostra o menu de categorias e direciona o jogador.
     */
    public static void categorias() {
        String resposta;
        boolean continuar = true;
        do {
            System.out.println("""
                    Escolha a categoria de perguntas:
                    1 - Terror
                    2 - Ação e Aventura
                    3 - RPG
                    4 - Sair
                    """);
            System.out.print("Digite o número da categoria: ");
            resposta = x.next();

            switch (resposta) {
                case "1" -> categoriaTerror();
                case "2" -> categoriaAcao();
                case "3" -> categoriaRPG();
                case "4" -> {
                    System.out.println("👋 Obrigado por jogar! Até a próxima!");
                    continuar = false;
                }
                default -> System.err.println("❌ Categoria inválida!");
            }
        } while (continuar);
    }

    /**
     * Método genérico para fazer perguntas e validar respostas.
     */
    public static boolean perguntar(String pergunta, String correta) {
        String resposta;
        do {
            System.out.println(pergunta);
            System.out.print("Escolha sua resposta: ");
            resposta = x.next();

            if (!resposta.matches("[ABCDabcd]")) {
                System.err.println("Alternativa inválida! Digite apenas A, B, C ou D.\n");
                continue;
            }

            if (resposta.equalsIgnoreCase(correta)) {
                System.out.println("✅ Resposta correta!\n");
                return true;
            } else {
                System.out.println("❌ Resposta errada!\n");
                return false;
            }
        } while (true);
    }

    /**
     * Função que pergunta se o jogador deseja voltar para o menu ou sair.
     */
    public static void voltarOuSair() {
        String inicio;
        do {
            System.out.println("Deseja voltar para a página inicial (sim/não)? ");
            inicio = x.next();
            if (inicio.equalsIgnoreCase("sim")) {
                System.out.println();
                categorias();
                return;
            } else if (inicio.equalsIgnoreCase("não") || inicio.equalsIgnoreCase("nao")) {
                System.out.println("👋 Obrigado por jogar! Até a próxima!");
                System.exit(0);
            } else {
                System.err.println("Opção inválida! Digite 'sim' ou 'não'.");
            }
        } while (true);
    }

    /**
     * Contêm as perguntas da categoria terror e emparalhar as perguntas.
     */
    public static void categoriaTerror() {
        String[] perguntas = {
                "No jogo Resident Evil 2, qual é o nome da cidade onde o jogo se passa?\n(A) Kijuju\n(B) Lanshiang\n(C) Raccoon City\n(D) Tall Oaks",
                "Em Silent Hill 2, James vai para Silent Hill após receber uma carta de sua esposa morta chamada:\n(A) Maria\n(B) Mary\n(C) Angela\n(D) Eloisa",
                "Nos jogos de Outlast, qual é a principal ferramenta que o protagonista usa?\n(A) Celular\n(B) Diário\n(C) Bateria\n(D) Filmadora",
                "Qual é o nome do primeiro manuscrito encontrado em Alan Wake?\n(A) Partida\n(B) Retorno\n(C) Iniciação\n(D) Verdade",
                "Em The Evil Within, qual é o nome do principal vilão do jogo?\n(A) Sebastian Castellanos\n(B) Ruvik\n(C) Marcelo Jimenez\n(D) Leslie Withers"
        };

        String[] respostas = {"C", "B", "D", "A", "B"};

        embaralhar(perguntas, respostas);

        int contador = 0;
        for (int i = 0; i < perguntas.length; i++) {
            if (perguntar(perguntas[i], respostas[i])) contador++;
        }

        System.out.printf("🎯 Você acertou %d/5 perguntas!\n\n", contador);
        voltarOuSair();
    }

    /**
     * Contêm as perguntas da categoria Ação e aventura e emparalhar as perguntas.
     */
    public static void categoriaAcao() {
        String[] perguntas = {
                "No jogo God of War Ragnarök, qual é o objetivo de Kratos?\n(A) Destruir o Olimpo\n(B) Encontrar Pandora\n(C) Matar Zeus\n(D) Impedir o Ragnarök",
                "Em Tomb Raider (2013), qual é o nome da ilha onde Lara Croft fica presa?\n(A) Yamatai\n(B) Xian\n(C) Kuru\n(D) Mabubu",
                "Nos jogos da série Arkham do Batman, qual vilão aparece nos três jogos?\n(A) Mulher Gato\n(B) Coringa\n(C) Dr. Pyg\n(D) Pinguim",
                "Em The Last of Us Part I, qual é o principal personagem que controlamos?\n(A) Ellie\n(B) Tommy\n(C) Joel\n(D) Abby",
                "Qual doença Arthur Morgan contrai durante a história de Red Dead Redemption 2?\n(A) Tuberculose\n(B) Malária\n(C) Febre tifóide\n(D) Peste"
        };

        String[] respostas = {"D", "A", "B", "C", "A"};

        embaralhar(perguntas, respostas);

        int contador = 0;
        for (int i = 0; i < perguntas.length; i++) {
            if (perguntar(perguntas[i], respostas[i])) contador++;
        }


        System.out.printf("🎯 Você acertou %d/5 perguntas!\n\n", contador);
        voltarOuSair();
    }

    /**
     * Contêm as perguntas da categoria RPG e emparalhar as perguntas.
     */
    public static void categoriaRPG() {
        String[] perguntas = {
                "Em Dark Souls, o que são as 'Almas' usadas para?\n(A) Abrir portais secretos\n(B) Comprar e melhorar equipamentos e atributos\n(C) Reviver personagens mortos\n(D) Invocar outros jogadores",
                "Em Clair Obscur: Expedition 33, quem é a 'Artífice' e qual é seu papel?\n(A) Uma deusa misteriosa que desperta a cada ano para apagar um grupo de humanos.\n(B) A líder dos exploradores que guia a Expedição 33 em busca de uma nova terra.\n(C) Uma guerreira lendária que tenta destruir o ciclo de renascimento.\n(D) Uma entidade que manipula o tempo e os sonhos dos exploradores.",
                "No jogo The Witcher 3: Wild Hunt, qual é o nome do protagonista?\n(A) Ezio Auditore\n(B) Arthur Morgan\n(C) Kratos\n(D) Geralt de Rívia",
                "Em Final Fantasy VII, qual é o nome da corporação responsável por explorar a energia Mako?\n(A) Avalanche\n(B) Midgar Corp\n(C) Shinra\n(D) ReactorX",
                "Em Elden Ring, qual personagem ajuda o jogador a subir de nível?\n(A) Malenia\n(B) Ranni\n(C) Renala\n(D) Melina"
        };

        String[] respostas = {"B", "A", "D", "C", "D"};

        embaralhar(perguntas, respostas);

        int contador = 0;
        for (int i = 0; i < perguntas.length; i++) {
            if (perguntar(perguntas[i], respostas[i])) contador++;
        }

        System.out.printf("🎯 Você acertou %d/5 perguntas!\n\n", contador);
        voltarOuSair();
    }

    /**
     * Embaralha dois arrays simultaneamente, mantendo a correspondência entre eles.
     * @param perguntas Array de perguntas (cada elemento é uma String com a pergunta e alternativas)
     * @param respostas Array de respostas corretas correspondentes às perguntas
     */
    public static void embaralhar(String[] perguntas, String[] respostas) {
        for (int i = perguntas.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            // trocar pergunta
            String tempPergunta = perguntas[i];
            perguntas[i] = perguntas[j];
            perguntas[j] = tempPergunta;

            // trocar resposta correspondente
            String tempResposta = respostas[i];
            respostas[i] = respostas[j];
            respostas[j] = tempResposta;
        }
    }
}
