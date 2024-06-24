package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.Player;

public class GerenciadorPlayers {
    private static List<Player> listaPlayers = new ArrayList<>();

    static {
        try {
            listaPlayers = Arquivo.carregarPlayers(Arquivo.PLAYERS);
        } catch (IOException e) {
            System.err.println("Erro ao carregar players: " + e.getMessage());
        }
    }

    public static void cadastrarPlayers(Player player) throws IOException {
        Arquivo.criarArquivoSeNaoExistir("players.txt");
        for (Player p : listaPlayers) {
            if (p.getNome().equals(player.getNome())) {
                System.out.println("Já existe um player com o nome '" + player.getNome() + "'.");
                return; 
            }
        }
        listaPlayers.add(player);
        Arquivo.salvarPlayers(Arquivo.PLAYERS, listaPlayers);
    }

    public static void salvarPontuacao(Player player) throws IOException {
        for (Player p : listaPlayers) {
            if (p.getNome().equals(player.getNome())) {
                if (player.getPontuacao() > p.getPontuacao()) {
                    p.setPontuacao(player.getPontuacao());
                }
                Arquivo.salvarPlayers(Arquivo.PLAYERS, listaPlayers);
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
            System.out.println("Jogador removido");
        } catch (Exception e) {
            System.out.println("Player não encontrado");
        }
    }

    public static void editarPlayer(String nomeAntigo, String novoNome, String novaSenha) throws IOException{
       try {
           Player player = buscarPlayer(nomeAntigo);
           player.setNome(novoNome);
           player.setSenha(novaSenha);
           Arquivo.salvarPlayers(Arquivo.PLAYERS, listaPlayers);
           System.out.println("Jogador editado com sucesso");
       } catch (Exception e) {
        System.out.println("Erro ao editar jogador: "+e.getMessage());
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
        listaPlayers.sort(Comparator.comparingInt(Player::getPontuacao).reversed());
        System.out.println("\n---- Scoreboard ----");
        for (Player player : listaPlayers) {
            System.out.println(player.getNome() + ": " + player.getPontuacao());
        }
    }
}
