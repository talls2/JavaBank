package programa;

public class Pessoa {
    // Vars
    private static int counter = 1;
    private String nome;
    private String cpf;
    private String email;

    public Pessoa(String nome, String cpf, String email) { //constructor
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        counter += 1; // auto incrementa o counter toda vez que uma nova "Pessoa" é criada
    }
    // getters and setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() { // converte os dados em String
        return "\nNome: " + this.getNome() +
                "\nCPF: " + this.getCpf() +
                "\nEmail: " + this.getEmail();
    }


}
