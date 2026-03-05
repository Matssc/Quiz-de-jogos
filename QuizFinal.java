import java.sql.*;
import java.util.*;

public class QuizFinal {
    static Scanner x = new Scanner(System.in);

    // === CONFIGURAÇÃO DO BANCO ===
    static final String URL = "jdbc:mysql://localhost:3306/quizdb";
    static final String USER = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        menuPrincipal();
    }

    /**
     * Exibe o menu principal do jogo.
     * Permite jogar, ver ranking, acessar CRUD ou sair.
     */
    public static void menuPrincipal() {
        String opcao;
        do {
            System.out.println("""
                    \n=== MENU PRINCIPAL ===
                    1 - Jogar Quiz
                    2 - Ver Ranking (Top 10)
                    3 - Gerenciar Perguntas (CRUD)
                    4 - Sair
                    """);
            System.out.print("Escolha uma opção: ");
            opcao = x.nextLine();

            switch (opcao) {
                case "1" -> {
                    String nomeUsuario = nome();
                    if (nomeUsuario != null) {
                        categorias(nomeUsuario);
                    }
                }
                case "2" -> exibirRanking();
                case "3" -> menuCRUD();
                case "4" -> {
                    System.out.println("👋 Obrigado por jogar! Até a próxima!");
                    return;
                }
                default -> System.err.println("❌ Opção inválida!");
            }
        } while (true);
    }

    /**
     * Conecta ao banco de dados MySQL usando JDBC.
     * @return objeto Connection para executar comandos SQL
     * @throws SQLException em caso de erro de conexão
     */
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Exibe o menu CRUD para gerenciar perguntas.
     * Permite criar, listar, atualizar, deletar perguntas
     * ou voltar ao menu principal.
     */
    public static void menuCRUD() {
        String opcao;
        do {
            System.out.println("""
                    \n=== MENU CRUD ===
                    1 - Criar pergunta
                    2 - Listar perguntas
                    3 - Atualizar pergunta
                    4 - Deletar pergunta
                    5 - Voltar ao menu principal
                    """);
            System.out.print("Escolha uma opção: ");
            opcao = x.nextLine();

            switch (opcao) {
                case "1" -> criarPergunta();
                case "2" -> listarPerguntas();
                case "3" -> atualizarPergunta();
                case "4" -> deletarPergunta();
                case "5" -> { return; }
                default -> System.err.println("❌ Opção inválida!");
            }
        } while (true);
    }

    /**
     * Cria uma nova pergunta e insere no banco de dados.
     * Solicita categoria, enunciado, alternativas e resposta correta.
     */
    public static void criarPergunta() {
        System.out.println("\n--- CRIAR NOVA PERGUNTA ---");
        System.out.print("Categoria: ");
        String categoria = x.nextLine();

        System.out.print("Enunciado: ");
        String enunciado = x.nextLine();

        System.out.print("Alternativa A: ");
        String a = x.nextLine();
        System.out.print("Alternativa B: ");
        String b = x.nextLine();
        System.out.print("Alternativa C: ");
        String c = x.nextLine();
        System.out.print("Alternativa D: ");
        String d = x.nextLine();

        String correta;
        do {
            System.out.print("Resposta correta (A, B, C ou D): ");
            correta = x.nextLine().trim().toUpperCase();
        } while (!correta.matches("[ABCD]"));

        try (Connection conn = conectar()) {
            String sql = "INSERT INTO perguntas (categoria, enunciado, alternativaA, alternativaB, alternativaC, alternativaD, correta) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, categoria);
            ps.setString(2, enunciado);
            ps.setString(3, a);
            ps.setString(4, b);
            ps.setString(5, c);
            ps.setString(6, d);
            ps.setString(7, correta);
            ps.executeUpdate();
            System.out.println("✅ Pergunta adicionada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lista todas as perguntas cadastradas no banco.
     * Mostra ID, categoria, enunciado e resposta correta.
     */
    public static void listarPerguntas() {
        System.out.println("\n--- LISTA DE PERGUNTAS ---");
        try (Connection conn = conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM perguntas")) {

            while (rs.next()) {
                System.out.printf("%d - [%s] %s (Correta: %s)\n",
                        rs.getInt("id"),
                        rs.getString("categoria"),
                        rs.getString("enunciado"),
                        rs.getString("correta"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Atualiza uma pergunta existente.
     * Solicita ID da pergunta, novos dados e salva no banco.
     */
    public static void atualizarPergunta() {
        listarPerguntas();
        System.out.print("\nDigite o ID da pergunta que deseja atualizar: ");
        int id = Integer.parseInt(x.nextLine());

        System.out.print("Novo enunciado: ");
        String enunciado = x.nextLine();

        System.out.print("Alternativa A: ");
        String a = x.nextLine();
        System.out.print("Alternativa B: ");
        String b = x.nextLine();
        System.out.print("Alternativa C: ");
        String c = x.nextLine();
        System.out.print("Alternativa D: ");
        String d = x.nextLine();

        System.out.print("Nova correta (A-D): ");
        String correta = x.nextLine().toUpperCase();

        try (Connection conn = conectar()) {
            String sql = "UPDATE perguntas SET enunciado=?, alternativaA=?, alternativaB=?, alternativaC=?, alternativaD=?, correta=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, enunciado);
            ps.setString(2, a);
            ps.setString(3, b);
            ps.setString(4, c);
            ps.setString(5, d);
            ps.setString(6, correta);
            ps.setInt(7, id);
            ps.executeUpdate();
            System.out.println("✅ Pergunta atualizada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleta uma pergunta do banco de dados.
     * Solicita o ID da pergunta a ser removida.
     */
    public static void deletarPergunta() {
        listarPerguntas();
        System.out.print("\nDigite o ID da pergunta que deseja deletar: ");
        int id = Integer.parseInt(x.nextLine());

        try (Connection conn = conectar()) {
            String sql = "DELETE FROM perguntas WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑️ Pergunta removida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Solicita o nome do jogador.
     * Se o nome for novo, cadastra no banco.
     * Se já existir, dá boas-vindas.
     * @return O nome do usuário (String) ou null em caso de falha de DB.
     */
    public static String nome() {
        String nome;
        System.out.println("🎮 Bem-vindo ao QUIZ de Jogos!!! 🎮");
        do {
            System.out.print("Informe o seu nome: ");
            nome = x.nextLine();
            if (!nome.matches("[A-Za-zÀ-ÖØ-öø-ÿ]+")) {
                System.err.println("Nome inválido! Digite apenas letras.");
                continue;
            }
            try (Connection conn = conectar()) {
                String sqlCheck = "SELECT COUNT(*) FROM usuarios WHERE nome = ?";
                PreparedStatement psCheck = conn.prepareStatement(sqlCheck);
                psCheck.setString(1, nome);
                ResultSet rs = psCheck.executeQuery();
                int count = 0;
                if (rs.next()) {
                    count = rs.getInt(1);
                }
                if (count > 0) {
                    System.out.printf("Olá %s, bem-vindo de volta! Iremos iniciar o quiz!\n", nome);
                } else {
                    String sqlInsert = "INSERT INTO usuarios (nome) VALUES (?)";
                    PreparedStatement psInsert = conn.prepareStatement(sqlInsert);
                    psInsert.setString(1, nome);
                    psInsert.executeUpdate();

                    System.out.printf("Olá %s, seja bem-vindo! Iremos iniciar o quiz!\n", nome);
                }
                return nome;

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }

        } while (true);
    }

    /**
     * Exibe categorias disponíveis e permite ao usuário escolher uma.
     * @param nomeUsuario O nome do jogador atual (para passar ao quiz).
     */
    public static void categorias(String nomeUsuario) {
        try (Connection conn = conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT DISTINCT categoria FROM perguntas")) {

            List<String> categorias = new ArrayList<>();
            while (rs.next()) {
                categorias.add(rs.getString("categoria"));
            }

            if (categorias.isEmpty()) {
                System.out.println("Nenhuma categoria cadastrada ainda!");
                return;
            }

            System.out.println("\n=== CATEGORIAS ===");
            for (int i = 0; i < categorias.size(); i++) {
                System.out.println((i + 1) + " - " + categorias.get(i));
            }

            System.out.print("Escolha o número da categoria: ");
            int escolha = Integer.parseInt(x.nextLine()) - 1;

            if (escolha < 0 || escolha >= categorias.size()) {
                System.err.println("Categoria inválida!");
                return;
            }

            jogarQuiz(categorias.get(escolha), nomeUsuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Executa o quiz para a categoria selecionada.
     * Salva a pontuação (acertos) do jogador no banco de dados.
     * @param categoria Categoria escolhida.
     * @param nomeUsuario Nome do jogador para salvar a pontuação.
     */
    public static void jogarQuiz(String categoria, String nomeUsuario) {
        try (Connection conn = conectar()) {
            String sql = "SELECT * FROM perguntas WHERE categoria=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, categoria);
            ResultSet rs = ps.executeQuery();

            List<Map<String, String>> perguntas = new ArrayList<>();
            while (rs.next()) {
                Map<String, String> p = new HashMap<>();
                p.put("enunciado", rs.getString("enunciado"));
                p.put("A", rs.getString("alternativaA"));
                p.put("B", rs.getString("alternativaB"));
                p.put("C", rs.getString("alternativaC"));
                p.put("D", rs.getString("alternativaD"));
                p.put("correta", rs.getString("correta"));
                perguntas.add(p);
            }

            if (perguntas.isEmpty()) {
                System.out.println("Nenhuma pergunta nessa categoria!");
                return;
            }

            Collections.shuffle(perguntas);
            int acertos = 0;

            for (Map<String, String> p : perguntas) {
                System.out.println("\n" + p.get("enunciado"));
                System.out.println("(A) " + p.get("A"));
                System.out.println("(B) " + p.get("B"));
                System.out.println("(C) " + p.get("C"));
                System.out.println("(D) " + p.get("D"));
                System.out.print("Sua resposta: ");
                String resp = x.nextLine().trim().toUpperCase();

                if (resp.equals(p.get("correta"))) {
                    System.out.println("✅ Correta!");
                    acertos++;
                } else {
                    System.out.println("❌ Errada! Resposta certa: " + p.get("correta"));
                }
            }
            int pontuacaoFinalDaPartida = acertos * 100;
            System.out.printf("🎯 Você acertou %d/%d perguntas!\n", acertos, perguntas.size());
            System.out.printf("💰 Você fez %d pontos nesta rodada!\n", pontuacaoFinalDaPartida);

            if (pontuacaoFinalDaPartida > 0) {
                String sqlUpdate = "UPDATE usuarios SET pontuacao = pontuacao + ? WHERE nome = ?";
                PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate);

                psUpdate.setInt(1, pontuacaoFinalDaPartida); // Salva o valor multiplicado

                psUpdate.setString(2, nomeUsuario);
                psUpdate.executeUpdate();
                System.out.println("✨ Pontuação salva com sucesso!");
            }
            // ---------------------------------

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Exibe os 10 melhores jogadores (ranking)
     * com base na pontuação total.
     */
    public static void exibirRanking() {
        System.out.println("\n🏆 === RANKING TOP 10 === 🏆");

        try (Connection conn = conectar()) {
            String sql = "SELECT nome, pontuacao FROM usuarios ORDER BY pontuacao DESC LIMIT 10";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            int posicao = 1;
            boolean temAlguem = false;

            while (rs.next()) {
                temAlguem = true;
                System.out.printf("%d. %s - %d pontos\n",
                        posicao,
                        rs.getString("nome"),
                        rs.getInt("pontuacao"));
                posicao++;
            }

            if (!temAlguem) {
                System.out.println("Ainda não há ninguém no ranking. Jogue para aparecer!");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar o ranking.");
            e.printStackTrace();
        }
    }
}