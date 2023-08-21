public class Contas {
    public static void main(String[] args) {
        // Item A
        ContaBancaria contaSeuMadruga = new ContaBancaria("Seu Madrugada", 72, 200.0f);
        ContaPoupanca contaDonaClotilde = new ContaPoupanca("Dona Clotilde", 71, 1000.0f, 13);
        ContaEspecial contaDonaFlorinda = new ContaEspecial("Dona Florinda", 14, 2000.0f, 499.99f);

        // Item B
        System.out.println("|--- Sacando R$250,00 da conta de " + contaSeuMadruga.getCliente() + "---|");
        contaSeuMadruga.sacar(250.00f);
        System.out.println("\n|--- Sacando R$750,00 da conta de " + contaDonaClotilde.getCliente() + "---|");
        contaDonaClotilde.sacar(750.00f);
        System.out.println("\n|--- Sacando R$2200,99 da conta de " + contaDonaFlorinda.getCliente() + "---|" );
        contaDonaFlorinda.sacar(2200.99f);

        // Item C
        System.out.println("\n|--- Depositando R$1000,00 na conta de " + contaSeuMadruga.getCliente() + "---|");
        contaSeuMadruga.depositar(1000.00f);
        System.out.println("\n|--- Depositando R$750,00 na conta de " + contaDonaClotilde.getCliente() + "---|");
        contaDonaClotilde.depositar(750.00f);
        System.out.println("\n|--- Depositando R$500,00 na conta de " + contaDonaFlorinda.getCliente() + "---|");
        contaDonaFlorinda.depositar(500.00f);

        // Item D 
        System.out.println("\n|--- Saldo de " + contaDonaClotilde.getCliente() + "; Rendimento: 0,80% ---|");
        contaDonaClotilde.calcularNovoSaldo(0.80f);

        // Item E
        ContaBancaria[] arrayContas = {contaSeuMadruga, contaDonaClotilde, contaDonaFlorinda};
        System.out.println("\nInformações das contas registradas:");
        for(int i = 0; i < arrayContas.length; i++) {
            System.out.println(arrayContas[i]);
        }
    }
}