import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorAdmins {
    private static List<Admin>listaAdmins = new ArrayList<>();

    public static void adicionarAdmin(Admin admin) throws IOException {
        listaAdmins.add(admin);
        salvarAdmins();
    }

    public static List<Admin> carregarAdmins() {
        List<Admin> listaAdmins = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Arquivo.ADMINS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                listaAdmins.add(Admin.fromString(linha));
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar admins: " + e.getMessage());
        }
        return listaAdmins;
    }

    public static void salvarAdmins() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Arquivo.ADMINS))) {
            for (Admin admin : listaAdmins) {
                writer.write(admin.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar admins: " + e.getMessage());
        }
    }

    public static Admin buscarAdmin(String nome, String senha) {
        for (Admin admin : listaAdmins) {
            if (admin.getNome().equals(nome) && admin.getSenha().equals(senha)) {
                return admin;
            }
        }
        return null;
    }
}
