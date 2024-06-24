import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorAdmins {
    private static List<Admin>listaAdmins = new ArrayList<>();

    static {
        listaAdmins = carregarAdmins();
    }

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

    public static void apagarAdmin(String nome, String senha) throws IOException {
        Admin admin = buscarAdmin(nome, senha);
        if(admin!=null){
            listaAdmins.remove(admin);
            salvarAdmins();
             System.out.println("Admin removido");
        }
    }

    public static void autenticarAdmin() throws IOException {
        String nome = Console.lerString("Informe o nome do admin: ");
        String senha = Console.lerString("Informe a senha do admin: ");
        Admin admin = buscarAdmin(nome, senha);
        if (admin != null) {
            Sistema.opcoesAdmins();
        } else {
            System.out.println("Nome ou senha incorretos. Acesso negado.");
        }
    }

    private static boolean adminPadraoExiste() {
        for (Admin admin : listaAdmins) {
            if (admin.getNome().equals("admin")) {
                return true;
            }
        }
        return false;
    }

    
    static void inicializarAdminPadrao() {
        if (!adminPadraoExiste()) {
            Admin adminPadrao = new Admin("admin", "admin123");
            try {
                adicionarAdmin(adminPadrao);
            } catch (IOException e) {
                System.err.println("Erro ao adicionar o administrador padrão: " + e.getMessage());
            }
        }
    }
}
