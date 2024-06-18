import java.util.List;

public class JogoTrivia {
    private List<Pergunta> perguntas;
    private int pontuacao;

    public JogoTrivia(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
        this.pontuacao = 0;
    }

    public void iniciar() {
        for (Pergunta pergunta : perguntas) {
            System.out.println(pergunta.getEnunciado());
            char op = 'A';
            for (String opcao : pergunta.getOpcoes()) {
                System.out.println(op + ": " + opcao);
                op++;
            }
            System.out.print("Sua resposta: ");
            char resposta = Console.lerString(null).toUpperCase().charAt(0); //Garantir que a entrada do usuário seja tratada de forma consistente, independentemente de o usuário digitar em maiúsculas ou minúsculas.

            if (resposta == pergunta.getRespostaCorreta()) {
                System.out.println("Correto!");
                pontuacao++;
            } else {
                System.out.println("Errado! Resposta incorreta");
            }
        }
        System.out.println("Jogo terminado! Sua pontuação: " + pontuacao);
        return;
    }

    public int getPontuacao() {
        return pontuacao;
    }
}
