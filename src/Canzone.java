public class Canzone {
    private String nome;


    public Canzone(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Canzone{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
