public class Data {
    private int dia;
    private int mes;
    private int ano;

    // Construindo a classe data:
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    // Criando métodos para exibir/pegar dados:

    // Pegar dia:
    public int getDia() {
        return dia;
    }

    // Pegar mês:
    public int getMes() {
        return mes;
    }

    // Pegar Ano:
    public int getAno() {
        return ano;
    }

    // Criando métodos para inserir dados:
    
    // Inserir dia:
    public void setDia(int dia) {
        this.dia = dia;
    }

    // Inserir mês:
    public void setMes(int mes) {
        this.mes = mes;
    }

    // Inserir ano:
    public void setAno(int ano) {
        this.ano = ano;
    }
}
