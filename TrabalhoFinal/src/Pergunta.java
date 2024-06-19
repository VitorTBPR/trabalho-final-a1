
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

    

    
    
}