public class ContaEspecial extends ContaBancaria {
    private float limite;

    public ContaEspecial() {
        this(0.00f);
    }

    public ContaEspecial(float limiteArg) {
        super("\0", 0, 0.00f);
        this.limite = limiteArg;
    }

    public ContaEspecial(String clienteArg, int nroContaArg, float saldoArg, float limiteArg) {
        super(clienteArg, nroContaArg, saldoArg);
        this.limite = limiteArg;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limiteArg) {
        this.limite = limiteArg;
    }

    @Override
    public void sacar(float valor) {
        if(valor > super.getSaldo() + limite) {
            System.out.println("Não é possível realizar a operação.\nO saldo limite é insuficiente.");
        } else {
            limite = super.getSaldo() + limite - valor;
            super.setSaldo(0);
            System.out.println("Foram sacados R$" + valor + ".\nSaldo atual: R$" + super.getSaldo());
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Limite: R$" + limite;
    }
}
