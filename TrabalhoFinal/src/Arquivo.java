import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
    //Perguntas
    public static List<Pergunta> carregarPerguntas(String caminhoArquivo) throws IOException{
        List<Pergunta> perguntas = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))){
            String linha;
            while ((linha = reader.readLine()) != null) {
                String enunciado = linha;
                String[] opcoes = new String[4];
                for (int i = 0; i < 4; i++){
                    opcoes[i] = reader.readLine();
                }
                char respostaCorreta = reader.readLine().charAt(0);
                perguntas.add(new Pergunta(enunciado, opcoes, respostaCorreta));
                
            }
        }
        return perguntas;
    }
    
    public static void salvarPontuacao(String caminhoArquivo, int pontuacao) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))){
            writer.write("Pontuação: "+pontuacao);
            writer.newLine();
        }
    }

    //Player
    public static List<Player> carregarPlayers(String caminhoArquivo) throws IOException {
        List<Player> players = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                players.add(Player.fromString(linha));
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


