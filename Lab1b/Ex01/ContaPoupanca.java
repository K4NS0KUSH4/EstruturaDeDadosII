public class ContaPoupanca extends ContaBancaria {
    private int diaDeVencimento;

    public ContaPoupanca() {
        this(0);
    }

    public ContaPoupanca(int diaDeVencimentoArg) {
        super("\0", 0, 0.0f);
        this.diaDeVencimento = diaDeVencimentoArg;
    }

    public ContaPoupanca(String clienteArg, int nroContaArg, float saldoArg, int diaDeVencimentoArg) {
        super(clienteArg, nroContaArg, saldoArg);
        this.diaDeVencimento = diaDeVencimentoArg;
    }

    public int getDiaDeVencimento() {
        return diaDeVencimento;
    }

    public void setDiaDeVencimento(int diaDeVencimentoArg) {
        this.diaDeVencimento = diaDeVencimentoArg;
    }

    @Override
    public String toString() {
        return super.toString() + " | Dia de Vencimento: " + diaDeVencimento;
    }
}
