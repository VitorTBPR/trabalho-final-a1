package controller;
import java.util.List;

import model.Pergunta;
import model.Player;
import view.Console;

public class JogoTrivia {
    private List<Pergunta> perguntas;
    private int pontuacao;
    private Player jogador;

    public JogoTrivia(List<Pergunta> perguntas, Player jogador) {
        this.perguntas = perguntas;
        this.pontuacao = 0;
        this.jogador = jogador;
    }

    public void iniciar() {
        for (Pergunta pergunta : perguntas) {
            System.out.println(pergunta.getEnunciado());
            char op = 'A';
            for (String opcao : pergunta.getOpcoes()) {
                System.out.println(op + ": " + opcao);
                op++;
            }
            char resposta = Console.lerString("Sua resposta ").toUpperCase().charAt(0);

            if (resposta == pergunta.getRespostaCorreta()) {
                System.out.println("Correto!\n");
                pontuacao++;
            } else {
                System.out.println("Errado! Resposta incorreta");
            }
        }
        System.out.println("Jogo terminado! Sua pontuação: " + pontuacao);
        if (pontuacao > jogador.getPontuacao()) {
            jogador.setPontuacao(pontuacao);
            try {
                GerenciadorPlayers.salvarPontuacao(jogador);
            } catch (Exception e) {
                System.err.println("Erro ao salvar pontuação do jogador: " + e.getMessage());
            }
        }
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public Player getJogador() {
        return jogador;
    }
}
