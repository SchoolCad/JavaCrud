import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

    // Função para salvar em arquivo:
    public static int SaveInFile(String fileName, String stringToSave) {
        try
        {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
            writer.println(stringToSave);
            writer.close();

            return 0; // Caso ela seja salva com sucesso, a funçãl retorna 0;
        } catch (IOException e)
        {
            System.out.println("ERRO: Não foi possível salvar no arquivo -> " + e.getMessage());
            return 1; // Caso haja algum problema ao salvar, esse problema é exibido e a função retorna 1;
        }
    }

    
    // Função para gerar uma ID:
    public static int idGenerator(){
        /*
        // Declara uma variável de verificação e um cont.
        int verif, cont = 0;
        // A função testa para achar um valor que seja igual à algum Id.
        do
        {
            verif = 0;
            for ()
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

        return cont; // Quando a função acha um valor para o novo Id, esse valor é retornado par a main. */

        // Por enquanto é gambiarra: (tem que arrumar a função para ela percorrer um arquivo procurando uma ID livre)
        return (int) (Math.random() * 99999);
    }

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int rUserL1, rUserL2;
        String[] dataConversor;
        Data newData;

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
                                System.out.print("O===========================================O\n| [1] Você escolheu cadastrar um Professor. |\nO===========================================O\n");
                                Professor newTeacher = new Professor();

                                //Pegando valores para salvar:

                                // Salvando o nome do novo professor:
                                System.out.print("\nDigite o Nome do novo professor.\nR: ");
                                newTeacher.setNome(scan.nextLine());

                                // Salvando o email do novo professor:
                                System.out.print("\nDigite o Email do novo professor.\nR: ");
                                newTeacher.setEmail(scan.nextLine());

                                // Salvando o CPF do novo professor:
                                System.out.print("\nDigite o CPF do novo professor.\nR: ");
                                newTeacher.setCPF(scan.nextLine());

                                // Salvando a data de nascimento do novo professor:
                                System.out.print("\nDigite a data de nascimento do professor. [DD/MM/AAAA]\nR: ");

                                // Convertendo a string DD/MM/AAA para inteiros:
                                dataConversor = scan.nextLine().split("/");

                                newData = new Data();

                                newData.setDia(Integer.parseInt(dataConversor[0]));
                                newData.setMes(Integer.parseInt(dataConversor[1]));
                                newData.setAno(Integer.parseInt(dataConversor[2]));

                                newTeacher.setNascimento(newData);
                                
                                // Gerando a ID para o novo professor:
                                newTeacher.setId(idGenerator());

                                //Salvando o novo professor no arquivo:
                                SaveInFile("ProfessorBd.txt", (newTeacher.getNome() + ";" + newTeacher.getEmail() + ";" + newTeacher.getCPF() + ";" + dataConversor[0] + "/" + dataConversor[1] + "/" + dataConversor[2] + ";" + newTeacher.getId()));
                            break;

                            case 2:
                                clearScreen();
                                System.out.print("O=======================================O\n| [1] Você escolheu cadastrar um Aluno. |\nO=======================================O\n");
                                Aluno newStudent = new Aluno();

                                //Pegando valores para salvar:

                                // Salvando o nome do novo Aluno:
                                System.out.print("\nDigite o Nome do novo Aluno.\nR: ");
                                newStudent.setNome(scan.nextLine());

                                // Salvando o email do novo Aluno:
                                System.out.print("\nDigite o Email do novo Aluno.\nR: ");
                                newStudent.setEmail(scan.nextLine());

                                // Salvando o CPF do novo Aluno:
                                System.out.print("\nDigite o CPF do novo Aluno.\nR: ");
                                newStudent.setCPF(scan.nextLine());

                                // Salvando a data de nascimento do novo Aluno:
                                System.out.print("\nDigite a data de nascimento do Aluno. [DD/MM/AAAA]\nR: ");

                                // Convertendo a string DD/MM/AAA para inteiros:
                                dataConversor = scan.nextLine().split("/");

                                newData = new Data();

                                newData.setDia(Integer.parseInt(dataConversor[0]));
                                newData.setMes(Integer.parseInt(dataConversor[1]));
                                newData.setAno(Integer.parseInt(dataConversor[2]));

                                newStudent.setNascimento(newData);
                                
                                // Gerando a ID para o novo Aluno:
                                newStudent.setId(idGenerator());

                                //Salvando o novo Aluno no arquivo:
                                SaveInFile("AlunoBd.txt", (newStudent.getNome() + ";" + newStudent.getEmail() + ";" + newStudent.getCPF() + ";" + dataConversor[0] + "/" + dataConversor[1] + "/" + dataConversor[2] + ";" + newStudent.getId()));
                            break;

                            case 3:
                                clearScreen();
                                System.out.print("O=======================================O\n| [1] Você escolheu cadastrar uma sala. |\nO=======================================O\n");

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
