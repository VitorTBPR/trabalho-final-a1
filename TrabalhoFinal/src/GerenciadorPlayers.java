import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorPlayers {
    private static List<Player> listaPlayers = new ArrayList<>();

    static {
        try {
            listaPlayers = Arquivo.carregarPlayers(Arquivo.PLAYERS);
        } catch (IOException e) {
            System.err.println("Erro ao carregar players do arquivo: " + e.getMessage());
        }
    }

    public static void salvarPlayer(Player player) throws IOException {
        Arquivo.criarPlayersSeNaoExistir();
        listaPlayers.add(player);
        Arquivo.salvarPlayers(Arquivo.PLAYERS, listaPlayers);
    }

    public static void mostrarLista() {
        if (listaPlayers.isEmpty()) {
            System.out.println("Nenhum player cadastrado.");
        } else {
            System.out.println("Lista de Players:");
            for (Player player : listaPlayers) {
                System.out.println("Nome: " + player.getNome());
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
            if (tempPlayer.getNome().equalsIgnoreCase(nome)) {
                return tempPlayer;
            }
        }
        throw new Exception("Player " + nome + " não encontrado");
    }

    public static void apagarPlayer(String nome) throws IOException {
        Player player = buscarPlayer(nome);
        listaPlayers.remove(player);
        Arquivo.salvarPlayers(Arquivo.PLAYERS, listaPlayers);
    }
}
