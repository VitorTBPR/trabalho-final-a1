import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
    public static final String PLAYERS = "players.txt";
    public static final String ADMINS = "admins.txt";

    public static void criarPlayersSeNaoExistir() {
        File arquivo = new File(PLAYERS);
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void criarAdminsSeNaoExistir() {
        File arquivo = new File(ADMINS);
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static List<Pergunta> carregarPerguntas(String caminhoArquivo) throws IOException {
        List<Pergunta> perguntas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String enunciado = linha;
                String[] opcoes = new String[4];
                for (int i = 0; i < 4; i++) {
                    opcoes[i] = reader.readLine();
                }
                char respostaCorreta = reader.readLine().charAt(0);
                perguntas.add(new Pergunta(enunciado, opcoes, respostaCorreta));
            }
        }
        return perguntas;
    }

    public static void salvarPontuacao(String caminhoArquivo, int pontuacao) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            writer.write("Pontuação: " + pontuacao);
            writer.newLine();
        }
    }

    public static List<Player> carregarPlayers(String caminhoArquivo) throws IOException {
        List<Player> players = new ArrayList<>();
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) {
            criarPlayersSeNaoExistir();
            return players;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                try {
                    players.add(Player.fromString(linha));
                } catch (Exception e) {
                    System.err.println("Formato inválido na linha: " + linha);
                }
            }
        }
        return players;
    }

    public static void salvarPlayers(String caminhoArquivo, List<Player> players) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Player player : players) {
                writer.write(player.toString());
                writer.newLine();
            }
        }
    }
}
