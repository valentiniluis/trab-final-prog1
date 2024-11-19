package trabalho_final;
import java.util.Scanner;

public class SistemaLoja {

    public static void iniciarSistema() {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("1 - Criar uma loja inserindo os valores");
        System.out.println("2 - Usar uma loja de exemplo");
        System.out.println("3 - Sair");
        System.out.println();
        System.out.print("Selecione uma das opções acima: ");

        int opcao = sc.nextInt();
        LojaDeCalcado lojaDeCalcado;

        if (opcao == 1) {
            sc.nextLine();
            System.out.println("Insira as seguintes informações sobre a loja: ");

            System.out.print("Proprietário: ");
            String proprietario = sc.nextLine();

            System.out.print("CPNJ: ");
            String cnpj = sc.nextLine();

            System.out.print("Data de criação (formado dd/mm/aa): ");
            String dataCriacao = sc.nextLine();

            System.out.print("Nome fantasia: ");
            String nomeFantasia = sc.nextLine();

            System.out.print("Razão social: ");
            String razaoSocial = sc.nextLine();

            lojaDeCalcado = new LojaDeCalcado(proprietario, cnpj, dataCriacao, nomeFantasia, razaoSocial);
        }
        else if (opcao == 2) {
            Endereco e = new Endereco("Santa Catarina", "Chapecó", "Rua Presidente Getúlio Vargas", 0);
            lojaDeCalcado = new LojaDeCalcado("João da Silva",
                    "00.623.904/0001-73", "01/01/2020", e,
                    "João Calçados LTDA", "João Calçados");

            lojaDeCalcado.povoarListaFuncionarios(10);
            lojaDeCalcado.atualizarCargo(9, "Gerente");
        }
        else return;

        SistemaLoja.executarSistema(lojaDeCalcado, sc);
        sc.close();
    }

    public static void executarSistema(LojaDeCalcado lojaDeCalcado, Scanner sc) {
        System.out.println("Bem-vindo ao sistema da loja " + lojaDeCalcado.getNomeFantasia() + "!");

        int opcao;
        boolean opcaoValida = true;

        do {
            SistemaLoja.imprimirMenuOpcoes();
            System.out.print("Selecione uma das opções acima: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    lojaDeCalcado.inserirFuncionario();
                    System.out.println("Funcionário adicionado com sucesso.");
                    break;
                case 2:
                    lojaDeCalcado.imprimirFuncionarios();
                    break;
                case 3:
                    System.out.print("ID do funcionário: ");
                    if (lojaDeCalcado.excluirFuncionario(sc.nextInt())) {
                        System.out.println("Funcionário excluído com sucesso.");
                    }
                    else System.out.println("Funcionário não encontrado.");
                    break;
                case 4:
                    System.out.print("ID do funcionário: ");
                    int id = sc.nextInt();
                    System.out.print("Novo cargo: ");
                    sc.nextLine();
                    if (lojaDeCalcado.atualizarCargo(id, sc.nextLine())) {
                        System.out.println("Cargo atualizado com sucesso.");
                    }
                    else System.out.println("Funcionário não encontrado.");
                    break;
                case 5:
                    System.out.print("Valor da venda: ");
                    lojaDeCalcado.cadastrarVenda(sc.nextDouble());
                    System.out.println("Venda cadastrada com sucesso.");
                    break;
                case 6:
                    System.out.print("Insira o mês (formato mm/aa): ");
                    String mesAno = sc.nextLine();
                    double valorMes = lojaDeCalcado.getValorVendidoMes(mesAno);
                    if (valorMes == 0) System.out.println("Nenhuma venda efetuada no mês solicitado.");
                    else System.out.println("Valor vendido no mês " + mesAno + ": R$" + valorMes);
                    break;
                case 7:
                    System.out.print("Insira o ano: ");
                    String ano = sc.nextLine();
                    double valorAno = lojaDeCalcado.getValorVendidoAno(ano);
                    if (valorAno == 0) System.out.println("Nenhuma venda efetuada no ano solicitado.");
                    else System.out.println("Valor vendido no ano " + ano + ": R$" + valorAno);
                    break;
                case 8:
                    System.out.println("O valor da folha salarial é de R$" + lojaDeCalcado.calcularFolhaSalarial());
                    break;
                case 9:
                    Funcionario gerente = lojaDeCalcado.getGerente();
                    if (gerente == null) System.out.println("Gerente não foi definido.");
                    else System.out.println("\nID: " + gerente.getId() + " | Nome: " + gerente.getNome() + " | Idade: "
                            + gerente.getIdade() + " anos | Salário: R$" + gerente.getSalario() + " | Cargo: " + gerente.getCargo());
                    break;
                case 10:
                    lojaDeCalcado.exibirInfoLoja();
                    break;
                default:
                    opcaoValida = false;
            }

        } while (opcaoValida);
    }


    public static void imprimirMenuOpcoes() {
        System.out.println();
        System.out.println("1 - Adicionar funcionário");
        System.out.println("2 - Imprimir funcionários");
        System.out.println("3 - Excluir funcionário");
        System.out.println("4 - Atualizar cargo");
        System.out.println("5 - Cadastrar venda");
        System.out.println("6 - Mostrar total vendido no mês");
        System.out.println("7 - Mostrar total vendido no ano");
        System.out.println("8 - Exibir valor da folha salarial");
        System.out.println("9 - Ver gerente");
        System.out.println("10 - Exibir informações da loja");
        System.out.println("11 - Sair");
        System.out.println();
    }
}
