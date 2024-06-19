import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GerenciadorPlayers {
    private static List<Player> listaPlayers = new ArrayList<>();
    
    public static void cadastrarPlayers(Player player) throws IOException{
        Arquivo.criarPlayersSeNaoExistir();
        List<Player> players = Arquivo.carregarPlayers(Arquivo.PLAYERS);
       for (Player p : players) {
        if (p.getNome().equals(player.getNome())) {
            System.out.println("Já existe um player com o nome '" + player.getNome() + "'.");
            return; 
        }
    }
    players.add(player);
    listaPlayers = players;
    Arquivo.salvarPlayers(Arquivo.PLAYERS, players);
} 

public static void salvarPontuacao(Player player) throws IOException {
    List<Player> players = Arquivo.carregarPlayers(Arquivo.PLAYERS);
    for (Player p : players) {
        if (p.getNome().equals(player.getNome())) {
            if (player.getPontuacao() > p.getPontuacao()) {
                p.setPontuacao(player.getPontuacao());
            }
            Arquivo.salvarPlayers(Arquivo.PLAYERS, players);
            return;
        }
    }
}
    
public static void verificarListaVazia() throws Exception {
        if (listaPlayers.isEmpty()) {
            throw new Exception("\nNão há players cadastrados");
        }
    }

    public static Player buscarPlayer(String nome) throws Exception {
        for (Player tempPlayer : listaPlayers) {
            if (tempPlayer.getNome().equals(nome)) {
                return tempPlayer;
            }
        }
        throw new Exception("Player " + nome + " não encontrado");
    }

    public static void apagarPlayer(String nome) throws IOException {
        try {
            Player player = buscarPlayer(nome);
            listaPlayers.remove(player);
            Arquivo.salvarPlayers(Arquivo.PLAYERS, listaPlayers);
        } catch (Exception e) {
            System.out.println("Player não encontrado");
        }
    } 

    

    public static void mostrarLista() {
        if (listaPlayers.isEmpty()) {
            System.out.println("Não há jogadores cadastrados.");
        } else {
            System.out.println("Lista de jogadores:");
            for (Player player : listaPlayers) {
                System.out.println("Nome: " + player.getNome());
            }
        }
    }

    public static void exibirScoreboard() throws IOException {
        List<Player> players = Arquivo.carregarPlayers(Arquivo.PLAYERS);
        players.sort(Comparator.comparingInt(Player::getPontuacao).reversed());
        System.out.println("\n---- Scoreboard ----");
        for (Player player : players) {
            System.out.println(player.getNome() + ": " + player.getPontuacao());
        }
    }
 
}