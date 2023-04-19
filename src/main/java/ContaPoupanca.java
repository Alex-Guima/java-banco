import java.util.Calendar;

public class ContaPoupanca extends Conta {
    public int mesAtual = Calendar.APRIL;
    protected double saldoAnterior;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }

    @Override
    public void depositar(double valor) {
        if (checarMesDiferente()) {
            setSaldoAnterior(saldo);
            setMesAtual();
        }
        saldo += valor;
    }

    public void setSaldoAnterior(double saldo) {
        if (checarMesDiferente())
            this.saldoAnterior = saldo;
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }


    public int getMesAtual() {
        return mesAtual;
    }

    public void setMesAtual() {
        if (checarMesDiferente())
            this.mesAtual = Calendar.MONTH;
    }

    public boolean checarMesDiferente() {
        return getMesAtual() != Calendar.MONTH;
    }

    public double calcularDiferencaSaldos(double saldo, double saldoAnterior) {
        return saldo - saldoAnterior;
    }

    public double calcularRedimento(double diferencaSaldos) {
        double rendimento = 0;

        return rendimento + diferencaSaldos * 0.74;
    }


    public void atualizarSaldoComRendimento() {
            double rendimento = calcularRedimento(calcularDiferencaSaldos(getSaldo(),
                    getSaldoAnterior()));

            super.depositar(rendimento);
    }
}