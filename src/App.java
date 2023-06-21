import java.io.BufferedReader;
import java.io.FileReader;
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
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
            writer.println(stringToSave);
            writer.close();

            return 0; // Caso ela seja salva com sucesso, a funçãl retorna 0;
        } catch (IOException e) {
            System.out.println("ERRO: Não foi possível salvar no arquivo -> " + e.getMessage());
            return 1; // Caso haja algum problema ao salvar, esse problema é exibido e a função retorna 1;
        }
    }

    // Função para procurar algo específico em um arquivo:
    public static String LookInFile(String fileName, String valueFinder, int indice) {
        int verif = 0;
        String StringToReturn = "";
        try {
            FileReader fileScan = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileScan);
            String linha;
            
            while ((linha = bufferedReader.readLine()) != null) {
                String[] Part = linha.split(";");
                String[] partFrom = Part[indice].split(": ");

                if (partFrom[1].equals(valueFinder)) {
                    StringToReturn += (linha + "|");
                    verif = 1;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("ERRO: Não foi possível ler do arquivo -> " + e.getMessage());
        }
        if(verif == 0){
            StringToReturn = "-1";
        }

        return StringToReturn;
    }

    // Função para gerar uma ID (falta fazer/melhorar):
    public static int idGenerator() {
        // Por enquanto é gambiarra: (tem que arrumar a função para ela percorrer o arquivo procurando uma ID livre)
        return (int) (Math.random() * 99999);
    }

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int rUserL1, rUserL2, rUserL3;
        String lineAux;
        String[] dataConversor;
        Data newData;
        String Finder;

        clearScreen();
        do {
            System.out.print("O=====================O\n| Sistema CRUD_SCHOOL |\nO=====================O\n| [1] Cadastrar.      |\n| [2] Visualizar.     |\n| [3] Editar.         |\n| [4] Deletar.        |\n| [5] Sair.           |\nO=====================O\n\nR: ");
            rUserL1 = Integer.parseInt(scan.nextLine());

            switch (rUserL1) {
                case 1:
                    do {
                        clearScreen();
                        System.out.print("O==============================O\n| O que você deseja cadastrar? |\nO==============================O\n| [1] Professor.               |\n| [2] Aluno.                   |\n| [3] Sala.                    |\n| [4] Voltar.                  |\nO==============================O\n\nR: ");
                        rUserL2 = Integer.parseInt(scan.nextLine());

                        switch (rUserL2) {
                            case 1:
                                clearScreen();
                                System.out.print("O===========================================O\n| Você escolheu [1] cadastrar um Professor. |\nO===========================================O\n");
                                Professor newTeacher = new Professor();

                                // Pegando valores para salvar:

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

                                // Salvando o novo professor no arquivo:
                                SaveInFile("./data/ProfessorBd.txt", ((
                                    "Nome do professor: " + newTeacher.getNome() + 
                                    ";Email do professor: " + newTeacher.getEmail() + 
                                    ";CPF do professor: " + newTeacher.getCPF() + 
                                    ";Nascimento: " + dataConversor[0] + "/" + dataConversor[1] + "/" + dataConversor[2] + 
                                    ";ID do professor: " + newTeacher.getId()
                                )) + ";" + "1");
                                break;

                            case 2:
                                clearScreen();
                                System.out.print("O=======================================O\n| Você escolheu [2] cadastrar um Aluno. |\nO=======================================O\n");
                                Aluno newStudent = new Aluno();

                                // Pegando valores para salvar:

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

                                // Salvando o novo Aluno no arquivo:
                                SaveInFile("./data/AlunoBd.txt", ((
                                    "Nome do aluno: " + newStudent.getNome() + 
                                    ";Email do aluno: " + newStudent.getEmail() + 
                                    ";CPF do aluno: " + newStudent.getCPF() +
                                    ";Nascimento: " + dataConversor[0] + "/" + dataConversor[1] + "/" + dataConversor[2] +
                                    ";Id do aluno: " + newStudent.getId()
                                )) + ";" + "1");
                                break;

                            case 3:
                                clearScreen();
                                System.out.print("O=======================================O\n| Você escolheu [3] cadastrar uma sala. |\nO=======================================O\n");
                                Sala newClassroom = new Sala();

                                // Salvando o número da sala:
                                System.out.print("\nDigite o número da nova sala.\nR: ");
                                newClassroom.setNum(Integer.parseInt(scan.nextLine()));

                                // Salvando o ID da sala:
                                newClassroom.setId(idGenerator());

                                // Salvando a sala no arquivo:
                                SaveInFile("./data/SalaDb.txt", ((
                                    "Número da sala: " + newClassroom.getNum() 
                                    + ";ID da sala: " + newClassroom.getId()
                                ) + ";" + "1"));
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
                    } while (rUserL2 != 4);
                    break;

                case 2:
                    do {
                        clearScreen();
                        System.out.print("O===============================O\n| O que você deseja Visualizar? |\nO===============================O\n| [1] Professor.                |\n| [2] Aluno.                    |\n| [3] Sala.                     |\n| [4] Voltar.                   |\nO===============================O\n\nR: ");
                        rUserL2 = Integer.parseInt(scan.nextLine());

                        switch (rUserL2) {
                            case 1:
                                do {
                                    clearScreen();
                                    System.out.print("O========================================O\n| Você escolheu [1] Visualizar Professor |\nO========================================O\n|   Digite como você deseja visualizar   |\nO----------------------------------------+\n| [1] Procurar por Nome do professor.    |\n| [2] Procurar por Email do professor.   |\n| [3] Procurar por CPF do professor.     |\n| [4] Procurar por Data de nascimento.   |\n| [5] Procurar por ID do professor.      |\n| [6] Visualizar todos os Professores.   |\n| [7] Voltar.                            |\n+----------------------------------------+\nO========================================O\n\nR: ");
                                    rUserL3 = Integer.parseInt(scan.nextLine());

                                    if (rUserL3 >= 1 && rUserL3 <= 6) {
                                        rUserL3--;

                                        if(rUserL3!=5){
                                            System.out.print("\nDigite o valor que você quer encontrar.\nR: ");
                                            Finder = scan.nextLine();
                                        }else{
                                            Finder = "1";
                                        }
                                        
                                        lineAux = LookInFile("./data/ProfessorBd.txt", Finder, rUserL3);
                                        
                                        if(lineAux.equals("-1")){
                                            System.out.println("\n\nDados não encontrados!");
                                        }else{
                                            System.out.println(lineAux.replace("|", "\n\n").replace(";", "\n"));
                                        }
                                        pauseScreen();
                                    } else if (rUserL3!=7){
                                        System.out.println("\nValor inválido. escolha entre 1 e 6.");
                                        pauseScreen();
                                    }
                                } while (rUserL3 != 7);

                                break;

                            case 2:
                                do {
                                    clearScreen();
                                    System.out.print("O========================================O\n|   Você escolheu [2] Visualizar Aluno   |\nO========================================O\n|   Digite como você deseja visualizar   |\n+----------------------------------------+\n| [1] Procurar por Nome do Aluno.        |\n| [2] Procurar por Email do Aluno.       |\n| [3] Procurar por CPF do Aluno.         |\n| [4] Procurar por Data de nascimento.   |\n| [5] Procurar por ID do Aluno.          |\n| [6] Visualizar todos os Aluno.         |\n| [7] Voltar.                            |\n+----------------------------------------+\nO========================================O\n\nR: ");
                                    rUserL3 = Integer.parseInt(scan.nextLine());

                                    if (rUserL3 >= 1 && rUserL3 <= 6) {
                                        rUserL3--;

                                        if(rUserL3!=5){
                                            System.out.print("\nDigite o valor que você quer encontrar.\nR: ");
                                            Finder = scan.nextLine();
                                        }else{
                                            Finder = "1";
                                        }

                                        lineAux = LookInFile("./data/ProfessorBd.txt", Finder, rUserL3);

                                        if(lineAux.equals("-1")){
                                            System.out.println("\n\nDados não encontrados!");
                                        }else{
                                            System.out.println(lineAux.replace("|", "\n\n").replace(";", "\n"));
                                        }
                                        pauseScreen();
                                    } else if (rUserL3!=7){
                                        System.out.println("\nValor inválido. escolha entre 1 e 6.");
                                        pauseScreen();
                                    }
                                } while (rUserL3 != 7);
                                break;

                            case 3:
                                do {
                                    clearScreen();
                                    System.out.print("O========================================O\n|   Você escolheu [3] Visualizar Sala    |\nO========================================O\n|   Digite como você deseja visualizar   |\n+----------------------------------------+\n| [1] Procurar por Número da sala.       |\n| [2] Procurar por ID da Sala.           |\n| [3] Visualizar todas as salas.         |\n| [4] Voltar.                            |\n+----------------------------------------+\nO========================================O\n\nR: ");
                                    rUserL3 = Integer.parseInt(scan.nextLine());

                                    if (rUserL3 >= 1 && rUserL3 <= 3) {
                                        rUserL3--;

                                        if(rUserL3!=2){
                                            System.out.print("\nDigite o valor que você quer encontrar.\nR: ");
                                            Finder = scan.nextLine();
                                        }else{
                                            Finder = "1";
                                        }

                                        lineAux = LookInFile("./data/ProfessorBd.txt", Finder, rUserL3);

                                        if(lineAux.equals("-1")){
                                            System.out.println("\n\nDados não encontrados!");
                                        }else{
                                            System.out.println("\n" + lineAux.replace("|", "\n\n").replace(";", "\n"));
                                        }
                                        pauseScreen();
                                    } else if (rUserL3!=4){
                                        System.out.println("\nValor inválido. escolha entre 1 e 4.");
                                        pauseScreen();
                                    }
                                } while (rUserL3 != 4);
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
                    } while (rUserL2 != 4);
                    break;

                case 3:
                    do {
                        clearScreen();
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
                    } while (rUserL2 != 4);
                    break;

                case 4:
                    do {
                        clearScreen();
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
                    } while (rUserL2 != 4);
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
        } while (rUserL1 != 5);

        scan.close();
    }
}
