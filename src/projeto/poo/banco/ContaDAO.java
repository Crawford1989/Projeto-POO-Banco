package projeto.poo.banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContaDAO {

    protected static List<Conta> contList = new ArrayList<>();

    public static void criarConta() {
        System.out.println("Informe o número da conta: ");
        int numConta = Utils.inputInt();
        System.out.println("Informe o saldo em conta: ");
        double saldo = Utils.inputDouble();
        System.out.println("Informe o id do cliente dessa conta: ");
        int idCliente = Utils.inputInt();
        Optional<Cliente> clienteOpt = ClienteDAO.clienteList.stream().filter(a -> a.id == idCliente).findFirst();
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            Conta conta = new Conta(numConta, saldo, cliente);
            contList.add(conta);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public static void sacar() {
        System.out.println("De qual cliente deseja sacar: ");
        for (Conta conta : contList) {
            System.out.println("Cliente: " + conta.cliente.nomeCliente + " Número da conta: " + conta.numConta);
        }
        System.out.println("Informe o número da conta: ");
        int numConta = Utils.inputInt();
        System.out.println("Valor a ser sacado: ");
        double valor = Utils.inputDouble(); 
        for (Conta conta : contList) {
            if (conta.numConta == numConta) {
                if (conta.saldo >= valor) {
                    conta.saldo -= valor;
                    System.out.println("Saque realizado com sucesso. Saldo atual:  " + conta.saldo);
                } else {
                    System.out.println("Saldo insuficiente para realizar saque!");
                }
            } else {
                System.out.println("Conta não encontrada!");
            }
        }

    }

    public static void depositar() {
        System.out.println("Para qual cliente você quer depoisitar: ");
        for (Conta conta : contList) {
            System.out.println("Cliente: " + conta.cliente.nomeCliente + " Número da conta: " + conta.numConta);
        }
        System.out.println("Informe o número da conta: ");
        int numConta = Utils.inputInt();
        System.out.println("Valor a ser depositado: ");
        double valor = Utils.inputDouble();
        for (Conta conta : contList) {
            if (conta.numConta == numConta) {
                conta.saldo += valor;
                System.out.println("Deposito realizado com sucesso. Saldo atual:  " + conta.saldo);

            } else {
                System.out.println("Conta não encontrada!");
            }
        }
    }

    public static void mostrarSaldo() {
        System.out.println("De qual cliente quer ver o saldo: ");
        for (Conta conta : contList) {
            System.out.println("Cliente: " + conta.cliente.nomeCliente + " Número da conta: " + conta.numConta);
        }
        System.out.println("Informe o número da conta: ");
        int numConta = Utils.inputInt();
        for (Conta conta : contList) {
            if (conta.numConta == numConta) {
                System.out.println("O cliente " + conta.cliente.nomeCliente + "tem o saldo de: " + conta.saldo);
            } else {
                System.out.println("Cliente não foi encontrado!");
            }
        }

    }

    public static void transferir() {
        System.out.println("Qual cliente fará a transferencia: ");
        for (Conta conta : contList) {
            System.out.println("Cliente: " + conta.cliente.nomeCliente + " Número da conta: " + conta.numConta);
        }
        System.out.println("Informe o número da conta: ");
        int numContaEnv = Utils.inputInt();
        System.out.println("Para qual cliente será transferido: ");
        int numContaRec = Utils.inputInt();
        System.out.println("Qual o valor a ser transferido: ");
        double valor = Utils.inputDouble();

        Conta contaEnv = null;
        Conta contaRec = null;

        for (Conta conta : contList) {
            if (conta.numConta == numContaEnv) {
                contaEnv = conta;
            } else if (conta.numConta == numContaRec) {
                contaRec = conta;
            }
        }

        if (contaEnv == null) {
            System.out.println("Conta de origem não encontrada!");
            return;
        }

        if (contaRec == null) {
            System.out.println("Conta de destino não encontrada!");
            return;
        }

        if (contaEnv.saldo >= valor) {
            contaEnv.saldo -= valor;
            contaRec.saldo += valor;
            System.out.println("Transferência realizada com sucesso. Saldo atual da conta de origem: " + contaEnv.saldo);
        } else {
            System.out.println("Não possui saldo suficiente para a transferência!");
        }
    }

}
