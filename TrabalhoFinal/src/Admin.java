import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Admin extends Player {
    private String id;

    public Admin(String nome, String senha) {
        super(nome, senha);
        this.id = gerarID();
    }
    
    public static void cadastrarPergunta() {
        System.out.println("Cadastro de nova pergunta");
        String enunciado = (Console.lerString("Enunciado: "));

        String[] opcoes = new String[4];
        for (int i = 0; i < 4; i++) {
            opcoes[i] = Console.lerString("Opção " + (char) ('A' + i) + ": ");
        }

        char respostaCorreta = Console.lerString("Resposta correta (A/B/C/D): ").toUpperCase().charAt(0);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("perguntas.txt", true))) {
            writer.write(enunciado);
            writer.newLine();
            for (String opcao : opcoes) {
                writer.write(opcao);
                writer.newLine();
            }
            writer.write(respostaCorreta);
            writer.newLine();
            System.out.println("Pergunta cadastrada com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar pergunta: " + e.getMessage());
        }
     }

    public String getID() {
        return id;
    }

    private String gerarID() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 11; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    

    
    @Override
    public String toString() {
        return id + "," + getNome() + "," + getSenha() + "," + getPontuacao();
    }

    public static Admin fromString(String adminDados){
        String[] parts = adminDados.split(",");
        Admin admin = new Admin(parts[1], parts[2]);
        admin.id = parts[0];
        admin.setPontuacao(Integer.parseInt(parts[3]));
        return admin;
    }

}

