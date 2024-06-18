import java.io.IOException;
import java.util.List;
public class Sistema {

    public static void executarSistema() throws IOException{

        while (true) {
            menu();
            int op = Console.lerInt("Informe uma opção");
            verificarOpcao(op);
        }

    }

    public static void menu() {
        System.out.println("\n---- Bem vindo ao jogo de trivia ----");
        System.out.println("1) Iniciar jogo");
        System.out.println("2) Players");
        System.out.println("3) Exibir scoreboard ");
        System.out.println("0) Sair");

    }

    public static void verificarOpcao(int op) throws IOException{
        switch (op) {
            
            case 1:
             try {
            List<Pergunta> perguntas = Arquivo.carregarPerguntas("perguntas.txt");
            JogoTrivia jogo = new JogoTrivia(perguntas);
            jogo.iniciar();
            Arquivo.salvarPontuacao("pontuacoes.txt", jogo.getPontuacao());
        } catch (IOException e) {
            System.err.println("Erro ao ler ou escrever arquivos: " + e.getMessage());
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
                    try{
                        GerenciadorPlayers.salvarPlayer(player);
                        GerenciadorPlayers.mostrarLista();
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar player: " + e.getMessage());
                    }
                        break;
                        case 2:
                        
                            break;

                        case 3:
                        GerenciadorPlayers.apagarPlayer(null);
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
                    
                    break;
                    
                    case 0:
                    System.exit(0);
                    break;
                    
                    default:
                    break;
                }
        }

    }
    





