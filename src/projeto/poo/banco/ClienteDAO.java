package projeto.poo.banco;

import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDAO {

    protected static int id = 0;
    protected static String tipoCliente;
    protected static List<Cliente> clienteList = new ArrayList<>();

    public static void cadastrarCliente() {
        int idCliente = ++id;
        System.out.println("informe o tipo de cliente a ser cadastrado PF ou PJ: ");
        tipoCliente = Utils.inputString();
        Cliente cliente = null;
        if (tipoCliente.equalsIgnoreCase("pf")) {
            System.out.println("Informe o nome do cliente: ");
            String nomeCliente = Utils.inputString();
            System.out.println("Informe o cpf do cliente: ");
            String doc = Utils.inputString();
            System.out.println("Informe o endereço: ");
            String end = Utils.inputString();
            cliente = new Cliente(idCliente, nomeCliente, doc, end);

        } else if (tipoCliente.equalsIgnoreCase("pj")) {
            System.out.println("Informe o nome fantasia da empresa: ");
            String nomeCliente = Utils.inputString();
            System.out.println("Informe o CNPJ da empresa: ");
            String doc = Utils.inputString();
            System.out.println("Informe o endereço: ");
            String end = Utils.inputString();
            cliente = new Cliente(idCliente, nomeCliente, doc, end);
        } else {
            System.out.println("Digite um tipo de documento valido. (PF ou PJ) ");
        }
        if (cliente != null) {
            clienteList.add(cliente);
        }
    }

    public static void consultaCliente() {
        for (Cliente cliente : clienteList) {
            System.out.println(cliente.toString());
            System.out.println("--------------");
        }
    }

    public static void removeCliente() {
        System.out.println("Escolha um cliente para remover: ");
        for (Cliente cliente : clienteList) {
            System.out.println(cliente.clienteNome());
        }
        System.out.println("Opção: ");
        int idCliente = Utils.inputInt();
        Optional<Cliente> cliente = clienteList.stream().filter(a -> a.id == idCliente).findFirst();
        if (cliente.isEmpty()) {
            System.out.println("Cliente não foi encontrado ");
        } else {
            clienteList.remove(cliente.get());
            System.out.println("Cliente foi removido");
        }
    }

    public static void atualizaDadosCliente() {
        System.out.println("Escolha o cliente que deseja alterar: ");
        for (Cliente cliente : clienteList) {
            System.out.println(cliente.clienteNome());
        }
        System.out.println("Opção: ");
        int idCliente = Utils.inputInt();
        Optional<Cliente> clienteOptional = clienteList.stream().filter(a -> a.id == idCliente).findFirst();
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            System.out.println("informe o tipo de cliente a ser cadastrado PF ou PJ: ");
            tipoCliente = Utils.inputString();
            if (tipoCliente.equalsIgnoreCase("pf")) {
                System.out.println("Informe o nome do cliente: ");
                String nomeCliente = Utils.inputString();
                System.out.println("Informe o cpf do cliente: ");
                String doc = Utils.inputString();
                System.out.println("Informe o endereço: ");
                String end = Utils.inputString();
                cliente.atualizaAll(nomeCliente, doc, end);
            } else if (tipoCliente.equalsIgnoreCase("pj")) {
                System.out.println("Informe o nome fantasia da empresa: ");
                String nomeCliente = Utils.inputString();
                System.out.println("Informe o CNPJ da empresa: ");
                String doc = Utils.inputString();
                System.out.println("Informe o endereço: ");
                String end = Utils.inputString();
                cliente.atualizaAll(nomeCliente, doc, end);
            } else {
                System.out.println("Digite um tipo de documento valido. (PF ou PJ) ");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

}
