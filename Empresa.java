package trabalho_final;
import java.util.Vector;
import java.util.Scanner;

public abstract class Empresa {
    protected static int contador_id = 0;
    protected String proprietario;
    protected String cnpj;
    protected String dataCriacao;
    protected Vector<Funcionario> funcionarios;
    protected String nomeFantasia;
    protected String razaoSocial;

    public Empresa(String proprietario, String cnpj, String dataCriacao, String nomeFantasia, String razaoSocial) {
        this.proprietario = proprietario;
        this.cnpj = cnpj;
        this.dataCriacao = dataCriacao;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.funcionarios = new Vector<>();
    }

    public String getProprietario() {
        return proprietario;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public Vector<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setFuncionarios(Vector<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public double calcularFolhaSalarial() {
        double totalSalarios = 0.0;
        for (Funcionario f : this.funcionarios) {
            totalSalarios += f.salario;
        }
        return totalSalarios;
    }

    public void inserirFuncionario() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Insira o nome do funcionário: ");
        String nome = sc.nextLine();

        System.out.print("Data de contratação (dd/mm/aa): ");
        String dataCont = sc.nextLine();

        System.out.print("Idade do funcionário: ");
        int idade = sc.nextInt();

        System.out.print("Salário do funcionário: ");
        double salario = sc.nextDouble();

        sc.nextLine();

        System.out.print("Cargo: ");
        String cargo = sc.nextLine();

        System.out.println();
        Funcionario f = new Funcionario(contador_id, nome, dataCont, idade, salario, cargo);
        this.funcionarios.add(f);
        contador_id++;
    }

    public void imprimirFuncionarios() {
        boolean listaVazia = true;

        for (Funcionario f : this.getFuncionarios()) {
            System.out.println("ID: " + f.getId() + " | Nome: " + f.getNome() + " | Contratação: " + f.getDataContratacao() +
                    " | Idade: " + f.getIdade() + " anos | Salário: R$" + f.getSalario() + " | Cargo: " + f.getCargo());
            listaVazia = false;
        }

        if (listaVazia) System.out.println("Nenhum funcionário cadastrado.");
    }

    public boolean excluirFuncionario(int id) {
        return this.funcionarios.removeIf(funcionario -> funcionario.id == id);
    }

    public void povoarListaFuncionarios(int qtdFuncionarios) {
        for (int i = 0; i < qtdFuncionarios; i++) {
            String nome = "Funcionário " + i;

            this.funcionarios.add(new Funcionario(contador_id, nome, "01/01/2020", 30, 5000, "Assistente"));
            contador_id++;
        }
    }
}
