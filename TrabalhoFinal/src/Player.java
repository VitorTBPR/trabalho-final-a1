
public class Player {
    private String nome;
    private String senha;
    private int pontuacao;

    public Player(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    @Override
    public String toString() {
        return nome + "," + senha;
    }


    public static Player fromString(String playerDados) {
        String[] parts = playerDados.split(",");
        return new Player(parts[0], parts[1]);
    }


}
