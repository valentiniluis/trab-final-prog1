package trabalho_final;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDate;

public class LojaDeCalcado extends Empresa {
    private Funcionario gerente;
    private Endereco endereco;
    private HashMap<String, Double> valorVendidoMes;
    private HashMap<String, Double> valorVendidoAno;

    public LojaDeCalcado(String proprietario, String cnpj, String dataCriacao, String nomeFantasia,
                         String razaoSocial) {
        super(proprietario, cnpj, dataCriacao, nomeFantasia, razaoSocial);
        this.gerente = null;
        this.endereco = perguntarEndereco();
        this.valorVendidoMes = new HashMap<>();
        this.valorVendidoAno = new HashMap<>();
    }

    public LojaDeCalcado(String proprietario, String cnpj, String dataCriacao, Endereco endereco,
                         String nomeFantasia, String razaoSocial) {
        super(proprietario, cnpj, dataCriacao, nomeFantasia, razaoSocial);
        this.gerente = null;
        this.endereco = endereco;
        this.valorVendidoMes = new HashMap<>();
        this.valorVendidoAno = new HashMap<>();
    }

    public Endereco perguntarEndereco() {
        Endereco e = new Endereco();

        Scanner sc = new Scanner(System.in);

        System.out.print("Estado/UF da loja: ");
        e.setEstado(sc.nextLine());

        System.out.print("Cidade da loja: ");
        e.setCidade(sc.nextLine());

        System.out.print("Rua: ");
        e.setRua(sc.nextLine());

        System.out.print("Número: ");
        e.setNumero(sc.nextInt());

        return e;
    }

    public void atualizarGerente() {
        for (Funcionario f : this.funcionarios) {
            if (f.cargo.equals("Gerente")) {
                this.gerente = f;
                return;
            }
        }
        this.gerente = null;
    }

    public boolean atualizarCargo(int id, String novoCargo) {
        String cargoAntigo = "";
        boolean idValido = false;

        for (Funcionario f : this.getFuncionarios()) {
            if (f.getId() == id) {
                cargoAntigo = f.getCargo();
                f.setCargo(novoCargo);
                idValido = true;
            }
        }

        if (!cargoAntigo.isEmpty()) {
            if (cargoAntigo.equals("Gerente") || novoCargo.equals("Gerente")) this.atualizarGerente();
        }
        return idValido;
    }

    public void cadastrarVenda(double valor) {
        LocalDate data = LocalDate.now();
        String mesAno = data.getMonthValue() + "/" + data.getYear();

        if (this.valorVendidoMes.containsKey(mesAno)) {
            Double valorNovo = this.valorVendidoMes.get(mesAno) + valor;
            this.valorVendidoMes.put(mesAno, valorNovo);
        }
        else {
            this.valorVendidoMes.put(mesAno, valor);
        }
        this.atualizarValorVendidoAno(Integer.toString(data.getYear()));
    }

    public void atualizarValorVendidoAno(String ano) {
        Double total = 0.0;

        for (Map.Entry<String, Double> entrada : this.valorVendidoMes.entrySet()) {
            if (entrada.getKey().endsWith(ano)) {
                total += entrada.getValue();
            }
        }
        this.valorVendidoAno.put(ano, total);
    }

    public Double getValorVendidoMes(String mesAno) {
        return this.valorVendidoMes.getOrDefault(mesAno, 0.0);
    }

    public Double getValorVendidoAno(String ano) {
        return this.valorVendidoAno.getOrDefault(ano, 0.0);
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public void inserirFuncionario() {
        super.inserirFuncionario();
        this.atualizarGerente();
    }

    @Override
    public boolean excluirFuncionario(int id) {
        boolean removido = super.excluirFuncionario(id);
        if (removido) this.atualizarGerente();
        return removido;
    }

    public void exibirInfoLoja() {
        System.out.println("Loja " + this.getNomeFantasia() + " | Razão social: " + this.getRazaoSocial());
        System.out.println("CNPJ: " + this.getCnpj() + " | Data de criação: " + this.getDataCriacao());
        System.out.println("Proprietário: " + this.getProprietario());
        Endereco e = this.getEndereco();
        System.out.println("Endereço: " + e.getRua() + ", " + e.getNumero() + " - " + e.getCidade() + ", " + e.getEstado());
    }
}
