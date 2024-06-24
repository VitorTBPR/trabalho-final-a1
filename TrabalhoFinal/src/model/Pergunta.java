package model;
import view.Console;

public class Pergunta {
    private String enunciado;
    private String[] opcoes;
    private char respostaCorreta;
    
    public Pergunta(String enunciado, String[] opcoes, char respostaCorreta) {
        this.enunciado = enunciado;
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String[] getOpcoes() {
        return opcoes;
    }

    public char getRespostaCorreta() {
        return respostaCorreta;
     }

     public static Pergunta novaPerguntaDoConsole() {
        String enunciado = Console.lerString("Informe o enunciado da pergunta");
        String[] opcoes = new String[4];
        for (int i = 0; i < 4; i++) {
            opcoes[i] = Console.lerString("Informe a opção " + (char)('A' + i));
        }
        char respostaCorreta = Console.lerString("Informe a letra da resposta correta").toUpperCase().charAt(0);
        return new Pergunta(enunciado, opcoes, respostaCorreta);
    }

}