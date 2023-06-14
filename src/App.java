import java.io.IOException;
import java.util.Scanner;

public class App {

    // Função para limpar a tela no linux e no windows:
    public static void clearScreen() throws InterruptedException, IOException {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.print("\033[H\033[2J");
        }
    }
    
    // Função para pausar a tela:
    public static void pauseScreen() throws IOException {
        System.in.read();
    }

    /*
    // Função para gerar a ID (traduzida e reaproveitada de C):
    public static int idGenerator(String OBJ){
        // Declara uma variável de verificação e um cont.
        int verif, cont = 0;
        // A função testa para achar um valor que seja igual à algum Id.
        do
        {
            verif = 0;
            for (node *I = lista->inicio; I != NULL; I = I->proximo)
            {
                if (cont == I->UserNode.id)
                {
                    verif = 1;
                    break;
                }
            }
            if (verif == 1)
            { // Quando a função encontra um Id igual ao cont, o cont é incrementado.
                cont++;
            }
        } while (verif != 0); // Enquanto a função não encontrar um valor para cont, que seja diferente de todos os IDs, ela não para.

        return cont; // Quando a função acha um valor para o novo Id, esse valor é retornado par a main.
    }*/

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int rUserL1, rUserL2;

        clearScreen();
        do {
            System.out.print("O=====================O\n| Sistema CRUD_SCHOOL |\nO=====================O\n| [1] Cadastrar.      |\n| [2] Visualizar.     |\n| [3] Editar.         |\n| [4] Deletar.        |\n| [5] Sair.           |\nO=====================O\n\nR: ");
            rUserL1 = Integer.parseInt(scan.nextLine());

            switch (rUserL1) {
                case 1:
                    clearScreen();
                    do {
                        System.out.print("O==============================O\n| O que você deseja cadastrar? |\nO==============================O\n| [1] Professor.               |\n| [2] Aluno.                   |\n| [3] Sala.                    |\n| [4] Voltar.                  |\nO==============================O\n\nR: ");
                        rUserL2 = Integer.parseInt(scan.nextLine());

                        switch (rUserL2) {
                            case 1:
                                clearScreen();
                                
                            break;

                            case 2:
                                clearScreen();

                            break;

                            case 3:
                                clearScreen();

                            break;

                            case 4:
                                clearScreen();
                        
                            break;

                            default:
                                System.out.println("\nOpção inválida! escolha entre 1 e 4.");
                                pauseScreen();
                                clearScreen();
                            break;
                        }
                    } while (rUserL2!=4);
                break;

                case 2:
                    clearScreen();
                    do {
                        System.out.print("O===============================O\n| O que você deseja Visualizar? |\nO===============================O\n| [1] Professor.                |\n| [2] Aluno.                    |\n| [3] Sala.                     |\n| [4] Voltar.                   |\nO===============================O\n\nR: ");
                        rUserL2 = Integer.parseInt(scan.nextLine());

                        switch (rUserL2) {
                            case 1:
                                clearScreen();

                            break;

                            case 2:
                                clearScreen();

                            break;

                            case 3:
                                clearScreen();

                            break;

                            case 4:
                            clearScreen();
                        
                            break;
                            
                            default:
                                System.out.println("\nOpção inválida! escolha entre 1 e 4.");
                                pauseScreen();
                                clearScreen();
                            break;
                        }
                    } while (rUserL2!=4);
                break;

                case 3:
                    clearScreen();
                    do{
                        System.out.print("O===========================O\n| O que você deseja Editar? |\nO===========================O\n| [1] Professor.            |\n| [2] Aluno.                |\n| [3] Sala.                 |\n| [4] Voltar.               |\nO===========================O\n\nR: ");
                        rUserL2 = Integer.parseInt(scan.nextLine());

                        switch (rUserL2) {
                            case 1:
                                clearScreen();
                                
                            break;

                            case 2:
                                clearScreen();

                            break;

                            case 3:
                                clearScreen();

                            break;

                            case 4:
                                clearScreen();
                        
                            break;
                            
                            default:
                                System.out.println("\nOpção inválida! escolha entre 1 e 4.");
                                pauseScreen();
                                clearScreen();
                            break;
                        }
                    } while (rUserL2!=4);
                break;

                case 4:
                    clearScreen();
                    do{
                        System.out.print("O============================O\n| O que você deseja Deletar? |\nO============================O\n| [1] Professor.             |\n| [2] Aluno.                 |\n| [3] Sala.                  |\n| [4] Voltar.                |\nO============================O\n\nR: ");
                        rUserL2 = Integer.parseInt(scan.nextLine());

                        switch (rUserL2) {
                            case 1:
                                clearScreen();
                                
                            break;

                            case 2:
                                clearScreen();

                            break;

                                case 3:
                            clearScreen();

                            break;

                            case 4:
                                clearScreen();
                        
                            break;
                            
                            default:
                                System.out.println("\nOpção inválida! escolha entre 1 e 4.");
                                pauseScreen();
                                clearScreen();
                            break;
                        }
                    } while (rUserL2!=4);
                break;

                case 5:
                    System.out.println("\nVocê escolheu sair. até a próxima!");
                break;
            
                default:
                    System.out.println("\nOpção inválida! escolha entre 1 e 5.");
                    pauseScreen();
                    clearScreen();
                break;
            }
        } while (rUserL1!=5);

        scan.close();
    }
}
