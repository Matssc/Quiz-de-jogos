import java.util.Scanner;
public class Quiz {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        // variáveis
        String nome, resposta1, escolhar1, resposta2, resposta4,resposta5;
        String escolhar2, resposta3, escolhar3, escolhar4,escolhar5;
        int contador = 0;
        // entrada de dados do usuário
        System.out.printf("   Bem Vindo ao QUIZ de Jogos!!!  \n\n");
        System.out.println("Informe o seu nome : ");
        nome = x.nextLine();
        // entrada de dados da primeira pergunta
        System.out.printf("Olá %s seja,bem vindo iremos iniciar o quiz!\n", nome);
        System.out.println("Primeira Pergunta: No jogo The Last of Zelda Ocarina of Time, qual é o nome do Protagonista?");
        System.out.println("(a) Zelda");
        System.out.println("(b) Epona");
        System.out.println("(c) Link");
        System.out.println("(d) Ganon");
        System.out.println("Escolhar sua resposta: ");
        escolhar1 = x.nextLine();
        resposta1 = "c";
        // Validando a resposta do usuário
        if (!escolhar1.equalsIgnoreCase("A") &&
                !escolhar1.equalsIgnoreCase("B") &&
                !escolhar1.equalsIgnoreCase("C") &&
                !escolhar1.equalsIgnoreCase("D")) {
            System.err.println("Alternativa inválida!!!");
            return;
        }
        // Verificando se o usuário acertou a pergunta
        if (escolhar1.equalsIgnoreCase(resposta1)) {
            System.out.println("Parabéns você Certou !!!");
            ++contador;
        } else {
            System.out.println("Infelizmente você Errou :(");
        }

        // entrada de dados da segunda pergunta
        System.out.println("\nSegunda pergunta: Qual é o nome do irmão do Mario? ");
        System.out.println("(a) Toad");
        System.out.println("(b) Luigi");
        System.out.println("(c) Bowser");
        System.out.println("(d) Yoshi");
        System.out.println("Escolhar sua resposta: ");
        escolhar2 = x.nextLine();
        resposta2 = "b";
        // Validando a resposta do usuário
        if (!escolhar2.equalsIgnoreCase("A") &&
                !escolhar2.equalsIgnoreCase("B") &&
                !escolhar2.equalsIgnoreCase("C") &&
                !escolhar2.equalsIgnoreCase("D")) {
            System.err.println("Alternativa inválida!!!");
            return;
        }
        // Verificando se o usuário acertou a pergunta
        if (escolhar2.equalsIgnoreCase(resposta2)) {
            System.out.println("Parabéns você Certou !!!");
            ++contador;
        } else {
            System.out.println("Infelizmente você Errou :(");
        }

        // entrada de dados da terceira pergunta
        System.out.println("\nTerceira pergunta: No jogo The Last of Zelda Ocarina of time qual é o instrumento músical o Protagonista usar durante o jogo? ");
        System.out.println("(a) Violão");
        System.out.println("(b) Gaita");
        System.out.println("(c) Bateria");
        System.out.println("(d) Ocarina");
        System.out.println("Escolhar sua resposta: ");
        escolhar3 = x.nextLine();
        resposta3 = "d";
        // Validando a resposta do usuário
        if (!escolhar3.equalsIgnoreCase("A") &&
                !escolhar3.equalsIgnoreCase("B") &&
                !escolhar3.equalsIgnoreCase("C") &&
                !escolhar3.equalsIgnoreCase("D")) {
            System.err.println("Alternativa inválida!!!");
            return;
        }
        // Verificando se o usuário acertou a pergunta
        if (escolhar3.equalsIgnoreCase(resposta3)) {
            System.out.println("Parabéns você Certou !!!");
            ++contador;
        } else {
            System.out.println("Infelizmente você Errou :(");
        }

        // entrada de dados da quarta pergunta
        System.out.println("\nQuarta pergunta: Qual é a cor do cogumelo do Mario que faz ele aumentar seu tamanho? ");
        System.out.println("(a) Vermelho");
        System.out.println("(b) Amarelo");
        System.out.println("(c) Azul");
        System.out.println("(d) Verde");
        System.out.println("Escolhar sua resposta: ");
        escolhar4 = x.nextLine();
        resposta4 = "a";
        // validando a respostar do usuário
        if (!escolhar4.equalsIgnoreCase("A") &&
                !escolhar4.equalsIgnoreCase("B") &&
                !escolhar4.equalsIgnoreCase("C") &&
                !escolhar4.equalsIgnoreCase("D")) {
            System.err.println("Alternativa inválida!!!");
            return;
        }
        // Verificando se o usuário acertou a pergunta
        if (escolhar4.equalsIgnoreCase(resposta4)) {
            System.out.println("Parabéns você Certou !!!");
            ++contador;
        } else {
            System.out.println("Infelizmente você Errou :(");
        }

        // entrada de dados da quinta pergunta
        System.out.println("\nQuinta pergunta: Qual é nome da espada sagrada que o protagonista usar The legend of Zelda? ");
        System.out.println("(a) Kokiri Sword");
        System.out.println("(b) Master Sword");
        System.out.println("(c) Four Sword");
        System.out.println("(d) Biggoron's Sword");
        System.out.println("Escolhar sua resposta: ");
        escolhar5 = x.nextLine();
        resposta5 = "b";
        // validando a respostar do usuário
        if (!escolhar5.equalsIgnoreCase("A") &&
                !escolhar5.equalsIgnoreCase("B") &&
                !escolhar5.equalsIgnoreCase("C") &&
                !escolhar5.equalsIgnoreCase("D")) {
            System.err.println("Alternativa inválida!!!");
            return;
        }
        // Verificando se o usuário acertou a pergunta
        if (escolhar5.equalsIgnoreCase(resposta5)) {
            System.out.println("Parabéns você Certou !!!");
            ++contador;
        } else {
            System.out.println("Infelizmente você Errou :(");
        }
        // Print final parabenizando o usuário e mostrando quantas perguntas o usuário acertou
        System.out.printf("Parabéns %s você acertou %d perguntas!!!", nome, contador);
        x.close();
    }

}
