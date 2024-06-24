package controller;
import java.io.IOException;
import java.util.List;

import model.Admin;
import model.Pergunta;
import model.Player;
import view.Console;

public class Sistema {

    static {
        GerenciadorAdmins.inicializarAdminPadrao();
    }

    public static void executarSistema() throws IOException {
        while (true) {
            menu();
            int op = Console.lerInt("Informe uma opção");
            System.out.println("\n");
            verificarOpcao(op);
        }
    }

    public static void menu() {
        System.out.println("\n---- Bem vindo ao jogo de trivia ----");
        System.out.println("1) Iniciar jogo");
        System.out.println("2) Players");
        System.out.println("3) Exibir scoreboard");
        System.out.println("4) Admin");
        System.out.println("0) Sair");
    }

    public static void verificarOpcao(int op) throws IOException {
        switch (op) {
            case 1:
                String nome = Console.lerString("Informe seu nome: ");
                String senha = Console.lerString("Informe sua senha: ");
                try {
                    Player jogador = GerenciadorPlayers.buscarPlayer(nome);
                    if (jogador != null && jogador.getSenha().equals(senha)) {
                        List<Pergunta> perguntas = Arquivo.carregarPerguntas("perguntas.txt");
                        JogoTrivia jogo = new JogoTrivia(perguntas, jogador);
                        jogo.iniciar();
                    } else {
                        System.out.println("Senha incorreta, tente novamente");
                    }
                } catch (Exception e) {
                    System.out.println("Erro ao buscar jogador: " + e.getMessage());
                }
                break;
            case 2:
                System.out.println("1) Cadastrar novo player");
                System.out.println("2) Editar player");
                System.out.println("3) Excluir player");
                System.out.println("4) Listar todos os players");
                System.out.println("0) Sair");
                int op2 = Console.lerInt("Informe uma opção: ");
                switch (op2) {
                    case 1:
                        Player player = new Player(null, null);
                        player.setNome(Console.lerString("Informe seu nome: "));
                        player.setSenha(Console.lerString("Informe sua senha: "));
                        try {
                            GerenciadorPlayers.cadastrarPlayers(player);
                        } catch (IOException e) {
                            System.out.println("Erro ao salvar player: " + e.getMessage());
                        }
                        break;
                    case 2:
                        GerenciadorPlayers.editarPlayer(Console.lerString("Quem você deseja editar? R: "), Console.lerString("Informe o novo nome: "), Console.lerString("Informe a nova senha: "));
                        break;
                    case 3:
                        GerenciadorPlayers.apagarPlayer(Console.lerString("Nome de quem deseja apagar: "));
                        break;
                    case 4:
                        GerenciadorPlayers.mostrarLista();
                        break;
                    case 0:
                        System.exit(op2);
                        break;
                    default:
                        System.out.println("Opção inválida tente novamente");
                        break;
                }
                break;
            case 3:
                GerenciadorPlayers.exibirScoreboard();
                break;
            
            case 4:
                GerenciadorAdmins.autenticarAdmin();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                break;
        }
 
    }

    public static void opcoesAdmins() throws IOException {
        System.out.println("1) Cadastrar novo admin");
        System.out.println("2) Listar todos os admins");
        System.out.println("3) Cadastrar uma nova pergunta ao jogo trivia");
        System.out.println("4) Apagar admin");
        System.out.println("0) Voltar");
        int op2 = Console.lerInt("Informe uma opção: ");
        switch (op2) {
            case 1:
                Admin admin = new Admin(Console.lerString("Informe o nome do admin: "), Console.lerString("Informe a senha do admin: "));
                GerenciadorAdmins.adicionarAdmin(admin);
                GerenciadorAdmins.salvarAdmins();
                break;
            case 2:
                List<Admin> admins = GerenciadorAdmins.carregarAdmins();
                System.out.println("Lista de administradores:");
                for (Admin a : admins) {
                    System.out.println("ID: " + a.getID() + ", Nome: " + a.getNome());
                }
                break;
            case 3:
                Admin.cadastrarPergunta();
                break;
            case 4:    
                GerenciadorAdmins.apagarAdmin(Console.lerString("Informe o nome: "), Console.lerString("Informe a senha: "));
            case 0:
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
                break;
        }
    }
}

