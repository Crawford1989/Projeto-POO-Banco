package projeto.poo.banco;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    protected int id;
    protected String nomeCliente;
    protected String doc;
    protected String end;
    protected String tipo;

    public Cliente(int id, String nomeCliente, String doc, String end) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.doc = doc;
        this.end = end;
        this.tipo = ClienteDAO.tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{"
                + "id do cliente =" + id
                + ", Nome do Cliente ='" + nomeCliente + '\''
                + ", Número do documento ='" + doc + '\''
                + ", Endereço ='" + end + '\''
                + ", Tipo ='" + tipo + '\''
                + '}';
    }

    public String clienteNome() {
        return this.id + " " + this.nomeCliente;
    }

    public void atualizaAll(String nomeCliente, String doc, String end) {
        this.nomeCliente = nomeCliente;
        this.doc = doc;
        this.end = end;
        this.tipo = ClienteDAO.tipoCliente;
    }
}
