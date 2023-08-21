public class ContaEspecial extends ContaBancaria {
    private float limite;

    public ContaEspecial() {
        this(0.0f);
    }

    public ContaEspecial(float limiteArg) {
        super("\0", 0, 0.0f);
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
    public String toString() {
        return super.toString() + " | Limite: R$" + limite;
    }
}
