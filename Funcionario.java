package trabalho_final;

public class Funcionario {
    protected int id;
    protected String nome;
    protected String dataContratacao;
    protected int idade;
    protected double salario;
    protected String cargo;

    public Funcionario(int id, String nome, String dataContratacao, int idade, double salario, String cargo) {
        this.id = id;
        this.nome = nome;
        this.dataContratacao = dataContratacao;
        this.idade = idade;
        this.salario = salario;
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public int getIdade() {
        return idade;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
