public class Usuario {

    private final long cpf;
    private String nome;
    private String endereco;

    public Usuario(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = "Endereço Não Informado";
    }

    public long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
