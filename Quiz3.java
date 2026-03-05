import java.util.Scanner;
public class Quiz3 {
    static Scanner x = new Scanner(System.in);
    public static void main(String[] args) {
        nome();
        pergutas();
    }
    /**
     * Este método pede o nome do usuário,verificar se estar válido e exibir na tela
     */
    public static void nome() {
        String nome;
        System.out.printf("   Bem Vindo ao QUIZ de Jogos!!!  \n\n");
        do {
            System.out.println("Informe o seu nome : ");
            nome = x.nextLine();
            if (nome.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.err.println("Nome Inválido!!!");
                continue;
            }
        } while (true);
        System.out.printf("Olá %s seja bem vindo,iremos iniciar o quiz!\n", nome);
    }
    /**
     * Este método exibe as perguntas na tela e pede para o usuário resposter,depois verificar a respota e exibe na tela se acertou ou não
     */
    public static void pergutas() {
        String escolhar1,escolhar2,escolhar3,escolhar4,escolhar5,inicio;
        int contador = 0;

        do {
            System.out.println("Primeira Pergunta: No jogo The Last of Zelda Ocarina of Time, qual é o nome do Protagonista?\n" + "(a) Zelda\n" + "(b) Epona\n" + "(c) Link\n" + "(d) Ganon");
            System.out.println("Escolhar sua resposta: ");
            escolhar1 = x.next();
            if (!escolhar1.equalsIgnoreCase("A") &&
                    !escolhar1.equalsIgnoreCase("B") &&
                    !escolhar1.equalsIgnoreCase("C") &&
                    !escolhar1.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            }else if (escolhar1.equalsIgnoreCase("c")){
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            }else{
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);

        do {
            System.out.println("Segunda Pergunta: Qual é o nome do irmão do Mario?\n"+"(a) Toad\n" +"(b) Luigi\n"+"(c) Bowser\n"+"(d) Yoshi");
            System.out.println("Escolhar sua resposta: ");
            escolhar2 = x.next();
            if (!escolhar2.equalsIgnoreCase("A") &&
                    !escolhar2.equalsIgnoreCase("B") &&
                    !escolhar2.equalsIgnoreCase("C") &&
                    !escolhar2.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            }else if (escolhar2.equalsIgnoreCase("b")){
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            }else{
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        do {
            System.out.println("Terceira Pergunta: No jogo The Last of Zelda Ocarina of time qual é o instrumento músical o Protagonista usar durante o jogo?\n"+"(a) Violão\n" +"(b) Gaita\n"+"(c) Bateria\n"+"(d) Ocarina");
            System.out.println("Escolhar sua resposta: ");
            escolhar3 = x.next();
            if (!escolhar3.equalsIgnoreCase("A") &&
                    !escolhar3.equalsIgnoreCase("B") &&
                    !escolhar3.equalsIgnoreCase("C") &&
                    !escolhar3.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            }else if (escolhar3.equalsIgnoreCase("d")){
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            }else{
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        do {
            System.out.println("Quarta Pergunta: Qual é a cor do cogumelo do Mario que faz ele aumentar seu tamanho?\n"+"(a) Vermelho\n" +"(b) Amarelo\n"+"(c) Azul\n"+"(d) Verde");
            System.out.println("Escolhar sua resposta: ");
            escolhar4 = x.next();
            if (!escolhar4.equalsIgnoreCase("A") &&
                    !escolhar4.equalsIgnoreCase("B") &&
                    !escolhar4.equalsIgnoreCase("C") &&
                    !escolhar4.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            }else if (escolhar4.equalsIgnoreCase("a")){
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            }else{
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        do {
            System.out.println("Quinta Pergunta: Qual é nome da espada sagrada que o protagonista usar The legend of Zelda?\n"+"(a) Kokiri Sword\n" +"(b) Master Sword\n"+"(c) Four Sword\n"+"(d) Biggoron's Sword");
            System.out.println("Escolhar sua resposta: ");
            escolhar5 = x.next();
            if (!escolhar5.equalsIgnoreCase("A") &&
                    !escolhar5.equalsIgnoreCase("B") &&
                    !escolhar5.equalsIgnoreCase("C") &&
                    !escolhar5.equalsIgnoreCase("D")) {
                System.err.println("Alternativa inválida!!!");
                continue;
            }else if (escolhar5.equalsIgnoreCase("b")){
                System.out.println("✅Resposta correta!");
                ++contador;
                break;
            }else{
                System.out.println("❌Resposta errada");
                break;
            }
        } while (true);
        System.out.printf("Parabéns você acertou %d/5 perguntas!!!\n",contador);
        System.out.println("Volta para pagina inicial(sim)(não)?");
        inicio = x.next();
        if (inicio.matches("[a-zA-Z]+")) {
        } else {
            System.err.println("Opção Inválida!");
    }
        if(inicio.equalsIgnoreCase("sim")){
            pergutas();
        }else{
            System.out.println("Obrigado por participar");
        }
    }
}