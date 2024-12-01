package produto;

public class Produto {
    private int id;         // Identificador único do produto
    private String nome;    // Nome do produto
    private double preco;   // Preço do produto
    private int quantidade; // Quantidade do produto no estoque

    // Construtor
    public Produto(int id, String nome, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método toString para facilitar a exibição do produto
    @Override
    public String toString() {
        return "Produto {" +
               "ID=" + id +
               ", Nome='" + nome + '\'' +
               ", Preço=R$" + preco +
               ", Quantidade=" + quantidade +
               '}';
    }
}
