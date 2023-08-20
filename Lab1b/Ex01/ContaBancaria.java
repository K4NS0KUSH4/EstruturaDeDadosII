public class ContaBancaria {
    private String cliente;
    private int nroConta;
    private float saldo;

    public ContaBancaria() {
        this("\0", 0, 0.0f);
    }

    public ContaBancaria(String clienteArg, int nroContaArg, float saldoArg) {
        this.cliente = clienteArg;
        this.nroConta = nroContaArg;
        this.saldo = saldoArg;
    }

    public void sacar(float valor) {
        if(saldo < 0) {
            System.out.println("Saldo negativo. Não é possível realizar a operação.");
        }
    }

    public void depositar(float valor) {

    }
}
