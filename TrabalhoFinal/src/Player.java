import java.util.ArrayList;

public class Player {
    private String nome;
    private String senha;

    public Player(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return nome + "," + senha;
    }

    public static Player fromString(String playerDados) {
        String[] parts = playerDados.split(",");
        return new Player(parts[0], parts[1]);
    }
    

    private static ArrayList<Player> listaPlayers = new ArrayList<>();

    public static void salvarPlayer(Player player) {
        listaPlayers.add(player);
    }

    public static ArrayList<Player> getListaPlayers() {
        return listaPlayers;
    }

    public static void verificarListaVazia() throws Exception {

        if (listaPlayers.isEmpty()) {
            throw new Exception("\nNão há players cadastrados");
        }

    }

    public static Player buscarPlayer(String nome) throws Exception {

        for(Player tempPlayer : listaPlayers) {

            if (tempPlayer.getNome().contains(nome)) {
                return tempPlayer;
            }
        }

        throw new Exception("Player " + nome + " não encontrado");
    }

    public static void apagarPlayer(Player player) {
        listaPlayers.remove(player);
    }

}
