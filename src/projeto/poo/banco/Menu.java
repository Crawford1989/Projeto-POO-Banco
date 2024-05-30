package projeto.poo.banco;

import jdk.jshell.execution.Util;

public class Menu {

    public static void GerenciaMenu() {
        int opcao;
        do {
            ImprimeMenu();
            System.out.println("Informe um opção: ");
            opcao = Utils.inputInt();
            SelecionaMenu(opcao);

        } while (opcao != 3);
    }

    private static void ImprimeMenu() {
        System.out.println("Menu:");
        System.out.println("=======================");
        System.out.println("1-Gerenciar CLIENTES");
        System.out.println("2-Gerenciar CONTAS");
        System.out.println("3- SAIR");
        System.out.println("=======================");
    }

    private static void SelecionaMenu(int opcao) {
        switch (opcao) {
            case 1:
                GerenciaSubMenuCliente();
                break;
            case 2:
                GerenciaSubMenuConta();
                break;
            case 3:
                finalizar();
                break;
        }
    }

    private static void Sair() {
        Menu.GerenciaMenu();
    }

    private static void finalizar() {
        System.out.println("Até a proxima, Obrigado!");
        System.exit(0);
    }

    private static void GerenciaSubMenuCliente() {
        int opcao;
        do {
            ImprimeSubMenuCliente();
            System.out.println("Informe um opção: ");
            opcao = Utils.inputInt();
            SelecionaSubMenuCliente(opcao);
        } while (opcao != 5);

    }

    private static void GerenciaSubMenuConta() {
        int opcao;
        do {
            ImprimeSubMenuConta();
            System.out.println("Informe um opção: ");
            opcao = Utils.inputInt();
            SelecionaSubMenuConta(opcao);
        } while (opcao != 6);
    }

    private static void ImprimeSubMenuCliente() {
        System.out.println("Menu:");
        System.out.println("=======================");
        System.out.println("1-Cadastrar CLIENTE");
        System.out.println("2-Consultar CLIENTE");
        System.out.println("3- Remover CLIENTE");
        System.out.println("4- Atualizar CLIENTE");
        System.out.println("5- Voltar ao MENU INICIAL");
        System.out.println("=======================");
    }

    private static void ImprimeSubMenuConta() {
        System.out.println("Menu:");
        System.out.println("=======================");
        System.out.println("1-Criar CONTA para um CLIENTE");
        System.out.println("2-Sacar dinheiro de uma CONTA de um CLIENTE");
        System.out.println("3-Depositar dinheiro para uma CONTA de um CLIENTE");
        System.out.println("4-Verificar saldo de uma CONTA de um CLIENTE");
        System.out.println("5-Transferir dinheiro de uma CONTA de um CLIENTE para outro CLIENTE");
        System.out.println("6-Voltar ao MENU INICIAL");
        System.out.println("=======================");
    }

    private static void SelecionaSubMenuCliente(int opcao) {
        switch (opcao) {
            case 1:
                ClienteDAO.cadastrarCliente();
                break;
            case 2:
                ClienteDAO.consultaCliente();
                break;
            case 3:
                ClienteDAO.removeCliente();
                break;
            case 4:
                ClienteDAO.atualizaDadosCliente();
                break;
            case 5:
                Sair();
                break;
        }
    }

    private static void SelecionaSubMenuConta(int opcao) {
        switch (opcao) {
            case 1:
                ContaDAO.criarConta();
                break;
            case 2:
                ContaDAO.sacar();
                break;
            case 3:
                ContaDAO.depositar();
                break;
            case 4:
                ContaDAO.mostrarSaldo();
                break;
            case 5:
                ContaDAO.transferir();
                break;
            case 6:
                Sair();
                break;
        }
    }

}
