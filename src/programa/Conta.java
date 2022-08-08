package programa;

import utilitarios.Utils;

public class Conta {
    // Vars
    private static int contadorDeContas = 1;
    private int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;
    // Constructor
    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas += 1;
    }
    //getters and setters
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    // method to convert Values to a text in String format
    public String toString(){
        return  "\nNúmero da conta: " + this.getNumeroConta() +
                "\nNome: " + this.pessoa.getNome() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nEmail" + this.pessoa.getEmail() +
                "\nSaldo " + Utils.doubleToString(this.getSaldo())+
                "\n";
    }
    // method to deposit some valor in the account
    public void depositar(Double valor) {
        if(valor > 0){
            setSaldo(getSaldo() += valor);
            System.out.println("Depósito realizado com sucesso!");
        }
        else{
            System.out.println("Não foi possivel realizar o depósito! insira um valor maior que \"0\"");
        }
    }
    // method to withdraw some value from the account
    public void sacar(Double valor){
        if(valor > 0 && valor <= this.getSaldo() ){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        }
        else{
            System.out.println("Não foi possivel realizar o Saque, verifique se o valor informado é" +
                    " maior ou igual ao disopnivel em conta");
        }
    }
    // method to transfer from one account to another
    public void transferir(Conta contaParaDeposito, Double valor){ // This block of code removes the valor from
        if (valor > 0 && this.getSaldo() >= valor) {               // the donating account
            setSaldo(getSaldo() - valor);

            contaParaDeposito.saldo  = contaParaDeposito.getSaldo() + valor;  //This block deposits the value on the
            System.out.println("Transferência efetuada com sucesso!"); //other account
        }else {
            System.out.println("Não foi possivel realizar a transferência");
        }

    }
}
