public class Main {
    public static void main(String[] args) {
        Cliente alex = new Cliente();
        alex.setNome("Alex");

        ContaCorrente cc = new ContaCorrente(alex);
        ContaPoupanca poupanca = new ContaPoupanca(alex);

        cc.depositar(100);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        if (poupanca.checarMesDiferente())
            poupanca.atualizarSaldoComRendimento();
    }
}
