public class ContaBancaria {
    private String cliente;
    private int nroConta;
    private float saldo;

    public ContaBancaria() {
        this("\0", 0, 0.00f);
    }

    public ContaBancaria(String clienteArg, int nroContaArg, float saldoArg) {
        this.cliente = clienteArg;
        this.nroConta = nroContaArg;
        this.saldo = saldoArg;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String clienteArg) {
        cliente = clienteArg;
    }

    public int getNroConta() {
        return nroConta;
    }

    public void setNroConta(int nroContaArg) {
        nroConta = nroContaArg;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldoArg) {
        saldo = saldoArg;
    }

    public void sacar(float valor) {
        if(saldo < 0) {
            System.out.println("Não é possível realizar a operação.\nO saldo atual da conta é negativo.");
        } else {
            if(saldo - valor < 0) {
                System.out.println("Não é possível realizar a operação.\nO saldo da conta após a operação é negativo.");
            } else {
                saldo -= valor;
                System.out.println("Foram sacados R$" + valor + ".\nSaldo atual: R$" + saldo);
            }
        }
    }

    public void depositar(float valor) {
        saldo += valor;
        System.out.println("Foram depositados R$" + valor + ".\nSaldo atual: R$" + saldo);
    }

    @Override
    public String toString() {
        return "Nome: " + cliente + " | Número: " + nroConta +
        " | Saldo: R$" + saldo;
    }
}
