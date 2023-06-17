public class Professor {
    private String nome;     // Nome do professor;
    private String email;    // Email do professor;
    private String CPF;      // CPF do professor;
    private Data nascimento; // Data de nascimento do professor;
    private int id;          // Id do professor;


    // Criando métodos para pegar/inserir dados:
    // Funções de pegar:
    // Pegar ID:
    public int getId() {
        return id;
    }

    // Pegar CPF:
    public String getCPF() {
        return CPF;
    }

    // Pegar Nome:
    public String getNome() {
        return nome;
    }

    // Pegar email:
    public String getEmail() {
        return email;
    }

    // Pegar Data de nascimento:
    public Data getNascimento() {
        return nascimento;
    }


    // Funções de inserir:
    // Inserindo ID:
    public void setId(int id) {
        this.id = id;
    }

    // Inserir CPF:
    public void setCPF(String CPF){
        this.CPF = CPF;
    }

    // Inserir Nome:
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Inserir Email:
    public void setEmail(String email) {
        this.email = email;
    }

    // Inserir Data de nascimento:
    public void setNascimento(Data nascimento) {
        this.nascimento = nascimento;
    }
}
