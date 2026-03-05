import java.util.Scanner;
public class Quiz2{
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        // variáveis
        String nome = "",escolhar1,escolhar2,escolhar3, escolhar4,escolhar5;
        int contador = 0;
        // entrada de dados do usuário
        System.out.printf("   Bem Vindo ao QUIZ de Jogos!!!  \n\n");
        System.out.println("Informe o seu nome : ");
        nome = x.nextLine();
        // Validando o nome do usuário
        if(nome.matches("[a-zA-Z]+")){
        }else {
            System.err.println("Nome Inválido!!!");
            return;
        }
        // entrada de dados da primeira pergunta
        System.out.printf("Olá %s seja,bem vindo iremos iniciar o quiz!\n", nome);
        System.out.println("Primeira Pergunta: No jogo The Last of Zelda Ocarina of Time, qual é o nome do Protagonista?");
        System.out.println("(a) Zelda");
        System.out.println("(b) Epona");
        System.out.println("(c) Link");
        System.out.println("(d) Ganon");
        System.out.println("Escolhar sua resposta: ");
        escolhar1 = x.nextLine();
        // Validando a resposta do usuário
        if (!escolhar1.equalsIgnoreCase("A") &&
                !escolhar1.equalsIgnoreCase("B") &&
                !escolhar1.equalsIgnoreCase("C") &&
                !escolhar1.equalsIgnoreCase("D")) {
            System.err.println("Alternativa inválida!!!");
            return;
        }
        // Verificando se o usuário acertou a pergunta
        System.out.println(escolhar1.equalsIgnoreCase("c")?"Parabéns você Certou !!!" : "Infelizmente você Errou :(");
        ++contador;

        // entrada de dados da segunda pergunt
        System.out.println("\nSegunda pergunta: Qual é o nome do irmão do Mario? ");
        System.out.println("(a) Toad");
        System.out.println("(b) Luigi");
        System.out.println("(c) Bowser");
        System.out.println("(d) Yoshi");
        System.out.println("Escolhar sua resposta: ");
        escolhar2 = x.nextLine();
        // Validando a resposta do usuário
        if (!escolhar2.equalsIgnoreCase("A") &&
                !escolhar2.equalsIgnoreCase("B") &&
                !escolhar2.equalsIgnoreCase("C") &&
                !escolhar2.equalsIgnoreCase("D")) {
            System.err.println("Alternativa inválida!!!");
            return;
        }
        // Verificando se o usuário acertou a pergunta
        System.out.println(escolhar2.equalsIgnoreCase("b")?"Parabéns você Certou !!!" : "Infelizmente você Errou :(");
        ++contador;

        // entrada de dados da terceira pergunta
        System.out.println("\nTerceira pergunta: No jogo The Last of Zelda Ocarina of time qual é o instrumento músical o Protagonista usar durante o jogo? ");
        System.out.println("(a) Violão");
        System.out.println("(b) Gaita");
        System.out.println("(c) Bateria");
        System.out.println("(d) Ocarina");
        System.out.println("Escolhar sua resposta: ");
        escolhar3 = x.nextLine();
        // Validando a resposta do usuário
        if (!escolhar3.equalsIgnoreCase("A") &&
                !escolhar3.equalsIgnoreCase("B") &&
                !escolhar3.equalsIgnoreCase("C") &&
                !escolhar3.equalsIgnoreCase("D")) {
            System.err.println("Alternativa inválida!!!");
            return;
        }
        // Verificando se o usuário acertou a pergunta
        System.out.println(escolhar3.equalsIgnoreCase("d")?"Parabéns você Certou !!!" : "Infelizmente você Errou :(");
        ++contador;

        // entrada de dados da quarta pergunta
        System.out.println("\nQuarta pergunta: Qual é a cor do cogumelo do Mario que faz ele aumentar seu tamanho? ");
        System.out.println("(a) Vermelho");
        System.out.println("(b) Amarelo");
        System.out.println("(c) Azul");
        System.out.println("(d) Verde");
        System.out.println("Escolhar sua resposta: ");
        escolhar4 = x.nextLine();
        // validando a respostar do usuário
        if (!escolhar4.equalsIgnoreCase("A") &&
                !escolhar4.equalsIgnoreCase("B") &&
                !escolhar4.equalsIgnoreCase("C") &&
                !escolhar4.equalsIgnoreCase("D")) {
            System.err.println("Alternativa inválida!!!");
            return;
        }
        // Verificando se o usuário acertou a pergunta
        System.out.println(escolhar4.equalsIgnoreCase("a")?"Parabéns você Certou !!!" : "Infelizmente você Errou :(");
        ++contador;

        // entrada de dados da quinta pergunta
        System.out.println("\nQuinta pergunta: Qual é nome da espada sagrada que o protagonista usar The legend of Zelda? ");
        System.out.println("(a) Kokiri Sword");
        System.out.println("(b) Master Sword");
        System.out.println("(c) Four Sword");
        System.out.println("(d) Biggoron's Sword");
        System.out.println("Escolhar sua resposta: ");
        escolhar5 = x.nextLine();
        // validando a respostar do usuário
        if (!escolhar5.equalsIgnoreCase("A") &&
                !escolhar5.equalsIgnoreCase("B") &&
                !escolhar5.equalsIgnoreCase("C") &&
                !escolhar5.equalsIgnoreCase("D")) {
            System.err.println("Alternativa inválida!!!");
            return;
        }
        // Verificando se o usuário acertou a pergunta
        System.out.println(escolhar5.equalsIgnoreCase("b")?"Parabéns você Certou !!!" : "Infelizmente você Errou :(");
        ++contador;

        // Print final parabenizando o usuário e mostrando quantas perguntas o usuário acertou
        System.out.printf("Parabéns %s você acertou %d perguntas!!!", nome, contador);
        x.close();
    }
}

