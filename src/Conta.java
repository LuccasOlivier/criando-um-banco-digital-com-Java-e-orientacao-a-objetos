public abstract class Conta implements ContaInterface {

    //Atributos
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;


    //Construtor
    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    //Métodos getter
    public int getAgencia(){
        return agencia;
    }

    public int getNumero(){
        return numero;
    }

    public double getSaldo(){
        return saldo;
    }

    //Métodos da interface (ContaInterface)
    @Override
    public void sacar(double valor) {
        this.saldo = saldo - valor;
    }

    @Override
    public void depositar(double valor) {
       this.saldo = saldo + valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
       this.sacar(valor);
       contaDestino.depositar(valor);
    }
    
    protected void imprimirInfoComuns(){
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
