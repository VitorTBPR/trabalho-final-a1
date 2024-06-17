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

    public static Player fromString(String playerData) {
        String[] parts = playerData.split(",");
        return new Player(parts[0], parts[1]);
    }
}
