public class Sistema {

    public static void executarSistema(){

        while (true) {
            menu();
            int op = Console.lerInt("Informe uma opção");
            verificarOpcao(op);
        }

    }

    public static void menu() {
        System.out.println("---- Bem vindo ao jogo de trivia ----");
        System.out.println("1) Iniciar jogo");
        System.out.println("2) Cadastrar player");
        System.out.println("3) Players");
        System.out.println("4) Exibir scoreboard ");

    }

    public static void verificarOpcao(int op){
        switch (op) {
            
            case 1:
                
                break;
            
            case 2:
            
                break;
            
            case 3:
            
                break;
            
            case 4:
                
                break;
            
            default:
                break;
        }

    }
    
    public static void players(){
        System.out.println("1) Cadastrar novo player");
        System.out.println("2) Editar player");
        System.out.println("3) Excluir player");
        System.out.println("4) Listar todos os players");
 }

}



