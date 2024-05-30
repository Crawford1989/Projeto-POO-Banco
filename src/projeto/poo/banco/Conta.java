package projeto.poo.banco;

public class Conta {

    protected int numConta;
    protected double saldo;
    protected Cliente cliente;

    public Conta(int numConta, double saldo, Cliente cliente) {
        this.numConta = numConta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

}
